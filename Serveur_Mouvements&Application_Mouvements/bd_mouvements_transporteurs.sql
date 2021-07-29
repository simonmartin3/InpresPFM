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
-- Table structure for table `transporteurs`
--

DROP TABLE IF EXISTS `transporteurs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transporteurs` (
  `idTransporteur` varchar(20) NOT NULL,
  `idSociete` varchar(50) NOT NULL,
  `capacite` int NOT NULL,
  `caracteristique` varchar(50) NOT NULL,
  PRIMARY KEY (`idTransporteur`),
  KEY `idSociete` (`idSociete`),
  CONSTRAINT `transporteurs_ibfk_1` FOREIGN KEY (`idSociete`) REFERENCES `societes` (`idSociete`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transporteurs`
--

LOCK TABLES `transporteurs` WRITE;
/*!40000 ALTER TABLE `transporteurs` DISABLE KEYS */;
INSERT INTO `transporteurs` VALUES ('000-000-001','Pede Consulting',1,'Camion'),('000-000-002','Cum Sociis LLC',1,'Camion'),('000-000-003','Urna Nec PC',1,'Camion'),('000-000-004','Ipsum Consulting',1,'Camion'),('000-000-005','Quis Ltd',1,'Camion'),('000-001-000','Bibendum Sed Est Corp.',5,'Bateau'),('000-002-000','Elit Nulla Corporation',8,'Bateau'),('000-003-000','Urna Nec PC',4,'Bateau'),('000-004-000','Porta LLP',6,'Bateau'),('000-005-000','Quis Ltd',10,'Bateau');
/*!40000 ALTER TABLE `transporteurs` ENABLE KEYS */;
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
