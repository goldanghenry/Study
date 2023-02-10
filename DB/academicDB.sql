create database academicDB;
use academicDB;

create table student(
	sno int,
    sname char(5),
    sdept char(20),
    stel char(20),
    primary key(sno)
);

create table course(
	code char(5),
    cname char(20),
    credit smallint,
    year smallint,
    primary key(code)
);

create table enroll(
	sno int,
    code char(5),
    score smallint,
    grade char(2),
    foreign key(sno) references student(sno),
    foreign key(code) references course(code)
);

create table professor(
	pno char(4),
    pname char(5),
    pdept char(20),
    ptel char(20),
    primary key(pno)
);
create table lecture(
	pno char(4),
    code char(5),
    hour smallint,
    room char(4),
   foreign key(pno) references professor(pno),
    foreign key(code) references course(code)
);

create table teach(
	pno char(4),
    sno int,
    foreign key(sno) references student(sno),
    foreign key(pno) references professor(pno)
);

INSERT INTO student VALUES(20181234,'김철수','컴퓨터','010-4657-7654');
INSERT INTO student VALUES(20182587,'이영자','컴퓨터','010-7654-9874');
INSERT INTO student VALUES(20183654,'고영준','경영','010-8732-0953');
INSERT INTO student VALUES(20184652,'김영옥','전자','010-7623-8753');
INSERT INTO student VALUES(20185753,'유진호','기계','010-5431-0964');
INSERT INTO student VALUES(20187654,'박용철','컴퓨터','010-6548-9872');

INSERT INTO professor VALUES('P200','홍길동','컴퓨터','010-0865-7632');
INSERT INTO professor VALUES('P202','박영순','전자','010-8641-0541');
INSERT INTO professor VALUES('P203','김기준','기계','010-7812-0432');
INSERT INTO professor VALUES('P204','김형일','화학','010-8432-1653');
INSERT INTO professor VALUES('P205','강선화','컴퓨터','010-5846-4765');
INSERT INTO professor VALUES('P206','정인수','전자','010-8536-4587');

INSERT INTO course VALUES('CO123','데이터베이스',3,3);
INSERT INTO course VALUES('CO234','네트워크',3,2);
INSERT INTO course VALUES('CO342','그래픽응용',2,3);
INSERT INTO course VALUES('CO423','프로그래밍',3,4);
INSERT INTO course VALUES('EE123','신호처리',3,2);
INSERT INTO course VALUES('ME102','열역학',3,3);

INSERT INTO teach VALUES('P200', 20181234);
INSERT INTO teach VALUES('P200', 20182587);
INSERT INTO teach VALUES('P200', 20185753);
INSERT INTO teach VALUES('P202', 20183654);
INSERT INTO teach VALUES('P202', 20184652);
INSERT INTO teach VALUES('P203', 20187654);

INSERT INTO lecture VALUES('P200', 'CO123',3,'E453');
INSERT INTO lecture VALUES('P200', 'CO423',3,'E265');
INSERT INTO lecture VALUES('P202', 'CO234',3,'K458');
INSERT INTO lecture VALUES('P202', 'CO342',4,'E234');
INSERT INTO lecture VALUES('P202', 'EE123',4,'K124');
INSERT INTO lecture VALUES('P203', 'ME102',3,'E324');

INSERT INTO enroll VALUES(20181234,'CO123',94,'A0');
INSERT INTO enroll VALUES(20181234,'CO423',87,'B+');
INSERT INTO enroll VALUES(20182587,'CO123',91,'A-');
INSERT INTO enroll VALUES(20182587,'CO423',86,'B+');
INSERT INTO enroll VALUES(20182587,'EE123',74,'C0');
INSERT INTO enroll VALUES(20183654,'CO234',97,'A+');
INSERT INTO enroll VALUES(20184652,'CO123',83,'B0');
INSERT INTO enroll VALUES(20184652,'CO234',81,'B-');
INSERT INTO enroll VALUES(20184652,'CO423',64,'D0');
INSERT INTO enroll VALUES(20184652,'EE123',89,'B+');
INSERT INTO enroll VALUES(20185753,'CO423',85,'B0');

SELECT * FROM student;
SELECT * FROM professor;
SELECT * FROM course;
SELECT * FROM teach;
SELECT * FROM lecture;
SELECT * FROM enroll;






