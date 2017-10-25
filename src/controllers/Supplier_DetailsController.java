/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Supplier_Model;
import models.Supplier_Table_Model;

/**
 * FXML Controller class
 *
 * @author Colonnello
 */
public class Supplier_DetailsController extends Supplier_Model implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public TextField txtSupplierName;

    @FXML
    public TextField txtAddress;

    @FXML
    public TextField txtContact;

    @FXML
    public TextField txtDate;

    //--------------------------------------------------------------------------
    @FXML
    private AnchorPane pane;
    //--------------------------------------------------------------------------
    @FXML
    private TableView<Supplier_Table_Model> tblSupplier;

    @FXML
    private TableColumn<Supplier_Table_Model, String> tbcProductCode;

    @FXML
    private TableColumn<Supplier_Table_Model, String> tbcProductName;

    @FXML
    private TableColumn<Supplier_Table_Model, Double> tbcSupplierPrice;

    @FXML
    private TableColumn<Supplier_Table_Model, Double> tbcSRP;

    @FXML
    private TableColumn<Supplier_Table_Model, String> tbcStocks;

    @FXML
    private TableColumn<Supplier_Table_Model, String> tbcSold;

    @FXML
    private TableColumn<Supplier_Table_Model, String> tbcInventory;

    @FXML
    private TableColumn<Supplier_Table_Model, String> tbcQtyUM;

    final ObservableList<Supplier_Table_Model> data = FXCollections.observableArrayList();

    @FXML
    public String supplierName;

    //--------------------------------------------------------------------------
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tbcProductCode.setCellValueFactory(new PropertyValueFactory<>("ProductCode"));
        tbcProductName.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        tbcSupplierPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        tbcSRP.setCellValueFactory(new PropertyValueFactory<>("SRP"));
        tbcStocks.setCellValueFactory(new PropertyValueFactory<>("Stocks"));
        tbcSold.setCellValueFactory(new PropertyValueFactory<>("Sold"));
        tbcInventory.setCellValueFactory(new PropertyValueFactory<>("Inventory"));
        tbcQtyUM.setCellValueFactory(new PropertyValueFactory<>("QtyUM"));
        tblSupplier.setItems(data);

    }

    public void tabulate_data(String supplierName[][]) {
        if (supplierName.length > 0) {
            for (String re[] : supplierName) {
                Supplier_Table_Model entry = new Supplier_Table_Model(
                        re[4],
                        re[5],
                        Double.parseDouble(re[6]),
                        Double.parseDouble(re[7]),
                        re[8],
                        re[9],
                        re[10],
                        re[11]
                );
                data.add(entry);
            }
        }
    }

    public void close() {
        Stage stage = (Stage) pane.getScene().getWindow();

        stage.close();
    }

    public void update() {
        if (!txtSupplierName.getText().isEmpty()
                & !txtAddress.getText().isEmpty()
                & !txtContact.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Are you you want to update " + txtSupplierName.getText() + " ?");
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle(" -fx-font-size: 15px;\n"
                    + "   -fx-font-weight: bold;"
            );
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                String column[] = {"supplier_name", "supplier_address", "supplier_contact"};
                String values[] = {txtSupplierName.getText(), txtAddress.getText(), txtContact.getText()};
                update_supplier(column, values, supplierName);
                Stage stage = (Stage) pane.getScene().getWindow();

                stage.close();
            } else {

            }

        } else {
            txtSupplierName.setStyle("-fx-border-color: #FF0000;");
            txtAddress.setStyle("-fx-border-color: #FF0000;");
            txtContact.setStyle("-fx-border-color: #FF0000;");
        }
    }

}
