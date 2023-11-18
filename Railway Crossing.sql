create database RailwayCrossingStatus;
use RailwayCrossingStatus;

create table railwayCrossingData (
crossingId int auto_increment,
crossingName varchar(50),
address varchar(50),
landmark varchar(50),
trainSchedule time,
personInCharge varchar(50),
statusCrossing varchar(20) DEFAULT 'CLOSED',
primary key(crossingId));
select * from railwayCrossingData;

create table user(
userId int auto_increment,
userName varchar(50),
userEmail varchar(50),
userPassword varchar(50),
primary key(userId));
select * from user;

create table admin(
adminId int auto_increment,
adminEmail varchar(50),
adminPassword varchar(50),
primary key(adminId));
select * from admin;

create table favouriteCrossing(
favId int auto_increment,
crossingId int,
primary key(favId),
foreign key(crossingId ) References railwayCrossingData(crossingId ));
select * from favouriteCrossing;

insert into user (userName, userEmail, userPassword) values
("abc ", " abc@email.com" ,"abc123"),
("xyz ", "xyz@email.com " , "xyz456");

insert into admin (adminEmail, adminPassword) values
("admin@email.com" ,"admin123");

INSERT INTO railwayCrossingData(crossingName, address, landmark, trainSchedule, personInCharge, statusCrossing) VALUES
( "Ishmeet Chowk Crossing", "Ishmeet Singh near Party People", "Ishmeet Singh near Party People", STR_TO_DATE('10:33:00 AM', '%h:%i:%s %p'), "David", "OPEN"),
("Midha Chowk Crossing", "Midha Crossing", "Midha Crossing", STR_TO_DATE('10:40:00 AM', '%h:%i:%s %p'), "Robin", "CLOSED"),
("ABC", "ABC Crossing", "ABC Crossing", STR_TO_DATE('11:40:00 AM', '%h:%i:%s %p'), "John", "OPEN");

drop table admin;
drop table user;
drop table railwayCrossingData;
truncate table railwayCrossingData;
drop table favouriteCrossing;
