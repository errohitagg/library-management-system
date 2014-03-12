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
public class EditMembershipMYSQL extends EditMembershipQuery {

     boolean check_membership()
    {
        boolean return_value = true;
        try
        {
            String query = "select * from MemberType where TypeName = ?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, EditMembership.membership);
            ResultSet result_set = execute_query.executeQuery();
            if(result_set.next())
                return_value=false;
            execute_query.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application", "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(return_value);
    }

    void insert_values()
    {
        try
        {
            String query = "update MemberType set BookLimit=? where TypeName =?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setInt(1, EditMembership.book_limit);
            execute_query.setString(2, EditMembership.membership);
            execute_query.executeUpdate();
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    ResultSet retrieve_values()
    {
        ResultSet result_set = null;
        try
        {
            String query = "select * from MemberType where TypeName=?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, EditMembership.membership);
            result_set = execute_query.executeQuery();
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(result_set);
    }

}
