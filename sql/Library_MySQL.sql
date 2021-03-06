create database Library;

use Library;

create table LibraryDetail
(
	Name varchar(100) not null,
	SName varchar(15) not null,
	Address varchar(150) not null,
	ContactNo char(15) not null,
	EmailID varchar(50) not null,
	Website varchar(50) not null
);

create table Member
(
	MemberID varchar(10) not null,
	Name varchar(100) not null,
	DateOfBirth date not null,
	Gender char(10) not null,
	ContactNo char(10) not null,
	Address varchar(150) not null,
	EMailID varchar(50) not null,
	Photo blob,
	constraint MeUniqueMember primary key (MemberID),
	constraint MeCheckGender check (Gender in ('Male', 'Female')),
	constraint MeCheckEMailID check (EMailID like '_%@_%._%')
);

create table MemberType
(
	TypeID int auto_increment not null,
	TypeName varchar(25) not null,
	BookLimit tinyint not null,
	constraint MTUniqueMemberType primary key (TypeName),
	constraint MTUniqueTypeID unique (TypeID)
);

create table Membership
(
	MemberID varchar(10) not null,
	Type int not null,
	ValidUpto date,
	constraint MsUniqueMembership primary key (MemberID),
	constraint MsCheckMember foreign key (MemberID) references Member(MemberID),
	constraint MsCheckMembership foreign key (Type) references MemberType(TypeID)
);

create table Book
(
	ISBNNo varchar(20) not null,
	Title varchar(100) not null,
	Author varchar(50) not null,
	Publisher varchar(100) not null,
	Price smallint not null,
	constraint LBUniqueBookNo primary key (ISBNNo),
	constraint LBCheckPrice check (Price > 0)
);

create table BookRecord
(
	ReferenceNo varchar(25) not null,
	ISBNNo varchar(20) not null,
	Status char(15) not null,
	constraint LBRUniqueBook primary key (ReferenceNo),
	constraint LBRCheckBookNo foreign key (ISBNNo) references Book(ISBNNo),
	constraint LBRCheckStatus check (Status in ('Available', 'Issued'))
);

create table CurrentlyIssued
(
	MemberID varchar(10) not null,
	ReferenceNo varchar(25) not null,
	DateOfIssue date not null,
	DateofReturn date not null,
	constraint CIUniqueTransaction primary key (MemberID, ReferenceNo),
	constraint CIUniqueBook unique (ReferenceNo),
	constraint CICheckBook foreign key (ReferenceNo) references BookRecord(ReferenceNo),
	constraint CICheckMemberID foreign key (MemberID) references Member(MemberID)
);

create table TotalTransaction
(
	MemberID varchar(10) not null,
	ReferenceNo varchar(25) not null,
	DateOfIssue date not null,
	DateOfReturn date not null,
	Fine smallint not null default 0,
	constraint TTUniqueTransaction primary key (MemberID, ReferenceNo),
	constraint TTUniqueBook unique (ReferenceNo),
	constraint TTCheckBook foreign key (ReferenceNo) references BookRecord(ReferenceNo),
	constraint TTCheckMemberID foreign key (MemberID) references Member(MemberID),
	constraint TTCheckDate check (DateOfIssue < DateOfReturn)
);

create table Leaves
(
	MemberID varchar(10) not null,
	LeaveDate date not null,
	LeaveDetails varchar(150) not null,
	constraint LeUniqueLeave primary key (MemberID, LeaveDate),
	constraint LeCheckMember foreign key (MemberID) references Member(MemberID)
);

create table Login
(
	UserName varchar(25) not null,
	Password varchar(25) not null,
	MemberID varchar(10) not null,
	constraint LUniqueUserName primary key (UserName),
	constraint LCheckMember foreign key (MemberID) references Member(MemberID)
);

insert into MemberType values (1, 'Administrator', 0);
insert into MemberType values (2, 'Librarian', 0);
insert into MemberType values (3, 'Employee', 0);
insert into Member values ('admin','admin',now(),'Male','admin','admin','admin@admin.admin', null);
insert into Login values ('admin','admin','admin');
insert into Membership values ('admin', 1, null);