SELECT * FROM academicdb.student;
-- (1) 
insert into student values(12345678, "김찰스", "수학", "010-1234-5678");

-- (2) insert나 update 작업이 일어나는 경우에, 변경되기 전의 데이터를 저장할 테이블 생성
create table backup_student(
   sno int,
    sname char(5) not null,
    sdept char(20),
    stel char(20),
   modType char(2), -- 변경된 타입, 수정 또는 삭제
   modDate date, -- 변경된 날짜
   modUser varchar(50) -- 변경한 사용자
);

-- (3) 변경(update)이 발생했을 때 작동하는 UpdateTrg 트리거를 생성한다.
drop trigger If exists UpdateTrg;
-- before 테이블에 변화가 생기기에 앞서 트리거 액션을 시키게 하고 싶을 때
-- after 테이블에 변화가 생긴 후 트리거 액션을 시키게 하고 싶을 때
delimiter //
create trigger UpdateTrg
   after update on student
    for each row
begin 
   insert into backup_student values(OLD.sno, OLD.sname, OLD.sdept, OLD.stel, '수정', CURDATE(), current_user());
end // 
delimiter ;

-- (4) 삭제(delete)가 발생했을 때 작동하는 DeleteTrg 트리거를 생성한다
drop trigger If exists DeleteTrg;
delimiter //
create trigger DeleteTrg
   after delete on student
    for each row
begin
   insert into backup_student values(OLD.sno, OLD.sname, OLD.sdept, OLD.stel, '삭제', CURDATE(), current_user());
end //
delimiter ;

update student set sname ='김창수' where sno=12345678;
delete from student where sno=12345678;

select * from backup_student;