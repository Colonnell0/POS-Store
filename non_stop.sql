-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 20, 2017 at 04:57 AM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `non_stop`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `account_id` int(11) NOT NULL,
  `account_type_id` int(11) NOT NULL,
  `branch_id` int(11) NOT NULL,
  `account_username` varchar(12) DEFAULT NULL,
  `account_password` varchar(32) DEFAULT NULL,
  `account_firstname` varchar(30) DEFAULT NULL,
  `account_middle_initial` char(1) DEFAULT NULL,
  `account_lastname` varchar(30) DEFAULT NULL,
  `account_gender` varchar(6) DEFAULT NULL,
  `account_street` varchar(100) DEFAULT NULL,
  `account_barangay` varchar(100) NOT NULL,
  `account_city_municipality` varchar(100) NOT NULL,
  `account_province` varchar(100) NOT NULL,
  `account_contact` varchar(100) NOT NULL,
  `account_date` date DEFAULT NULL,
  `account_status` varchar(10) NOT NULL,
  `login_status` varchar(20) NOT NULL,
  `account_pic_filename` text NOT NULL,
  `account_key` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`account_id`, `account_type_id`, `branch_id`, `account_username`, `account_password`, `account_firstname`, `account_middle_initial`, `account_lastname`, `account_gender`, `account_street`, `account_barangay`, `account_city_municipality`, `account_province`, `account_contact`, `account_date`, `account_status`, `login_status`, `account_pic_filename`, `account_key`) VALUES
(1, 3, 1, 'admin', 'jgWMoCEUf2cMW/F6k5ka4g==', 'Administrator', '', '    ', 'Male', NULL, '', '', '', '', NULL, 'Enable', 'Available', '1null', 'FMbJpSusGJYCxydXRezxjQ== - v99xUxa77O - fZqnJ7sWV0 - X98RXrsDTZ - oIftz76VYT - 7ZBt80ioNO - BjQzR5DTnA'),
(3, 2, 1, 'llLeerekazll', 'lCCbVoUBO6OkHRMsVxLZMQ==', 'Sample', '', 'sample', 'Female', 'Zapoter', 'Balugo', 'Dumaguete †', 'Negros Oriental', '0999999999', '2017-04-27', 'Delete', 'N/A', '3null', 'FMbJpSusGJYCxydXRezxjQ== - v99xUxa77O - fZqnJ7sWV0 - X98RXrsDTZ - oIftz76VYT - 7ZBt80ioNO - BjQzR5DTnA'),
(4, 2, 1, 'testtest', '5FHHznZ2epFJ9zgL2ZuKbA==', 'Test', '', 'test', 'Female', 'Test', 'Bagacay', 'Dumaguete †', 'Negros Oriental', '099999999', '2017-04-27', 'Delete', 'N/A', '4null', 'FMbJpSusGJYCxydXRezxjQ== - v99xUxa77O - fZqnJ7sWV0 - X98RXrsDTZ - oIftz76VYT - 7ZBt80ioNO - BjQzR5DTnA'),
(5, 2, 1, 'aaaaaaa', 'QkHvajMZREDUEDhX19yTQg==', 'Aaaa', '', 'aaaa', 'Male', 'Aaaaa', 'Bagacay', 'Dumaguete †', 'Negros Oriental', '0999999999', '2017-04-27', 'Delete', 'N/A', '5null', 'FMbJpSusGJYCxydXRezxjQ== - v99xUxa77O - fZqnJ7sWV0 - X98RXrsDTZ - oIftz76VYT - 7ZBt80ioNO - BjQzR5DTnA'),
(6, 2, 1, '123123123', 'RCFbTivULJWzQopRHENCtQ==', 'S2123123', '1', '123123', 'Male', '`313123123', '123123123', '123123', '123123123', '123123123123', '2017-04-27', 'Delete', 'N/A', '6null', 'FMbJpSusGJYCxydXRezxjQ== - v99xUxa77O - fZqnJ7sWV0 - X98RXrsDTZ - oIftz76VYT - 7ZBt80ioNO - BjQzR5DTnA'),
(31, 3, 1, 'owner', 'DXpT+fZ6G7Ji+herIUbimg==', 'Bethany', '', 'Navarro', 'Female', '97 san jose extension', 'Taclobo', 'Dumaguete †', 'Negros Oriental', '0999999999', '2017-04-26', 'Enable', 'Available', '2null', 'FMbJpSusGJYCxydXRezxjQ== - v99xUxa77O - fZqnJ7sWV0 - X98RXrsDTZ - oIftz76VYT - 7ZBt80ioNO - BjQzR5DTnA'),
(32, 2, 1, 'stopnshop', 'XDXM/SPAD/0M5FWdCyAglQ==', 'Jeneva', 'T', 'Reveligia', 'Female', '97 San Jose Ext.', 'Taclobo', 'Dumaguete †', 'Negros Oriental', '09978541566', '2017-04-27', 'Enable', 'Available', '32null', 'FMbJpSusGJYCxydXRezxjQ== - v99xUxa77O - fZqnJ7sWV0 - X98RXrsDTZ - oIftz76VYT - 7ZBt80ioNO - BjQzR5DTnA'),
(33, 5, 1, 'production', 'BnJJXLCdOeDWU3wQ/jwdCQ==', 'Rashel ', 'T', 'Biorco', 'Female', '97 San Jose Ext.', 'Taclobo', 'Dumaguete †', 'Negros Oriental', '09956923053', '2017-04-27', 'Enable', 'Available', '33null', 'FMbJpSusGJYCxydXRezxjQ== - v99xUxa77O - fZqnJ7sWV0 - X98RXrsDTZ - oIftz76VYT - 7ZBt80ioNO - BjQzR5DTnA');

-- --------------------------------------------------------

--
-- Table structure for table `account_logs`
--

CREATE TABLE `account_logs` (
  `account_logs_id` int(11) NOT NULL,
  `account_id` int(11) DEFAULT NULL,
  `ipaddress` varchar(50) NOT NULL,
  `date_login` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account_logs`
--

INSERT INTO `account_logs` (`account_logs_id`, `account_id`, `ipaddress`, `date_login`) VALUES
(1, 1, 'Colonnello-PC/192.168.0.21', '2017-05-18 23:13:33'),
(2, 1, 'Colonnello-PC/192.168.0.21', '2017-05-18 23:19:31'),
(3, 1, 'Colonnello-PC/192.168.0.21', '2017-05-18 23:22:15'),
(4, 1, 'Colonnello-PC/192.168.0.21', '2017-05-18 23:24:46'),
(5, 1, 'Colonnello-PC/192.168.0.21', '2017-05-19 19:49:16'),
(6, 1, 'Colonnello-PC/192.168.0.21', '2017-05-19 19:52:51');

-- --------------------------------------------------------

--
-- Table structure for table `account_types`
--

CREATE TABLE `account_types` (
  `account_type_id` int(11) NOT NULL,
  `account_type_name` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account_types`
--

INSERT INTO `account_types` (`account_type_id`, `account_type_name`) VALUES
(1, 'Admin'),
(2, 'Cashier'),
(3, 'Owner'),
(4, 'Delivery'),
(5, 'Production');

-- --------------------------------------------------------

--
-- Table structure for table `barangay`
--

CREATE TABLE `barangay` (
  `barangay_id` int(11) NOT NULL,
  `barangay` varchar(100) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barangay`
--

INSERT INTO `barangay` (`barangay_id`, `barangay`, `city_id`) VALUES
(1, 'Balugo', 10),
(2, 'Banilad', 10),
(3, 'Batinguel', 10),
(4, 'Buñao', 10),
(5, 'Cadawinonan', 10),
(6, 'Calindagan', 10),
(7, 'Camanjac', 10),
(8, 'Candau-ay', 10),
(9, 'Cantil-e', 10),
(10, 'Daro', 10),
(11, 'Junob', 10),
(12, 'Looc', 10),
(13, 'Mangnao Canal', 10),
(14, 'Motong', 10),
(15, 'Piapi', 10),
(16, 'Poblacion No. 1(Tinago)', 10),
(17, 'Poblacion No. 2(Upper Luke Wright)', 10),
(18, 'Poblacion No. 3(Colon Ext.)', 10),
(19, 'Poblacion No. 4(Rizal Boulevard)', 10),
(20, 'Poblacion No. 5(Silliman Area)', 10),
(21, 'Poblacion No. 6(Cambagroy)', 10),
(22, 'Poblacion No. 7(Manggay)', 10),
(23, 'Poblacion No. 8(Cervantes Street)', 10),
(24, 'Pulantubig', 10),
(25, 'Tabuc Tubig', 10),
(26, 'Taclobo', 10),
(27, 'Talay', 10),
(28, 'Bagacay', 10),
(29, 'Bajumpandan', 10),
(30, 'Bantayan', 10),
(38, 'Basac', 25),
(39, 'Calango', 25),
(40, 'Lotuban', 25),
(41, 'Malongcay Diot', 25),
(42, 'Maluay', 25),
(43, 'Mayabon', 25),
(44, 'Nabago', 25),
(45, 'Nasig-id', 25),
(46, 'Najandig', 25),
(47, 'Poblacion', 25),
(48, 'Anahawan', 9),
(49, 'Bagacay', 9),
(50, 'Baslay', 9),
(51, 'Batuhon Dacu', 9),
(52, 'Boloc-Boloc', 9),
(53, 'Bulak', 9),
(54, 'Bungay', 9),
(55, 'Casile', 9),
(56, 'Libjo', 9),
(57, 'Lipayo', 9),
(58, 'Maayongtubig', 9),
(59, 'Mag-aso', 9),
(60, 'Magsaysay', 9),
(61, 'Malongcay Dacu', 9),
(62, 'Masaplod Norte', 9),
(63, 'Masaplod Sur', 9),
(64, 'Pahubtuban', 9),
(65, 'Poblacion I', 9),
(66, 'Poblacion II', 9),
(67, 'Poblacion III', 9),
(68, 'Tugawe', 9),
(69, 'Tunga-tunga', 9),
(70, 'Apo Island', 9),
(71, 'Apolong', 23),
(72, 'East Balabag', 23),
(73, 'West Balabag', 23),
(74, 'Balayagmanok', 23),
(75, 'Balili', 23),
(76, 'Balugo', 23),
(77, 'Bongbong', 23),
(78, 'Bong - ao', NULL),
(79, 'Calayugan', 23),
(80, 'Cambucad', 23),
(81, 'Dobdob', 23),
(82, 'Jawa', 23),
(83, 'Caidiocan', 23),
(84, 'Liptong', 23),
(85, 'Lunga', 23),
(86, 'Malabo', 23),
(87, 'Malaunay', 23),
(88, 'Mampas', 23),
(89, 'Palinpinon', 23),
(90, 'North Poblacion', 23),
(91, 'South Poblacion', 23),
(92, 'Puhagan', 23),
(93, 'Pulangbato', 23),
(94, 'Sagbang', 23),
(95, 'Agan-an', 20),
(96, 'Ajong', 20),
(97, 'Balugo', 20),
(98, 'Boloc-boloc', 20),
(99, 'Calabnugan', 20),
(100, 'Cangmating', 20),
(101, 'Enrique Villanueva', 20),
(102, 'Looc', 20),
(103, 'Magatas', 20),
(104, 'Maningcao', 20),
(105, 'Maslog', 20),
(106, 'Poblacion', 20),
(107, 'San Antonio', 20),
(108, 'Tubigon', 20),
(109, 'Tubtubon', 20);

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE `branch` (
  `branch_id` int(11) NOT NULL,
  `branch_name` varchar(150) NOT NULL,
  `branch_address` varchar(150) NOT NULL,
  `branch_contact` varchar(100) NOT NULL,
  `branch_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`branch_id`, `branch_name`, `branch_address`, `branch_contact`, `branch_date`) VALUES
(1, 'Stop N'' Shop (Main Branch)', '97 San Jose Extension, Dumaguete City Negros Oriental\n\n', '09361276839', '2017-03-22');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`category_id`, `category_name`) VALUES
(1, 'Seasoning '),
(3, 'Clothes '),
(4, 'Softdrinks '),
(5, ' '),
(6, 'Coffee'),
(7, 'Cereal Drinks'),
(8, 'Chips'),
(9, 'Biscuits'),
(10, 'Canned Goods'),
(11, 'Candies'),
(12, 'Toiletries');

-- --------------------------------------------------------

--
-- Table structure for table `cities`
--

