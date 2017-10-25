/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import libs.NodePrinter;
import models.Context;
import models.GenerateSales_Model;

/**
 * FXML Controller class
 *
 * @author Colonnello
 */
public class PrintPreviewController extends GenerateSales_Model implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane pane;

    @FXML
    GenerateSalesController controller;

    public void setDataPane(Node nodes) {
        pane.getChildren().clear();
        pane.getChildren().addAll(nodes);

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {

            setDataPane(fadeAnimate("/views/GenerateSales.fxml"));

        } catch (IOException e) {
            System.out.println(e);

        }
    }

    @FXML
    private void setPrint() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(null);
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to generate sales?");
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle(" -fx-font-size: 15px;\n"
                + "   -fx-font-weight: bold;"
                + "   -fx-text-fill: red;");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {

            String column[] = {"branch_id", "sales_id", "account_id", "sale_date", "sold", "amount", "owner_id"};

            setSales(column, Context.getInstance().user_id().getGenerateSales());
            
            NodePrinter printer = new NodePrinter();
            printer.printNode(pane);
            Stage stage = (Stage) pane.getScene().getWindow();

            stage.close();
        }

    }

    @FXML
    private void setClose() {
        Stage stage = (Stage) pane.getScene().getWindow();

        stage.close();
    }

}
