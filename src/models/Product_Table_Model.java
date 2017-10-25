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
public class Product_Table_Model {

    private final SimpleStringProperty productCode;
    private final SimpleStringProperty productName;
    private final SimpleStringProperty supplier;
    private final SimpleDoubleProperty supplierPrice;
    private final SimpleDoubleProperty sellingRetailPrice;
    private final SimpleStringProperty stocks;
    private final SimpleStringProperty sold;
    private final SimpleStringProperty inventory;
    private final SimpleStringProperty order;
    private final SimpleStringProperty category;
    private final SimpleStringProperty expirationDate;
    private final SimpleStringProperty date;
    private final SimpleStringProperty accountName;

    public Product_Table_Model(
            String productCode,
            String productName,
            String supplier,
            double supplierPrice,
            double sellingRetailPrice,
            String stocks,
            String sold,
            String inventory,
            String order,
            String category,
            String expirationDate,
            String date,
            String accountName) {
        this.productCode = new SimpleStringProperty(productCode);
        this.productName = new SimpleStringProperty(productName);
        this.supplier = new SimpleStringProperty(supplier);
        this.supplierPrice = new SimpleDoubleProperty(supplierPrice);
        this.sellingRetailPrice = new SimpleDoubleProperty(sellingRetailPrice);
        this.stocks = new SimpleStringProperty(stocks);
        this.sold = new SimpleStringProperty(sold);
        this.inventory = new SimpleStringProperty(inventory);
        this.order = new SimpleStringProperty(order);
        this.category = new SimpleStringProperty(category);
        this.expirationDate = new SimpleStringProperty(expirationDate);
        this.date = new SimpleStringProperty(date);
        this.accountName = new SimpleStringProperty(accountName);

    }

    public void setProductCode(String productCode) {
        this.productCode.set(productCode);

    }

    public void setProductName(String productName) {
        this.productName.set(productName);
    }

    public void setSupplier(String supplier) {
        this.supplier.set(supplier);
    }

    public void setSupplierPrice(double supplierPrice) {
        this.supplierPrice.set(supplierPrice);
    }

    public void setSellingRetailPrice(double sellingRetailPrice) {
        this.sellingRetailPrice.set(sellingRetailPrice);
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

    public void setOrder(String order) {
        this.order.set(order);
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate.set(expirationDate);
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public void setAccountName(String accountName) {
        this.accountName.set(accountName);
    }

    //--------------------------------------------------------------------------
    public String getProductCode() {
        return this.productCode.get();
    }

    public String getProductName() {
        return this.productName.get();
    }

    public String getSupplier() {
        return this.supplier.get();
    }

    public double getSupplierPrice() {
        return this.supplierPrice.get();
    }

    public double getSellingRetailPrice() {
        return this.sellingRetailPrice.get();
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

    public String getOrder() {
        return this.order.get();
    }

    public String getCategory() {
        return this.category.get();
    }

    public String getExpirationDate() {
        return this.expirationDate.get();
    }

    public String getDate() {
        return this.date.get();
    }

    public String getAccountName() {
        return this.accountName.get();
    }

}
