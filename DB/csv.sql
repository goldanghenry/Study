create database report;
use report;

create table ApartPrice(
	no         int,
	ymd        date,
    ym         date,
    year       char(4),
    code       char(5),
    addr1      char(10),
    apt_nm     varchar(50),
    juso_jibun varchar(200),
    price      decimal(10),
    con_year   decimal(4) default 2022,
    area       decimal(5),
    floor      decimal(3),
    py         decimal(5),
    cnt        decimal(3),
    primary key(no),
    CONSTRAINT CK_cnt CHECK(cnt >0 and cnt<100)
);

load data infile "C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/final_csv_data.csv" 
INTO TABLE ApartPrice
CHARACTER SET utf8mb4
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(@no, @ymd, @ym, @year, @code, @addr1, @apt_nm, @juso_jibun, @price, @con_year, @area, @floor, @py, @cnt)
SET no = IF(@no = '', NULL, @no),
    ymd = IF(@ymd = '', NULL, @ymd),
    ym = IF(@ym = '', NULL, @ym),
    year = IF(@year = '', NULL, @year),
    code = IF(@code = '', NULL, @code),
    addr1 = IF(@addr1 = '', NULL, @addr1),
    apt_nm = IF(@apt_nm = '', NULL, @apt_nm),
    juso_jibun = IF(@juso_jibun = '', NULL, @juso_jibun),
    price = IF(@price = 'NA', NULL, @price),
    con_year = IF(@con_year = '', NULL, @con_year),
    area = IF(@area = '', NULL, @area),
    floor = IF(@floor = '', NULL, @floor),
    py = IF(@py = 'NA', NULL, @py),
    cnt = IF(@cnt = '', NULL, @cnt)
;
