create database lab2;

CREATE TABLE Employee(
       EmpNo varchar(5) PRIMARY KEY,
       EmpName varchar(20) NOT NULL,
       EmpEmail varchar(25) NOT NULL,
       projNo varchar(5) NOT NULL,
       projName varchar(15) NOT NULL,
       EmpGrade varchar(2) NOT NULL,
       HrlyRate integer(2) NOT NULL,
       HrsWorked integer(3) NOT NULL
);




INSERT INTO Employee VALUES('E001','John Brown','john@gmail.com','P01','BIZOPS','A',20,35);
INSERT INTO Employee VALUES('E002','Harry Davis','harry@gmail.com','P01','BIZOPS','B',16,36);
INSERT INTO Employee VALUES('E003','Larry Miller','larry@gmail.com','P01','BIZOPS','A',20,36);
INSERT INTO Employee VALUES('E004','Leo Wilson','leo@gmail.com','P02','SASHA','C',12,32);
INSERT INTO Employee VALUES('E005','Merry Moore','merry@gmail.com','P03','JAVA','A',20,40);
INSERT INTO Employee VALUES('E006','Stone Taylor','stone@gmail.com','P02','SASHA','A',20,45) ;
INSERT INTO Employee VALUES('E007','Dustin Anderson','dustin@gmail.com','P03','JAVA','C',12,39) ;
INSERT INTO Employee VALUES('E008','Nima Thomas','nima@gmail.com','P02','SASHA','B',16,30) ;
INSERT INTO Employee VALUES('E009','Doug Jackson','doug@gmail.com','P01','BIZOPS','A',20,25) ;
INSERT INTO Employee VALUES('E010','Leon Jackson','leon@gmail.com','P03','JAVA','A',20,42) ;
INSERT INTO Employee VALUES('E011','Danny White','dannygmail.com','P06','C#','A',20,38) ;
INSERT INTO Employee VALUES('E012','Beck Harris','beck@gmail.com','P02','SASHA','B',16,42) ;
INSERT INTO Employee VALUES('E013','Michael Martin','michael@gmail.com','P03','JAVA','B',16,40) ;
INSERT INTO Employee VALUES('E014','Sara Thompson','sara@gmail.com','P04','PHP','A',20,44) ;
INSERT INTO Employee VALUES('E015','Abhi Garcia','abhi@gmail.com','P04','PHP','C',12, 42) ;
INSERT INTO Employee VALUES('E016','Julia Martinez','julia@gmail.com','P05','PERL','C',12, 44) ;
INSERT INTO Employee VALUES('E017','Johny Robinson','johny@gmail.com','P06','C#','A',20,36) ;
INSERT INTO Employee VALUES('E018','James Adams','james@gmail.com','P05','PERL','B',16,44) ;
 
Employee (EmpNo, EmpName, EmpEmail)
Project (projNo, projName)
ProjectSummary (EmpNo, projNo, HrsWorked, EmpGrade, HrlyRate)

CREATE TABLE Employee_new(
       EmpNo varchar(5) PRIMARY KEY,
       EmpName varchar(20) NOT NULL,
       EmpEmail varchar(25) NOT NULL
);

