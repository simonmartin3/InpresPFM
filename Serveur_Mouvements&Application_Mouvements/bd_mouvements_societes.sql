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
-- Table structure for table `societes`
--

DROP TABLE IF EXISTS `societes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `societes` (
  `idSociete` varchar(50) NOT NULL,
  `nomContact` varchar(20) NOT NULL,
  `emailContact` varchar(50) NOT NULL,
  `telContact` varchar(20) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  PRIMARY KEY (`idSociete`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `societes`
--

LOCK TABLES `societes` WRITE;
/*!40000 ALTER TABLE `societes` DISABLE KEYS */;
INSERT INTO `societes` VALUES ('Amet Ornare Lectus Corporation','Caldwell','Donec.at@dolor.com','0532787926','715-8107 Mauris St.'),('Bibendum Sed Est Corp.','Angelica','Donec.tempor@ligulaelitpretium.org','0454721810','Ap #879-7394 Enim. Road'),('Cum Sociis LLC','Dominique','vestibulum.Mauris.magna@gravidamaurisut.co.uk','0130763018','517-162 Nisl Avenue'),('Elit Nulla Corporation','Rhonda','Vestibulum.ante.ipsum@habitantmorbi.co.uk','0302147057','4018 Nisl. Ave'),('Erat Eget Ipsum Corporation','Angela','nisl.Maecenas@anequeNullam.com','0289099271','7417 Laoreet, Rd.'),('Ipsum Consulting','Carolyn','In.at.pede@duiFusce.net','0517557292','Ap #931-1244 Venenatis Rd.'),('Libero Et Tristique LLP','Audrey','Curae@Integer.ca','0424574005','152-3862 Porttitor Road'),('Pede Consulting','Bert','magna@cursusnonegestas.edu','0287125276','315-8131 Etiam Av.'),('Porta LLP','Russell','Aenean@malesuadaiderat.net','0230392323','7661 Mollis. Av.'),('Quis Associates','Hammett','leo.Morbi.neque@Namconsequatdolor.edu','0683855265','617-824 Diam Ave'),('Quis Ltd','Moses','eu.placerat.eget@Aliquam.org','0785775663','790-2903 Ultricies Av.'),('Sed Nec Consulting','Alec','dui@nulla.ca','0980779039','181-3537 Justo Av.'),('Sit Corp.','Merrill','vitae.posuere@velitAliquam.ca','0982721159','Ap #372-1469 Id Av.'),('Tristique Senectus LLP','Odette','lectus.rutrum@consectetuer.ca','0221545841','274-3947 Quisque Av.'),('Urna Nec PC','Kasper','malesuada@dapibus.net','0895638475','Ap #500-6572 Urna Av.');
/*!40000 ALTER TABLE `societes` ENABLE KEYS */;
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
