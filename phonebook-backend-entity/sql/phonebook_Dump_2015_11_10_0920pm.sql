CREATE DATABASE  IF NOT EXISTS `phonebook` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `phonebook`;
-- MySQL dump 10.13  Distrib 5.6.26, for Linux (x86_64)
--
-- Host: localhost    Database: phonebook
-- ------------------------------------------------------
-- Server version	5.6.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `company_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) NOT NULL,
  `code` varchar(10) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(345) DEFAULT NULL,
  `address1` varchar(45) DEFAULT NULL,
  `address2` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zip` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`company_id`),
  KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_location`
--

DROP TABLE IF EXISTS `company_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company_location` (
  `company_location_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  `company_id` int(11) NOT NULL,
  `address1` varchar(45) DEFAULT NULL,
  `address2` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zip` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`company_location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_location`
--

LOCK TABLES `company_location` WRITE;
/*!40000 ALTER TABLE `company_location` DISABLE KEYS */;
/*!40000 ALTER TABLE `company_location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contacts`
--

DROP TABLE IF EXISTS `contacts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contacts` (
  `contact_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `prefix` varchar(45) DEFAULT NULL,
  `first_name` varchar(45) NOT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) NOT NULL,
  `suffix` varchar(45) DEFAULT NULL,
  `address1` varchar(45) DEFAULT NULL,
  `address2` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(2) DEFAULT NULL,
  `zip` varchar(45) DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL,
  `entered_by` int(11) DEFAULT NULL,
  `entered_date` datetime DEFAULT NULL,
  `edited_by` int(11) DEFAULT NULL,
  `edited_date` datetime DEFAULT NULL,
  `birthdate` datetime DEFAULT NULL,
  PRIMARY KEY (`contact_id`),
  KEY `fk_contacts_1` (`user_id`),
  CONSTRAINT `fk_contacts_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacts`
--

