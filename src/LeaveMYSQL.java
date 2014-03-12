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
public class LeaveMYSQL extends LeaveQuery {

    boolean check_employee()
    {
        boolean return_value = false;
        try
        {
            String query = "select * from Membership where MemberID = ? and Type=?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, Leave.employee_code);
            execute_query.setString(2, "Employee");
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

    void insert_values()
    {
        try
        {
            String query = "insert into Leaves (MemberID, LeaveDate, LeaveDetails) values (?,?,?)";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, Leave.employee_code);
            execute_query.setDate(2, new Date(Leave.leave_date.getTime().getYear(), Leave.leave_date.getTime().getMonth(), Leave.leave_date.getTime().getDate()));
            execute_query.setString(3, Leave.leave_details);
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
