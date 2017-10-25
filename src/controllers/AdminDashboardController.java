/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.Main.stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import libs.FormatNumber;
import models.Admin_Model;
import models.Context;

/**
 * FXML Controller class
 *
 * @author Colonnello
 */
public class AdminDashboardController extends Admin_Model implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnAccounts;

    @FXML
    private Button btnTransaction;

    @FXML
    private Button btnProduct;

    @FXML
    private ImageView imgProfile;

    @FXML
    private Stage modal;

    @FXML
    private Button btnSales;

    //--------------------------------------------------------------------------
    @FXML
    private Label lblHead;

    @FXML
    private Label lblPosition;

    @FXML
    private Label lblName;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblContact;

    @FXML
    private Label lblTotalSale;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblAmount;

    @FXML
    private Label lblAvailable;

    @FXML
    private Label lblSold;

    @FXML
    private Label lblPurchase;

    @FXML
    private Label lblStatus;

    @FXML
    public Label lblAccountName;

    //--------------------------------------------------------------------------
    @FXML
    private ComboBox cmbType;

    @FXML
    private ComboBox cmbBranch;
    //--------------------------------------------------------------------------
    @FXML
    private LineChart lcGraph;

    //--------------------------------------------------------------------------
    private String account_data_file[][];

    private int accountHandler = 0;

    private double amount;

    private double sold;

    private double available;

    private double purchase;

    private int branch_id = 1;

    private final FormatNumber formatNum = new FormatNumber();

    SimpleDateFormat ft
            = new SimpleDateFormat("MMM dd,  yyyy");

    java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
    //--------------------------------------------------------------------------

    @FXML
    private Pane pStatus;

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
                            setLineGraph();
                            account_data_file = getAccount("" + LocalDate.now().getYear());

                            lblName.setText(account_data_file[accountHandler][0]);
                            lblAddress.setText(account_data_file[accountHandler][1]);
                            lblContact.setText(account_data_file[accountHandler][2]);
                            lblTotalSale.setText(account_data_file[accountHandler][3]);
                            lblDate.setText(account_data_file[accountHandler][4]);
                            lblPosition.setText(account_data_file[accountHandler][7]);

                            if (account_data_file[accountHandler][8].equalsIgnoreCase("Available")) {
                                lblStatus.setText("Available");
                                pStatus.setStyle("-fx-background-color: #00FF00;");
                            }
                            if (!account_data_file[accountHandler][8].equalsIgnoreCase("Available")) {
                                lblStatus.setText("Not Available");
                                pStatus.setStyle("-fx-background-color: #FF0000;");
                            }

                            if (account_data_file[accountHandler][5].contains("null")) {

                                if (account_data_file[accountHandler][6].equalsIgnoreCase("Male")) {
                                    setImage("profile/male-user-profile-picture.png");
                                }
                                if (account_data_file[accountHandler][6].equalsIgnoreCase("Female")) {
                                    setImage("profile/profile-picture-for-social-network.png");
                                }

                            } else {
                                setImage("profile/" + account_data_file[accountHandler][5]);
                            }

                        }
                    }
                    ),
                    new KeyFrame(Duration.seconds(60))
            );
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        lblHead.setText("Dashboard / ");
        btnProduct.setText("Product\n"
                + "Adding new products to your range, and view all product listed( Category, Supplier, Branch)");

        btnTransaction.setText("Transaction\n"
                + "View exchange of goods or services between a buyer and a seller.");

        btnAccounts.setText("Account\n"
                + "Add, update, and delete accounts.");

        btnSales.setText("Sales\n"
                + "View generated sales");
        account_data_file = getAccount("" + LocalDate.now().getYear());

        lblName.setText(account_data_file[0][0]);
        lblAddress.setText(account_data_file[0][1]);
        lblContact.setText(account_data_file[0][2]);
        lblTotalSale.setText(account_data_file[0][3]);
        lblDate.setText(account_data_file[0][4]);
        lblPosition.setText(account_data_file[0][7]);

        if (account_data_file[0][8].equalsIgnoreCase("Available")) {
            lblStatus.setText("Available");
            pStatus.setStyle("-fx-background-color: #00FF00;");
        }
        if (!account_data_file[0][8].equalsIgnoreCase("Available")) {
            lblStatus.setText("Not Available");
            pStatus.setStyle("-fx-background-color: #FF0000;");
        }

        if (account_data_file[0][5].contains("null")) {

            if (account_data_file[0][6].equalsIgnoreCase("Male")) {
                setImage("profile/male-user-profile-picture.png");
            }
            if (account_data_file[0][6].equalsIgnoreCase("Female")) {
                setImage("profile/profile-picture-for-social-network.png");
            }

        } else {
            setImage("profile/" + account_data_file[0][5]);
        }
        //----------------------------------------------------------------------
        ArrayList<String> type = new ArrayList<>();
        type.add("Daily");
        type.add("Weekly");
        type.add("Monthly");
        ObservableList<String> type_list = FXCollections.observableArrayList(type);
        cmbType.setItems(type_list);
        cmbType.setValue(type.get(2));

        //----------------------------------------------------------------------
        ArrayList<String> branch = new ArrayList<>();

        String branch_data[][] = getBranch();
        if (branch_data.length > 0) {
            for (String res[] : branch_data) {
                branch.add(res[1]);
            }
        }

        ObservableList<String> branch_list = FXCollections.observableArrayList(branch);
        cmbBranch.setItems(branch_list);
        cmbBranch.setValue(branch.get(0));

        DashboardFrameData dash = new DashboardFrameData();
        dash.dashboard();

    }

    public void setImage(String imageFile) {
        File file = new File(imageFile);
        Image image = new Image(file.toURI().toString(), 120, 120, false, false, false);
        imgProfile.setImage(image);

    }

    public void setAccountPrev() {
        if (accountHandler == 0) {
            accountHandler = (account_data_file.length);
        }
        accountHandler--;
        lblName.setText(account_data_file[accountHandler][0]);
        lblAddress.setText(account_data_file[accountHandler][1]);
        lblContact.setText(account_data_file[accountHandler][2]);
        lblTotalSale.setText(account_data_file[accountHandler][3]);
        lblDate.setText(account_data_file[accountHandler][4]);
        lblPosition.setText(account_data_file[accountHandler][7]);

        if (account_data_file[accountHandler][8].equalsIgnoreCase("Available")) {
            lblStatus.setText("Available");
            pStatus.setStyle("-fx-background-color: #00FF00;");
        }
        if (!account_data_file[accountHandler][8].equalsIgnoreCase("Available")) {
            lblStatus.setText("Not Available");
            pStatus.setStyle("-fx-background-color: #FF0000;");
        }

        if (account_data_file[accountHandler][5].contains("null")) {

            if (account_data_file[accountHandler][6].equalsIgnoreCase("Male")) {
                setImage("profile/male-user-profile-picture.png");
            }
            if (account_data_file[accountHandler][6].equalsIgnoreCase("Female")) {
                setImage("profile/profile-picture-for-social-network.png");
            }

        } else {
            setImage("profile/" + account_data_file[accountHandler][5]);
        }

    }

    @FXML
    private void Logout() throws IOException {
        String column[] = {"login_status"};
        String values[] = {""};
        setLogout(column, values, Context.getInstance().account_name().getAccountID());
        System.exit(0);

    }

    public void setAccountNext() {
        if (accountHandler == (account_data_file.length - 1)) {
            accountHandler = -1;
        }
        accountHandler++;
        lblName.setText(account_data_file[accountHandler][0]);
        lblAddress.setText(account_data_file[accountHandler][1]);
        lblContact.setText(account_data_file[accountHandler][2]);
        lblTotalSale.setText(account_data_file[accountHandler][3]);
        lblDate.setText(account_data_file[accountHandler][4]);
        lblPosition.setText(account_data_file[accountHandler][7]);

        if (account_data_file[accountHandler][8].equalsIgnoreCase("Available")) {
            lblStatus.setText("Available");
            pStatus.setStyle("-fx-background-color: #00FF00;");
        }
        if (!account_data_file[accountHandler][8].equalsIgnoreCase("Available")) {
            lblStatus.setText("Not Available");
            pStatus.setStyle("-fx-background-color: #FF0000;");
        }

        if (account_data_file[accountHandler][5].contains("null")) {

            if (account_data_file[accountHandler][6].equalsIgnoreCase("Male")) {
                setImage("profile/male-user-profile-picture.png");
            }
            if (account_data_file[accountHandler][6].equalsIgnoreCase("Female")) {
                setImage("profile/profile-picture-for-social-network.png");
            }

        } else {
            setImage("profile/" + account_data_file[accountHandler][5]);
        }

    }

    public void account() throws IOException {
        lblHead.setText("Dashboard / Add account");
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        modal = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/views/Account.fxml"));
        AnchorPane showModal = loader.load();

        modal.setTitle("Stop N' Shop | add account");
        //  adminpane.getIcons().add(new Image("/assets/images/login_header.png"));
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.initStyle(StageStyle.UTILITY);

        modal.initOwner(stage);
        modal.setResizable(false);
        modal.setMinWidth(screenBounds.getWidth() - 50);
        modal.setMinHeight(screenBounds.getHeight() - 200);

        Scene scene = new Scene(showModal);
        modal.setScene(scene);
        //AddAccountController controller = loader.<AddAccountController>getController();
        modal.showAndWait();
        lblHead.setText("Dashboard / ");
    }

    public void product() throws IOException {
        lblHead.setText("Dashboard / Product");
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        modal = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/views/Admin_Product.fxml"));
        AnchorPane showModal = loader.load();

        modal.setTitle("Stop N' Shop | Product");
        //  adminpane.getIcons().add(new Image("/assets/images/login_header.png"));
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.initStyle(StageStyle.UTILITY);

        modal.initOwner(stage);
        modal.setResizable(false);
        modal.setMinWidth(screenBounds.getWidth() - 50);
        modal.setMinHeight(screenBounds.getHeight() - 200);
        Scene scene = new Scene(showModal);
        modal.setScene(scene);

        modal.showAndWait();
        lblHead.setText("Dashboard / ");
    }

    public void transaction() throws IOException {
        lblHead.setText("Dashboard / Transaction");
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        modal = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/views/Transaction_History.fxml"));
        AnchorPane showModal = loader.load();

        modal.setTitle("Stop N' Shop | Transaction");
        //  adminpane.getIcons().add(new Image("/assets/images/login_header.png"));
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.initStyle(StageStyle.UTILITY);

        modal.initOwner(stage);
        modal.setResizable(false);
        modal.setMinWidth(screenBounds.getWidth() - 50);
        modal.setMinHeight(screenBounds.getHeight() - 200);
        Scene scene = new Scene(showModal);
        modal.setScene(scene);

        modal.showAndWait();
        lblHead.setText("Dashboard / ");
    }

    @FXML
    private void sales() throws IOException {
        lblHead.setText("Dashboard / Sales");
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        modal = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/views/Sales_History.fxml"));
        AnchorPane showModal = loader.load();

        modal.setTitle("Stop N' Shop | Transaction");
        //  adminpane.getIcons().add(new Image("/assets/images/login_header.png"));
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.initStyle(StageStyle.UTILITY);

        modal.initOwner(stage);
        modal.setResizable(false);
        modal.setMinWidth(screenBounds.getWidth() - 50);
        modal.setMinHeight(screenBounds.getHeight() - 200);
        Scene scene = new Scene(showModal);
        modal.setScene(scene);

        modal.showAndWait();
        lblHead.setText("Dashboard / ");
    }

    @FXML
    private void setBranchID() {
        branch_id = getBranch_id(cmbBranch.getValue().toString());
        setLineGraph();
    }

    @FXML
    private void setLineGraph() {
        lcGraph.getData().clear();
        Calendar calender = Calendar.getInstance();
        int year = calender.get(Calendar.YEAR);

        lcGraph.setTitle(cmbBranch.getValue() + " graphical presentation in " + year);

        XYChart.Series<String, Number> amount = new XYChart.Series<>();
        XYChart.Series<String, Number> productSold = new XYChart.Series<>();
        XYChart.Series<String, Number> availableProduct = new XYChart.Series<>();
        XYChart.Series<String, Number> TotalPurchase = new XYChart.Series<>();
        String result[][] = getDataGraphTransaction(cmbType.getValue().toString(), "" + LocalDate.now().getYear(), "" + branch_id);
        String result_p[][] = getDataGraphProduct(cmbType.getValue().toString(), "" + LocalDate.now().getYear(), "" + branch_id);
        if (result.length > 0) {
            for (int i = 0; i < result.length; i++) {

                amount.getData().add(new XYChart.Data<>(result[i][2], Double.parseDouble(result[i][1])));
                this.amount += Double.parseDouble(result[i][1]);
                productSold.getData().add(new XYChart.Data<>(result[i][2], Double.parseDouble(result[i][0])));
                this.sold += Double.parseDouble(result[i][0]);

            }
        }
        if (result_p.length > 0) {
            for (int i = 0; i < result_p.length; i++) {

                availableProduct.getData().add(new XYChart.Data<>(result_p[i][2], Double.parseDouble(result_p[i][0])));

                TotalPurchase.getData().add(new XYChart.Data<>(result_p[i][2], Double.parseDouble(result_p[i][1])));

            }
        }
        String res[][] = getAvailableProductTotalCost("" + branch_id);
        this.available += Double.parseDouble(res[0][0]);
        this.purchase += Double.parseDouble(res[0][1]);

        amount.setName("Total amount");
        lcGraph.getData().add(amount);

        productSold.setName("Total product sold");
        lcGraph.getData().add(productSold);

        availableProduct.setName("Available product");
        lcGraph.getData().add(availableProduct);

        TotalPurchase.setName("Total purchase");
        lcGraph.getData().add(TotalPurchase);

        lcGraph.getXAxis().setLabel("Dates");
        lcGraph.getYAxis().setLabel("Philippine pesos value (Php) ");

        //----------------------------------------------------------------------
        lblAmount.setText(formatNum.formatNumbers("Php " + this.amount));
        lblSold.setText(formatNum.formatNumbers("" + this.sold));
        lblAvailable.setText(formatNum.formatNumbers("" + this.available));
        lblPurchase.setText(formatNum.formatNumbers("Php " + this.purchase));
        this.amount = 0;
        this.sold = 0;
        this.available = 0;
        this.purchase = 0;
    }

    public void setUser(String account_name, String branch_name, String branch_id, String account_id, String account_type) {
        Context.getInstance().branch_id().setBranchID(branch_id);
        Context.getInstance().user_id().setAccountID(account_id);
        Context.getInstance().branch_name().setBranchName(branch_name);
        Context.getInstance().account_type().setAccountType(account_type);
        Context.getInstance().account_name().setAccountName(account_name);

    }

}

class AdminUtilies {

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
