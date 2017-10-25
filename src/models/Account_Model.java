/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import libs.Database;

/**
 *
 * @author Colonnello
 */
public class Account_Model extends Database {

    protected String[][] getAcccounType() {
        String column[] = {"account_type_id", "account_type_name"};
        String result[][] = SELECT(column, "account_types", column, "", "", "");

        return result;
    }

    protected String[][] getBranch() {
        String column[] = {"branch_id", "branch_name"};
        String result[][] = SELECT(column, "branch", column, "", "", "");

        return result;
    }

    protected void setAccount(String column[], String values[]) {
        INSERT("accounts", column, values);

    }

    protected int getAccountID() {
        int num;
        String column[] = {"MAX(account_id)",
            "account_type_id"};
        String result[][] = SELECT(column, "accounts", column, "", "", "");
        num = Integer.parseInt(result[0][0]);

        return num;
    }

    protected int getPicFilename(String id) {
        int num;
        String temp_name;
        String column[] = {"account_id",
            "account_pic_filename"};
        String result[][] = SELECT(column, "accounts", column, "", "WHERE account_id = '" + id + "'", "");
        temp_name = result[0][1].replaceAll("[^\\d.]", "");
        temp_name = temp_name.replaceAll("\\.", "");
        num = Integer.parseInt(temp_name);

        return num;
    }

    protected String[][] getBarangay() {
        String column[] = {"barangay_id", "barangay"};
        String result[][] = SELECT(column, "barangay", column, "", "", "");

        return result;
    }

    protected String[][] getCity() {
        String column[] = {"city_id", "city"};
        String result[][] = SELECT(column, "cities", column, "", "", "");

        return result;
    }

    protected String[][] getProvince() {
        String column[] = {"province_id", "province"};
        String result[][] = SELECT(column, "provinces", column, "", "", "");

        return result;
    }

    protected boolean getUsername(String username) {
        boolean tf = false;
        String column[] = {"account_id", "account_username"};
        String result[][] = SELECT(column, "accounts", column, "", " WHERE account_username = '" + username + "'", "");
        if (result.length > 0) {
            tf = true;
        }

        return tf;
    }

    public void setAccount_logs(String column[], String values[]) {
        INSERT("account_logs", column, values);

    }

    protected String[][] getAccountList(String id_name) {
        String column[] = {"accounts.account_id",
            "account_types.account_type_name",
            "CONCAT(accounts.account_firstname,' ',if(accounts.account_middle_initial='',' ',CONCAT(accounts.account_middle_initial,'. ')),accounts.account_lastname)",
            "accounts.account_gender",
            "CONCAT(accounts.account_street,', ',accounts.account_barangay,', ',accounts.account_city_municipality,', ',accounts.account_province)",
            "accounts.account_contact",
            "branch.branch_name",
            "accounts.account_date"};

        String result[][] = SELECT(column, "accounts", column, "LEFT JOIN account_types ON accounts.account_type_id = account_types.account_type_id "
                + "LEFT JOIN branch ON accounts.branch_id = branch.branch_id ", "WHERE accounts.account_status != 'Delete' AND (CONCAT(accounts.account_firstname,' ',if(accounts.account_middle_initial='',' ',CONCAT(accounts.account_middle_initial,'. ')),accounts.account_lastname) LIKE '%" + id_name + "%' OR accounts.account_id LIKE '%" + id_name + "%')", "");

        return result;
    }

    protected String[][] getViewAccount(String id_name) {
        String column[] = {"accounts.account_pic_filename",
            "accounts.account_firstname",
            "accounts.account_middle_initial",
            "accounts.account_lastname",
            "accounts.account_street",
            "accounts.account_barangay",
            "accounts.account_city_municipality",
            "accounts.account_province",
            "accounts.account_gender",
            "accounts.account_contact",
            "branch.branch_name",
            "account_types.account_type_name",
            "accounts.account_username",
            "accounts.account_status",
            "accounts.account_id"};

        String result[][] = SELECT(column, "accounts", column, "LEFT JOIN account_types ON accounts.account_type_id = account_types.account_type_id "
                + "LEFT JOIN branch ON accounts.branch_id = branch.branch_id ", "WHERE accounts.account_id = '" + id_name + "'", "");

        return result;
    }

    protected void setUpdateAccount(String column[], String values[], String product_code) {
        UPDATE("accounts", column, values, "WHERE account_id = '" + product_code + "'");
    }

    protected void setAccountStatus(String column[], String values[], String product_code) {
        UPDATE("accounts", column, values, "WHERE account_id = '" + product_code + "'");
    }

}
