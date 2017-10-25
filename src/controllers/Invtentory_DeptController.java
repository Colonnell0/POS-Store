/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import models.Context;
import models.Products_Model;

/**
 * FXML Controller class
 *
 * @author Colonnello
 */
public class Invtentory_DeptController extends Products_Model implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public Label lblAccountName;

    @FXML
    private AnchorPane viewFrame;

    //--------------------------------------------------------------------------
    @FXML
    Label lblHead;

    public void setDataPane(Node nodes) {
        viewFrame.getChildren().clear();
        viewFrame.getChildren().addAll(nodes);

    }

    public AnchorPane fadeAnimate(String url) throws IOException {
        AnchorPane view = (AnchorPane) FXMLLoader.load(getClass().getResource(url));
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(200));
        fadeTransition.setNode(view);
        fadeTransition.setFromValue(0.1);
        fadeTransition.setToValue(1);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(false);
        fadeTransition.play();
        return view;
    }

    public void Products(ActionEvent event) throws IOException {

        setDataPane(fadeAnimate("/views/Products.fxml"));
        lblHead.setText("Production / Products");

    }

    public void setUser(String account_name, String branch_name, String branch_id, String account_id, String account_type) {
        Context.getInstance().branch_id().setBranchID(branch_id);
        Context.getInstance().user_id().setAccountID(account_id);
        Context.getInstance().branch_name().setBranchName(branch_name);
        Context.getInstance().account_type().setAccountType(account_type);
        Context.getInstance().account_name().setAccountName(account_name);
     

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {

            setDataPane(fadeAnimate("/views/Products.fxml"));
            lblHead.setText("Production / Products");

        } catch (IOException ex) {
            Logger.getLogger(Invtentory_DeptController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Logout() throws IOException {
        String column[] = {"account_status"};
        String values[] = {""};
        setLogout(column, values, Context.getInstance().account_name().getAccountID());
        System.exit(0);
    }

}
