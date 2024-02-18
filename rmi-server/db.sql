-- --------------------------------------------------------
-- Hôte :                        localhost
-- Version du serveur:           10.6.3-MariaDB-log - mariadb.org binary distribution
-- SE du serveur:                Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Listage de la structure de la base pour e_bank
CREATE DATABASE IF NOT EXISTS `e_bank` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `e_bank`;

-- Listage de la structure de la table e_bank. accounts
CREATE TABLE IF NOT EXISTS `accounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `solde` double DEFAULT NULL,
  `cin` varchar(10) DEFAULT NULL,
  `f_name` varchar(50) DEFAULT NULL,
  `l_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Listage des données de la table e_bank.accounts : ~0 rows (environ)
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` (`id`, `solde`, `cin`, `f_name`, `l_name`) VALUES
	(1, 14415, 'd55', 'ayoub', 'el maalmi'),
	(2, 15, 'd78', 'omar', 'tr');
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;

-- Listage de la structure de la table e_bank. statments
CREATE TABLE IF NOT EXISTS `statments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `solde` double DEFAULT NULL,
  `operation_date` date DEFAULT NULL,
  `operation_type` varchar(50) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `account_id` (`account_id`),
  CONSTRAINT `statments_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Listage des données de la table e_bank.statments : ~0 rows (environ)
/*!40000 ALTER TABLE `statments` DISABLE KEYS */;
INSERT INTO `statments` (`id`, `solde`, `operation_date`, `operation_type`, `account_id`) VALUES
	(1, 150, '2023-02-07', 'withdraw', 1),
	(9, 150, '2023-02-07', 'transfer', 2),
	(10, 150, '2023-02-07', 'transfer', 2),
	(11, 150, '2023-02-07', 'transfer', 1),
	(12, 15000, '2023-02-07', 'deposit', 1);
/*!40000 ALTER TABLE `statments` ENABLE KEYS */;

-- Listage de la structure de la table e_bank. users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Listage des données de la table e_bank.users : ~0 rows (environ)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `email`, `password`) VALUES
	(1, 'admin@account.com', '123456789');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
