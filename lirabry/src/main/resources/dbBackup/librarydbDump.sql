/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `author` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `birth_place` varchar(150) NOT NULL,
  `birth_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (1,'Kalia','Stewart','Prince George','1969-12-31 16:00:00'),(2,'Akeem','Roberts','Ca├▒as','1969-12-31 16:00:00'),(3,'Dillon','Guy','Ostellato','1969-12-31 16:00:00'),(4,'Kiona','Shannon','Grivegn┼╜e','1969-12-31 16:00:00'),(5,'firstName_test2','lastName_test3','test_UpdateCity3','1978-04-26 00:00:00'),(6,'Dorian','Dudley','Tumba','1969-12-31 16:00:00'),(7,'Genevieve','Morales','Istmina','1969-12-31 16:00:00'),(8,'Winter','Ayers','Drongen','1969-12-31 16:00:00'),(9,'Darrel','White','Hapur','1969-12-31 16:00:00'),(10,'Hillary','Parks','Kelso','1969-12-31 16:00:00'),(11,'McKenzie','Vasquez','Hunstanton','1969-12-31 16:00:00'),(12,'Demetria','Lawson','Dreieich','1969-12-31 16:00:00'),(13,'Armand','Fuller','Rancagua','1969-12-31 16:00:00'),(14,'Joy','Andrews','Valenciennes','1969-12-31 16:00:00'),(15,'Sydney','Cantu','Montalto Uffugo','1969-12-31 16:00:00');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `copies_available` int NOT NULL,
  `author_id` int NOT NULL,
  `publisher_id` int NOT NULL,
  `book_condition_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `author_id` (`author_id`),
  KEY `publisher_id` (`publisher_id`),
  KEY `book_condition_id` (`book_condition_id`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`),
  CONSTRAINT `book_ibfk_2` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`),
  CONSTRAINT `book_ibfk_3` FOREIGN KEY (`book_condition_id`) REFERENCES `book_condition` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Fusce aliquet',2,15,3,6),(2,'Etiam ligula tortor,',1,5,10,4),(3,'sit amet, dapibus id, blandit',3,8,5,5),(4,'scelerisque mollis.',3,8,9,6),(5,'test_update_2',1,4,6,5),(6,'lobortis ultrices. Vivamus',1,10,12,4),(7,'nulla. Donec non justo.',4,12,7,4),(8,'mus. Aenean',5,6,4,6),(9,'vulputate, risus a ultricies',4,11,5,2),(10,'dolor, nonummy ac, feugiat',4,10,10,4),(11,'massa. Vestibulum accumsan',2,15,3,4),(12,'eu, euismod',3,14,15,2),(13,'consequat purus. Maecenas libero est,',1,13,1,5),(14,'amet ultricies',2,3,6,1),(15,'eleifend egestas. Sed',5,1,4,2),(16,'TEST_1',3,3,10,5),(17,'TEST_1',3,3,10,5);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_condition`
--

