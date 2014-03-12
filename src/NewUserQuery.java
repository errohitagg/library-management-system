/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Rohit Aggarwal
 */
public abstract class NewUserQuery {

    abstract boolean check_user_name();
    abstract boolean check_unique_id();
    abstract boolean check_unique_id_exists();
    abstract void insert_values();
}
