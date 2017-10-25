package controllers;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.Account_Model;
import models.Context;
import models.Login_Model;

public class Main extends Application {

    public static Stage stage;

    String[] accountDetails;

    Login_Model login = new Login_Model();

    ArrayList<String> product_code = new ArrayList<>();
    String result[][];

    @Override
    public void start(Stage stage) throws Exception {

        result = login.getProductCode();
        if (result.length > 0) {
            for (String res[] : result) {
                product_code.add(res[0]);
            }
        }

        accountDetails = LoginController.login("/views/login.fxml", "Stop N' Shop", 484, 318);
        setAccount_logs(accountDetails[5], accountDetails[4]);
        if (accountDetails[6].equalsIgnoreCase("5")) {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/Products.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setMaximized(true);
            stage.setScene(scene);
            stage.toBack();
            ProductsController controller = fxmlLoader.<ProductsController>getController();
            controller.lblAccountName.setText(accountDetails[0]);
            controller.setUser(accountDetails[0], accountDetails[1], accountDetails[4], accountDetails[5], accountDetails[6]);

            stage.show();
        }
        if (accountDetails[6].equalsIgnoreCase("2")) {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/POS.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setMaximized(true);
            stage.setScene(scene);
            stage.toBack();
            POSController controller = fxmlLoader.<POSController>getController();
            controller.lblAccountName.setText(accountDetails[0]);
            controller.txtStoreName.setText(accountDetails[1]);
            controller.txtStoreAddress.setText(accountDetails[2]);
            controller.txtContact.setText(accountDetails[3]);
            controller.branch_id = Integer.parseInt(accountDetails[4]);
            Context.getInstance().user_id().setAccountID(accountDetails[5]);
            controller.setUser(accountDetails[0], accountDetails[1], accountDetails[4], accountDetails[5], accountDetails[6]);

            stage.show();
        }
        if (accountDetails[6].equalsIgnoreCase("1") || accountDetails[6].equalsIgnoreCase("3")) {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/AdminDashboard.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setMaximized(true);
            stage.setScene(scene);
            stage.toBack();
            AdminDashboardController controller = fxmlLoader.<AdminDashboardController>getController();
            controller.lblAccountName.setText(accountDetails[0]);
            controller.setUser(accountDetails[0], accountDetails[1], accountDetails[4], accountDetails[5], accountDetails[6]);

            stage.show();
        }

    }

    public static void customer(String source, String title, int w, int h) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(source));
        AnchorPane showModal = loader.load();

        Stage modal = new Stage();
        modal.setTitle(title);
        modal.getIcons().add(new Image("/assets/images/17577730_1460176047339927_230815903_n.png"));
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.initOwner(stage);
        modal.setResizable(false);
        modal.setMinWidth(w);
        modal.setMinHeight(h);
        Scene scene = new Scene(showModal);
        modal.setScene(scene);
        modal.showAndWait();

    }

    public static void modal(String source, String title, double w, double h) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(source));
        AnchorPane showModal = loader.load();

        Stage modal = new Stage();
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

    }

    public static void undecorated(String source, String title, double w, double h) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(source));
        AnchorPane showModal = loader.load();

        Stage modal = new Stage();
        modal.setTitle(title);
        //  adminpane.getIcons().add(new Image("/assets/images/login_header.png"));
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.initStyle(StageStyle.UNDECORATED);
        modal.initOwner(stage);
        modal.setResizable(false);
        modal.setMinWidth(w);
        modal.setMinHeight(h);
        Scene scene = new Scene(showModal);
        modal.setScene(scene);
        modal.showAndWait();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void setAccount_logs(String account_id, String branch_id) throws UnknownHostException {
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat datetime
                = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String column[] = {"account_id", "ipaddress", "date_login"};
        String values[] = {account_id, InetAddress.getLocalHost().toString(), datetime.format(dt)};

        Account_Model account = new Account_Model();
//------------------------------------------------------------------------------
        String columnUpdate[] = {"login_status"};
        String valuesUpate[] = {"Available"};
        account.UPDATE("accounts", columnUpdate, valuesUpate, "WHERE account_id = '" + account_id + "'");

        account.setAccount_logs(column, values);

        for (int i = 0; i < product_code.size(); i++) {
            if (!login.find_product(product_code.get(i))) {

                String column_history[] = {"product_code", "cp_number", "account_id", "branch_id", "product_stock", "total_cost", "tendered_amount", "history_date", "supplier_id", "supplier_price", "selling_price", "expiration_date", "product_sold"};
                String values_history[] = {product_code.get(i), "", account_id, branch_id, result[i][2], "0", "0", date.toString(), result[i][3], result[i][4], result[i][5], "0000-00-00", "0"};

                Context.getInstance().product_history().Update_Product_History(product_code.get(i), date.toString(), column_history, values_history, "insert");

            }
        }

    }

}
