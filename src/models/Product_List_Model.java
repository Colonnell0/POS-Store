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
public class Product_List_Model {

    private final SimpleStringProperty productCode;
    private final SimpleStringProperty productName;
    private final SimpleDoubleProperty price;
    private final SimpleDoubleProperty sold;
    private final SimpleStringProperty number;
    private final SimpleStringProperty accountName;

    public Product_List_Model(
            String productCode,
            String productName,
            double price,
            double sold,
            String number,
            String accountName) {
        this.productCode = new SimpleStringProperty(productCode);
        this.productName = new SimpleStringProperty(productName);
        this.price = new SimpleDoubleProperty(price);
        this.sold = new SimpleDoubleProperty(sold);
        this.number = new SimpleStringProperty(number);
        this.accountName = new SimpleStringProperty(accountName);
    }

    public void setProductCode(String productCode) {
        this.productCode.set(productCode);
    }

    public void setProductName(String productName) {
        this.productName.set(productName);
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public void setSold(double sold) {
        this.sold.set(sold);
    }

    public void setNumber(String number) {
        this.number.set(number);
    }
    public void setAccountName(String accountName){
        this.accountName.set(accountName);
    }

    //--------------------------------------------------------------------------
    public String getProductCode() {
        return this.productCode.get();
    }

    public String getProductName() {
        return this.productName.get();
    }

    public double getPrice() {
        return this.price.get();
    }

    public double getSold() {
        return this.sold.get();
    }

    public String getNumber() {
        return this.number.get();
    }
    public String getAccountName(){
        return this.accountName.get();
    }
}
