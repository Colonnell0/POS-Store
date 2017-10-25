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
public class Context {

    private final static Context instance = new Context();

    public static Context getInstance() {
        return instance;
    }

    private User_info user_info = new User_info();
    private Update_History update_history = new Update_History();

    public User_info branch_id() {
        return user_info;
    }

    public User_info user_id() {
        return user_info;
    }

    public User_info branch_name() {
        return user_info;
    }

    public User_info account_type() {
        return user_info;
    }

    public User_info account_name() {
        return user_info;
    }

    public User_info supplier_name() {
        return user_info;
    }

    public Update_History product_history() {
        return update_history;
    }

}
