/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import models.Context;
import models.Product_List_Model;
import models.Products_Model;

/**
 * FXML Controller class
 *
 * @author Colonnello
 */
public class Stack_SummaryController extends Products_Model implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Product_List_Model> tblProduct;

    @FXML
    private TableColumn<Product_List_Model, String> tbcProductCode;

    @FXML
    private TableColumn<Product_List_Model, String> tbcProductName;

    @FXML
    private TableColumn<Product_List_Model, Double> tbcSellingPrice;

    @FXML
    private TableColumn<Product_List_Model, Double> tbcSold;

    @FXML
    private TableColumn<Product_List_Model, String> tbcNumber;

    @FXML
    private TableColumn<Product_List_Model, String> tbcAccountName;

    //--------------------------------------------------------------------------
    @FXML
    private StackedBarChart sbcStackSummary;
    //--------------------------------------------------------------------------
    @FXML
    private TextField txtProductCodeName;

    //--------------------------------------------------------------------------
    @FXML
    private String productCodeName = " ";

    //--------------------------------------------------------------------------
    final ObservableList<Product_List_Model> data = FXCollections.observableArrayList();

    Date dNow = new Date();
    SimpleDateFormat ft
            = new SimpleDateFormat("MMM/dd/yyyy 'at' hh:mm:ss a");

    class DashboardFrameData {

        public DashboardFrameData() {
            dashboard();
        }

        // the digital clock updates once a second.
        private void dashboard() {

            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(0),
                            new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            tabulateData();
                            setTabulateStackPane();
                        }
                    }
                    ),
                    new KeyFrame(Duration.seconds(1000))
            );
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        tbcProductCode.setCellValueFactory(new PropertyValueFactory<>("ProductCode"));
        tbcProductName.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        tbcSellingPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        tbcSold.setCellValueFactory(new PropertyValueFactory<>("Sold"));
        tbcNumber.setCellValueFactory(new PropertyValueFactory<>("Number"));
        tbcAccountName.setCellValueFactory(new PropertyValueFactory<>("AccountName"));
        tblProduct.setItems(data);
        DashboardFrameData dash = new DashboardFrameData();
        dash.dashboard();

    }

    private void tabulateData() {
        tblProduct.getItems().clear();

        String result[][] = get_product_listsStack(productCodeName, Context.getInstance().branch_id().getBranchID());
        if (result.length > 0) {
            for (String re[] : result) {
                Product_List_Model entry = new Product_List_Model(
                        re[0],
                        re[1],
                        Double.parseDouble(re[2]),
                        Double.parseDouble(re[3]),
                        re[4],
                        re[5]
                );
                data.add(entry);
            }
        }

    }

    public void setProductCodeName() {
        productCodeName = txtProductCodeName.getText();
        tabulateData();
    }

    private void setTabulateStackPane() {
        sbcStackSummary.getData().clear();

        String result[][] = get_product_listsStack(productCodeName, Context.getInstance().branch_id().getBranchID());
        if (result.length > 0) {
            sbcStackSummary.setTitle(Context.getInstance().branch_name().getBranchName());
            XYChart.Series<String, Number> number_of_product = new XYChart.Series<>();
            XYChart.Series<String, Number> sold_of_product = new XYChart.Series<>();

            for (int i = 0; i < result.length; i++) {
                number_of_product.getData().add(new XYChart.Data<>(result[i][1], Double.parseDouble(result[i][4])));
                sold_of_product.getData().add(new XYChart.Data<>(result[i][1], Double.parseDouble(result[i][3])));
            }

            number_of_product.setName("Number of product");
            sold_of_product.setName("Number of Sold product");
            sbcStackSummary.getData().add(number_of_product);
            sbcStackSummary.getData().add(sold_of_product);

        }

    }
}

class DashboardUtilites {

    /**
     * Creates a string left padded to the specified width with the supplied
     * padding character.
     *
     * @param fieldWidth the length of the resultant padded string.
     * @param padChar a character to use for padding the string.
     * @param s the string to be padded.
     * @return the padded string.
     */
    public static String pad(int fieldWidth, char padChar, String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i < fieldWidth; i++) {
            sb.append(padChar);
        }
        sb.append(s);

        return sb.toString();
    }
}
