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
public class GenerateSales_Model extends Database {

    protected String[][] getSales(String id, String date) {
        String column[] = {
            "branch.branch_name",
            "branch.branch_address",
            "branch.branch_contact",
            "CONCAT(accounts.account_firstname,' ',if(accounts.account_middle_initial='',' ',CONCAT(accounts.account_middle_initial,'. ')),accounts.account_lastname)",
            "SUM(transaction.transaction_total_product)",
            "SUM(transaction.transaction_amount - transaction.transaction_change)",
            "branch.branch_id",
            "accounts.account_id"
        };

        String result[][] = SELECT(column, "transaction", column, "LEFT JOIN branch ON transaction.transaction_branch_id=branch.branch_id "
                + "LEFT JOIN  accounts ON transaction.transaction_account_id = accounts.account_id ", "WHERE DATE(transaction.transaction_date) = '" + date + "' "
                + "AND transaction.transaction_account_id = '" + id + "' ", "GROUP BY DATE(transaction.transaction_Date)");

        return result;
    }

    protected String[][] getOwner() {
        String column[] = {"account_id",
            "CONCAT(accounts.account_firstname,' ',if(accounts.account_middle_initial='',' ',CONCAT(accounts.account_middle_initial,'. ')),accounts.account_lastname)",};
        String result[][] = SELECT(column, "accounts", column, "", "WHERE account_type_id = '3'", "");

        return result;
    }

    protected int get_pk_transactionID() {
        int num = SELECT_UNIQUE_RANDOM(999999999, "transaction_id", "transaction", "transaction_id");

        return num;
    }

    protected void setSales(String column[], String values[]) {
        INSERT("sales", column, values);

    }

    protected String[][] getBranch() {
        String column[] = {"branch_id", "branch_name"};
        String result[][] = SELECT(column, "branch", column, "", "", "");

        return result;
    }

    protected String[][] getSales(String id, String from, String to) {
        String column[] = {"sales.sales_id",
            "branch.branch_name",
            "CONCAT(accounts.account_firstname,' ',if(accounts.account_middle_initial='',' ',CONCAT(accounts.account_middle_initial,'. ')),accounts.account_lastname)",
            "sales.sold",
            "sales.amount",
            "sales.sale_date"};
        String result[][] = SELECT(column, "sales", column, "LEFT JOIN branch ON sales.branch_id = branch.branch_id "
                + "LEFT JOIN accounts ON sales.account_id = accounts.account_id", " WHERE sales.sales_id LIKE '%" + id + "%' "
                + from + to, " ORDER BY sales.sale_date");

        return result;
    }

    protected String[][] getIndividualSales(String id, String from, String to) {
        String column[] = {
            "product_history.product_code",
            "CONCAT(product.product_name,' ',cp_number)",
            "product_history.product_stock",
            "product_history.product_sold",
            "product_history.tendered_amount",
            "CONCAT(accounts.account_firstname,' ',if(accounts.account_middle_initial='',' ',CONCAT(accounts.account_middle_initial,'. ')),accounts.account_lastname)",
            "product_history.history_date"};
        String result[][] = SELECT(column, "product_history", column, "LEFT JOIN product ON product_history.product_code=product.product_code "
                + "LEFT JOIN accounts ON product_history.account_id = accounts.account_id ", "WHERE (product.product_code LIKE '%" + id + "%' OR product.product_name LIKE '%" + id + "%' ) "
                + "AND product_history.product_sold > 0 " + from + to, "ORDER BY product_history.history_date");
        return result;
    }

}
