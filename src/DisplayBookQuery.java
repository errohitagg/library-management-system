/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.ResultSet;

/**
 *
 * @author Rohit Aggarwal
 */
public abstract class DisplayBookQuery {

    abstract ResultSet retrieve_book();
    abstract ResultSet retrieve_books();

}
