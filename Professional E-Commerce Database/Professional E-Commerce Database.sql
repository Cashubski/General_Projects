
/* SECTION 1 CREATE TABLE STATEMENTS */

CREATE TABLE adbs919Customer 
(
customer_id int(9) NOT NULL,
first_name varchar(45) NOT NULL,
last_name varchar(50) NOT NULL,
email varchar(200) NOT NULL,
phone_number varchar(13) NOT NULL,
address varchar(255) NOT NULL,
city varchar(30) NOT NULL,
zip_code varchar(8) NOT NULL,
country varchar(20) NOT NULL,
login varchar(50) NOT NULL,
password varchar(200) NOT NULL,
PRIMARY KEY (customer_id)
);

CREATE TABLE adbs919Order
(
order_no int(9) NOT NULL,
sale_id int(9) NOT NULL,
customer_id int(9) NOT NULL,
FOREIGN KEY (sale_id) REFERENCES adbs919Sale (sale_id),
FOREIGN KEY (customer_id) REFERENCES adbs919Customer (customer_id), 
PRIMARY KEY (order_no)
);

CREATE TABLE adbs919Sale 
(
sale_id int(9) NOT NULL,
sale_date int(6) NOT NULL,
quantity int(7) NOT NULL,
unit_sale_price decimal(7, 2) NOT NULL,
country_sold_to varchar(200) NOT NULL,
component_id int(9) NOT NULL,
FOREIGN KEY (component_id) REFERENCES adbs919Component(component_id),
PRIMARY KEY (sale_id)
);


CREATE TABLE adbs919Component 
(
component_id int(9) NOT NULL AUTO_INCREMENT,
component_name varchar(255) NOT NULL,
release_date int(6) NOT NULL,
brand varchar(100) NOT NULL,
stock int(6) NOT NULL,
component_type varchar(100) NOT NULL,
PRIMARY KEY (component_id)
);

CREATE TABLE adbs919Store_purchase 
(
purchase_id int(9) NOT NULL,
purchase_date int(6) NOT NULL,
quantity int(10) NOT NULL,
unit_purchase_price_usd decimal(7, 2) NOT NULL,
wholesale varchar(200) NOT NULL,
country_of_purchase varchar(200) NOT NULL,
component_id int(9) NOT NULL,
FOREIGN KEY (component_id) REFERENCES adbs919Component(component_id),
PRIMARY KEY (purchase_id)
);


/* SECTION 2 INSERT STATEMENTS */

INSERT INTO adbs919Customer VALUES (24152142, 'Malcolm', 'Hill','mhill@live.com','07241421525','22 Felix Lane','London', 'CO2 3FX','United Kingdom', 'Malhil', '1q2w3e4r5t6y'),
(23452632, 'Sean', 'Blake','seablake@gmail.com','07761892091','25 Park Terrace','Surrey', 'KY13 3YB','United Kingdom', 'Seabas', 'dj29ao23ks9'),
(61235324, 'Isaac', 'Bailey','baile1235@outlook.com','07888022081','58 Cefn Road','Berlin', 'WA1 2TU','Germany', 'Bailes', 'ASGF23SD'),
(77234212, 'Aaliyah', 'Graham','graal11@gmail.com','07007129620','72 Tonbridge Rd','Sydney', 'IV51 4HZ','Australia', 'Aaliys', '51234ASDSD'),
(64324543, 'Zak', 'Brennan','brezak@live.com','07762286304','38 Layburn Court','Texas', 'OX1 0TB','United States', 'Zakaz', '11245SSS'),
(72345334, 'Carl', 'Johnson','cj@gmail.com','07011360739','17 Grove Street','California', 'HP18 9PL','United States', 'Cj', 'ASFDG3DS'),
(12435677, 'Isabel', 'Burns','burns231@hotmail.com','07984077995','12 Bootham Terrace','Frankfurt', 'GU35 6PZ','Germany', 'Izzyb', '2ASDFAS'),
(89432142, 'Liam', 'Fuller','liamliam22@yahoo.com','07046672239','4hao Lou 704','Fuzhou - Cangshan District', 'PL10 7PG','China', 'Liamf', 'G3SAD'),
(19283754, 'Alfie', 'Joyce','aljoy22@live.com','07748330235','42 Boughton Rd','Melbourne', 'NR29 3EN', 'Australia','Al', '3ASDSAFS'),
(45236232, 'Leon', 'Davies','dav223@yahoo.com','07984248952','Gu Yi Lang 8hao 704shi','Nanjing - Xuanwu District', 'CB8 6JQ','China', 'Ledav', '3AFSADS'),
(72345433, 'Phoebe', 'Watkins','pheeebeee@gmail.com','07865273129','Wan Da Guang Chang 7chuang 615','Suzhou - Pingjiang District', 'ST19 7WZ','China', 'Phoeb', '2AFSWARAS'),
(85434432, 'Madeleine', 'Skinner','madski512@hotmail.com','07974702715','73 St Andrews Lane','London', 'IV12 8RU','United Kingdom', 'Madski', 'WADSF32'),
(23457345, 'Jayden', 'Brooks','jabroo881@live.com','07926626781', 'Marcham Road','Detroit', 'KY10 7EY','United States', 'Jayjay', 'asdasfas2'),
(75365443, 'Amber', 'Harrison','amhar34@outlook.com','07002920066','34 Botley Road','Reading', 'CB2 2RH','United Kingdom', 'Amhar', 'fwasrtw2');

