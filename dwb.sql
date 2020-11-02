CREATE DATABASE  IF NOT EXISTS `sakila` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sakila`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: sakila
-- ------------------------------------------------------
-- Server version	5.7.30-log

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
-- Table structure for table `dwb`
--

DROP TABLE IF EXISTS `dwb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dwb` (
  `dwbh` varchar(30) NOT NULL,
  `dwmc` varchar(45) DEFAULT NULL,
  `sjdwbh` varchar(45) DEFAULT NULL,
  `xzqh` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`dwbh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dwb`
--

LOCK TABLES `dwb` WRITE;
/*!40000 ALTER TABLE `dwb` DISABLE KEYS */;
INSERT INTO `dwb` VALUES ('10','汉东省保卫厅',NULL,'东京区'),('10001','东京市保卫局','10','东京区'),('10001001','东京市黄浦区保卫处','10001','黄浦区'),('10001002','东京市高新区保卫处','10001','高新区'),('10002','大阪市保卫局','10','大阪区'),('10002001','大阪市樱花区保卫处','10002','樱花区'),('10002002','大阪市合水区保卫处','10002','合水区'),('10003','横滨市保卫局','10','横滨区'),('10003001','横滨市清湖区保卫处','10003','清湖区');
/*!40000 ALTER TABLE `dwb` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-03 17:33:12
