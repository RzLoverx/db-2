-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 01, 2020 at 01:37 AM
-- Server version: 5.7.26
-- PHP Version: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `training`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `Name` varchar(100) NOT NULL,
  `NIC` varchar(20) NOT NULL,
  PRIMARY KEY (`NIC`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Name`, `NIC`) VALUES
('dinesh', '962473375v'),
('dewmi', '992473375v');

-- --------------------------------------------------------

--
-- Table structure for table `trial`
--

DROP TABLE IF EXISTS `trial`;
CREATE TABLE IF NOT EXISTS `trial` (
  `CNIC` varchar(20) NOT NULL,
  `Date` date NOT NULL,
  `LoanAmount` double NOT NULL,
  `NoOfPeiriods` int(11) NOT NULL,
  `IR` double NOT NULL,
  `Rental` double NOT NULL,
  `TrialID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`TrialID`),
  KEY `CNIC` (`CNIC`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trial`
--

INSERT INTO `trial` (`CNIC`, `Date`, `LoanAmount`, `NoOfPeiriods`, `IR`, `Rental`, `TrialID`) VALUES
('992473375v', '2020-10-22', 100000, 12, 8.5, 8721.98, 1),
('962473375v', '2020-10-23', 400000, 12, 8.5, 34887.92, 2),
('962473375v', '2020-10-23', 300000, 12, 12, 26654.64, 3);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
