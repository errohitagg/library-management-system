
import java.sql.*;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rohit Aggarwal
 */
public class SearchBookMSSQL extends SearchBookQuery {

    ResultSet retrieve_books()
    {
        ResultSet return_value = null;
        try
        {
            String query = "select * from Book join BookRecord on Book.ISBNNo = BookRecord.ISBNNo where ";
            if(SearchBook.search_type.compareTo("BookName") == 0)
                query += "Book.Title like ?";
            else if(SearchBook.search_type.compareTo("ISBNNo") == 0)
                query += "Book.ISBNNo like ?";
            else if(SearchBook.search_type.compareTo("Author") == 0)
                query += "Book.Author like ?";
            else if(SearchBook.search_type.compareTo("Publisher") == 0)
                query += "Book.Publisher like ?";
            PreparedStatement execute_query = ServerDetails.server_connection.prepareStatement(query);
            execute_query.setString(1, "%" + SearchBook.search_text + "%");
            return_value = execute_query.executeQuery();            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application", "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return(return_value);
    }

}
