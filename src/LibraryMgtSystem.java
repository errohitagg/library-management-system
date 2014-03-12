/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Rohit Aggarwal
 */
public class LibraryMgtSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
            FileReader server_file = new FileReader("C:\\Server File.lms");
            BufferedReader read_server_file = new BufferedReader(server_file);
            String temp = read_server_file.readLine();
            if(temp.compareTo("Microsoft Access") == 0)
                ServerDetails.database = Database.MSACCESS;
            else if(temp.compareTo("Microsoft SQL Server") == 0)
                ServerDetails.database = Database.SQLSERVER;
            else if(temp.compareTo("MySQL") == 0)
                ServerDetails.database = Database.MYSQL;
            else if(temp.compareTo("PostgreSQL") == 0)
                ServerDetails.database = Database.POSTGRESQL;
            ServerDetails.driver_type = read_server_file.readLine();
            ServerDetails.driver_string = read_server_file.readLine();
            ServerDetails.dsn_url = read_server_file.readLine();
            ServerDetails.window_auth = Boolean.parseBoolean(read_server_file.readLine());
            ServerDetails.user_name = read_server_file.readLine();
            ServerDetails.password = read_server_file.readLine();
            read_server_file.close();
            server_file.close();
            if(ServerDetails.driver_type.compareTo("Type 1") == 0)
            {
                new ConnectServerType1();
            }
            else if(ServerDetails.driver_type.compareTo("Type 4") == 0)
            {
                new ConnectServerType4();
            }            
        }
        catch(FileNotFoundException e)
        {
            ServerDetails server_details = new ServerDetails();
            server_details.show();
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null,"Server File can't be accessed.\nRestart the application and try again.","Server File",JOptionPane.ERROR_MESSAGE);
        }
    }

}
