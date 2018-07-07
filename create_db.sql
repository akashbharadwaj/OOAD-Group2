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
id	int not null AUTO_INCREMENT,
name char(40) not null,
location char(100)
)
insert into arenas 
(name, location) values 
('Soccer', 'Urec1'), 
('Tennis', 'Urec2'), 
('TT', 'Urec3'), 
('Pool', Urec4), 
('Racquetball', 'Urec5'),
('Gym', 'Urec7'),
('Squash', 'Urec8'),
('SwimmingPool', 'Urec9'),
('FIFA', 'Urec10');

CREATE TABLE booking (
userId char(100) ,
arenaId int ,
arenaName char(100),
slotTime char(20) 
)
