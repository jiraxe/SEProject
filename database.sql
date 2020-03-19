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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `user_id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_c0r9atamxvbhjjvy5j8da1kam` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `block` VALUES (1,'January 2020','2020-01-25','2020-01-05'),(2,'February 2020','2020-02-25','2020-02-05'),(3,'March 2020','2020-03-25','2020-03-05'),(4,'April 2020','2020-04-25','2020-04-05'),(5,'May 2020','2020-05-25','2020-05-05');
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Enterprise Architecture',2),(2,'Software Engineering',NULL),(3,'Web Application Architecture',NULL),(4,'Modern Web Applications',NULL),(5,'Operating Systems',8),(6,'Algorithms',NULL),(7,'Big Data',6),(8,'Database Management Systems',NULL);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faculty` (
  `user_id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_eivw7fxg6ss3qdh80ew3ol3u9` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty`
--

LOCK TABLES `faculty` WRITE;
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` VALUES (2,'mnaraghi@mum.edu','Maryam','Naraghi'),(3,'oKalu@miu.eduo','Obinna','Kalu'),(4,'jbruen@miu.edu','Joe ','Bruen'),(5,'psalek@miu.edu','Payman','Salek'),(6,'klevi@miu.edu','Keith','Levi');
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;
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
INSERT INTO `hibernate_sequence` VALUES (12),(12),(12),(12);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequences`
--

DROP TABLE IF EXISTS `hibernate_sequences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) NOT NULL,
  `next_val` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sequence_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequences`
--

LOCK TABLES `hibernate_sequences` WRITE;
/*!40000 ALTER TABLE `hibernate_sequences` DISABLE KEYS */;
INSERT INTO `hibernate_sequences` VALUES ('default',6);
/*!40000 ALTER TABLE `hibernate_sequences` ENABLE KEYS */;
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
INSERT INTO `location` VALUES (1,'Verill Hall','101'),(2,'Verill hall','102'),(3,'Verill hall','103'),(4,'Verill Hall','104'),(5,'Verill Hall','105');
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
  KEY `FKrwvv5o1y3qsknxbhlnp196l6` (`faculty_user_id`),
  KEY `FKcydvhfhjjvyllkeng2q0ecf6v` (`location_location_id`),
  CONSTRAINT `FKcaob2rpl5w0q76503ake08qdn` FOREIGN KEY (`course_course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `FKcydvhfhjjvyllkeng2q0ecf6v` FOREIGN KEY (`location_location_id`) REFERENCES `location` (`location_id`),
  CONSTRAINT `FKrwvv5o1y3qsknxbhlnp196l6` FOREIGN KEY (`faculty_user_id`) REFERENCES `faculty` (`user_id`),
  CONSTRAINT `FKtre870d3wimrydxurvxuqosfg` FOREIGN KEY (`block_block_id`) REFERENCES `block` (`block_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section`
--

LOCK TABLES `section` WRITE;
/*!40000 ALTER TABLE `section` DISABLE KEYS */;
INSERT INTO `section` VALUES (6,50,1,1,5,1),(7,50,2,2,3,2),(8,50,3,3,4,2),(9,50,4,7,6,5);
/*!40000 ALTER TABLE `section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `user_id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_fe0i52si7ybu0wjedj6motiim` (`email`),
  UNIQUE KEY `UK_lh7am6sc9pv0nhyg7qkj7w5d3` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Ojablaoui@miu.edu','Oussama','Jablaoui',NULL);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_section`
--

DROP TABLE IF EXISTS `student_section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_section` (
  `students_user_id` bigint(20) NOT NULL,
  `sections_section_id` int(11) NOT NULL,
  KEY `FKo9coxhtqja2vdl7i49wgvxlmn` (`sections_section_id`),
  KEY `FKk7ibo2swvej93m8bavj6fdlmg` (`students_user_id`),
  CONSTRAINT `FKk7ibo2swvej93m8bavj6fdlmg` FOREIGN KEY (`students_user_id`) REFERENCES `student` (`user_id`),
  CONSTRAINT `FKo9coxhtqja2vdl7i49wgvxlmn` FOREIGN KEY (`sections_section_id`) REFERENCES `section` (`section_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_section`
--

LOCK TABLES `student_section` WRITE;
/*!40000 ALTER TABLE `student_section` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_section` ENABLE KEYS */;
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
  `user_id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-18 23:33:59
