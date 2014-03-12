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
public class LoginMYSQL extends LoginQuery{

    boolean check_user_name()
    {
        boolean return_value = false;
        try
        {
            String query = "select * from Login where UserName = ?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, Login.user_name);
            ResultSet result_set = execute_query.executeQuery();
            if(result_set.next())
                return_value=true;
            execute_query.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application", "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(return_value);
    }
    boolean check_password()
    {
        boolean return_value = false;
        try
        {
            String query = "select Password from Login where UserName = ?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, Login.user_name);
            ResultSet result_set = execute_query.executeQuery();
            if(result_set.next())
            {
                 if(result_set.getString("Password").trim().compareTo(Login.password) == 0)
                {                    
                    return_value=true;   
                }
            }
            result_set.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" + e, "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
        return(return_value);
    }
    String get_category()
    {
        String return_value = "";
        String temp_id = null;
        int temp_type = -1;
        try
        {
            String query = "select MemberID from Login where UserName = ?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, Login.user_name);
            ResultSet result_set = execute_query.executeQuery();
            if(result_set.next())
                temp_id = result_set.getString("MemberID");
            

            query = "select Type from Membership where MemberID=?";
            execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, temp_id);
            result_set = execute_query.executeQuery();
            if(result_set.next())
                temp_type = result_set.getInt("Type");
          

            query = "select TypeName from MemberType where TypeID=?";
            execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setInt(1, temp_type);
            result_set = execute_query.executeQuery();
            if(result_set.next())
                return_value = result_set.getString("TypeName");
            execute_query.close();

        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application", "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(return_value);
    }
}
