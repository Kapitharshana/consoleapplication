create database sltb;
use sltb;

create table buses(
    ID int PRIMARY KEY,
    Departure varchar(20),
    Arrival varchar(20),
    bus_t TIME,
    avilable_seats INT,
    bus_type boolean,
    price DECIMAL(7,2)
);

insert into buses values(1,'Colombo','Kalmunai','07:00:00',35,0,1227.00);
insert into buses values(7,'Colombo','Kalmunai','15:30:00',35,0,1215.00);
insert into buses values(2,'Colombo','Jaffna','22:40:00',32,0,1371.00);
insert into buses values(8,'Colombo','Jaffna','09:40:00',32,0,1231.00);
insert into buses values(3,'Colombo','Matara','10:00:00',33,1,631.00);
insert into buses values(4,'Colombo','Ampara','23:00:00',30,0,1293.00);
insert into buses values(5,'Colombo','Eravur','22:00:00',32,0,1013.00);
insert into buses values(6,'Colombo','Matale','05:50:00',24,0,542.00);
insert into buses values(8,'Colombo','Jaffna','09:40:00',2,0,1231.00);

select * from buses;

create table booking(
booking_id int(10) PRIMARY KEY AUTO_INCREMENT,
    ID INT,
    passenger_name VARCHAR(50),
    phone VARCHAR(20),
    email VARCHAR(50),
    seat_no INT,
    journey_date DATE,
    FOREIGN KEY(ID) REFERENCES buses(ID)
);
insert into booking value (1,1,'kapi','0771234567','kapi@gmail.com',4,'2025-10-07');
insert into booking value (2,1,'salomi','0777654321','salomi@gmail.com',7,'2025-10-07');

select * from booking;
DESCRIBE buses;
select * from buses;

ALTER TABLE buses CHANGE avilable_seats available_seats INT;
DELETE FROM buses
WHERE ID = 8;


