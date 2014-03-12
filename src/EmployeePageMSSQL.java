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
public class EmployeePageMSSQL extends EmployeePageQuery {

    boolean check_book()
    {
        boolean return_value = false;
        try
        {
            String query = "select * from Book";
            Statement execute_query = ServerDetails.server_connection.createStatement();
            ResultSet result_set = execute_query.executeQuery(query);
            if(result_set.next())
                return_value = true;
            result_set.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server1.\nCheck the server and restart the Application" , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(return_value);
    }

    String retrieve_member_id()
    {
        String return_value = null;
        try
        {
            String query = "select MemberID from Login where UserName=?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, ServerDetails.login_user);
            ResultSet result_set = execute_query.executeQuery();
            if(result_set.next())
                return_value = result_set.getString("MemberID");
            result_set.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server1.\nCheck the server and restart the Application" , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(return_value);
    }


    boolean check_member_id()
    {
        boolean return_value = false;
        try
        {
            String query = "select * from Member where MemberID = ?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, EmployeePage.member_id);
            ResultSet result_set = execute_query.executeQuery();
            if(result_set.next())
                return_value = true;
            result_set.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(return_value);
    }

    boolean check_isbn_book()
    {
        boolean return_value = false;
        try
        {
            String query = "select * from Book where ISBNNo = ?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, EmployeePage.isbn_no);
            ResultSet result_set = execute_query.executeQuery();
            if(result_set.next())
                return_value = true;
            result_set.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(return_value);
    }

    boolean check_member_reference()
    {
        boolean return_value = false;
        try
        {
            String query = "select * from CurrentIssued where MemberID = ? and ReferenceNo=?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, AdministratorPage.member_id);
            execute_query.setString(2, AdministratorPage.reference_no);
            ResultSet result_set = execute_query.executeQuery();
            if(result_set.next())
                return_value = true;
            result_set.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(return_value);
    }

}
