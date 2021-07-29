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
-- Table structure for table `mouvements`
--

DROP TABLE IF EXISTS `mouvements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mouvements` (
  `idMouvement` int NOT NULL AUTO_INCREMENT,
  `idContainer` varchar(20) NOT NULL,
  `idTransporteurIn` varchar(20) NOT NULL,
  `dateArrivee` varchar(20) NOT NULL,
  `idTransporteurOut` varchar(20) DEFAULT NULL,
  `poids` int NOT NULL,
  `dateDepart` varchar(20) DEFAULT NULL,
  `destination` varchar(30) NOT NULL,
  PRIMARY KEY (`idMouvement`),
  KEY `destination` (`destination`),
  KEY `idContainer` (`idContainer`),
  KEY `idTransporteurIn` (`idTransporteurIn`),
  KEY `idTransporteurOut` (`idTransporteurOut`),
  CONSTRAINT `mouvements_ibfk_1` FOREIGN KEY (`destination`) REFERENCES `destination` (`ville`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `mouvements_ibfk_2` FOREIGN KEY (`idContainer`) REFERENCES `containers` (`idContainer`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `mouvements_ibfk_3` FOREIGN KEY (`idTransporteurIn`) REFERENCES `transporteurs` (`idTransporteur`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `mouvements_ibfk_4` FOREIGN KEY (`idTransporteurOut`) REFERENCES `transporteurs` (`idTransporteur`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mouvements`
--

LOCK TABLES `mouvements` WRITE;
/*!40000 ALTER TABLE `mouvements` DISABLE KEYS */;
/*!40000 ALTER TABLE `mouvements` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-28 16:54:44
