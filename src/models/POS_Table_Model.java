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
public class POS_Table_Model {

    private final SimpleStringProperty productCode;
    private final SimpleStringProperty productName;
    private final SimpleDoubleProperty price;
    private final SimpleStringProperty qty;
    private final SimpleDoubleProperty discount;
    private final SimpleDoubleProperty extPrice;

    public POS_Table_Model(String productCode,
            String productName,
            double price,
            String qty,
            double discount,
            double extPrice) {
        this.productCode = new SimpleStringProperty(productCode);
        this.productName = new SimpleStringProperty(productName);
        this.price = new SimpleDoubleProperty(price);
        this.qty = new SimpleStringProperty(qty);
        this.discount = new SimpleDoubleProperty(discount);
        this.extPrice = new SimpleDoubleProperty(extPrice);
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

    public void setQty(String qty) {
        this.qty.set(qty);
    }

    public void setDiscount(double discount) {
        this.discount.set(discount);
    }

    public void setExtPrice(double extPrice) {
        this.extPrice.set(extPrice);
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

    public String getQty() {
        return this.qty.get();
    }

    public double getDiscount() {
        return this.discount.get();
    }

    public double getExtPrice() {
        return this.extPrice.get();
    }
}
