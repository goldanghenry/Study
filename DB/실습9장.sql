use academicdb;
select sname, stel from student;
select credit from course where cname='프로그래밍';
select sname, score from student, enroll where student.sno=enroll.sno and code='CO423';

select sno from enroll where code='CO123' and score>=90;
select sname, stel from student, enroll where student.sno=enroll.sno and code='CO123';

select pname, pdept from professor where pdept !='컴퓨터';

select * from student where sdept = "컴퓨터";

select * from student where sdept = 
( select sdept from student where sname = "김철수");

select sname from student where sno in 
( select sno from  enroll where code ="CO123");

select code, avg(score) from enroll group by code;
select code, avg(score) from enroll group by code having count(*) >=2;

select sname, cname from student
inner join enroll on student.sno = enroll.sno
inner join course on enroll.code = course.code
where score >= 90;