/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author Rohit Aggarwal
 */
public class ReIssueMSSQL extends ReIssueQuery {  

    ResultSet retrieve_values()
    {
        ResultSet result_set = null;
        try
        {
            String query = "select * from CurrentlyIssued where MemberID=? and ReferenceNo=?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, ReIssue.member_id);
            execute_query.setString(2, ReIssue.reference_no);
            result_set = execute_query.executeQuery();            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" + e, "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(result_set);
    }

    void insert_values()
    {
        String query;
        PreparedStatement execute_query;
        try
        {
            query = "insert into TotalTransactions (MemberID, ReferenceNo, DateOfIssue, DateOfReturn) values (?,?,?,?)";
            execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, ReIssue.member_id);
            execute_query.setString(2, ReIssue.reference_no);
            execute_query.setDate(3, new Date(ReIssue.date_of_issue.getTime().getYear(), ReIssue.date_of_issue.getTime().getMonth(), ReIssue.date_of_issue.getTime().getDate()));
            execute_query.setDate(4, new Date(ReIssue.date_of_return.getTime().getYear(), ReIssue.date_of_return.getTime().getMonth(), ReIssue.date_of_return.getTime().getDate()));
            execute_query.executeUpdate();

            query = "update CurrentIssued set DateOfIssue=? and DateOfReturn=? where MemberID=? and ReferenceNo=?";
            execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setDate(1, new Date(ReIssue.date_of_issue_new.getTime().getYear(), ReIssue.date_of_issue_new.getTime().getMonth(), ReIssue.date_of_issue_new.getTime().getDate()));
            execute_query.setDate(2, new Date(ReIssue.date_of_return_new.getTime().getYear(), ReIssue.date_of_return_new.getTime().getMonth(), ReIssue.date_of_return_new.getTime().getDate()));
            execute_query.setString(3, ReIssue.member_id);
            execute_query.setString(4, ReIssue.reference_no);
            execute_query.executeUpdate();

        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

}
