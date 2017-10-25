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
public class Sales_History_Table_Model {

    private final SimpleStringProperty productCode;
    private final SimpleStringProperty productName;
    private final SimpleStringProperty stocks;
    private final SimpleStringProperty sold;
    private final SimpleDoubleProperty amount;
    private final SimpleStringProperty accountName;
    private final SimpleStringProperty date;

    public Sales_History_Table_Model(
            String productCode,
            String productName,
            String stocks,
            String sold,
            double amount,
            String accountName,
            String date) {
        this.productCode = new SimpleStringProperty(productCode);
        this.productName = new SimpleStringProperty(productName);
        this.stocks = new SimpleStringProperty(stocks);
        this.sold = new SimpleStringProperty(sold);
        this.amount = new SimpleDoubleProperty(amount);
        this.accountName = new SimpleStringProperty(accountName);
        this.date = new SimpleStringProperty(date);

    }

    public void setProductCode(String value) {
        this.productCode.setValue(value);
    }

    public void setProductName(String value) {
        this.productName.setValue(value);
    }

    public void setStocks(String value) {
        this.stocks.setValue(value);
    }

    public void setSold(String value) {
        this.sold.setValue(value);
    }

    public void setAmount(double value) {
        this.amount.setValue(value);
    }

    public void setAccountName(String value) {
        this.accountName.setValue(value);
    }

    public void setDate(String value) {
        this.date.setValue(value);
    }

    //--------------------------------------------------------------------------
    public String getProductCode() {
        return this.productCode.get();
    }

    public String getProductName() {
        return this.productName.get();
    }

    public String getStocks() {
        return this.stocks.get();
    }

    public String getSold() {
        return this.sold.get();
    }

    public double getAmount() {
        return this.amount.get();
    }

    public String getAccountName() {
        return this.accountName.get();
    }

    public String getDate() {
        return this.date.get();
    }

}