INSERT INTO adbs919Order VALUES (235326234,343566234,24152142),
(635326236,442562373,23452632),
(245123524,457342323,61235324),
(512346123,632732343,77234212),
(612352122,723234543,64324543),
(667123423,312513632,72345334),
(623462342,623423623,12435677),
(112112343,534276345,89432142),
(523633342,235232632,19283754),
(523623262,623672346,45236232),
(663223178,237234623,72345433),
(672788968,627374354,23457345);


INSERT INTO adbs919Sale VALUES (343566234,201222,1,410.99,'USA',12314256),
(442562373,201222,1,410.99,'UK',12314256),
(457342323,201222,1,120.99,'Germany',66234216),
(632732343,201222,1,120.99,'Australia',66234216),
(723234543,201222,1,410.99,'USA',12314256),
(312513632,201223,2,120.99,'USA',66234216),
(623423623,201223,1,1510.99,'Germany',66432214),
(534276345,201223,7,450.99,'China',67234234),
(235232632,201224,2,450.99,'Australia',67234234),
(623672346,201224,4,110.99,'China',11245323),
(237234623,201224,1,670.99,'China',41235663),
(627374354,201225,3,110.99,'USA',62342161);

INSERT INTO adbs919Component VALUES (12314256, 'NVIDIA GeForce RTX 3060 Ti',201202,'Nvidia',87,'Graphics Card'),
(24512315, 'NVIDIA GeForce RTX 3070 Founders Edition',201029,'Nvidia',240,'Graphics Card'),
(12314343, 'NVIDIA GeForce RTX 3080 Founders Edition',200917,'Nvidia',53,'Graphics Card'),
(66432214, 'NVIDIA GeForce RTX 3090 Founders Edition',200924,'Nvidia',24,'Graphics Card'),
(41235663, 'AMD Radeon RX6800',201118,'AMD',3,'Graphics Card'),
(73252342, 'AMD XFX Radeon RX 6900 XT',201208,'AMD',167,'Graphics Card'),
(92348235, 'AMD Ryzen 9 5900X',201105,'AMD',201,'CPU'),
(67234453, 'AMD Ryzen 9 5950X',201105,'AMD',154,'CPU'),
(52343252, 'CORE I9-10900K 3.7 GHZ',200430,'Intel',64,'CPU'),
(67234234, 'Intel Core I9-9900K 3.6 GHZ',190401,'Intel',45,'CPU'),
(44421231, 'SanDisk Ultra 3D SSD 1TB',170630,'SanDisk',217,'SSD'),
(62342161, 'Samsung 860 EVO 1 TB',180623,'Samsung',113,'SSD'),
(11245323, 'Crucial MX500 1 TB',171219,'Crucial',66,'SSD'),
(11242323, 'BarraCuda 4TB Desktop Hard Drive 3.5" SATA III',140422,'Seagate',0,'HDD'),
(11245232, 'BarraCuda 1TB Desktop Hard Drive 3.5" SATA III',160916,'Seagate',0,'HDD'),
(66234216, 'Kingston SA400S37 A400 1TB',180226,'Kingston',52,'SSD');

INSERT INTO adbs919Store_purchase VALUES (234512352, 201210, 32, 349.99,'Alibaba','China',12314256),
(234123423, 180722, 49, 76.99,'Alibaba','China',62342161),
(234512122, 201205, 20, 550.99,'Tomtop','Taiwan',12314343),
(234516432, 200925, 6, 1249.99,'Alibaba','Hong Kong',66432214),
(234516634, 201119, 22, 400.98,'Alibaba','China',67234234),
(234573453, 201210, 16, 410.00,'Alibaba','Singapore',67234234),
(234512342, 201105, 14, 99.99,'Tomtop','Taiwan',66234216),
(234512325, 201105, 8, 99.99,'Alibaba','Japan',66234216),
(234516234, 200501, 10, 97.99,'Alibaba','Japan',66234216),
(234512734, 190505, 77, 52.99,'Alibaba','Japan',44421231),
(234512345, 180111, 37, 55.99,'Alibaba','Malaysia',44421231),
(234512372, 191103, 12, 51.99,'Banggood','South Korea',44421231),
(234516235, 191104, 34, 71.99,'Banggood','South Korea',62342161),
(234514336, 201210, 11, 350.99,'Taobao','China',12314256),
(234512396, 201210, 2, 345.99,'Pinduoduo','China',12314256),
(234512351, 201210, 5, 349.99,'JD','China',12314256),
(234515112, 201210, 7, 349.99,'JD','China',12314256);


