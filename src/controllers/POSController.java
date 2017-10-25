/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.Main.stage;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import libs.FormatNumber;
import models.Context;
import models.POS_Model;
import models.POS_Table_Model;

/**
 * FXML Controller class
 *
 * @author Colonnello
 */
public class POSController extends POS_Model implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnCustomer;

    @FXML
    private Button btnEmpty;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnListItem;

    @FXML
    private Button btnPay;

    @FXML
    private Button btnGenerateSales;

    //--------------------------------------------------------------------------
    @FXML
    private TextField txtProductCode;

    @FXML
    public TextField txtStoreName;

    @FXML
    public TextField txtStoreAddress;

    @FXML
    public TextField txtContact;

    //--------------------------------------------------------------------------
    @FXML
    private TableView<POS_Table_Model> tblPOS;

    @FXML
    private TableColumn<POS_Table_Model, Integer> tbcProductCode;

    @FXML
    private TableColumn<POS_Table_Model, String> tbcProductName;

    @FXML
    private TableColumn<POS_Table_Model, Double> tbcPrice;

    @FXML
    private TableColumn<POS_Table_Model, String> tbcQty;

    @FXML
    private TableColumn<POS_Table_Model, Double> tbcDiscount;

    @FXML
    private TableColumn<POS_Table_Model, Double> tbcExtPrice;

    //--------------------------------------------------------------------------
    @FXML
    private Label lblSubTotal;

    @FXML
    private Label lblTotal;

    @FXML
    private Label lblNav;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblDate;

    @FXML
    public Label lblAccountName;
    //--------------------------------------------------------------------------
    private int quantity_holder = 0;

    private double subTotal;

    public int branch_id;

    private int ref_id;

    private int error_handler_branch = 0;

    private double total_product = 0;

    private ArrayList<String> load_product_id = new ArrayList<>();

    //--------------------------------------------------------------------------
    static Stage modal;
    @FXML
    private AnchorPane POSPane;
    //--------------------------------------------------------------------------
    final ObservableList<POS_Table_Model> data = FXCollections.observableArrayList();
    private final ArrayList<String> product_code = new ArrayList<>();

    SimpleDateFormat d
            = new SimpleDateFormat("EEEE dd MMMM yyyy");

    private final FormatNumber formatNumber = new FormatNumber();
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    DateFormat time = new SimpleDateFormat("h:mm a");
    Date date = new Date();

    class DashboardFrameData {

        public DashboardFrameData() {
            dashboard();
        }

        // the digital clock updates once a second.
        private void dashboard() {

            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(0),
                            new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            Calendar time = Calendar.getInstance();

                            String hourString = POSUtilies.pad(2, ' ', time.get(Calendar.HOUR) == 0 ? "12" : time.get(Calendar.HOUR) + "");
                            String minuteString = POSUtilies.pad(2, '0', time.get(Calendar.MINUTE) + "");
                            String secondString = POSUtilies.pad(2, '0', time.get(Calendar.SECOND) + "");
                            String am_pm = POSUtilies.pad(2, '0', time.get(Calendar.AM_PM) + "");
                            if (am_pm.equalsIgnoreCase("00")) {
                                am_pm = "AM";

                            }
                            if (am_pm.equalsIgnoreCase("01")) {
                                am_pm = "PM";

                            }

                            lblTime.setText(hourString + ":" + minuteString + ":" + secondString + " " + am_pm);
                            lblDate.setText(d.format(date));
                        }
                    }
                    ),
                    new KeyFrame(Duration.seconds(1))
            );
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lblNav.setText("POS / ");

        tbcProductCode.setCellValueFactory(new PropertyValueFactory<>("ProductCode"));
        tbcProductName.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        tbcPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        tbcQty.setCellValueFactory(new PropertyValueFactory<>("Qty"));
        tbcDiscount.setCellValueFactory(new PropertyValueFactory<>("Discout"));
        tbcExtPrice.setCellValueFactory(new PropertyValueFactory<>("ExtPrice"));
        tblPOS.setItems(data);

        btnCustomer.setText("Customer\n"
                + "     (F1)");
        btnEmpty.setText("Empty\n"
                + "Basket (F2)\n");
        btnDelete.setText("Remove\n"
                + "Item (DEL)");
        btnListItem.setText("Item list  \n"
                + "    (F3)");

        String result[][] = get_product();
        if (result.length > 0) {
            for (String res[] : result) {
                load_product_id.add(res[0]);
            }

        }

        DashboardFrameData dash = new DashboardFrameData();
        dash.dashboard();

    }

    public void tabulate_data_direct() throws IOException {
        if (load_product_id.indexOf(txtProductCode.getText()) >= 0) {
            String[][] result = POS(txtProductCode.getText(), "" + branch_id);
            Context.getInstance().branch_name().setLoadCenter(result[0][1]);
            String res[] = Loda_ModalController.Load_Central("/views/Loda_Modal.fxml", result[0][1], 400, 250);
            if (res[0].equals("OK")) {
                POS_Table_Model entry = new POS_Table_Model(
                        txtProductCode.getText(),
                        res[4],
                        Double.parseDouble(res[3]),
                        res[2],
                        0,
                        Double.parseDouble(res[3])
                );
                data.add(entry);
                price((1 * Double.parseDouble(res[3])), "add");

            }
            txtProductCode.setText("");
            txtProductCode.requestFocus();
            quantity_holder = 0;

        } else {
            if (error_handler_branch == 0) {
                String result[][] = get_product("" + branch_id);
                if (result.length > 0) {
                    for (int i = 0; i < result.length; i++) {
                        product_code.add(result[i][0]);
                    }
                }
                error_handler_branch = 1;
            }

            //----------------------------------------------------------------------
            if (product_code.contains(txtProductCode.getText()) & quantity_holder == 0) {
                String[][] result = POS(txtProductCode.getText(), "" + branch_id);
                POS_Table_Model entry = new POS_Table_Model(
                        result[0][0],
                        result[0][1],
                        Double.parseDouble(result[0][2]),
                        "1",
                        0,
                        (Double.parseDouble(result[0][2]) * 1)
                );
                data.add(entry);

                price((Double.parseDouble(result[0][2]) * 1), "add");
                txtProductCode.setText("");
                txtProductCode.requestFocus();
                quantity_holder = 0;
            }
        }

    }

    public void pay() throws IOException {

        Date dNow = new Date();
        SimpleDateFormat ft
                = new SimpleDateFormat("M/dd/yyyy  hh:mm:ss a");
        SimpleDateFormat ft_ref
                = new SimpleDateFormat("yyyyMMdd");

        SimpleDateFormat ft_transaction
                = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        lblNav.setText("POS / Payment");
        modal = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/views/PAY.fxml"));
        AnchorPane showModal = loader.load();

        modal.setTitle("Transaction");
        modal.getIcons().add(new Image("/assets/images/17577730_1460176047339927_230815903_n.png"));
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.initStyle(StageStyle.UTILITY);

        modal.initOwner(stage);
        modal.setResizable(false);
        modal.setMinWidth(635);
        modal.setMinHeight(435);
        Scene scene = new Scene(showModal);
        modal.setScene(scene);
        PAYController controller = loader.<PAYController>getController();
        controller.lblShopInfo.setText(txtStoreName.getText() + "\n" + txtStoreAddress.getText() + "\n" + txtContact.getText() + "\n--------------------------------------------------");
        controller.lblDate.setText(ft.format(dNow));
        controller.lblAccountName.setText(lblAccountName.getText());
        double vbox_size = 375;

        if (tblPOS.getItems().size() > 0) {
            String transaction_basket = "";

            for (int i = 0; i < tblPOS.getItems().size(); i++) {
                transaction_basket += tblPOS.getItems().get(i).getProductName() + "\t" + tblPOS.getItems().get(i).getPrice() + "\tx\t" + tblPOS.getItems().get(i).getQty() + "\t\t" + tblPOS.getItems().get(i).getExtPrice() + "\n";
                controller.transaction_basket.add(tblPOS.getItems().get(i).getProductCode() + "~:~" + tblPOS.getItems().get(i).getProductName() + "~:~" + tblPOS.getItems().get(i).getPrice() + "~:~" + tblPOS.getItems().get(i).getQty() + "~:~" + tblPOS.getItems().get(i).getExtPrice());
                total_product += Double.parseDouble(tblPOS.getItems().get(i).getQty());
                controller.total_product = this.total_product;
                if (i >= 1) {
                    vbox_size += 17;
                }

            }
            controller.lblBasketTransactionList.setText(transaction_basket);
        }
        ref_id = get_pk_transactionID();
        controller.lblRefNum.setText(ft_ref.format(dNow) + ref_id);
        controller.vbList.setPrefHeight(vbox_size);

        controller.txtTotal.setText(lblTotal.getText());
        controller.lblPaySubtotal.setText(lblTotal.getText());
        controller.lblPayTotal.setText(lblTotal.getText());
        controller.branch_id = this.branch_id;
        controller.date_time_transaction = ft_transaction.format(dNow);
        controller.load_product_id = this.load_product_id;

        controller.txtAmount.requestFocus();

        modal.showAndWait();
        String handler = modal.getTitle();
        if (handler.equals("OK")) {
            tblPOS.getItems().clear();
            lblSubTotal.setText("");
            lblTotal.setText("");
            subTotal = 0;
            quantity_holder = 0;
            txtProductCode.requestFocus();
            lblNav.setText("POS / ");
        }

    }

    public void empty_basket() {
        lblNav.setText("POS / Empty Basket");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(null);
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to empty the basket?");
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle(" -fx-font-size: 15px;\n"
                + "   -fx-font-weight: bold;"
                + "   -fx-text-fill: red;");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            tblPOS.getItems().clear();
            lblSubTotal.setText("");
            lblTotal.setText("");
            subTotal = 0;
            quantity_holder = 0;
            txtProductCode.requestFocus();
            lblNav.setText("POS / ");
        } else {
            lblNav.setText("POS / ");
            txtProductCode.requestFocus();
        }
    }

    public void product_list() throws Exception {
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        lblNav.setText("POS / Product list");
        String product_id = Product_ListController.productList("/views/Product_List.fxml", "Product list (branch ID): " + branch_id, screenBounds.getWidth() - 200, screenBounds.getHeight() - 300);
        lblNav.setText("POS / ");
        if (!product_id.equals("close")) {
            txtProductCode.setText(product_id);
            txtProductCode.requestFocus();
            txtProductCode.positionCaret(txtProductCode.getText().length());
            quantity_holder = 1;
        }

    }

    public void tabulate_data_enter() throws IOException {
        if (load_product_id.indexOf(txtProductCode.accessibleHelpProperty()) >= 0) {
            String[][] result = POS(txtProductCode.getText(), "" + branch_id);
            Context.getInstance().branch_name().setLoadCenter(result[0][1]);
            String res[] = Loda_ModalController.Load_Central("/views/Loda_Modal.fxml", result[0][1], 400, 250);
            if (res[0].equals("OK")) {
                POS_Table_Model entry = new POS_Table_Model(
                        txtProductCode.getText(),
                        res[4],
                        Double.parseDouble(res[3]),
                        res[2],
                        0,
                        Double.parseDouble(res[3])
                );
                data.add(entry);
                price((1 * Double.parseDouble(res[3])), "add");

            }
            txtProductCode.setText("");
            txtProductCode.requestFocus();
            quantity_holder = 0;

        } else {
            String product_remove_space = txtProductCode.getText().replaceAll(" ", "");
            String[] product_code_splited = product_remove_space.split("\\*");
            if (product_code.contains(product_code_splited[0]) & quantity_holder == 1) {
                String[][] result = POS(product_code_splited[0], "" + branch_id);
                POS_Table_Model entry = new POS_Table_Model(
                        result[0][0],
                        result[0][1],
                        Double.parseDouble(result[0][2]),
                        product_code_splited[1],
                        0,
                        (Double.parseDouble(result[0][2]) * Double.parseDouble(product_code_splited[1]))
                );
                data.add(entry);
                price((Double.parseDouble(result[0][2]) * Double.parseDouble(product_code_splited[1])), "add");
                txtProductCode.setText("");
                txtProductCode.requestFocus();
                quantity_holder = 0;
            }
        }

    }

    public void clear() {
        txtProductCode.setText("");
        txtProductCode.requestFocus();
    }

    public void delete() {
        int cell = tblPOS.getSelectionModel().getSelectedIndex();
        price(tblPOS.getItems().get(cell).getExtPrice(), "delete");
        txtProductCode.requestFocus();

        tblPOS.getItems().remove(cell);
    }

    public void key_event(KeyEvent event) {
        if (event.getCode() == KeyCode.SHIFT) {
            quantity_holder = 1;

        }
        if (event.getCode() == KeyCode.ENTER) {
            String product_remove_space = txtProductCode.getText().replaceAll(" ", "");
            String[] product_code_splited = product_remove_space.split("\\*");
            if (product_code.contains(product_code_splited[0]) & quantity_holder == 1) {
                String[][] result = POS(product_code_splited[0], "" + branch_id);
                POS_Table_Model entry = new POS_Table_Model(
                        result[0][0],
                        result[0][1],
                        Double.parseDouble(result[0][2]),
                        product_code_splited[1],
                        0,
                        (Double.parseDouble(result[0][2]) * Double.parseDouble(product_code_splited[1]))
                );
                data.add(entry);
                price((Double.parseDouble(result[0][2]) * Double.parseDouble(product_code_splited[1])), "add");
                txtProductCode.setText("");
                txtProductCode.requestFocus();
                quantity_holder = 0;
            }

        }
        if (event.getCode() == KeyCode.DELETE) {
            delete();
        }
        if (event.getCode() == KeyCode.F3) {
            try {
                product_list();
            } catch (Exception ex) {
                Logger.getLogger(POSController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (event.getCode() == KeyCode.CONTROL) {
            try {
                pay();
            } catch (IOException ex) {
                Logger.getLogger(POSController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    private void Logout() throws IOException {
        String column[] = {"login_status"};
        String values[] = {""};
        setLogout(column, values, Context.getInstance().account_name().getAccountID());
        System.exit(0);

    }

    private void price(double price, String action) {
        if (action.equals("add")) {
            subTotal += price;
            lblSubTotal.setText(formatNumber.formatNumbers("" + subTotal));
            lblTotal.setText(formatNumber.formatNumbers("" + subTotal));
        }
        if (action.equals("delete")) {
            subTotal -= price;
            lblSubTotal.setText(formatNumber.formatNumbers("" + subTotal));
            lblTotal.setText(formatNumber.formatNumbers("" + subTotal));
        }
    }

    @FXML
    private void setGenerateSales() throws IOException {
        Main.undecorated("/views/PrintPreview.fxml", "", 370, 470);
    }

    public void setUser(String account_name, String branch_name, String branch_id, String account_id, String account_type) {
        Context.getInstance().branch_id().setBranchID(branch_id);
        Context.getInstance().user_id().setAccountID(account_id);
        Context.getInstance().branch_name().setBranchName(branch_name);
        Context.getInstance().account_type().setAccountType(account_type);
        Context.getInstance().account_name().setAccountName(account_name);

    }

}

class POSUtilies {

    /**
     * Creates a string left padded to the specified width with the supplied
     * padding character.
     *
     * @param fieldWidth the length of the resultant padded string.
     * @param padChar a character to use for padding the string.
     * @param s the string to be padded.
     * @return the padded string.
     */
    public static String pad(int fieldWidth, char padChar, String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i < fieldWidth; i++) {
            sb.append(padChar);
        }
        sb.append(s);

        return sb.toString();
    }
}
