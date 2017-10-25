/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.Main.stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.Context;
import models.Products_Model;
import models.View_Product_Table;

/**
 * FXML Controller class
 *
 * @author Colonnello
 */
public class View_ProductController extends Products_Model implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ComboBox cmbBranch;
    //--------------------------------------------------------------------------
    @FXML
    private TableView<View_Product_Table> tblProduct;

    @FXML
    private TableColumn<View_Product_Table, String> tbcProductCode;

    @FXML
    private TableColumn<View_Product_Table, String> tbcProductName;

    @FXML
    private TableColumn<View_Product_Table, Double> tbcPrice;

    @FXML
    private TableColumn<View_Product_Table, String> tbcStock;

    @FXML
    private TableColumn<View_Product_Table, String> tbcOrder;

    @FXML
    private TableColumn<View_Product_Table, String> tbcStatus;

    @FXML
    private TableColumn<View_Product_Table, String> tbcUpdate;

    @FXML
    private TableColumn<View_Product_Table, String> tbcDelete;

    //--------------------------------------------------------------------------
    @FXML
    private TextField txtProductCodeName;
    //--------------------------------------------------------------------------
    private String branch_All_list[][] = null;

    private int branch_id;

    private Stage modal;

    final ObservableList<View_Product_Table> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        ArrayList<String> branch = new ArrayList<>();
        branch_All_list = get_branch();
        if (branch_All_list.length > 0) {

            for (int i = 0; i < branch_All_list.length; i++) {
                branch.add(branch_All_list[i][1]);
            }
        }

        ObservableList<String> branch_list = FXCollections.observableArrayList(branch);
        cmbBranch.setItems(branch_list);
        cmbBranch.setValue(branch_All_list[0][1]);
        branch_id = Integer.parseInt(branch_All_list[0][0]);

        //----------------------------------------------------------------------
        this.tbcProductCode.setCellValueFactory(new PropertyValueFactory<>("ProductCode"));
        this.tbcProductName.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        this.tbcPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        this.tbcStock.setCellValueFactory(new PropertyValueFactory<>("Stocks"));
        this.tbcOrder.setCellValueFactory(new PropertyValueFactory<>("Order"));
        this.tbcStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
        this.tbcUpdate.setCellValueFactory(new PropertyValueFactory<>("Update"));
        this.tbcDelete.setCellValueFactory(new PropertyValueFactory<>("Delete"));
        this.tblProduct.setItems(data);
        tabulate_data();

        tbcStatus.setCellFactory(tc -> {
            TableCell<View_Product_Table, String> cell = new TableCell<View_Product_Table, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : item);
                }
            };
            cell.setOnMouseClicked(e -> {
                if (!cell.isEmpty()) {
                    String status = cell.getItem();
                    String title = tblProduct.getSelectionModel().getSelectedItem().getProductCode() + " " + tblProduct.getSelectionModel().getSelectedItem().getProductName();
                    List<String> choices = new ArrayList<>();
                    choices.add("Enable");
                    choices.add("Disable");

                    ChoiceDialog<String> dialog = new ChoiceDialog<>(status, choices);
                    DialogPane dialogPane = dialog.getDialogPane();
                    dialogPane.setStyle(" -fx-font-size: 12px;\n"
                            + "   -fx-font-weight: bold;");
                    dialog.setTitle("Stop N' Shop (Main Branch) | " + tblProduct.getSelectionModel().getSelectedItem().getProductCode());

                    dialog.setHeaderText(title);
                    dialog.setContentText(null);

                    // Traditional way to get the response value.
                    Optional<String> result = dialog.showAndWait();
                    if (result.isPresent()) {

                        setUpdateStatus(tblProduct.getSelectionModel().getSelectedItem().getProductCode(), result.get());
                    }

                    tabulate_data();
                }
            });
            return cell;
        });
        tbcDelete.setCellFactory(tc -> {
            TableCell<View_Product_Table, String> cell = new TableCell<View_Product_Table, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : item);
                }
            };
            cell.setOnMouseClicked(e -> {
                if (!cell.isEmpty()) {
                    String status = cell.getItem();
                    try {
                        setProductUpdateDelete("Delete", tblProduct.getSelectionModel().getSelectedItem().getProductCode());
                    } catch (IOException ex) {
                        Logger.getLogger(View_ProductController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    tabulate_data();
                }
            });
            return cell;
        });
        tbcUpdate.setCellFactory(tc -> {
            TableCell<View_Product_Table, String> cell = new TableCell<View_Product_Table, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : item);
                }
            };
            cell.setOnMouseClicked(e -> {
                if (!cell.isEmpty()) {
                    String status = cell.getItem();
                    try {
                        setProductUpdateDelete("Update", tblProduct.getSelectionModel().getSelectedItem().getProductCode());
                    } catch (IOException ex) {
                        Logger.getLogger(View_ProductController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    tabulate_data();
                }
            });
            return cell;
        });
        tbcOrder.setCellFactory(tc -> {
            TableCell<View_Product_Table, String> cell = new TableCell<View_Product_Table, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : item);
                }
            };
            cell.setOnMouseClicked(e -> {
                if (!cell.isEmpty()) {
                    String status = cell.getItem();
                    TextInputDialog dialog = new TextInputDialog("");

                    DialogPane dialogPane = dialog.getDialogPane();
                    dialogPane.setStyle(" -fx-font-size: 12px;\n"
                            + "   -fx-font-weight: bold;");
                    dialog.setTitle("Stop N' Shop (Main Branch) | " + tblProduct.getSelectionModel().getSelectedItem().getProductCode());
                    dialog.setHeaderText(tblProduct.getSelectionModel().getSelectedItem().getProductName());
                    dialog.setContentText("Please specify max order number:");

                    // Traditional way to get the response value.
                    Optional<String> result = dialog.showAndWait();
                    if (result.isPresent()) {

                        try {
                            setUpdateOrder(tblProduct.getSelectionModel().getSelectedItem().getProductCode(), "" + Double.parseDouble(result.get()));
                        } catch (Exception ex) {
                            Logger.getLogger(View_ProductController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    tabulate_data();
                }
            });
            return cell;
        });

    }

    @FXML
    private void tabulate_data() {
        tblProduct.getItems().clear();
        String result[][] = get_product_lists(txtProductCodeName.getText(), "" + branch_id);
        if (result.length > 0) {
            for (String res[] : result) {
                View_Product_Table entry = new View_Product_Table(
                        res[0],
                        res[1],
                        Double.parseDouble(res[2]),
                        res[3],
                        res[5],
                        res[4],
                        "Update",
                        "Delete"
                );
                data.add(entry);
            }

        }

    }

    @FXML
    private void setBranch() {
        for (String result[] : branch_All_list) {
            if (cmbBranch.getValue().toString().equalsIgnoreCase(result[1])) {
                branch_id = Integer.parseInt(result[0]);
                break;
            }
        }
        tabulate_data();
    }

    private void setUpdateStatus(String id, String status) {
        String column[] = {"product.product_status"};
        String values[] = {status};
        updateProduct(column, values, id);

    }

    private void setUpdateOrder(String id, String order) {
        String column[] = {"product.order_constant"};
        String values[] = {order};
        updateProduct(column, values, id);

    }

    private void setProductUpdateDelete(String action, String id) throws IOException {

        modal = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/views/Add_Product.fxml"));
        AnchorPane showModal = loader.load();

        modal.setTitle("Stop N' Shop | Product");
        //  adminpane.getIcons().add(new Image("/assets/images/login_header.png"));
        modal.initModality(Modality.WINDOW_MODAL);
        modal.initStyle(StageStyle.UTILITY);

        modal.initOwner(stage);
        modal.setResizable(false);
        modal.setMinWidth(700);
        modal.setMinHeight(600);
        Scene scene = new Scene(showModal);
        modal.setScene(scene);

        Add_ProductController controller = loader.<Add_ProductController>getController();
        String result[][] = get_product_listAll(id, Context.getInstance().branch_id().getBranchID());
        controller.txtProductCode.setText(result[0][0]);
        controller.txtProductCode.setEditable(false);
        controller.txtProductName.setText(result[0][1]);
        controller.txtNumProducts.setText(result[0][2]);
        controller.txtTotalCost.setDisable(true);
        controller.txtCategory.setText(result[0][3]);
        controller.txtSupplier.setText(result[0][4]);
        controller.txtSupplierPrice.setText(result[0][5]);
        controller.txtSellingPrice.setText(result[0][6]);
        controller.dtpExpirationDate.setDisable(true);
        controller.dtpDateCreated.setDisable(true);
        controller.btnSubmit.setText(action);

        modal.showAndWait();

    }

}
