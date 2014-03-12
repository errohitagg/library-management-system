/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Rohit Aggarwal
 */
public class DisplayBookMSSQL extends DisplayBookQuery {

    ResultSet retrieve_book()
    {
        ResultSet result_set = null;
        try
        {
            String query = "select * from Book where ISBNNo=?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, DisplayBook.isbn_no);
            result_set = execute_query.executeQuery();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server1.\nCheck the server and restart the Application" + e, "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(result_set);
    }

    ResultSet retrieve_books()
    {
        ResultSet result_set = null;
        try
        {
            String query = "select * from BookRecord where ISBNNo=?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, DisplayBook.isbn_no);
            result_set = execute_query.executeQuery();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server2.\nCheck the server and restart the Application" + e, "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(result_set);
    }

}
