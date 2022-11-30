
use DBMS;
CREATE TABLE supplier (
	SUPP_ID int,
    SUPP_NAME varchar(50) NOT NULL,
    SUPP_CITY varchar(50) NOT NULL,
    SUPP_PHONE varchar(50) NOT NULL,
    PRIMARY KEY (SUPP_ID)
);

CREATE TABLE customer (
CUS_ID int primary key,
CUS_NAME varchar(20) NOT NULL,
CUS_PHONE varchar(10) NOT NULL,
CUS_CITY varchar(30) NOT NULL,
CUS_GENDER CHAR
);

CREATE TABLE category(
CAT_ID int primary key,
CAT_NAME varchar(20) NOT NULL
);

CREATE TABLE product(
PRO_ID int primary key,
PRO_NAME varchar(20) NOT NULL DEFAULT 'Dummy',
PRO_DESC varchar(60),
CAT_ID int,
FOREIGN KEY (CAT_ID) REFERENCES category(CAT_ID)
);

CREATE TABLE supplier_pricing(
PRICING_ID int primary key,
PRO_ID INT, 
SUPP_ID INT,
SUPP_PRICE int DEFAULT 0,
FOREIGN KEY (PRO_ID) REFERENCES product(PRO_ID),
FOREIGN KEY (SUPP_ID) REFERENCES supplier(SUPP_ID)
);

CREATE TABLE `order`(
ORD_ID INT primary key,
ORD_AMOUNT INT NOT NULL, 
ORD_DATE DATE NOT NULL,
CUS_ID INT,
PRICING_ID int,
FOREIGN KEY (CUS_ID) REFERENCES customer(CUS_ID),
FOREIGN KEY (PRICING_ID) REFERENCES supplier_pricing(PRICING_ID)
);

CREATE TABLE rating(
RAT_ID INT PRIMARY KEY,
ORD_ID INT,
RAT_RATSTARS INT NOT NULL,
FOREIGN KEY (ORD_ID) REFERENCES `order`(ORD_ID)
);
-- ------------------------------------------------------------------------------------------------------------ --

insert into supplier(SUPP_ID,SUPP_NAME,SUPP_CITY,SUPP_PHONE) 
values(1,'Rajesh Retails','Delhi',1234567890),(2,'Appario Ltd.','Mumbai',2589631470),(3,'Knome products','Banglore',9785462315),(4,'Bansal Retails','Kochi',8975463285),(5,'Mittal Ltd.','Lucknow',7898456532);


insert into customer(CUS_ID,CUS_NAME,CUS_PHONE,CUS_CITY,CUS_GENDER) 
values(1,'AAKASH',9999999999,'DELHI','M'),(2,'AMAN',9785463215,'NOIDA','M'),(3,'NEHA',9999999999,'MUMBAI','F'),(4,'MEGHA',9994562399,'KOLKATA','F'),(5,'PULKIT',7895999999,'LUCKNOW','M');

insert into category(CAT_ID,CAT_NAME) 
values(1,'BOOKS'),(2,'GAMES'),(3,'GROCERIES'),(4,'ELECTRONICS'),(5,'CLOTHES');

insert into product(PRO_ID,PRO_NAME,PRO_DESC,CAT_ID) 
values(1,'GTA V','Windows 7 and above with i5 processor and 8GB RAM',2),
(2,'TSHIRT','SIZE-L with Black, Blue and White variations',5),
(3,'ROG LAPTOP','Windows 10 with 15inch screen i7 processor,1TB SSD',4),
(4,'OATS','Highly Nutritious from Nestle',3),(5,'HARRY POTTER','Best Collection of all time by J.K Rowling',1),
(6,'MILK','1L Toned MIlk',3),(7,'Boat Earphones','1.5Meter long Dolby Atmos',4),(8,'Jeans','Stretchable Denim Jeans with various sizes and color',5),
(9,'Project IGI','compatible with windows 7 and above',2),(10,'Hoodie','Black GUCCI for 13 yrs and above',5),(11,'Rich Dad Poor Dad','Written by RObert Kiyosaki',1),
(12,'Train Your Brain','By Shireen Stephen',1);

insert into supplier_pricing(PRICING_ID,PRO_ID,SUPP_ID,SUPP_PRICE) 
values(1,1,2,1500),(2,3,5,30000),(3,5,1,3000),(4,2,3,2500),(5,4,1,1000);

