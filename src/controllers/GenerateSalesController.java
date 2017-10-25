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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import libs.FormatNumber;
import models.Context;
import models.GenerateSales_Model;

/**
 * FXML Controller class
 *
 * @author Colonnello
 */
public class GenerateSalesController extends GenerateSales_Model implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label lblBranch;

    @FXML
    private Label lblRefID;

    @FXML
    private Label lblAccountName;

    @FXML
    private Label lblCashier;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblProductSold;

    @FXML
    private Label lblAmount;

    @FXML
    private Label lblOwner;

    //--------------------------------------------------------------------------
    public String branchID;

    //--------------------------------------------------------------------------
    Date dNow = new Date();
    SimpleDateFormat ft
            = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat ft_ref
            = new SimpleDateFormat("yyyyMMdd");

    java.text.SimpleDateFormat datetime
            = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    FormatNumber fm = new FormatNumber();

    private String generateListData[];

    private String owner[][];

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tabulate_data();
    }

    private void tabulate_data() {

        int ref_id = get_pk_transactionID();
        String result[][] = getSales(Context.getInstance().user_id().getAccountID(), ft.format(dNow));
        generateListData = new String[7];
        owner = getOwner();
        if (result.length > 0) {

            for (String res[] : result) {
                lblBranch.setText(res[0] + "\n" + res[1] + res[2]);
                branchID = res[0];
                lblRefID.setText(ft_ref.format(dNow) + ref_id);
                lblAccountName.setText(res[3]);
                lblDate.setText(datetime.format(dNow));
                lblProductSold.setText(res[4]);
                lblAmount.setText("Php. " + fm.formatNumbers(res[5]));
                lblOwner.setText(owner[0][1]);
                lblCashier.setText(res[3]);
                //--------------------------------------------------------------

                generateListData[0] = res[6];
                generateListData[1] = lblRefID.getText();
                generateListData[2] = res[7];
                generateListData[3] = lblDate.getText();
                generateListData[4] = lblProductSold.getText();
                generateListData[5] = lblAmount.getText().replace("Php. ", "");
                generateListData[6] = owner[0][0];

            }
            Context.getInstance().user_id().setGenerateSales(generateListData);
        }

    }

}
