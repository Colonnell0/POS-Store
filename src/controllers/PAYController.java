/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.POSController.modal;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import libs.FormatNumber;
import models.Context;
import models.Pay_Model;

/**
 * FXML Controller class
 *
 * @author Colonnello
 */
public class PAYController extends Pay_Model implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public TextField txtTotal;

    @FXML
    private TextField txtChange;

    @FXML
    public TextField txtAmount;
    //--------------------------------------------------------------------------
    @FXML
    private Button num_1, num_2, num_3, num_4, num_5, num_6, num_7, num_8, num_9, num_0, num_period, num_clear;

    //--------------------------------------------------------------------------
    @FXML
    public Label lblShopInfo;

    @FXML
    public Label lblDate;

    @FXML
    public Label lblAccountName;

    @FXML
    public Label lblBasketTransactionList;

    @FXML
    public Label lblRefNum;

    @FXML
    public Label lblPaySubtotal;

    @FXML
    public Label lblPayTotal;
    //--------------------------------------------------------------------------
    @FXML
    public VBox vbList;

    //--------------------------------------------------------------------------
    private double total, amount, change = 0;

    private boolean change_handler = false;

    public ArrayList<String> transaction_basket = new ArrayList<>();

    public int branch_id;

    public double total_product = 0;

    public String date_time_transaction;

    public ArrayList<String> load_product_id = new ArrayList<>();

    java.sql.Timestamp dNow = new java.sql.Timestamp(new java.util.Date().getTime());
    
    SimpleDateFormat search_dt
            = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat ft
            = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    //--------------------------------------------------------------------------
    @FXML
    private AnchorPane pane;
    //
    FormatNumber formatNumber = new FormatNumber();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void change() throws Exception {
        total = Double.parseDouble(txtTotal.getText().replaceAll(",", ""));
        amount = Double.parseDouble(txtAmount.getText());
        change = 0;
        change = amount - total;
        if (change >= 0) {
            txtChange.setStyle("  -fx-text-fill: #429ef4;");
            change_handler = true;
        }
        if (change < 0) {
            txtChange.setStyle("  -fx-text-fill: red;");
            change_handler = false;
        }
        txtChange.setText(formatNumber.formatNumbers("" + change));
        txtAmount.requestFocus();
        txtAmount.positionCaret(txtAmount.getText().length());

    }

    public void change_event(KeyEvent event) throws Exception {
        if (event.getCode() == KeyCode.ESCAPE) {
            Stage stage = (Stage) pane.getScene().getWindow();
            stage.close();
        }
        if (event.getCode() == KeyCode.CONTROL) {
            pay();
        } else {
            change();
        }

    }

    //--------------------------------------------------------------------------
    public void num_keys_0() throws Exception {
        String num = txtAmount.getText() + "0";
        txtAmount.setText(num);
        change();

    }

    public void num_keys_1() throws Exception {
        String num = txtAmount.getText() + "1";
        txtAmount.setText(num);
        change();

    }

    public void num_keys_2() throws Exception {
        String num = txtAmount.getText() + "2";
        txtAmount.setText(num);
        change();

    }

    public void num_keys_3() throws Exception {
        String num = txtAmount.getText() + "3";
        txtAmount.setText(num);
        change();

    }

    public void num_keys_4() throws Exception {
        String num = txtAmount.getText() + "4";
        txtAmount.setText(num);
        change();

    }

    public void num_keys_5() throws Exception {
        String num = txtAmount.getText() + "5";
        txtAmount.setText(num);
        change();

    }

    public void num_keys_6() throws Exception {
        String num = txtAmount.getText() + "6";
        txtAmount.setText(num);
        change();

    }

    public void num_keys_7() throws Exception {
        String num = txtAmount.getText() + "7";
        txtAmount.setText(num);

    }

    public void num_keys_8() throws Exception {
        String num = txtAmount.getText() + "8";
        txtAmount.setText(num);
        change();

    }

    public void num_keys_9() throws Exception {
        String num = txtAmount.getText() + "9";
        txtAmount.setText(num);
        change();

    }

    public void num_keys_period() throws Exception {
        String num = txtAmount.getText() + ".";
        txtAmount.setText(num);
        change();

    }

    public void num_keys_clear() throws Exception {
        txtAmount.setText("");
        txtChange.setText("0");
        txtAmount.requestFocus();
        txtAmount.positionCaret(txtAmount.getText().length());

    }

    public void cancel() {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }

    public void pay() {
        if (change_handler) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("YOUR CHANGE " + txtChange.getText() + "\n    Thank you ◕‿◕");
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle(" -fx-font-size: 20px;\n"
                    + "   -fx-font-weight: bold;"
            );
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Stage stage = (Stage) pane.getScene().getWindow();

                String column[] = {"transaction_id", "transaction_basket", "transaction_branch_id", "transaction_account_id", "transaction_amount", "transaction_subtotal", "transaction_total", "transaction_tax", "transaction_discount", "transaction_change", "transaction_date", "transaction_total_product"};
                String values[] = {lblRefNum.getText(), transaction_basket.toString(), "" + branch_id, Context.getInstance().user_id().getAccountID(), txtAmount.getText(), lblPaySubtotal.getText(), lblPayTotal.getText(), "0", "0", "" + change, date_time_transaction, "" + total_product};
                pay_transaction("transaction", column, values);

                for (int i = 0; i < transaction_basket.size(); i++) {
                    String split[] = transaction_basket.get(i).split("\\~:~");

                    if (load_product_id.indexOf(split[0]) >= 0) {
                        String column_p[] = {"num_of_products"};
                        String result_p[][] = find_product(split[0], Context.getInstance().branch_id().getBranchID());
                        String values_p[] = {"" + (Double.parseDouble(result_p[0][1]) - Double.parseDouble(split[3]))};
                        updateProduct(column_p, values_p, split[0]);

                        String column_history[] = {"product_code", "cp_number", "account_id", "branch_id", "product_stock", "product_sold", "total_cost", "tendered_amount", "history_date", "supplier_id", "supplier_price", "selling_price", "expiration_date"};
                        String values_history[] = {split[0], split[1].split("\\ = ")[1], Context.getInstance().account_name().getAccountID(), Context.getInstance().branch_id().getBranchID(), "" + (Double.parseDouble(result_p[0][1]) - Double.parseDouble(split[3])), "" + Double.parseDouble(split[3]), "0", split[4], ft.format(dNow), result_p[0][2], result_p[0][3], result_p[0][4], "0000-00-00"};

                        add_product_history("product_history", column_history, values_history);

                    } else {

                        String column_p[] = {"num_of_products"};
                        String result_p[][] = find_product(split[0], Context.getInstance().branch_id().getBranchID());
                        String values_p[] = {"" + (Double.parseDouble(result_p[0][1]) - Double.parseDouble(split[3]))};
                        updateProduct(column_p, values_p, split[0]);

                        String column_history[] = {"product_sold", "product_stock", "tendered_amount", "history_date", "account_id"};
                        String values_history[] = {"" + (Double.parseDouble(split[3]) + Double.parseDouble(result_p[0][5])), "" + (Double.parseDouble(result_p[0][1]) - Double.parseDouble(split[3])), "" + (Double.parseDouble(result_p[0][6]) + Double.parseDouble(split[4])), ft.format(dNow), Context.getInstance().account_name().getAccountID()};
                        Context.getInstance().product_history().Update_Product_History(split[0],search_dt.format(dNow), column_history, values_history, "update");

                    }

                }

                modal.setTitle("OK");
                stage.close();
            }

        }
    }

}
