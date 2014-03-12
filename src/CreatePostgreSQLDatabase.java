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

public class CreatePostgreSQLDatabase {

    public CreatePostgreSQLDatabase()
    {
        try
        {
            String query;

            Class.forName(ServerDetails.driver_string);
            ServerDetails.server_connection = DriverManager.getConnection(ServerDetails.create_dsn_url, ServerDetails.user_name, ServerDetails.password);

            query = "create database \"Library\";";
            Statement execute_query = ServerDetails.server_connection.createStatement();
            execute_query.execute(query);

            ServerDetails.server_connection = DriverManager.getConnection(ServerDetails.dsn_url, ServerDetails.user_name, ServerDetails.password);

            query = "CREATE TABLE \"LibraryDetail\"";
            query += "(\"Name\" character varying(100) NOT NULL,";
            query += "\"SName\" character varying(15) NOT NULL,";
            query += "\"Address\" character varying(150) NOT NULL,";
            query += "\"ContactNo\" character(15) NOT NULL,";
            query += "\"EMailID\" character varying(50) NOT NULL,";
            query += "\"Website\" character varying(50) NOT NULL);";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.execute(query);

            query = "CREATE TABLE \"Member\"";
            query += "(\"MemberID\" character varying(10) NOT NULL,";
            query += "\"Name\" character varying(100) NOT NULL,";
            query += "\"DateOfBirth\" date NOT NULL,";
            query += "\"Gender\" character(10) NOT NULL,";
            query += "\"ContactNo\" character(10) NOT NULL,";
            query += "\"Address\" character varying(150) NOT NULL,";
            query += "\"EMailID\" character varying(50) NOT NULL,";
            query += "\"Image\" bytea,";
            query += "CONSTRAINT \"MeUniqueMember\" PRIMARY KEY (\"MemberID\"),";
            query += "CONSTRAINT \"MeCheckEMailID\" CHECK (\"EMailID\"::text ~~ '_%@_%._%'::text),";
            query += "CONSTRAINT \"MeCheckGender\" CHECK (\"Gender\" = ANY (ARRAY['Male'::bpchar, 'Female'::bpchar])));";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.execute(query);

            query = "CREATE TABLE \"MemberType\"";
            query += "(\"TypeID\" serial NOT NULL,";
            query += "\"TypeName\" character varying(25) NOT NULL,";
            query += "\"BookLimit\" smallint NOT NULL,";
            query += "CONSTRAINT \"MTUniqueMemberType\" PRIMARY KEY (\"TypeName\"),";
            query += "CONSTRAINT \"MTUniqueTypeID\" UNIQUE (\"TypeID\"));";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.execute(query);

            query = "CREATE TABLE \"Membership\"";
            query += "(\"MemberID\" character varying(10) NOT NULL,";
            query += "\"Type\" integer NOT NULL,";
            query += "\"ValidUpto\" date,";
            query += "CONSTRAINT \"MsUniqueMembership\" PRIMARY KEY (\"MemberID\"),";
            query += "CONSTRAINT \"MsCheckMember\" FOREIGN KEY (\"MemberID\") REFERENCES \"Member\" (\"MemberID\") MATCH FULL ON UPDATE RESTRICT ON DELETE RESTRICT,";
            query += "CONSTRAINT \"MsCheckMembership\" FOREIGN KEY (\"Type\") REFERENCES \"MemberType\" (\"TypeID\") MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT);";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.execute(query);

            query = "CREATE TABLE \"Book\"";
            query += "(\"ISBNNo\" character varying(20) NOT NULL,";
            query += "\"Title\" character varying(100) NOT NULL,";
            query += "\"Author\" character varying(50) NOT NULL,";
            query += "\"Publisher\" character varying(100) NOT NULL,";
            query += "\"Price\" numeric NOT NULL,";
            query += "CONSTRAINT \"LBUniqueBookNo\" PRIMARY KEY (\"ISBNNo\"),";
            query += "CONSTRAINT \"LBCheckPrice\" CHECK (\"Price\" < 0::numeric));";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.execute(query);

            query = "CREATE TABLE \"BookRecord\"";
            query += "(\"ReferenceNo\" character varying(25) NOT NULL,";
            query += "\"ISBNNo\" character varying(20) NOT NULL,";
            query += "\"Status\" character(15) NOT NULL,";
            query += "CONSTRAINT \"LBRUniqueBook\" PRIMARY KEY (\"ReferenceNo\"),";
            query += "CONSTRAINT \"LBRCheckBookNo\" FOREIGN KEY (\"ISBNNo\") REFERENCES \"Book\" (\"ISBNNo\") MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,";
            query += "CONSTRAINT \"LBRCheckStatus\" CHECK (\"Status\" = ANY (ARRAY['Available'::bpchar, 'Issued'::bpchar])));";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.execute(query);

            query = "CREATE TABLE \"CurrentlyIssued\"";
            query += "(\"MemberID\" character varying(10) NOT NULL,";
            query += "\"ReferenceNo\" character varying(25) NOT NULL,";
            query += "\"DateOfIssue\" date NOT NULL,";
            query += "\"DateOfReturn\" date NOT NULL,";
            query += "CONSTRAINT \"CIUniqueTransaction\" PRIMARY KEY (\"MemberID\", \"ReferenceNo\"),";
            query += "CONSTRAINT \"CICheckBook\" FOREIGN KEY (\"ReferenceNo\") REFERENCES \"BookRecord\" (\"ReferenceNo\") MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,";
            query += "CONSTRAINT \"CICheckMemberID\" FOREIGN KEY (\"MemberID\") REFERENCES \"Member\" (\"MemberID\") MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,";
            query += "CONSTRAINT \"CIUniqueBook\" UNIQUE (\"ReferenceNo\"));";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.execute(query);

            query = "CREATE TABLE \"TotalTransaction\"";
            query += "(\"MemberID\" character varying(10) NOT NULL,";
            query += "\"ReferenceNo\" character varying(25) NOT NULL,";
            query += "\"DateOfIssue\" date NOT NULL,";
            query += "\"DateOfReturn\" date NOT NULL,";
            query += "\"Fine\" numeric NOT NULL DEFAULT 0,";
            query += "CONSTRAINT \"TTUniqueTransaction\" PRIMARY KEY (\"MemberID\", \"ReferenceNo\"),";
            query += "CONSTRAINT \"TTCheckBook\" FOREIGN KEY (\"ReferenceNo\") REFERENCES \"BookRecord\" (\"ReferenceNo\") MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,";
            query += "CONSTRAINT \"TTCheckMemberID\" FOREIGN KEY (\"MemberID\") REFERENCES \"Member\" (\"MemberID\") MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,";
            query += "CONSTRAINT \"TTUniqueBook\" UNIQUE (\"ReferenceNo\"),";
            query += "CONSTRAINT \"TTCheckDate\" CHECK (\"DateOfIssue\" < \"DateOfReturn\"));";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.execute(query);

            query = "CREATE TABLE \"Leaves\"";
            query += "(\"MemberID\" character varying(10) NOT NULL,";
            query += "\"LeaveDate\" date NOT NULL,";
            query += "\"LeaveDetails\" character varying(150) NOT NULL,";
            query += "CONSTRAINT \"LeUniqueLeave\" PRIMARY KEY (\"MemberID\", \"LeaveDate\"),";
            query += "CONSTRAINT \"LeCheckMember\" FOREIGN KEY (\"MemberID\") REFERENCES \"Member\" (\"MemberID\") MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT);";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.execute(query);            

            query = "CREATE TABLE \"Login\"";
            query += "(\"UserName\" character varying(25) NOT NULL,";
            query += "\"Password\" character varying(25) NOT NULL,";
            query += "\"MemberID\" character varying(10) NOT NULL,";
            query += "CONSTRAINT \"LUniqueUserName\" PRIMARY KEY (\"UserName\"),";
            query += "CONSTRAINT \"LCheckMember\" FOREIGN KEY (\"MemberID\") REFERENCES \"Member\" (\"MemberID\") MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT);";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.execute(query);

            query = "insert into \"MemberType\" (\"TypeName\", \"BookLimit\") values ('Administrator', 0)";
            execute_query.executeUpdate(query);

            query = "insert into \"MemberType\" (\"TypeName\", \"BookLimit\")  values ('Librarian', 0)";
            execute_query.executeUpdate(query);

            query = "insert into \"MemberType\" (\"TypeName\", \"BookLimit\")  values ('Employee', 0)";
            execute_query.executeUpdate(query);

            query = "insert into \"Member\"  (\"MemberID\", \"Name\", \"DateOfBirth\", \"Gender\", \"ContactNo\", \"Address\", \"EMailID\", \"Photo\")  values ('admin','admin',CURRENT_DATE,'Male','admin','admin','admin@admin.admin', null)";
            execute_query.executeUpdate(query);

            query = "insert into \"Login\" (\"UserName\", \"Password\", \"MemberID\") values ('admin','admin','admin')";
            execute_query.executeUpdate(query);

            query = "insert into \"Membership\" (\"MemberID\", \"Type\", \"ValidUpto\") values ('admin', 1, null)";
            execute_query.executeUpdate(query);

            new ConnectServerType4();
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
            JOptionPane.showMessageDialog(null ,"Database couldn't be created.\nCheck the server and restart the Application", "Server Error", JOptionPane.ERROR_MESSAGE);
            File server_file = new File("C:\\Server File.lms");
            server_file.delete();
            System.exit(0);
        }
    }
}
