use lab1;

create table department(
       deptNo varchar(5) PRIMARY KEY,
       deptName varchar(15) NOT NULL,
       mgrEmpID varchar(5) NOT NULL
);

create table Employee(
       empID varchar(5) PRIMARY KEY,
       fName varchar(10) NOT NULL,
       lName varchar(10) NOT NULL,
       address varchar(15) NOT NULL,
       DOB datetime,
       sex varchar(6) NOT NULL,
       position varchar(10) NOT NULL,
       deptNo varchar(5) references Department(deptNo)
);
       
create table Project(
       projNo varchar(5) PRIMARY KEY,
       projName varchar(15) NOT NULL,
       deptNo varchar(5) references Department(deptNo)      
);

create table WorksOn(
       empID varchar(5) references Employee(empID),
       projNo varchar(5) references Project(projNo),
       hoursWorked integer(2) NOT NULL,
       PRIMARY KEY(empID,projNo) 
); 
        
     
insert into employee values('E001','John','Brown','Fairfield, IA','1965-12-12','Male','Manager','A01');
insert into employee values('E002','Harry','Davis','Cary, NC','1982-07-15','Male','Manager','A02');
insert into employee values('E003','Larry','Miller','Morrisville, NC','1986-11-16','Male','Manager','A03');
insert into employee values('E004','Leo','Wilson','Fairfield, IA','1983-12-28','Male','Manager','A04');
insert into employee values('E005','Merry','Moore','Irving, Tx','1980-01-15','Female','Manager','A05');
insert into employee values('E006','Stone','Taylor','Greensboro, NC','1990-12-05','Male','Sr. Dev','A02') ;
insert into employee values('E007','Dustin','Anderson','Raleigh, NC','1991-04-07','Male','Dev','A02') ;
insert into employee values('E008','Nima','Thomas','Irvine, CA','1992-03-09','Male','Dev','A02') ;
insert into employee values('E009','Doug','Jackson','Apex, NC','1990-02-08','Male','Dev','A02') ;
insert into employee values('E010','Leon','Jackson','Cary, NC','1989-10-05','Male','Sr. Dev','A02') ;
insert into employee values('E011','Danny','White','Irving, Tx','1990-05-05','Male','Sr. Dev','A02') ;
insert into employee values('E012','Beck','Harris','Greensboro, NC','1982-04-24','Male','Sr. Dev','A02') ;
insert into employee values('E013','Michael','Martin','Apex, NC','1985-11-11','Male','Jr. Admin','A01') ;
insert into employee values('E014','Sara','Thompson','Cary, NC','1986-02-26','Female','Sr. Admin','A01') ;
insert into employee values('E015','Abhi','Garcia','Cary, NC','1989-07-30','Male','Specialist','A03') ;
insert into employee values('E016','Julia','Martinez','Cary, NC','1991-04-04','Female','Cashier','A04') ;
insert into employee values('E017','Johny','Robinson','Apex, NC','1986-08-24','Male','Accountant','A04') ;
insert into employee values('E018','James','Adams','Durham, NC','1992-12-10','Male','Salesman','A05') ;
 
insert into project values('P001','BIZOPS','A002');
insert into project values('P002','SASHA','A002');
insert into project values('P003','JAVA','A002');
insert into project values('P004','PHP','A002');
insert into project values('P005','PERL','A002');


insert into workson values('E006','P001',60);
insert into workson values('E007','P001',45);
insert into workson values('E008','P002',32);
insert into workson values('E009','P002',68);
insert into workson values('E010','P003',45);
insert into workson values('E011','P004',34);
insert into workson values('E012','P004',34);
insert into workson values('E006','P002',54);
insert into workson values('E007','P003',33);
insert into workson values('E008','P004',47);
insert into workson values('E009','P003',62);
insert into workson values('E010','P002',18);
insert into workson values('E011','P001',12);
insert into workson values('E012','P005',110);


1.	List all employees in alphabetical order of surname and within surname, first name.
ANS:

SELECT * FROM employee ORDER BY lName,fName;

2.	List all the details of employees who are female.
ANS:

SELECT * FROM employee  WHERE sex='Female';

3.	List the names and addresses of all employees who are Managers.
ANS:

SELECT concat(fName,' ',lName) AS Name, address FROM employee e, department d  WHERE e.empID=d.mgrEmpID;

4.	Produce a list of the names and addresses of all employees who work for the IT department.
ANS:

SELECT concat(fName,' ',lName) AS Name, address FROM employee e JOIN department d ON e.deptNo=d.deptNo WHERE d.deptName='IT';

5.	Produce a complete list of all managers who are due to retire this year, in alphabetical order of surname.
ANS:
 Assumption: Retire at the age of 50
 
SELECT e.* FROM employee e JOIN department d on e.empID=d.mgrEmpID WHERE YEAR(CURRENT_TIMESTAMP)- YEAR(e.DOB)>50 ORDER BY e.lName;

6.	Find out how many employees are managed by ‘James Adams’.
ANS:

SELECT COUNT(*) AS TOTAL_EMP FROM employee e where deptNo=(SELECT d.deptNo from department d JOIN employee e ON e.deptNo=d.deptNo WHERE e.fName='James' and e.lName='Adams') and position !='Manager';

7.	Produce a report of the total hours worked by each employee, arranged in order of department number and within department, alphabetically by employee surname.
ANS:

SELECT  e.deptNo, concat(fName,' ',lName) AS Name, SUM(hoursWorked) AS 'Hour Worked' FROM employee e JOIN workson w ON e.empID=w.empID GROUP BY e.empID ORDER BY e.deptNo, e.lName;


8.	For each project on which more than two employees worked, list the project number, project name and the number of employees who work on that project.
ANS
SELECT p.projNo as 'Project No', p.projName as 'Project Name', COUNT(w.empID) as 'No. of Emp' FROM project p JOIN workson w ON p.projNo=w.projNo GROUP BY p.projNo HAVING COUNT(w.empID)>2; 

9.	List the total number of employees in each department for those departments with more than 10 employees. Create an appropriate heading for the columns of the results table.
ANS:

SELECT d.deptName AS 'Department', COUNT(e.empID) AS 'Total Employee' FROM employee e JOIN department d ON e.deptNo=d.deptNo GROUP BY e.deptNo HAVING COUNT(e.empID)>10;