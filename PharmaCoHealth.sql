
CREATE DATABASE HospitalManagement
--DROP DATABASE HospitalManagement


CREATE TABLE ADMINISTRATOR(
AdminId int IDENTITY(1,1) PRIMARY KEY,
AdminFirstName varchar(20) NOT NULL,
AdminLastName varchar(20) NOT NULL,
AdminPhoneNo varchar(15) NOT NULL,
Email varchar(20) NOT NULL,
Password varchar(20) NOT NULL,
);

SELECT * FROM ADMINISTRATOR
--DROP TABLE ADMINISTRATOR


CREATE TABLE DOCTOR(

DoctorId int IDENTITY(1,1) PRIMARY KEY,
DoctorFirstName varchar(50) NOT NULL,
DoctorLastName varchar(20) NOT NULL,
Specialize varchar(20) NOT NULL,
DoctorPhoneNo varchar(15) NOT NULL,
Email varchar(20) NOT NULL,
Password varchar(20) NOT NULL,
);

SELECT * FROM DOCTOR

--DROP TABLE DOCTOR

CREATE TABLE PATIENT(

PatientId int IDENTITY(1,1) PRIMARY KEY,
PatientFirstName varchar(20) NOT NULL,
PatientLastName varchar(20) NOT NULL,
PatientPhoneNo varchar(15) NOT NULL,
Email varchar(20) NOT NULL,
Password varchar(20) NOT NULL,
);

SELECT * FROM PATIENT
--DROP TABLE PATIENT

CREATE TABLE PATIENTINFO(

PatientInfoId int IDENTITY(1,1) PRIMARY KEY,
PatientFirstName varchar(20) NOT NULL,
PatientLastName varchar(20) NOT NULL,
Age int NOT NULL,
Weight float NOT NULL,
Gender varchar(10) NOT NULL,
MedicalHistory varchar(50) NOT NULL,
BloodGrp varchar(50) NOT NULL,
PatientId int NOT NULL FOREIGN KEY REFERENCES PATIENT (PatientId),
);


SELECT * FROM PATIENTINFO
--DROP TABLE PATIENTINFO

CREATE TABLE PATIENTREPORT(  
ReportId int IDENTITY(1,1) PRIMARY KEY,
Symptom varchar(50) NOT NULL,
Diagnosis varchar(50) NOT NULL,
PrescribedMedicine varchar(50) NOT NULL,
DoctorId int NOT NULL FOREIGN KEY REFERENCES DOCTOR (DoctorId),
PatientId int NOT NULL FOREIGN KEY REFERENCES PATIENT (PatientId),
);

SELECT * FROM PATIENTREPORT
--DROP TABLE PATIENTREPORT


CREATE TABLE BloodBank
(
BloodGrp varchar(50) Primary key,
Amount decimal(8,2)
)

INSERT INTO BloodBank(BloodGrp, Amount)
VALUES('A-',10)

INSERT INTO BloodBank(BloodGrp, Amount)
VALUES('B+',65)

INSERT INTO BloodBank(BloodGrp, Amount)
VALUES('B-',5)

INSERT INTO BloodBank(BloodGrp, Amount)
VALUES('A+',50)

SELECT * FROM BloodBank
--DROP TABLE BloodBank


CREATE TABLE SCEDULE
(
	ScheduleID int IDENTITY(1,1) Primary Key,
	ScheduledTime varchar(50),
	PatientId int Foreign key references Patient(PatientId),
	DoctorId int Foreign key references Doctor(DoctorId),
);

SELECT * FROM  SCEDULE
--DROP TABLE SCEDULE



