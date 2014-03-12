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
public class NewBookMSSQL extends NewBookQuery {

    boolean check_book()
    {
        boolean return_value = false;
        try
        {
            String query = "select * from Book where ISBNNo=?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, NewBook.isbn_no);
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

    void insert_values()
    {
        try
        {
            String query = "insert into Book (ISBNNo, Title, Author, Publisher, Price) values (?,?,?,?,?)";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, NewBook.isbn_no);
            execute_query.setString(2, NewBook.title);
            execute_query.setString(3, NewBook.author);
            execute_query.setString(4, NewBook.publisher);
            execute_query.setInt(5, (int)NewBook.price);
            execute_query.executeUpdate();
            execute_query.close();

            for(int i=0; i<NewBook.book_count; i++)
            {
                query = "insert into BookRecord (ReferenceNo, ISBNNo, Status) values (?,?,?)";
                execute_query = ServerDetails.server_connection.prepareStatement(query);
                execute_query.setString(1, String.valueOf(NewBook.reference_no.get(i).getText()));
                execute_query.setString(2, NewBook.isbn_no);
                execute_query.setString(3, "Available");
                execute_query.executeUpdate();
                execute_query.close();
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" +e , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

}
