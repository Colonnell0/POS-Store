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
public class Pay_Model extends Database {

    protected void pay_transaction(String tableName, String[] column, String values[]) {
        INSERT(tableName, column, values);

    }

    protected void updateProduct(String column[], String values[], String product_code) {
        UPDATE("product", column, values, "WHERE product_code = '" + product_code + "'");
    }

    protected String[][] find_product(String product_code, String branch_id) {

        String column[] = {"product.product_code",
            "product.num_of_products",
            "product.supplier_id",
            "product.supplier_price",
            "product.selling_price",
            "ifnull(h.product_sold,0)",
            "ifnull(h.tendered_amount,0)"};
        String result[][] = SELECT(column, "product", column, "LEFT JOIN (SELECT * FROM product_history WHERE product_history.product_history_id IN (SELECT MAX(product_history.product_history_id) FROM product_history GROUP BY product_history.product_code)) as h ON h.product_code = product.product_code   ", "WHERE product.product_code ='" + product_code + "' "
                + "AND product.branch_id ='" + branch_id + "'", "");

        return result;
    }

    protected void add_product_history(String tableName, String column[], String values[]) {
        INSERT(tableName, column, values);
    }

}
