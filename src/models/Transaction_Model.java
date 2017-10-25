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
public class Transaction_Model extends Database {

    protected String[][] getTransactionSell(String id) {
        String column[] = {"transaction.transaction_basket", "CONCAT(accounts.account_firstname,' ',if(accounts.account_middle_initial='',' ',CONCAT(accounts.account_middle_initial,'. ')),accounts.account_lastname)"};
        String result[][] = SELECT(column, "transaction", column, "LEFT JOIN accounts ON transaction.transaction_account_id = accounts.account_id ", "WHERE transaction.transaction_id = '" + id + "'", "");
        return result;
    }

    protected String[][] getTransactionBuy(String id) {
        String column[] = {"product.product_name", "product.num_of_products", "product_history.total_cost", "CONCAT(accounts.account_firstname,' ',if(accounts.account_middle_initial='',' ',CONCAT(accounts.account_middle_initial,'. ')),accounts.account_lastname)", "accounts.account_firstname"};
        String result[][] = SELECT(column, "product_history", column, "LEFT JOIN accounts ON product_history.account_id = accounts.account_id "
                + "LEFT JOIN product ON product_history.product_code = product.product_code ",
                "WHERE DATE_FORMAT(product.date_created,'%Y%m%d') = '" + id + "'", "");
        return result;
    }

    protected String[][] getBranch() {
        String column[] = {"branch_id", "branch_name"};
        String result[][] = SELECT(column, "branch", column, "", "", "");

        return result;
    }

}
