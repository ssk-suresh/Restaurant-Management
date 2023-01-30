create database Restaurant;

use Restaurant;

create table customer(
CUSTOMER_ID varchar(45) primary key,
CUSTOMER_NAME varchar(30) not null,
GENDER varchar(20) not null,
EMAIL varchar(30) not null,
ADDRESS varchar(200) not null,
MOBILE_NUMBER bigint not null
);
insert into customer values(1,'suresh','male','ssksuresh@gmail.com','muhavoor',6564558454);
insert into customer values('suresh','male','ssksuresh@gmail.com','muhavoor',6564558454);
select * from customer;

create table members(
CUSTOMER_ID varchar(45) primary key,
JOIN_DATE timestamp not null
);
select * from members;

create table menu(
PRODUCT_ID varchar(45) primary key,
PRODUCT_NAME varchar(45) not null,
PRICE decimal not null
);
select * from menu;

create table sales(
CUSTOMER_ID varchar(45) ,
ORDER_DATE date not null,
PRODUCT_ID varchar(45),
constraint FK_ProductId foreign key(PRODUCT_ID) references menu(PRODUCT_ID)
);
alter table sales add constraint FK_CustomerId foreign key(CUSTOMER_ID) references customer(CUSTOMER_ID);

insert into sales values(2,'2022-12-06',4);
select * from sales;



