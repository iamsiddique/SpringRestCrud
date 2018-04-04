# Host: localhost  (Version 5.5.42)
# Date: 2018-04-04 07:56:37
# Generator: MySQL-Front 5.4  (Build 1.10)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "courier_centers"
#

DROP TABLE IF EXISTS `courier_centers`;
CREATE TABLE `courier_centers` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `pincode` varchar(15) DEFAULT NULL,
  `address` text,
  `state` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

#
# Data for table "courier_centers"
#

INSERT INTO `courier_centers` VALUES (10,'560001','Shivajinagar','Karnataka','India','Bangalore',NULL),(11,'pincode','address','state','country',NULL,NULL),(12,'pincode','address','state','country',NULL,'email'),(13,'pincode','address','state','country',NULL,'email@email.com'),(14,'pincode','address','state','country',NULL,NULL),(15,'pincode123','address','state','country',NULL,NULL),(16,'pincode','address','state','country',NULL,NULL),(17,'pincode','address','state','country',NULL,'test@test.com');

#
# Structure for table "courier_centers1"
#

DROP TABLE IF EXISTS `courier_centers1`;
CREATE TABLE `courier_centers1` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `pincode` varchar(15) DEFAULT NULL,
  `address` text,
  `state` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

#
# Data for table "courier_centers1"
#

INSERT INTO `courier_centers1` VALUES (10,'560001','Shivajinagar','Karnataka','India','Bangalore',NULL),(11,'pincode','address','state','country',NULL,NULL),(12,'pincode','address','state','country',NULL,'email'),(13,'pincode','address','state','country',NULL,'email@email.com'),(14,'pincode','address','state','country',NULL,NULL),(15,'pincode123','address','state','country',NULL,NULL),(16,'pincode','address','state','country',NULL,NULL),(17,'pincode','address','state','country',NULL,'test@test.com');

#
# Structure for table "products"
#

DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `photo_file_name` varchar(255) DEFAULT NULL,
  `photo_unique_file_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

#
# Data for table "products"
#

INSERT INTO `products` VALUES (13,'sugar','SU110','screenshot.png','7064d4b6e44b4961b144f120be8c6138.png'),(14,'name','code',NULL,NULL),(15,'name','code123',NULL,NULL);

#
# Structure for table "inventory"
#

DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `courier_center_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `product_id` (`product_id`),
  KEY `courier_center_id` (`courier_center_id`),
  CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`Id`),
  CONSTRAINT `inventory_ibfk_2` FOREIGN KEY (`courier_center_id`) REFERENCES `courier_centers` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

#
# Data for table "inventory"
#

INSERT INTO `inventory` VALUES (11,13,'2020-10-10',10,435),(12,13,'2020-10-11',10,-19),(13,13,'2020-10-11',14,10),(14,13,'2017-03-25',10,116),(15,14,'2017-03-25',10,45);

#
# Structure for table "seed_roles"
#

DROP TABLE IF EXISTS `seed_roles`;
CREATE TABLE `seed_roles` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

#
# Data for table "seed_roles"
#

INSERT INTO `seed_roles` VALUES (1,'admin'),(2,'courier_boy'),(3,'manager');

#
# Structure for table "service_availability"
#

