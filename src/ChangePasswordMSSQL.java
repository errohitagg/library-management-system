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
public class ChangePasswordMSSQL extends ChangePasswordQuery {

    boolean check_password()
    {
        boolean return_value =false;
        try
        {
            String query = "select Password from Login where UserName = ?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, ChangePassword.user_name);
            ResultSet result_set = execute_query.executeQuery();
            if(result_set.next())
            {
                if(result_set.getString("Password").trim().compareTo(ChangePassword.old_password) == 0)
                    return_value=true;
            }
            result_set.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server1.\nCheck the server and restart the Application" , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(return_value);
    }

    void update_password()
    {
        try
        {
            String query = "update Login set Password=? where UserName=?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, ChangePassword.new_password);
            execute_query.setString(2, ChangePassword.user_name);
            execute_query.executeUpdate();
            execute_query.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application", "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

}
