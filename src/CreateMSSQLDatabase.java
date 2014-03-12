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

public class CreateMSSQLDatabase {

    public CreateMSSQLDatabase()
    {

        try
        {
            String query;

            Class.forName(ServerDetails.driver_string);
            if(ServerDetails.window_auth == true)
            {
                ServerDetails.server_connection = DriverManager.getConnection(ServerDetails.create_dsn_url + ";integratedSecurity=true");
            }
            else
            {
                ServerDetails.server_connection = DriverManager.getConnection(ServerDetails.create_dsn_url, ServerDetails.user_name, ServerDetails.password);
            }
            
            query = "create database Library";
            Statement execute_query = ServerDetails.server_connection.createStatement();
            execute_query.execute(query);

            query = "use Library";
            execute_query = ServerDetails.server_connection.createStatement();
            execute_query.execute(query);        

            query = "create table LibraryDetail"+
                    "(Name varchar(100) not null,"+
                    "SName varchar(15) not null,"+
                    "Address varchar(150) not null,"+
                    "ContactNo char(15) not null,"+
                    "EmailID varchar(50) not null,"+
                    "Website varchar(50) not null);";
            execute_query.execute(query);

            query = "create table Member"+
                    "(MemberID varchar(10) not null,"+
                    "Name varchar(100) not null,"+
                    "DateofBirth date not null,"+
                    "Gender char(10) not null,"+
                    "ContactNo char(10) not null,"+
                    "Address varchar(150) not null,"+
                    "EMailID varchar(50) not null,"+
                    "Photo image,"+
                    "constraint MeUniqueMember primary key (MemberID),"+
                    "constraint MeCheckGender check (Gender in ('Male', 'Female')),"+
                    "constraint MeCheckEMailID check (EMailID like '_%@_%._%'))";
            execute_query.execute(query);

            query = "create table MemberType"+
                    "(TypeID int identity(1,1) not null,"+
                    "TypeName varchar(25) not null,"+
                    "BookLimit tinyint not null,"+
                    "constraint MTUniqueMemberType primary key (TypeName),"+
                    "constraint MTUniqueTypeID unique (TypeID))";
            execute_query.execute(query);

            query = "create table Membership"+
                    "(MemberID varchar(10) not null,"+
                    "Type int not null,"+
                    "ValidUpto date,"+
                    "constraint MsUniqueMembership primary key (MemberID),"+
                    "constraint MsCheckMember foreign key (MemberID) references Member(MemberID),"+
                    "constraint MsCheckMembership foreign key (Type) references MemberType(TypeID))";
            execute_query.execute(query);

            query = "create table Book"+
                    "(ISBNNo varchar(20) not null,"+
                    "Title varchar(100) not null,"+
                    "Author varchar(50) not null,"+
                    "Publisher varchar(100) not null,"+
                    "Price money not null,"+
                    "constraint LBUniqueBookNo primary key (ISBNNo),"+
                    "constraint LBCheckPrice check (Price > 0))";
            execute_query.execute(query);

            query = "create table BookRecord"+
                    "(ReferenceNo varchar(25) not null,"+
                    "ISBNNo varchar(20) not null,"+
                    "Status char(15) not null,"+
                    "constraint LBRUniqueBook primary key (ReferenceNo),"+
                    "constraint LBRCheckBookNo foreign key (ISBNNo) references Book(ISBNNo),"+
                    "constraint LBRCheckStatus check (Status in ('Available', 'Issued')))";
            execute_query.execute(query);

            query = "create table CurrentlyIssued"+
                    "(MemberID varchar(10) not null,"+
                    "ReferenceNo varchar(25) not null,"+
                    "DateOfIssue date not null,"+
                    "DateofReturn date not null,"+
                    "constraint CIUniqueTransaction primary key (MemberID, ReferenceNo),"+
                    "constraint CIUniqueBook unique (ReferenceNo),"+
                    "constraint CICheckBook foreign key (ReferenceNo) references BookRecord(ReferenceNo),"+
                    "constraint CICheckMemberID foreign key (MemberID) references Member(MemberID))";
            execute_query.execute(query);

            query = "create table TotalTransaction"+
                    "(MemberID varchar(10) not null,"+
                    "ReferenceNo varchar(25) not null,"+
                    "DateOfIssue date not null,"+
                    "DateOfReturn date not null,"+
                    "Fine money not null default 0,"+
                    "constraint TTUniqueTransaction primary key (MemberID, ReferenceNo),"+
                    "constraint TTUniqueBook unique (ReferenceNo),"+
                    "constraint TTCheckBook foreign key (ReferenceNo) references BookRecord(ReferenceNo),"+
                    "constraint TTCheckMemberID foreign key (MemberID) references Member(MemberID),"+
                    "constraint TTCheckDate check (DateOfIssue < DateOfReturn))";
            execute_query.execute(query);

            query = "create table Leaves"+
                    "(MemberID varchar(10) not null,"+
                    "LeaveDate date not null,"+
                    "LeaveDetails varchar(150) not null,"+
                    "constraint LeUniqueLeave primary key (MemberID, LeaveDate),"+
                    "constraint LeCheckMember foreign key (MemberID) references Member(MemberID))";
            execute_query.execute(query);

            query = "create table Login"+
                    "(UserName varchar(25) not null,"+
                    "Password varchar(25) not null,"+
                    "MemberID varchar(10) not null,"+
                    "constraint LUniqueUserName primary key (UserName),"+
                    "constraint LCheckMember foreign key (MemberID) references Member(MemberID))";
            execute_query.execute(query);

            query = "insert into MemberType (TypeName, BookLimit) values ('Administrator', 0)";
            execute_query.executeUpdate(query);

            query = "insert into MemberType (TypeName, BookLimit)  values ('Librarian', 0)";
            execute_query.executeUpdate(query);

            query = "insert into MemberType (TypeName, BookLimit)  values ('Employee', 0)";
            execute_query.executeUpdate(query);

            query = "insert into Member (MemberID, Name, DateOfBirth, Gender, ContactNo, Address, EMailID, Photo) values ('admin','admin',GETDATE(),'Male','admin','admin','admin@admin.admin', null)";
            execute_query.executeUpdate(query);

            query = "insert into Login (UserName, Password, MemberID) values ('admin','admin','admin')";
            execute_query.executeUpdate(query);

            query = "insert into Membership (MemberID, Type, ValidUpto) values ('admin', 1, null)";
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
