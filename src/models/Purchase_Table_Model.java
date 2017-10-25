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
public class Purchase_Table_Model {

    private final SimpleStringProperty productCode;
    private final SimpleStringProperty productName;
    private final SimpleStringProperty supplierName;
    private final SimpleDoubleProperty supplierPrice;
    private final SimpleStringProperty qtyUM;
    private final SimpleDoubleProperty total;

    public Purchase_Table_Model(
            String productCode,
            String productName,
            String supplierName,
            double supplierPrice,
            String qtyUM,
            double total) {
        this.productCode = new SimpleStringProperty(productCode);
        this.productName = new SimpleStringProperty(productName);
        this.supplierName = new SimpleStringProperty(supplierName);
        this.supplierPrice = new SimpleDoubleProperty(supplierPrice);
        this.qtyUM = new SimpleStringProperty(qtyUM);
        this.total = new SimpleDoubleProperty(total);

    }

    public void setProductCode(String value) {
        this.productCode.set(value);
    }

    public void setProductName(String value) {
        this.productName.set(value);
    }

    public void setSupplierName(String value) {
        this.supplierName.set(value);
    }

    public void setSupplierPrice(double value) {
        this.supplierPrice.set(value);
    }

    public void setQtyUM(String value) {
        this.qtyUM.set(value);
    }

    public void setTotal(double value) {
        this.total.set(value);
    }

    //--------------------------------------------------------------------------
    public String getProductCode() {
        return this.productCode.get();
    }

    public String getProductName() {
        return this.productName.get();
    }

    public String getSupplierName() {
        return this.supplierName.get();
    }

    public double getSupplierPrice() {
        return this.supplierPrice.get();
    }

    public String getQtyUM() {
        return this.qtyUM.get();
    }

    public double getTotal() {
        return this.total.get();
    }

}
