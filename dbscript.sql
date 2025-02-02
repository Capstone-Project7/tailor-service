create database tailor_service_db;
use tailor_service_db;

create table tailor_details(
	tailor_id int primary key auto_increment,
    tailor_name varchar(20),
    tailor_mobile_number varchar(20),
    workloads int,
    is_active boolean,
    username varchar(20));

select * from tailor_details;