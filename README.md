Instructions:
1. jdk version 17.
2. create all tables first then run this application.
3. set database name,database username,database password in databaseConfig.java.

CATEGORY TABLE
CREATE TABLE `category` (
  `cat_id` int NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(50) NOT NULL,
  `cat_desc` varchar(100) NOT NULL,
  PRIMARY KEY (`cat_id`)
)

PRODUCT TABLE
CREATE TABLE `product` (
  `prod_id` int NOT NULL AUTO_INCREMENT,
  `prod_name` varchar(50) NOT NULL,
  `prod_desc` varchar(100) NOT NULL,
  `prod_price` float NOT NULL,
  `prod_quantity` int NOT NULL,
  `category_id` int NOT NULL,
  PRIMARY KEY (`prod_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`cat_id`)
)

ORDERS TABLE
CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `order_status` varchar(30) NOT NULL,
  `customer_id` int NOT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`cust_id`)
)

ORDER_ITEMS TABLE
CREATE TABLE `order_items` (
  `order_item_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `product_id` int NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`order_item_id`),
  KEY `order_id` (`order_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `order_items_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `order_items_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`prod_id`)
)

CUSTOMER TABLE
CREATE TABLE `customer` (
  `cust_id` int NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(30) NOT NULL,
  `cust_address` varchar(100) NOT NULL,
  `cust_phone` bigint NOT NULL,
  PRIMARY KEY (`cust_id`)
)



