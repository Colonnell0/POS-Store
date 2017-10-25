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
public class Transaction_Table_Model {

    private final SimpleStringProperty date;
    private final SimpleStringProperty id;
    private final SimpleStringProperty type;
    private final SimpleDoubleProperty amount;
    private final SimpleStringProperty branch;

    public Transaction_Table_Model(
            String date,
            String id,
            String type,
            double amount,
            String branch) {
        this.date = new SimpleStringProperty(date);
        this.id = new SimpleStringProperty(id);
        this.type = new SimpleStringProperty(type);
        this.amount = new SimpleDoubleProperty(amount);
        this.branch = new SimpleStringProperty(branch);
    }

    //--------------------------------------------------------------------------
    public void setDate(String value) {
        this.date.set(value);
    }

    public void setID(String value) {
        this.id.set(value);
    }

    public void setType(String value) {
        this.type.set(value);
    }

    public void setAmount(double value) {
        this.amount.set(value);
    }

    public void setBranch(String value) {
        this.branch.set(value);
    }

    //--------------------------------------------------------------------------
    public String getDate() {
        return this.date.get();
    }

    public String getID() {
        return this.id.get();
    }

    public String getType() {
        return this.type.get();
    }

    public double getAmount() {
        return this.amount.get();
    }

    public String getBranch() {
        return this.branch.get();
    }
}
