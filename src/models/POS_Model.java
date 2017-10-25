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
public class POS_Model extends Database {

    protected String[][] POS(String product_code, String branch_id) {
        String column[] = {"product_code", "product_name", "selling_price", "selling_unit_price", "selling_quantity"};
        String result[][] = SELECT(column, "product", column, "", "WHERE product_code = '" + product_code + "' AND branch_id ='" + branch_id + "' "
                + "AND product_status = 'Enable'", "");
        return result;
    }

    protected String[][] get_product(String branch_id) {
        String column[] = {"product_code", "product_name"};
        String result[][] = SELECT(column, "product", column, "", "WHERE branch_id = '" + branch_id + "' "
                + "AND product_status = 'Enable'", " GROUP BY product_code");
        return result;
    }

    protected int get_pk_transactionID() {
        int num = SELECT_UNIQUE_RANDOM(999999999, "transaction_id", "transaction", "transaction_id");

        return num;
    }

    protected void setLogout(String column[], String values[], String product_code) {
        UPDATE("accounts", column, values, "WHERE account_id = '" + product_code + "'");
    }

    protected String[][] get_product() {
        String column[] = {"load_product_id", "load_product_name"};
        String result[][] = SELECT(column, "load_central", column, "", "", "");
        return result;
    }

}
