/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Colonnello
 */
public class User_info {

    private final SimpleStringProperty branch_id = new SimpleStringProperty("");
    private final SimpleStringProperty account_id = new SimpleStringProperty("");
    private final SimpleStringProperty branch_name = new SimpleStringProperty("");
    private final SimpleStringProperty account_type = new SimpleStringProperty("");
    private final SimpleStringProperty account_name = new SimpleStringProperty("");
    private final SimpleStringProperty supplier_name = new SimpleStringProperty("");
    private final SimpleStringProperty supplier_name_clause = new SimpleStringProperty("");
    private final SimpleStringProperty load_center = new SimpleStringProperty("");
    private String generate_sale[] = {};

    public User_info() {
    }
//------------------------------------------------------------------------------

    public void setBranchID(String value) {
        this.branch_id.set(value);
    }

    public void setAccountID(String value) {
        this.account_id.set(value);
    }

    public void setBranchName(String value) {
        this.branch_name.set(value);
    }

    public void setAccountType(String value) {
        this.account_type.set(value);
    }

    public void setAccountName(String value) {
        this.account_name.set(value);
    }

    public void setSupplierName(String value) {
        this.supplier_name.set(value);
    }

    public void setSupplierNameClause(String value) {
        this.supplier_name_clause.set(value);
    }

    public void setLoadCenter(String value) {
        this.load_center.set(value);
    }

    public void setGenerateSales(String[] value) {
        this.generate_sale = value;
    }
    //------------------------------------------------------------------------------

    public String getBranchID() {
        return this.branch_id.get();
    }

    public String getAccountID() {
        return this.account_id.get();
    }

    public String getBranchName() {
        return this.branch_name.get();
    }

    public String getAccountType() {
        return this.account_type.get();
    }

    public String getAccountName() {
        return this.account_name.get();
    }

    public String getSupplierName() {
        return this.supplier_name.get();
    }

    public String getSupplierNameCaluse() {
        return this.supplier_name_clause.get();
    }
     public String getLoadCenter() {
        return this.load_center.get();
    }

    public String[] getGenerateSales() {
        return this.generate_sale;
    }

}
