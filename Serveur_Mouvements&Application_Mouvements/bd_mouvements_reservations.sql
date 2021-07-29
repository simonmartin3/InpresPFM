CREATE DATABASE  IF NOT EXISTS `bd_mouvements` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_mouvements`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_mouvements
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservations` (
  `idReservation` varchar(20) NOT NULL,
  `idContainer` varchar(50) NOT NULL,
  `idSociete` varchar(50) NOT NULL,
  `idTransporteur` varchar(20) NOT NULL,
  `dateReservation` varchar(20) NOT NULL,
  PRIMARY KEY (`idReservation`),
  KEY `reservations_ibfk_3` (`idTransporteur`),
  KEY `idSociete` (`idSociete`),
  CONSTRAINT `reservations_ibfk_1` FOREIGN KEY (`idSociete`) REFERENCES `societes` (`idSociete`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `reservations_ibfk_3` FOREIGN KEY (`idTransporteur`) REFERENCES `transporteurs` (`idTransporteur`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
INSERT INTO `reservations` VALUES ('R-000001','C-000-AAA','Pede Consulting','000-000-001','12/01/2020'),('R-000002','C-000-AAB','Quis Ltd','000-000-005','05/03/2020'),('R-000003','C-000-AAC','Pede Consulting','000-000-001','14/06/2020'),('R-000004','C-000-AAD','Ipsum Consulting','000-000-004','15/08/2020'),('R-000005','C-000-AAE','Urna Nec PC','000-000-003','26/10/2020');
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-28 16:54:45
