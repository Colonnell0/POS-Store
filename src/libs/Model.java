/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libs;

import java.sql.Connection;

/**
 *
 * @author Colonnello
 */
public class Model extends dbConnection {

    protected Connection conn;

    protected void db_connect() {

        try {
            conn = super.setConnection(conn, "non_stop", "UFejRPXD9rPGZUcz", "non_stop");
            System.out.println("connected");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
