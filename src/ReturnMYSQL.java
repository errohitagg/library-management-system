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
public class ReturnMYSQL extends ReturnQuery {

    ResultSet retrieve_book()
    {
        ResultSet result_set = null;
        try
        {
            String query = "select * from CurrentlyIssued where MemberID=?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, Return.member_id);
            result_set = execute_query.executeQuery();            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application", "Server Error", JOptionPane.ERROR_MESSAGE);
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
            query = "delete from CurrentlyIssued where MemberID=? and ReferenceNo=?";
            execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, Return.member_id);
            execute_query.setString(2, Return.reference_no);
            execute_query.executeUpdate();

            query = "insert into TotalTransaction (MemberID, ReferenceNo, DateOfIssue, DateOfReturn) values (?,?,?,?)";
            execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, Return.member_id);
            execute_query.setString(2, Return.reference_no);
            execute_query.setDate(3, new Date(Return.date_of_issue.getTime().getYear(), Return.date_of_issue.getTime().getMonth(), Return.date_of_issue.getTime().getDate()));
            execute_query.setDate(4, new Date(Return.date_of_return.getTime().getYear(), Return.date_of_return.getTime().getMonth(), Return.date_of_return.getTime().getDate()));
            execute_query.executeUpdate();

            query = "update BookRecord set Status=? where ReferenceNo=?";
            execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, "Available");
            execute_query.setString(2, Return.reference_no);
            execute_query.executeUpdate();            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" + e , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

}
