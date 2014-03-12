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
public class DisplayLibraryDetailsMSSQL extends DisplayLibraryDetailsQuery {

    ResultSet retrieve_values()
    {
        ResultSet result_set = null;
        try
        {
            String query = "select * from LibraryDetail";
            Statement execute_query = ServerDetails.server_connection.createStatement();
            result_set = execute_query.executeQuery(query);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server1.\nCheck the server and restart the Application" + e, "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(result_set);
    }

}
