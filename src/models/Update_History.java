/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Colonnello
 */
public class Update_History extends Products_Model {

    public void Update_Product_History(String product_code, String date, String column[], String values[], String action) {
        if (action.equalsIgnoreCase("insert")) {

            add_product_history("product_history", column, values);

        }
        if (action.equalsIgnoreCase("update")) {

            update_product_history(column, values, product_code, date);

        }

    }

    public static String[] removeElement(String[] original, int element) {
        String[] n = new String[original.length - 1];
        System.arraycopy(original, 0, n, 0, element);
        System.arraycopy(original, element + 1, n, element, original.length - element - 1);
        return n;
    }

}
