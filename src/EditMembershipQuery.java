/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.ResultSet;

/**
 *
 * @author Rohit Aggarwal
 */
public abstract class EditMembershipQuery {

    abstract boolean check_membership();
    abstract void insert_values();
    abstract ResultSet retrieve_values();

}
