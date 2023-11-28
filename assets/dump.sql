-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: bszw.ddns.net    Database: wit12c_hecht
-- ------------------------------------------------------
-- Server version	8.0.30-0ubuntu0.20.04.2

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
-- Table structure for table `Arzt`
--

DROP TABLE IF EXISTS `Arzt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Arzt` (
  `ArztNr` int NOT NULL,
  `ArztName` varchar(45) DEFAULT NULL,
  `ArztFaktor` double DEFAULT NULL,
  PRIMARY KEY (`ArztNr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Arzt`
--

LOCK TABLES `Arzt` WRITE;
/*!40000 ALTER TABLE `Arzt` DISABLE KEYS */;
INSERT INTO `Arzt` VALUES (16,'Klein',1),(23,'Gross',1.5),(25,'Huber',1.5),(34,'Schmidt',2);
/*!40000 ALTER TABLE `Arzt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MedLeistung`
--

DROP TABLE IF EXISTS `MedLeistung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `MedLeistung` (
  `MLeistungNr` int NOT NULL,
  `Bezeichnung` varchar(45) DEFAULT NULL,
  `Preis` double DEFAULT NULL,
  PRIMARY KEY (`MLeistungNr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MedLeistung`
--

LOCK TABLES `MedLeistung` WRITE;
/*!40000 ALTER TABLE `MedLeistung` DISABLE KEYS */;
INSERT INTO `MedLeistung` VALUES (1342,'Untersuchung',55.3),(2345,'Visite',20.76),(4781,'Injektion',18.7),(4876,'Verband',16.34),(8906,'MRT',700);
/*!40000 ALTER TABLE `MedLeistung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pat_MedLeistung`
--

DROP TABLE IF EXISTS `Pat_MedLeistung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Pat_MedLeistung` (
  `PatientNr` int NOT NULL,
  `LeistungsDat` datetime NOT NULL,
  `MLeistungsNR` int NOT NULL,
  `ArztNr` int DEFAULT NULL,
  PRIMARY KEY (`PatientNr`,`LeistungsDat`,`MLeistungsNR`),
  KEY `idArzt_idx` (`ArztNr`),
  KEY `idLeistung_idx` (`MLeistungsNR`),
  KEY `idPatient_idx` (`PatientNr`),
  CONSTRAINT `idArzt` FOREIGN KEY (`ArztNr`) REFERENCES `Arzt` (`ArztNr`),
  CONSTRAINT `idLeistung` FOREIGN KEY (`MLeistungsNR`) REFERENCES `MedLeistung` (`MLeistungNr`),
  CONSTRAINT `idPatient` FOREIGN KEY (`PatientNr`) REFERENCES `Patient` (`PatientenNr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pat_MedLeistung`
--

LOCK TABLES `Pat_MedLeistung` WRITE;
/*!40000 ALTER TABLE `Pat_MedLeistung` DISABLE KEYS */;
INSERT INTO `Pat_MedLeistung` VALUES (54671,'2020-04-19 00:00:00',2345,16),(54671,'2020-04-19 00:00:00',8906,16),(51987,'2020-04-20 00:00:00',4876,23),(57890,'2020-04-19 00:00:00',4876,25),(57890,'2020-04-19 00:00:00',8906,25),(57890,'2020-04-19 00:00:00',1342,34),(59429,'2020-04-21 00:00:00',2345,34),(59429,'2020-04-21 00:00:00',4781,34),(59429,'2020-04-21 00:00:00',8906,34);
/*!40000 ALTER TABLE `Pat_MedLeistung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pat_ZusatzLeistung`
--

DROP TABLE IF EXISTS `Pat_ZusatzLeistung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Pat_ZusatzLeistung` (
  `PatientenNr` int NOT NULL,
  `ZLeistungNr` varchar(45) NOT NULL,
  `VonDatum` datetime NOT NULL,
  `BisDatum` datetime DEFAULT NULL,
  PRIMARY KEY (`PatientenNr`,`ZLeistungNr`,`VonDatum`),
  KEY `idZusatzleistung_idx` (`ZLeistungNr`),
  KEY `idPatient_idx` (`PatientenNr`),
  CONSTRAINT `idZusatzleistung` FOREIGN KEY (`ZLeistungNr`) REFERENCES `Zusatzleistung` (`ZLeistungNr`),
  CONSTRAINT `patientid` FOREIGN KEY (`PatientenNr`) REFERENCES `Patient` (`PatientenNr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pat_ZusatzLeistung`
--

LOCK TABLES `Pat_ZusatzLeistung` WRITE;
/*!40000 ALTER TABLE `Pat_ZusatzLeistung` DISABLE KEYS */;
INSERT INTO `Pat_ZusatzLeistung` VALUES (54671,'Z01','2020-04-18 00:00:00','2020-04-23 00:00:00'),(54671,'Z03','2020-04-18 00:00:00','2020-04-23 00:00:00'),(54671,'Z04','2020-04-18 00:00:00','2020-04-23 00:00:00'),(57890,'Z01','2020-04-19 00:00:00','2020-04-24 00:00:00'),(57890,'Z02','2020-04-20 00:00:00','2020-04-24 00:00:00'),(57890,'Z03','2020-04-19 00:00:00','2020-04-24 00:00:00'),(57890,'Z04','2020-04-19 00:00:00','2020-04-24 00:00:00');
/*!40000 ALTER TABLE `Pat_ZusatzLeistung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Patient`
--

DROP TABLE IF EXISTS `Patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Patient` (
  `PatientenNr` int NOT NULL,
  `PatientName` varchar(45) DEFAULT NULL,
  `PatientVorname` varchar(45) DEFAULT NULL,
  `PatientStrNr` varchar(45) DEFAULT NULL,
  `PatientPLZ` decimal(10,0) DEFAULT NULL,
  `PatientOrt` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PatientenNr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Patient`
--

LOCK TABLES `Patient` WRITE;
/*!40000 ALTER TABLE `Patient` DISABLE KEYS */;
INSERT INTO `Patient` VALUES (51987,'Sommer','Heinz','Bachstraße 67',95666,'Mitterteich'),(54671,'Kunz','Berta','Teichstraße 89',95478,'Kemnath'),(57890,'Joseph','Mayer','Pestalozzistraße 156',95676,'Wiesau'),(59429,'Winter','Pia','Weiherstraße 78',95643,'Tirschenreuth');
/*!40000 ALTER TABLE `Patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Zusatzleistung`
--

DROP TABLE IF EXISTS `Zusatzleistung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Zusatzleistung` (
  `ZLeistungNr` varchar(46) NOT NULL,
  `Bezeichnung` varchar(45) DEFAULT NULL,
  `TagesPreis` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ZLeistungNr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Zusatzleistung`
--

LOCK TABLES `Zusatzleistung` WRITE;
/*!40000 ALTER TABLE `Zusatzleistung` DISABLE KEYS */;
INSERT INTO `Zusatzleistung` VALUES ('Z01','Einzelzimmer','120.0'),('Z02','Wunschessen','22.0'),('Z03','Fernseher','8.0'),('Z04','WLAN','1.50');
/*!40000 ALTER TABLE `Zusatzleistung` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-06  9:43:06
