/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import libs.FormatNumber;
import models.GenerateSales_Model;
import models.Sales_History_Table_Model;
import models.Sales_Table_Model;

/**
 * FXML Controller class
 *
 * @author Colonnello
 */
public class Sales_HistoryController extends GenerateSales_Model implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Sales_Table_Model> tblSales;

    @FXML
    private TableColumn<Sales_Table_Model, String> tbcRefID;

    @FXML
    private TableColumn<Sales_Table_Model, String> tbcBranchName;

    @FXML
    private TableColumn<Sales_Table_Model, String> tbcAccountName;

    @FXML
    private TableColumn<Sales_Table_Model, Integer> tbcProductSold;

    @FXML
    private TableColumn<Sales_Table_Model, Double> tbcAmount;

    @FXML
    private TableColumn<Sales_Table_Model, String> tbcDate;

    //--------------------------------------------------------------------------
    @FXML
    private TableView<Sales_History_Table_Model> tblSalesHistory;

    @FXML
    TableColumn<Sales_History_Table_Model, String> tbcHistoryProductCode;

    @FXML
    TableColumn<Sales_History_Table_Model, String> tbcHistoryProductName;

    @FXML
    TableColumn<Sales_History_Table_Model, String> tbcHistoryProductStocks;

    @FXML
    TableColumn<Sales_History_Table_Model, String> tbcHistorySold;

    @FXML
    TableColumn<Sales_History_Table_Model, Double> tbcHistoryAmount;

    @FXML
    TableColumn<Sales_History_Table_Model, String> tbcHistoryAccountName;

    @FXML
    TableColumn<Sales_History_Table_Model, String> tbcHistoryDate;
    //--------------------------------------------------------------------------
    @FXML
    private TextField txtRefID;
    //--------------------------------------------------------------------------
    @FXML
    private ComboBox cmbBranch;

    //--------------------------------------------------------------------------
    @FXML
    private Label lblSold;

    @FXML
    private Label lblAmount;
    //--------------------------------------------------------------------------
    @FXML
    private TabPane tpPane;
    //--------------------------------------------------------------------------
    @FXML
    private DatePicker dtpDateFrom;

    @FXML
    private DatePicker dtpDateTo;

    //--------------------------------------------------------------------------
    final ObservableList<Sales_Table_Model> data = FXCollections.observableArrayList();
    final ObservableList<Sales_History_Table_Model> data_history = FXCollections.observableArrayList();

    private String branch_name;

    private String refID;

    private String from;

    private String to;

    private double totalSold;

    private double totalAmount;

    private String generatedSalesHandler = "";

    private String branch[][];

    //--------------------------------------------------------------------------
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
        generatedSalesHandler = "product_history.history_date";
        refID = "";
        dtpDateFrom.setValue(LocalDate.now());
        dtpDateTo.setValue(LocalDate.now());
        from = " AND datediff(DATE(" + generatedSalesHandler + "), '" + dtpDateFrom.getValue().toString() + "') >=0 ";
        to = "  AND datediff('" + dtpDateTo.getValue().toString() + "',DATE(" + generatedSalesHandler + ")) >=0 ";
        lblSold.setText(fm.formatNumbers("0"));
        lblAmount.setText(fm.formatNumbers("0"));
        this.tbcRefID.setCellValueFactory(new PropertyValueFactory<>("RefID"));
        this.tbcBranchName.setCellValueFactory(new PropertyValueFactory<>("BranchName"));
        this.tbcAccountName.setCellValueFactory(new PropertyValueFactory<>("AccountName"));
        this.tbcProductSold.setCellValueFactory(new PropertyValueFactory<>("ProductSold"));
        this.tbcAmount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        this.tbcDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        this.tblSales.setItems(data);

        //----------------------------------------------------------------------
        this.tbcHistoryProductCode.setCellValueFactory(new PropertyValueFactory<>("ProductCode"));
        this.tbcHistoryProductName.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        this.tbcHistoryProductStocks.setCellValueFactory(new PropertyValueFactory<>("Stocks"));
        this.tbcHistorySold.setCellValueFactory(new PropertyValueFactory<>("Sold"));
        this.tbcHistoryAmount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        this.tbcHistoryAccountName.setCellValueFactory(new PropertyValueFactory<>("AccountName"));
        this.tbcHistoryDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        this.tblSalesHistory.setItems(data_history);

        tabulate_data();

    }

    @FXML
    private void tabulate_data() {
        if (tpPane.getSelectionModel().getSelectedItem().getText().equalsIgnoreCase("Generated Sales")) {
            generatedSalesHandler = "sales.sale_date";
            from = " AND datediff(DATE(" + generatedSalesHandler + "), '" + dtpDateFrom.getValue().toString() + "') >=0 ";
            to = "  AND datediff('" + dtpDateTo.getValue().toString() + "',DATE(" + generatedSalesHandler + ")) >=0 ";

            this.tblSales.getItems().clear();
            String result[][] = getSales(refID, from, to);
            if (result.length > 0) {
                for (String res[] : result) {
                    Sales_Table_Model entry = new Sales_Table_Model(
                            res[0],
                            res[1],
                            res[2],
                            res[3],
                            Double.parseDouble(res[4]),
                            res[5]
                    );
                    data.add(entry);
                    totalSold += Double.parseDouble(res[3]);
                    totalAmount += Double.parseDouble(res[4]);

                }
                lblSold.setText(fm.formatNumbers("" + totalSold));
                lblAmount.setText(fm.formatNumbers("Php " + totalAmount));
                totalSold = 0;
                totalAmount = 0;
            }
        }
        if (tpPane.getSelectionModel().getSelectedItem().getText().equalsIgnoreCase("Sales History")) {
            generatedSalesHandler = "product_history.history_date";
            from = " AND datediff(DATE(" + generatedSalesHandler + "), '" + dtpDateFrom.getValue().toString() + "') >=0 ";
            to = "  AND datediff('" + dtpDateTo.getValue().toString() + "',DATE(" + generatedSalesHandler + ")) >=0 ";

            this.tblSalesHistory.getItems().clear();
            String result[][] = getIndividualSales(refID, from, to);
            if (result.length > 0) {
                for (String res[] : result) {
                    Sales_History_Table_Model entry = new Sales_History_Table_Model(
                            res[0],
                            res[1],
                            res[2],
                            res[3],
                            Double.parseDouble(res[4]),
                            res[5],
                            res[6]
                    );
                    data_history.add(entry);
                    totalSold += Double.parseDouble(res[3]);
                    totalAmount += Double.parseDouble(res[4]);
                }
                lblSold.setText(fm.formatNumbers("" + totalSold));
                lblAmount.setText(fm.formatNumbers("Php " + totalAmount));
                totalSold = 0;
                totalAmount = 0;
            }
        }

    }

    @FXML
    private void setBranch() {
        branch_name = cmbBranch.getValue().toString();
        tabulate_data();
    }

    @FXML
    private void setTimeFrom() throws ParseException {
        from = " AND datediff(DATE(" + generatedSalesHandler + "), '" + dtpDateFrom.getValue().toString() + "') >=0 ";
        tabulate_data();

    }

    @FXML
    private void setTimeTo() throws ParseException {
        to = "  AND datediff('" + dtpDateTo.getValue().toString() + "',DATE(" + generatedSalesHandler + ")) >=0 ";
        tabulate_data();
    }

    @FXML
    private void setID() {
        refID = txtRefID.getText();
        tabulate_data();
    }

}
