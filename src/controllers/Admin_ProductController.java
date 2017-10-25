/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.Main.stage;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import models.Product_Table_Model;
import models.Products_Model;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import models.Context;

/**
 * FXML Controller class
 *
 * @author Colonnello
 */
public class Admin_ProductController extends Products_Model implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Product_Table_Model> tblProduct;

    @FXML
    private TableColumn<Product_Table_Model, String> tbcTableHead;

    @FXML
    private TableColumn<Product_Table_Model, String> tbcProductCode;

    @FXML
    private TableColumn<Product_Table_Model, String> tbcProductName;

    @FXML
    private TableColumn<Product_Table_Model, String> tbcSupplier;

    @FXML
    private TableColumn<Product_Table_Model, Double> tbcSupplierPrice;

    @FXML
    private TableColumn<Product_Table_Model, Double> tbcSellingRetailPrice;

    @FXML
    private TableColumn<Product_Table_Model, String> tbcStocks;

    @FXML
    private TableColumn<Product_Table_Model, String> tbcSold;

    @FXML
    private TableColumn<Product_Table_Model, String> tbcInventory;

    @FXML
    private TableColumn<Product_Table_Model, String> tbcOrder;

    @FXML
    private TableColumn<Product_Table_Model, String> tbcCategory;

    @FXML
    private TableColumn<Product_Table_Model, String> tbcExpirationDate;

    @FXML
    private TableColumn<Product_Table_Model, String> tbcDate;

    @FXML
    private TableColumn<Product_Table_Model, String> tbcAccountName;

    //--------------------------------------------------------------------------
    @FXML
    private AnchorPane pane;

    //--------------------------------------------------------------------------
    @FXML
    private TextField txtProductCodeName;

    //--------------------------------------------------------------------------
    @FXML
    private ComboBox cmbBranch;

    @FXML
    private ComboBox cmbSupplier;

    @FXML
    private ComboBox cmbCategory;
    //--------------------------------------------------------------------------

    @FXML
    private DatePicker dtpDateFrom;

    @FXML
    private DatePicker dtpDateTo;

    //--------------------------------------------------------------------------
    @FXML
    private Label lblNotifactionCounter;
    //--------------------------------------------------------------------------

    private String productCodeName = "";

    private String branch_All_list[][];

    private String supplier_All_list[][];

    private String account_All_list[][];

    private String category_All_list[][];

    private String purchaseOrder[][];

    private String supplierName = "All";

    private String categoryName = "All";

    private Stage modal;

    private String from;

    private String to;

    //--------------------------------------------------------------------------
    final ObservableList<Product_Table_Model> data = FXCollections.observableArrayList();

  java.sql.Timestamp dNow = new java.sql.Timestamp(new java.util.Date().getTime());
    SimpleDateFormat ft
            = new SimpleDateFormat("MMM/dd/yyyy 'at' hh:mm:ss a");

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

                            purchaseOrder = getPurchaseOrder(Context.getInstance().branch_id().getBranchID());
                            if (purchaseOrder.length > 0) {
                                lblNotifactionCounter.setVisible(true);
                                lblNotifactionCounter.setText("" + purchaseOrder.length);
                            }
                            if (purchaseOrder.length == 0) {
                                lblNotifactionCounter.setVisible(false);
                            }

                        }
                    }
                    ),
                    new KeyFrame(Duration.seconds(60))
            );
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tbcTableHead.setCellValueFactory(new PropertyValueFactory<>("TableHead"));
        tbcProductCode.setCellValueFactory(new PropertyValueFactory<>("ProductCode"));
        tbcProductName.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        tbcSupplier.setCellValueFactory(new PropertyValueFactory<>("Supplier"));
        tbcSupplierPrice.setCellValueFactory(new PropertyValueFactory<>("SupplierPrice"));
        tbcSellingRetailPrice.setCellValueFactory(new PropertyValueFactory<>("SellingRetailPrice"));
        tbcStocks.setCellValueFactory(new PropertyValueFactory<>("Stocks"));
        tbcSold.setCellValueFactory(new PropertyValueFactory<>("Sold"));
        tbcInventory.setCellValueFactory(new PropertyValueFactory<>("Inventory"));
        tbcOrder.setCellValueFactory(new PropertyValueFactory<>("Order"));
        tbcCategory.setCellValueFactory(new PropertyValueFactory<>("Category"));
        tbcExpirationDate.setCellValueFactory(new PropertyValueFactory<>("ExpirationDate"));
        tbcDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        tbcAccountName.setCellValueFactory(new PropertyValueFactory<>("AccountName"));
        tblProduct.setItems(data);

        dtpDateFrom.setValue(LocalDate.now());
        dtpDateTo.setValue(LocalDate.now());
        from = " AND datediff(ifnull(product_history.history_date,'0000-00-00'), '" + dtpDateFrom.getValue().toString() + "') >=0 ";
        to = "  AND datediff('" + dtpDateTo.getValue().toString() + "',ifnull(product_history.history_date,'0000-00-00')) >=0 ";

        ArrayList<String> branch = new ArrayList<>();
        branch_All_list = getBranchList();
        if (branch_All_list.length
                > 0) {

            for (int i = 0; i < branch_All_list.length; i++) {
                branch.add(branch_All_list[i][1]);
            }
        }

        ObservableList<String> branch_list = FXCollections.observableArrayList(branch);
        cmbBranch.setItems(branch_list);
        cmbBranch.setValue(Context.getInstance().branch_name().getBranchName());

        //----------------------------------------------------------------------
        ArrayList<String> supplier = new ArrayList<>();
        supplier_All_list = getSupplierList();
        if (supplier_All_list.length
                > 0) {
            for (int i = 0; i < supplier_All_list.length; i++) {
                supplier.add(supplier_All_list[i][1]);
            }
        }

        supplier.add(
                "All");

        ObservableList<String> supplier_list = FXCollections.observableArrayList(supplier);

        cmbSupplier.setItems(supplier_list);

        cmbSupplier.setValue(
                "All");

        //----------------------------------------------------------------------
        ArrayList<String> category = new ArrayList<>();
        category_All_list = getCategoryList();
        if (category_All_list.length
                > 0) {
            for (int i = 0; i < category_All_list.length; i++) {
                category.add(category_All_list[i][1]);
            }
        }

        category.add(
                "All");

        ObservableList<String> category_list = FXCollections.observableArrayList(category);

        cmbCategory.setItems(category_list);

        cmbCategory.setValue(
                "All");
        //----------------------------------------------------------------------

        tabulateData();
        tbcSupplier.setCellFactory(tc
                -> {
            TableCell<Product_Table_Model, String> cell = new TableCell<Product_Table_Model, String>() {
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
                        supplierDetails(productID);

                    } catch (IOException ex) {
                        Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    tabulateData();
                }
            });
            return cell;
        }
        );
         DashboardFrameData dash = new DashboardFrameData();
        dash.dashboard();

    }

    private void tabulateData() {
        if (supplierName.equalsIgnoreCase("All") && !categoryName.equalsIgnoreCase("All")) {
            tblProduct.getItems().clear();
            tbcTableHead.setText("Inventory status on " + ft.format(dNow));
            String result[][] = get_product_listsInventoryCategory(productCodeName, getBranchList(cmbBranch.getValue().toString())[0][0], categoryName, from, to);
            if (result.length > 0) {
                for (String re[] : result) {
                    Product_Table_Model entry = new Product_Table_Model(
                            re[0],
                            re[1],
                            re[2],
                            Double.parseDouble(re[3]),
                            Double.parseDouble(re[4]),
                            re[5],
                            re[6],
                            re[7],
                            re[8],
                            re[9],
                            re[10],
                            re[11],
                            re[12]
                    );
                    data.add(entry);
                }
            }

        }
        if (categoryName.equalsIgnoreCase("All") && !supplierName.equalsIgnoreCase("All")) {
            tblProduct.getItems().clear();
            tbcTableHead.setText("Inventory status on " + ft.format(dNow));
            String result[][] = get_product_listsInventorySupplier(productCodeName, getBranchList(cmbBranch.getValue().toString())[0][0], getSupplierList(cmbSupplier.getValue().toString())[0][0], from, to);
            if (result.length > 0) {
                for (String re[] : result) {
                    Product_Table_Model entry = new Product_Table_Model(
                            re[0],
                            re[1],
                            re[2],
                            Double.parseDouble(re[3]),
                            Double.parseDouble(re[4]),
                            re[5],
                            re[6],
                            re[7],
                            re[8],
                            re[9],
                            re[10],
                            re[11],
                            re[12]
                    );
                    data.add(entry);
                }
            }

        }
        if (categoryName.equalsIgnoreCase("All") && supplierName.equalsIgnoreCase("All")) {
            tblProduct.getItems().clear();
            tbcTableHead.setText("Inventory status on " + ft.format(dNow));
            String result[][] = get_product_listsInventorySupplierCategory(productCodeName, getBranchList(cmbBranch.getValue().toString())[0][0], from, to);
            if (result.length > 0) {
                for (String re[] : result) {
                    Product_Table_Model entry = new Product_Table_Model(
                            re[0],
                            re[1],
                            re[2],
                            Double.parseDouble(re[3]),
                            Double.parseDouble(re[4]),
                            re[5],
                            re[6],
                            re[7],
                            re[8],
                            re[9],
                            re[10],
                            re[11],
                            re[12]
                    );
                    data.add(entry);
                }
            }
        }
        if (!categoryName.equalsIgnoreCase("All") && !supplierName.equalsIgnoreCase("All")) {

            tblProduct.getItems().clear();
            tbcTableHead.setText("Inventory status on " + ft.format(dNow));
            String result[][] = get_product_listsInventory(productCodeName, getBranchList(cmbBranch.getValue().toString())[0][0], getSupplierList(cmbSupplier.getValue().toString())[0][0], categoryName, from, to);
            if (result.length > 0) {
                for (String re[] : result) {
                    Product_Table_Model entry = new Product_Table_Model(
                            re[0],
                            re[1],
                            re[2],
                            Double.parseDouble(re[3]),
                            Double.parseDouble(re[4]),
                            re[5],
                            re[6],
                            re[7],
                            re[8],
                            re[9],
                            re[10],
                            re[11],
                            re[12]
                    );
                    data.add(entry);
                }
            }
        }

    }

    public void setProductCodeName() {
        productCodeName = txtProductCodeName.getText();
        tabulateData();
    }

    public void setSupplierName() {
        supplierName = cmbSupplier.getValue().toString();
        tabulateData();
    }

    public void setCategoryName() {
        categoryName = cmbCategory.getValue().toString();
        tabulateData();
    }

    @FXML
    public void setTimeFrom() throws ParseException {
        from = " AND datediff(ifnull(product_history.history_date,'0000-00-00'), '" + dtpDateFrom.getValue().toString() + "') >=0 ";
        tabulateData();

    }

    @FXML
    public void setTimeTo() throws ParseException {
        to = "  AND datediff('" + dtpDateTo.getValue().toString() + "',ifnull(product_history.history_date,'0000-00-00')) >=0 ";
        tabulateData();
    }

    @FXML
    private void purchaseOrder() throws IOException {
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        Main.modal("/views/Purchase_Order.fxml", "One Stop Shop | Purchase Order", 700, 450);
    }

    @FXML
    private void setProduct() throws IOException {

        Main.modal("/views/View_Product.fxml", "One Stop Shop | Product", 700, 400);
        tabulateData();
    }

    public void addProduct() throws IOException {
        Main.modal("/views/Add_Product.fxml", "One Stop Shop | Add Product", 700, 600);
        tabulateData();
    }

    public void supplierDetails(String supplierName) throws IOException {
        modal = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader
                .setLocation(Main.class
                        .getResource("/views/Supplier_Details.fxml"));
        AnchorPane showModal = loader.load();

        //  adminpane.getIcons().add(new Image("/assets/images/login_header.png"));
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.initStyle(StageStyle.UNDECORATED);

        modal.initOwner(stage);
        modal.setResizable(false);
        modal.setMinWidth(650);
        modal.setMinHeight(500);
        Scene scene = new Scene(showModal);
        modal.setScene(scene);
        Supplier_DetailsController controller = loader.<Supplier_DetailsController>getController();

        String result[][] = getSupplierDetails(supplierName);
        if (result.length > 0) {
            controller.txtSupplierName.setText(result[0][0]);
            controller.txtAddress.setText(result[0][1]);
            controller.txtContact.setText(result[0][2]);
            controller.txtDate.setText(result[0][3]);
            controller.supplierName = supplierName;

            controller.tabulate_data(result);
        }

        modal.showAndWait();
    }

}
