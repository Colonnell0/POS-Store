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
public class Products_Model extends Database {

    protected void add_product(String tableName, String column[], String values[]) {
        INSERT(tableName, column, values);
    }

    protected void add_product_history(String tableName, String column[], String values[]) {
        INSERT(tableName, column, values);
    }

    protected void update_product_history(String column[], String values[], String product_code, String date) {
        UPDATE("product_history", column, values, "WHERE product_code = '" + product_code + "' AND DATE(history_date) = '" + date + "'");
    }

    protected void updateProduct(String column[], String values[], String product_code) {
        UPDATE("product", column, values, "WHERE product_code = '" + product_code + "'");
    }

    protected void add_category(String tableName, String column[], String values[]) {
        INSERT(tableName, column, values);
    }

    protected void add_supplier(String tableName, String column[], String values[]) {
        INSERT(tableName, column, values);
    }

    protected String[][] get_product() {
        String column[] = {"product_code", "product_name"};
        String result[][] = SELECT(column, "product", column, "", "", "");
        return result;
    }

    protected String[][] get_branch() {
        String column[] = {"branch_id", "branch_name"};
        String result[][] = SELECT(column, "branch", column, "", "", "");
        return result;
    }

    protected String[][] get_category() {
        String column[] = {"category_id", "category_name"};
        String result[][] = SELECT(column, "category", column, "", "", "");
        return result;
    }

    protected String[][] get_supplier() {
        String column[] = {"supplier_id", "supplier_name"};
        String result[][] = SELECT(column, "supplier", column, "", "", "");
        return result;
    }

    protected boolean find_history(String code, String date) {
        boolean tf = false;
        String column[] = {"product_history_id", "history_date"};
        String result[][] = SELECT(column, "product_history", column, "", "WHERE product_code = '" + code + "' AND DATE(history_date) = '" + date + "'", "");
        if (result.length > 0) {
            tf = true;
        } else {
            tf = false;
        }
        return tf;
    }

    protected String[][] get_product_list(String productCode) {
        String column[] = {"product.product_code",
            "product.product_name",
            "product.num_of_products",
            "ifnull(category.category_name,' ')",
            "ifnull(supplier.supplier_name,' ')",
            "product.supplier_price",
            "product.selling_price",
            "product.selling_unit_price",
            "product.selling_quantity",
            "product.date_created"};
        String result[][] = SELECT(column, "product ", column, ""
                + " LEFT JOIN supplier ON product.supplier_id=supplier.supplier_id "
                + "LEFT JOIN category ON product.category_id=category.category_id ", "WHERE product.product_code = '" + productCode + "'", "LIMIT 1");
        return result;
    }

    protected String[][] get_product_listAll(String productCode, String branchID) {
        String column[] = {"product.product_code",
            "product.product_name",
            "product.num_of_products",
            "ifnull(category.category_name,' ')",
            "ifnull(supplier.supplier_name,' ')",
            "supplier_price",
            "product.selling_price"
        };
        String result[][] = SELECT(column, "product", column, ""
                + "LEFT JOIN category ON product.category_id=category.category_id"
                + " LEFT JOIN supplier ON product.supplier_id=supplier.supplier_id",
                " WHERE product.branch_id = '" + branchID + "' "
                + "AND product.product_status != 'Delete' "
                + "AND product.product_code= '" + productCode + "' ",
                "");
        return result;
    }

    protected String[][] get_product_lists(String productCode, String branchID) {
        String column[] = {"product_code",
            "product_name",
            "selling_price",
            "num_of_products",
            "product_status",
            "order_constant"
        };
        String result[][] = SELECT(column, "product", column, "", " WHERE branch_id = '" + branchID + "' "
                + "AND product_status != 'Delete'"
                + " AND (product_code LIKE '%" + productCode + "%' OR product_name LIKE '%" + productCode + "%' )",
                "GROUP BY product_code ORDER BY num_of_products ASC, expiration_date ASC");
        return result;
    }

