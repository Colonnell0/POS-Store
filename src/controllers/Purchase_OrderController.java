/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.Main.stage;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import libs.FormatNumber;
import models.Context;
import models.Products_Model;
import models.Purchase_Table_Model;

/**
 * FXML Controller class
 *
 * @author Colonnello
 */
public class Purchase_OrderController extends Products_Model implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Purchase_Table_Model> tblPurchaseOrder;
    
    @FXML
    private TableColumn<Purchase_Table_Model, String> tbcProductCode;
    
    @FXML
    private TableColumn<Purchase_Table_Model, String> tbcProductName;
    
    @FXML
    private TableColumn<Purchase_Table_Model, String> tbcSupplierName;
    
    @FXML
    private TableColumn<Purchase_Table_Model, Double> tbcSupplierPrice;
    
    @FXML
    private TableColumn<Purchase_Table_Model, String> tbcQtyUM;
    
    @FXML
    private TableColumn<Purchase_Table_Model, Double> tbcTotal;
    //--------------------------------------------------------------------------
    @FXML
    private ComboBox cmbBranch;
    
    @FXML
    private ComboBox cmbSupplier;
    //--------------------------------------------------------------------------
    @FXML
    private TextField txtProductCodeName;
    //--------------------------------------------------------------------------

    private String branch_All_list[][];
    
    private String supplier_All_list[][];
    
    private String supplier = "";
    
    private String branch = "";
    
    private String productNameCode = "";
    
    private Stage modal;
    
    final ObservableList<Purchase_Table_Model> data = FXCollections.observableArrayList();
    private FormatNumber fm = new FormatNumber();
    NumberFormat formatter = new DecimalFormat("#0.00");  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.tbcProductCode.setCellValueFactory(new PropertyValueFactory<>("ProductCode"));
        this.tbcProductName.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        this.tbcSupplierName.setCellValueFactory(new PropertyValueFactory<>("SupplierName"));
        this.tbcSupplierPrice.setCellValueFactory(new PropertyValueFactory<>("SupplierPrice"));
        this.tbcQtyUM.setCellValueFactory(new PropertyValueFactory<>("QtyUM"));
        this.tbcTotal.setCellValueFactory(new PropertyValueFactory<>("Total"));
        this.tblPurchaseOrder.setItems(data);
        branch = Context.getInstance().branch_id().getBranchID();
        tabulate_data();

        //----------------------------------------------------------------------
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
        tbcSupplierName.setCellFactory(tc
                -> {
            TableCell<Purchase_Table_Model, String> cell = new TableCell<Purchase_Table_Model, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : item);
                }
            };
            cell.setOnMouseClicked(e -> {
                if (!cell.isEmpty()) {
                    try {
                        setPurchaseOrder(tblPurchaseOrder.getSelectionModel().getSelectedItem().getSupplierName());
                    } catch (IOException ex) {
                        Logger.getLogger(Purchase_OrderController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            return cell;
        }
        );
    }
    
    private void tabulate_data() {
        this.tblPurchaseOrder.getItems().clear();
        String result[][] = getPurchaseOrder(branch, supplier, productNameCode);
        if (result.length > 0) {
            for (String res[] : result) {
                Purchase_Table_Model entry = new Purchase_Table_Model(
                        res[0],
                        res[1],
                        res[2],
                        Double.parseDouble(res[5]),
                        res[7],
                        Double.parseDouble(formatter.format(Double.parseDouble(res[8]))));
                data.add(entry);
            }
            
        }
    }
    
    @FXML
    private void setSupplier() {
        if (cmbSupplier.getValue().toString().equalsIgnoreCase("All")) {
            supplier = "";
        } else {
            supplier = cmbSupplier.getValue().toString();
        }
        tabulate_data();
    }
    
    @FXML
    private void setBranch() {
        
        for (String res[] : branch_All_list) {
            if (res[1].equalsIgnoreCase(cmbBranch.getValue().toString())) {
                branch = res[0];
            }
        }
        tabulate_data();
    }
    
    @FXML
    private void setProductCodeName() {
        productNameCode = txtProductCodeName.getText();
        tabulate_data();
        
    }
    
    @FXML
    private void setPurchaseOrder(String supplier) throws IOException {
        int supplier_id = 0;
        int num = 1;
        String num_count = "";
        String code_count = "";
        String name_count = "";
        String qty_count = "";
        String unitPrice_count = "";
        String total_count = "";
        double subtotal = 0;
        
        modal = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader
                .setLocation(Main.class
                        .getResource("/views/Purchase_Order_View.fxml"));
        AnchorPane showModal = loader.load();

        //  adminpane.getIcons().add(new Image("/assets/images/login_header.png"));
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.initStyle(StageStyle.UTILITY);
        
        modal.initOwner(stage);
        modal.setResizable(false);
        modal.setMinWidth(650);
        modal.setMinHeight(500);
        Scene scene = new Scene(showModal);
        modal.setScene(scene);
        Purchase_Order_ViewController controller = loader.<Purchase_Order_ViewController>getController();
        for (int i = 0; i < supplier_All_list.length; i++) {
            if (supplier_All_list[i][1].equalsIgnoreCase(supplier)) {
                supplier_id = Integer.parseInt(supplier_All_list[i][0]);
                break;
            }
        }
        String result[][] = getPurchaseOrderView(supplier_id);
        controller.lblDate.setText(LocalDate.now().toString());
        if (result.length > 0) {
            for (String res[] : result) {
                if (num <= 15) {
                    controller.lblAddress.setText(res[10]);
                    controller.lblContact.setText(res[11]);
                    controller.lblSupplierName.setText(res[2]);
                    controller.lblSupplierAddress.setText(res[3]);
                    controller.lblSupplierContact.setText(res[4]);
                    
                    num_count += num + ".\n";
                    code_count += res[0] + "\n";
                    name_count += res[1] + "\n";
                    qty_count += res[7] + "\n";
                    unitPrice_count += "" + Double.parseDouble(res[5]) + "\n";
                    total_count += "" + formatter.format(Double.parseDouble(res[8])) + "\n";
                    subtotal += Double.parseDouble(res[8]);
                    num++;
                    
                }
                controller.lblNum.setText(num_count);
                controller.lblPrCode.setText(code_count);
                controller.lblProductName.setText(name_count);
                controller.lblQTY.setText(qty_count);
                controller.lblUnitPrice.setText(unitPrice_count);
                controller.lblTotal.setText(total_count);
                controller.lblSubtotal.setText("Php " + fm.formatNumbers("" + Double.parseDouble(formatter.format(subtotal))));
            }
        }
        
        modal.showAndWait();
        
    }
    
}
