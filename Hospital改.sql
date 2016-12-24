use hospital5

CREATE TABLE Patient(
	Patient_Id varchar(20)primary key NOT NULL,
	Patient_Name varchar(10) NULL,
	Patient_Sex smallint NULL,
	Patient_Age int NULL,
	IsMarried int NULL,
	Telephone char(11) NULL,
	Address varchar(255) NULL,
 )

 CREATE TABLE Userinfo(
    
	id varchar(20) NOT NULL primary key,
	Password varchar(20) NOT NULL,
	Role int NOT NULL
	
 )
  CREATE TABLE Department(
    Department_Id int not null identity(1,1) primary key,
	Department varchar(20) NOT NULL,
	Information varchar(255) NULL,
	Room int NOT NULL
 )
 CREATE TABLE Doctor(
	doctor_Id varchar(20) NOT NULL primary key references userinfo(id),
	Name varchar(10) NOT NULL,
	Department_Id int NOT NULL references department(department_id) 
 )


CREATE TABLE Appointment(
	Appoitment_Id int not NULL identity(1,1)  primary key,
	Patient_Id varchar(20) NOT NULL references patient(patient_id),
	Time datetime NOT NULL,
	doctor_Id varchar(20) references doctor(doctor_id)
 )


CREATE TABLE Drug(
	Drug_Id int  identity(1,1) primary key,
	Drug_Name char(10) NOT NULL,
	Price decimal NOT NULL,
	Unit char(10) NOT NULL,
	Amount int NOT NULL,
 )

CREATE TABLE Prescription(
    ID int  not null identity(1,1) primary key,
	Drug_Id int NOT NULL references drug(drug_id),
	Patient_Id varchar(20) NOT NULL references patient(patient_id) ,
	Doctor_Id varchar(20) NOT NULL references doctor(doctor_id),
	Quantity int,
	IsPaid int NOT NULL
) 
CREATE TABLE Register(
	Register_Id int  identity(1,1) NOT NULL,
	Patient_Id varchar(20) NOT NULL references patient(patient_id),
	
	Doctor_Id varchar(20) NOT NULL references doctor(doctor_id),
	Time datetime NOT NULL,
	IsLooked int NOT NULL
) 
