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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.Context;
import models.Product_List_Model;
import models.Products_Model;

/**
 * FXML Controller class
 *
 * @author Colonnello
 */
public class Product_ListController extends Products_Model implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Product_List_Model> tblProductList;

    @FXML
    private TableColumn<Product_List_Model, String> tbcProductCode;

    @FXML
    private TableColumn<Product_List_Model, String> tbcProductName;

    @FXML
    private TableColumn<Product_List_Model, Double> tbcPrice;

    @FXML
    private TableColumn<Product_List_Model, Double> tbcNumber;
    //--------------------------------------------------------------------------
    @FXML
    private TextField txtProductNameCode;
    //--------------------------------------------------------------------------
    private static String product_code;

    private static Stage modal;
    //--------------------------------------------------------------------------

    final ObservableList<Product_List_Model> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tbcProductCode.setCellValueFactory(new PropertyValueFactory<>("ProductCode"));
        tbcProductName.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        tbcPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        tbcNumber.setCellValueFactory(new PropertyValueFactory<>("Number"));
        tblProductList.setItems(data);
    }

    public static String productList(String source, String title, double w, double h) throws IOException {
        modal = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(POSController.class.getResource(source));
        AnchorPane showModal = loader.load();

        modal.setTitle(title);

        modal.setOnCloseRequest(e -> {
            product_code = "";

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

        return product_code;
    }

    public void tabulate_data() {
        tblProductList.getItems().clear();
        String result[][] = get_product_lists(txtProductNameCode.getText(), Context.getInstance().branch_id().getBranchID());
        if (result.length > 0) {
            for (String res[] : result) {
                Product_List_Model entry = new Product_List_Model(
                        res[0],
                        res[1],
                        Double.parseDouble(res[2]),
                        0,
                        res[3],
                        ""
                );
                data.add(entry);
            }

        }
    }

    public void key_event(KeyEvent event) {
        if (event.getCode() == KeyCode.ESCAPE) {
            product_code = "close";
            modal.close();
        }
        if (event.getCode() == KeyCode.ENTER) {
            product_code = tblProductList.getSelectionModel().getSelectedItem().getProductCode();
            modal.close();
        }
       
    }

}
