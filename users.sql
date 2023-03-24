-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 09, 2022 at 06:29 AM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `signupdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `mobile` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`name`, `email`, `mobile`, `password`) VALUES
('Arafat', 'arafat2018@gmail.com', '13744805068', 'Arafat1234'),
('Arafat1', 'arafat2011@gmail.com', '13744805067', 'Arafat12345'),
('baba', 'baba12@gmail.com', '2345678901', 'baba12x'),
('maa', 'maa@gmail.com', '12345678901', 'maa123456'),
('shakila', 'shakila@gmail.vom', '12345678902', 'shakila12345'),
('shakila', 'shakila2004@gmail.com', '01747679161', 'Shakila123@'),
('kayes', 'kayes2010@gmail.com', '23456789091', 'kayes123r'),
('shazuti', 'shazuti2002@gmail.com', '0178965434', 'shazuti2914'),
('himel', 'himel2001@gmail.com', '1234567890', 'himel2001'),
('maruf', 'maruf2002@gmail.com', '0178694534', 'maruf3456'),
('Tania', 'tania1996@gmail.com', '0195647890', 'tania123456'),
('Arafat', 'arafat2001@gamail.com', '15655564781', 'Arafat2914'),
('Arafat', 'Arafat420ahut@gmail.com', '1234567894', 'Ahut2019'),
('cocolaoshi', 'cocolaoshi2019@gmail.com', '1357911131', 'cocolaoshi123456'),
('manik', 'manik2023@gmail.com', '10987654367', 'manik980'),
('Yafei', 'yafei2023@gmail.com', '24487654567', 'Yafei23Ahut');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
