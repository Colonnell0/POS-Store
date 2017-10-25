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
public class Supplier_Model extends Database {

    protected void update_supplier(String column[], String values[], String product_code) {
        product_code = product_code.replaceAll("\"", "");
        UPDATE("supplier", column, values, "WHERE supplier_name = \"" + product_code + "\"");
    }
}
