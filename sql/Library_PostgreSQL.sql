CREATE DATABASE "Library";

CREATE TABLE "LibraryDetail"
(
  "Name" character varying(100) NOT NULL,
  "SName" character varying(15) NOT NULL,
  "Address" character varying(150) NOT NULL,
  "ContactNo" character(15) NOT NULL,
  "EMailID" character varying(50) NOT NULL,
  "Website" character varying(50) NOT NULL
);

CREATE TABLE "Member"
(
  "MemberID" character varying(10) NOT NULL,
  "Name" character varying(100) NOT NULL,
  "DateOfBirth" date NOT NULL,
  "Gender" character(10) NOT NULL,
  "ContactNo" character(10) NOT NULL,
  "Address" character varying(150) NOT NULL,
  "EMailID" character varying(50) NOT NULL,
  "Image" bytea,
  CONSTRAINT "MeUniqueMember" PRIMARY KEY ("MemberID"),
  CONSTRAINT "MeCheckEMailID" CHECK ("EMailID"::text ~~ '_%@_%._%'::text),
  CONSTRAINT "MeCheckGender" CHECK ("Gender" = ANY (ARRAY['Male'::bpchar, 'Female'::bpchar]))
);

CREATE TABLE "MemberType"
(
  "TypeID" serial NOT NULL,
  "TypeName" character varying(25) NOT NULL,
  "BookLimit" smallint NOT NULL,
  CONSTRAINT "MTUniqueMemberType" PRIMARY KEY ("TypeName"),
  CONSTRAINT "MTUniqueTypeID" UNIQUE ("TypeID")
);

CREATE TABLE "Membership"
(
  "MemberID" character varying(10) NOT NULL,
  "Type" integer NOT NULL,
  "ValidUpto" date,
  CONSTRAINT "MsUniqueMembership" PRIMARY KEY ("MemberID"),
  CONSTRAINT "MsCheckMember" FOREIGN KEY ("MemberID") REFERENCES "Member" ("MemberID") MATCH FULL ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT "MsCheckMembership" FOREIGN KEY ("Type") REFERENCES "MemberType" ("TypeID") MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

CREATE TABLE "Book"
(
  "ISBNNo" character varying(20) NOT NULL,
  "Title" character varying(100) NOT NULL,
  "Author" character varying(50) NOT NULL,
  "Publisher" character varying(100) NOT NULL,
  "Price" numeric NOT NULL,
  CONSTRAINT "LBUniqueBookNo" PRIMARY KEY ("ISBNNo"),
  CONSTRAINT "LBCheckPrice" CHECK ("Price" < 0::numeric)
);

CREATE TABLE "BookRecord"
(
  "ReferenceNo" character varying(25) NOT NULL,
  "ISBNNo" character varying(20) NOT NULL,
  "Status" character(15) NOT NULL,
  CONSTRAINT "LBRUniqueBook" PRIMARY KEY ("ReferenceNo"),
  CONSTRAINT "LBRCheckBookNo" FOREIGN KEY ("ISBNNo") REFERENCES "Book" ("ISBNNo") MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT "LBRCheckStatus" CHECK ("Status" = ANY (ARRAY['Available'::bpchar, 'Issued'::bpchar]))
);

CREATE TABLE "CurrentlyIssued"
(
  "MemberID" character varying(10) NOT NULL,
  "ReferenceNo" character varying(25) NOT NULL,
  "DateOfIssue" date NOT NULL,
  "DateOfReturn" date NOT NULL,
  CONSTRAINT "CIUniqueTransaction" PRIMARY KEY ("MemberID", "ReferenceNo"),
  CONSTRAINT "CICheckBook" FOREIGN KEY ("ReferenceNo") REFERENCES "BookRecord" ("ReferenceNo") MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT "CICheckMemberID" FOREIGN KEY ("MemberID") REFERENCES "Member" ("MemberID") MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT "CIUniqueBook" UNIQUE ("ReferenceNo")
);

CREATE TABLE "TotalTransaction"
(
  "MemberID" character varying(10) NOT NULL,
  "ReferenceNo" character varying(25) NOT NULL,
  "DateOfIssue" date NOT NULL,
  "DateOfReturn" date NOT NULL,
  "Fine" numeric NOT NULL DEFAULT 0,
  CONSTRAINT "TTUniqueTransaction" PRIMARY KEY ("MemberID", "ReferenceNo"),
  CONSTRAINT "TTCheckBook" FOREIGN KEY ("ReferenceNo") REFERENCES "BookRecord" ("ReferenceNo") MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT "TTCheckMemberID" FOREIGN KEY ("MemberID") REFERENCES "Member" ("MemberID") MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT "TTUniqueBook" UNIQUE ("ReferenceNo"),
  CONSTRAINT "TTCheckDate" CHECK ("DateOfIssue" < "DateOfReturn")
);

CREATE TABLE "Leaves"
(
  "MemberID" character varying(10) NOT NULL,
  "LeaveDate" date NOT NULL,
  "LeaveDetails" character varying(150) NOT NULL,
  CONSTRAINT "LeUniqueLeave" PRIMARY KEY ("MemberID", "LeaveDate"),
  CONSTRAINT "LeCheckMember" FOREIGN KEY ("MemberID") REFERENCES "Member" ("MemberID") MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

CREATE TABLE "Login"
(
  "UserName" character varying(25) NOT NULL,
  "Password" character varying(25) NOT NULL,
  "MemberID" character varying(10) NOT NULL,
  CONSTRAINT "LUniqueUserName" PRIMARY KEY ("UserName"),
  CONSTRAINT "LCheckMember" FOREIGN KEY ("MemberID") REFERENCES "Member" ("MemberID") MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

insert into "MemberType" ("TypeName", "BookLimit") values ('Administrator', 0)
insert into "MemberType" ("TypeName", "BookLimit")  values ('Librarian', 0)
insert into "MemberType" ("TypeName", "BookLimit")  values ('Employee', 0)
insert into "Member" values ('admin','admin',CURRENT_DATE,'Male','admin','admin','admin@admin.admin', null)
insert into "Login" values ('admin','admin','admin')
insert into "Membership" values ('admin', 1, null)