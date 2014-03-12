/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author Rohit Aggarwal
 */
public class NewMemberMSSQL extends NewMemberQuery{

    boolean check_member_id()
    {
         boolean return_value = true;
        try
        {
            String query = "select * from Member where MemberID = ?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, NewMember.member_id);
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
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(result_set);
    }

    void insert_values()
    {
        FileInputStream temp_image = null;
        int temp_type = 0;
        try
        {
            if(NewMember.image_file != null)
                temp_image = new FileInputStream(NewMember.image_file.getAbsolutePath());

            String query = "insert into Member (MemberID, Name, DateOfBirth, Gender, ContactNo, Address, EMailID, Photo) values (?,?,?,?,?,?,?,?)";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, NewMember.member_id);
            execute_query.setString(2, NewMember.name);
            execute_query.setDate(3, new Date(NewMember.date_of_birth.getTime().getYear(), NewMember.date_of_birth.getTime().getMonth(), NewMember.date_of_birth.getTime().getDate()));
            execute_query.setString(4, NewMember.gender);
            execute_query.setString(5, NewMember.contact_no);
            execute_query.setString(6, NewMember.address);
            execute_query.setString(7, NewMember.email_id);
            if(temp_image == null)
                execute_query.setNull(8, java.sql.Types.NULL);
            else
                execute_query.setBinaryStream(8, temp_image);
            execute_query.executeUpdate();
            execute_query.close();

            query = "select TypeID from MemberType where TypeName=?";
            execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, NewMember.membership);
            ResultSet result_set = execute_query.executeQuery();
            if(result_set.next())
                temp_type = result_set.getInt("TypeID");
            execute_query.close();

            query = "insert into Membership (MemberID, Type, ValidUpto) values (?,?,?)";
            execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, NewMember.member_id);
            execute_query.setInt(2, temp_type);
            execute_query.setDate(3, new Date(NewMember.validity.getTime().getYear(), NewMember.validity.getTime().getMonth(), NewMember.validity.getTime().getDate()));
            execute_query.executeUpdate();
            execute_query.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server1.\nCheck the server and restart the Application" +e, "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        catch(FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server2.\nCheck the server and restart the Application" + e, "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

}
