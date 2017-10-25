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
public class Login_Model extends Database {

    protected String[][] getBranchList() {
        String column[] = {"branch_id", "branch_name"};
        String result[][] = SELECT(column, "branch", column, "", "", "");
        return result;
    }

    protected String[][] login_user(String username, String password, String branch_id) {

        String column[] = {"CONCAT(accounts.account_firstname,' ',if(accounts.account_middle_initial='',' ',CONCAT(accounts.account_middle_initial,'. ')),accounts.account_lastname)",
            "branch.branch_name",
            "branch.branch_address",
            "branch.branch_contact",
            "branch.branch_id",
            "accounts.account_id",
            "accounts.account_type_id",
            "accounts.account_status"};
        String result[][] = SELECT(column, "accounts", column, "LEFT JOIN branch ON accounts.branch_id = branch.branch_id", " WHERE accounts.account_username ='" + username + "' "
                + "AND accounts.account_password = '" + password + "' "
                + "AND branch.branch_id = '" + branch_id + "'"
                + "AND accounts.account_key = 'FMbJpSusGJYCxydXRezxjQ== - v99xUxa77O - fZqnJ7sWV0 - X98RXrsDTZ - oIftz76VYT - 7ZBt80ioNO - BjQzR5DTnA'", "");

        return result;
    }

    protected String[][] transaction_dateTrap(String date) {

        String column[] = {"transaction_date", "DATEDIFF(CURDATE(),MAX(transaction_date))"};
        String result[][] = SELECT(column, "transaction", column, "", "WHERE CURDATE() = '" + date + "'", "");

        return result;
    }

    protected void setLogout(String column[], String values[], String product_code) {
        UPDATE("accout_logs", column, values, "WHERE account_id = '" + product_code + "'");
    }

    public String[][] getProductCode() {
        String column[] = {"product_code", "product_name","num_of_products","supplier_id","supplier_price","selling_price"};
        String result[][] = SELECT(column, "product", column, "", "", "");
        return result;
    }

    public boolean find_product(String product_code) {
        boolean tf = false;
        String column[] = {"product_code", "product_history_id"};
        String result[][] = SELECT(column, "product_history", column, "", "WHERE DATE(history_date) = CURDATE() "
                + "AND product_code = '" + product_code + "'", "");

        if (result.length > 0) {
            tf = true;
        } else {
            tf = false;
        }
        return tf;
    }

}
