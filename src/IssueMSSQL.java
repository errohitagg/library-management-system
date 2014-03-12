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
public class IssueMSSQL extends IssueQuery {

    boolean check_member()
    {
        boolean return_value = false;
        try
        {
            String query = "select * from Member where MemberID = ?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, Issue.member_id);
            ResultSet result_set = execute_query.executeQuery();
            if(result_set.next())
                return_value = true;
            execute_query.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(return_value);
    }

    boolean check_book()
    {
        String temp_status;
        boolean return_value = false;
        try
        {
            String query = "select * from BookRecord where ReferenceNo = ?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, Issue.reference_no);
            ResultSet result_set = execute_query.executeQuery();
            if(result_set.next())
            {
                temp_status = result_set.getString("Status");
                if(temp_status.trim().compareTo("Available") == 0)
                {
                    return_value = true;
                }
            }
            execute_query.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(return_value);
    }

    boolean check_book_count()
    {
        int temp_count = 0;
        boolean return_value = false;
        try
        {
            String query = "select * from Membership where MemberID = ?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, Issue.member_id);
            ResultSet result_set = execute_query.executeQuery();
            if(result_set.next())
            {
                temp_count = result_set.getInt("Type");
            }

            query = "select * from MemberType where TypeID = ?";
            execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setInt(1, temp_count);
            result_set = execute_query.executeQuery();
            if(result_set.next())
            {
                temp_count = result_set.getInt("BookLimit");
            }

            query = "select * from CurrentlyIssued where MemberID = ?";
            execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, Issue.member_id);
            result_set = execute_query.executeQuery();
            if(result_set.next())
            {
                if(result_set.getFetchSize() < temp_count)
                    return_value = true;
            }
            else
                return_value = true;
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(return_value);
    }

    void insert_values()
    {
        try
        {
            String query = "insert into CurrentlyIssued (MemberID, ReferenceNo, DateOfIssue, DateOfReturn) values (?,?,?,?)";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, Issue.member_id);
            execute_query.setString(2, Issue.reference_no);
            execute_query.setDate(3, new Date(Issue.date_of_issue.getTime().getYear(), Issue.date_of_issue.getTime().getMonth(), Issue.date_of_issue.getTime().getDate()));
            execute_query.setDate(4, new Date(Issue.date_of_return.getTime().getYear(), Issue.date_of_return.getTime().getMonth(), Issue.date_of_return.getTime().getDate()));
            execute_query.executeUpdate();
            execute_query.close();

            query = "update BookRecord set Status=? where ReferenceNo=?";
            execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, "Issued");
            execute_query.setString(2, Issue.reference_no);
            execute_query.executeUpdate();
            execute_query.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application"+e , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

}