INSERT INTO Employee_new VALUES('E001','John Brown','john@gmail.com');
INSERT INTO Employee_new VALUES('E002','Harry Davis','harry@gmail.com');
INSERT INTO Employee_new VALUES('E003','Larry Miller','larry@gmail.com');
INSERT INTO Employee_new VALUES('E004','Leo Wilson','leo@gmail.com');
INSERT INTO Employee_new VALUES('E005','Merry Moore','merry@gmail.com');
INSERT INTO Employee_new VALUES('E006','Stone Taylor','stone@gmail.com');
INSERT INTO Employee_new VALUES('E007','Dustin Anderson','dustin@gmail.com');
INSERT INTO Employee_new VALUES('E008','Nima Thomas','nima@gmail.com');
INSERT INTO Employee_new VALUES('E009','Doug Jackson','doug@gmail.com');
INSERT INTO Employee_new VALUES('E010','Leon Jackson','leon@gmail.com');
INSERT INTO Employee_new VALUES('E011','Danny White','dannygmail.com');
INSERT INTO Employee_new VALUES('E012','Beck Harris','beck@gmail.com');
INSERT INTO Employee_new VALUES('E013','Michael Martin','michael@gmail.com');
INSERT INTO Employee_new VALUES('E014','Sara Thompson','sara@gmail.com');
INSERT INTO Employee_new VALUES('E015','Abhi Garcia','abhi@gmail.com');
INSERT INTO Employee_new VALUES('E016','Julia Martinez','julia@gmail.com');
INSERT INTO Employee_new VALUES('E017','Johny Robinson','johny@gmail.com');
INSERT INTO Employee_new VALUES('E018','James Adams','james@gmail.com');


CREATE TABLE Project(
       projNo varchar(5) PRIMARY KEY,
       projName varchar(15) NOT NULL
);


INSERT INTO Project VALUES('P01','BIZOPS');
INSERT INTO Project VALUES('P02','SASHA');
INSERT INTO Project VALUES('P03','JAVA');
INSERT INTO Project VALUES('P04','PHP');
INSERT INTO Project VALUES('P05','PERL');
INSERT INTO Project VALUES('P06','C#');

ProjectSummary (EmpNo, projNo, EmpGrade, HrlyRate, HrsWorked)

CREATE TABLE Employee(
       EmpNo varchar(5) PRIMARY KEY,
       EmpName varchar(20) NOT NULL,
       EmpEmail varchar(25) NOT NULL,
       projNo varchar(5) NOT NULL,
       projName varchar(15) NOT NULL,
       EmpGrade varchar(2) NOT NULL,
       HrlyRate integer(2) NOT NULL,
       HrsWorked integer(3) NOT NULL
);


CREATE TABLE ProjectSummary(
       EmpNo varchar(5) References Employee_new(EmpNo),
       projNo varchar(5) References Project(projNo),
       EmpGrade varchar(2) NOT NULL,
       HrsWorked integer(3) NOT NULL
);

INSERT INTO ProjectSummary VALUES('E001','P01','A',35);
INSERT INTO ProjectSummary VALUES('E002','P01','B',36);
INSERT INTO ProjectSummary VALUES('E003','P01','A',36);
INSERT INTO ProjectSummary VALUES('E004','P02','C',32);
INSERT INTO ProjectSummary VALUES('E005','P03','A',40);
INSERT INTO ProjectSummary VALUES('E006','P02','A',45) ;
INSERT INTO ProjectSummary VALUES('E007','P03','C',39) ;
INSERT INTO ProjectSummary VALUES('E008','P02','B',30) ;
INSERT INTO ProjectSummary VALUES('E009','P01','A',25) ;
INSERT INTO ProjectSummary VALUES('E010','P03','A',42) ;
INSERT INTO ProjectSummary VALUES('E011','P06','A',38) ;
INSERT INTO ProjectSummary VALUES('E012','P02','B',42) ;
INSERT INTO ProjectSummary VALUES('E013','P03','B',40) ;
INSERT INTO ProjectSummary VALUES('E014','P04','A',44) ;
INSERT INTO ProjectSummary VALUES('E015','P04','C',42) ;
INSERT INTO ProjectSummary VALUES('E016','P05','C',44) ;
INSERT INTO ProjectSummary VALUES('E017','P06','A',36) ;
INSERT INTO ProjectSummary VALUES('E018','P05','B',44) ;


CREATE TABLE Grade(
       EmpGrade varchar(2) Primary key,
       HrlyRate integer(2) NOT NULL
);

INSERT INTO Grade VALUES('A',20);
INSERT INTO Grade VALUES('B',16);
INSERT INTO Grade VALUES('C',12);

