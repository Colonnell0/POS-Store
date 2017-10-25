/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Colonnello
 */
public class Stack_Summary_Model {

    private final SimpleIntegerProperty productCode;
    private final SimpleStringProperty productName;
    private final SimpleDoubleProperty sellingPrice;
    private final SimpleDoubleProperty sold;
    private final SimpleDoubleProperty number;

    public Stack_Summary_Model(
            int productCode,
            String productName,
            double sellingPrice,
            double sold,
            double number
    ) {

        this.productCode = new SimpleIntegerProperty(productCode);
        this.productName = new SimpleStringProperty(productName);
        this.sellingPrice = new SimpleDoubleProperty(sellingPrice);
        this.sold = new SimpleDoubleProperty(sold);
        this.number = new SimpleDoubleProperty(number);

    }

    public void setProductCode(int productCode) {
        this.productCode.set(productCode);

    }

    public void setProductName(String productName) {
        this.productName.set(productName);
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice.set(sellingPrice);
    }

    public void setSold(double sold) {
        this.sold.set(sold);
    }

    public void setNumber(double number) {
        this.number.set(number);
    }

    //--------------------------------------------------------------------------
    public int getProductCode() {
        return this.productCode.get();
    }

    public String getProductName() {
        return this.productName.get();
    }

    public double getSellingPrice() {
        return this.sellingPrice.get();
    }

    public double getSold() {
        return this.sold.get();
    }

    public double getNumber() {
        return this.number.get();
    }

}
