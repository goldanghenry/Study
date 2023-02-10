use classicmodels;

select orderNumber, sum(priceEach * quantityOrdered) as '주문량 합계' from orderdetails 
group by orderNumber having sum(priceEach * quantityOrdered) >= 60000; 


select customers.customerName, count(orderNumber) as '주문 수' from  customers, orders 
where customers.customerNumber = orders.customerNumber 
group by customers.customerNumber 
order by count(orderNumber) desc;


select lastName, firstName from employees, offices 
where employees.officeCode = offices.officeCode and country  = (select country from offices where officeCode = 1);



create index idx_jobtitle on employees(jobTitle);
select employeeNumber, lastName, firstName from employees where jobTitle = 'Sales Rep';


create view customerpayments(customerName, checkNumber, paymentDate, amount) as
	select customerName, checkNumber, paymentDate, amount from customers
    inner join payments using(customerNumber);
/*차이점 : 원래 payments 테이블은 customer의 이름을 볼 수 없어 불편했는데, 이제는 customer의 번호 대신 이름을 볼 수 있어 가독성이 좋습니다. (6)*/


delimiter $$
	create procedure GetCustomers()
    begin
		select customerName, city, state, postalCode, country from customers order by customerName;
	end $$
delimiter ;

call GetCustomers();


drop procedure if exists GetGrade;
delimiter $$
	create procedure GetGrade()
    begin
		declare money int; 
        declare count int default 0; 
        declare cNum int; 
        declare endOfRow boolean default false;
        
        declare cur cursor for select customers.customerNumber, sum(amount) from customers, payments 
        where customers.customerNumber = payments.customerNumber 
        group by customers.customerNumber;
        declare continue handler for not found set endOfRow = true;
        open cur;
        
        alter table customers add grade varchar(30) NULL; 
        
        cursor_loop: LOOP
			fetch cur
            into cNum, money;
            if endOfRow then leave cursor_loop;
            end if;
            
            if (money>300000) then update customers set grade='best customer' where customerNumber = cNum;
            elseif (money>100000) then update customers set grade='good customer' where customerNumber = cNum;
            elseif (money>5000) then update customers set grade='average customer' where customerNumber = cNum;
            else update customers set grade=NULL where customerNumber = cNum;
            end if;
		end Loop cursor_loop;
		close cur;
	end $$
delimiter ;

set sql_safe_updates = 0;
call GetGrade();

select customerNumber, customerName, country, grade from customers;


