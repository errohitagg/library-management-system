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

public class CreateMySQLDatabase {

    public CreateMySQLDatabase()
    {

        try
        {
            String query;

            Class.forName(ServerDetails.driver_string);
            ServerDetails.server_connection = DriverManager.getConnection(ServerDetails.create_dsn_url, ServerDetails.user_name, ServerDetails.password);

            query = "create database Library;";
            Statement execute_query = ServerDetails.server_connection.createStatement();
            execute_query.execute(query);

            query = "use Library;";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.execute(query);

            query = "create table LibraryDetail";
            query += "(Name varchar(100) not null,";
            query += "SName varchar(15) not null,";
            query += "Address varchar(150) not null,";
            query += "ContactNo char(15) not null,";
            query += "EmailID varchar(50) not null,";
            query += "Website varchar(50) not null);";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.execute(query);

            query = "create table Member";
            query += "(MemberID varchar(10) not null,";
            query += "Name varchar(100) not null,";
            query += "DateOfBirth date not null,";
            query += "Gender char(10) not null,";
            query += "ContactNo char(10) not null,";
            query += "Address varchar(150) not null,";
            query += "EMailID varchar(50) not null,";
            query += "Photo blob,";
            query += "constraint MeUniqueMember primary key (MemberID),";
            query += "constraint MeCheckGender check (Gender in ('Male', 'Female')),";
            query += "constraint MeCheckEMailID check (EMailID like '_%@_%._%'));";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.execute(query);

            query = "create table MemberType";
            query += "(TypeID int auto_increment not null,";
            query += "TypeName varchar(25) not null,";
            query += "BookLimit tinyint not null,";
            query += "constraint MTUniqueMemberType primary key (TypeName),";
            query += "constraint MTUniqueTypeID unique (TypeID));";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.execute(query);

            query = "create table Membership";
            query += "(MemberID varchar(10) not null,";
            query += "Type int not null,";
            query += "ValidUpto date,";
            query += "constraint MsUniqueMembership primary key (MemberID),";
            query += "constraint MsCheckMember foreign key (MemberID) references Member(MemberID),";
            query += "constraint MsCheckMembership foreign key (Type) references MemberType(TypeID));";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.execute(query);

            query = "create table Book";
            query += "(ISBNNo varchar(20) not null,";
            query += "Title varchar(100) not null,";
            query += "Author varchar(50) not null,";
            query += "Publisher varchar(100) not null,";
            query += "Price smallint not null,";
            query += "constraint LBUniqueBookNo primary key (ISBNNo),";
            query += "constraint LBCheckPrice check (Price > 0));";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.execute(query);

            query = "create table BookRecord";
            query += "(ReferenceNo varchar(25) not null,";
            query += "ISBNNo varchar(20) not null,";
            query += "Status char(15) not null,";
            query += "constraint LBRUniqueBook primary key (ReferenceNo),";
            query += "constraint LBRCheckBookNo foreign key (ISBNNo) references Book(ISBNNo),";
            query += "constraint LBRCheckStatus check (Status in ('Available', 'Issued')));";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.execute(query);

            query = "create table CurrentlyIssued";
            query += "(MemberID varchar(10) not null,";
            query += "ReferenceNo varchar(25) not null,";
            query += "DateOfIssue date not null,";
            query += "DateofReturn date not null,";
            query += "constraint CIUniqueTransaction primary key (MemberID, ReferenceNo),";
            query += "constraint CIUniqueBook unique (ReferenceNo),";
            query += "constraint CICheckBook foreign key (ReferenceNo) references BookRecord(ReferenceNo),";
            query += "constraint CICheckMemberID foreign key (MemberID) references Member(MemberID));";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.execute(query);

            query = "create table TotalTransaction";
            query += "(MemberID varchar(10) not null,";
            query += "ReferenceNo varchar(25) not null,";
            query += "DateOfIssue date not null,";
            query += "DateOfReturn date not null,";
            query += "Fine smallint not null default 0,";
            query += "constraint TTUniqueTransaction primary key (MemberID, ReferenceNo),";
            query += "constraint TTUniqueBook unique (ReferenceNo),";
            query += "constraint TTCheckBook foreign key (ReferenceNo) references BookRecord(ReferenceNo),";
            query += "constraint TTCheckMemberID foreign key (MemberID) references Member(MemberID),";
            query += "constraint TTCheckDate check (DateOfIssue < DateOfReturn));";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.execute(query);

            query = "create table Leaves";
            query += "(MemberID varchar(10) not null,";
            query += "LeaveDate date not null,";
            query += "LeaveDetails varchar(150) not null,";
            query += "constraint LeUniqueLeave primary key (MemberID, LeaveDate),";
            query += "constraint LeCheckMember foreign key (MemberID) references Member(MemberID));";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.execute(query);

            query = "create table Login";
            query += "(UserName varchar(25) not null,";
            query += "Password varchar(25) not null,";
            query += "MemberID varchar(10) not null,";
            query += "constraint LUniqueUserName primary key (UserName),";
            query += "constraint LCheckMember foreign key (MemberID) references Member(MemberID));";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.execute(query);

            query = "insert into MemberType (TypeName, BookLimit) values (1, 'Administrator', 0);";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.executeUpdate(query);

            query = "insert into MemberType (TypeName, BookLimit) values (2, 'Librarian', 0);";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.executeUpdate(query);

            query = "insert into MemberType (TypeName, BookLimit) values (3, 'Employee', 0);";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.executeUpdate(query);

            query = "insert into Member (MemberID, Name, DateOfBirth, Gender, ContactNo, Address, EMailID, Photo) values ('admin','admin',now(),'Male','admin','admin','admin@admin.admin', null);";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.executeUpdate(query);

            query = "insert into Login (UserName, Password, MemberID) values ('admin','admin','admin');";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.executeUpdate(query);

            query = "insert into Membership (MemberID, Type, ValidUpto) values ('admin', 1, null);";
            execute_query = ServerDetails.server_connection.createStatement();
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
            JOptionPane.showMessageDialog(null ,"Database couldn't be created.\nCheck the server and restart the Application" + e, "Server Error", JOptionPane.ERROR_MESSAGE);
            File server_file = new File("C:\\Server File.lms");
            server_file.delete();
            System.exit(0);
        }

    }
}