DROP TABLE IF EXISTS `book_condition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_condition` (
  `id` int NOT NULL AUTO_INCREMENT,
  `condition_type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_condition`
--

LOCK TABLES `book_condition` WRITE;
/*!40000 ALTER TABLE `book_condition` DISABLE KEYS */;
INSERT INTO `book_condition` VALUES (1,'Fine (F)'),(2,'Near Fine (NF)'),(3,'Very Good (VG)'),(4,'Good (G)'),(5,'Fair (FR)'),(6,'Poor (P)');
/*!40000 ALTER TABLE `book_condition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_loan`
--

DROP TABLE IF EXISTS `book_loan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_loan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `checkout_date` datetime NOT NULL,
  `to_be_returned_date` datetime NOT NULL,
  `book_id` int NOT NULL,
  `patron_id` int NOT NULL,
  `employee_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `book_id` (`book_id`),
  KEY `patron_id` (`patron_id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `book_loan_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `book_loan_ibfk_2` FOREIGN KEY (`patron_id`) REFERENCES `patron` (`id`),
  CONSTRAINT `book_loan_ibfk_3` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_loan`
--

LOCK TABLES `book_loan` WRITE;
/*!40000 ALTER TABLE `book_loan` DISABLE KEYS */;
INSERT INTO `book_loan` VALUES (1,'2020-12-05 08:07:50','2021-12-04 15:51:59',12,2,3),(2,'2020-03-27 07:14:42','2021-11-25 05:02:14',11,6,3),(3,'2020-07-08 18:18:27','2020-12-06 14:50:41',13,13,6),(4,'2020-06-13 23:49:39','2022-01-22 21:46:58',5,5,1),(5,'2020-04-26 14:33:14','2021-09-29 18:23:53',14,15,1),(6,'2020-06-18 03:37:08','2022-09-05 05:18:03',3,11,2),(7,'2020-09-05 02:45:30','2021-11-24 00:12:34',14,8,1),(8,'2020-07-22 00:08:15','2022-09-28 15:01:56',2,4,5),(9,'2020-05-30 02:56:21','2021-02-02 07:59:25',15,11,3),(10,'2020-01-16 00:49:53','2021-05-28 07:49:21',8,2,2),(11,'2020-01-23 20:52:27','2020-07-13 03:37:40',7,9,2),(12,'2020-09-05 23:13:01','2022-10-13 14:59:07',11,13,3),(13,'2020-01-08 03:09:24','2020-12-14 23:46:38',11,9,4),(14,'2020-12-05 08:42:09','2021-08-13 00:04:49',8,3,2),(15,'2020-05-09 03:10:01','2021-04-23 21:08:03',9,13,2);
/*!40000 ALTER TABLE `book_loan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `date_of_employment` datetime DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `salary` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Armand','Slater','2018-07-30 03:52:06','(039116) 639073',5950.00),(2,'Tallulah','Hanson','2016-04-19 17:32:57','(037452) 226322',3218.00),(3,'Stephen','Terrell','2020-04-01 07:12:49','(033241) 631605',3345.00),(4,'Gavin','Byers','2018-11-15 21:09:57','(030628) 515818',5561.00),(5,'testEmpFNUpdate2','testEmpLNupdate2','2018-04-22 00:00:00','+359856222566',2800.00),(6,'Maggy','Frye','2020-09-03 21:04:31','(021) 44558342',4178.00),(7,'testEmpFN','testEmpLN','2018-04-22 00:00:00','+359856656565',2.50);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patron`
--

DROP TABLE IF EXISTS `patron`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patron` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `card_number` varchar(20) DEFAULT NULL,
  `register_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patron`
--

LOCK TABLES `patron` WRITE;
/*!40000 ALTER TABLE `patron` DISABLE KEYS */;
INSERT INTO `patron` VALUES (1,'Dennis','Stephenson','WWU29CJY8UY','(032) 34345256','X0K6I7K7O8B8E0V8Q0J8','2020-11-04 23:57:38'),(2,'Kylan','Roach','VOT11CXX8BM','(033302) 717490','W1W3J6G9Y8V5F2A2N0Z4','2020-05-19 10:38:14'),(3,'Yolanda','Franks','PBB32ZAU4EC','(0329) 04122028','Y6W5J5I5L3V6G9D3D0T6','2020-04-06 23:07:28'),(4,'Nasim','Jarvis','XOP12LSD5EW','(032783) 657822','T4C5H3K4Z3U4P7K8D5X9','2020-08-08 02:23:44'),(5,'Cameran','Warren','MTE56VRF3TZ','(036956) 922420','V1G2Q0Q6K7V7V8O0A2S4','2020-10-13 00:12:17'),(6,'Allegra','Rosa','DTS41VVG3UC','(034817) 578022','F8J6V5R3E0K8N7X1A1Z6','2020-04-21 14:00:29'),(7,'Madaline','Greene','YBD16ZSI7WL','(044) 54739865','Y8O9B7I4L7O4Q1M9D4S0','2020-08-05 01:11:06'),(8,'Jada','Bradley','GHV82ECM8FT','(02601) 7146751','Q8Y1O5X2F5I6V5C1U4E5','2020-11-15 16:21:58'),(9,'Vielka','Gibson','AZG39SCY2HQ','(037935) 633085','J9X5Z6G5J5L7D7F3N4I7','2020-06-28 03:14:48'),(10,'Urielle','Koch','AAG89DDT7SB','(012) 58286545','L0V9V5Z1R9Y3H6N5Y5D3','2021-01-18 02:14:29'),(11,'Veronica','Collier','CBN27GRR6KK','(0534) 67267189','B8G8Q7L1D7B7Y0G4I7N8','2020-10-22 23:08:38'),(12,'Buckminster','Russell','JZK83UEB3YX','(064) 21156891','K2L7S6M1B4D4V8N3C9M3','2020-05-08 14:17:57'),(13,'Mariam','Albert','ADK88XHG0GD','(08518) 8933855','F3Q2F8M2N4H2P0T5R5O2','2020-12-19 14:30:35'),(14,'Warren','Cross','WXD46KKZ8PS','(01577) 4776673','L4Z0K9V1W6P5U3O5E5C3','2020-07-16 05:32:01'),(15,'Ronan','Silva','IOW13BFR7BN','(038604) 990821','X9R2T5V2Y4J4V9T8N4P6','2020-08-22 16:40:42');
/*!40000 ALTER TABLE `patron` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patron_subscription`
--

DROP TABLE IF EXISTS `patron_subscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patron_subscription` (
  `id` int NOT NULL AUTO_INCREMENT,
  `start_date` datetime NOT NULL,
  `patron_id` int NOT NULL,
  `subscription_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `patron_id` (`patron_id`),
  KEY `subscription_id` (`subscription_id`),
  CONSTRAINT `patron_subscription_ibfk_1` FOREIGN KEY (`patron_id`) REFERENCES `patron` (`id`),
  CONSTRAINT `patron_subscription_ibfk_2` FOREIGN KEY (`subscription_id`) REFERENCES `subscription` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patron_subscription`
--

LOCK TABLES `patron_subscription` WRITE;
/*!40000 ALTER TABLE `patron_subscription` DISABLE KEYS */;
INSERT INTO `patron_subscription` VALUES (1,'2020-12-02 20:20:59',1,1),(2,'2020-04-14 01:14:02',2,4),(3,'2020-04-15 07:46:21',3,1),(4,'2020-08-12 08:28:11',4,3),(5,'2019-01-11 00:00:00',4,4),(6,'2020-11-07 23:57:49',6,3),(7,'2020-04-12 23:04:56',7,2),(8,'2020-07-02 02:09:23',8,3),(9,'2021-03-03 01:11:44',9,3),(10,'2020-04-10 08:33:06',10,3),(11,'2020-12-14 07:11:37',11,3),(12,'2020-07-15 23:38:22',12,3),(13,'2020-12-01 03:02:24',13,3),(14,'2021-01-09 17:29:27',14,1),(15,'2021-03-29 20:19:00',15,3),(16,'2018-04-22 00:00:00',3,4);
/*!40000 ALTER TABLE `patron_subscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publisher`
--

DROP TABLE IF EXISTS `publisher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publisher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(150) DEFAULT NULL,
  `established` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publisher`
--

LOCK TABLES `publisher` WRITE;
/*!40000 ALTER TABLE `publisher` DISABLE KEYS */;
INSERT INTO `publisher` VALUES (1,'A Limited','1978-11-26 21:06:53'),(2,'Ante Nunc Consulting','1963-09-25 19:47:11'),(3,'Tempor Diam LLC','1952-11-17 02:50:58'),(4,'Pretium Consulting','1939-11-27 07:42:56'),(5,'Sed Consequat Corp.','1937-09-07 13:17:32'),(6,'Orci Lobortis Ltd','1990-08-15 03:13:17'),(7,'Elit Pharetra Industries','1984-05-27 13:36:12'),(8,'Cursus Limited','1953-11-20 15:40:00'),(9,'Morbi Tristique Institute','1944-07-11 23:08:22'),(10,'Dui Cras Pellentesque Foundation','1973-10-26 07:08:10'),(11,'Dapibus Associates','1984-08-06 14:43:18'),(12,'Cursus Foundation','1965-09-01 04:37:59'),(13,'Rutrum Urna LLP','1978-08-14 12:38:22'),(14,'Dis Parturient Montes Ltd','1944-12-15 23:42:12'),(15,'Tristique Senectus Et Inc.','1993-08-25 08:10:19');
/*!40000 ALTER TABLE `publisher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscription`
--

DROP TABLE IF EXISTS `subscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscription` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(20) DEFAULT NULL,
  `price` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscription`
--

LOCK TABLES `subscription` WRITE;
/*!40000 ALTER TABLE `subscription` DISABLE KEYS */;
INSERT INTO `subscription` VALUES (1,'DAILY',3.00),(2,'WEEKLY',5.00),(3,'MONTHLY',15.00),(4,'YEARLY',55.00);
/*!40000 ALTER TABLE `subscription` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-24 18:28:49