LOCK TABLES `contacts` WRITE;
/*!40000 ALTER TABLE `contacts` DISABLE KEYS */;
INSERT INTO `contacts` VALUES (2,1,'Mr.','updated_fn','middle_name','updated_ln','Jr.','123 main street','Apt. 456','Randolph','MA','11111-1234',0,1,'2013-06-21 00:00:00',1,'2013-06-21 00:00:00','1966-11-03 00:00:00'),(3,2,'Mr.','Timothy','Scott','Holmes1','Jr.','43 Wheeler Circle','Apartment 37','Brewster','MA','12345',0,1,'2012-08-21 09:36:47',1,'2012-08-21 09:36:47','2012-08-21 09:36:47'),(4,2,NULL,'Tom','J','Holmes',NULL,'19 Devine Road',NULL,'Randolph','MA','02368',0,1,'2012-08-21 10:48:14',2,'2012-08-27 11:38:49','1966-11-03 09:48:14'),(5,3,'Mr.','John',NULL,'Pallozzi',NULL,'123 Main Street',NULL,'Boston','MA','12345',0,3,'2012-08-27 12:33:28',3,'2012-08-29 12:17:01','2012-08-27 12:00:00'),(6,3,NULL,'ssdfds',NULL,'sdfsdf',NULL,'sdfsdf',NULL,'sdsdf','sd','sdfsdf',0,3,'2012-08-29 12:17:25',3,'2012-08-29 12:17:25','2012-08-29 12:00:00');
/*!40000 ALTER TABLE `contacts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contacts_email`
--

DROP TABLE IF EXISTS `contacts_email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contacts_email` (
  `contacts_email_id` int(11) NOT NULL AUTO_INCREMENT,
  `contact_id` int(11) NOT NULL,
  `email_type_id` int(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  `entered_date` datetime NOT NULL,
  PRIMARY KEY (`contacts_email_id`),
  KEY `fk_contacts_email_1` (`contact_id`),
  KEY `fk_contacts_email_2` (`email_type_id`),
  CONSTRAINT `fk_contacts_email_1` FOREIGN KEY (`contact_id`) REFERENCES `contacts` (`contact_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_contacts_email_2` FOREIGN KEY (`email_type_id`) REFERENCES `email_type` (`email_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacts_email`
--

LOCK TABLES `contacts_email` WRITE;
/*!40000 ALTER TABLE `contacts_email` DISABLE KEYS */;
INSERT INTO `contacts_email` VALUES (1,4,1,'tholmes@tomholmes.net','2012-08-03 11:22:33'),(2,4,2,'tech@tomholmes.net','2012-08-03 09:24:56'),(3,3,1,'tim@timholmes.net','2012-08-03 09:28:21'),(4,2,1,'tom@tomholmes.net','2012-08-03 09:28:57'),(5,5,2,'test1@test.com','2012-08-28 15:41:19'),(6,5,3,'test2@test.com','2012-08-28 15:58:34'),(7,5,1,'test3@test.com','2012-08-29 11:06:22');
/*!40000 ALTER TABLE `contacts_email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contacts_link`
--

DROP TABLE IF EXISTS `contacts_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contacts_link` (
  `contacts_link_id` int(11) NOT NULL AUTO_INCREMENT,
  `contact_id` int(11) NOT NULL,
  `link_type_id` int(11) NOT NULL,
  `link_description` varchar(80) NOT NULL,
  `link_url` varchar(245) NOT NULL,
  `entered_date` datetime DEFAULT NULL,
  PRIMARY KEY (`contacts_link_id`),
  UNIQUE KEY `index2` (`link_url`),
  KEY `fk_contacts_link_1` (`contact_id`),
  KEY `fk_contacts_link_2` (`link_type_id`),
  CONSTRAINT `fk_contacts_link_1` FOREIGN KEY (`contact_id`) REFERENCES `contacts` (`contact_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_contacts_link_2` FOREIGN KEY (`link_type_id`) REFERENCES `link_type` (`link_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacts_link`
--

LOCK TABLES `contacts_link` WRITE;
/*!40000 ALTER TABLE `contacts_link` DISABLE KEYS */;
INSERT INTO `contacts_link` VALUES (2,5,7,'test two description','www.test2.com','2012-08-29 11:50:33'),(4,6,3,'sdfsdf','sdsdf','2012-08-29 12:16:06');
/*!40000 ALTER TABLE `contacts_link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contacts_phone`
--

DROP TABLE IF EXISTS `contacts_phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contacts_phone` (
  `contacts_phone_id` int(11) NOT NULL AUTO_INCREMENT,
  `contact_id` int(11) NOT NULL,
  `phone_type_id` int(11) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `entered_date` datetime NOT NULL,
  PRIMARY KEY (`contacts_phone_id`),
  UNIQUE KEY `phone_unq` (`phone`),
  KEY `fk_contacts_phone_1` (`contact_id`),
  KEY `fk_contacts_phone_2` (`phone_type_id`),
  CONSTRAINT `fk_contacts_phone_1` FOREIGN KEY (`contact_id`) REFERENCES `contacts` (`contact_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_contacts_phone_2` FOREIGN KEY (`phone_type_id`) REFERENCES `phone_type` (`phone_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacts_phone`
--

LOCK TABLES `contacts_phone` WRITE;
/*!40000 ALTER TABLE `contacts_phone` DISABLE KEYS */;
INSERT INTO `contacts_phone` VALUES (4,4,1,'111-444-5555','2012-08-22 14:52:14'),(9,5,1,'781-961-3156','2012-08-28 14:41:48'),(10,5,3,'111-222-3333','2012-08-28 15:34:38'),(11,5,2,'222-333-1112','2012-08-29 11:06:22');
/*!40000 ALTER TABLE `contacts_phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dict_suffix`
--

DROP TABLE IF EXISTS `dict_suffix`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dict_suffix` (
  `dict_suffix_id` int(11) NOT NULL AUTO_INCREMENT,
  `dict_suffix_name` varchar(45) NOT NULL,
  `dict_suffix_active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`dict_suffix_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dict_suffix`
--

LOCK TABLES `dict_suffix` WRITE;
/*!40000 ALTER TABLE `dict_suffix` DISABLE KEYS */;
INSERT INTO `dict_suffix` VALUES (1,'Mr.',1),(2,'Miss',1),(3,'Mrs.',1),(4,'Dr.',1);
/*!40000 ALTER TABLE `dict_suffix` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email_type`
--

DROP TABLE IF EXISTS `email_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `email_type` (
  `email_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `email_type_description` varchar(45) NOT NULL,
  `email_type_active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`email_type_id`),
  UNIQUE KEY `email_type_description_UNIQUE` (`email_type_description`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email_type`
--

LOCK TABLES `email_type` WRITE;
/*!40000 ALTER TABLE `email_type` DISABLE KEYS */;
INSERT INTO `email_type` VALUES (1,'Home',1),(2,'Work',1),(3,'Office',1);
/*!40000 ALTER TABLE `email_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `link_type`
--

DROP TABLE IF EXISTS `link_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `link_type` (
  `link_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `link_type_description` varchar(45) NOT NULL,
  `link_type_active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`link_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `link_type`
--

LOCK TABLES `link_type` WRITE;
/*!40000 ALTER TABLE `link_type` DISABLE KEYS */;
INSERT INTO `link_type` VALUES (1,'Home',1),(2,'Office',1),(3,'Work',1),(4,'LinkedIn',1),(5,'Facebook',1),(6,'Personal',1),(7,'Other',1),(8,'Google',1);
/*!40000 ALTER TABLE `link_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_type`
--

DROP TABLE IF EXISTS `phone_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phone_type` (
  `phone_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_type_description` varchar(45) NOT NULL,
  `phone_type_active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`phone_type_id`),
  UNIQUE KEY `phone_type_description_UNIQUE` (`phone_type_description`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_type`
--

LOCK TABLES `phone_type` WRITE;
/*!40000 ALTER TABLE `phone_type` DISABLE KEYS */;
INSERT INTO `phone_type` VALUES (1,'Home',1),(2,'Work',1),(3,'Office',1),(4,'Cell',1);
/*!40000 ALTER TABLE `phone_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `position` (
  `position_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  `code` varchar(45) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`position_id`),
  UNIQUE KEY `code_unq` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,1,'ADMIN','Administrator'),(2,1,'USER','User'),(3,1,'OTHER','Other');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  `position_id` int(11) NOT NULL DEFAULT '2',
  `username` varchar(50) NOT NULL,
  `password` varchar(15) NOT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `security_question_1` varchar(145) NOT NULL,
  `security_answer_1` varchar(45) NOT NULL,
  `security_question_2` varchar(145) NOT NULL,
  `security_answer_2` varchar(45) NOT NULL,
  `birthdate` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username_uq` (`username`),
  UNIQUE KEY `email_uq` (`email`),
  KEY `fk_users_1` (`position_id`),
  CONSTRAINT `fk_users_1` FOREIGN KEY (`position_id`) REFERENCES `position` (`position_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,1,1,'demo','demo','Demo','Demo','tom@tomholmes.net','aaa','bbb','ccc','ddd','1966-11-01 00:00:00'),(2,1,2,'user1','pass11','Thomas','Holmes','tim@tomholmes.net','question11','answer11','question21','answer21','1966-11-03 00:00:00'),(3,1,2,'user2','pass22','Kevin','Folan','test1email','aaa','bbb','ccc','ddd','1943-08-25 00:00:00'),(4,1,2,'user3','pass3','test3first','test3last','test3email','aaa','bbb','ccc','ddd',NULL),(5,1,2,'test5','xxx','Test5First','Test5Last','test2email','City father Born','aaa','City father Born','aaa','2012-08-29 12:00:00'),(6,0,2,'tom@tomholmes.net','passw0rd','tom_upd','holmes_upd','tom@tomholmes.upd','question11','answer11','question22','answer22',NULL),(9,0,3,'user2new','pass4upd','tom4_upd','holmes4_upd','tom@tomholmes1.new','question1upd','answer1upd','question2upd','answer2upd',NULL),(10,1,2,'user3new','pass3new','tom3_new','holmes3_new','tom@tomholmes2.new','question1','answer1','question2','answer2',NULL),(11,1,2,'user4new','pass4new','tom4_new','holmes4_new','tom@tomholmes3.new','question1','answer1','question2','answer2',NULL),(12,1,2,'user5new','pass5new','tom5_new','holmes5_new','tom@tomholmes4.new','question1new','answer1new','question2new','answer2ew',NULL),(13,0,2,'test1','test1pwd','test1first','test1last','test1@email.com','aaa','bbb','ccc','ddd','1967-05-30 20:00:00'),(14,1,2,'test2','test2pwd','test2first','test2last','test2@email.com','eee','fff','ggg','hhh','1980-05-05 20:00:00');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-10 21:20:20
