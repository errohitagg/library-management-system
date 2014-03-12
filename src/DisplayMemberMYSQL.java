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
public class DisplayMemberMYSQL extends DisplayMemberQuery {

    ResultSet retrieve_data()
    {
        ResultSet result_set = null;
        try
        {
            String query = "select * from Member where MemberID=?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, DisplayMember.member_id);
            result_set = execute_query.executeQuery();
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application", "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(result_set);
    }

    ResultSet retrieve_membership()
    {
        int temp_id = 0;
        ResultSet result_set = null;
        try
        {
            String query = "select * from Membership where MemberID=?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, DisplayMember.member_id);
            result_set = execute_query.executeQuery();
            if(result_set.next())
                temp_id = result_set.getInt("Type");
            execute_query.close();

            query = "select * from MemberType where TypeID=?";
            execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setInt(1, temp_id);
            result_set = execute_query.executeQuery();
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application", "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(result_set);
    }

    ResultSet retrieve_validity()
    {
        ResultSet result_set = null;
        try
        {
            String query = "select * from Membership where MemberID=?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, DisplayMember.member_id);
            result_set = execute_query.executeQuery();
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application", "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(result_set);
    }

}
