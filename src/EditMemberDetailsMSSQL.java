/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author Rohit Aggarwal
 */
public class EditMemberDetailsMSSQL extends EditMemberDetailsQuery {

    boolean check_member_id()
    {
        boolean return_value = true;
        try
        {
            String query = "select * from Member where MemberID = ?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, EditMemberDetails.member_id);
            ResultSet result_set = execute_query.executeQuery();
            if(result_set.next())
                return_value=false;            
            execute_query.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(return_value);
    }

    ResultSet retrieve_memberships()
    {
        ResultSet result_set = null;
        try
        {
            String query = "select TypeName from MemberType";
            Statement execute_query = ServerDetails.server_connection.createStatement();
            result_set = execute_query.executeQuery(query);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server1.\nCheck the server and restart the Application" , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(result_set);
    }

    ResultSet retrieve_values()
    {
        ResultSet result_set = null;
        try
        {
            String query = "select * from Member where MemberID=?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, EditMemberDetails.member_id);
            result_set = execute_query.executeQuery();            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(result_set);
    }

    ResultSet retrieve_values_()
    {
        int temp_type = 0;
        ResultSet result_set = null;
        try
        {
            String query = "select Type from Membership where MemberID=?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, EditMemberDetails.member_id);
            result_set = execute_query.executeQuery();
            if(result_set.next())
                temp_type= result_set.getInt("Type");
                        
            query = "select TypeName from MemberType where TypeID=?";
            execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setInt(1, temp_type);
            result_set = execute_query.executeQuery();
            if(result_set.next())
                result_set = execute_query.executeQuery();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" +e , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(result_set);
    }

    ResultSet _retrieve_values_()
    {
        ResultSet result_set = null;
        try
        {
            String query = "select * from Membership where MemberID=?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, EditMemberDetails.member_id);
            result_set = execute_query.executeQuery();            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(result_set);
    }

    void insert_values()
    {
        FileInputStream temp_image = null;
        int temp_id = 0;
        try
        {
            if(EditMemberDetails.image_file != null)
                temp_image = new FileInputStream(EditMemberDetails.image_file.getAbsolutePath());

            String query = "update Member set Name=?, DateOfBirth=?, Gender=?, ContactNo=?, Address=?, EmailID=?, Photo=? where MemberID=?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, EditMemberDetails.name);
            execute_query.setDate(2, new Date(EditMemberDetails.date_of_birth.getTime().getYear(), EditMemberDetails.date_of_birth.getTime().getMonth(), EditMemberDetails.date_of_birth.getTime().getDate()));
            execute_query.setString(3, EditMemberDetails.gender);
            execute_query.setString(4, EditMemberDetails.contact_no);
            execute_query.setString(5, EditMemberDetails.address);
            execute_query.setString(6, EditMemberDetails.email_id);
            if(temp_image == null)
                execute_query.setBlob(7, EditMemberDetails.image_value);
            else
                execute_query.setBinaryStream(7, temp_image);
            
            execute_query.setString(8, EditMemberDetails.member_id);
            execute_query.executeUpdate();

            query = "select * from MemberType where TypeName=?";
            execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, EditMemberDetails.membership);
            ResultSet result_set = execute_query.executeQuery();
            result_set.next();
            temp_id = result_set.getInt("TypeID");

            query = "select * from Membership where MemberID=?";
            execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, EditMemberDetails.member_id);
            result_set = execute_query.executeQuery();
            if(result_set.next())
            {
                query = "update Membership set Type=?, ValidUpto=? where MemberID=?";
                execute_query = ServerDetails.server_connection.prepareStatement(query);
                execute_query.setInt(1, temp_id);
                execute_query.setDate(2, new Date(EditMemberDetails.validity.getTime().getYear(), EditMemberDetails.validity.getTime().getMonth(), EditMemberDetails.validity.getTime().getDate()));
                execute_query.setString(3, EditMemberDetails.member_id);
                execute_query.executeUpdate();
            }
            else
            {
                query = "insert into Membership (Type, ValidUpto, MemberID) values (?,?,?)";
                execute_query = ServerDetails.server_connection.prepareStatement(query);
                execute_query.setInt(1, temp_id);
                execute_query.setDate(2, new Date(EditMemberDetails.validity.getTime().getYear(), EditMemberDetails.validity.getTime().getMonth(), EditMemberDetails.validity.getTime().getDate()));
                execute_query.setString(3, EditMemberDetails.member_id);
                execute_query.executeUpdate();
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" + e, "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        catch(FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

}