CREATE TABLE `cities` (
  `city_id` int(11) NOT NULL,
  `city` varchar(100) DEFAULT NULL,
  `area_code_landline` varchar(10) NOT NULL,
  `province_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cities`
--

INSERT INTO `cities` (`city_id`, `city`, `area_code_landline`, `province_id`) VALUES
(1, 'Amlan (Ayuquitan)', '', 7),
(2, 'Ayungon', '', 7),
(3, 'Bacong', '', 7),
(4, 'Bais *', '(035)', 7),
(5, 'Basay', '', 7),
(6, 'Bayawan (Tulong) *', '(035)', 7),
(7, 'Bindoy (Payabon)', '', 7),
(8, 'Canlaon *', '', 7),
(9, 'Dauin', '', 7),
(10, 'Dumaguete †', '(035)', 7),
(11, 'Guihulngan *', '', 7),
(12, 'Jimalalud', '', 7),
(13, 'La Libertad', '', 7),
(14, 'Mabinay', '', 7),
(15, 'Manjuyod', '', 7),
(16, 'Pamplona', '', 7),
(17, 'San Jose', '', 7),
(18, 'Santa Catalina', '', 7),
(19, 'Siaton', '', 7),
(20, 'Sibulan', '', 7),
(21, 'Tanjay *', '(035)', 7),
(22, 'Tayasan', '', 7),
(23, 'Valencia (Luzurriaga)', '', 7),
(24, 'Vallehermoso', '', 7),
(25, 'Zamboanguita', '', 7);

-- --------------------------------------------------------

--
-- Table structure for table `load_central`
--

CREATE TABLE `load_central` (
  `load_central_id` int(11) NOT NULL,
  `load_product_id` varchar(50) DEFAULT NULL,
  `load_product_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `load_central`
--

INSERT INTO `load_central` (`load_central_id`, `load_product_id`, `load_product_name`) VALUES
(1, '000G1', 'Globe'),
(2, '000S1', 'Smart'),
(3, '000T1', 'TM'),
(4, '000T2', 'Talk N'' Text'),
(5, '000S2', 'Sun'),
(6, '000R1', 'Red Mobile');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `product_code` varchar(100) NOT NULL,
  `branch_id` int(11) NOT NULL,
  `product_name` varchar(150) NOT NULL,
  `num_of_products` double NOT NULL,
  `order_constant` double NOT NULL,
  `category_id` int(11) NOT NULL,
  `supplier_id` int(11) NOT NULL,
  `supplier_price` float NOT NULL,
  `selling_price` float NOT NULL,
  `selling_unit_price` float NOT NULL,
  `selling_quantity` float NOT NULL,
  `product_status` varchar(10) NOT NULL,
  `date_created` date NOT NULL,
  `expiration_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `product_code`, `branch_id`, `product_name`, `num_of_products`, `order_constant`, `category_id`, `supplier_id`, `supplier_price`, `selling_price`, `selling_unit_price`, `selling_quantity`, `product_status`, `date_created`, `expiration_date`) VALUES
(1, '8996001440049', 1, 'Energen Chocolate 30g', 1, 0, 7, 6, 5.33, 6, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(2, '8996001414309', 1, 'Kopiko Blanca 30g', 1, 0, 6, 6, 5.6, 7, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(3, '8996001410226', 1, 'Kopiko Black 3in1 25g', 1, 0, 6, 6, 4.5, 6, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(4, '8886467103605', 1, 'Pringles Sour Cream & Onion 13g', 1, 0, 8, 0, 8, 10, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(5, '8851717040016', 1, 'Dutch Mill Strawberry 180ml', 1, 0, 4, 0, 16.22, 20, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(6, '8851717200007', 1, 'Dutch Mill Strawberry 90ml', 1, 0, 4, 0, 8.15, 10, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(7, '4807770100703', 1, 'Bread Stix (blue) 20g', 1, 0, 9, 0, 3.81, 5, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(8, '8886467103599', 1, 'Pringles Original 13g', 1, 0, 8, 0, 8, 10, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(9, '750515031043', 1, 'Skyflakes Condensada 30g', 1, 0, 9, 0, 4.68, 6, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(10, '4807770122255', 1, 'Nissin Wafer Choco King Size 22g', 1, 0, 9, 0, 4.31, 6, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(11, '4807770101854', 1, 'Nissin Eggnog Cookies 18g', 1, 0, 9, 0, 3.8, 5, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(12, '750515017429', 1, 'Fita Crackers 30g', 1, 0, 9, 0, 4.31, 6, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(13, '750515018402', 1, 'Skyflakes Plain 25g', 1, 0, 9, 0, 4.29, 6, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(14, '4807770122163', 1, 'Nissin Butter Coconut 25g', 1, 0, 9, 0, 4.5, 6, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(15, '4807770121197', 1, 'Nissin Stick Wafer Choco 28g', 1, 0, 9, 0, 4.57, 6, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(16, '4807770121210', 1, 'Nissin Stick Wafer Strawberry 28g', 1, 0, 9, 0, 4.57, 6, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(17, '8996001410981', 1, 'Kopiko LA Coffee 25g', 1, 0, 6, 6, 5.1, 7, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(18, '8996001440124', 1, 'Energen Vanilla 30g', 1, 0, 7, 6, 5.33, 6, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(19, '8996001410547', 1, 'Kopiko Brown 27.5g', 1, 0, 6, 6, 5.25, 7, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(20, '8851717200014', 1, 'Dutch Mill Blueberry 90ml', 1, 0, 4, 0, 8.15, 10, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(21, '4807770120206', 1, 'Nissin Wafer Choco 12g', 1, 0, 9, 0, 1.78, 3, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(22, '4807770101557', 1, 'Bingo Double Choco 28g', 1, 0, 9, 0, 4.68, 6, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(23, '4807770121708', 1, 'Nissin Waffle Deluxe 23g', 1, 0, 9, 0, 8.33, 12, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(24, '4807770120763', 1, 'Sumo Cookies+Cream 20g', 1, 0, 9, 0, 4.68, 6, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(25, '4807770101533', 1, 'Bingo Orange 28g', 1, 0, 9, 0, 4.68, 6, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(26, '4807770120435', 1, 'Voice Combo Choco 30g', 1, 0, 9, 0, 4.67, 6, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(27, '750515031067', 1, 'Skyflakes Sweet Mantikilya 30g', 1, 0, 9, 0, 4.68, 6, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(28, '4801981125180', 1, 'Minute Maid Orange 330ml', 1, 0, 4, 5, 21.58, 26, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(29, '4801981164905', 1, 'Powerade 250ml', 1, 0, 4, 5, 9, 12, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(30, '4801981105205', 1, 'Sprite 8oz', 1, 0, 4, 5, 7.8, 10, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(31, '4800602024833', 1, 'Powerade 500ml', 1, 0, 4, 5, 21, 26, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(32, '4801981106202', 1, 'Sprite 12oz', 1, 0, 4, 5, 9.76, 12, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(33, '4800443001062', 1, 'Sparkle 240ml', 1, 0, 4, 5, 6, 9, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(34, '4801981106004', 1, 'Coke 12oz', 1, 0, 4, 5, 9.76, 12, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(35, '4801981105007', 1, 'Coke 8oz', 1, 0, 4, 5, 7.8, 10, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(36, '4801981109005', 1, 'Coke Regular 1L', 1, 0, 4, 5, 22.5, 26, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(37, '4801981109203', 1, 'Sprite 1L', 1, 0, 4, 5, 22.5, 26, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(38, '4801981116171', 1, 'Royal 1.5L', 1, 0, 4, 5, 43.5, 50, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(39, '4801981116645', 1, 'Coke Zero 1.5L', 1, 0, 4, 5, 43.5, 50, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(40, '4801981117208', 1, 'Sprite 1.75L', 1, 0, 4, 5, 43.5, 50, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(41, '4801981117000', 1, 'Coke Regular 1.75L', 1, 0, 4, 5, 43.5, 50, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(42, '054028367911', 1, 'Yakult', 1, 0, 4, 7, 7.2, 10, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(43, '4801981122943', 1, 'Royal 1.75L', 1, 0, 4, 5, 43.5, 50, 0, 0, 'Enable', '2017-04-13', '0000-00-00'),
(44, '4800016110597', 1, 'Chicharron ni Mang Juan Spicy Sisig 90g', 1, 0, 8, 9, 12.75, 18, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(45, '4800016056291', 1, 'Refresh Big Sip Mango 290ml', 1, 0, 4, 9, 4.78, 7, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(46, '4800016110535', 1, 'Chicharron ni Mang Juan Sukang Paombong 26g', 1, 0, 8, 9, 4.47, 6, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(47, '4800016622588', 1, 'Pic-A BBQ Overload Snack Mix 180g', 1, 0, 8, 9, 34.66, 48, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(48, '4800016644504', 1, 'Piattos Cheese 85g', 1, 0, 8, 9, 21.51, 30, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(49, '4800016633799', 1, 'Piattos Roadhouse BBQ 85g', 1, 0, 8, 9, 21.51, 30, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(50, '4800016633621', 1, 'Piattos Nacho Pizza 40g', 1, 0, 8, 9, 9.33, 13, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(51, '4800016663802', 1, 'Nova Country Cheddar 40g', 1, 0, 8, 9, 9.33, 13, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(52, '4800016663505', 1, 'Nova Country Cheddar 78g', 1, 0, 8, 9, 21.51, 30, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(53, '4800016604225', 1, 'Nova Homestyle BBQ 40g', 1, 0, 8, 9, 9.33, 13, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(54, '4800016604232', 1, 'Nova Homestyle BBQ 78g', 1, 0, 8, 9, 21.51, 30, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(55, '4800016622526', 1, 'Potato Chips BBQ 60g', 1, 0, 8, 9, 20.69, 30, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(56, '4800016603266', 1, 'Potato Chips V-cut Cheese 60g', 1, 0, 8, 9, 20.69, 30, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(57, '4800016625534', 1, 'Potato Chips V-cut Spicy BBQ 60g', 1, 0, 8, 9, 20.69, 30, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(58, '4800016622533', 1, 'Potato Chips V-cut Soicy BBQ 25g', 1, 0, 8, 9, 9.07, 13, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(59, '4800016653094', 1, 'Mr.Chips Nacho Cheese 100g', 1, 0, 8, 9, 15.3, 21, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(60, '4800016643095', 1, 'Chippy BBQ 110g', 1, 0, 8, 9, 16, 23, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(61, '4800016641503', 1, 'Chippy Chili&Cheese 110g', 1, 0, 8, 9, 16, 23, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(62, '4800016641008', 1, 'Chippy Chili&Chesse 27g', 1, 0, 8, 9, 4.64, 7, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(63, '4800016642029', 1, 'Chippy BBQ 27g', 1, 0, 8, 9, 4.64, 7, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(64, '4800016603259', 1, 'Potato Chips V-cut Cheese 25g', 1, 0, 8, 9, 9.07, 13, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(65, '4800016661006', 1, 'Roller Coaster Cheddar Cheese 24g ', 1, 0, 8, 9, 4.64, 7, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(66, '4800016661099', 1, 'Roller Coaster Cheddar Cheese 85g', 1, 0, 8, 9, 16, 22, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(67, '4800016021497', 1, 'Great Taste White Twin Pack 50g', 1, 0, 6, 9, 7.91, 11, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(68, '4800016021282', 1, 'Blend 45 Kapeng Pinoy Pula 20g', 1, 0, 6, 9, 4.09, 6, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(69, '4800016021039', 1, 'Great Taste White 30g ', 1, 0, 6, 9, 5.1, 7, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(70, '4800010011272', 1, 'Great Taste Original 20g ', 1, 0, 6, 9, 5.1, 7, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(71, '4800016054907', 1, 'Blend 45 Original 20g', 1, 0, 6, 9, 3.46, 6, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(72, '4800016021633', 1, 'Blend 45 Kapeng Pinoy Kondensada 20g ', 1, 0, 6, 9, 4.09, 6, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(73, '4800016021251', 1, 'Blend 45 Kapeng Pinoy Puti 20g', 1, 0, 6, 9, 4.09, 6, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(74, '4800016111044', 1, 'Quake Choco Burst 38g ', 1, 0, 9, 9, 4.66, 7, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(75, '4800016111051', 1, 'Quake Vanillla Thrilla 38g', 1, 0, 9, 9, 4.66, 7, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(76, '4800016112140', 1, 'Quake Overload Mocha Butter 30g', 1, 0, 9, 9, 4.69, 7, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(77, '4800016112379', 1, 'Quake Overload Strawberry', 1, 0, 9, 9, 4.69, 7, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(78, '4800016112430', 1, 'Quake Overload Black Forest 30g', 1, 0, 9, 9, 4.69, 7, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(79, '4800016082603', 1, 'Magic Flakes 28g', 1, 0, 9, 9, 3.64, 6, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(80, '4800016082610', 1, 'Magic Creams Butter 28g ', 1, 0, 9, 9, 3.77, 6, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(81, '4800016082627', 1, 'Magic Creams Chocolate 28g', 1, 0, 9, 9, 3.77, 6, 0, 0, 'Enable', '2017-04-24', '0000-00-00'),
(82, '4800016052149', 1, 'C2 Green Tea Lemon 500ml', 1, 0, 4, 9, 19.64, 24, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(83, '4800016052057', 1, 'C2 Green Tea Lemon 355ml', 1, 0, 4, 9, 15.56, 19, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(84, '4800016052767', 1, 'C2 Green Tea Lemon 1000ml', 1, 0, 4, 9, 27.85, 34, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(85, '4800016052774', 1, 'C2 Green Tea Apple 1000ml', 1, 0, 4, 9, 27.85, 34, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(86, '4800016052040', 1, 'C2 Green Tea Apple 355ml', 1, 0, 4, 9, 15.56, 19, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(87, '4800016056277', 1, 'Refresh Big Sip Orange 290ml', 1, 0, 4, 9, 4.78, 7, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(88, '4800016056284', 1, 'Refresh Big Sip Apple 290ml', 1, 0, 4, 9, 4.78, 7, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(89, '48040600', 1, 'Refresh Apple 188ml', 1, 0, 4, 9, 4.37, 6, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(90, '4800016627262', 1, 'Choco Knots 28g', 1, 0, 9, 9, 4.64, 7, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(91, '4800016629426', 1, 'Choco Knots Blast 28g', 1, 0, 9, 9, 4.64, 7, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(92, '4800016627279', 1, 'Berry Knots 28g', 1, 0, 9, 9, 4.64, 7, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(93, '4800016627286', 1, 'Milky Knots 28g', 1, 0, 9, 9, 4.64, 7, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(94, '4800016628269', 1, 'Pretzels Chocolate 40g', 1, 0, 9, 9, 8.43, 13, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(95, '4800016084034', 1, 'Wafrets Brix Cheese 24g', 1, 0, 9, 9, 3.77, 6, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(96, '4800016077715', 1, 'Cream-O Cafe Latte 30g', 1, 0, 9, 9, 5.1, 7, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(97, '4800016628283', 1, 'Pretzels Mini Choco 28g', 1, 0, 9, 9, 4.64, 7, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(98, '4800016084195', 1, 'Wafrets Brix Choco Vanilla 24g ', 1, 0, 9, 9, 3.77, 6, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(99, '4800016078590', 1, 'Cream-O Crinkles 30g', 1, 0, 9, 9, 5.1, 7, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(100, '4800016077081', 1, 'Cream-O Chip Cookies 36g', 1, 0, 9, 9, 6.04, 7, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(101, '4800016078552', 1, 'Cream-O Deluxe 33g', 1, 0, 9, 9, 5.01, 7, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(102, '4800016113055', 1, 'Dewberry Blueberries 33g', 1, 0, 9, 9, 5.1, 7, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(103, '4800016113970', 1, 'Dewberry P&M 33g', 1, 0, 9, 9, 5.1, 7, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(104, '4800010075069', 1, 'Cream-O Vanilla 30g ', 1, 0, 9, 9, 5.1, 7, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(105, '4800016113048', 1, 'Dewberry Strawberry 33g', 1, 0, 9, 9, 5.1, 7, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(106, '4800010961447', 1, 'Cloud 9 Classic 28g', 1, 0, 11, 9, 5.26, 7, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(107, '4800016082641', 1, 'Magic Flakes Cheese 28g', 1, 0, 9, 9, 3.74, 6, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(108, '4800016082825', 1, 'Magic Flakes Chocolate 30g', 1, 0, 9, 9, 3.63, 6, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(109, '4800010075878', 1, 'Presto Creams Chocolate', 1, 0, 9, 9, 3.99, 6, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(110, '4800016076756', 1, 'Presto Creams Coffee Mocha 30g ', 1, 0, 9, 9, 3.99, 6, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(111, '4800016633614', 1, 'Piattos Nacho Pizza 85g ', 1, 0, 8, 9, 21.51, 30, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(112, '4800016115011', 1, 'Chik N Skin ni Mang Juan 17g ', 1, 0, 8, 9, 4.64, 6, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(113, '4800016087257', 1, 'Magic Creams Condensada 25g', 1, 0, 9, 9, 3.77, 6, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(114, '4800016112478', 1, 'Quake Overload Mallow Vanilla 28g', 1, 0, 9, 9, 4.69, 7, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(115, '4800016076930', 1, 'Presto Creams Double Choco 30g', 1, 0, 9, 9, 3.99, 6, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(116, '4800361015172', 1, 'Nestle Low-Fat Milk 250ml', 1, 0, 4, 10, 26.7, 36, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(117, '4800361015103', 1, 'Nestle Fresh Milk 250ml', 1, 0, 4, 10, 26.7, 36, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(118, '14800016057073', 1, 'C2 Green Tea Apple 230ml', 1, 0, 4, 9, 8.01, 11, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(119, '4800361397605', 1, 'Bear Brand 99g', 1, 0, 7, 10, 28.91, 40, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(120, '8850124006585', 1, 'Cofee-Mate 80g', 1, 0, 7, 10, 15.31, 23, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(121, '4800361015400', 1, 'Chuckie CalciN 250ml', 1, 0, 4, 10, 20.44, 28, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(122, '4800361388313', 1, 'Chuckie CalciN 180ml', 1, 0, 4, 10, 15.85, 24, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(123, '4800361339186', 1, 'Nescafe Classic 25g', 1, 0, 6, 10, 16.73, 25, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(124, '4800361396059', 1, 'Nescafe Blend&Brew Orig. 20g', 1, 0, 6, 10, 4.48, 7, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(125, '4800361396189', 1, 'Nsscafe Blend&Brew Silky Roast 20g ', 1, 0, 6, 10, 4.48, 7, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(126, '4800361395076', 1, 'Nescafe 3in1 B&C Twin Pack 40g ', 1, 0, 6, 10, 7.75, 11, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(127, '4800361391900', 1, 'Nescafe 3in1 Original Twin Pack 17g', 1, 0, 6, 10, 6.47, 10, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(128, '4800361396202', 1, 'Nescafe Blend&Brew Expresso Roast 20g', 1, 0, 6, 10, 4.48, 7, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(129, '4800361383301', 1, 'Milo Actigen-E 22g', 1, 0, 7, 10, 4.82, 7, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(130, '4800361383493', 1, 'Nescafe 3in1 CreamyLatte 27.5g', 1, 0, 6, 10, 5.02, 7, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(131, '4800361381024', 1, 'Bear Brand Swak 33g', 1, 0, 7, 10, 9.73, 14, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(132, '9556001132338', 1, 'Cerelac Rice&Soya 120g', 1, 0, 7, 10, 46.97, 63, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(133, '9556001210876', 1, 'Cerelac Rice&Soya 20g', 1, 0, 7, 10, 8.04, 11, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(134, '4800361386722', 1, 'Nesfruta Dalandan 25g', 1, 0, 4, 10, 7.58, 11, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(135, '4800361382083', 1, 'Nestea Apple Blend 25g', 1, 0, 4, 0, 7.65, 11, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(136, '4800361384650', 1, 'Nesfruta Orange 25g', 1, 0, 4, 10, 7.58, 11, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(137, '4800361387989', 1, 'Nestea Honey blend 25g', 1, 0, 4, 10, 7.65, 11, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(138, '4800361328463', 1, 'Koko Crunch 15g', 1, 0, 7, 11, 4, 6, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(139, '4800361393096', 1, 'Nescafe Creamy White 28g', 1, 0, 6, 10, 5.02, 7, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(140, '4800361394253', 1, 'Nesfruta Guyabano 25g', 1, 0, 4, 10, 7.58, 11, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(141, '4800361379557', 1, 'Nestle Lemon blend 25g', 1, 0, 4, 10, 7.65, 11, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(142, '4800361395366', 1, 'Nestea Kiwi Lemon blend 25g', 1, 0, 4, 10, 7.65, 11, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(143, '48025522', 1, 'Magic Sarap 8g', 1, 0, 1, 10, 2.28, 3, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(144, '4800361339568', 1, 'Nescafe Classic 2g', 1, 0, 6, 10, 1.69, 3, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(145, '4800361386821', 1, 'Nesfruta Melon 25g', 1, 0, 4, 10, 7.58, 11, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(146, '4800361394581', 1, 'Nescafe 3in1 Creamy White Twin Pack 50g', 1, 0, 6, 10, 7.75, 11, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(147, '8850006320518', 1, 'Colgate Great Regular Flavor 50ml', 1, 0, 12, 12, 43.12, 52, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(148, '8850006321133', 1, 'Colgate Great Regular Flavor 25ml', 1, 0, 12, 12, 22.96, 28, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(149, '8850006320501', 1, 'Colgate Great Regular Flavor 95ml', 1, 0, 12, 12, 68.32, 82, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(150, '8850006325216', 1, 'Colgate Great Regular Flavor 24g', 1, 0, 12, 12, 5.9, 8, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(151, '8850006321539', 1, 'Colgate Triple Action w/ multi-vitamins 95ml', 1, 0, 12, 12, 68.32, 82, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(152, '8850006325049', 1, 'Colgate Triple Action w/ multi-vitamins 50ml', 1, 0, 12, 12, 43.12, 52, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(153, '8850006321546', 1, 'Colgate Triple Action 25ml', 1, 0, 12, 12, 22.96, 28, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(154, '8850006322918', 1, 'Colgate Peppermint Ice 50ml', 1, 0, 12, 12, 43.12, 52, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(155, '8850006323670', 1, 'Colgate Kool Menthol Fresh 50ml', 1, 0, 12, 12, 43.12, 52, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(156, '8850006325230', 1, 'Colgate Kool Menthol Fresh 22g ', 1, 0, 12, 12, 5.9, 8, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(157, '8850006322949', 1, 'Colgate Spicy Fresh 50ml', 1, 0, 12, 12, 43.12, 52, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(158, '8850006325223', 1, 'Colgate Spicy Fresh 22g', 1, 0, 12, 12, 5.9, 8, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(159, '8850006491119', 1, 'Palmolive Shampoo Intensive Moisture Pink 13.5ml', 1, 0, 12, 12, 4.25, 6, 0, 0, 'Enable', '2017-04-26', '0000-00-00'),
(160, '8850006491102', 1, 'Palmolive Healthy & Smooth Green 13.5ml', 1, 0, 9, 3, 4.25, 6, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(161, '8850006491133', 1, 'Palmolive Brilliant Shine Platinum 13.5ml', 1, 0, 9, 3, 4.25, 6, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(162, '8850006491799', 1, 'Palmolive Conditioner Silky Straight 12ml ', 1, 0, 9, 3, 4.1, 7, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(163, '8850006481806', 1, 'Palmolive Conditioner Brilliant Shine 12ml', 1, 0, 9, 3, 4.1, 7, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(164, '8850006491812', 1, 'Palmolive Conditioner Complete Repair 12ml', 1, 0, 9, 3, 4.1, 7, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(165, '8850006491782', 1, 'Palmolive Conditioner Intensive Moisture Pink 12ml', 1, 0, 9, 3, 4.1, 7, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(166, '4808888320106', 1, 'Colgate Toothbrush Classic Deep Clean ', 1, 0, 9, 3, 10.92, 15, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(167, '4808888201115', 1, 'Colgate Toothbrush Flow Wrap', 1, 0, 9, 3, 10.92, 15, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(168, '8850006265178', 1, 'Colgate Toothbrush Twister', 1, 0, 9, 3, 43.12, 55, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(169, '8850006536056', 1, 'Gard Shampoo Pink 16ml', 1, 0, 9, 3, 4.32, 6, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(170, '8850006536063', 1, 'Gard Shampoo Green 16ml', 1, 0, 9, 3, 4.32, 6, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(171, '8850006491126', 1, 'Palmolive Silky Straight Purple 13.5ml', 1, 0, 9, 3, 4.25, 6, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(172, '8850006491157', 1, 'Palmolive Complete Repair Red 13.5ml', 1, 0, 9, 3, 4.25, 6, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(173, '8850006491140', 1, 'Palmolive Anti-Dandruff Blue 13.5ml', 1, 0, 9, 3, 4.25, 6, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(174, '4800016110511', 1, 'Chicharron ni Mang Juan Sukang Paombong 90g', 1, 0, 10, 4, 12.75, 18, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(175, '4800016110528', 1, 'Chicharron ni Mang Juan Sukat Sili 90g ', 1, 0, 10, 4, 12.75, 18, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(176, '4800016622571', 1, 'Pic-A Ultimate Cheddar 180g', 1, 0, 10, 4, 34.66, 48, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(177, '4800016633782', 1, 'Piattos Roadhouse BBQ 40g', 1, 0, 10, 4, 9.33, 13, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(178, '4800016644801', 1, 'Piattos Cheese 40g ', 1, 0, 11, 4, 9.33, 13, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(179, '4800016671807', 1, 'Piattos Sour Cream 40g', 1, 0, 11, 4, 9.33, 13, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(180, '4800016652035', 1, 'Mr. Chips Nacho Cheese 26g', 1, 0, 11, 4, 3.73, 7, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(181, '4800010076073', 1, 'Presto Creams Peanut Butter 30g', 1, 0, 12, 4, 3.99, 6, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(182, '4800016077524', 1, 'Cream-O Cookies N Cream 27g', 1, 0, 12, 4, 5.1, 7, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(183, '48039260', 1, 'Refresh Pineapple 188ml', 1, 0, 4, 4, 4.37, 6, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(184, '48040617', 1, 'Refresh Mango 188ml', 1, 0, 4, 4, 4.37, 6, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(185, '4800088230605', 1, 'Virginia Hotdog Regular 250g ', 1, 0, 13, 5, 43.5, 53, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(186, '4800088230667', 1, 'Virginia Hotdog Jumbo 240g', 1, 0, 13, 5, 43.5, 53, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(187, '4800088250269', 1, 'Champion Hotdog Jumbo 250g', 1, 0, 13, 5, 20, 25, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(188, '4800088210416', 1, 'Virginia Pork Tocino 200g', 1, 0, 13, 5, 42, 53, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(189, '4809010394774', 1, 'Fresh-O Orange 200ml', 1, 0, 4, 5, 5.4, 8, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(190, '4809010394644', 1, 'Fresh-O Pineapple 200ml', 1, 0, 4, 5, 5.4, 8, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(191, '4809010394880', 1, 'Fresh-O Apple', 1, 0, 4, 5, 5.4, 8, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(192, '4800088250290', 1, 'Champion Hotdog Mini 250g', 1, 0, 13, 5, 20, 25, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(193, '4800088230513', 1, 'Winner Hotdog Mini 250g', 1, 0, 13, 5, 24, 30, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(194, '4800088230506', 1, 'Winner Hotdog Regular 250g', 1, 0, 13, 5, 24, 30, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(195, '4800361381086', 1, 'Bearbrand Iron+Zinc+Vit.C 150g', 1, 0, 14, 6, 42.51, 57, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(196, '4806502721476', 1, 'Gardenia Chocolate Chip Loaf 400g', 1, 0, 11, 7, 56.35, 62, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(197, '4806502720417', 1, 'Gardenia Classic White Bread 400g', 1, 0, 11, 7, 41.55, 45.75, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(198, '4806502720615', 1, 'Gardenia Classic White Bread Regular Slice 600g ', 1, 0, 11, 7, 55, 60.5, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(199, '4806502721445', 1, 'Gardenia California Raisin Loaf 400g', 1, 0, 11, 7, 56.35, 62, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(200, '4806502725726', 1, 'Gardenia Soft Delight Pandesal Family Pack 300g', 1, 0, 11, 7, 32.95, 36.25, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(201, '4806502726129', 1, 'Gardenia Cheese Buns 250g', 1, 0, 10, 7, 40, 44, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(202, '4806502725269', 1, 'Gardenia Amazing Black Forest 400g', 1, 0, 11, 7, 65.45, 72, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(203, '4806502720165', 1, 'Gardenia Double Delights U&C 400g ', 1, 0, 11, 7, 56.35, 62, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(204, '4807770273612', 1, 'Lucky Me Spicy Bulalo 40g', 1, 0, 13, 8, 15.3, 20, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(205, '4807770270024', 1, 'Lucky Me Noodles Chicken 55g', 1, 0, 13, 8, 6.9, 9, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(206, '4807770270017', 1, 'Lucky Me Noodles Beef 55g', 1, 0, 13, 8, 6.9, 9, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(207, '4800110025995', 1, 'Ho-Mi Noodles Chicken 55g', 1, 0, 13, 8, 6.5, 8, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(208, '4800110026497', 1, 'Ho-Mi Noodles Beef 55g', 1, 0, 13, 8, 6.5, 8, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(209, '4807770270291', 1, 'Lucky Me Pancit Canton Chili-Mansi 60g', 1, 0, 13, 8, 8.75, 11, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(210, '4807770270123', 1, 'Lucky Me Pancit Canton Kalamansi 60g', 1, 0, 13, 8, 8.75, 11, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(211, '4807770271229', 1, 'Lucky Me Pancit Canton Extra Hot 60g', 1, 0, 13, 8, 8.75, 11, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(212, '4807770270055', 1, 'Lucky Me Pancit Canton Original 60g', 1, 0, 13, 8, 8.75, 11, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(213, '4807770272554', 1, 'Lucky Me Pancit Canton S&S 60g', 1, 0, 13, 8, 8.75, 11, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(214, '4808680651026', 1, 'Ladys Choice Tuna Spread 80ml', 1, 0, 13, 8, 27.5, 34, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(215, '4808680022017', 1, 'Ladys Choice Chicken Spread 80ml', 1, 0, 13, 8, 27.5, 34, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(216, '4808680653419', 1, 'Ladys Choice Chicken Sandwich 15ml', 1, 0, 13, 8, 6.85, 10, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(217, '4808680652887', 1, 'Ladys Choice Chicken Spread 15ml ', 1, 0, 13, 8, 6.85, 10, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(218, '4808680652894', 1, 'Ladys Choice Ham Spread 15ml ', 1, 0, 13, 8, 6.85, 10, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(219, '4808680653402', 1, 'Ladys Choice Real Mayonnaise 15ml', 1, 0, 13, 8, 6.85, 10, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(220, '4800066122519', 1, 'Holiday Carne Norte 150g', 1, 0, 13, 8, 21.85, 26, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(221, '4800066124902', 1, 'Holiday Sausage 90g', 1, 0, 13, 8, 15.25, 19, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(222, '748485700052', 1, '555 TUNA H&S 155g', 1, 0, 13, 8, 24, 29, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(223, '748485700014', 1, '555 TUNA Adobo 155g ', 1, 0, 13, 8, 21.4, 26, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(224, '748485700083', 1, '555 TUNA Flakes in Oil 155g', 1, 0, 13, 8, 24, 29, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(225, '748485801490', 1, 'Argentina Meat Loaf 150g', 1, 0, 13, 8, 15.5, 19, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(226, '748485800349', 1, 'Argentina Carne Norte 150g', 1, 0, 13, 8, 23.75, 29, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(227, '748485800431', 1, 'Argentina Corned Beef 150g', 1, 0, 13, 8, 27.7, 33, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(228, ' 748485801728', 1, 'Lucky 7 Carne Norte 150', 1, 0, 13, 8, 17, 21, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(229, '748485800738 ', 1, 'Argentina Beef Loaf 150g', 1, 0, 13, 8, 15.45, 19, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(230, '748485100432', 1, 'Century Tuna Afritada 155g', 1, 0, 13, 8, 21.4, 30, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(231, '748485900032', 1, 'Fresca Tuna Caldereta 175g', 1, 0, 13, 8, 20.35, 25, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(232, '748485900049', 1, 'Fresca Tuna Mechado 175g', 1, 0, 13, 8, 20.35, 25, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(233, '748485900056', 1, 'Fresca Tuna Afritada 175g', 1, 0, 13, 8, 20.35, 25, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(234, '748485900070', 1, 'Fresca Tuna Adobo 175g', 1, 0, 13, 8, 20.35, 25, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(235, '8851028000945', 1, 'Vita Milk Soy 300ml', 1, 0, 4, 8, 21.5, 26, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(236, '8851028000808', 1, 'Vita Milk Choco Shake 300ml ', 1, 0, 4, 8, 21.5, 26, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(237, '4800130300515', 1, 'Vino Kulafu 350ml ', 1, 0, 4, 8, 23.45, 30, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(238, '4800220503154', 1, 'Tanduay Long Neck 750ml', 1, 0, 4, 8, 80.16, 97, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(239, '4800220503253', 1, 'Tanduay Sr. 375ml', 1, 0, 4, 8, 40.41, 49, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(240, '4800220503451', 1, 'Tanduay Jr. 250ml', 1, 0, 4, 8, 29.9, 36, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(241, '4800142110102', 1, 'Emperador Light 1000ml ', 1, 0, 4, 8, 110.75, 133, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(242, '4800142110089', 1, 'Emperador Light 750ml', 1, 0, 4, 8, 81.5, 98, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(243, '4800142110072', 1, 'Emperador Light 500ml', 1, 0, 4, 8, 57.2, 69, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(244, '4807770271519', 1, 'Lucky Me Chicken Sotanghon 28g', 1, 0, 13, 8, 21.25, 26, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(245, '4807770272653', 1, 'Lucky Me Jjampong 40g', 1, 0, 13, 8, 19.5, 24, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(246, '4800163008020', 1, 'King Cup Red 155g', 1, 0, 13, 8, 12, 15, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(247, '748485200026', 1, '555 Sardines Red 155g', 1, 0, 13, 8, 13.85, 17, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(248, '748485200019', 1, '555 Sardines Green 155g', 1, 0, 13, 8, 13.6, 17, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(249, '748485100401', 1, 'Century Tuna Flakes in Oil 155g', 1, 0, 13, 8, 27.1, 33, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(250, '748485100418', 1, 'Century Tuna H&S 155g ', 1, 0, 13, 8, 27.1, 33, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(251, '4806502350300', 1, 'Jade Tissue Paper ', 1, 0, 9, 8, 6.35, 8, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(252, '4902430583169', 1, 'Ariel Powder Green 70g', 1, 0, 9, 8, 9.97, 12, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(253, '4902430583176', 1, 'Ariel Powder Violet 66g', 1, 0, 9, 8, 9.97, 12, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(254, '4902430583183', 1, 'Ariel Powder Red 66g', 1, 0, 9, 8, 9.97, 12, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(255, '4800047840029', 1, 'Zonrox orig. 500ml', 1, 0, 9, 8, 17.4, 21, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(256, '4800047840036', 1, 'Zonrox Orig. 250ml', 1, 0, 9, 8, 11, 13, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(257, '4800047840043', 1, 'Zonrox Orig. 100ml', 1, 0, 9, 8, 6.85, 8, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(258, '4800047841781', 1, 'Zonrox C&S 95ml', 1, 0, 9, 8, 10.25, 13, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(259, '4902430453295', 1, 'Downy GB 28ml', 1, 0, 9, 8, 4.53, 6, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(260, '4902430344876', 1, 'Downy Anti-bac', 1, 0, 9, 8, 4.53, 6, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(261, '4902430587914', 1, 'Tide L&K 80g', 1, 0, 9, 8, 8.16, 10, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(262, '4902430611312', 1, 'Tide Downy 74g', 1, 0, 9, 8, 8.16, 10, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(263, '4902430587907', 1, 'Tide Original 80g', 1, 0, 9, 8, 8.16, 10, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(264, '4902430258074', 1, 'Tide with Power of Safeguard 80g', 1, 0, 9, 8, 8.16, 10, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(265, '4800888151834', 1, 'Surf w/ Fabcon blue 65g', 1, 0, 9, 8, 4.41, 6, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(266, '4800888151827', 1, 'Surf Kalamansi Green', 1, 0, 9, 8, 4.41, 6, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(267, '4800888183804', 1, 'Surf Rose Fresh Pink 65g', 1, 0, 9, 8, 4.41, 6, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(268, '4800888151841', 1, 'Surf Sun Fresh 65g', 1, 0, 9, 8, 4.41, 6, 0, 0, 'Enable', '2017-05-02', '0000-00-00'),
(269, '4806502726822', 1, 'NeuBake White Bread 450g ', 1, 0, 11, 7, 32.7, 36, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(270, '4806502720080', 1, 'Gardenia Premium Pandesal 350g', 1, 0, 11, 7, 33.6, 37, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(271, '4806502726136', 1, 'Gardenia California Raisin Buns 300g', 1, 0, 11, 7, 43.6, 48, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(272, '4806502720110', 1, 'Gardenia Butter Toast 25g', 1, 0, 11, 7, 18.6, 23, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(273, '4800016677809', 1, 'Potato Chips BBQ 22g', 1, 0, 11, 4, 9.07, 13, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(274, '4800194116619', 1, 'Oishi Fish Crackers 24g', 1, 0, 11, 8, 4.45, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(275, '4891208040143', 1, 'Oishi Prawn Crackers 24g', 1, 0, 11, 8, 4.45, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(276, '4800194104869', 1, 'Oishi Crispy Patata 24g', 1, 0, 11, 8, 4.45, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(277, '4800194104968', 1, 'Oishi Prawn Spicy 24g', 1, 0, 11, 8, 4.45, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(278, '4800024570024', 1, 'F&R Four Season 330ml', 1, 0, 4, 8, 22.15, 27, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(279, '4800024570000', 1, 'F&R Apple 330ml', 1, 0, 4, 8, 22.15, 27, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(280, '4800024571908', 1, 'F&R Watermelon 330ml', 1, 0, 4, 8, 22.15, 27, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(281, '748485802138', 1, 'Wow Ulam Bicol Express 155g', 1, 0, 13, 8, 16.3, 19, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(282, '748485802091', 1, 'Wow Ulam Lechon Paksiw 155g', 1, 0, 13, 8, 16.3, 19, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(283, '4800194116466', 1, 'Pillows Yellow 38g', 1, 0, 11, 8, 6.55, 9, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(284, '4800194152327', 1, 'Pillows Violet 38g', 1, 0, 11, 8, 6.55, 9, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(285, '4800194153232', 1, 'Bread Pan Red 24g', 1, 0, 11, 8, 4.55, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(286, '748485802060', 1, 'Wow Ulam Adobo 155g', 1, 0, 13, 8, 16.3, 19, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(287, '4800888139306', 1, 'Creamsilk Pink 12ml', 1, 0, 9, 8, 5.25, 7, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(288, '4800888139276', 1, 'Creamsilk Blue 12ml', 1, 0, 9, 8, 5.25, 7, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(289, '4800888139313', 1, 'Creamsilk Violet 12ml', 1, 0, 9, 8, 5.25, 7, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(290, '4800888154262', 1, 'Dove Shampoo Blue 10ml', 1, 0, 9, 8, 4.1, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(291, '4800888180100', 1, 'Creamsilk Orange 11ml', 1, 0, 9, 8, 5.25, 7, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(292, '4800888139283', 1, 'Creamsilk Green 11ml', 1, 0, 9, 8, 5.25, 7, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(293, '4800888169716', 1, 'Sunsilk Shampoo 13ml', 1, 0, 9, 8, 4.2, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(294, '4800888169693', 1, 'Sunsilk Shampoo Orange 13ml', 1, 0, 9, 8, 4.2, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(295, '4902430522809', 1, 'H&S Anti-Dandruff Shampoo 12ml', 1, 0, 9, 8, 5.05, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(296, '4902430333597', 1, 'H&S Cool Menthol 12ml', 1, 0, 9, 8, 5.05, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(297, '4902430698078', 1, 'Rejoice Fragrant Rich  Orange 16ml', 1, 0, 9, 8, 4.53, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(298, '4902430330718', 1, 'Rejoice Anti-Dandruff Shampoo Blue 15ml', 1, 0, 9, 8, 4.53, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(299, '4902430698139', 1, 'Rejoice Anti-Frizz Shampoo Pink 16ml', 1, 0, 9, 8, 4.53, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(300, '4800888151704', 1, 'Clear Blue 12ml', 1, 0, 9, 8, 4.4, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(301, '4800888141194', 1, 'Clear Pink 12ml', 1, 0, 9, 8, 4.4, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(302, '4902430698658', 1, 'H&S Smooth&Silky Pink 12ml', 1, 0, 9, 8, 5.05, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(303, '4800888169709', 1, 'Sunsilk Green 13ml', 1, 0, 9, 8, 4.2, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(304, '4800888190185', 1, 'Dove Shampoo Skyblue 10ml', 1, 0, 9, 8, 4.1, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(305, '4800888179593', 1, 'Dove Shampoo White 10ml', 1, 0, 9, 8, 4.1, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(306, '4801668602027', 1, 'Datu Puti Vinegar 200ml', 1, 0, 1, 8, 5.45, 8, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(307, '4801668602225', 1, 'Datu Puti Vinegar 100ml', 1, 0, 1, 8, 3.3, 5, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(308, '4800344001949', 1, 'Silver Swan SS 200ml ', 1, 0, 1, 8, 7.45, 9, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(309, '4800344001963', 1, 'Silver Swan SS 100ml ', 1, 0, 1, 8, 4.05, 5, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(310, '4800344001925', 1, 'Silver Swan SS 20ml', 1, 0, 1, 8, 0.94, 1, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(311, '4800344004926', 1, 'Silver Swan Vinegar 20ml', 1, 0, 1, 8, 0.94, 1, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(312, '8850006493878', 1, 'Palmolive Soap FC Black ', 1, 0, 9, 8, 11.5, 15, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(313, '9556031084126', 1, 'Palmolive MS Green', 1, 0, 9, 8, 11.5, 15, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(314, '4902430970525', 1, 'Safeguard CM Blue 60g', 1, 0, 9, 8, 15.4, 19, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(315, '748485200675', 1, '555 Fried Sardines w/ Tausi 155g', 1, 0, 13, 8, 23.3, 28, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(316, '748485201061', 1, '555 Fried Sardines w/ Bistek 155g', 1, 0, 13, 8, 23.3, 28, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(317, '748485200989', 1, '555 Fried Sardines 155g', 1, 0, 13, 8, 23.3, 28, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(318, '4800888136701', 1, 'Surf Bar Blue', 1, 0, 9, 8, 4.62, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(319, '4902430951357', 1, 'Palmolive FP w/ Aloe Soap 60g', 1, 0, 9, 8, 15.4, 19, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(320, '4902430381772', 1, 'Safeguard IWC Violet Soap 60g', 1, 0, 9, 8, 15.4, 19, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(321, '4801668603659', 1, 'Oysterrific Sauce 30g', 1, 0, 1, 8, 4, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(322, '748485200132', 1, 'Consuelo Sardines Red 155g ', 1, 0, 13, 8, 12.5, 16, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(323, '4800047841712', 1, 'Zonrox CS 450ml', 1, 0, 9, 8, 31.5, 38, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(324, '4800047841729', 1, 'Zonrox CS 225ml', 1, 0, 9, 8, 20.5, 25, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(325, '4806506318955', 1, 'Sisters 8 pads w/o wings', 1, 0, 9, 8, 20.15, 24, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(326, '4902430434393', 1, 'Joy Kalamansi 20ml', 1, 0, 9, 8, 4.64, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(327, '4902430389570', 1, 'Joy Lemon 20ml', 1, 0, 9, 8, 4.64, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(328, '4902430440080', 1, 'Bonux Powder Pink', 1, 0, 9, 8, 4.43, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(329, '4902430623179', 1, 'Bonux Powder Red', 1, 0, 9, 8, 4.43, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(330, '4800112256151', 1, 'Fuego Match Stix', 1, 0, 15, 8, 1.32, 2, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(331, '4806011812269', 1, 'Golden Q Green 454g', 1, 0, 13, 8, 19.75, 24, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(332, '4800024555489', 1, 'DM Tomato Sauce 115g', 1, 0, 1, 8, 13.9, 17, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(333, '4800017938107', 1, 'Ram Tomato Paste 150g', 1, 0, 1, 8, 20.5, 25, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(334, '4800017907707', 1, 'Ram Tomato Paste 70g', 1, 0, 1, 8, 11.25, 14, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(335, '4800888602725', 1, 'Knorr Pork Cubes', 1, 0, 1, 8, 4.5, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(336, '4800888602732', 1, 'Knorr Beef Cubes', 1, 0, 1, 8, 4.5, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(337, '4800888602718', 1, 'Knorr Chicken Cubes', 1, 0, 1, 8, 4.5, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(338, '4891208040167', 1, 'Oishi Kirei 20g', 1, 0, 11, 8, 4.45, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(339, '4800194116084', 1, 'Oishi Cracklings 24g', 1, 0, 11, 8, 4.45, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(340, '4800016084058', 1, 'Wafrets Choco Brix 24g', 1, 0, 12, 4, 3.77, 6, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(341, '323456789', 1, 'Nips Regular 14g', 1, 0, 16, 4, 2.66, 4, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(342, '423456789', 1, 'Nips Peanut 14g', 1, 0, 16, 4, 2.66, 4, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(343, '523456789', 1, 'Nips White Choco 14g', 1, 0, 16, 4, 2.66, 4, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(344, '4801234105815', 1, 'Baygon Kidlat Katol', 1, 0, 15, 8, 1.45, 4, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(345, '4801032111025', 1, 'San Miguel Beer 320ml', 1, 0, 4, 9, 23, 28, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(346, '4801032741048', 1, 'San Mig Light 330 ml', 1, 0, 4, 9, 25.63, 30, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(347, '4801032281056', 1, 'SM Lemon 330ml', 1, 0, 4, 9, 22.08, 26, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(348, '4801032281049', 1, 'SM Apple 330ml', 1, 0, 4, 9, 22.08, 26, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(349, '4801032111131', 1, 'San Miguel Beer 1000ml', 1, 0, 4, 9, 63.17, 74, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(350, '4801032211138', 1, 'Red Horse 1000ml', 1, 0, 4, 9, 63.83, 74, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(351, '4801032211077', 1, 'Red Horse 500ml', 1, 0, 4, 9, 31.42, 37, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(352, '623456789', 1, 'Ganador 1kg.', 1, 0, 17, 10, 45.6, 51, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(353, '723456789', 1, 'Ganador 1/2kg', 1, 0, 17, 10, 22.8, 25.5, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(354, '823456789', 1, 'Ganador 3/4kg', 1, 0, 17, 10, 34.2, 38.25, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(355, '923456789', 1, 'Ganador 1/4 kg', 1, 0, 17, 10, 11.4, 12.75, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(356, '102345678', 1, 'Balikatan 1kg', 1, 0, 17, 10, 41, 44, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(357, '112345678', 1, 'Balikatan 1/2kg', 1, 0, 17, 10, 20.5, 23, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(358, '122345678', 1, 'Balikatan 3/4kg', 1, 0, 17, 10, 30.75, 34.5, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(359, '132345678', 1, 'Balikatan 1/4kg', 1, 0, 17, 10, 10.25, 11.5, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(360, '142345678', 1, 'Tamaraw 1kg', 1, 0, 17, 10, 39, 44, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(361, '152345678', 1, 'Tamaraw 1/2kg', 1, 0, 17, 10, 19.5, 22, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(362, '162345678', 1, 'Tamaraw 3/4 kg', 1, 0, 17, 10, 29.25, 33, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(363, '172345678', 1, 'Tamaraw 1/4kg', 1, 0, 17, 10, 9.75, 11, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(364, '182345678', 1, 'Broken Oliver 1kg', 1, 0, 17, 10, 35.2, 39, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(365, '192345678', 1, 'Broken Oliver 1/2kg', 1, 0, 17, 10, 17.6, 19.5, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(366, '202345678', 1, 'Broken Oliver 3/4kg', 1, 0, 17, 10, 26.4, 29.25, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(367, '212345678', 1, 'Broken Oliver 1/4kg', 1, 0, 17, 10, 8.8, 9.75, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(368, '242345678', 1, 'White Sugar 1kg', 1, 0, 17, 10, 42.2, 64, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(369, '252345678', 1, 'White Sugar 1/2kg', 1, 0, 17, 10, 21.1, 32, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(370, '262345678', 1, 'White Sugar 1/4kg', 1, 0, 17, 10, 10.55, 16, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(371, '272345678', 1, 'Brown Sugar 1kg', 1, 0, 17, 10, 31.4, 52, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(372, '282345678', 1, 'Brown Sugar 1/2kg', 1, 0, 17, 10, 15.7, 26, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(373, '292345678', 1, 'Brown Sugar 1/4kg', 1, 0, 17, 10, 7.85, 13, 0, 0, 'Enable', '2017-05-03', '0000-00-00'),
(374, '748485400174', 1, 'Plus King Pineapple 250ml', 1, 0, 4, 5, 5.65, 8, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(375, '4800575884007', 1, 'Alpine Full Cream Evaporated 370ml', 1, 0, 13, 8, 50.35, 57, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(376, '9557727929202', 1, 'Doreen Condense Milk 370ml', 1, 0, 13, 8, 28, 34, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(377, '4800575130166', 1, 'Alaska Condensada 168ml ', 1, 0, 13, 8, 25.75, 31, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(378, '4800575883000', 1, 'Carnation Evap 370ml', 1, 0, 13, 8, 32.75, 39, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(379, '4800217051019', 1, 'Temple Salted Black Beans 150g', 1, 0, 13, 8, 22.3, 27, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(380, '4800575883512', 1, 'Carnation Condensada 168ml', 1, 0, 13, 8, 31.25, 37, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(381, '4800575884502', 1, 'Alpine Full Cream Evaporated 154ml', 1, 0, 13, 8, 26.1, 31, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(382, '4800575130302', 1, 'Alaska Condensada 300ml', 1, 0, 13, 8, 39.5, 48, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(383, '4800575140370', 1, 'Alaska Evaporated 370ml', 1, 0, 13, 8, 24.45, 29, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(384, '4800575140158', 1, 'Alaska Evaporada 140ml', 1, 0, 13, 8, 10.7, 14, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(385, '4800888151100', 1, 'Rexona Passion DL Red ', 1, 0, 9, 8, 6.75, 8, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(386, '4800888160027', 1, 'Rexona for Men DL ', 1, 0, 9, 8, 6.75, 8, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(387, '4809010431622', 1, 'Glow Spoon ', 1, 0, 17, 8, 1.12, 2, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(388, '4801958334102', 1, 'Ajinomoto 24g', 1, 0, 1, 8, 4.18, 5, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(389, '4801958153109', 1, 'Ajinomoto 9g', 1, 0, 1, 8, 1.66, 2, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(390, '4800888158888', 1, 'Rexona Powder Dry DL Pink', 1, 0, 9, 8, 6.75, 8, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(391, '4809010431806', 1, 'Glow Fork', 1, 0, 17, 8, 1.2, 2, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(392, '4809010431790', 1, 'Glow Paper Plate ', 1, 0, 17, 8, 1.68, 2, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(393, '4800045310241', 1, 'Smart DW 200g', 1, 0, 9, 8, 19.1, 23, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(394, '4800194153225', 1, 'Bread Pan Green 24g', 1, 0, 11, 8, 4.55, 6, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(395, '4800194153683', 1, 'Bread Pan White 24g', 1, 0, 11, 8, 4.55, 6, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(396, '4800194104982', 1, 'Onion Rings ', 1, 0, 11, 8, 4.45, 6, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(397, '4800602060503', 1, 'Eight ''O Clock Mango 30g', 1, 0, 4, 8, 7.5, 10, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(398, '4800602060251', 1, 'Eight ''O Clock Pineapple 30g', 1, 0, 4, 8, 7.5, 10, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(399, '4902430495066', 1, 'Safeguard Pure White 25g', 1, 0, 9, 8, 6.6, 9, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(400, '4902430278119', 1, 'Tide Bar Original Scent ', 1, 0, 9, 8, 4.75, 6, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(401, '4800888190987', 1, 'Surf Bar Pink', 1, 0, 9, 8, 5.33, 6, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(402, '4800888136787', 1, 'Surf Bar Yellow', 1, 0, 9, 8, 5.33, 6, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(403, '4800888136749', 1, 'Surf Bar Green', 1, 0, 9, 8, 4.62, 6, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(404, '842345678', 1, 'Plastic Cup 8oz', 1, 0, 17, 8, 0.39, 1, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(405, '322345678', 1, 'Medicol Advance 200mg', 1, 0, 18, 11, 5.5, 8, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(406, '332345678', 1, 'Diatabs 2mg', 1, 0, 18, 11, 7.2, 9, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(407, '342345678', 1, 'Tuseran Forte 325mg', 1, 0, 18, 11, 9, 12, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(408, '352345678', 1, 'Saridon Tab 250mg', 1, 0, 18, 11, 5.2, 8, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(409, '362345678', 1, 'Mefenamic Acid 500mg', 1, 0, 18, 11, 2.1, 4, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(410, '382345678', 1, 'Enervon Tab', 1, 0, 18, 11, 6, 8, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(411, '392345678', 1, 'Stresstabs', 1, 0, 18, 11, 10.75, 14, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(412, '402345678', 1, 'Centrum', 1, 0, 18, 11, 11, 13, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(413, '522345678', 1, 'Alaxan FR 200mg', 1, 0, 18, 11, 8.1, 10, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(414, '532345678', 1, 'Biogesic 500mg', 1, 0, 18, 11, 3.25, 5, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(415, '542345678', 1, 'Strepsils 1.2mg', 1, 0, 18, 11, 55.15, 66, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(416, '562345678', 1, 'Neozep Forte ', 1, 0, 18, 11, 5.5, 7, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(417, '582345678', 1, 'Bioflu 500mg', 1, 0, 18, 11, 7.25, 9, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(418, '592345678', 1, 'Robitussin 200mg', 1, 0, 18, 11, 11.75, 14, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(419, '612345678', 1, 'Dolfenal 500mg', 1, 0, 18, 11, 26, 31, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(420, '672345678', 1, 'Sinutab 500mg', 1, 0, 18, 11, 9.65, 12, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(421, '772345678', 1, 'Revicon Forte ', 1, 0, 18, 11, 4.75, 6, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(422, '802345678', 1, 'Solmux Cap 500mg', 1, 0, 18, 11, 10.75, 13, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(423, '812345678', 1, 'Kremil-S Tab 30mg', 1, 0, 18, 11, 5.25, 7, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(424, '832345678', 1, 'Decolgen Forte 500mg', 1, 0, 18, 11, 5.8, 7, 0, 0, 'Enable', '2017-05-05', '0000-00-00');
INSERT INTO `product` (`product_id`, `product_code`, `branch_id`, `product_name`, `num_of_products`, `order_constant`, `category_id`, `supplier_id`, `supplier_price`, `selling_price`, `selling_unit_price`, `selling_quantity`, `product_status`, `date_created`, `expiration_date`) VALUES
(425, '4800016115257', 1, 'Chik N Skin ni Mang Juan 70g', 1, 0, 11, 4, 12.75, 18, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(426, '4891208040181', 1, 'Rinbee 24g', 1, 0, 11, 8, 4.45, 6, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(427, '4902430401845', 1, 'Downy SF 28ml', 1, 0, 9, 8, 4.53, 6, 0, 0, 'Enable', '2017-05-05', '0000-00-00'),
(428, '4800488101314', 1, 'Charmee w/ Wings 8pads ', 1, 0, 9, 8, 17.5, 24, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(429, '4902430615174', 1, 'Pampers XL', 1, 0, 9, 8, 12.04, 15, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(430, '8850007331261', 1, 'Carefree Breathable Panty Liner', 1, 0, 9, 8, 2.22, 3, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(431, '748485200118', 1, 'Lucky 7 hot 155g', 1, 0, 13, 8, 13.15, 16, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(432, '748485200101', 1, 'Lucky 7 Green 155g', 1, 0, 13, 8, 13.05, 16, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(433, '4806508622029', 1, 'Swan Sardines Red 155g ', 1, 0, 13, 8, 12.5, 16, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(434, '4800163008013', 1, 'King Cup Sardines Green 155g', 1, 0, 13, 8, 12.3, 15, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(435, '4806508622005', 1, 'Swan Sardines Green 155g', 1, 0, 13, 8, 12.5, 16, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(436, '4806504710119', 1, 'Mega Sardines Green 155g ', 1, 0, 13, 8, 14.25, 18, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(437, '4806504710126', 1, 'Mega Sardines Red 155g', 1, 0, 13, 8, 14.5, 18, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(438, '4807770271342', 1, 'Lucky Me Chicken Mami 40g', 1, 0, 13, 8, 15.3, 20, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(439, '4807770271168', 1, 'Lucky Me La Paz Batchoy 40g', 1, 0, 13, 8, 15.3, 20, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(440, '4808647020162', 1, 'Eden Cheese Sachet 35g', 1, 0, 13, 8, 10.5, 13, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(441, '4808647020094', 1, 'Eden Cheese 165g', 1, 0, 13, 8, 43.25, 52, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(442, '4800066410128', 1, 'Sunpride Tocino Mix 120g', 1, 0, 1, 8, 21.25, 27, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(443, '4800047841705', 1, 'Zonrox CS 900ml', 1, 0, 9, 8, 56.1, 67, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(444, '4800047840012', 1, 'Zonrox Original 1000ml', 1, 0, 9, 8, 28.75, 35, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(445, '4902430615419', 1, 'Pampers L', 1, 0, 9, 8, 11.15, 14, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(446, '4902430729925', 1, 'Downy Mystique 20ml', 1, 0, 9, 8, 4.6, 6, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(447, '4902430729901', 1, 'Downy Passion 20ml', 1, 0, 9, 8, 4.6, 6, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(448, '4902430178228', 1, 'Perla Blue', 1, 0, 9, 8, 10.65, 13, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(449, '4902430177597', 1, 'Perla White ', 1, 0, 9, 8, 10.65, 13, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(450, '4902430346177', 1, 'Downy SF 43ml', 1, 0, 9, 8, 6.75, 8, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(451, '4902430452694', 1, 'Downy GB 43ml', 1, 0, 9, 8, 6.75, 8, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(452, '4800888189806', 1, 'Surf CB 57g', 1, 0, 9, 8, 4.41, 6, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(453, '4801958460009', 1, 'Crispy Fry Orig. 30g', 1, 0, 1, 8, 8.25, 10, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(454, '4800045310272', 1, 'Smart DW Paste Kalamansi 400g', 1, 0, 9, 8, 34.25, 41, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(455, '4800045310159', 1, 'Smart DW Paste Lemon 400g', 1, 0, 9, 8, 34.25, 41, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(456, '4801958390108', 1, 'Crispy Fry Orig.62g', 1, 0, 1, 8, 13.4, 16, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(457, '4800575883505', 1, 'Carnation Condensada 300ml', 1, 0, 13, 8, 48.6, 58, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(458, '4806014001196', 1, 'Good life Bread Crumbs 230g ', 1, 0, 1, 8, 28.5, 34, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(459, '4800888154439', 1, 'Dove Conditioner Pink', 1, 0, 9, 8, 5.25, 7, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(460, '4800488011415', 1, 'Charmee 8''s w/ wings ', 1, 0, 9, 8, 15, 21, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(461, '4806515986619', 1, 'Tawas 45gms', 1, 0, 9, 8, 7, 10, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(462, '48031813', 1, 'OFF Lotion', 1, 0, 9, 8, 6.4, 8, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(463, '4800888154422', 1, 'Dove Conditioner Blue ', 1, 0, 9, 8, 5.25, 7, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(464, '4800888154415', 1, 'Dove Conditioner Gold', 1, 0, 9, 8, 5.25, 7, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(465, '4800888179630', 1, 'Dove Conditioner White', 1, 0, 9, 8, 5.25, 7, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(466, '748485200125', 1, 'Consuelo Sardines Green 155g', 1, 0, 13, 8, 11, 16, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(467, '4806507832214', 1, 'Silka Green 65g', 1, 0, 9, 8, 17.5, 21, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(468, '7622300559991', 1, 'Tang Orange 25g', 1, 0, 4, 8, 8.95, 11, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(469, '4800602060237', 1, 'Eight O'' Clock 30g', 1, 0, 4, 8, 7.5, 10, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(470, '4808680651019', 1, 'Lady''s Choice Ham Spread 80ml', 1, 0, 13, 8, 27.5, 34, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(471, '4808680651002', 1, 'Lady''s Choice Bacon Spread 80ml', 1, 0, 13, 8, 27.5, 34, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(472, '4808680021355', 1, 'Lady''s Choice Real Mayonnaise 80ml', 1, 0, 13, 8, 26.5, 32, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(473, '7622300312039', 1, 'Cheez Whiz Pimiento 15g', 1, 0, 13, 8, 5.85, 7, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(474, '4808647010149', 1, 'Chezz Whiz Original 15g', 1, 0, 13, 8, 5.85, 7, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(475, '8992222052467', 1, 'Gatsby Red ', 1, 0, 9, 8, 3.75, 5, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(476, '4902806015553', 1, 'Gatsby Blue ', 1, 0, 9, 8, 3.75, 5, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(477, '4800888154279', 1, 'Dove Pink ', 1, 0, 9, 8, 4.1, 6, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(478, '014285003250', 1, 'UFC 320g', 1, 0, 1, 8, 14.2, 21, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(479, '4800066410609', 1, 'Sunpride Tocino Mix 60g', 1, 0, 1, 8, 14, 17, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(480, '4806013001067', 1, 'Lion-Tiger Katol', 1, 0, 15, 8, 1.35, 2, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(481, '014285003908', 1, 'UFC 25g', 1, 0, 1, 8, 2.32, 3, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(482, '4807770272646', 1, 'Lucky Me Supreme Jjamppong 70g ', 1, 0, 13, 8, 32.5, 40, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(483, '9556031084133', 1, 'Palmolive Papaya Soap ', 1, 0, 9, 8, 11.5, 15, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(484, '8850006492291', 1, 'Palmolive Soap Blue', 1, 0, 9, 8, 11.5, 15, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(485, '4806014092835', 1, 'Good Life Bread Crumbs 80g', 1, 0, 1, 8, 13.5, 17, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(486, '4902430389549', 1, 'Joy Antibac 18ml', 1, 0, 9, 8, 4.64, 6, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(487, '942345678', 1, 'Glow Styro Cup 8oz', 1, 0, 17, 8, 1.32, 2, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(488, '4806506318849', 1, 'Sisters w/ Wings Green 8''s', 1, 0, 9, 8, 20.15, 24, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(489, '4800488011484', 1, 'Charmee Cottony w/o wings pink 8''s', 1, 0, 9, 8, 15, 21, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(490, '48032025', 1, 'Ginisa Mix 7g', 1, 0, 1, 8, 1.62, 3, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(491, '4800086035943', 1, 'Selecta Coffee Crumble 1.5L', 1, 0, 19, 12, 222.72, 255, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(492, '4800086040909', 1, 'Selecta Coffee Crumble 750ml', 1, 0, 19, 12, 113.63, 135, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(493, '4800086040879', 1, 'Selecta Double Dutch 750ml', 1, 0, 19, 12, 113.63, 135, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(494, '4800086043917', 1, 'Selecta Choco Chip Cookie Dough 750ml', 1, 0, 19, 12, 113.63, 135, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(495, '4800086043979', 1, 'Selecta 2in1 Buco Pie Con Leche Quezo Real  750ml', 1, 0, 19, 12, 113.63, 135, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(496, '4800086043504', 1, 'Selecta Birthday 3-in-1 Choco Pandan Ube 1L ', 1, 0, 19, 12, 90, 110, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(497, '4800086040688', 1, 'Selecta 2in1 Cookies&Cream Double Dutch 750ml', 1, 0, 19, 12, 113.63, 135, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(498, '4800086043375', 1, 'Selecta Black Forest 750ml', 1, 0, 19, 12, 113.63, 135, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(499, '4800086043399', 1, 'Selecta Butterscotch Salted Caramel 750ml', 1, 0, 19, 12, 113.63, 135, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(500, '4800086043610', 1, 'Selecta Rocky Road solo pack 475ml', 1, 0, 19, 12, 80.9, 95, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(501, '4800086043641', 1, 'Selecta Pistachio&Cashew 475ml', 1, 0, 19, 12, 80.9, 95, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(502, '4800086043634', 1, 'Selecta Coffee Crumble solo pack 475ml', 1, 0, 19, 12, 80.9, 95, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(503, '4800086040527', 1, 'Selecta Birthday 3-in-1 ChocoKesoUbe 1L', 1, 0, 19, 12, 90, 110, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(504, '4800086035967', 1, 'Selecta Double Dutch 1.5L', 1, 0, 19, 12, 222.72, 255, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(505, '4800086042293', 1, 'Selecta Mango Graham Cake 1.5L', 1, 0, 19, 12, 222.72, 255, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(506, '4800086036049', 1, 'Selecta Super Thick Vanilla 1.5L', 1, 0, 19, 12, 209.1, 230, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(507, '4800086043344', 1, 'Selecta Mango Sans Rival 1.5L', 1, 0, 19, 12, 222.72, 255, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(508, '4800086039149`', 1, 'Selecta 3-in-1+1 ChocoMangoUbeDD 3L', 1, 0, 19, 12, 309.09, 350, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(509, '4800086036179', 1, 'Selecta Rocky Road 3.0L', 1, 0, 19, 12, 399.99, 450, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(510, '4800086036209', 1, 'Selecta Pistachio&Cashew 1.5L', 1, 0, 19, 12, 222.72, 255, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(511, '4800086036162', 1, 'Selecta Quezo Real 1.5L', 1, 0, 19, 12, 222.72, 255, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(512, '4800086043887', 1, 'Selecta Buco Pie Con Leche 1.5L', 1, 0, 19, 12, 222.72, 255, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(513, '4800086036094', 1, 'Selecta Super Think Strawberry 1.5L', 1, 0, 19, 12, 209.1, 230, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(514, '4800086043009', 1, 'Selecta 2in1 Super Chocolate/Ube Royale 1.5L', 1, 0, 19, 12, 209.1, 240, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(515, '4800086035929', 1, 'Selecta Cookies&Cream 1.5L', 1, 0, 19, 12, 222.72, 255, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(516, '4800086036025', 1, 'Selecta Super Chocolate 1.5L', 1, 0, 19, 12, 209.1, 230, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(517, '4800086043924', 1, 'Selecta Sapin-Sapin 1.5L', 1, 0, 19, 12, 222.72, 255, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(518, '4800086035905', 1, 'Selecta Buco Salad 1.5L', 1, 0, 19, 12, 222, 255, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(519, '4800086043382', 1, 'Selecta Butterscotch Salted Caramel 1.5L', 1, 0, 19, 12, 222.72, 255, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(520, '4800086036001', 1, 'Selecta Mango 1.5L', 1, 0, 19, 12, 209.1, 230, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(521, '6921738085289', 1, 'Pentel Pen Disposable ', 1, 0, 20, 13, 9, 15, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(522, '026000223720', 1, 'Elmer''s Glue-All 130g', 1, 0, 20, 13, 39, 48, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(523, '8801038200019', 1, 'Dorco Blade ', 1, 0, 20, 13, 2.2, 5, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(524, '4806524271126', 1, 'Atlantic Yellow Pad', 1, 0, 20, 13, 15, 22, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(525, '4806524271034', 1, 'Intermediate Pad ', 1, 0, 20, 13, 12, 22, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(526, '4806508030510', 1, 'Hapi Grade 3 ', 1, 0, 20, 13, 7, 12, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(527, '4806508030497', 1, 'Hapi Grade 2', 1, 0, 20, 13, 7, 12, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(528, '4806508030480', 1, 'Hapi Grade 1', 1, 0, 20, 13, 7, 12, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(529, '992345678', 1, 'Bondpaper Long', 1, 0, 20, 13, 0.32, 2, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(530, '100234567', 1, 'Bondpaper Short ', 1, 0, 20, 13, 0.27, 1, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(531, '109234567', 1, 'Brown Envelope Long ', 1, 0, 20, 13, 1.4, 4, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(532, '110234567', 1, 'Brown Envelope Short', 1, 0, 20, 13, 1.3, 3, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(533, '101234567', 1, 'Folder White Long', 1, 0, 20, 13, 3, 7, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(534, '104234567', 1, 'Sliding Folder Short', 1, 0, 20, 13, 4.5, 6, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(535, '105234567', 1, 'Plastic Envelope Long', 1, 0, 20, 13, 6, 8, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(536, '106234567', 1, 'Plastic Envelope Short ', 1, 0, 20, 13, 5.5, 7, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(537, '107234567', 1, 'Manila Paper', 1, 0, 20, 13, 2.5, 5, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(538, '108234567', 1, 'HBW Ballpen', 1, 0, 20, 13, 3.75, 6, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(539, '111234567', 1, 'Cartolina', 1, 0, 20, 13, 6, 7, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(540, '112234567', 1, 'Pencil', 1, 0, 20, 13, 5.5, 6, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(541, '113234567', 1, 'Fastener', 1, 0, 20, 13, 1, 2, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(542, '114234567', 1, 'Biodata', 1, 0, 20, 13, 0.04, 2, 0, 0, 'Enable', '2017-05-06', '0000-00-00'),
(543, '115234567', 1, 'Sharpener', 1, 0, 20, 13, 2.5, 5, 0, 0, 'Enable', '2017-05-06', '0000-00-00');

-- --------------------------------------------------------

--
-- Table structure for table `product_history`
--

CREATE TABLE `product_history` (
  `product_history_id` int(11) NOT NULL,
  `branch_id` int(11) NOT NULL,
  `product_code` varchar(20) DEFAULT NULL,
  `supplier_id` int(11) NOT NULL,
  `cp_number` varchar(20) NOT NULL,
  `account_id` int(11) NOT NULL,
  `supplier_price` float NOT NULL,
  `selling_price` float NOT NULL,
  `product_stock` double DEFAULT NULL,
  `product_sold` double DEFAULT NULL,
  `total_cost` double NOT NULL,
  `tendered_amount` double NOT NULL,
  `expiration_date` date NOT NULL,
  `history_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_history`
--

INSERT INTO `product_history` (`product_history_id`, `branch_id`, `product_code`, `supplier_id`, `cp_number`, `account_id`, `supplier_price`, `selling_price`, `product_stock`, `product_sold`, `total_cost`, `tendered_amount`, `expiration_date`, `history_date`) VALUES
(1, 1, '48025522', 1, '', 1, 2.25, 4, 100, 0, 0, 0, '0000-00-00', '2017-05-18 11:24:57'),
(2, 1, '8996001440049', 6, '', 1, 5.33, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(3, 1, '8996001414309', 6, '', 1, 5.6, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(4, 1, '8996001410226', 6, '', 1, 4.5, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(5, 1, '8886467103605', 0, '', 1, 8, 10, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(6, 1, '8851717040016', 0, '', 1, 16.22, 20, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(7, 1, '8851717200007', 0, '', 1, 8.15, 10, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(8, 1, '4807770100703', 0, '', 1, 3.81, 5, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(9, 1, '8886467103599', 0, '', 1, 8, 10, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(10, 1, '750515031043', 0, '', 1, 4.68, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(11, 1, '4807770122255', 0, '', 1, 4.31, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(12, 1, '4807770101854', 0, '', 1, 3.8, 5, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(13, 1, '750515017429', 0, '', 1, 4.31, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(14, 1, '750515018402', 0, '', 1, 4.29, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(15, 1, '4807770122163', 0, '', 1, 4.5, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(16, 1, '4807770121197', 0, '', 1, 4.57, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(17, 1, '4807770121210', 0, '', 1, 4.57, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(18, 1, '8996001410981', 6, '', 1, 5.1, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(19, 1, '8996001440124', 6, '', 1, 5.33, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(20, 1, '8996001410547', 6, '', 1, 5.25, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(21, 1, '8851717200014', 0, '', 1, 8.15, 10, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(22, 1, '4807770120206', 0, '', 1, 1.78, 3, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(23, 1, '4807770101557', 0, '', 1, 4.68, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(24, 1, '4807770121708', 0, '', 1, 8.33, 12, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(25, 1, '4807770120763', 0, '', 1, 4.68, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(26, 1, '4807770101533', 0, '', 1, 4.68, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(27, 1, '4807770120435', 0, '', 1, 4.67, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(28, 1, '750515031067', 0, '', 1, 4.68, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(29, 1, '4801981125180', 5, '', 1, 21.58, 26, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(30, 1, '4801981164905', 5, '', 1, 9, 12, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(31, 1, '4801981105205', 5, '', 1, 7.8, 10, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(32, 1, '4800602024833', 5, '', 1, 21, 26, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(33, 1, '4801981106202', 5, '', 1, 9.76, 12, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(34, 1, '4800443001062', 5, '', 1, 6, 9, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(35, 1, '4801981106004', 5, '', 1, 9.76, 12, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(36, 1, '4801981105007', 5, '', 1, 7.8, 10, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(37, 1, '4801981109005', 5, '', 1, 22.5, 26, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(38, 1, '4801981109203', 5, '', 1, 22.5, 26, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(39, 1, '4801981116171', 5, '', 1, 43.5, 50, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(40, 1, '4801981116645', 5, '', 1, 43.5, 50, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(41, 1, '4801981117208', 5, '', 1, 43.5, 50, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(42, 1, '4801981117000', 5, '', 1, 43.5, 50, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(43, 1, '054028367911', 7, '', 1, 7.2, 10, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(44, 1, '4801981122943', 5, '', 1, 43.5, 50, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(45, 1, '4800016110597', 9, '', 1, 12.75, 18, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(46, 1, '4800016056291', 9, '', 1, 4.78, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(47, 1, '4800016110535', 9, '', 1, 4.47, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(48, 1, '4800016622588', 9, '', 1, 34.66, 48, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(49, 1, '4800016644504', 9, '', 1, 21.51, 30, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(50, 1, '4800016633799', 9, '', 1, 21.51, 30, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(51, 1, '4800016633621', 9, '', 1, 9.33, 13, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(52, 1, '4800016663802', 9, '', 1, 9.33, 13, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(53, 1, '4800016663505', 9, '', 1, 21.51, 30, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(54, 1, '4800016604225', 9, '', 1, 9.33, 13, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(55, 1, '4800016604232', 9, '', 1, 21.51, 30, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(56, 1, '4800016622526', 9, '', 1, 20.69, 30, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(57, 1, '4800016603266', 9, '', 1, 20.69, 30, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(58, 1, '4800016625534', 9, '', 1, 20.69, 30, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(59, 1, '4800016622533', 9, '', 1, 9.07, 13, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(60, 1, '4800016653094', 9, '', 1, 15.3, 21, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(61, 1, '4800016643095', 9, '', 1, 16, 23, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(62, 1, '4800016641503', 9, '', 1, 16, 23, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(63, 1, '4800016641008', 9, '', 1, 4.64, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(64, 1, '4800016642029', 9, '', 1, 4.64, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(65, 1, '4800016603259', 9, '', 1, 9.07, 13, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(66, 1, '4800016661006', 9, '', 1, 4.64, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(67, 1, '4800016661099', 9, '', 1, 16, 22, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(68, 1, '4800016021497', 9, '', 1, 7.91, 11, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(69, 1, '4800016021282', 9, '', 1, 4.09, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(70, 1, '4800016021039', 9, '', 1, 5.1, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(71, 1, '4800010011272', 9, '', 1, 5.1, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(72, 1, '4800016054907', 9, '', 1, 3.46, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(73, 1, '4800016021633', 9, '', 1, 4.09, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(74, 1, '4800016021251', 9, '', 1, 4.09, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(75, 1, '4800016111044', 9, '', 1, 4.66, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(76, 1, '4800016111051', 9, '', 1, 4.66, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(77, 1, '4800016112140', 9, '', 1, 4.69, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(78, 1, '4800016112379', 9, '', 1, 4.69, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(79, 1, '4800016112430', 9, '', 1, 4.69, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(80, 1, '4800016082603', 9, '', 1, 3.64, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(81, 1, '4800016082610', 9, '', 1, 3.77, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(82, 1, '4800016082627', 9, '', 1, 3.77, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(83, 1, '4800016052149', 9, '', 1, 19.64, 24, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(84, 1, '4800016052057', 9, '', 1, 15.56, 19, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(85, 1, '4800016052767', 9, '', 1, 27.85, 34, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(86, 1, '4800016052774', 9, '', 1, 27.85, 34, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(87, 1, '4800016052040', 9, '', 1, 15.56, 19, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(88, 1, '4800016056277', 9, '', 1, 4.78, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(89, 1, '4800016056284', 9, '', 1, 4.78, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(90, 1, '48040600', 9, '', 1, 4.37, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(91, 1, '4800016627262', 9, '', 1, 4.64, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(92, 1, '4800016629426', 9, '', 1, 4.64, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(93, 1, '4800016627279', 9, '', 1, 4.64, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(94, 1, '4800016627286', 9, '', 1, 4.64, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(95, 1, '4800016628269', 9, '', 1, 8.43, 13, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(96, 1, '4800016084034', 9, '', 1, 3.77, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(97, 1, '4800016077715', 9, '', 1, 5.1, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(98, 1, '4800016628283', 9, '', 1, 4.64, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(99, 1, '4800016084195', 9, '', 1, 3.77, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(100, 1, '4800016078590', 9, '', 1, 5.1, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(101, 1, '4800016077081', 9, '', 1, 6.04, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(102, 1, '4800016078552', 9, '', 1, 5.01, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(103, 1, '4800016113055', 9, '', 1, 5.1, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(104, 1, '4800016113970', 9, '', 1, 5.1, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(105, 1, '4800010075069', 9, '', 1, 5.1, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(106, 1, '4800016113048', 9, '', 1, 5.1, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(107, 1, '4800010961447', 9, '', 1, 5.26, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(108, 1, '4800016082641', 9, '', 1, 3.74, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(109, 1, '4800016082825', 9, '', 1, 3.63, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(110, 1, '4800010075878', 9, '', 1, 3.99, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(111, 1, '4800016076756', 9, '', 1, 3.99, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(112, 1, '4800016633614', 9, '', 1, 21.51, 30, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(113, 1, '4800016115011', 9, '', 1, 4.64, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(114, 1, '4800016087257', 9, '', 1, 3.77, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(115, 1, '4800016112478', 9, '', 1, 4.69, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(116, 1, '4800016076930', 9, '', 1, 3.99, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(117, 1, '4800361015172', 10, '', 1, 26.7, 36, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(118, 1, '4800361015103', 10, '', 1, 26.7, 36, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(119, 1, '14800016057073', 9, '', 1, 8.01, 11, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(120, 1, '4800361397605', 10, '', 1, 28.91, 40, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(121, 1, '8850124006585', 10, '', 1, 15.31, 23, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(122, 1, '4800361015400', 10, '', 1, 20.44, 28, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(123, 1, '4800361388313', 10, '', 1, 15.85, 24, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(124, 1, '4800361339186', 10, '', 1, 16.73, 25, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(125, 1, '4800361396059', 10, '', 1, 4.48, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(126, 1, '4800361396189', 10, '', 1, 4.48, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(127, 1, '4800361395076', 10, '', 1, 7.75, 11, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(128, 1, '4800361391900', 10, '', 1, 6.47, 10, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(129, 1, '4800361396202', 10, '', 1, 4.48, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(130, 1, '4800361383301', 10, '', 1, 4.82, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(131, 1, '4800361383493', 10, '', 1, 5.02, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(132, 1, '4800361381024', 10, '', 1, 9.73, 14, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(133, 1, '9556001132338', 10, '', 1, 46.97, 63, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(134, 1, '9556001210876', 10, '', 1, 8.04, 11, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(135, 1, '4800361386722', 10, '', 1, 7.58, 11, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(136, 1, '4800361382083', 0, '', 1, 7.65, 11, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(137, 1, '4800361384650', 10, '', 1, 7.58, 11, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(138, 1, '4800361387989', 10, '', 1, 7.65, 11, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(139, 1, '4800361328463', 11, '', 1, 4, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(140, 1, '4800361393096', 10, '', 1, 5.02, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(141, 1, '4800361394253', 10, '', 1, 7.58, 11, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(142, 1, '4800361379557', 10, '', 1, 7.65, 11, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(143, 1, '4800361395366', 10, '', 1, 7.65, 11, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(144, 1, '48025522', 10, '', 1, 2.28, 3, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(145, 1, '4800361339568', 10, '', 1, 1.69, 3, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(146, 1, '4800361386821', 10, '', 1, 7.58, 11, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(147, 1, '4800361394581', 10, '', 1, 7.75, 11, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(148, 1, '8850006320518', 12, '', 1, 43.12, 52, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(149, 1, '8850006321133', 12, '', 1, 22.96, 28, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(150, 1, '8850006320501', 12, '', 1, 68.32, 82, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(151, 1, '8850006325216', 12, '', 1, 5.9, 8, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(152, 1, '8850006321539', 12, '', 1, 68.32, 82, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(153, 1, '8850006325049', 12, '', 1, 43.12, 52, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(154, 1, '8850006321546', 12, '', 1, 22.96, 28, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(155, 1, '8850006322918', 12, '', 1, 43.12, 52, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(156, 1, '8850006323670', 12, '', 1, 43.12, 52, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(157, 1, '8850006325230', 12, '', 1, 5.9, 8, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(158, 1, '8850006322949', 12, '', 1, 43.12, 52, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(159, 1, '8850006325223', 12, '', 1, 5.9, 8, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(160, 1, '8850006491119', 12, '', 1, 4.25, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(161, 1, '8850006491102', 3, '', 1, 4.25, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(162, 1, '8850006491133', 3, '', 1, 4.25, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(163, 1, '8850006491799', 3, '', 1, 4.1, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(164, 1, '8850006481806', 3, '', 1, 4.1, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(165, 1, '8850006491812', 3, '', 1, 4.1, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(166, 1, '8850006491782', 3, '', 1, 4.1, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(167, 1, '4808888320106', 3, '', 1, 10.92, 15, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(168, 1, '4808888201115', 3, '', 1, 10.92, 15, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(169, 1, '8850006265178', 3, '', 1, 43.12, 55, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(170, 1, '8850006536056', 3, '', 1, 4.32, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(171, 1, '8850006536063', 3, '', 1, 4.32, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(172, 1, '8850006491126', 3, '', 1, 4.25, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(173, 1, '8850006491157', 3, '', 1, 4.25, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(174, 1, '8850006491140', 3, '', 1, 4.25, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(175, 1, '4800016110511', 4, '', 1, 12.75, 18, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(176, 1, '4800016110528', 4, '', 1, 12.75, 18, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(177, 1, '4800016622571', 4, '', 1, 34.66, 48, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(178, 1, '4800016633782', 4, '', 1, 9.33, 13, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(179, 1, '4800016644801', 4, '', 1, 9.33, 13, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(180, 1, '4800016671807', 4, '', 1, 9.33, 13, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(181, 1, '4800016652035', 4, '', 1, 3.73, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(182, 1, '4800010076073', 4, '', 1, 3.99, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(183, 1, '4800016077524', 4, '', 1, 5.1, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(184, 1, '48039260', 4, '', 1, 4.37, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(185, 1, '48040617', 4, '', 1, 4.37, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(186, 1, '4800088230605', 5, '', 1, 43.5, 53, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(187, 1, '4800088230667', 5, '', 1, 43.5, 53, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(188, 1, '4800088250269', 5, '', 1, 20, 25, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(189, 1, '4800088210416', 5, '', 1, 42, 53, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(190, 1, '4809010394774', 5, '', 1, 5.4, 8, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(191, 1, '4809010394644', 5, '', 1, 5.4, 8, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(192, 1, '4809010394880', 5, '', 1, 5.4, 8, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(193, 1, '4800088250290', 5, '', 1, 20, 25, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(194, 1, '4800088230513', 5, '', 1, 24, 30, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(195, 1, '4800088230506', 5, '', 1, 24, 30, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(196, 1, '4800361381086', 6, '', 1, 42.51, 57, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(197, 1, '4806502721476', 7, '', 1, 56.35, 62, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(198, 1, '4806502720417', 7, '', 1, 41.55, 45.75, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(199, 1, '4806502720615', 7, '', 1, 55, 60.5, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(200, 1, '4806502721445', 7, '', 1, 56.35, 62, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(201, 1, '4806502725726', 7, '', 1, 32.95, 36.25, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(202, 1, '4806502726129', 7, '', 1, 40, 44, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(203, 1, '4806502725269', 7, '', 1, 65.45, 72, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(204, 1, '4806502720165', 7, '', 1, 56.35, 62, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(205, 1, '4807770273612', 8, '', 1, 15.3, 20, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(206, 1, '4807770270024', 8, '', 1, 6.9, 9, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(207, 1, '4807770270017', 8, '', 1, 6.9, 9, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(208, 1, '4800110025995', 8, '', 1, 6.5, 8, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(209, 1, '4800110026497', 8, '', 1, 6.5, 8, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(210, 1, '4807770270291', 8, '', 1, 8.75, 11, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(211, 1, '4807770270123', 8, '', 1, 8.75, 11, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(212, 1, '4807770271229', 8, '', 1, 8.75, 11, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(213, 1, '4807770270055', 8, '', 1, 8.75, 11, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(214, 1, '4807770272554', 8, '', 1, 8.75, 11, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(215, 1, '4808680651026', 8, '', 1, 27.5, 34, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(216, 1, '4808680022017', 8, '', 1, 27.5, 34, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(217, 1, '4808680653419', 8, '', 1, 6.85, 10, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(218, 1, '4808680652887', 8, '', 1, 6.85, 10, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(219, 1, '4808680652894', 8, '', 1, 6.85, 10, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(220, 1, '4808680653402', 8, '', 1, 6.85, 10, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(221, 1, '4800066122519', 8, '', 1, 21.85, 26, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(222, 1, '4800066124902', 8, '', 1, 15.25, 19, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(223, 1, '748485700052', 8, '', 1, 24, 29, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(224, 1, '748485700014', 8, '', 1, 21.4, 26, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(225, 1, '748485700083', 8, '', 1, 24, 29, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(226, 1, '748485801490', 8, '', 1, 15.5, 19, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(227, 1, '748485800349', 8, '', 1, 23.75, 29, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(228, 1, '748485800431', 8, '', 1, 27.7, 33, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(229, 1, ' 748485801728', 8, '', 1, 17, 21, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(230, 1, '748485800738 ', 8, '', 1, 15.45, 19, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(231, 1, '748485100432', 8, '', 1, 21.4, 30, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(232, 1, '748485900032', 8, '', 1, 20.35, 25, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(233, 1, '748485900049', 8, '', 1, 20.35, 25, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(234, 1, '748485900056', 8, '', 1, 20.35, 25, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(235, 1, '748485900070', 8, '', 1, 20.35, 25, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(236, 1, '8851028000945', 8, '', 1, 21.5, 26, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(237, 1, '8851028000808', 8, '', 1, 21.5, 26, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(238, 1, '4800130300515', 8, '', 1, 23.45, 30, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(239, 1, '4800220503154', 8, '', 1, 80.16, 97, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(240, 1, '4800220503253', 8, '', 1, 40.41, 49, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(241, 1, '4800220503451', 8, '', 1, 29.9, 36, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(242, 1, '4800142110102', 8, '', 1, 110.75, 133, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(243, 1, '4800142110089', 8, '', 1, 81.5, 98, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(244, 1, '4800142110072', 8, '', 1, 57.2, 69, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(245, 1, '4807770271519', 8, '', 1, 21.25, 26, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(246, 1, '4807770272653', 8, '', 1, 19.5, 24, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(247, 1, '4800163008020', 8, '', 1, 12, 15, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(248, 1, '748485200026', 8, '', 1, 13.85, 17, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(249, 1, '748485200019', 8, '', 1, 13.6, 17, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(250, 1, '748485100401', 8, '', 1, 27.1, 33, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(251, 1, '748485100418', 8, '', 1, 27.1, 33, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(252, 1, '4806502350300', 8, '', 1, 6.35, 8, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(253, 1, '4902430583169', 8, '', 1, 9.97, 12, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(254, 1, '4902430583176', 8, '', 1, 9.97, 12, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(255, 1, '4902430583183', 8, '', 1, 9.97, 12, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(256, 1, '4800047840029', 8, '', 1, 17.4, 21, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(257, 1, '4800047840036', 8, '', 1, 11, 13, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(258, 1, '4800047840043', 8, '', 1, 6.85, 8, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(259, 1, '4800047841781', 8, '', 1, 10.25, 13, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(260, 1, '4902430453295', 8, '', 1, 4.53, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(261, 1, '4902430344876', 8, '', 1, 4.53, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(262, 1, '4902430587914', 8, '', 1, 8.16, 10, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(263, 1, '4902430611312', 8, '', 1, 8.16, 10, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(264, 1, '4902430587907', 8, '', 1, 8.16, 10, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(265, 1, '4902430258074', 8, '', 1, 8.16, 10, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(266, 1, '4800888151834', 8, '', 1, 4.41, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(267, 1, '4800888151827', 8, '', 1, 4.41, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(268, 1, '4800888183804', 8, '', 1, 4.41, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(269, 1, '4800888151841', 8, '', 1, 4.41, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(270, 1, '4806502726822', 7, '', 1, 32.7, 36, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(271, 1, '4806502720080', 7, '', 1, 33.6, 37, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(272, 1, '4806502726136', 7, '', 1, 43.6, 48, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(273, 1, '4806502720110', 7, '', 1, 18.6, 23, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(274, 1, '4800016677809', 4, '', 1, 9.07, 13, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(275, 1, '4800194116619', 8, '', 1, 4.45, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(276, 1, '4891208040143', 8, '', 1, 4.45, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(277, 1, '4800194104869', 8, '', 1, 4.45, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(278, 1, '4800194104968', 8, '', 1, 4.45, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(279, 1, '4800024570024', 8, '', 1, 22.15, 27, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(280, 1, '4800024570000', 8, '', 1, 22.15, 27, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(281, 1, '4800024571908', 8, '', 1, 22.15, 27, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(282, 1, '748485802138', 8, '', 1, 16.3, 19, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(283, 1, '748485802091', 8, '', 1, 16.3, 19, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(284, 1, '4800194116466', 8, '', 1, 6.55, 9, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(285, 1, '4800194152327', 8, '', 1, 6.55, 9, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(286, 1, '4800194153232', 8, '', 1, 4.55, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(287, 1, '748485802060', 8, '', 1, 16.3, 19, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(288, 1, '4800888139306', 8, '', 1, 5.25, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(289, 1, '4800888139276', 8, '', 1, 5.25, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(290, 1, '4800888139313', 8, '', 1, 5.25, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(291, 1, '4800888154262', 8, '', 1, 4.1, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(292, 1, '4800888180100', 8, '', 1, 5.25, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(293, 1, '4800888139283', 8, '', 1, 5.25, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(294, 1, '4800888169716', 8, '', 1, 4.2, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(295, 1, '4800888169693', 8, '', 1, 4.2, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(296, 1, '4902430522809', 8, '', 1, 5.05, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(297, 1, '4902430333597', 8, '', 1, 5.05, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(298, 1, '4902430698078', 8, '', 1, 4.53, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(299, 1, '4902430330718', 8, '', 1, 4.53, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(300, 1, '4902430698139', 8, '', 1, 4.53, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(301, 1, '4800888151704', 8, '', 1, 4.4, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(302, 1, '4800888141194', 8, '', 1, 4.4, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(303, 1, '4902430698658', 8, '', 1, 5.05, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(304, 1, '4800888169709', 8, '', 1, 4.2, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(305, 1, '4800888190185', 8, '', 1, 4.1, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(306, 1, '4800888179593', 8, '', 1, 4.1, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(307, 1, '4801668602027', 8, '', 1, 5.45, 8, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(308, 1, '4801668602225', 8, '', 1, 3.3, 5, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(309, 1, '4800344001949', 8, '', 1, 7.45, 9, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(310, 1, '4800344001963', 8, '', 1, 4.05, 5, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(311, 1, '4800344001925', 8, '', 1, 0.94, 1, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(312, 1, '4800344004926', 8, '', 1, 0.94, 1, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(313, 1, '8850006493878', 8, '', 1, 11.5, 15, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(314, 1, '9556031084126', 8, '', 1, 11.5, 15, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(315, 1, '4902430970525', 8, '', 1, 15.4, 19, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(316, 1, '748485200675', 8, '', 1, 23.3, 28, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(317, 1, '748485201061', 8, '', 1, 23.3, 28, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(318, 1, '748485200989', 8, '', 1, 23.3, 28, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(319, 1, '4800888136701', 8, '', 1, 4.62, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(320, 1, '4902430951357', 8, '', 1, 15.4, 19, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(321, 1, '4902430381772', 8, '', 1, 15.4, 19, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(322, 1, '4801668603659', 8, '', 1, 4, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(323, 1, '748485200132', 8, '', 1, 12.5, 16, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(324, 1, '4800047841712', 8, '', 1, 31.5, 38, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(325, 1, '4800047841729', 8, '', 1, 20.5, 25, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(326, 1, '4806506318955', 8, '', 1, 20.15, 24, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(327, 1, '4902430434393', 8, '', 1, 4.64, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(328, 1, '4902430389570', 8, '', 1, 4.64, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(329, 1, '4902430440080', 8, '', 1, 4.43, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(330, 1, '4902430623179', 8, '', 1, 4.43, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(331, 1, '4800112256151', 8, '', 1, 1.32, 2, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(332, 1, '4806011812269', 8, '', 1, 19.75, 24, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(333, 1, '4800024555489', 8, '', 1, 13.9, 17, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(334, 1, '4800017938107', 8, '', 1, 20.5, 25, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(335, 1, '4800017907707', 8, '', 1, 11.25, 14, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(336, 1, '4800888602725', 8, '', 1, 4.5, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(337, 1, '4800888602732', 8, '', 1, 4.5, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(338, 1, '4800888602718', 8, '', 1, 4.5, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(339, 1, '4891208040167', 8, '', 1, 4.45, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(340, 1, '4800194116084', 8, '', 1, 4.45, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(341, 1, '4800016084058', 4, '', 1, 3.77, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(342, 1, '323456789', 4, '', 1, 2.66, 4, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(343, 1, '423456789', 4, '', 1, 2.66, 4, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(344, 1, '523456789', 4, '', 1, 2.66, 4, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(345, 1, '4801234105815', 8, '', 1, 1.45, 4, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(346, 1, '4801032111025', 9, '', 1, 23, 28, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(347, 1, '4801032741048', 9, '', 1, 25.63, 30, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(348, 1, '4801032281056', 9, '', 1, 22.08, 26, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(349, 1, '4801032281049', 9, '', 1, 22.08, 26, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(350, 1, '4801032111131', 9, '', 1, 63.17, 74, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(351, 1, '4801032211138', 9, '', 1, 63.83, 74, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(352, 1, '4801032211077', 9, '', 1, 31.42, 37, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(353, 1, '623456789', 10, '', 1, 45.6, 51, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(354, 1, '723456789', 10, '', 1, 22.8, 25.5, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(355, 1, '823456789', 10, '', 1, 34.2, 38.25, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(356, 1, '923456789', 10, '', 1, 11.4, 12.75, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(357, 1, '102345678', 10, '', 1, 41, 44, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(358, 1, '112345678', 10, '', 1, 20.5, 23, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(359, 1, '122345678', 10, '', 1, 30.75, 34.5, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(360, 1, '132345678', 10, '', 1, 10.25, 11.5, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(361, 1, '142345678', 10, '', 1, 39, 44, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(362, 1, '152345678', 10, '', 1, 19.5, 22, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(363, 1, '162345678', 10, '', 1, 29.25, 33, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(364, 1, '172345678', 10, '', 1, 9.75, 11, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(365, 1, '182345678', 10, '', 1, 35.2, 39, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(366, 1, '192345678', 10, '', 1, 17.6, 19.5, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(367, 1, '202345678', 10, '', 1, 26.4, 29.25, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(368, 1, '212345678', 10, '', 1, 8.8, 9.75, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(369, 1, '242345678', 10, '', 1, 42.2, 64, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(370, 1, '252345678', 10, '', 1, 21.1, 32, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(371, 1, '262345678', 10, '', 1, 10.55, 16, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(372, 1, '272345678', 10, '', 1, 31.4, 52, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(373, 1, '282345678', 10, '', 1, 15.7, 26, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(374, 1, '292345678', 10, '', 1, 7.85, 13, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(375, 1, '748485400174', 5, '', 1, 5.65, 8, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(376, 1, '4800575884007', 8, '', 1, 50.35, 57, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(377, 1, '9557727929202', 8, '', 1, 28, 34, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(378, 1, '4800575130166', 8, '', 1, 25.75, 31, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(379, 1, '4800575883000', 8, '', 1, 32.75, 39, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(380, 1, '4800217051019', 8, '', 1, 22.3, 27, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(381, 1, '4800575883512', 8, '', 1, 31.25, 37, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(382, 1, '4800575884502', 8, '', 1, 26.1, 31, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(383, 1, '4800575130302', 8, '', 1, 39.5, 48, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(384, 1, '4800575140370', 8, '', 1, 24.45, 29, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(385, 1, '4800575140158', 8, '', 1, 10.7, 14, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(386, 1, '4800888151100', 8, '', 1, 6.75, 8, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(387, 1, '4800888160027', 8, '', 1, 6.75, 8, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(388, 1, '4809010431622', 8, '', 1, 1.12, 2, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(389, 1, '4801958334102', 8, '', 1, 4.18, 5, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(390, 1, '4801958153109', 8, '', 1, 1.66, 2, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(391, 1, '4800888158888', 8, '', 1, 6.75, 8, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(392, 1, '4809010431806', 8, '', 1, 1.2, 2, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(393, 1, '4809010431790', 8, '', 1, 1.68, 2, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(394, 1, '4800045310241', 8, '', 1, 19.1, 23, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(395, 1, '4800194153225', 8, '', 1, 4.55, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(396, 1, '4800194153683', 8, '', 1, 4.55, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(397, 1, '4800194104982', 8, '', 1, 4.45, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(398, 1, '4800602060503', 8, '', 1, 7.5, 10, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(399, 1, '4800602060251', 8, '', 1, 7.5, 10, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(400, 1, '4902430495066', 8, '', 1, 6.6, 9, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(401, 1, '4902430278119', 8, '', 1, 4.75, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(402, 1, '4800888190987', 8, '', 1, 5.33, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(403, 1, '4800888136787', 8, '', 1, 5.33, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(404, 1, '4800888136749', 8, '', 1, 4.62, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(405, 1, '842345678', 8, '', 1, 0.39, 1, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(406, 1, '322345678', 11, '', 1, 5.5, 8, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(407, 1, '332345678', 11, '', 1, 7.2, 9, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(408, 1, '342345678', 11, '', 1, 9, 12, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(409, 1, '352345678', 11, '', 1, 5.2, 8, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(410, 1, '362345678', 11, '', 1, 2.1, 4, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(411, 1, '382345678', 11, '', 1, 6, 8, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(412, 1, '392345678', 11, '', 1, 10.75, 14, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(413, 1, '402345678', 11, '', 1, 11, 13, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(414, 1, '522345678', 11, '', 1, 8.1, 10, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(415, 1, '532345678', 11, '', 1, 3.25, 5, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(416, 1, '542345678', 11, '', 1, 55.15, 66, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(417, 1, '562345678', 11, '', 1, 5.5, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(418, 1, '582345678', 11, '', 1, 7.25, 9, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(419, 1, '592345678', 11, '', 1, 11.75, 14, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(420, 1, '612345678', 11, '', 1, 26, 31, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(421, 1, '672345678', 11, '', 1, 9.65, 12, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(422, 1, '772345678', 11, '', 1, 4.75, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(423, 1, '802345678', 11, '', 1, 10.75, 13, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(424, 1, '812345678', 11, '', 1, 5.25, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(425, 1, '832345678', 11, '', 1, 5.8, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(426, 1, '4800016115257', 4, '', 1, 12.75, 18, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(427, 1, '4891208040181', 8, '', 1, 4.45, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(428, 1, '4902430401845', 8, '', 1, 4.53, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(429, 1, '4800488101314', 8, '', 1, 17.5, 24, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(430, 1, '4902430615174', 8, '', 1, 12.04, 15, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(431, 1, '8850007331261', 8, '', 1, 2.22, 3, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(432, 1, '748485200118', 8, '', 1, 13.15, 16, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(433, 1, '748485200101', 8, '', 1, 13.05, 16, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(434, 1, '4806508622029', 8, '', 1, 12.5, 16, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(435, 1, '4800163008013', 8, '', 1, 12.3, 15, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(436, 1, '4806508622005', 8, '', 1, 12.5, 16, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(437, 1, '4806504710119', 8, '', 1, 14.25, 18, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(438, 1, '4806504710126', 8, '', 1, 14.5, 18, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(439, 1, '4807770271342', 8, '', 1, 15.3, 20, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(440, 1, '4807770271168', 8, '', 1, 15.3, 20, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(441, 1, '4808647020162', 8, '', 1, 10.5, 13, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(442, 1, '4808647020094', 8, '', 1, 43.25, 52, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(443, 1, '4800066410128', 8, '', 1, 21.25, 27, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(444, 1, '4800047841705', 8, '', 1, 56.1, 67, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(445, 1, '4800047840012', 8, '', 1, 28.75, 35, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(446, 1, '4902430615419', 8, '', 1, 11.15, 14, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(447, 1, '4902430729925', 8, '', 1, 4.6, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(448, 1, '4902430729901', 8, '', 1, 4.6, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(449, 1, '4902430178228', 8, '', 1, 10.65, 13, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(450, 1, '4902430177597', 8, '', 1, 10.65, 13, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(451, 1, '4902430346177', 8, '', 1, 6.75, 8, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(452, 1, '4902430452694', 8, '', 1, 6.75, 8, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(453, 1, '4800888189806', 8, '', 1, 4.41, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(454, 1, '4801958460009', 8, '', 1, 8.25, 10, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(455, 1, '4800045310272', 8, '', 1, 34.25, 41, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(456, 1, '4800045310159', 8, '', 1, 34.25, 41, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(457, 1, '4801958390108', 8, '', 1, 13.4, 16, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(458, 1, '4800575883505', 8, '', 1, 48.6, 58, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(459, 1, '4806014001196', 8, '', 1, 28.5, 34, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(460, 1, '4800888154439', 8, '', 1, 5.25, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(461, 1, '4800488011415', 8, '', 1, 15, 21, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(462, 1, '4806515986619', 8, '', 1, 7, 10, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(463, 1, '48031813', 8, '', 1, 6.4, 8, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(464, 1, '4800888154422', 8, '', 1, 5.25, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(465, 1, '4800888154415', 8, '', 1, 5.25, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(466, 1, '4800888179630', 8, '', 1, 5.25, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(467, 1, '748485200125', 8, '', 1, 11, 16, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(468, 1, '4806507832214', 8, '', 1, 17.5, 21, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(469, 1, '7622300559991', 8, '', 1, 8.95, 11, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(470, 1, '4800602060237', 8, '', 1, 7.5, 10, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(471, 1, '4808680651019', 8, '', 1, 27.5, 34, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(472, 1, '4808680651002', 8, '', 1, 27.5, 34, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(473, 1, '4808680021355', 8, '', 1, 26.5, 32, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(474, 1, '7622300312039', 8, '', 1, 5.85, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(475, 1, '4808647010149', 8, '', 1, 5.85, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(476, 1, '8992222052467', 8, '', 1, 3.75, 5, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(477, 1, '4902806015553', 8, '', 1, 3.75, 5, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(478, 1, '4800888154279', 8, '', 1, 4.1, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(479, 1, '014285003250', 8, '', 1, 14.2, 21, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(480, 1, '4800066410609', 8, '', 1, 14, 17, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(481, 1, '4806013001067', 8, '', 1, 1.35, 2, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(482, 1, '014285003908', 8, '', 1, 2.32, 3, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(483, 1, '4807770272646', 8, '', 1, 32.5, 40, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(484, 1, '9556031084133', 8, '', 1, 11.5, 15, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(485, 1, '8850006492291', 8, '', 1, 11.5, 15, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(486, 1, '4806014092835', 8, '', 1, 13.5, 17, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(487, 1, '4902430389549', 8, '', 1, 4.64, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(488, 1, '942345678', 8, '', 1, 1.32, 2, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(489, 1, '4806506318849', 8, '', 1, 20.15, 24, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(490, 1, '4800488011484', 8, '', 1, 15, 21, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(491, 1, '48032025', 8, '', 1, 1.62, 3, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(492, 1, '4800086035943', 12, '', 1, 222.72, 255, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(493, 1, '4800086040909', 12, '', 1, 113.63, 135, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(494, 1, '4800086040879', 12, '', 1, 113.63, 135, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(495, 1, '4800086043917', 12, '', 1, 113.63, 135, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(496, 1, '4800086043979', 12, '', 1, 113.63, 135, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(497, 1, '4800086043504', 12, '', 1, 90, 110, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(498, 1, '4800086040688', 12, '', 1, 113.63, 135, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(499, 1, '4800086043375', 12, '', 1, 113.63, 135, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(500, 1, '4800086043399', 12, '', 1, 113.63, 135, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(501, 1, '4800086043610', 12, '', 1, 80.9, 95, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(502, 1, '4800086043641', 12, '', 1, 80.9, 95, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(503, 1, '4800086043634', 12, '', 1, 80.9, 95, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(504, 1, '4800086040527', 12, '', 1, 90, 110, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(505, 1, '4800086035967', 12, '', 1, 222.72, 255, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(506, 1, '4800086042293', 12, '', 1, 222.72, 255, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(507, 1, '4800086036049', 12, '', 1, 209.1, 230, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(508, 1, '4800086043344', 12, '', 1, 222.72, 255, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(509, 1, '4800086039149`', 12, '', 1, 309.09, 350, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(510, 1, '4800086036179', 12, '', 1, 399.99, 450, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(511, 1, '4800086036209', 12, '', 1, 222.72, 255, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(512, 1, '4800086036162', 12, '', 1, 222.72, 255, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(513, 1, '4800086043887', 12, '', 1, 222.72, 255, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(514, 1, '4800086036094', 12, '', 1, 209.1, 230, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(515, 1, '4800086043009', 12, '', 1, 209.1, 240, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(516, 1, '4800086035929', 12, '', 1, 222.72, 255, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(517, 1, '4800086036025', 12, '', 1, 209.1, 230, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(518, 1, '4800086043924', 12, '', 1, 222.72, 255, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(519, 1, '4800086035905', 12, '', 1, 222, 255, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(520, 1, '4800086043382', 12, '', 1, 222.72, 255, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(521, 1, '4800086036001', 12, '', 1, 209.1, 230, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(522, 1, '6921738085289', 13, '', 1, 9, 15, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(523, 1, '026000223720', 13, '', 1, 39, 48, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(524, 1, '8801038200019', 13, '', 1, 2.2, 5, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(525, 1, '4806524271126', 13, '', 1, 15, 22, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(526, 1, '4806524271034', 13, '', 1, 12, 22, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(527, 1, '4806508030510', 13, '', 1, 7, 12, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(528, 1, '4806508030497', 13, '', 1, 7, 12, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(529, 1, '4806508030480', 13, '', 1, 7, 12, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(530, 1, '992345678', 13, '', 1, 0.32, 2, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(531, 1, '100234567', 13, '', 1, 0.27, 1, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(532, 1, '109234567', 13, '', 1, 1.4, 4, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(533, 1, '110234567', 13, '', 1, 1.3, 3, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16');
INSERT INTO `product_history` (`product_history_id`, `branch_id`, `product_code`, `supplier_id`, `cp_number`, `account_id`, `supplier_price`, `selling_price`, `product_stock`, `product_sold`, `total_cost`, `tendered_amount`, `expiration_date`, `history_date`) VALUES
(534, 1, '101234567', 13, '', 1, 3, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(535, 1, '104234567', 13, '', 1, 4.5, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(536, 1, '105234567', 13, '', 1, 6, 8, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(537, 1, '106234567', 13, '', 1, 5.5, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(538, 1, '107234567', 13, '', 1, 2.5, 5, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(539, 1, '108234567', 13, '', 1, 3.75, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(540, 1, '111234567', 13, '', 1, 6, 7, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(541, 1, '112234567', 13, '', 1, 5.5, 6, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(542, 1, '113234567', 13, '', 1, 1, 2, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(543, 1, '114234567', 13, '', 1, 0.04, 2, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16'),
(544, 1, '115234567', 13, '', 1, 2.5, 5, 1, 0, 0, 0, '0000-00-00', '2017-05-19 19:49:16');

-- --------------------------------------------------------

--
-- Table structure for table `provinces`
--

CREATE TABLE `provinces` (
  `province_id` int(11) NOT NULL,
  `province` varchar(100) DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `provinces`
--

INSERT INTO `provinces` (`province_id`, `province`, `country_id`) VALUES
(1, 'Aklan', 1),
(2, 'Antique', 1),
(3, 'Capiz', 1),
(4, 'Iloilo', 1),
(5, 'Guimaras', 1),
(6, 'Negros Occidental', 1),
(7, 'Negros Oriental', 1),
(8, 'Cebu', 1),
(9, 'Bohol', 1),
(10, 'Siquijor', 1),
(11, 'Northern Samar', 1),
(12, 'Samar', 1),
(13, 'Eastern Samar', 1),
(14, 'Biliran', 1),
(15, 'Leyte', 1),
(16, 'Southern Leyte', 1);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `sales_id` bigint(17) NOT NULL,
  `branch_id` int(11) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  `sale_date` datetime DEFAULT NULL,
  `sold` double DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `owner_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `supplier_id` int(11) NOT NULL,
  `supplier_name` varchar(150) NOT NULL,
  `supplier_address` varchar(150) NOT NULL,
  `supplier_contact` varchar(100) NOT NULL,
  `supplier_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`supplier_id`, `supplier_name`, `supplier_address`, `supplier_contact`, `supplier_date`) VALUES
(1, 'Nestle', 'Vevey, Switzerland', '1800 10 063 7853', '2017-03-28'),
(2, 'Vanson', ' ', ' ', '2017-03-29'),
(3, 'Robinson', ' ', ' ', '2017-03-29'),
(4, ' ', ' ', ' ', '2017-04-07'),
(5, 'Amru Trading', ' ', ' ', '2017-04-08'),
(6, 'Semigi Corporation', ' ', ' ', '2017-04-13'),
(7, 'Negros Longlife Corp.', ' ', ' ', '2017-04-13'),
(8, 'Philippine Spring Water Resources, Inc.', ' ', ' ', '2017-04-13'),
(9, 'Southern Mindanao Enterprises', ' ', ' ', '2017-04-24'),
(10, 'Island merchants corporation', ' ', ' ', '2017-04-26'),
(11, '1', ' ', ' ', '2017-04-26'),
(12, 'PD 888 Distributors Inc.', ' ', ' ', '2017-04-26');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transaction_id` bigint(20) NOT NULL,
  `transaction_basket` text NOT NULL,
  `transaction_branch_id` int(11) NOT NULL,
  `transaction_account_id` int(11) NOT NULL,
  `transaction_amount` float DEFAULT NULL,
  `transaction_subtotal` double NOT NULL,
  `transaction_total` double NOT NULL,
  `transaction_total_product` double NOT NULL,
  `transaction_tax` double NOT NULL,
  `transaction_discount` double NOT NULL,
  `transaction_change` double NOT NULL,
  `transaction_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`transaction_id`, `transaction_basket`, `transaction_branch_id`, `transaction_account_id`, `transaction_amount`, `transaction_subtotal`, `transaction_total`, `transaction_total_product`, `transaction_tax`, `transaction_discount`, `transaction_change`, `transaction_date`) VALUES
(1, '', 0, 0, NULL, 0, 0, 0, 0, 0, 0, '2017-05-18 00:00:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`account_id`);

--
-- Indexes for table `account_logs`
--
ALTER TABLE `account_logs`
  ADD PRIMARY KEY (`account_logs_id`);

--
-- Indexes for table `account_types`
--
ALTER TABLE `account_types`
  ADD PRIMARY KEY (`account_type_id`);

--
-- Indexes for table `barangay`
--
ALTER TABLE `barangay`
  ADD PRIMARY KEY (`barangay_id`);

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`branch_id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `cities`
--
ALTER TABLE `cities`
  ADD PRIMARY KEY (`city_id`);

--
-- Indexes for table `load_central`
--
ALTER TABLE `load_central`
  ADD PRIMARY KEY (`load_central_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `product_history`
--
ALTER TABLE `product_history`
  ADD PRIMARY KEY (`product_history_id`);

--
-- Indexes for table `provinces`
--
ALTER TABLE `provinces`
  ADD PRIMARY KEY (`province_id`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`sales_id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`supplier_id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transaction_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accounts`
--
ALTER TABLE `accounts`
  MODIFY `account_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
--
-- AUTO_INCREMENT for table `account_logs`
--
ALTER TABLE `account_logs`
  MODIFY `account_logs_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `account_types`
--
ALTER TABLE `account_types`
  MODIFY `account_type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `barangay`
--
ALTER TABLE `barangay`
  MODIFY `barangay_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=110;
--
-- AUTO_INCREMENT for table `branch`
--
ALTER TABLE `branch`
  MODIFY `branch_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `cities`
--
ALTER TABLE `cities`
  MODIFY `city_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `load_central`
--
ALTER TABLE `load_central`
  MODIFY `load_central_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=544;
--
-- AUTO_INCREMENT for table `product_history`
--
ALTER TABLE `product_history`
  MODIFY `product_history_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=545;
--
-- AUTO_INCREMENT for table `provinces`
--
ALTER TABLE `provinces`
  MODIFY `province_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `supplier_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `transaction_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
