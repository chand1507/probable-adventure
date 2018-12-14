create table customer(
cust_id number(4),
custname varchar2(20),
address varchar2(20),
phonenumber varchar2(10),
dateofbooking date);

 CREATE SEQUENCE custId_sequence
     start with 1000;