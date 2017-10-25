/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.sun.javafx.print.PrintHelper;
import com.sun.javafx.print.Units;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterAttributes;
import javafx.print.PrinterJob;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;

/**
 * FXML Controller class
 *
 * @author Colonnello
 */
public class Purchase_Order_ViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public Label lblDate;

    @FXML
    public Label lblAddress;

    @FXML
    public Label lblContact;

    @FXML
    public Label lblSupplierName;

    @FXML
    public Label lblSupplierAddress;

    @FXML
    public Label lblSupplierContact;

    @FXML
    public Label lblNum;

    @FXML
    public Label lblPrCode;

    @FXML
    public Label lblProductName;

    @FXML
    public Label lblQTY;

    @FXML
    public Label lblUnitPrice;

    @FXML
    public Label lblTotal;

    @FXML
    public Label lblSubtotal;

    @FXML
    private AnchorPane node;
    
    
     final KeyCombination kb = new KeyCodeCombination(KeyCode.P, KeyCombination.CONTROL_DOWN);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void print(KeyEvent event) {
      if(kb.match(event)){
            Paper photo = PrintHelper.createPaper("10x15", 8.5, 11, Units.INCH);

        Printer printer = Printer.getDefaultPrinter();
        PageLayout pageLayout
                = printer.createPageLayout(photo, PageOrientation.PORTRAIT, Printer.MarginType.HARDWARE_MINIMUM);
        PrinterAttributes attr = printer.getPrinterAttributes();
        PrinterJob job = PrinterJob.createPrinterJob();
        double scaleX
                = pageLayout.getPrintableWidth() / 650;
        double scaleY
                = pageLayout.getPrintableHeight() / 750;
        Scale scale = new Scale(scaleX, scaleY);
        node.getTransforms().add(scale);

        if (job != null && job.showPrintDialog(node.getScene().getWindow())) {
            boolean success = job.printPage(pageLayout, node);
            if (success) {
                job.endJob();

            }
        }
        node.getTransforms().remove(scale);
      }
    }

}
