-- MySQL dump 10.13  Distrib 5.7.9, for Win32 (AMD64)
--
-- Host: localhost    Database: bank
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `surname` varchar(20) DEFAULT NULL,
  `userRole_idRoleUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_login_uindex` (`login`),
  KEY `FKornjrxhaf4lca2hhfgrap3jy3` (`userRole_idRoleUser`),
  CONSTRAINT `FKornjrxhaf4lca2hhfgrap3jy3` FOREIGN KEY (`userRole_idRoleUser`) REFERENCES `user_role` (`idRoleUser`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'a','Rob','a','Perry',1),(2,'b','b','b','b',1),(3,'v','v','v','v',1),(4,'Administrator','Nikolay','pass','Snegurskiy',2),(6,'f','ff','f','f',1),(7,'d','d','d','d',1),(8,'g','g','g','g',1),(9,'H','H','H','hH',1),(11,'S','S','S','S',1),(13,'e','e','e','e',1),(14,'q','kuk','q','nikolay',1),(19,'qq','qq','qq','qq',1),(21,'gg','gg','gg','gg',1),(22,'AAA','A','A','A',1),(23,'pppppp','a','a','a',1),(24,'asdf','a','a','a',1),(25,'asdff','a','a','a',1),(26,'ssssssssss','s','s','s',1),(27,'dddd','d','d','dd',1),(28,'ddddd','d','d','d',1),(29,'gggggggggggg','g','g','g',1),(30,'FF','F','F','fF',1),(31,'ffffff','f','f','f',1),(88,'fffffffff','f','f','f',1),(93,'aa','a','a','a',1),(95,'ss','s','s','s',1),(98,'sss','s','s','s',1),(99,'ssss','s','s','s',1),(105,'asd','f','asd','f',1),(106,'aaaa','a','a','a',1),(107,'aaaaaa','a','a','a',1),(108,'niksneg','nik','xyz','Sneg',1),(109,'dd','d','d','d',1),(110,'sssss','s','s','s',1),(111,'aaaaaaaa','a','a','a',1);
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

-- Dump completed on 2017-04-18  9:37:44
