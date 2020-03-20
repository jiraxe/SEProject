-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: se
-- ------------------------------------------------------
-- Server version	5.7.23-log

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
-- Table structure for table `block`
--

DROP TABLE IF EXISTS `block`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `block` (
  `block_id` int(11) NOT NULL,
  `block_title` varchar(255) DEFAULT NULL,
  `end_date` date NOT NULL,
  `start_date` date NOT NULL,
  PRIMARY KEY (`block_id`),
  UNIQUE KEY `UK_1hlc3twffcf8hwa40p8aat08u` (`end_date`),
  UNIQUE KEY `UK_rhy6fdo3dkulbmmitltstp23m` (`start_date`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `block`
--

LOCK TABLES `block` WRITE;
/*!40000 ALTER TABLE `block` DISABLE KEYS */;
INSERT INTO `block` VALUES (1,'March 2020','2020-03-31','2020-03-01'),(2,'April 2020','2020-04-30','2020-04-01'),(3,'May 2020','2020-05-31','2020-05-01'),(4,'June 2020','2020-06-30','2020-06-01'),(5,'July 2020','2020-07-31','2020-07-01');
/*!40000 ALTER TABLE `block` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_title` varchar(255) DEFAULT NULL,
  `prerequisite_course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `FK4kihdg8vnj8lvgrkwra63tsuw` (`prerequisite_course_id`),
  CONSTRAINT `FK4kihdg8vnj8lvgrkwra63tsuw` FOREIGN KEY (`prerequisite_course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Enterprise Architecture',2),(2,'Software Engineering',NULL),(3,'Web Application Architecture',NULL),(4,'Modern Web Applications',7),(5,'Algorithms',NULL),(6,'Operating Systems',NULL),(7,'web programming',NULL);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (19),(19),(19),(19);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `location_id` int(11) NOT NULL AUTO_INCREMENT,
  `building` varchar(255) NOT NULL,
  `room_number` varchar(255) NOT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'Verill Hall','104'),(2,'Verill Hall','102'),(3,'macklavin  building','101'),(4,'Verill Hall building','105'),(5,'dalby Hall','106');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule` (
  `schedule_id` bigint(20) NOT NULL,
  PRIMARY KEY (`schedule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule_section`
--

DROP TABLE IF EXISTS `schedule_section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule_section` (
  `schedule_schedule_id` bigint(20) NOT NULL,
  `sections_section_id` int(11) NOT NULL,
  UNIQUE KEY `UK_1lkb5xeg5jfrmo03nokvmghbu` (`sections_section_id`),
  KEY `FKgvfwfa9n1bfdm21roiq3bewm7` (`schedule_schedule_id`),
  CONSTRAINT `FKgvfwfa9n1bfdm21roiq3bewm7` FOREIGN KEY (`schedule_schedule_id`) REFERENCES `schedule` (`schedule_id`),
  CONSTRAINT `FKiyymw6njpob7sgufatptxmn7n` FOREIGN KEY (`sections_section_id`) REFERENCES `section` (`section_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_section`
--

LOCK TABLES `schedule_section` WRITE;
/*!40000 ALTER TABLE `schedule_section` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule_section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `section`
--

DROP TABLE IF EXISTS `section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `section` (
  `section_id` int(11) NOT NULL,
  `capacity` int(11) DEFAULT NULL,
  `block_block_id` int(11) DEFAULT NULL,
  `course_course_id` int(11) DEFAULT NULL,
  `faculty_user_id` bigint(20) DEFAULT NULL,
  `location_location_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`section_id`),
  KEY `FKtre870d3wimrydxurvxuqosfg` (`block_block_id`),
  KEY `FKcaob2rpl5w0q76503ake08qdn` (`course_course_id`),
  KEY `FKcegtikw85yej0ndkpu2ldh6mv` (`faculty_user_id`),
  KEY `FKcydvhfhjjvyllkeng2q0ecf6v` (`location_location_id`),
  CONSTRAINT `FKcaob2rpl5w0q76503ake08qdn` FOREIGN KEY (`course_course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `FKcegtikw85yej0ndkpu2ldh6mv` FOREIGN KEY (`faculty_user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKcydvhfhjjvyllkeng2q0ecf6v` FOREIGN KEY (`location_location_id`) REFERENCES `location` (`location_id`),
  CONSTRAINT `FKtre870d3wimrydxurvxuqosfg` FOREIGN KEY (`block_block_id`) REFERENCES `block` (`block_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section`
--

LOCK TABLES `section` WRITE;
/*!40000 ALTER TABLE `section` DISABLE KEYS */;
INSERT INTO `section` VALUES (6,50,1,2,10,1),(7,49,2,5,12,3),(8,50,3,6,14,2),(9,49,4,4,13,4),(10,50,5,6,12,2),(11,50,1,1,11,2),(12,49,3,2,12,2),(13,49,1,7,13,4),(14,50,1,4,11,5),(15,50,2,3,10,4),(16,50,1,5,14,5),(17,50,2,6,12,1),(18,50,3,7,10,1);
/*!40000 ALTER TABLE `section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transcript`
--

DROP TABLE IF EXISTS `transcript`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transcript` (
  `transcript_id` bigint(20) NOT NULL,
  PRIMARY KEY (`transcript_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transcript`
--

LOCK TABLES `transcript` WRITE;
/*!40000 ALTER TABLE `transcript` DISABLE KEYS */;
/*!40000 ALTER TABLE `transcript` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transcript_grade_for_section`
--

DROP TABLE IF EXISTS `transcript_grade_for_section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transcript_grade_for_section` (
  `transcript_transcript_id` bigint(20) NOT NULL,
  `grade_for_section` varchar(255) DEFAULT NULL,
  KEY `FKop0xqesd042fwvmbna8ig9j0p` (`transcript_transcript_id`),
  CONSTRAINT `FKop0xqesd042fwvmbna8ig9j0p` FOREIGN KEY (`transcript_transcript_id`) REFERENCES `transcript` (`transcript_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transcript_grade_for_section`
--

LOCK TABLES `transcript_grade_for_section` WRITE;
/*!40000 ALTER TABLE `transcript_grade_for_section` DISABLE KEYS */;
/*!40000 ALTER TABLE `transcript_grade_for_section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transcript_section`
--

DROP TABLE IF EXISTS `transcript_section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transcript_section` (
  `transcript_transcript_id` bigint(20) NOT NULL,
  `sections_section_id` int(11) NOT NULL,
  UNIQUE KEY `UK_qtdttyrga76se1n07d40jdxli` (`sections_section_id`),
  KEY `FKckx77e7pp9oployc88brq2arf` (`transcript_transcript_id`),
  CONSTRAINT `FKckx77e7pp9oployc88brq2arf` FOREIGN KEY (`transcript_transcript_id`) REFERENCES `transcript` (`transcript_id`),
  CONSTRAINT `FKgxjgtv5en8qcet5i8vcpmayvo` FOREIGN KEY (`sections_section_id`) REFERENCES `section` (`section_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transcript_section`
--

LOCK TABLES `transcript_section` WRITE;
/*!40000 ALTER TABLE `transcript_section` DISABLE KEYS */;
/*!40000 ALTER TABLE `transcript_section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `dtype` varchar(31) NOT NULL,
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_i1pkkkteed13wt581o8vanlx8` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('Admin',1,'oussamajablaoui@gmail.com','Oussama','Jablaoui','$2a$10$v/lnBWWagTKfdCJ.faLpI.upnKRJRpwjpLzEPf1ZYLdRiILntaYCO','admin',NULL),('Student',2,'asobhi@miu.edu','Abanoub','Kaiser','$2a$10$Gszf9C.dowVMsHyAntuv9eMwPBdXwl/bLvVC42xn4.F7rmI44cJRO','abanoub',NULL),('Student',4,'oussamajablaoui@mum.edu','oussama','jablaoui','$2a$10$ckQ3vAuKRPW.rZUMiNJ82Ox2j8Nuv1GXD5Xnp46X/3P4xz7UklWaC','jiraxe',NULL),('Faculty',10,'OKalu@miu.edu','Obinna','Kalu','$2a$10$q.lkyc8KobD40K4UwVVMQOMGarBtTUsCDYs5Cxc6J91bFSXvpZoJS','Kalu',NULL),('Faculty',11,'a.saad@miu.edu','Amine','Saad','$2a$10$mVeTzdKkE./BlemfT2lokuL87NMqodrdqHt4cd8dXVmM/qtv2AYRC','Saad',NULL),('Faculty',12,'ruby@gmail.com','Keith','Ruby','$2a$10$PxYuzciwDCXrTeoW.brA9.h8sUmiH9/hNSKqQrF6B5oNbbUF1.1Ra','ruby',NULL),('Faculty',13,'a.saad2@miu.edu','Asaad','Saad','$2a$10$qLlEYold2kmn4iAh1LAcpeG7//Kf2jbzaMgZaIxGS5CNMZ1VYJzz6','Assad',NULL),('Faculty',14,'oliver@gmail.com','oliver','bob','$2a$10$/CQfAf0zKwVhxrUH.KSrCuklOhlb0f7pkX0ao2oPGc8k3QpDSLRyC','oliver',NULL),('Student',15,'mark@mum.edu','mark','Ghatas','$2a$10$y5F1PKkF3vIxVYB7r8ewxuw324ScWY89NLF7BIHIWgkW0aK3r7Z8S','mark',NULL),('Student',16,'adhamMohamed@miu.edu','Adham','ahmed','$2a$10$k/kPX5gAL2U2MwDj867Vy.jOUBgDHQRyFcU5wwEiTXCvn8YGSf.9u','adham',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_section`
--

DROP TABLE IF EXISTS `user_section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_section` (
  `students_user_id` bigint(20) NOT NULL,
  `sections_section_id` int(11) NOT NULL,
  KEY `FKgqypo6c13wpelua9badx1pqy9` (`sections_section_id`),
  KEY `FKfu5o8om7cw6abrjxte2qc1pll` (`students_user_id`),
  CONSTRAINT `FKfu5o8om7cw6abrjxte2qc1pll` FOREIGN KEY (`students_user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKgqypo6c13wpelua9badx1pqy9` FOREIGN KEY (`sections_section_id`) REFERENCES `section` (`section_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_section`
--

LOCK TABLES `user_section` WRITE;
/*!40000 ALTER TABLE `user_section` DISABLE KEYS */;
INSERT INTO `user_section` VALUES (15,13),(15,7),(15,12),(15,9),(15,10);
/*!40000 ALTER TABLE `user_section` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-19 20:54:01
