/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.ResultSet;

/**
 *
 * @author Rohit Aggarwal
 */
public abstract class ReIssueQuery {

    abstract ResultSet retrieve_values();
    abstract void insert_values();

}
