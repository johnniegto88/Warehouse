-- MySQL dump 10.13  Distrib 5.5.30, for Win32 (x86)
--
-- Host: localhost    Database: warehouse
-- ------------------------------------------------------
-- Server version	5.5.30

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
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'johnniegto','wonderer'),(2,'gia','12345');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `sName` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `telnumber` varchar(15) DEFAULT NULL,
  `city` varchar(15) DEFAULT NULL,
  `adr` varchar(50) DEFAULT NULL,
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'John','Magalios','johnniegto88@yahoo.gr','6974502570','Koridallos','G.Gennimata 29','johnniegto','wonderer'),(2,'George','Papaioannou','g.papaioannou@gmail.com','6987906543','Aigalew','Kotiorwn 48','geo','123'),(3,'Pantelis','Bariamoglou','pan_mpa@hotmail.com','21092000000','Athens','Kolokotroni 1','pbariamoglou','Ec8ArQ');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehousefactory`
--

DROP TABLE IF EXISTS `warehousefactory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `warehousefactory` (
  `itemID` int(11) NOT NULL AUTO_INCREMENT,
  `itemTitle` varchar(25) DEFAULT NULL,
  `itemDesc` varchar(100) DEFAULT NULL,
  `itemPrice` varchar(10) DEFAULT NULL,
  `expDate` varchar(10) DEFAULT NULL,
  `userId` int(10) DEFAULT NULL,
  `lastBidFromUser` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`itemID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehousefactory`
--

LOCK TABLES `warehousefactory` WRITE;
/*!40000 ALTER TABLE `warehousefactory` DISABLE KEYS */;
INSERT INTO `warehousefactory` VALUES (1,'car','Honda Civic','4660',NULL,NULL,'gg2'),(2,'laptop','dell','150','25/02/2014',NULL,'johnniegto'),(3,'pc','full pc','100','30/12/2014',NULL,'johnniegto'),(4,'ps3 game','killzone 3','6','25/01/2014',NULL,'johnniegto'),(5,'ps4','new','405','25/02/2014',1,'gg'),(16,'stereo','ok','55','7/1/14',2,'johnniegto'),(17,'Tilefono','Sony Erricsson super phone very cheap BUY','105','12/02/14',3,'johnniegto');
/*!40000 ALTER TABLE `warehousefactory` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-01-12 13:57:44
