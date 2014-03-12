/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Rohit Aggarwal
 */
public class ConnectServerType4
{
    public ConnectServerType4()
    {
        try
        {
            Class.forName(ServerDetails.driver_string);
            if(ServerDetails.database == Database.SQLSERVER)
            {
                if(ServerDetails.window_auth == true)
                {
                    ServerDetails.server_connection = DriverManager.getConnection(ServerDetails.dsn_url + ";integratedSecurity=true");
                    JOptionPane.showMessageDialog(null, "Successfully connected to server with windows authentication.", "Server Connected", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    ServerDetails.server_connection = DriverManager.getConnection(ServerDetails.dsn_url, ServerDetails.user_name, ServerDetails.password);
                    JOptionPane.showMessageDialog(null, "Successfully connected to server with user name : " + ServerDetails.user_name, "Server Connected", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else
            {
                ServerDetails.server_connection = DriverManager.getConnection(ServerDetails.dsn_url,ServerDetails.user_name,ServerDetails.password);
                JOptionPane.showMessageDialog(null, "Successfully connected to server with user name : " + ServerDetails.user_name, "Server Connected", JOptionPane.INFORMATION_MESSAGE);
            }            

            String query;
            Statement execute_query = ServerDetails.server_connection.createStatement();

            if(ServerDetails.database == Database.SQLSERVER)
            {
                query = "select * from LibraryDetail";
                ResultSet result_set = execute_query.executeQuery(query);
                if(result_set.next())
                {
                    ServerDetails.library_name = result_set.getString("SName");
                    Login login = new Login();
                    login.show();
                }
                else
                {
                    ServerDetails.login_user = "admin";
                    ServerDetails.invoker = Invoker.ADMINISTRATOR;
                    AdministratorPage admin_page = new AdministratorPage();
                    admin_page.show();
                }
            }
            else if(ServerDetails.database == Database.MYSQL)
            {
                query = "select * from LibraryDetail";
                ResultSet result_set = execute_query.executeQuery(query);
                if(result_set.next())
                {
                    ServerDetails.library_name = result_set.getString("SName");
                    Login login = new Login();
                    login.show();
                }
                else
                {
                    ServerDetails.login_user = "admin";
                    ServerDetails.invoker = Invoker.ADMINISTRATOR;
                    AdministratorPage admin_page = new AdministratorPage();
                    admin_page.show();
                }
            }
            else if(ServerDetails.database == Database.POSTGRESQL)
            {

            }
        }
        catch(ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, "Class not found for the given Driver String.\nRestart the Application.", "Server Error", JOptionPane.ERROR_MESSAGE);
            File server_file = new File("C:\\Server File.lms");
            server_file.delete();
            System.exit(0);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application.", "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