DROP TABLE IF EXISTS `service_availability`;
CREATE TABLE `service_availability` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `pincode` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `pincode` (`pincode`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

#
# Data for table "service_availability"
#

INSERT INTO `service_availability` VALUES (6,'560001'),(12,'560005');

#
# Structure for table "stock_dispatch"
#

DROP TABLE IF EXISTS `stock_dispatch`;
CREATE TABLE `stock_dispatch` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `to_addr` varchar(255) DEFAULT NULL,
  `invoice_date` date DEFAULT NULL,
  `courier_center_id` int(11) DEFAULT NULL,
  `payment_mode` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `courier_center_id` (`courier_center_id`),
  CONSTRAINT `stock_dispatch_ibfk_1` FOREIGN KEY (`courier_center_id`) REFERENCES `courier_centers` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

#
# Data for table "stock_dispatch"
#

INSERT INTO `stock_dispatch` VALUES (1,'toAddress','2017-01-01',10,NULL),(3,'toAddress','2017-01-01',10,NULL),(4,'toAddress','2017-01-01',10,NULL),(5,'toAddress','2017-01-01',10,NULL),(6,'toAddress','2017-01-01',10,NULL),(7,'toAddress','2017-01-01',10,NULL),(8,'toAddress','2017-01-01',10,NULL),(9,'toAddress','2017-01-01',10,NULL),(10,'toAddress','2017-01-01',10,NULL),(11,'toAddress','2017-01-01',10,NULL),(12,'toAddress','2017-01-01',10,'cash');

#
# Structure for table "stock_dispatch_products"
#

DROP TABLE IF EXISTS `stock_dispatch_products`;
CREATE TABLE `stock_dispatch_products` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `stock_dispatch_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `invoice_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `stock_dispatch_id` (`stock_dispatch_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `stock_dispatch_products_ibfk_1` FOREIGN KEY (`stock_dispatch_id`) REFERENCES `stock_dispatch` (`Id`),
  CONSTRAINT `stock_dispatch_products_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

#
# Data for table "stock_dispatch_products"
#

INSERT INTO `stock_dispatch_products` VALUES (3,3,13,'2020-02-02',20,NULL),(4,3,14,'2020-02-02',20,NULL),(5,4,13,'2020-02-02',20,NULL),(6,4,14,'2020-02-02',20,NULL),(7,5,13,'2020-10-11',3,NULL),(8,5,14,'2020-02-02',20,NULL),(9,6,13,'2020-10-11',3,NULL),(10,6,14,'2020-02-02',20,NULL),(11,7,13,'2020-10-11',3,'4546'),(12,7,14,'2020-02-02',20,NULL),(13,8,13,'2020-10-11',3,'4546'),(14,8,14,'2020-02-02',20,NULL),(15,9,13,'2020-10-11',3,'4546'),(16,9,14,'2020-02-02',20,NULL),(17,10,13,'2020-10-11',3,'4546'),(18,10,14,'2020-02-02',20,NULL),(19,11,13,'2020-10-11',3,'4546'),(20,11,14,'2020-02-02',20,NULL),(21,12,13,'2020-10-11',3,'4546'),(22,12,14,'2020-02-02',20,NULL);

#
# Structure for table "stock_entry"
#

DROP TABLE IF EXISTS `stock_entry`;
CREATE TABLE `stock_entry` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `courier_center_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `manufacture_date` date DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `entry_date` date DEFAULT NULL,
  `invoice_number` varchar(255) DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;

#
# Data for table "stock_entry"
#

INSERT INTO `stock_entry` VALUES (7,13,10,25,'2016-09-07','2017-02-08','2017-02-15',NULL,NULL),(8,1,3,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(9,1,3,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(10,1,3,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(11,1,3,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(12,1,3,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(16,13,10,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(17,13,10,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(18,13,10,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(19,13,10,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(20,13,10,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(21,13,10,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(23,13,10,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(24,13,10,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(25,13,10,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(26,13,10,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(27,13,10,120,'2016-10-10','2020-10-10',NULL,NULL,NULL),(28,13,10,250,'2016-10-10','2020-10-10',NULL,NULL,NULL),(29,13,10,5,'2016-10-10','2020-10-10',NULL,NULL,NULL),(30,13,10,5,'2016-10-10','2020-10-11',NULL,NULL,NULL),(31,13,14,5,'2016-10-10','2020-10-11',NULL,NULL,NULL),(32,13,14,5,'2016-10-10','2020-10-11',NULL,NULL,NULL),(33,13,10,12,'2017-03-25','2017-03-25','2017-03-25','10','2'),(34,13,10,21,'2017-03-25','2017-03-25','2017-03-25','1231','0'),(35,13,10,21,'2017-03-25','2017-03-25','2017-03-25','1231','0'),(36,14,10,20,'2017-03-25','2017-03-25','2017-03-25','asdsfsf','assfdsfsd'),(37,13,10,12,'2017-03-25','2017-03-25','2017-03-25','kujgyujh','hhghjgj'),(38,13,10,1,'2017-03-25','2017-03-25','2017-03-25','khkj','112'),(39,13,10,1,'2017-03-25','2017-03-25','2017-03-25','khkj','112'),(40,13,10,12,'2017-03-25','2017-03-25','2017-03-25','hgh','kbhj'),(41,14,10,25,'2017-03-25','2017-03-25','2017-03-25','jkghjg','nbvhg'),(42,13,10,25,'2017-03-25','2017-03-25','2017-03-25','hghjg','bhjj'),(43,13,10,11,'2017-03-25','2017-03-25','2017-03-25','jhjg','vhjgfj');

#
# Structure for table "users"
#

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `unique_username` (`username`),
  KEY `roles_fk` (`role_id`),
  CONSTRAINT `roles_fk` FOREIGN KEY (`role_id`) REFERENCES `seed_roles` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=latin1;

#
# Data for table "users"
#

INSERT INTO `users` VALUES (1,'admin','admin',1),(72,'test','a',2),(73,'siddi','a',2),(86,'newuploaduser123',NULL,3),(89,'n123',NULL,3),(91,'dsfdn123',NULL,3),(92,'aaaaaaaaaaa',NULL,2),(94,'aaaaaaaaaaaaaaaaaaaaaaaaa',NULL,2);

#
# Structure for table "employees"
#

DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `mobile_number` varchar(15) DEFAULT NULL,
  `alternate_number` varchar(15) DEFAULT NULL,
  `permanent_address` varchar(255) DEFAULT NULL,
  `current_address` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `bank_account_holder_name` varchar(255) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `bank_account_number` varchar(255) DEFAULT NULL,
  `bank_ifsc_code` varchar(255) DEFAULT NULL,
  `enable` int(11) NOT NULL DEFAULT '1',
  `photo_file_name` varchar(255) DEFAULT NULL,
  `photo_unique_file_name` varchar(255) DEFAULT NULL,
  `dl_file_name` varchar(255) DEFAULT NULL,
  `dl_unique_file_name` varchar(255) DEFAULT NULL,
  `pan_file_name` varchar(255) DEFAULT NULL,
  `pan_unique_file_name` varchar(255) DEFAULT NULL,
  `courier_center_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `employees_ibfk_1` (`user_id`),
  KEY `courier_center_id` (`courier_center_id`),
  CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`Id`),
  CONSTRAINT `employees_ibfk_2` FOREIGN KEY (`courier_center_id`) REFERENCES `courier_centers` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

#
# Data for table "employees"
#

INSERT INTO `employees` VALUES (1,'viqar','admin',NULL,NULL,NULL,NULL,86,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'viqar','admin',NULL,NULL,NULL,NULL,89,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'viqar','admin',NULL,NULL,NULL,NULL,91,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,10);

#
# Structure for table "courier_boys"
#

DROP TABLE IF EXISTS `courier_boys`;
CREATE TABLE `courier_boys` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `mobile_number` varchar(15) DEFAULT NULL,
  `alternate_number` varchar(15) DEFAULT NULL,
  `permanent_address` varchar(255) DEFAULT NULL,
  `current_address` varchar(255) DEFAULT NULL,
  `vehicle_type` varchar(20) DEFAULT NULL,
  `vehicle_name` varchar(50) DEFAULT NULL,
  `dl_number` varchar(50) DEFAULT NULL,
  `batch_number` varchar(50) DEFAULT NULL,
  `dl_unique_file_name` varchar(50) DEFAULT NULL,
  `rc_unique_file_name` varchar(50) DEFAULT NULL,
  `insurance_unique_file_name` varchar(50) DEFAULT NULL,
  `roadtax_unique_file_name` varchar(50) DEFAULT NULL,
  `photo_unique_file_name` varchar(50) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `bank_account_holder_name` varchar(255) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `bank_account_number` varchar(255) DEFAULT NULL,
  `bank_ifsc_code` varchar(255) DEFAULT NULL,
  `enable` int(11) NOT NULL DEFAULT '1',
  `dl_file_name` varchar(255) DEFAULT NULL,
  `rc_file_name` varchar(255) DEFAULT NULL,
  `insurance_file_name` varchar(255) DEFAULT NULL,
  `roadtax_file_name` varchar(255) DEFAULT NULL,
  `photo_file_name` varchar(255) DEFAULT NULL,
  `vehicle_owner` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `courier_boys_ibfk_1` (`user_id`),
  CONSTRAINT `courier_boys_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

#
# Data for table "courier_boys"
#

INSERT INTO `courier_boys` VALUES (21,'viqar','viqar','viqar','viqar','viqar','viqar','2W','viqar','viqar','viqar',NULL,NULL,NULL,NULL,NULL,72,NULL,'viqar',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL),(22,'siddi','siddi','siddi','siddi','siddi','siddi','2W','siddi','siddi','siddi',NULL,NULL,NULL,NULL,NULL,73,'siddi','siddi','siddi','siddi',1,NULL,NULL,NULL,NULL,NULL,NULL),(23,'aaaaa','aaaaaaaa','aaaaaaaa','aaaaaaaa','aaaaaaaaaa','aaaaaaaaa','2W','aaaaaaa','aaaaaaa','aaaaaaaaa','e1a5f55802c94a7bae469643e125ac26.jpg','2fe639e56f734244b31191d60fea0a4a.jpg','a6f5e227e23e4ff5bdd91680bdacc731.jpg','50443bcbaecc4d6a889c0ad72bcdc1eb.jpg','ee15e4c7842b47b2a0251e9fed8afe13.jpg',92,'aaaaaaaaa','aaaaaaa','aaaaaaaaa','aaaaaaaaaa',1,'my.jpg','my.jpg','my.jpg','my.jpg','my.jpg',NULL),(24,'aaaaaaaaaaa','aaaaaaaaaaa','aaaaaa','aaaaaaaaaaaaa','aaaaaaaaaa','aaaaaaaaaa','2W','aaaaaaaaa','aaaaaaaaa','aaaaaaaaa','d36915ce1a9645cf9a3bc9c4eb62c3fc.jpg','d1edb51d2b624f4ca3101d2120bc5a44.jpg','82964eebb3464342a94f9ff40c56516b.jpg','3f7fd5eebe7a4dfcb8f2a078f7376d2a.jpg','f23813eba88745589af1b83ebbf70a02.jpg',94,'aaaaaaaaaa','aaaaaaaaa','aaaaaaaa','aaaaaaaa',1,'my.jpg','my.jpg','my.jpg','my.jpg','my.jpg','S');
