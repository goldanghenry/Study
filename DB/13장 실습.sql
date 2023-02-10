use academicdb;
drop table IF EXISTS testTBL;
create table testTBL (id int, txt varchar(20));
insert into testTBL values(1, '이멕스아이디');
insert into testTBL values(2, '애프터스쿨');
insert into testTBL values(3, '에이오에이');

drop trigger IF EXISTS testTrg;
DELIMITER //
create trigger testTrg
		after DELETE
        ON testTBL
        FOR EACH ROW
begin
	set @msg = '가수 그룹이 삭제됨';
end //
DELIMITER ;

set sql_safe_updates = 0;
select * from testTBL;

set @msg = '';
insert into testTBL values(4,'나인뮤지스');
select @msg;

update testTBL set txt ='에이핑크' where id=3;
select @msg;

delete from testTBL where id=4;
select@msg;

select * from student;

delete from enroll;
delete from teach;
delete from student;

use sys;
