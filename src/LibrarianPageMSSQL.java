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
public class LibrarianPageMSSQL extends LibrarianPageQuery {

    boolean check_library()
    {
        boolean return_value =false;
        try
        {
            String query = "select * from LibraryDetail";
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

    boolean check_member()
    {
        boolean return_value = false;
        try
        {
            String query = "select * from Member";
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

    boolean check_member_type()
    {
        boolean return_value = false;
        try
        {
            String query = "select * from MemberType";
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
            execute_query.setString(1, AdministratorPage.member_id);
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
            execute_query.setString(1, AdministratorPage.isbn_no);
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

    void delete_member()
    {
        try
        {
            String query = "delete from Login where MemberID = ?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, AdministratorPage.member_id);
            execute_query.executeUpdate();

            query = "delete from Membership where MemberID = ?";
            execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, AdministratorPage.member_id);
            execute_query.executeUpdate();

            query = "delete from TotalTransactions where MemberID = ?";
            execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, AdministratorPage.member_id);
            execute_query.executeUpdate();

            query = "delete from Leaves where MemberID = ?";
            execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, AdministratorPage.member_id);
            execute_query.executeUpdate();

            query = "delete from Member where MemberID = ?";
            execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, AdministratorPage.member_id);
            execute_query.executeUpdate();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    void delete_membership()
    {
        int membership_id = 0;
        try
        {
            String query = "select * from MemberType where TypeName=?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, AdministratorPage.membership);
            ResultSet result_set = execute_query.executeQuery();
            membership_id = result_set.getInt("TypeID");

            query = "delete from Membership where Type = ?";
            execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setInt(1, membership_id);
            execute_query.executeUpdate();

            query = "delete from MemberType where TypeName = ?";
            execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, AdministratorPage.membership);
            execute_query.executeUpdate();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    void delete_book()
    {
        try
        {
            String query = "select * from BookRecord where ISBNNo=?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, AdministratorPage.isbn_no);
            ResultSet result_set = execute_query.executeQuery();

            while(result_set.next())
            {
                query = "delete from TotalTransaction where ReferenceNo = ?";
                execute_query = ServerDetails.server_connection.prepareStatement(query);
                execute_query.setString(1, result_set.getString("ReferenceNo"));
                execute_query.executeUpdate();
            }

            query = "delete from BookRecord where ISBNNo = ?";
            execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, AdministratorPage.isbn_no);
            execute_query.executeUpdate();

            query = "delete from Book where ISBNNo = ?";
            execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, AdministratorPage.isbn_no);
            execute_query.executeUpdate();

        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    boolean check_membership()
    {
        boolean return_value = false;
        try
        {
            String query = "select * from MemberType where TypeName =?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, AdministratorPage.membership);
            ResultSet result_set = execute_query.executeQuery();
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
