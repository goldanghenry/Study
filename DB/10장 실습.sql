use academicdb;

-- 1) 학생 테이블을 모두 검색하라
select * from student;

-- 2) 학생 테이블에 어떤 학과들이 있는지 검색하라.
select sdept from student group by sdept;

-- 3) 과목 테이블에서 학점이 3이고 학년이 4인 과목코드와 과목명을 검색하라.
select code, cname from course where year =4 and credit=3;

-- 4) 과목코드가 'CO'로 시작하는 과목의 과목코드와 과목명을 검색하라.
select code, cname from course where code like 'CO%';

-- 5) 강의 테이블에서 강의실이 NULL인 교수번호와 과목코드를 검색하라.
select pno, code from lecture where room is NULL;

-- 6) 수강 테이블에서 점수가 80점부터 90점 사이의 열들을 검색하라
select * from enroll where score between 80 and 90;

-- 7) 수강 테이블에서 점수가 80점 이상인 학생의 학번과 성적을 검색하되, 학번은 오름차순으로, 같은 학번에 대해서 성적은 내림차순으로 검색하라.
select sno, score from enroll where score >= 80 order by sno asc, score desc;

-- 8) 수강 테이블에서 과목코드 'CO123'에 수강한 학생의 학번과 점수에 2점을 더한 값을 검색하되, 학번의 열 이름은 "DB수강학번", 점수의 열 이름은 "수정점수",
-- 	  그리고 그 사이에 "최종점수 = "라는 텍스트 내용을 "내용"이라는 열 이름으로 디스플레이하라
select sno as DB수강학번, "최종점수 = " as 내용, score+2 as 수정점수
from enroll
where code = "CO123";

 -- 9) 과목번호 'CO423'에 수강한 학생의 성명, 학과, 성적을 검색하라.
 select sname, sdept, score from student, enroll where code = 'CO423';
 
 -- 10) 같은 학과 학생들의 학번을 쌍으로 검색하라. 단 첫 번째 학번은 오름차순으로 정렬하라.
 select s1.sno, s2.sno from student s1, student s2 where s1.sdept = s2.sdept and s1.sno != s2.sno order by s1.sno;
 
 -- 11) 학생 테이블에 학생 수가 얼마인가를 검색하라.
 select count(*) as 학생수 from student;
 
 -- 12) 과목 'CO123'에 대한 점수의 평균은 얼마인가?'
 select avg(score) as 평균 from enroll where code = 'CO123';
 
 -- 13) 과목별 점수의 평균을 검색하라.
 select code, avg(score) as 평균 from enroll group by code;
 
 -- 14) 2명 이상 수강한 과목에 대한 점수의 평균을 검색하라. 
 select code, avg(score) as 평균 from enroll group by code having count(*) >= 2;
 
 -- 15) 학생 '김철수'와 같은 학과에 속하는 학생의 성명을 검색하라.(중첩 질의문 사용)
 select sname from student where sdept = (select sdept from student where sname='김철수') and sname!='김철수';
 
 -- 16) 과목코드 'CO123'에 수강한 학생의 성명을 검색하라.(중첩 질의문 사용)
 select sname from student where sno in ( select sno from enroll where code ='CO123');
 
 -- 17) 과목코드 'CO123'에 수강하지 않은 학생의 성명을 검색하라(중첩 질의문 사용)
 select sname from student where sno not in (select sno from enroll where code  ='CO123');
 
 -- 18) 과목 'CO123'에 수강한 학생의 성명을 검색하라 (exists문 사용)
 select sname from student where exists (select sno from enroll where code ='CO123');
 
 -- 19) '컴퓨터'과 학생이거나 또는 'EE123'에 수강한 학생의 학번을 검색하라(union)
 select sno from student where sdept = '컴퓨터' union select sno from enroll where code = 'EE123';