/* SECTION 3 UPDATE STATEMENTS */

UPDATE adbs919Customer SET email = 'malcahill@gmail.com', last_name = 'Cahill' 
WHERE customer_id = 24152142;

UPDATE adbs919Store_purchase SET wholesale = 'Pinduoduo', country_of_purchase = 'Taiwan'
WHERE purchase_id = 234515112;


/* SECTION 4 SINGLE TABLE QUERIES */


/* 1) What components have less than 10 units left in stock? */
SELECT component_name, brand , stock
FROM adbs919Component 
WHERE stock < 10
GROUP BY component_name; 


/* 2) Display the names, brands and stock level of 10 components, in descending order.  */
SELECT component_name,brand,stock
FROM adbs919Component
GROUP BY stock
DESC
LIMIT 10;


/* 3)  How many times has Alibaba been used to source components since 2018? */
SELECT wholesale, COUNT(*) AS amount
FROM adbs919Store_purchase 
WHERE wholesale = 'Alibaba' and purchase_date > 180100
GROUP BY wholesale
ORDER BY amount;


/* 4) List the names of all components that are SSDs and their stock level in ascending order*/

SELECT component_name, stock
FROM adbs919Component
WHERE component_type = 'SSD'
GROUP BY stock 
ASC;


/* 5) What is the average price of all sales, on the 22nd of December 2020?  */
SELECT AVG(unit_sale_price) AS average
FROM adbs919Sale
WHERE sale_date = 201222;


/* 6) In descending order, what are the top 5 countries that the store sells to the most? */
SELECT country_sold_to, COUNT(country_sold_to) AS sales
FROM adbs919Sale
GROUP BY country_sold_to
ORDER BY sales
DESC
LIMIT 5;


/* SECTION 5 MULTIPLE TABLE QUERIES */

/* 1) List the order number, component name and price of all sold components.  */
SELECT component_name, unit_sale_price, order_no
FROM adbs919Component T1
INNER JOIN adbs919Sale T2
ON T1.component_id = T2.component_id
INNER JOIN adbs919Order T3
ON T2.sale_id = T3.sale_id;

/* 2)  Display the full name of a customer and the country they ordered to with their order number.*/
SELECT first_name,last_name, order_no, country_sold_to
FROM adbs919Customer T1
INNER JOIN adbs919Order T2
ON T1.customer_id = T2.customer_id
INNER JOIN adbs919Sale T3
ON T2.sale_id = T3.sale_id
GROUP BY first_name
ORDER BY first_name;

/* 3) Display all the components that were sold on the 23rd of December 2020 in alphabetical order*/ 
SELECT DISTINCT sale_date, component_type, component_name 
FROM adbs919Sale T1
INNER JOIN adbs919Component T2
ON T1.component_id = T2.component_id
HAVING sale_date = 201223
ORDER BY component_name ASC;


/* 4) Calculate the profit from every sale, from cheapest to most expensive */
SELECT DISTINCT component_name, unit_sale_price, unit_purchase_price_usd,(unit_sale_price-unit_purchase_price_usd) as profit_usd
FROM adbs919Sale T1
INNER JOIN adbs919Component T2
ON T1.component_id = T2.component_id
INNER JOIN adbs919Store_purchase T3
ON T2.component_id = T3.component_id
ORDER BY unit_sale_price;

/* 5) List the names of the components that sold above the average sale price  */
SELECT component_name
FROM adbs919Component
WHERE component_id IN
(SELECT DISTINCT (component_id)
FROM adbs919Sale 
WHERE unit_sale_price >
(SELECT AVG(unit_sale_price) FROM adbs919Sale));

/* 6)  Display how many times each component has been restocked in the past and when.*/
SELECT component_name,quantity, purchase_date
FROM adbs919Component T1
LEFT JOIN adbs919Store_purchase T2
ON T1.component_id = T2.component_id
HAVING quantity IS NOT NULL;


/*
SECTION 6 DELETE ROWS (make sure the SQL is commented out in this section)
DELETE FROM adbs919Customer
WHERE city = 'Reading';

DELETE FROM adbs919Customer
WHERE first_name = 'Madeleine';

*/

/* SECTION 6 DROP TABLES (make sure the SQL is commented out in this section)
DROP TABLE adbs919Customer;
DROP TABLE adbs919Order;
DROP TABLE adbs919Sale;
DROP TABLE adbs919Component;
DROP TABLE adbs919Store_purchase;

*/
