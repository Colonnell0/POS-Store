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
public class Admin_Model extends Database {

    protected String[][] getAccount(String date) {
        String column[] = {
            "CONCAT(accounts.account_firstname,' ',if(accounts.account_middle_initial='',' ',CONCAT(accounts.account_middle_initial,'. ')),accounts.account_lastname)",
            "CONCAT(accounts.account_street,', ',accounts.account_barangay,', ',accounts.account_city_municipality,', ',accounts.account_province)",
            "accounts.account_contact",
            "SUM(transaction.transaction_amount - transaction.transaction_change)",
            "DATE_FORMAT(accounts.account_date,'%M %d,  %Y')",
            "accounts.account_pic_filename",
            "accounts.account_gender",
            "account_types.account_type_name",
            "ifnull(accounts.login_status,' ')"};
        String result[][] = SELECT(column, "accounts", column, "LEFT JOIN transaction "
                + "ON accounts.account_id=transaction.transaction_account_id "
                + "LEFT JOIN account_types ON accounts.account_type_id = account_types.account_type_id "
                + "", " WHERE YEAR(transaction.transaction_date) = '" + date + "' "
                + "OR accounts.account_id > 0 "
                + "AND accounts.account_status != 'Delete'", "");

        return result;
    }

    protected String[][] getBranch() {
        String column[] = {"branch_id", "branch_name"};
        String result[][] = SELECT(column, "branch", column, "", "", "");

        return result;
    }

    protected int getBranch_id(String name) {
        String column[] = {"branch_id", "branch_name"};
        int result = Integer.parseInt(SELECT(column, "branch", column, "", "WHERE branch_name = '" + name + "'", "")[0][0]);

        return result;
    }

    protected String[][] getDataGraphTransaction(String date, String year, String id) {
        String productName[][] = {};
        if (date.equalsIgnoreCase("Monthly")) {
            String column[] = {"SUM(transaction_total_product)",
                "sum(transaction_amount) - sum(transaction_change)",
                "DATE_FORMAT(transaction_date,'%M %d,  %Y')"};
            productName = SELECT(column, "transaction", column, "", " WHERE YEAR(transaction_date) = '" + year + "' "
                    + "AND transaction_branch_id =  '" + id + "' ", "GROUP BY MONTHNAME(transaction_date)  ORDER BY FIELD(MONTHNAME(transaction_date),'January','February','March','April','May','June','July','August','September','October','November','December')");

        }
        if (date.equalsIgnoreCase("Daily")) {
            String column[] = {"SUM(transaction_total_product)",
                "sum(transaction_amount) - sum(transaction_change)",
                "DATE_FORMAT(transaction_date,'%M %d,  %Y')"};

            productName = SELECT(column, "transaction", column, "", " WHERE YEAR(transaction_date) = '" + year + "' "
                    + "AND transaction_branch_id =  '" + id + "'  ", "GROUP BY DAY(transaction_date)  ORDER BY transaction_date");

        }
        if (date.equalsIgnoreCase("Weekly")) {
            String column[] = {"SUM(transaction_total_product)",
                "sum(transaction_amount) - sum(transaction_change)",
                "DATE_FORMAT(transaction_date,'%M %d,  %Y')"};

            productName = SELECT(column, "transaction", column, "", " WHERE YEAR(transaction_date) = '" + year + "' "
                    + "AND transaction_branch_id =  '" + id + "'  ", "GROUP BY WEEK(transaction_date)  ORDER BY transaction_date");

        }
        return productName;

    }

    protected String[][] getDataGraphProduct(String date, String year, String id) {
        String productName[][] = {};
        if (date.equalsIgnoreCase("Monthly")) {
            String column[] = {"SUM(product.num_of_products)",
                "SUM(h.total_cost)",
                "DATE_FORMAT(h.history_date,'%M %d,  %Y')"};

            productName = SELECT(column, "product", column, " LEFT JOIN product_history h ON product.product_code = h.product_code ", " WHERE YEAR(h.history_date) = '" + year + "' "
                    + "AND product.branch_id = '" + id + "' "
                    + "AND product.product_status != 'Delete' ", "GROUP BY MONTHNAME(h.history_date)  ORDER BY FIELD(MONTHNAME(h.history_date),'January','February','March','April','May','June','July','August','September','October','November','December')");

        }
        if (date.equalsIgnoreCase("Daily")) {
            String column[] = {"SUM(product.num_of_products)",
                "SUM(h.total_cost)",
                "DATE_FORMAT(h.history_date,'%M %d,  %Y')"};
            productName = SELECT(column, "product", column, " LEFT JOIN product_history h ON product.product_code = h.product_code ", " WHERE YEAR(h.history_date) = '" + year + "' "
                    + "AND product.branch_id = '" + id + "' "
                    + "AND product.product_status != 'Delete' ", " GROUP BY DATE(h.history_date) ORDER BY h.history_date");

        }
        if (date.equalsIgnoreCase("Weekly")) {
            String column[] = {"SUM(product.num_of_products)",
                "SUM(h.total_cost)",
                "DATE_FORMAT(h.history_date,'%M %d,  %Y')"};
            productName = SELECT(column, "product", column, " LEFT JOIN product_history h ON product.product_code = h.product_code ", " WHERE YEAR(h.history_date) = '" + year + "' "
                    + "AND product.branch_id = '" + id + "' "
                    + "AND product.product_status != 'Delete' ", "GROUP BY WEEK(h.history_date)  ORDER BY h.history_date");

        }
        return productName;

    }

    protected String[][] getAvailableProductTotalCost(String id) {
        String column[] = {
            "SUM(product.num_of_products)",
            "SUM(h.total_cost)",};
        String result[][] = SELECT(column, "product", column,
                "LEFT JOIN (SELECT * FROM product_history WHERE product_history.product_history_id IN (SELECT MAX(product_history.product_history_id) FROM product_history GROUP BY product_history.product_code)) as h ON h.product_code = product.product_code   ",
                " WHERE h.branch_id = '"+id+"'",
                "");
        return result;
    }

    protected void setLogout(String column[], String values[], String product_code) {
        UPDATE("accounts", column, values, "WHERE account_id = '" + product_code + "'");
    }

}
