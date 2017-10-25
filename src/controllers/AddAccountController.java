/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.Main.stage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import libs.FormValidation;
import libs.Hash;
import models.Account_Model;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author Colonnello
 */
public class AddAccountController extends Account_Model implements Initializable {

    @FXML
    private AnchorPane pane;
    //--------------------------------------------------------------------------
    @FXML
    public TextField txtStreet;

    @FXML
    public TextField txtBarangay;

    @FXML
    public TextField txtCity;

    @FXML
    public TextField txtProvince;

    @FXML
    public TextField txtContact;

    @FXML
    public TextField txtUsername;

    @FXML
    public PasswordField txtPassword;

    @FXML
    public TextField txtMI;

    @FXML
    public TextField txtFirstname;

    @FXML
    public TextField txtLastname;
    //--------------------------------------------------------------------------

    @FXML
    private Label lblStreet;

    @FXML
    private Label lblBarangay;

    @FXML
    private Label lblCity;

    @FXML
    private Label lblProvince;

    @FXML
    private Label lblFirstname;

    @FXML
    private Label lblMI;

    @FXML
    private Label lblLastname;


    @FXML
    private Label lblGender;

    @FXML
    private Label lblUsernameError;

    @FXML
    private Label lblPasswordError;

    //--------------------------------------------------------------------------
    @FXML
    public Button btnSubmit;
    //--------------------------------------------------------------------------
    @FXML
    public RadioButton radioMale;

    @FXML
    private ToggleGroup groupGender;

    @FXML
    public RadioButton radioFemale;

    //--------------------------------------------------------------------------
    @FXML
    public ComboBox cmbAccountType;

    @FXML
    public ComboBox cmbAccountStatus;

    @FXML
    public ComboBox cmbBranch;
    //--------------------------------------------------------------------------

    @FXML
    public ImageView imgProfile;
    //--------------------------------------------------------------------------

    private String[][] branch;

    private String[][] account_type;

    final FileChooser fileChooser = new FileChooser();

    private String imgHandlerError = "NOT";

    private String path;

    private File file;

    public String fileName = null;

    public String accountID;

   java.sql.Timestamp dt = new java.sql.Timestamp(new java.util.Date().getTime());

    java.text.SimpleDateFormat datetime
            = new java.text.SimpleDateFormat("yyyy-MM-dd");

    FormValidation formVal = new FormValidation();
    Hash hash = new Hash();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<String> status = new ArrayList<>();
        status.add("Enable");
        status.add("Disable");

        ObservableList<String> status_list = FXCollections.observableArrayList(status);
        cmbAccountStatus.setItems(status_list);
        cmbAccountStatus.setValue("Enable");
        //----------------------------------------------------------------------
        radioMale.setUserData("Male");
        radioFemale.setUserData("Female");
        //----------------------------------------------------------------------
        ArrayList<String> a = new ArrayList<>();

        account_type = getAcccounType();
        if (account_type.length > 0) {
            for (String res[] : account_type) {
                a.add(res[1]);
            }
        }

        ObservableList<String> account_type_list = FXCollections.observableArrayList(a);
        cmbAccountType.setItems(account_type_list);
        cmbAccountType.setValue("Cashier");
        //----------------------------------------------------------------------
        ArrayList<String> b = new ArrayList<>();
        branch = getBranch();
        if (branch.length > 0) {
            for (String res[] : branch) {
                b.add(res[1]);
            }
        }
        ObservableList<String> branch_list = FXCollections.observableArrayList(b);
        cmbBranch.setItems(branch_list);
        cmbBranch.setValue(b.get(0));

