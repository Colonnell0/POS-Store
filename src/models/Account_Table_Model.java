/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Colonnello
 */
public class Account_Table_Model {

    private final SimpleIntegerProperty accountID;
    private final SimpleStringProperty position;
    private final SimpleStringProperty name;
    private final SimpleStringProperty gender;
    private final SimpleStringProperty address;
    private final SimpleStringProperty contact;
    private final SimpleStringProperty branch;
    private final SimpleStringProperty date;
    private final SimpleStringProperty update;
    private final SimpleStringProperty delete;

    public Account_Table_Model(
            int accountID,
            String position,
            String name,
            String gender,
            String address,
            String contact,
            String branch,
            String date,
            String update,
            String delete) {
        this.accountID = new SimpleIntegerProperty(accountID);
        this.position = new SimpleStringProperty(position);
        this.name = new SimpleStringProperty(name);
        this.gender = new SimpleStringProperty(gender);
        this.address = new SimpleStringProperty(address);
        this.contact = new SimpleStringProperty(contact);
        this.branch = new SimpleStringProperty(branch);
        this.date = new SimpleStringProperty(date);
        this.update = new SimpleStringProperty(update);
        this.delete = new SimpleStringProperty(delete);

    }

    //--------------------------------------------------------------------------
    public void setAccountID(int value) {
        this.accountID.set(value);
    }

    public void setPosition(String value) {
        this.position.set(value);
    }

    public void setName(String value) {
        this.name.set(value);
    }

    public void setGender(String value) {
        this.gender.set(value);
    }

    public void setAddress(String value) {
        this.position.set(value);
    }

    public void setContact(String value) {
        this.contact.set(value);
    }

    public void setBranch(String value) {
        this.position.set(value);
    }

    public void getDate(String value) {
        this.date.set(value);
    }

    public void setUpdate(String value) {
        this.position.set(value);
    }

    public void setDelete(String value) {
        this.position.set(value);
    }

    //--------------------------------------------------------------------------
    public int getAccountID() {
        return this.accountID.get();
    }

    public String getPosition() {
        return this.position.get();
    }

    public String getName() {
        return this.name.get();
    }

    public String getGender() {
        return this.gender.get();
    }

    public String getAddress() {
        return this.address.get();
    }

    public String getContact() {
        return this.contact.get();
    }

    public String getBranch() {
        return this.branch.get();
    }

    public String getDate() {
        return this.date.get();
    }

    public String getUpdate() {
        return this.update.get();
    }

    public String getDelete() {
        return this.delete.get();
    }

}