INSERT INTO SUPPLIER_PRICING VALUES(1,1,2,1500);
INSERT INTO SUPPLIER_PRICING VALUES(2,3,5,30000);
INSERT INTO SUPPLIER_PRICING VALUES(3,5,1,3000);
INSERT INTO SUPPLIER_PRICING VALUES(4,2,3,2500);
INSERT INTO SUPPLIER_PRICING VALUES(5,4,1,1000);
INSERT INTO SUPPLIER_PRICING VALUES(6,12,2,780);
INSERT INTO SUPPLIER_PRICING VALUES(7,12,4,789);
INSERT INTO SUPPLIER_PRICING VALUES(8,3,1,31000);
INSERT INTO SUPPLIER_PRICING VALUES(9,1,5,1450);
INSERT INTO SUPPLIER_PRICING VALUES(10,4,2,999);
INSERT INTO SUPPLIER_PRICING VALUES(11,7,3,549);
INSERT INTO SUPPLIER_PRICING VALUES(12,7,4,529);
INSERT INTO SUPPLIER_PRICING VALUES(13,6,2,105);
INSERT INTO SUPPLIER_PRICING VALUES(14,6,1,99);
INSERT INTO SUPPLIER_PRICING VALUES(15,2,5,2999);
INSERT INTO SUPPLIER_PRICING VALUES(16,5,2,2999);


SET  FOREIGN_KEY_CHECKS=0;

insert into `order`(ORD_ID,ORD_AMOUNT,ORD_DATE,CUS_ID,PRICING_ID) 
values(101,1500,'2021-10-06',2,1),(102,1000,'2021-10-12',3,5),(103,30000,'2021-09-16',5,2),(104,1500,'2021-10-05',1,1),(105,3000,'2021-08-16',4,3),(106,1450,'2021-08-18',1,9),(107,789,'2021-09-01',3,7),(108,780,'2021-09-07',5,6),(109,3000,'2021-09-10',5,3),(110,2500,'2021-09-10',2,4),(111,1000,'2021-09-15',4,5),(112,789,'2021-09-16',4,7),(113,31000,'2021-09-16',1,8),(114,1000,'2021-09-16',3,5),(115,3000,'2021-09-16',5,3),(116,99,'021-09-17',2,14);

insert into rating(RAT_ID,ORD_ID,RAT_RATSTARS) 
values(1,101,4),(2,102,3),(3,103,1),(4,104,2),(5,105,4),(6,106,3),(7,107,4),(8,108,4),(9,109,3),(10,110,5),(11,111,3),(12,112,4),(13,113,2),(14,114,1),(15,115,1),(16,116,0);

-- ------------------------------------------------------------------------------------------------------------ --



-- Display the total number of customers based on gender who have placed orders of worth at least Rs.3000. --
SELECT customer.CUS_GENDER , COUNT(customer.CUS_ID)
FROM customer LEFT JOIN `order`
ON customer.CUS_ID = `order`.CUS_ID where `order`.ORD_AMOUNT >= 3000
group by customer.CUS_GENDER ;

-- Display all the orders along with product name ordered by a customer having Customer_Id=2 --

SELECT product.pro_name AS pro_name,
  `order`.ORD_ID AS orderID
FROM  product
INNER JOIN supplier_pricing
  ON supplier_pricing.PRO_ID = product.PRO_ID
INNER JOIN `order`
  ON supplier_pricing.PRICING_ID = `order`.PRICING_ID
where `order`.CUS_ID = 2;

-- Display the Supplier details who can supply more than one product.

SELECT *
FROM supplier
INNER JOIN 
  (
  SELECT distinct SUPP_ID 
  FROM supplier_pricing
  GROUP BY SUPP_ID
  HAVING COUNT(distinct supplier_pricing.PRO_ID) > 1
  ) as cnt
 ON supplier.SUPP_ID = cnt.SUPP_ID;

-- Find the least expensive product from each category and print the table with category id, name, product name and price of the product --

select category.CAT_ID, category.CAT_NAME, product.PRO_NAME, supplier_pricing.SUPP_PRICE 
from category 
inner join product on category.CAT_ID = product.CAT_ID
inner join supplier_pricing on supplier_pricing.PRO_ID = product.PRO_ID
group by category.CAT_NAME having min(supplier_pricing.SUPP_PRICE);

 -- Display the Id and Name of the Product ordered after “2021-10-05”. --
 
 
 select PRO_ID, PRO_NAME from product where PRO_ID in ( select PRO_ID from supplier_pricing 
 where PRICING_ID in (select pRICING_ID from `order` where ORD_DATE>'2021-10-05'));
 
-- Display customer name and gender whose names start or end with character 'A'. --

select CUS_NAME ,CUS_GENDER from customer
where CUS_NAME like 'A%' or CUS_NAME like '%A';

-- Create a stored procedure to display supplier id, name, rating and Type_of_Service. For Type_of_Service, If rating =5, print “Excellent Service”,If rating >4 print “Good Service”, If rating >2 print “Average Service” else print “Poor Service”. --

select `order`.PRICING_ID, avg(rating.RAT_RATSTARS) as rating, case
when avg(rating.RAT_RATSTARS)=5 then 'Excellent Service'
when avg(rating.RAT_RATSTARS)>5 then 'Good Service'
when avg(rating.RAT_RATSTARS)>5 then 'Average Service'
else 'Poor Service' end as Type_of_Service from `order`
inner join rating where `order`.ORD_ID = rating.ORD_ID group by `order`.PRICING_ID;