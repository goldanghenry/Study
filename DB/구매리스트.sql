use test;
drop table if exists customer;
Create table customer(
customerId 	CHAR(4)	NOT NULL PRIMARY KEY,
name		varchar(10)	not null,
addr		char(2) not null,
mobile		char(13) null
);

Create table buyList(
num			smallint auto_increment primary key,
customerId 	CHAR(4),
bname		varchar(10)	not null,
price		INT not null,
count		INT not null,
foreign key(customerId) references customer(customerId)
);

INSERT INTO customer VALUES('C100', '이만수', '서울', '010-1111-1111');
INSERT INTO customer VALUES('C200', '김일범', '경남', '010-2222-2222');
INSERT INTO customer VALUES('C300', '김경자', '전남', '010-3333-3333');
INSERT INTO customer VALUES('C400', '조영희', '경기', '010-4444-4444');
INSERT INTO customer VALUES('C500', '박태영', '서울', '010-5555-5555');
INSERT INTO customer VALUES('C600', '윤종찬', '전남', NULL);

INSERT INTO buyList VALUES(num,'C200', '운동화', 30, 2);
INSERT INTO buyList VALUES(num,'C200', '노트북', 1000, 1);
INSERT INTO buyList VALUES(num,'C400', '전화기', 200, 1);
INSERT INTO buyList VALUES(num,'C500', '가방', 300, 2);

SELECT * FROM customer;
SELECT * FROM buyList;

drop table if exists customer;
Create table customer(
customerId 	CHAR(4)	NOT NULL PRIMARY KEY,
name		varchar(10)	not null unique,
addr		char(2) default "서울",
mobile		char(13) null,
CONSTRAINT CK_addr CHECK(addr IS NOT NULL)
);

INSERT INTO customer VALUES('C100', '이만수', default, '010-1111-1111');
INSERT INTO customer VALUES('C200', '김일범', '경남', '010-2222-2222');
INSERT INTO customer VALUES('C300', '김경자', '전남', '010-3333-3333');
INSERT INTO customer VALUES('C400', '조영희', '경기', '010-4444-4444');
INSERT INTO customer VALUES('C500', '박태영', default, '010-5555-5555');
INSERT INTO customer VALUES('C600', '윤종찬', '전남', NULL);

Create table buyList(
num			smallint auto_increment primary key,
customerId 	CHAR(4),
bname		varchar(10)	not null,
price		INT not null,
count		INT not null,
foreign key(customerId) references customer(customerId),
CONSTRAINT CK_count CHECK(count >0)
);

INSERT INTO buyList VALUES(num,'C200', '운동화', 30, 2);
INSERT INTO buyList VALUES(num,'C200', '노트북', 1000, 1);
INSERT INTO buyList VALUES(num,'C400', '전화기', 200, 1);
INSERT INTO buyList VALUES(num,'C500', '가방', 300, 2);

SELECT * FROM customer;
SELECT * FROM buyList;