    protected String[][] get_product_listsStack(String productCode, String branchID) {
        String column[] = {"product.product_code",
            "product.product_name",
            "product.selling_price",
            "product_stock.product_sold",
            "product_stock.product_number",
            "CONCAT(accounts.account_firstname,' ',if(accounts.account_middle_initial='',' ',CONCAT(accounts.account_middle_initial,'. ')),accounts.account_lastname)",
            "product.product_status"};
        String result[][] = SELECT(column, "product", column, "LEFT JOIN product_stock "
                + "ON (product.product_code=product_stock.product_code) "
                + "LEFT JOIN accounts "
                + "ON product.account_id = accounts.account_id ", " WHERE product_stock.branch_id ='" + branchID + "' AND product.branch_id = '" + branchID + "' "
                + "AND product.product_status = 'Enable' "
                + "AND (product.product_code LIKE '%" + productCode + "%' OR product.product_name LIKE '%" + productCode + "%' )",
                "GROUP BY product.product_code ORDER BY product_stock.product_number ASC, product.expiration_date ASC");
        return result;
    }

    protected String[][] get_product_listsInventoryCategory(String productCodeName, String branch_id, String category, String from, String to) {

        String column[] = {"product_history.product_code",
            "CONCAT(product.product_name,' ',product_history.cp_number)",
            "supplier.supplier_name",
            "product_history.supplier_price",
            "product_history.selling_price",
            "product_history.product_stock + product_history.product_sold",
            "product_history.product_sold",
            "(product_history.product_stock - product_history.product_sold) + product_history.product_sold",
            "if((product.order_constant - (product_history.product_stock - product_history.product_sold) -product_history.product_sold)<=0,0,(product.order_constant - (product_history.product_stock - product_history.product_sold))-product_history.product_sold)",
            "category.category_name",
            "ifnull(product.expiration_date,' ')",
            "product_history.history_date",
            "CONCAT(accounts.account_firstname,' ',if(accounts.account_middle_initial='',' ',CONCAT(accounts.account_middle_initial,'. ')),accounts.account_lastname)",};

        String result[][] = SELECT(column, "product_history", column, " LEFT JOIN product ON product_history.product_code=product.product_code "
                + " LEFT JOIN category ON product.category_id=category.category_id "
                + " LEFT JOIN supplier ON product_history.supplier_id=supplier.supplier_id "
                + " LEFT JOIN accounts ON product_history.account_id = accounts.account_id ", " WHERE product.branch_id = '" + branch_id + "' "
                //   + "AND product_history.account_id = '" + account_id + "' "
                + " AND category.category_name LIKE '%" + category + "%' " + from + to
                + " AND (product.product_code LIKE '%" + productCodeName + "%' OR product.product_name LIKE '%" + productCodeName + "%')", " ORDER BY product.expiration_date,product_history.product_history_id ASC");
        return result;
    }

    protected String[][] get_product_listsInventorySupplier(String productCodeName, String branch_id, String supplier, String from, String to) {

        String column[] = {"product_history.product_code",
            "CONCAT(product.product_name,' ',product_history.cp_number)",
            "supplier.supplier_name",
            "product_history.supplier_price",
            "product_history.selling_price",
            "product_history.product_stock + product_history.product_sold",
            "product_history.product_sold",
            "(product_history.product_stock - product_history.product_sold) + product_history.product_sold",
            "if((product.order_constant - (product_history.product_stock - product_history.product_sold) -product_history.product_sold)<=0,0,(product.order_constant - (product_history.product_stock - product_history.product_sold))-product_history.product_sold)",
            "category.category_name",
            "ifnull(product.expiration_date,' ')",
            "product_history.history_date",
            "CONCAT(accounts.account_firstname,' ',if(accounts.account_middle_initial='',' ',CONCAT(accounts.account_middle_initial,'. ')),accounts.account_lastname)",};
        String result[][] = SELECT(column, "product_history", column, " LEFT JOIN product ON product_history.product_code=product.product_code"
                + " LEFT JOIN category ON product.category_id=category.category_id "
                + " LEFT JOIN supplier ON product_history.supplier_id=supplier.supplier_id "
                + " LEFT JOIN accounts ON product_history.account_id = accounts.account_id ", " WHERE product.branch_id = '" + branch_id + "' "
                //   + "AND product_history.account_id = '" + account_id + "' "
                + " AND product_history.supplier_id = '" + supplier + "'" + from + to
                + " AND (product.product_code LIKE '%" + productCodeName + "%' OR product.product_name LIKE '%" + productCodeName + "%')", " ORDER BY product.expiration_date,product_history.product_history_id ASC");
        return result;
    }

