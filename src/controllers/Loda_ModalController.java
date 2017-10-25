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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.Context;

/**
 * FXML Controller class
 *
 * @author Colonnello
 */
public class Loda_ModalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtCpNum;

    @FXML
    private TextField txtLoad;

    @FXML
    private TextField txtPrice;

    @FXML
    public Label lblLabel;
    //--------------------------------------------------------------------------
    private static Stage modal;

    private static String value[] = new String[5];

    public static String[] Load_Central(String source, String title, int w, int h) throws IOException {
        modal = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(source));
        AnchorPane showModal = loader.load();

        modal.setOnCloseRequest(e -> {
            value[0] = "close";

        });

        modal.setTitle(title);
        //  adminpane.getIcons().add(new Image("/assets/images/login_header.png"));
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.initStyle(StageStyle.UTILITY);
        modal.initOwner(stage);
        modal.setResizable(false);
        modal.setMinWidth(w);
        modal.setMinHeight(h);
        Scene scene = new Scene(showModal);
        modal.setScene(scene);
        modal.showAndWait();

        return value;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lblLabel.setText(Context.getInstance().branch_name().getLoadCenter());
    }

    @FXML
    private void setSubmit() {
        double amount;
        try {
            if (!txtCpNum.getText().isEmpty() & !txtLoad.getText().isEmpty() & !txtPrice.getText().isEmpty()) {
                value[0] = "OK";
                value[1] = txtCpNum.getText();
                value[2] = txtLoad.getText();
                value[3] = txtPrice.getText();
                value[4] = lblLabel.getText() + " = " + txtCpNum.getText();
                modal.close();
            }
        } catch (Exception e) {

        }

    }

    @FXML
    private void setCancel() {
        value[0] = "close";
        modal.close();
    }

    @FXML
    private void setViewClose(KeyEvent event) {
        if (event.getCode() == KeyCode.ESCAPE) {
            value[0] = "close";
            modal.close();

        }
        if (event.getCode() == KeyCode.ENTER) {
            double amount;
            try {
                if (!txtCpNum.getText().isEmpty() & !txtLoad.getText().isEmpty() & !txtPrice.getText().isEmpty()) {
                    value[0] = "OK";
                    value[1] = txtCpNum.getText();
                    value[2] = txtLoad.getText();
                    value[3] = txtPrice.getText();
                    value[4] = lblLabel.getText() + " = " + txtCpNum.getText();
                    modal.close();
                }
            } catch (Exception e) {

            }
        }

    }

}
