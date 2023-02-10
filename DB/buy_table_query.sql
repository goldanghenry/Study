use test;
CREATE TABLE buy
(num INT, 
 userID CHAR(8), 
 prodName VARCHAR(10), 
 groupName VARCHAR(10),
 price INT,
 amount INT
);
INSERT INTO buy VALUES(1, 'KBS', '운동화', NULL, 30, 2);
INSERT INTO buy VALUES(2, 'KBS', '노트북', '전자', 1000, 1);
INSERT INTO buy VALUES(3, 'JYP', '모니터', '전자', 200, 1);
INSERT INTO buy VALUES(4, 'BBK', '모니터', '전자', 200, 5);
INSERT INTO buy VALUES(5, 'KBS', '청바지', '의류', 50, 3);
INSERT INTO buy VALUES(6, 'BBK', '메모리', '전자', 80, 10);
INSERT INTO buy VALUES(7, 'SSK', '책', '서적', 15, 5);
INSERT INTO buy VALUES(8, 'EJW', '책', '서적', 15, 2);
INSERT INTO buy VALUES(9, 'EJW', '청바지', '의류', 50, 1);
INSERT INTO buy VALUES(10, 'BBK', '운동화', null, 30, 2);
INSERT INTO buy VALUES(11, 'EJW', '책', '서적', 15, 1);
INSERT INTO buy VALUES(12, 'BBK', '운동화', null, 30, 2);
select * from buy;

alter table buy add constraint pk_name primary key(num);
create index idx_buy_userID on buy(userID);
create index idx_buy_prodName on buy(prodName);
create index idx_buy_groupName on buy(groupName);
create index idx_buy_userID_prodName on buy(userID, prodName);
drop index idx_buy_groupName on buy;

show index from buy;