        //----------------------------------------------------------------------
        String barangay[][] = getBarangay();
        if (barangay.length > 0) {
            String list[] = new String[barangay.length];
            for (int i = 0; i < barangay.length; i++) {
                list[i] = barangay[i][1];
            }
            TextFields.bindAutoCompletion(txtBarangay, list);
        }
        //----------------------------------------------------------------------
        String city[][] = getCity();
        if (city.length > 0) {
            String list[] = new String[city.length];
            for (int i = 0; i < city.length; i++) {
                list[i] = city[i][1];
            }
            TextFields.bindAutoCompletion(txtCity, list);
        }
        //----------------------------------------------------------------------
        String province[][] = getProvince();
        if (province.length > 0) {
            String list[] = new String[province.length];
            for (int i = 0; i < province.length; i++) {
                list[i] = province[i][1];
            }
            TextFields.bindAutoCompletion(txtProvince, list);
        }

    }

    @FXML
    private void submit(MouseEvent event) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {

        if (btnSubmit.getText().equalsIgnoreCase("Delete")) {

            if (!(cmbAccountType.getValue().toString().equalsIgnoreCase("Admin") || cmbAccountType.getValue().toString().equalsIgnoreCase("Owner"))) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete this account!");
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.setStyle(" -fx-font-size: 15px;\n"
                        + "   -fx-font-weight: bold;"
                        + "   -fx-text-fill: red;");
                String column[] = {"account_status"};
                String values[] = {"Delete"};

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    setAccountStatus(column, values, accountID);
                    Stage stage = (Stage) pane.getScene().getWindow();

                    stage.close();
                }
            }
            if (cmbAccountType.getValue().toString().equalsIgnoreCase("Admin") || cmbAccountType.getValue().toString().equalsIgnoreCase("Owner")) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("You cannot delete admin or owner account!");
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.setStyle(" -fx-font-size: 15px;\n"
                        + "   -fx-font-weight: bold;"
                        + "   -fx-text-fill: red;");

                Optional<ButtonType> result = alert.showAndWait();
            }
        }
        if (btnSubmit.getText().equalsIgnoreCase("Submit")) {
            if (getFirstname()
                    & getMI()
                    & getLastname()
                    & getStreet()
                    & getBarangayError()
                    & getCityError()
                    & getProvinceError()
                    & getGender()
                    & getContact()
                    & getUsernameError()
                    & getPassword()) {
                int account_type_id = 0;
                int branch_id = 0;
                String mi = "";
                String path = "null";

                for (String res[] : account_type) {
                    if (res[1].equalsIgnoreCase(cmbAccountType.getValue().toString())) {
                        account_type_id = Integer.parseInt(res[0]);
                        break;
                    }
                }
                for (String res[] : branch) {
                    if (res[1].equalsIgnoreCase(cmbBranch.getValue().toString())) {
                        branch_id = Integer.parseInt(res[0]);
                    }
                }
                if (!txtMI.getText().isEmpty()) {
                    mi = txtMI.getText().substring(0).toUpperCase();
                }
                if (imgHandlerError.equals("OK")) {
                    SaveFile((getAccountID() + 1) + ". " + txtFirstname.getText() + ".png", file);
                    path = (getAccountID() + 1) + ". " + txtFirstname.getText() + ".png";
                }

                String column[] = {
                    "account_id",
                    "account_type_id",
                    "branch_id",
                    "account_username",
                    "account_password",
                    "account_firstname",
                    "account_middle_initial",
                    "account_lastname",
                    "account_gender",
                    "account_street",
                    "account_barangay",
                    "account_city_municipality",
                    "account_province",
                    "account_contact",
                    "account_date",
                    "account_status",
                    "login_status",
                    "account_pic_filename",
                    "account_key"};

                String values[] = {
                    "" + (getAccountID() + 1),
                    "" + account_type_id,
                    "" + branch_id,
                    txtUsername.getText(),
                    hash.hash(txtPassword.getText()),
                    txtFirstname.getText().substring(0, 1).toUpperCase() + txtFirstname.getText().substring(1),
                    mi,
                    txtLastname.getText().substring(0, 1) + txtLastname.getText().substring(1),
                    groupGender.getSelectedToggle().getUserData().toString(),
                    txtStreet.getText().substring(0, 1).toUpperCase() + txtStreet.getText().substring(1),
                    txtBarangay.getText().substring(0, 1).toUpperCase() + txtBarangay.getText().substring(1),
                    txtCity.getText().substring(0, 1).toUpperCase() + txtCity.getText().substring(1),
                    txtProvince.getText().substring(0, 1).toUpperCase() + txtProvince.getText().substring(1),
                    txtContact.getText(),
                    datetime.format(dt),
                    cmbAccountStatus.getValue().toString(),
                    "N/A",
                    getAccountID() + 1 + path,
                    "FMbJpSusGJYCxydXRezxjQ== - v99xUxa77O - fZqnJ7sWV0 - X98RXrsDTZ - oIftz76VYT - 7ZBt80ioNO - BjQzR5DTnA"};

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("Successfully register!");
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.setStyle(" -fx-font-size: 15px;\n"
                        + "   -fx-font-weight: bold;"
                        + "   -fx-text-fill: red;");
                Optional<ButtonType> result = alert.showAndWait();

                setAccount(column, values);

                Stage stage = (Stage) pane.getScene().getWindow();

                stage.close();

            }
        }
        if (btnSubmit.getText().equalsIgnoreCase("Update")) {

            if (getFirstname()
                    & getMI()
                    & getLastname()
                    & getStreet()
                    & getBarangayError()
                    & getCityError()
                    & getProvinceError()
                    & getGender()
                    & getContact()) {
                int account_type_id = 0;
                int branch_id = 0;
                String mi = "";
                String path = null;

                for (String res[] : account_type) {
                    if (res[1].equalsIgnoreCase(cmbAccountType.getValue().toString())) {
                        account_type_id = Integer.parseInt(res[0]);
                        break;
                    }
                }
                for (String res[] : branch) {
                    if (res[1].equalsIgnoreCase(cmbBranch.getValue().toString())) {
                        branch_id = Integer.parseInt(res[0]);
                    }
                }
                if (!txtMI.getText().isEmpty()) {
                    mi = txtMI.getText().substring(0).toUpperCase();
                }
                if (imgHandlerError.equals("OK")) {
                    SaveFile((getPicFilename(accountID) + 1) + ". " + txtFirstname.getText() + ".png", file);
                    path = (getPicFilename(accountID) + 1) + ". " + txtFirstname.getText() + ".png";
                    path = path.replaceAll("profile/", "");

                }
                if (!imgHandlerError.equals("OK")) {

                    path = fileName;
                    path = path.replaceAll("profile/", "");

                }

                if (txtPassword.getText().isEmpty()) {
                    String column[] = {
                        "account_type_id",
                        "branch_id",
                        "account_firstname",
                        "account_middle_initial",
                        "account_lastname",
                        "account_gender",
                        "account_street",
                        "account_barangay",
                        "account_city_municipality",
                        "account_province",
                        "account_contact",
                        "account_status",
                        "account_pic_filename",
                        "account_key"};

                    String values[] = {
                        "" + account_type_id,
                        "" + branch_id,
                        txtFirstname.getText().substring(0, 1).toUpperCase() + txtFirstname.getText().substring(1),
                        mi,
                        txtLastname.getText().substring(0, 1) + txtLastname.getText().substring(1),
                        groupGender.getSelectedToggle().getUserData().toString(),
                        txtStreet.getText().substring(0, 1).toUpperCase() + txtStreet.getText().substring(1),
                        txtBarangay.getText().substring(0, 1).toUpperCase() + txtBarangay.getText().substring(1),
                        txtCity.getText().substring(0, 1).toUpperCase() + txtCity.getText().substring(1),
                        txtProvince.getText().substring(0, 1).toUpperCase() + txtProvince.getText().substring(1),
                        txtContact.getText(),
                        cmbAccountStatus.getValue().toString(),
                        path,
                        "FMbJpSusGJYCxydXRezxjQ== - v99xUxa77O - fZqnJ7sWV0 - X98RXrsDTZ - oIftz76VYT - 7ZBt80ioNO - BjQzR5DTnA"};
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle(null);
                    alert.setHeaderText(null);
                    alert.setContentText("Are you sure you want to update this account!");
                    DialogPane dialogPane = alert.getDialogPane();
                    dialogPane.setStyle(" -fx-font-size: 15px;\n"
                            + "   -fx-font-weight: bold;"
                            + "   -fx-text-fill: red;");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        setUpdateAccount(column, values, accountID);
                        Stage stage = (Stage) pane.getScene().getWindow();

                        stage.close();
                    }

                }
                if (!txtPassword.getText().isEmpty()) {
                    String column[] = {
                        "account_type_id",
                        "branch_id",
                        "account_password",
                        "account_firstname",
                        "account_middle_initial",
                        "account_lastname",
                        "account_gender",
                        "account_street",
                        "account_barangay",
                        "account_city_municipality",
                        "account_province",
                        "account_contact",
                        "account_status",
                        "account_pic_filename",
                        "account_key"};

                    String values[] = {
                        "" + account_type_id,
                        "" + branch_id,
                        hash.hash(txtPassword.getText()),
                        txtFirstname.getText().substring(0, 1).toUpperCase() + txtFirstname.getText().substring(1),
                        mi,
                        txtLastname.getText().substring(0, 1) + txtLastname.getText().substring(1),
                        groupGender.getSelectedToggle().getUserData().toString(),
                        txtStreet.getText().substring(0, 1).toUpperCase() + txtStreet.getText().substring(1),
                        txtBarangay.getText().substring(0, 1).toUpperCase() + txtBarangay.getText().substring(1),
                        txtCity.getText().substring(0, 1).toUpperCase() + txtCity.getText().substring(1),
                        txtProvince.getText().substring(0, 1).toUpperCase() + txtProvince.getText().substring(1),
                        txtContact.getText(),
                        cmbAccountStatus.getValue().toString(),
                        path,
                        "FMbJpSusGJYCxydXRezxjQ== - v99xUxa77O - fZqnJ7sWV0 - X98RXrsDTZ - oIftz76VYT - 7ZBt80ioNO - BjQzR5DTnA"};
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle(null);
                    alert.setHeaderText(null);
                    alert.setContentText("Are you sure you want to update this account!");
                    DialogPane dialogPane = alert.getDialogPane();
                    dialogPane.setStyle(" -fx-font-size: 15px;\n"
                            + "   -fx-font-weight: bold;"
                            + "   -fx-text-fill: red;");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        setUpdateAccount(column, values, accountID);
                        Stage stage = (Stage) pane.getScene().getWindow();

                        stage.close();
                    }
                }

            }
        }

    }

    @FXML
    private void setViewCloseClick(MouseEvent event) {
        Stage stage = (Stage) pane.getScene().getWindow();

        stage.close();

    }

    @FXML
    private void setViewClose(KeyEvent event) {
        if (event.getCode() == KeyCode.ESCAPE) {
            Stage stage = (Stage) pane.getScene().getWindow();

            stage.close();
        }

    }

    @FXML
    private void setImageFileChooser() {
        configureFileChooser(fileChooser);
        List<File> list
                = fileChooser.showOpenMultipleDialog(stage);
        if (list != null) {
            if (list.toString().contains("jpg") | list.toString().contains("JPG") | list.toString().contains("png") | list.toString().contains("PNG")) {
                for (File file : list) {
                    this.file = file;
                    Image image = new Image(file.toURI().toString(), 120, 120, false, false);
                    imgProfile.setImage(image);
                    imgProfile.setFitHeight(120);
                    imgProfile.setFitWidth(120);
                    imgHandlerError = "OK";

                }
            } else {
                imgHandlerError = "NOT";
            }

        }
    }

    private static void configureFileChooser(
            final FileChooser fileChooser) {
        fileChooser.setTitle("Open");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );

    }

    private void SaveFile(String content, File file) throws IOException {
        Scanner in = new Scanner(new FileReader("ip.txt"));
        String holder;
        ArrayList<String> path = new ArrayList<>();
        while (in.hasNext()) {
            path.add(in.next());
        }

        Path target = Paths.get(path.get(1).replace("path=", ""), content);
        Files.copy(file.toPath(), target);
    }

    //--------------------------------------------------------------------------
    @FXML
    private boolean getFirstname() {
        boolean tf = false;
        if (formVal.minLength(txtFirstname.getText().length(), 2)) {
            tf = true;
            setFillBlack(txtFirstname);
            setFillBlack(lblFirstname);
        } else {
            setFillRed(txtFirstname);
            setFillRed(lblFirstname);
            tf = false;
        }
        return tf;
    }

    @FXML
    private boolean getMI() {
        boolean tf = false;
        if (formVal.maxLength(txtMI.getText().length(), 1)) {
            tf = true;
            setFillBlack(txtMI);
            setFillBlack(lblMI);
        } else {
            setFillRed(txtMI);
            setFillRed(lblMI);
            tf = false;
        }
        return tf;
    }

    @FXML
    private boolean getLastname() {
        boolean tf = false;
        if (formVal.minLength(txtLastname.getText().length(), 2)) {
            tf = true;
            setFillBlack(txtLastname);
            setFillBlack(lblLastname);
        } else {
            setFillRed(txtLastname);
            setFillRed(lblLastname);
            tf = false;
        }
        return tf;
    }

    @FXML
    private boolean getStreet() {
        boolean tf = false;
        if (formVal.minLength(txtStreet.getText().length(), 3)) {
            tf = true;
            setFillBlack(txtStreet);
            setFillBlack(lblStreet);
        } else {
            setFillRed(txtStreet);
            setFillRed(lblStreet);
            tf = false;
        }
        return tf;
    }

    @FXML
    private boolean getBarangayError() {
        boolean tf = false;
        if (formVal.minLength(txtBarangay.getText().length(), 3)) {
            tf = true;
            setFillBlack(txtBarangay);
            setFillBlack(lblBarangay);
        } else {
            setFillRed(txtBarangay);
            setFillRed(lblBarangay);
            tf = false;
        }
        return tf;
    }

    @FXML
    private boolean getCityError() {
        boolean tf = false;
        if (formVal.minLength(txtCity.getText().length(), 3)) {
            tf = true;
            setFillBlack(txtCity);
            setFillBlack(lblCity);
        } else {
            setFillRed(txtCity);
            setFillRed(lblCity);
            tf = false;
        }
        return tf;
    }

    @FXML
    private boolean getProvinceError() {
        boolean tf = false;
        if (formVal.minLength(txtProvince.getText().length(), 3)) {
            tf = true;
            setFillBlack(txtProvince);
            setFillBlack(lblProvince);
        } else {
            setFillRed(txtProvince);
            setFillRed(lblProvince);
            tf = false;
        }
        return tf;
    }

    @FXML
    private boolean getGender() {
        boolean tf = false;
        if (radioMale.isSelected() || radioFemale.isSelected()) {
            tf = true;
            lblGender.setText("");
            setFillBlack(lblGender);
            setFillBlack(radioMale);
            setFillBlack(radioFemale);

        } else {
            lblGender.setText("*");
            setFillRed(lblGender);
            setFillRed(radioMale);
            setFillRed(radioFemale);

            tf = false;
        }
        return tf;
    }

    @FXML
    private boolean getContact() {
        boolean tf = false;
        if (formVal.minLength(txtContact.getText().length(), 7)) {
            tf = true;
            setFillBlack(txtContact);

        } else {
            setFillRed(txtContact);

            tf = false;
        }
        return tf;
    }

    @FXML
    private boolean getUsernameError() {
        boolean tf = false;
        if (formVal.minLength(txtUsername.getText().length(), 5) & formVal.maxLength(txtUsername.getText().length(), 12)) {

            if (getUsername(txtUsername.getText())) {
                setFillRed(txtUsername);
                setFillRed(lblUsernameError);
                lblUsernameError.setText("*already taken.");
                tf = false;
            } else {
                tf = true;
                setFillBlack(txtUsername);
                setFillBlack(lblUsernameError);
                lblUsernameError.setText("");
            }

        } else {
            setFillRed(txtUsername);
            setFillRed(lblUsernameError);
            lblUsernameError.setText("*min length 5 and max length 12");
            tf = false;
        }
        return tf;
    }

    @FXML
    private boolean getPassword() {
        boolean tf = false;
        if (formVal.minLength(txtPassword.getText().length(), 8)) {
            tf = true;
            lblPasswordError.setText("");
            setFillBlack(lblPasswordError);
            setFillBlack(txtPassword);

        } else {
            lblPasswordError.setText("*min length 8");
            setFillRed(lblPasswordError);
            setFillRed(txtPassword);

            tf = false;
        }
        return tf;
    }

    private void setFillBlack(Control name) {
        name.setStyle("-fx-text-fill: #000000;");

    }

    private void setFillRed(Control name) {
        name.setStyle("-fx-text-fill: #FF0000;");

    }

    public void setImage(String imageFile, String fileName) {
        File file = new File(imageFile);
        Image image = new Image(file.toURI().toString(), 120, 120, false, false, false);
        imgProfile.setImage(image);
        this.fileName = fileName;

    }

}
