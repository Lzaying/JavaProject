
CREATE TABLE Appointment(
	Appoitment_Id int IDENTIFIED(1,1); not NULL,#gaile
	Patient_Id char(20); NOT NULL,
	Time datetime NOT NULL,
	Department_Id int ;#gaile外键
 );
CREATE TABLE Department(
        Department_Id int identified(1,1) primarykey;
	Department varchar(20); NOT NULL,
	Information varchar(255); NULL,
	Room int NOT NULL
 );
CREATE TABLE Doctor(
	Id char(10); NOT NULL primarykey,
	Name varchar(10); NOT NULL,
	Department_Id int; NOT NULL 外键,
 );
CREATE TABLE Drug(
	Drug_Id int  identified(1,1) primarykey,
	Drug_Name char(10); NOT NULL,
	Price decimal NOT NULL,
	Unit char(10); NOT NULL,
	Amount int NOT NULL,
 );
CREATE TABLE Patient(
	Patient_Id char(20);primary key NOT NULL,
	Patient_Name varchar(10); NULL,
	Patient_Sex smallint; NULL,
	Patient_Age smallint NULL,
	IsMarried int NULL,
	Telephone char(11); NULL,
	Address varchar(50); NULL,
 );
CREATE TABLE Prescription(
	Drug_Id int NOT NULL,
	Patient_Id int; NOT NULL,
	Doctor_Id char(10); NOT NULL,
	Quantity int,
	IsPaid int NOT NULL
); 
CREATE TABLE Register(
	Register_Id int  identified(1,1) NOT NULL,
	Patient_Id char(20); NOT NULL,
	
	Doctor_Id char(10); NOT NULL,
	Time datetime NOT NULL,
	IsLooked int NOT NULL
); 
CREATE TABLE User(
	Id char(10); NOT NULL,外键
	Password varchar(20); NOT NULL,
	Role int NOT NULL,#1挂号2医生3
	Name varchar(10); NOT NULL,
 );