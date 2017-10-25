/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.Main.stage;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import libs.FormatNumber;
import models.Transaction_Model;
import models.Transaction_Table_Model;

/**
 * FXML Controller class
 *
 * @author Colonnello
 */
public class Transaction_HistoryController extends Transaction_Model implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Transaction_Table_Model> tblTransaction;

    @FXML
    private TableColumn<Transaction_Table_Model, String> tbcDate;

    @FXML
    private TableColumn<Transaction_Table_Model, String> tbcID;

    @FXML
    private TableColumn<Transaction_Table_Model, String> tbcType;

    @FXML
    private TableColumn<Transaction_Table_Model, Double> tbcAmount;

    @FXML
    private TableColumn<Transaction_Table_Model, String> tbcBranch;

    //--------------------------------------------------------------------------
    @FXML
    private TextField txtRefID;
    //--------------------------------------------------------------------------
    @FXML
    private ComboBox cmbBranch;

    //--------------------------------------------------------------------------
    @FXML
    private DatePicker dtpDateFrom;

    @FXML
    private DatePicker dtpDateTo;
    //--------------------------------------------------------------------------
    @FXML
    private Label lblSell;

    @FXML
    private Label lblBuy;

    //--------------------------------------------------------------------------
    final ObservableList<Transaction_Table_Model> data = FXCollections.observableArrayList();
    private Statement stmt;
    private ResultSet rs;

    private String[][] branch;

    private String branch_name;
    private String to;
    private String from;
    private String refID;
    private Stage modal;
    private double sell;
    private double buy;

    FormatNumber fm = new FormatNumber();

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        //----------------------------------------------------------------------
        ArrayList<String> b = new ArrayList<>();
        branch = getBranch();
        if (branch.length > 0) {
            for (String res[] : branch) {
                b.add(res[1]);
            }
        }

        ObservableList<String> branch_list = FXCollections.observableArrayList(b);
        cmbBranch.setItems(branch_list);
        cmbBranch.setValue(b.get(0));
        branch_name = branch[0][1];

        //----------------------------------------------------------------------
        dtpDateFrom.setValue(LocalDate.now());
        dtpDateTo.setValue(LocalDate.now());
        refID = "" + LocalDate.now().getYear();
        from = " AND datediff(ifnull(t.date,'0000-00-00'), '" + dtpDateFrom.getValue().toString() + "') >=0 ";
        to = "  AND datediff('" + dtpDateTo.getValue().toString() + "',ifnull(t.date,'0000-00-00')) >=0 ";

        //----------------------------------------------------------------------
        tbcDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        tbcID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        tbcType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        tbcAmount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        tbcBranch.setCellValueFactory(new PropertyValueFactory<>("Branch"));
        tblTransaction.setItems(data);
        tabulate_data();

        tbcID.setCellFactory(tc -> {
            TableCell<Transaction_Table_Model, String> cell = new TableCell<Transaction_Table_Model, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : item);
                }
            };
            cell.setOnMouseClicked(e -> {
                if (!cell.isEmpty()) {
                    String productID = cell.getItem();
                    try {
                        viewTransaction();
                    } catch (IOException ex) {
                        Logger.getLogger(Transaction_HistoryController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            return cell;
        });

    }

    @FXML
    private void tabulate_data() {
        tblTransaction.getItems().clear();
        buy = 0;
        sell = 0;
        db_connect();

        String select = "SELECT * FROM(\n"
                + "(SELECT DATE(product_history.history_date) as date,DATE_FORMAT(product_history.history_date,'%Y%m%d') as id,'Buy' as type,SUM(product_history.total_cost) as amount,branch.branch_name as branch FROM product_history LEFT JOIN branch ON product_history.branch_id=branch.branch_id GROUP BY id \n"
                + " )"
                + "    UNION(\n"
                + "    SELECT DATE(transaction.transaction_date) as date,transaction.transaction_id as id, 'Sell' as type,transaction.transaction_amount - transaction.transaction_change as amount,branch.branch_name as branch FROM transaction LEFT JOIN branch ON transaction.transaction_branch_id=branch.branch_id\n"
                + "    )\n"
                + ") as t  WHERE t.branch = \"" + branch_name + "\" " + to + from + "AND t.id LIKE '%" + refID + "%' ORDER BY t.date";

        System.out.println(select);
        try {
            stmt = conn.createStatement();
            stmt.execute(select);
            rs = stmt.getResultSet();
            while (rs.next()) {
                if (rs.getString("type").equals("Buy")) {
                    buy += Double.parseDouble("" + rs.getDouble("amount"));
                }
                if (rs.getString("type").equals("Sell")) {
                    sell += Double.parseDouble("" + rs.getDouble("amount"));
                }
                Transaction_Table_Model entry = new Transaction_Table_Model(
                        rs.getString("date"),
                        rs.getString("id"),
                        rs.getString("type"),
                        rs.getDouble("amount"),
                        rs.getString("branch")
                );
                data.add(entry);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        lblSell.setText("Php " + fm.formatNumbers("" + sell));
        lblBuy.setText("Php " + fm.formatNumbers("" + buy));

    }

    @FXML
    private void viewTransaction() throws IOException {
        modal = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/views/View_Transaction.fxml"));
        AnchorPane showModal = loader.load();

        //  adminpane.getIcons().add(new Image("/assets/images/login_header.png"));
        modal.initModality(Modality.WINDOW_MODAL);
        modal.initStyle(StageStyle.UTILITY);

        modal.initOwner(stage);
        modal.setResizable(false);
        modal.setMinWidth(400);
        modal.setMinHeight(600);
        Scene scene = new Scene(showModal);
        modal.setScene(scene);
        modal.setAlwaysOnTop(true);
        View_TransactionController controller = loader.<View_TransactionController>getController();
        controller.branchName.setText(tblTransaction.getSelectionModel().getSelectedItem().getBranch());
        controller.refID.setText(tblTransaction.getSelectionModel().getSelectedItem().getID());
        controller.date.setText(tblTransaction.getSelectionModel().getSelectedItem().getDate());
        controller.amount.setText("Php " + fm.formatNumbers("" + tblTransaction.getSelectionModel().getSelectedItem().getAmount()));
        controller.type.setText(tblTransaction.getSelectionModel().getSelectedItem().getType());

        if (tblTransaction.getSelectionModel().getSelectedItem().getType().equalsIgnoreCase("Buy")) {
            String result[][] = getTransactionBuy(tblTransaction.getSelectionModel().getSelectedItem().getID());
            String account_name = "";
            String text = "";
            if (result.length > 0) {
                for (String res[] : result) {
                    text += res[0] + "     " + res[1] + "   =   Php " + fm.formatNumbers(res[2]) + "  ( " + res[4] + " )\n";
                    if (!account_name.contains(res[3])) {
                        account_name += res[3] + ", ";
                    }
                }
                account_name = account_name.substring(0, account_name.length() - 1);
                controller.lblAccountName.setText(account_name);
                controller.lblTransactionBasket.setText(text);
            }
        }
        if (tblTransaction.getSelectionModel().getSelectedItem().getType().equalsIgnoreCase("Sell")) {
            String result[][] = getTransactionSell(tblTransaction.getSelectionModel().getSelectedItem().getID());
            String text = "";
            String totalPrice[] = null;
            if (result.length > 0) {
                for (String res[] : result) {
                    controller.lblAccountName.setText(res[1]);
                    String transactionBasket[] = res[0].split("\\~:~");
                    for (int i = 0; i < transactionBasket.length; i++) {

                        if (((i + 1) % 4) == 0) {
                            totalPrice = transactionBasket[i + 1].split("\\, ");
                            text += transactionBasket[i - 2] + "     " + transactionBasket[i - 1] + "  X  " + transactionBasket[i] + "  = " + totalPrice[0] + "  \n";
                        }
                    }
                }
                text = text.substring(0, text.length() - 1);
                controller.lblTransactionBasket.setText(text);
            }
        }
        modal.showAndWait();

    }

    @FXML
    private void setBranch() {
        branch_name = cmbBranch.getValue().toString();
        tabulate_data();
    }

    @FXML
    private void setTimeFrom() throws ParseException {
        from = " AND datediff(ifnull(t.date,'0000-00-00'), '" + dtpDateFrom.getValue().toString() + "') >=0 ";
        tabulate_data();

    }

    @FXML
    private void setTimeTo() throws ParseException {
        to = "  AND datediff('" + dtpDateTo.getValue().toString() + "',ifnull(t.date,'0000-00-00')) >=0 ";
        tabulate_data();
    }

    @FXML
    private void setID() {
        refID = txtRefID.getText();
        tabulate_data();
    }

}
