/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.Main.stage;
import static controllers.POSController.modal;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import libs.Hash;
import models.Login_Model;

/**
 * FXML Controller class
 *
 * @author Colonnello
 */
public class LoginController extends Login_Model implements Initializable {

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblInvalid;

    @FXML
    private ComboBox cmbBranch;

    @FXML
    private String branch_All_list[][];

    //--------------------------------------------------------------------------
    public String branch_id;
    //--------------------------------------------------------------------------
    private static String[] login;

    private Hash hash = new Hash();

    /**
     * Initializes the controller class.
     */
    Date dNow = new Date();
    SimpleDateFormat ft
            = new SimpleDateFormat("yyyy-MM-dd");

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        ArrayList<String> branch = new ArrayList<>();
        branch_All_list = getBranchList();
        if (branch_All_list.length > 0) {

            for (int i = 0; i < branch_All_list.length; i++) {
                branch.add(branch_All_list[i][1]);
            }
        }

        ObservableList<String> list = FXCollections.observableArrayList(branch);
        cmbBranch.setItems(list);
        cmbBranch.setValue(branch.get(0));

    }

    public static String[] login(String source, String title, int w, int h) throws IOException {
        modal = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(POSController.class.getResource(source));
        AnchorPane showModal = loader.load();

        modal.setTitle(title);

        modal.setOnCloseRequest(e -> {
            System.exit(0);

        });
        //  adminpane.getIcons().add(new Image("/assets/images/login_header.png"));
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.initStyle(StageStyle.UTILITY);
        modal.initOwner(stage);
        modal.setResizable(false);
        modal.setMinWidth(w);
        modal.setMinHeight(h);
        Scene scene = new Scene(showModal);
        modal.setScene(scene);
        modal.toFront();
        modal.showAndWait();

        return login;
    }

    @FXML
    private void loginEnter(KeyEvent event) throws InvalidKeySpecException, NoSuchAlgorithmException {

        if (event.getCode() == KeyCode.ENTER) {
            if ((Integer.parseInt(transaction_dateTrap(ft.format(dNow))[0][1]) >= 0)) {
                for (int i = 0; i < branch_All_list.length; i++) {
                    if (branch_All_list[i][1].equals(cmbBranch.getValue().toString())) {

                        String res[][] = login_user(txtUsername.getText(), hash.hash(txtPassword.getText()), branch_All_list[i][0]);
                        if (res.length > 0) {
                            if (res[0][7].equals("Enable")) {
                                login = new String[7];
                                for (String result[] : res) {
                                    login[0] = result[0];
                                    login[1] = result[1];
                                    login[2] = result[2];
                                    login[3] = result[3];
                                    login[4] = result[4];
                                    login[5] = result[5];
                                    login[6] = result[6];

                                }
                                modal.close();
                            }
                            if (res[0][7].equals("Disable")) {
                                lblInvalid.setText("*Account disabled");
                                txtPassword.setText("");

                            }
                            if (res[0][7].equals("Delete")) {
                                lblInvalid.setText("*Invalid user");
                                txtUsername.setText("");
                                txtPassword.setText("");

                            }
                        } else {
                            lblInvalid.setText("*Invalid user");
                            txtUsername.setText("");
                            txtPassword.setText("");
                        }

                    }
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("Check your date!");
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.setStyle(" -fx-font-size: 15px;\n"
                        + "   -fx-font-weight: bold;"
                        + "   -fx-text-fill: red;");

                Optional<ButtonType> result = alert.showAndWait();
            }

        }
    }

    @FXML
    private void login(MouseEvent event) throws Exception {
        if ((Integer.parseInt(transaction_dateTrap(ft.format(dNow))[0][1]) >= 0)) {
            for (int i = 0; i < branch_All_list.length; i++) {
                if (branch_All_list[i][1].equals(cmbBranch.getValue().toString())) {

                    String res[][] = login_user(txtUsername.getText(), hash.hash(txtPassword.getText()), branch_All_list[i][0]);
                    if (res.length > 0) {
                        if (res[0][7].equals("Enable")) {
                            login = new String[7];
                            for (String result[] : res) {
                                login[0] = result[0];
                                login[1] = result[1];
                                login[2] = result[2];
                                login[3] = result[3];
                                login[4] = result[4];
                                login[5] = result[5];
                                login[6] = result[6];

                            }
                            modal.close();
                        }
                        if (res[0][7].equals("Disable")) {
                            lblInvalid.setText("*Account disabled");
                            txtPassword.setText("");

                        }
                    } else {
                        lblInvalid.setText("*Invalid user");
                        txtUsername.setText("");
                        txtPassword.setText("");
                    }

                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Check your date!");
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle(" -fx-font-size: 15px;\n"
                    + "   -fx-font-weight: bold;"
                    + "   -fx-text-fill: red;");

            Optional<ButtonType> result = alert.showAndWait();
        }

    }

}
