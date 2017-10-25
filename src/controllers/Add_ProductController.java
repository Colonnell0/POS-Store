/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Context;
import models.Products_Model;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author Colonnello
 */
public class Add_ProductController extends Products_Model implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public TextField txtProductCode;

    @FXML
    public TextField txtProductName;

    @FXML
    public TextField txtNumProducts;

    @FXML
    public TextField txtSupplierPrice;

    @FXML
    public TextField txtSellingPrice;

    @FXML
    public TextField txtSellingUnitPrice;

    @FXML
    public TextField txtQuantity;

    @FXML
    public TextField txtCategory;

    @FXML
    public TextField txtSupplier;

    @FXML
    public TextField txtTotalCost;

    //--------------------------------------------------------------------------
    @FXML
    public Button btnSubmit;
    //--------------------------------------------------------------------------
    @FXML
    public DatePicker dtpExpirationDate;

    @FXML
    public DatePicker dtpDateCreated;

    //--------------------------------------------------------------------------
    @FXML
    private Label lblProductError;
    //--------------------------------------------------------------------------
    @FXML
    private AnchorPane pane;
    //--------------------------------------------------------------------------
    private String category[][] = null;
    private String supplier[][] = null;
    private int categoryID;
    private int supplierID;
    private String date_expiration = "0000-00-00";
    private double supplier_price = 0;
    private double selling_unit_price = 0;
    private double selling_quantity = 0;
    private String product_code_handler;
    private String product_num;

    java.sql.Timestamp dNow = new java.sql.Timestamp(new java.util.Date().getTime());
    SimpleDateFormat ft
            = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    ArrayList<String> product_code = new ArrayList<>();

    public void setProductCode(KeyEvent event) {
        if (product_code.indexOf(txtProductCode.getText()) >= 0) {
            String[][] result = get_product_list(txtProductCode.getText());
            txtProductCode.setEditable(false);
            txtProductName.setEditable(false);
            if (!txtCategory.getText().isEmpty()) {
                txtCategory.setEditable(false);
            }
            txtSellingPrice.setEditable(false);
            txtSellingUnitPrice.setEditable(false);
            txtQuantity.setEditable(false);
            for (String[] re : result) {
                txtProductName.setText(re[1]);
                product_num = re[2];
                txtCategory.setText(re[3]);
                txtSupplier.setText(re[4]);
                txtSupplierPrice.setText(re[5]);
                txtSellingPrice.setText(re[6]);
                txtSellingUnitPrice.setText(re[7]);
                txtQuantity.setText(re[8]);
                product_code_handler = "OK";

            }

        } else {
            lblProductError.setText("");
        }
    }

    public void setExpirationDate() {
        date_expiration = dtpExpirationDate.getValue().toString();
    }

    public void setSupplierPrice() throws Exception {
        supplier_price = Double.parseDouble(txtSupplierPrice.getText());
    }

    public void setSellingUnitPrice() throws Exception {
        selling_unit_price = Double.parseDouble(txtSellingUnitPrice.getText());
    }

    public void setSellingQuantity() throws Exception {
        selling_quantity = Double.parseDouble(txtQuantity.getText());
    }

    public void save() throws Exception {
        if (!txtProductCode.getText().isEmpty()
                & !txtProductName.getText().isEmpty()
                & !txtNumProducts.getText().isEmpty()
                & !txtSellingPrice.getText().isEmpty()
                & !txtTotalCost.getText().isEmpty()
                & btnSubmit.getText().equals("Save")) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to add this product " + txtProductCode.getText() + " " + txtProductName.getText() + " ?");
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle(" -fx-font-size: 15px;\n"
                    + "   -fx-font-weight: bold;"
                    + "   -fx-text-fill: red;");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {

                for (int i = 0; i < category.length; i++) {
                    if (category[i][1].equalsIgnoreCase(txtCategory.getText())) {
                        categoryID = Integer.parseInt(category[i][0]);
                        break;
                    }
                }
                for (int i = 0; i < supplier.length; i++) {
                    if (supplier[i][1].equalsIgnoreCase(txtSupplier.getText())) {
                        supplierID = Integer.parseInt(supplier[i][0]);
                        break;
                    }
                }

                if (supplierID == 0 & !txtSupplier.getText().isEmpty()) {
                    String column[] = {"supplier_name", "supplier_address", "supplier_contact", "supplier_date"};
                    String values[] = {txtSupplier.getText().substring(0, 1).toUpperCase() + txtSupplier.getText().substring(1), " ", " ", dtpDateCreated.getValue().toString()};

                    add_supplier("supplier", column, values);
                }
                if (categoryID == 0 & !txtCategory.getText().isEmpty()) {
                    String column[] = {"category_name"};
                    String values[] = {txtCategory.getText().substring(0, 1).toUpperCase() + txtCategory.getText().substring(1)};

                    add_category("category", column, values);
                }

                category = get_category();
                supplier = get_supplier();

                for (int i = 0; i < category.length; i++) {
                    if (category[i][1].equalsIgnoreCase(txtCategory.getText())) {
                        categoryID = Integer.parseInt(category[i][0]);
                        break;
                    }
                }
                for (int i = 0; i < supplier.length; i++) {
                    if (supplier[i][1].equalsIgnoreCase(txtSupplier.getText())) {
                        supplierID = Integer.parseInt(supplier[i][0]);
                        break;
                    }
                }

                double num_of_products = Double.parseDouble(txtNumProducts.getText());
                double selling_price = Double.parseDouble(txtSellingPrice.getText());
                double total_cost = Double.parseDouble(txtTotalCost.getText());
                supplier_price = Double.parseDouble(txtSupplierPrice.getText());

                //--------------------------------------------------------------
                //--------------------------------------------------------------
                if (product_code_handler == null) {
                    String column[] = {"product_code", "branch_id", "product_name", "num_of_products", "category_id", "selling_unit_price", "selling_quantity", "date_created", "product_status", "supplier_id", "supplier_price", "selling_price", "expiration_date", "order_constant"};
                    String values[] = {txtProductCode.getText(), Context.getInstance().branch_id().getBranchID(), txtProductName.getText().substring(0, 1).toUpperCase() + txtProductName.getText().substring(1), "" + num_of_products, "" + categoryID, "" + selling_unit_price, "" + selling_quantity, dtpDateCreated.getValue().toString(), "Enable", "" + supplierID, "" + supplier_price, "" + selling_price, date_expiration, "0"};

                    add_product("product", column, values);

                    String column_history[] = {"product_code", "cp_number", "account_id", "branch_id", "product_stock", "total_cost", "tendered_amount", "history_date", "supplier_id", "supplier_price", "selling_price", "expiration_date", "product_sold"};
                    String values_history[] = {txtProductCode.getText(), "", Context.getInstance().account_name().getAccountID(), Context.getInstance().branch_id().getBranchID(), "" + num_of_products, "" + total_cost, "0", ft.format(dNow), "" + supplierID, "" + supplier_price, "" + selling_price, date_expiration, "0"};

                    Context.getInstance().product_history().Update_Product_History(txtProductCode.getText(), dtpDateCreated.getValue().toString(), column_history, values_history, "insert");
                    Stage stage = (Stage) pane.getScene().getWindow();

                    stage.close();

                }
                if (product_code_handler.equalsIgnoreCase("OK")) {

                    num_of_products = Double.parseDouble(txtNumProducts.getText()) + Double.parseDouble(product_num);

                    String column[] = {"product_code", "branch_id", "product_name", "num_of_products", "category_id", "selling_unit_price", "selling_quantity", "date_created", "product_status", "supplier_id", "supplier_price", "selling_price", "expiration_date"};
                    String values[] = {txtProductCode.getText(), Context.getInstance().branch_id().getBranchID(), txtProductName.getText().substring(0, 1).toUpperCase() + txtProductName.getText().substring(1), "" + num_of_products, "" + categoryID, "" + selling_unit_price, "" + selling_quantity, dtpDateCreated.getValue().toString(), "Enable", "" + supplierID, "" + supplier_price, "" + selling_price, date_expiration};

                    updateProduct(column, values, txtProductCode.getText());

                    String column_history[] = {"product_code", "account_id", "branch_id", "product_stock", "total_cost", "history_date", "supplier_id", "supplier_price", "selling_price", "expiration_date"};
                    String values_history[] = {txtProductCode.getText(), Context.getInstance().account_name().getAccountID(), Context.getInstance().branch_id().getBranchID(), "" + num_of_products, "" + total_cost, ft.format(dNow), "" + supplierID, "" + supplier_price, "" + selling_price, date_expiration};

                    Context.getInstance().product_history().Update_Product_History(txtProductCode.getText(), dtpDateCreated.getValue().toString(), column_history, values_history, "update");

                    Stage stage = (Stage) pane.getScene().getWindow();

                    stage.close();

                }

            } else {
                // ... user chose CANCEL or closed the dialog
            }

        }

        if (!txtProductCode.getText()
                .isEmpty()
                & !txtProductName.getText().isEmpty()
                & !txtNumProducts.getText().isEmpty()
                & !txtSellingPrice.getText().isEmpty()
                & btnSubmit.getText().equals("Update")) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to update this product " + txtProductCode.getText() + " " + txtProductName.getText() + " ?");
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle(" -fx-font-size: 15px;\n"
                    + "   -fx-font-weight: bold;"
                    + "   -fx-text-fill: red;");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                for (int i = 0; i < category.length; i++) {
                    if (category[i][1].equalsIgnoreCase(txtCategory.getText())) {
                        categoryID = Integer.parseInt(category[i][0]);
                        break;
                    }
                }
                for (int i = 0; i < supplier.length; i++) {
                    if (supplier[i][1].equalsIgnoreCase(txtSupplier.getText())) {
                        supplierID = Integer.parseInt(supplier[i][0]);
                        break;
                    }
                }

                if (supplierID == 0 & !txtSupplier.getText().isEmpty()) {
                    String column[] = {"supplier_name", "supplier_address", "supplier_contact", "supplier_date"};
                    String values[] = {txtSupplier.getText().substring(0, 1).toUpperCase() + txtSupplier.getText().substring(1), " ", " ", dtpDateCreated.getValue().toString()};

                    add_supplier("supplier", column, values);
                }
                if (categoryID == 0 & !txtCategory.getText().isEmpty()) {
                    String column[] = {"category_name"};
                    String values[] = {txtCategory.getText().substring(0, 1).toUpperCase() + txtCategory.getText().substring(1)};

                    add_category("category", column, values);
                }

                category = get_category();
                supplier = get_supplier();

                for (int i = 0; i < category.length; i++) {
                    if (category[i][1].equalsIgnoreCase(txtCategory.getText())) {
                        categoryID = Integer.parseInt(category[i][0]);
                        break;
                    }
                }
                for (int i = 0; i < supplier.length; i++) {
                    if (supplier[i][1].equalsIgnoreCase(txtSupplier.getText())) {
                        supplierID = Integer.parseInt(supplier[i][0]);
                        break;
                    }
                }

                double num_of_products = Double.parseDouble(txtNumProducts.getText());
                double selling_price = Double.parseDouble(txtSellingPrice.getText());
                double total_cost = Double.parseDouble(txtTotalCost.getText());
                supplier_price = Double.parseDouble(txtSupplierPrice.getText());

                String columnProduct[] = {"product.product_code",
                    "product.product_name",
                    "category_id",
                    "supplier_id",
                    "supplier_price",
                    "selling_price",
                    "num_of_products"
                };
                String valuesProduct[] = {txtProductCode.getText(),
                    txtProductName.getText(),
                    "" + categoryID,
                    "" + supplierID,
                    txtSupplierPrice.getText(),
                    txtSellingPrice.getText(),
                    "" + num_of_products};

                updateProduct(columnProduct, valuesProduct, txtProductCode.getText());

                String column_history[] = {"product_code", "account_id", "branch_id", "product_stock", "total_cost", "history_date", "supplier_id", "supplier_price", "selling_price", "expiration_date"};
                String values_history[] = {txtProductCode.getText(), Context.getInstance().account_name().getAccountID(), Context.getInstance().branch_id().getBranchID(), "" + num_of_products, "" + total_cost, ft.format(dNow), "" + supplierID, "" + supplier_price, "" + selling_price, date_expiration};

                Context.getInstance().product_history().Update_Product_History(txtProductCode.getText(), dtpDateCreated.getValue().toString(), column_history, values_history, "update");

                Stage stage = (Stage) pane.getScene().getWindow();

                stage.close();
            }

        }

        if (!txtProductCode.getText()
                .isEmpty()
                & !txtProductName.getText().isEmpty()
                & !txtNumProducts.getText().isEmpty()
                & !txtSellingPrice.getText().isEmpty()
                & btnSubmit.getText().equals("Delete")) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delete this product " + txtProductCode.getText() + " " + txtProductName.getText() + " ?");
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle(" -fx-font-size: 15px;\n"
                    + "   -fx-font-weight: bold;"
                    + "   -fx-text-fill: red;");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {

                category = get_category();
                supplier = get_supplier();

                for (int i = 0; i < category.length; i++) {
                    if (category[i][1].equalsIgnoreCase(txtCategory.getText())) {
                        categoryID = Integer.parseInt(category[i][0]);
                        break;
                    }
                }
                for (int i = 0; i < supplier.length; i++) {
                    if (supplier[i][1].equalsIgnoreCase(txtSupplier.getText())) {
                        supplierID = Integer.parseInt(supplier[i][0]);
                        break;
                    }
                }

                String columnProduct[] = {"product.product_status"};
                String valuesProduct[] = {"Delete"};

                updateProduct(columnProduct, valuesProduct, txtProductCode.getText());

                Stage stage = (Stage) pane.getScene().getWindow();

                stage.close();
            }

        } else {
            txtProductCode.setStyle("-fx-border-color: #FF0000;");
            txtProductName.setStyle("-fx-border-color: #FF0000;");
            txtNumProducts.setStyle("-fx-border-color: #FF0000;");
            txtSellingPrice.setStyle("-fx-border-color: #FF0000;");
            txtTotalCost.setStyle("-fx-border-color: #FF0000;");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        String product[][] = get_product();
        for (int i = 0; i < product.length; i++) {
            product_code.add(product[i][0]);
        }
        category = get_category();
        if (category.length > 0) {
            String categoryList[] = new String[category.length];
            for (int c = 0; c < category.length; c++) {
                categoryList[c] = category[c][1];
            }
            TextFields.bindAutoCompletion(txtCategory, categoryList);

        }

        supplier = get_supplier();
        if (supplier.length > 0) {
            String supplierList[] = new String[supplier.length];
            for (int c = 0; c < supplier.length; c++) {
                supplierList[c] = supplier[c][1];
            }
            TextFields.bindAutoCompletion(txtSupplier, supplierList);
        }

        dtpDateCreated.setValue(LocalDate.now());
        txtSupplier.getText().replaceAll("\\s+", "");
        txtCategory.getText().replaceAll("\\s+", "");

    }

    @FXML
    private void cancel() {

        Stage stage = (Stage) pane.getScene().getWindow();

        stage.close();
    }

}
