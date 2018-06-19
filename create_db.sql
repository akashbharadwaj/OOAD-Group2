use coursedatabase;

drop table customer;
CREATE TABLE customer (
userId char(20) NOT NULL,
password char(10) DEFAULT NULL,
name char(20) DEFAULT NULL,
age int  null,
gender char(1)  null,
user_type  char(1) null
)

drop Table arenas;
create table arenas (
id	int not null,
name char(40) not null,
location char(100)
)