    protected String[][] get_product_listsInventorySupplierCategory(String productCodeName, String branch_id, String from, String to) {

        String column[] = {"product_history.product_code",
            "CONCAT(product.product_name,' ',product_history.cp_number)",
            "supplier.supplier_name",
            "product_history.supplier_price",
            "product_history.selling_price",
            "product_history.product_stock + product_history.product_sold",
            "product_history.product_sold",
            "(product_history.product_stock - product_history.product_sold) + product_history.product_sold",
            "if((product.order_constant - (product_history.product_stock - product_history.product_sold) -product_history.product_sold)<=0,0,(product.order_constant - (product_history.product_stock - product_history.product_sold))-product_history.product_sold)",
            "category.category_name",
            "ifnull(product.expiration_date,' ')",
            "product_history.history_date",
            "CONCAT(accounts.account_firstname,' ',if(accounts.account_middle_initial='',' ',CONCAT(accounts.account_middle_initial,'. ')),accounts.account_lastname)",};
        String result[][] = SELECT(column, "product_history", column, " LEFT JOIN product ON product_history.product_code=product.product_code"
                + " LEFT JOIN category ON product.category_id=category.category_id "
                + " LEFT JOIN supplier ON product_history.supplier_id=supplier.supplier_id "
                + " LEFT JOIN accounts ON product_history.account_id = accounts.account_id ", " WHERE product.branch_id = '" + branch_id + "' "
                // + "AND product_history.account_id = '" + account_id + "' "
                + from + to
                + " AND (product.product_code LIKE '%" + productCodeName + "%' OR product.product_name LIKE '%" + productCodeName + "%')", " ORDER BY product.expiration_date,product_history.product_history_id ASC");
        return result;
    }

    protected String[][] get_product_listsInventory(String productCodeName, String branch_id, String supplier, String category, String from, String to) {

        String column[] = {"product_history.product_code",
            "CONCAT(product.product_name,' ',product_history.cp_number)",
            "supplier.supplier_name",
            "product_history.supplier_price",
            "product_history.selling_price",
            "product_history.product_stock + product_history.product_sold",
            "product_history.product_sold",
            "(product_history.product_stock - product_history.product_sold) + product_history.product_sold",
            "if((product.order_constant - (product_history.product_stock - product_history.product_sold) -product_history.product_sold)<=0,0,(product.order_constant - (product_history.product_stock - product_history.product_sold))-product_history.product_sold)",
            "category.category_name",
            "ifnull(product.expiration_date,' ')",
            "product_history.history_date",
            "CONCAT(accounts.account_firstname,' ',if(accounts.account_middle_initial='',' ',CONCAT(accounts.account_middle_initial,'. ')),accounts.account_lastname)",};

        String result[][] = SELECT(column, "product_history", column, " LEFT JOIN product ON product_history.product_code=product.product_code"
                + "LEFT JOIN category ON product.category_id=category.category_id "
                + " LEFT JOIN supplier ON product_history.supplier_id=supplier.supplier_id "
                + " LEFT JOIN accounts ON product_history.account_id = accounts.account_id ", " WHERE  product.branch_id = '" + branch_id + "' "
                //  + "AND product_history.account_id = '" + account_id + "' "
                + " AND product_history.supplier_id = '" + supplier + "'"
                + " AND category.category_name LIKE '%" + category + "%' " + from + to
                + " AND (product.product_code LIKE '%" + productCodeName + "%' OR product.product_name LIKE '%" + productCodeName + "%')", " ORDER BY product.expiration_date,product_history.product_history_id ASC");
        return result;
    }

