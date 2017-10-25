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
public class Supplier_Table_Model {

    private final SimpleStringProperty productCode;
    private final SimpleStringProperty productName;
    private final SimpleDoubleProperty supplierPrice;
    private final SimpleDoubleProperty srp;
    private final SimpleStringProperty stocks;
    private final SimpleStringProperty sold;
    private final SimpleStringProperty inventory;
    private final SimpleStringProperty qtyUM;

    public Supplier_Table_Model(
            String productCode,
            String productName,
            double supplierPrice,
            double srp,
            String stocks,
            String sold,
            String inventory,
            String qtyUM) {
        this.productCode = new SimpleStringProperty(productCode);
        this.productName = new SimpleStringProperty(productName);
        this.supplierPrice = new SimpleDoubleProperty(supplierPrice);
        this.srp = new SimpleDoubleProperty(srp);
        this.stocks = new SimpleStringProperty(stocks);
        this.sold = new SimpleStringProperty(sold);
        this.inventory = new SimpleStringProperty(inventory);
        this.qtyUM = new SimpleStringProperty(qtyUM);

    }

    public void setProductCode(String productCode) {
        this.productCode.set(productCode);
    }

    public void setProductName(String productName) {
        this.productName.set(productName);
    }

    public void setPrice(double price) {
        this.supplierPrice.set(price);
    }

    public void setSRP(double srp) {
        this.srp.set(srp);
    }

    public void setStocks(String stocks) {
        this.stocks.set(stocks);
    }

    public void setSold(String sold) {
        this.sold.set(sold);
    }

    public void setInventory(String inventory) {
        this.inventory.set(inventory);
    }

    public void setQtyUM(String qtyUM) {
        this.qtyUM.set(qtyUM);
    }

    //--------------------------------------------------------------------------
    public String getProductCode() {
        return this.productCode.get();
    }

    public String getProductName() {
        return this.productName.get();
    }

    public double getPrice() {
        return this.supplierPrice.get();
    }

    public double getSRP() {
        return this.srp.get();
    }

    public String getStocks() {
        return this.stocks.get();
    }

    public String getSold() {
        return this.sold.get();
    }

    public String getInventory() {
        return this.inventory.get();
    }

    public String getQtyUM() {
        return this.qtyUM.get();
    }

}
