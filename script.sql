CREATE DATABASE  IF NOT EXISTS `daybook` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `daybook`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: daybook
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `account_heads`
--

DROP TABLE IF EXISTS `account_heads`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_heads` (
  `code` int(11) NOT NULL AUTO_INCREMENT,
  `accountName` varchar(35) DEFAULT NULL,
  `accountCode` char(8) DEFAULT NULL,
  `transactionType` char(1) DEFAULT 'U' COMMENT 'E = Entrata\nU = Uscita',
  PRIMARY KEY (`code`),
  KEY `account_heads_accountName_IDX` (`accountName`),
  KEY `FK_account_heads_transactionType_IDX` (`transactionType`),
  CONSTRAINT `FK_account_heads_transactionTypes` FOREIGN KEY (`transactionType`) REFERENCES `transaction_types` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='The table for storing the account heads from the accounting software.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_heads`
--

LOCK TABLES `account_heads` WRITE;
/*!40000 ALTER TABLE `account_heads` DISABLE KEYS */;
INSERT INTO `account_heads` VALUES (1,'Cassa Euro','10-00-01','E'),(2,'Cassa USD','10-00-05','E'),(3,'Spese Personali','50-00-01','U'),(4,'Spese Mediche','50-00-02','U'),(5,'Formazione: Corsi e Libri','50-00-05','U'),(6,'Carità e Solidarietà Straordinaria','50-00-06','U'),(7,'Trasporto Aereo','50-20-02','U'),(8,'Altri Trasporti','50-20-06','U'),(9,'Spese Amministrative','50-40-01','U'),(10,'Segretaria Missione','51-20-37','U');
/*!40000 ALTER TABLE `account_heads` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `code` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(60) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `designation` varchar(60) DEFAULT NULL,
  `closedOn` datetime DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='Table for storing user details';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'Roberto Genuin','','Ministro Generale',NULL),(2,'José Ángel Torres Rivera','','Vicario Generale',NULL),(3,'Norbert Auberlin Solondrazana','','Consigliere Generale',NULL),(4,'Francesco Neri','','Consigliere Generale',NULL),(5,'Carlos Silva','','Consigliere Generale',NULL),(6,'Kilian Ngitir','','Consigliere Generale',NULL),(7,'Piotr Stasiński','','Consigliere Generale',NULL),(8,'Pio Murat','','Consigliere Generale',NULL),(9,'John Baptist Palliparambil','','Consigliere Generale',NULL),(10,'Victorius Dwiardy','','Consigliere Generale',NULL),(11,'Celestino Arias','','Consigliere Generale',NULL),(12,'Clayton','','Segretario Generale',NULL),(13,'Damian','','Vice Segretario Generale',NULL);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_account_heads`
--

DROP TABLE IF EXISTS `login_account_heads`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login_account_heads` (
  `code` int(11) NOT NULL AUTO_INCREMENT,
  `login` int(11) DEFAULT NULL,
  `accountHeads` int(11) DEFAULT NULL,
  PRIMARY KEY (`code`),
  KEY `FK_loginAccountHeads_accountHeads_idx` (`accountHeads`),
  KEY `FK_loginAccountHeads_login_idx` (`login`),
  CONSTRAINT `FK_loginAccountHeads_accountHeads` FOREIGN KEY (`accountHeads`) REFERENCES `account_heads` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_loginAccountHeads_login` FOREIGN KEY (`login`) REFERENCES `login` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Table for setting the account heads usable for each login user.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_account_heads`
--

LOCK TABLES `login_account_heads` WRITE;
/*!40000 ALTER TABLE `login_account_heads` DISABLE KEYS */;
/*!40000 ALTER TABLE `login_account_heads` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `register`
--

DROP TABLE IF EXISTS `register`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `register` (
  `code` bigint(20) NOT NULL AUTO_INCREMENT,
  `transactionDate` datetime DEFAULT NULL,
  `amount` decimal(8,2) DEFAULT NULL,
  `debit` int(11) DEFAULT NULL,
  `credit` int(11) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `login` int(11) DEFAULT NULL COMMENT 'column for storing the user id.',
  PRIMARY KEY (`code`),
  KEY `FK_Debit_idx` (`debit`),
  KEY `FK_Credit_idx` (`credit`),
  KEY `FK_UserID_idx` (`login`),
  KEY `register_search_IDX` (`transactionDate`,`login`,`debit`,`credit`),
  CONSTRAINT `FK_register_credit` FOREIGN KEY (`credit`) REFERENCES `account_heads` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_register_debit` FOREIGN KEY (`debit`) REFERENCES `account_heads` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_register_login` FOREIGN KEY (`login`) REFERENCES `login` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='The table for registering the daybook entries.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `register`
--

LOCK TABLES `register` WRITE;
/*!40000 ALTER TABLE `register` DISABLE KEYS */;
INSERT INTO `register` VALUES (1,'2019-02-18 00:00:00',500.00,2,NULL,'DEsfsda',1),(2,'2019-02-18 00:00:00',2500.00,1,NULL,'Test',1),(3,'2019-02-18 00:00:00',1000.00,7,1,'Test',1),(4,'2019-02-18 00:00:00',15.00,9,2,'sdafdf',1),(5,'2019-02-19 00:00:00',10.00,10,1,'ASTe',1),(6,'2019-02-19 00:00:00',13.00,8,2,'asdf',1),(7,'2019-01-01 00:00:00',14.00,7,1,'afs',1),(8,'2019-01-01 00:00:00',2500.00,1,NULL,'wer',1),(9,'2019-01-29 00:00:00',16.00,9,1,'sadf',1),(10,'2019-02-21 00:00:00',500.00,2,NULL,'',1),(11,'2019-02-20 00:00:00',15.00,3,1,'Test',1),(12,'2019-02-01 00:00:00',15.00,6,1,'Test',1),(13,'2019-02-01 00:00:00',40.00,1,NULL,'dfgdf',1),(14,'2019-02-20 00:00:00',100.00,1,NULL,'dfsg',1),(15,'2019-01-01 00:00:00',30.00,1,NULL,'sadf',1),(16,'2019-03-01 00:00:00',1200.00,1,NULL,'asd',1),(17,'2019-03-01 00:00:00',500.00,6,1,'zsdf',1),(18,'2019-02-26 00:00:00',352.00,6,1,'sdf',1),(19,'2019-02-22 00:00:00',890.00,7,1,'sdaf',1),(20,'2019-03-04 00:00:00',85.00,6,9,'1',1),(21,'2019-03-06 00:00:00',135.00,4,1,'Decrizione Breve',1),(22,'2019-03-15 00:00:00',342.00,1,NULL,'Dalla Provincia di Roma',1),(23,'2019-01-01 00:00:00',500.00,2,NULL,'Dall Economato',1),(24,'2019-01-01 00:00:00',20.00,8,2,'fsdf',1),(25,'2019-04-02 00:00:00',230.00,1,NULL,'gfh',1),(26,'2019-04-02 00:00:00',35.00,7,1,'dgsbdsf',1),(49,'2019-03-21 00:00:00',52.00,8,1,'gfh',1);
/*!40000 ALTER TABLE `register` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_types`
--

DROP TABLE IF EXISTS `transaction_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction_types` (
  `code` char(1) NOT NULL,
  `transactionType` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Table for storing the types of transactions involved - two values (Entrata or Uscita)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_types`
--

LOCK TABLES `transaction_types` WRITE;
/*!40000 ALTER TABLE `transaction_types` DISABLE KEYS */;
INSERT INTO `transaction_types` VALUES ('E','Entrata'),('U','Uscita');
/*!40000 ALTER TABLE `transaction_types` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-13 10:41:19
