/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Colonnello
 */
public class View_TransactionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public Label branchName;

    @FXML
    public Label refID;

    @FXML
    public Label date;

    @FXML
    public Label amount;

    @FXML
    public Label type;

    @FXML
    public Label lblAccountName;
    
    @FXML
    public Label lblTransactionBasket;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
