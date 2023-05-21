-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: reseau
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `albums`
--

DROP TABLE IF EXISTS `albums`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `albums` (
  `idal` decimal(10,0) NOT NULL,
  `idu` decimal(10,0) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `albums`
--

LOCK TABLES `albums` WRITE;
/*!40000 ALTER TABLE `albums` DISABLE KEYS */;
/*!40000 ALTER TABLE `albums` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `amis`
--

DROP TABLE IF EXISTS `amis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `amis` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idu` decimal(10,0) DEFAULT NULL,
  `idu_amis` decimal(10,0) DEFAULT NULL,
  `dateAmitie` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amis`
--

LOCK TABLES `amis` WRITE;
/*!40000 ALTER TABLE `amis` DISABLE KEYS */;
INSERT INTO `amis` VALUES (1,17,15,'2023-05-10'),(2,18,18,'2023-05-15'),(3,17,18,'2023-05-15'),(4,15,18,'2023-05-15'),(5,18,19,'2023-05-16'),(6,18,17,'2023-05-16');
/*!40000 ALTER TABLE `amis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commentaire` (
  `idc` int NOT NULL AUTO_INCREMENT,
  `idu` decimal(10,0) DEFAULT NULL,
  `post_id` decimal(10,0) DEFAULT NULL,
  `contenu` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`idc`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commentaire`
--

LOCK TABLES `commentaire` WRITE;
/*!40000 ALTER TABLE `commentaire` DISABLE KEYS */;
INSERT INTO `commentaire` VALUES (1,17,30,'panda'),(2,18,30,'beautiful panda'),(3,18,30,'beautiful panda'),(4,18,38,'kirito');
/*!40000 ALTER TABLE `commentaire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `groupe` (
  `idg` decimal(10,0) NOT NULL,
  `idu` decimal(10,0) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idg`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupe`
--

LOCK TABLES `groupe` WRITE;
/*!40000 ALTER TABLE `groupe` DISABLE KEYS */;
/*!40000 ALTER TABLE `groupe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupeamis`
--

DROP TABLE IF EXISTS `groupeamis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `groupeamis` (
  `idg` decimal(10,0) NOT NULL,
  `idu` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`idg`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupeamis`
--

LOCK TABLES `groupeamis` WRITE;
/*!40000 ALTER TABLE `groupeamis` DISABLE KEYS */;
/*!40000 ALTER TABLE `groupeamis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `id` decimal(10,0) NOT NULL,
  `path` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `album_id` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invitation`
--

DROP TABLE IF EXISTS `invitation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invitation` (
  `idinv` decimal(10,0) NOT NULL,
  `idu` decimal(10,0) DEFAULT NULL,
  `idu_invite` decimal(10,0) DEFAULT NULL,
  `dateInvitation` date DEFAULT NULL,
  `dateAcceptation` date DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idinv`),
  CONSTRAINT `invitation_chk_1` CHECK ((`status` in (_utf8mb4'en cours',_utf8mb4'accepte',_utf8mb4'refuse')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invitation`
--

LOCK TABLES `invitation` WRITE;
/*!40000 ALTER TABLE `invitation` DISABLE KEYS */;
/*!40000 ALTER TABLE `invitation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likes`
--

DROP TABLE IF EXISTS `likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likes` (
  `idl` int NOT NULL AUTO_INCREMENT,
  `idu` decimal(10,0) DEFAULT NULL,
  `idp` decimal(10,0) DEFAULT NULL,
  `typelike` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idl`),
  CONSTRAINT `likes_chk_1` CHECK ((`typelike` in (_utf8mb4'like',_utf8mb4'deslike')))
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likes`
--

LOCK TABLES `likes` WRITE;
/*!40000 ALTER TABLE `likes` DISABLE KEYS */;
INSERT INTO `likes` VALUES (1,17,2,'like'),(2,17,2,'deslike'),(46,18,1,'like'),(47,18,1,'like'),(48,18,30,'like'),(49,18,29,'like'),(50,18,2,'like'),(51,18,1,'like'),(52,17,1,'like'),(53,17,1,'like'),(54,17,1,'like'),(55,17,1,'like'),(56,17,1,'like'),(57,17,1,'like'),(58,17,1,'like'),(59,17,1,'like'),(60,17,1,'like'),(61,18,1,'like'),(62,18,1,'like'),(63,18,1,'like'),(64,18,1,'like'),(65,18,1,'like'),(66,18,1,'like'),(67,18,1,'like'),(68,18,1,'like'),(69,18,1,'like'),(70,18,1,'like'),(71,18,1,'like'),(72,18,1,'like'),(73,18,1,'like'),(74,18,1,'like'),(75,17,30,'like'),(76,19,34,'like'),(77,18,38,'like');
/*!40000 ALTER TABLE `likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partage`
--

DROP TABLE IF EXISTS `partage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partage` (
  `idp` decimal(10,0) NOT NULL,
  `idu` decimal(10,0) DEFAULT NULL,
  `idu_partage` decimal(10,0) DEFAULT NULL,
  `post_id` decimal(10,0) DEFAULT NULL,
  `datePartage` date DEFAULT NULL,
  PRIMARY KEY (`idp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partage`
--

LOCK TABLES `partage` WRITE;
/*!40000 ALTER TABLE `partage` DISABLE KEYS */;
/*!40000 ALTER TABLE `partage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pays`
--

DROP TABLE IF EXISTS `pays`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pays` (
  `idp` decimal(8,0) NOT NULL,
  `nomp` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pays`
--

LOCK TABLES `pays` WRITE;
/*!40000 ALTER TABLE `pays` DISABLE KEYS */;
INSERT INTO `pays` VALUES (1,'MAROC'),(2,'FRANCE'),(3,'ESPAGNE');
/*!40000 ALTER TABLE `pays` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `posts` (
  `idp` int NOT NULL AUTO_INCREMENT,
  `idu` decimal(10,0) DEFAULT NULL,
  `title` varchar(150) DEFAULT NULL,
  `contenu` varchar(1000) DEFAULT NULL,
  `datePoste` date DEFAULT NULL,
  `typeposte` varchar(30) DEFAULT NULL,
  `state` decimal(10,0) DEFAULT NULL,
  `nbrlikes` decimal(8,0) DEFAULT '0',
  `nbrdeslikes` decimal(8,0) DEFAULT '0',
  PRIMARY KEY (`idp`),
  CONSTRAINT `posts_chk_1` CHECK ((`typeposte` in (_utf8mb4'message',_utf8mb4'image',_utf8mb4'video')))
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (1,15,'bon ramadan','je vous souhaite un bon ramadan','2023-05-10','message',1,0,0),(2,17,'vacances','kk.png','2023-05-10','image',1,0,0),(29,17,'test','test.jpg','2023-05-13','message',NULL,0,0),(30,17,'test','test.jpg','2023-05-13','image',NULL,0,0),(34,19,'madara','madara.png','2023-05-16','image',NULL,0,0),(35,19,'madara','madara.png','2023-05-16','image',NULL,0,0),(36,19,'madara','madara.png','2023-05-16','image',NULL,0,0),(37,19,'madara','madara.png','2023-05-16','image',NULL,0,0),(38,18,'test','ll.png','2023-05-16','image',NULL,0,0);
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utilisateur` (
  `idu` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `tel` varchar(30) DEFAULT NULL,
  `dateNaiss` date DEFAULT NULL,
  `regDate` date DEFAULT NULL,
  `profilImg` varchar(255) DEFAULT NULL,
  `banniereImg` varchar(255) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `mdp` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  `reponse` varchar(255) DEFAULT NULL,
  `idville` decimal(8,0) DEFAULT NULL,
  `etatcpt` decimal(1,0) DEFAULT '1',
  PRIMARY KEY (`idu`),
  CONSTRAINT `utilisateur_chk_1` CHECK ((`etatcpt` in (0,1)))
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateur`
--

LOCK TABLES `utilisateur` WRITE;
/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
INSERT INTO `utilisateur` VALUES (15,'Rmili','Mohamex','xyz@gmail.com','0708969971','2001-12-11','2023-05-09','1.png',NULL,NULL,'1234','user',NULL,NULL,1,1),(17,'Kafka','Tamora','AYMANELAZIZI','0708969971','2002-03-11','2023-05-09','ll.png',NULL,NULL,'111','user',NULL,NULL,2,1),(18,'snowie','ackerman','admin@gmail.com','admin','2010-06-10','2023-05-12','1.png',NULL,NULL,'geoserver','user',NULL,NULL,0,1),(19,'Madara','Uchiha','admin','555','2023-05-24','2023-05-16','madara.png','covmadara.png',NULL,'5','user',NULL,NULL,0,1);
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ville`
--

DROP TABLE IF EXISTS `ville`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ville` (
  `idv` decimal(8,0) NOT NULL,
  `nomv` varchar(30) DEFAULT NULL,
  `idp` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`idv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ville`
--

LOCK TABLES `ville` WRITE;
/*!40000 ALTER TABLE `ville` DISABLE KEYS */;
INSERT INTO `ville` VALUES (1,'Casablanca',1),(2,'Rabat',1),(3,'Paris',2),(4,'Marseille',2),(5,'Madrid',3),(6,'Barcelone',3);
/*!40000 ALTER TABLE `ville` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-16 12:50:41
