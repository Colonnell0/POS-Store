/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Colonnello
 */
public class Sales_Table_Model {

    private final SimpleStringProperty refID;
    private final SimpleStringProperty branchName;
    private final SimpleStringProperty accountName;
    private final SimpleStringProperty productSold;
    private final SimpleDoubleProperty amount;
    private final SimpleStringProperty date;

    public Sales_Table_Model(
            String refID,
            String branchName,
            String accountName,
            String productSold,
            double amount,
            String date) {
        this.refID = new SimpleStringProperty(refID);
        this.branchName = new SimpleStringProperty(branchName);
        this.accountName = new SimpleStringProperty(accountName);
        this.productSold = new SimpleStringProperty(productSold);
        this.amount = new SimpleDoubleProperty(amount);
        this.date = new SimpleStringProperty(date);
    }

    //--------------------------------------------------------------------------
    public void setRefID(String value) {
        this.refID.set(value);
    }

    public void setBranchName(String value) {
        this.branchName.set(value);
    }

    public void setAccountName(String value) {
        this.accountName.set(value);
    }

    public void setProductSold(String value) {
        this.productSold.set(value);
    }

    public void setAmount(double value) {
        this.amount.set(value);
    }

    public void setDate(String value) {
        this.date.set(value);
    }

    //--------------------------------------------------------------------------
    public String getRefID() {
        return this.refID.get();
    }

    public String getBranchName() {
        return this.branchName.get();
    }

    public String getAccountName() {
        return this.accountName.get();
    }

    public String getProductSold() {
        return this.productSold.get();
    }

    public double getAmount() {
        return this.amount.get();
    }

    public String getDate() {
        return this.date.get();
    }

}
