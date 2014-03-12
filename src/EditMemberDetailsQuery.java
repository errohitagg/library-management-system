/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.ResultSet;

/**
 *
 * @author Rohit Aggarwal
 */
public abstract class EditMemberDetailsQuery {

    abstract boolean check_member_id();
    abstract ResultSet retrieve_memberships();
    abstract ResultSet retrieve_values();
    abstract ResultSet retrieve_values_();
    abstract ResultSet _retrieve_values_();
    abstract void insert_values();

}
