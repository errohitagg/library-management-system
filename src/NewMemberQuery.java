/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.ResultSet;

/**
 *
 * @author Rohit Aggarwal
 */
public abstract class NewMemberQuery {

    abstract boolean check_member_id();
    abstract ResultSet retrieve_memberships();
    abstract void insert_values();

}