    protected String[][] getBranchList() {
        String column[] = {"branch_id", "branch_name"};
        String result[][] = SELECT(column, "branch", column, "", "", "");
        return result;
    }

    protected String[][] getAccountList() {
        String column[] = {"account_id", "CONCAT(accounts.account_firstname,' ',if(accounts.account_middle_initial='',' ',CONCAT(accounts.account_middle_initial,'. ')),accounts.account_lastname)"};
        String result[][] = SELECT(column, "accounts", column, "", "", "");
        return result;
    }

    protected String[][] getSupplierList() {
        String column[] = {"supplier_id", "supplier_name"};
        String result[][] = SELECT(column, "supplier", column, "", "", "");
        return result;
    }

    protected String[][] getCategoryList() {
        String column[] = {"category_id", "category_name"};
        String result[][] = SELECT(column, "category", column, "", "", "");
        return result;
    }

    protected String[][] getBranchList(String branch_name) {
        String column[] = {"branch_id", "branch_name"};
        String result[][] = SELECT(column, "branch", column, "", " WHERE branch_name = \"" + branch_name + "\"", "");
        return result;
    }

    protected String[][] getAccountList(String account_name) {
        String column[] = {"account_id", "CONCAT(accounts.account_firstname,' ',if(accounts.account_middle_initial='',' ',CONCAT(accounts.account_middle_initial,'. ')),accounts.account_lastname)"};
        String result[][] = SELECT(column, "accounts", column, "", " WHERE CONCAT(accounts.account_firstname,' ',if(accounts.account_middle_initial='',' ',CONCAT(accounts.account_middle_initial,'. ')),accounts.account_lastname) = \"" + account_name + "\"", "");
        return result;
    }

    protected String[][] getSupplierList(String supplier_name) {
        String column[] = {"supplier_id", "supplier_name"};
        String result[][] = SELECT(column, "supplier", column, "", " WHERE supplier_name = \"" + supplier_name + "\"", "");
        return result;
    }

    protected String[][] getSupplierDetails(String supplier_name) {
        String column[] = {"s.supplier_name",
            "s.supplier_address",
            "s.supplier_contact",
            "s.supplier_date",
            "product.product_code",
            "product.product_name",
            "product.supplier_price",
            "product.selling_price",
            "product.num_of_products+  h.product_sold",
            "h.product_sold",
            "(h.product_stock - h.product_sold)+ h.product_sold",
            "if((product.order_constant - (h.product_stock - h.product_sold) -  h.product_sold)<=0,0,(product.order_constant - (h.product_stock - h.product_sold))- h.product_sold)"};
        String result[][] = SELECT(column, "supplier s", column, "LEFT JOIN product  ON s.supplier_id = product.supplier_id "
                + "LEFT JOIN (SELECT * FROM product_history WHERE product_history.product_history_id IN (SELECT MAX(product_history.product_history_id) FROM product_history GROUP BY product_history.product_code)) as h ON h.product_code = product.product_code   ", " WHERE supplier_name = \"" + supplier_name + "\"", " GROUP BY product.product_code ORDER BY if(product.order_constant - (h.product_stock - h.product_sold)<=0,0,product.order_constant - (h.product_stock - h.product_sold)) DESC");
        return result;
    }

