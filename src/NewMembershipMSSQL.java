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
public class NewMembershipMSSQL extends NewMembershipQuery {

    boolean check_membership()
    {
        boolean return_value = true;
        try
        {
            String query = "select * from MemberType where TypeName = ?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, NewMembership.membership);
            ResultSet result_set = execute_query.executeQuery();
            if(result_set.next())
                return_value=false;
            execute_query.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server1.\nCheck the server and restart the Application", "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(return_value);
    }

    void insert_values()
    {
        try
        {
            String query = "insert into MemberType (TypeName, BookLimit) values (?,?)";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, NewMembership.membership);
            execute_query.setInt(2, NewMembership.book_limit);
            execute_query.executeUpdate();
            execute_query.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server2.\nCheck the server and restart the Application"  +e, "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

}
