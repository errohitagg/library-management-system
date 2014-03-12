/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.ResultSet;

/**
 *
 * @author Rohit Aggarwal
 */
public abstract class DisplayMemberQuery {

    abstract ResultSet retrieve_data();
    abstract ResultSet retrieve_membership();
    abstract ResultSet retrieve_validity();

}