    protected String[][] getPurchaseOrder(String branch, String supplier, String productCode) {
        String column[] = {
            "product.product_code",
            "product.product_name",
            "s.supplier_name",
            "s.supplier_address",
            "s.supplier_contact",
            "product.supplier_price",
            "product.selling_price",
            "if((product.order_constant - (h.product_stock - h.product_sold) -  h.product_sold)<=0,0,(product.order_constant - (h.product_stock - h.product_sold))- h.product_sold)",
            "(if((product.order_constant - (h.product_stock - h.product_sold) -  h.product_sold)<=0,0,(product.order_constant - (h.product_stock - h.product_sold))- h.product_sold)) * product.supplier_price"};
        String result[][] = SELECT(column, "supplier s", column, "LEFT JOIN product  ON s.supplier_id = product.supplier_id "
                + "LEFT JOIN (SELECT * FROM product_history WHERE product_history.product_history_id IN (SELECT MAX(product_history.product_history_id) FROM product_history GROUP BY product_history.product_code)) as h ON h.product_code = product.product_code   ", "WHERE product.num_of_products <= 20 "
                + "AND product.branch_id = '" + branch + "' "
                + "AND s.supplier_name LIKE \"%" + supplier + "%\" "
                + "AND (product.product_code LIKE '%" + productCode + "%' OR product.product_name LIKE '%" + productCode + "%' )", " GROUP BY product.product_code ORDER BY if(product.order_constant - (h.product_stock - h.product_sold)<=0,0,product.order_constant - (h.product_stock - h.product_sold)) DESC");
        return result;
    }

    protected String[][] getPurchaseOrder(String branch) {
        String column[] = {
            "product.product_code",
            "product.product_name",
            "s.supplier_name",
            "s.supplier_address",
            "s.supplier_contact",
            "product.supplier_price",
            "product.selling_price",
            "if((product.order_constant - (h.product_stock - h.product_sold) -  h.product_sold)<=0,0,(product.order_constant - (h.product_stock - h.product_sold))- h.product_sold)",
            "(if((product.order_constant - (h.product_stock - h.product_sold) -  h.product_sold)<=0,0,(product.order_constant - (h.product_stock - h.product_sold))- h.product_sold)) * product.supplier_price"};
        String result[][] = SELECT(column, "supplier s", column, "LEFT JOIN product  ON s.supplier_id = product.supplier_id "
                + "LEFT JOIN (SELECT * FROM product_history WHERE product_history.product_history_id IN (SELECT MAX(product_history.product_history_id) FROM product_history GROUP BY product_history.product_code)) as h ON h.product_code = product.product_code   ", "WHERE product.num_of_products <= 20 "
                + "AND product.branch_id = '" + branch + "' ",
                " GROUP BY product.product_code ORDER BY if(product.order_constant - (h.product_stock - h.product_sold)<=0,0,product.order_constant - (h.product_stock - h.product_sold)) DESC");
        return result;
    }

    protected String[][] getPurchaseOrderView(int supplier) {
        String column[] = {
            "product.product_code",
            "product.product_name",
            "s.supplier_name",
            "s.supplier_address",
            "s.supplier_contact",
            "product.supplier_price",
            "product.selling_price",
            "if((product.order_constant - (h.product_stock - h.product_sold) -  h.product_sold)<=0,0,(product.order_constant - (h.product_stock - h.product_sold))- h.product_sold)",
            "(if((product.order_constant - (h.product_stock - h.product_sold) -  h.product_sold)<=0,0,(product.order_constant - (h.product_stock - h.product_sold))- h.product_sold)) * product.supplier_price",
            "product.branch_id",
            "branch.branch_address",
            "branch.branch_contact"};
        String result[][] = SELECT(column, "supplier s", column, "LEFT JOIN product  ON s.supplier_id = product.supplier_id "
                + "LEFT JOIN (SELECT * FROM product_history WHERE product_history.product_history_id IN (SELECT MAX(product_history.product_history_id) FROM product_history GROUP BY product_history.product_code)) as h ON h.product_code = product.product_code   "
                + "LEFT JOIN branch ON product.branch_id = branch.branch_id ", "WHERE product.num_of_products <= 20 AND product.supplier_id = '" + supplier + "'",
                " GROUP BY product.product_code ORDER BY if(product.order_constant - (h.product_stock - h.product_sold)<=0,0,product.order_constant - (h.product_stock - h.product_sold)) DESC");
        return result;
    }

    protected void setLogout(String column[], String values[], String product_code) {
        UPDATE("accounts", column, values, "WHERE account_id = '" + product_code + "'");
    }

}
