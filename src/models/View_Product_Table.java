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
public class View_Product_Table {

    private final SimpleStringProperty productCode;
    private final SimpleStringProperty productName;
    private final SimpleDoubleProperty price;
    private final SimpleStringProperty stocks;
    private final SimpleStringProperty order;
    private final SimpleStringProperty status;
    private final SimpleStringProperty update;
    private final SimpleStringProperty delete;

    public View_Product_Table(
            String productCode,
            String productName,
            double price,
            String stocks,
            String order,
            String status,
            String update,
            String delete) {
        this.productCode = new SimpleStringProperty(productCode);
        this.productName = new SimpleStringProperty(productName);
        this.price = new SimpleDoubleProperty(price);
        this.stocks = new SimpleStringProperty(stocks);
        this.order = new SimpleStringProperty(order);
        this.status = new SimpleStringProperty(status);
        this.update = new SimpleStringProperty(update);
        this.delete = new SimpleStringProperty(delete);
    }

    public void setProductCode(String value) {
        this.productCode.set(value);
    }

    public void setProductName(String value) {
        this.productName.set(value);
    }

    public void setPrice(double value) {
        this.price.set(value);
    }

    public void setStocks(String value) {
        this.stocks.set(value);
    }

    public void setOrder(String value) {
        this.stocks.set(value);
    }

    public void setStatus(String value) {
        this.status.set(value);
    }

    public void setUpdate(String value) {
        this.update.set(value);
    }

    public void setDelete(String value) {
        this.delete.set(value);
    }

    //--------------------------------------------------------------------------
    public String getProductCode() {
        return this.productCode.get();
    }

    public String getProductName() {
        return this.productName.get();
    }

    public Double getPrice() {
        return this.price.get();
    }

    public String getStocks() {
        return this.stocks.get();
    }
     public String getOrder() {
        return this.order.get();
    }

    public String getStatus() {
        return this.status.get();
    }

    public String getUpdate() {
        return this.update.get();
    }

    public String getDelete() {
        return this.delete.get();
    }

}
