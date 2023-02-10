use academicDB;
drop procedure IF exists studentProc;
DELIMITER $$
	create procedure studentProc()
    begin
		select * from student;
	END $$
DELIMITER ;
call studentProc();

drop procedure IF exists studentProc1;
DELIMITER $$
	create procedure studentProc1(IN userName varchar(10))
    begin
		select * from student where sname = userName;
	END $$
DELIMITER ;
call studentProc1('김철수');

drop procedure IF exists studentProc2;
DELIMITER $$
	create procedure studentProc2(IN userName varchar(10), IN deptName varchar(20))
    begin
		select * from student where sname = userName and sdept = deptName;
	END $$
DELIMITER ;
call studentProc2('김철수', '컴퓨터');

drop procedure IF exists testProc;
DELIMITER $$
	create procedure testProc(IN txtValue varchar(10), OUT outValue int )
    begin
		insert into testTBL values(null, txtValue);
		select max(id) into outValue from testTBL;
	END $$
DELIMITER ;
create table IF NOT exists testTBL (
	id int auto_increment primary key,
    txt char(10)
);

call testProc('테스트값', @myValue);
select concat('현재 입력된 ID 값 ==>', @myValue);

drop procedure IF exists ifelseProc;
DELIMITER $$
	create procedure ifelseProc(IN number int)
    begin
		declare eScore int;
        select score into eScore from enroll where sno=number;
        if (eScore >= 90) THEN select 'A 학점';
        else select 'B 학점';
        end if;
	end $$
DELIMITER ;

call ifelseProc(20183654);
