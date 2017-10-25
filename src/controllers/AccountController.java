/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.Main.stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.Account_Model;
import models.Account_Table_Model;

/**
 * FXML Controller class
 *
 * @author Colonnello
 */
public class AccountController extends Account_Model implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Account_Table_Model> tblAccount;

    @FXML
    private TableColumn<Account_Table_Model, Integer> tbcID;

    @FXML
    private TableColumn<Account_Table_Model, String> tbcPosition;

    @FXML
    private TableColumn<Account_Table_Model, String> tbcName;

    @FXML
    private TableColumn<Account_Table_Model, String> tbcGender;

    @FXML
    private TableColumn<Account_Table_Model, String> tbcAddress;

    @FXML
    private TableColumn<Account_Table_Model, String> tbcContact;

    @FXML
    private TableColumn<Account_Table_Model, String> tbcBranch;

    @FXML
    private TableColumn<Account_Table_Model, String> tbcDate;

    @FXML
    private TableColumn<Account_Table_Model, String> tbcUpdate;

    @FXML
    private TableColumn<Account_Table_Model, String> tbcDelete;

    //--------------------------------------------------------------------------
    @FXML
    private TextField txtNameID;
    //--------------------------------------------------------------------------
    final ObservableList<Account_Table_Model> data = FXCollections.observableArrayList();

    private Stage modal;

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.tbcID.setCellValueFactory(new PropertyValueFactory<>("AccountID"));
        this.tbcName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        this.tbcPosition.setCellValueFactory(new PropertyValueFactory<>("Position"));
        this.tbcGender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        this.tbcAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        this.tbcContact.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        this.tbcBranch.setCellValueFactory(new PropertyValueFactory<>("Branch"));
        this.tbcDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        this.tbcUpdate.setCellValueFactory(new PropertyValueFactory<>("Update"));
        this.tbcDelete.setCellValueFactory(new PropertyValueFactory<>("Delete"));
        tblAccount.setItems(data);
        tabulate_data();

        tbcUpdate.setCellFactory(tc -> {
            TableCell<Account_Table_Model, String> cell = new TableCell<Account_Table_Model, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : item);
                }
            };
            cell.setOnMouseClicked(e -> {
                if (!cell.isEmpty()) {
                    String productID = cell.getItem();

                }
            });
            return cell;
        });

        tbcUpdate.setCellFactory(tc -> {
            TableCell<Account_Table_Model, String> cell = new TableCell<Account_Table_Model, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : item);
                }
            };
            cell.setOnMouseClicked(e -> {
                if (!cell.isEmpty()) {
                    String Update = cell.getItem();
                    try {
                        setAccount(Update);
                        tabulate_data();
                    } catch (IOException ex) {
                        Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            return cell;
        });

        tbcDelete.setCellFactory(tc -> {
            TableCell<Account_Table_Model, String> cell = new TableCell<Account_Table_Model, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : item);
                }
            };
            cell.setOnMouseClicked(e -> {
                if (!cell.isEmpty()) {
                    String Delete = cell.getItem();
                    try {
                        setAccount(Delete);
                        tabulate_data();
                    } catch (IOException ex) {
                        Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            return cell;
        });

    }

    @FXML
    private void tabulate_data() {
        tblAccount.getItems().clear();
        String result[][] = getAccountList(txtNameID.getText());
        if (result.length > 0) {
            for (String res[] : result) {
                Account_Table_Model entry = new Account_Table_Model(
                        Integer.parseInt(res[0]),
                        res[1],
                        res[2],
                        res[3],
                        res[4],
                        res[5],
                        res[6],
                        res[7],
                        "Update",
                        "Delete"
                );
                data.add(entry);
            }
        }
    }

    private void setAccount(String action) throws IOException {
        modal = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/views/AddAccount.fxml"));
        AnchorPane showModal = loader.load();

        //  adminpane.getIcons().add(new Image("/assets/images/login_header.png"));
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.initStyle(StageStyle.UNDECORATED);

        modal.initOwner(stage);
        modal.setResizable(false);
        modal.setMinWidth(600);
        modal.setMinHeight(700);
        Scene scene = new Scene(showModal);
        modal.setScene(scene);
        AddAccountController controller = loader.<AddAccountController>getController();
        controller.btnSubmit.setText(action);
        String account_data_file[][] = getViewAccount("" + tblAccount.getSelectionModel().getSelectedItem().getAccountID());
        if (account_data_file.length > 0) {
            for (String res[] : account_data_file) {
                if (res[0].contains("null")) {

                    if (res[8].equalsIgnoreCase("Male")) {
                        controller.setImage("profile/male-user-profile-picture.png", res[0]);
                    }
                    if (res[8].equalsIgnoreCase("Female")) {
                        controller.setImage("profile/profile-picture-for-social-network.png", res[0]);
                    }

                } else {
                    controller.setImage("profile/" + account_data_file[0][0], "profile/" + account_data_file[0][0]);

                }
                controller.txtFirstname.setText(res[1]);
                controller.txtMI.setText(res[2]);
                controller.txtLastname.setText(res[3]);
                controller.txtStreet.setText(res[4]);
                controller.txtBarangay.setText(res[5]);
                controller.txtCity.setText(res[6]);
                controller.txtProvince.setText(res[7]);
                if (res[8].equalsIgnoreCase("Male")) {
                    controller.radioMale.setSelected(true);
                }
                if (res[8].equalsIgnoreCase("Female")) {
                    controller.radioFemale.setSelected(true);
                }
                controller.txtContact.setText(res[9]);
                controller.cmbBranch.setValue(res[10]);
                controller.cmbAccountType.setValue(res[11]);
                controller.txtUsername.setText(res[12]);
                controller.txtUsername.setDisable(true);
                controller.cmbAccountStatus.setValue(res[13]);
                controller.accountID = res[14];
                if (action.equalsIgnoreCase("Delete")) {
                    controller.txtFirstname.setEditable(false);
                    controller.txtMI.setEditable(false);
                    controller.txtLastname.setEditable(false);
                    controller.txtStreet.setEditable(false);
                    controller.txtBarangay.setEditable(false);
                    controller.txtCity.setEditable(false);
                    controller.txtProvince.setEditable(false);
                    controller.txtContact.setEditable(false);
                    controller.cmbBranch.setEditable(false);
                    controller.cmbAccountType.setEditable(false);
                    controller.cmbAccountStatus.setEditable(false);
                    controller.txtPassword.setEditable(false);
                }

            }

        }

        modal.showAndWait();

    }

    @FXML
    private void setAddAccount() throws IOException {
        Main.undecorated("/views/AddAccount.fxml", "Add account", 600, 700);
        tabulate_data();
    }

}
