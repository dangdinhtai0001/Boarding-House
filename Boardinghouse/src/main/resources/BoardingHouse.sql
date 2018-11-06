-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 06, 2018 lúc 11:11 AM
-- Phiên bản máy phục vụ: 10.1.34-MariaDB
-- Phiên bản PHP: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `boardinghouse`
--
CREATE DATABASE IF NOT EXISTS `boardinghouse` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci;
USE `boardinghouse`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `app_role`
--

DROP TABLE IF EXISTS `app_role`;
CREATE TABLE IF NOT EXISTS `app_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `app_role`:
--

--
-- Đang đổ dữ liệu cho bảng `app_role`
--

INSERT INTO `app_role` (`id`, `name`) VALUES
(1, 'GUEST'),
(2, 'MEMBER'),
(3, 'ADMIN');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `app_user`
--

DROP TABLE IF EXISTS `app_user`;
CREATE TABLE IF NOT EXISTS `app_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `app_user`:
--

--
-- Đang đổ dữ liệu cho bảng `app_user`
--

INSERT INTO `app_user` (`id`, `username`, `password`, `enabled`) VALUES
(2, 'dbadmin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1),
(3, 'dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1),
(4, 'sena', '$2a$04$Q2Cq0k57zf2Vs/n3JXwzmerql9RzElr.J7aQd3/Sq0fw/BdDFPAj.', 1),
(5, 'kai', '$2a$04$Q2Cq0k57zf2Vs/n3JXwzmerql9RzElr.J7aQd3/Sq0fw/BdDFPAj.', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `contract`
--

DROP TABLE IF EXISTS `contract`;
CREATE TABLE IF NOT EXISTS `contract` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerID` int(11) NOT NULL,
  `roomID` int(11) NOT NULL,
  `serviceID` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `duration` int(11) NOT NULL DEFAULT '12',
  `payCycle` int(11) NOT NULL DEFAULT '1',
  `deposit` double NOT NULL DEFAULT '0',
  `start` date NOT NULL,
  `end` date NOT NULL,
  `description` text COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`id`),
  KEY `customerID` (`customerID`,`roomID`,`serviceID`),
  KEY `roomID` (`roomID`),
  KEY `serviceID` (`serviceID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `contract`:
--   `roomID`
--       `room` -> `id`
--   `serviceID`
--       `service` -> `id`
--

--
-- Đang đổ dữ liệu cho bảng `contract`
--

INSERT INTO `contract` (`id`, `customerID`, `roomID`, `serviceID`, `type`, `duration`, `payCycle`, `deposit`, `start`, `end`, `description`) VALUES
(1, 1, 3, 5, 0, 1, 1, 500000, '2018-11-01', '2018-12-01', 'đã thanh toán'),
(2, 4, 3, 6, 0, 1, 1, 0, '2018-11-01', '2018-12-01', 'đã thu'),
(3, 5, 2, 1, 0, 1, 1, 0, '2018-11-02', '2018-12-03', 'còn nợ 15000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gender` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dateOfBirth` date NOT NULL,
  `identityNumber` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phoneNumber` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mail` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `facebook` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` text COLLATE utf8mb4_unicode_ci,
  `isStudent` tinyint(1) NOT NULL DEFAULT '1',
  `declarationOfTemporaryResidence` tinyint(1) NOT NULL DEFAULT '0',
  `company` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `image` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `customer`:
--

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`id`, `name`, `gender`, `dateOfBirth`, `identityNumber`, `phoneNumber`, `mail`, `facebook`, `description`, `isStudent`, `declarationOfTemporaryResidence`, `company`, `image`) VALUES
(1, 'Nguyễn Thị Kiều Trang', 'Nữ', '1998-05-03', '123456789', '01657589900', 'nguyentrangxinhgai@gmail.com', 'https://www.facebook.com/son.trang.7140', NULL, 1, 1, '', ''),
(2, 'Nguyễn Thị Hà 1', 'Nữ', '1995-11-11', '122456789', '01234567890', 'nguyenhaxaugai@gmail.com', 'https://www.facebook.com/profile.php?id=100012640873151', 'Tầng 2', 0, 0, 'Công ty cổ phần Công nghệ Simax', ''),
(3, 'Vũ Hữu Sơn', 'Nam', '1998-05-06', '156789123', '01665872303', 'vuhuusonvohinh@gmail.com', 'https://www.facebook.com/vhson97', '', 1, 0, '', ''),
(4, 'Đặng Đình Tài ', 'Nam', '1998-12-12', '111222333', '01665389123', 'dangdinhtaixauxi@gmail.com.vn', 'https://www.facebook.com/dinhtai.dang.7', '', 1, 1, '', ''),
(5, 'Nguyễn Thị Hà 2', 'Nữ', '1997-10-25', '168618456', '01672924567', 'hayeuhung@gmail.com', '', 'Tầng 5', 1, 1, '', '');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `device`
--

DROP TABLE IF EXISTS `device`;
CREATE TABLE IF NOT EXISTS `device` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roomID` int(11) NOT NULL,
  `unitID` int(11) NOT NULL,
  `name` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `amount` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `compensatory` int(11) NOT NULL,
  `description` text COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`id`),
  KEY `roomID` (`roomID`),
  KEY `unitID` (`unitID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `device`:
--   `roomID`
--       `room` -> `id`
--   `unitID`
--       `unit` -> `id`
--

--
-- Đang đổ dữ liệu cho bảng `device`
--

INSERT INTO `device` (`id`, `roomID`, `unitID`, `name`, `amount`, `price`, `compensatory`, `description`) VALUES
(1, 1, 1, 'Giường', 1, 700000, 100000, 'Nếu làm hỏng, người thuê chịu hoàn toàn chi phí sửa chữa'),
(2, 3, 1, 'Điều hòa', 1, 4000000, 500000, 'Nếu làm hỏng, người thuê chịu hoàn toàn chi phí sửa chữa'),
(3, 3, 1, 'Nóng lạnh', 1, 300000, 500000, 'Nếu làm hỏng, người thuê chịu hoàn toàn chi phí sửa chữa'),
(4, 4, 1, 'Nóng lạnh', 1, 3000000, 500000, 'Nếu làm hỏng, người thuê chịu hoàn toàn chi phí sửa chữa');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `error`
--

DROP TABLE IF EXISTS `error`;
CREATE TABLE IF NOT EXISTS `error` (
  `id` varchar(16) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `name` varchar(256) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `description` text COLLATE utf8mb4_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- RELATIONSHIPS FOR TABLE `error`:
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `home`
--

DROP TABLE IF EXISTS `home`;
CREATE TABLE IF NOT EXISTS `home` (
  `name` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phoneNumber` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dateOfBirth` date NOT NULL,
  `gender` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `home`:
--

--
-- Đang đổ dữ liệu cho bảng `home`
--

INSERT INTO `home` (`name`, `phoneNumber`, `dateOfBirth`, `gender`, `address`, `email`) VALUES
('Nguyễn Thị Lan', '01657589900', '1998-05-03', 'Nữ', 'Hà Nội', 'lannguyen1212@gmail.com.vn'),
('Phạm Văn Mạnh', '01234567890', '1995-01-16', 'Nam', 'Thanh Hóa', 'manhpham1601@gmail.com'),
('Phan Văn Tùng', '01665342678', '1998-09-15', 'Nam', 'Nghệ An', 'tungphan@gmail.com'),
('Trần Thảo Nguyên', '01673467878', '1992-09-09', 'Nữ', 'Vĩnh Phúc', 'nguyennguyen@gmail.com'),
('Lê Văn Long', '01672924567', '1997-10-18', 'Nam', 'Hòa Bình', 'dragonball@gmail.com.vn');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `room`
--

DROP TABLE IF EXISTS `room`;
CREATE TABLE IF NOT EXISTS `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `recommend` int(11) NOT NULL,
  `floor` int(11) NOT NULL,
  `price` double NOT NULL,
  `description` text COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `room`:
--

--
-- Đang đổ dữ liệu cho bảng `room`
--

INSERT INTO `room` (`id`, `name`, `status`, `recommend`, `floor`, `price`, `description`) VALUES
(1, 'R101', 'Trống', 3, 3, 1500000, '15m2, vệ sinh khép kín'),
(2, 'R102', 'Đã thuê', 2, 2, 1400000, '15m2, vệ sinh khép kín'),
(3, 'R103', 'Đã thuê', 3, 3, 2000000, '17m2, vệ sinh khép kín, có điều hòa nóng lạnh'),
(4, 'R104', 'Trống', 1, 5, 1200000, '12m2, vệ sinh khép kín, có nóng lạnh'),
(5, 'R105', 'Trống', 4, 2, 2500000, '30m2, vệ sinh khép kín, có nóng lạnh, điều hòa');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `room_rental`
--

DROP TABLE IF EXISTS `room_rental`;
CREATE TABLE IF NOT EXISTS `room_rental` (
  `customerID` int(11) NOT NULL,
  `roomID` int(11) NOT NULL,
  `representative` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`customerID`,`roomID`),
  KEY `roomID` (`roomID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `room_rental`:
--   `roomID`
--       `room` -> `id`
--   `customerID`
--       `customer` -> `id`
--

--
-- Đang đổ dữ liệu cho bảng `room_rental`
--

INSERT INTO `room_rental` (`customerID`, `roomID`, `representative`) VALUES
(1, 3, 0),
(4, 3, 0),
(5, 2, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `service`
--

DROP TABLE IF EXISTS `service`;
CREATE TABLE IF NOT EXISTS `service` (
  `id` int(11) NOT NULL,
  `name` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` text COLLATE utf8mb4_unicode_ci,
  `status` int(11) NOT NULL,
  `isDefault` tinyint(1) NOT NULL,
  `price` double NOT NULL,
  `duration` int(11) NOT NULL DEFAULT '1',
  `unitID` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `unitID` (`unitID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `service`:
--   `unitID`
--       `unit` -> `id`
--

--
-- Đang đổ dữ liệu cho bảng `service`
--

INSERT INTO `service` (`id`, `name`, `description`, `status`, `isDefault`, `price`, `duration`, `unitID`) VALUES
(1, 'xe máy', 'dịch vụ trông xe ', 80, 1, 100000, 1, 1),
(2, 'điều hòa', 'bảo dưỡng và lắp đặt điều hòa ', 40, 1, 5000000, 1, 1),
(3, 'điện', 'phục vụ điện cho các phòng', 1, 1, 4000, 1, 3),
(4, 'nước', 'phục vụ nước cho các phòng', 1, 1, 25000, 1, 2),
(5, 'dịch vụ internet', 'thu theo phòng', 1, 1, 100000, 1, 4),
(6, 'dịch vụ vệ sinh', 'thu theo phòng', 1, 1, 50000, 1, 4),
(7, 'bảo dưỡng và lắp đặt nóng lạnh', 'lặp đặt cho các phòng có nhu cầu ', 1, 1, 4000000, 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `service_rental`
--

DROP TABLE IF EXISTS `service_rental`;
CREATE TABLE IF NOT EXISTS `service_rental` (
  `serviceID` int(11) NOT NULL,
  `roomID` int(11) NOT NULL,
  PRIMARY KEY (`serviceID`,`roomID`),
  KEY `roomID` (`roomID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `service_rental`:
--   `roomID`
--       `room` -> `id`
--   `serviceID`
--       `service` -> `id`
--

--
-- Đang đổ dữ liệu cho bảng `service_rental`
--

INSERT INTO `service_rental` (`serviceID`, `roomID`) VALUES
(1, 3),
(3, 2),
(3, 3),
(4, 2),
(4, 3),
(5, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `unit`
--

DROP TABLE IF EXISTS `unit`;
CREATE TABLE IF NOT EXISTS `unit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` text COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `unit`:
--

--
-- Đang đổ dữ liệu cho bảng `unit`
--

INSERT INTO `unit` (`id`, `name`, `description`) VALUES
(1, 'chiếc', NULL),
(2, 'khối', 'đo lượng nước của mỗi phòng'),
(3, 'số', 'đo số điện của các phòng'),
(4, '/phòng', 'thu tiền theo phòng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `roleId_2` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `user_role`:
--   `role_id`
--       `app_role` -> `id`
--   `user_id`
--       `app_user` -> `id`
--

--
-- Đang đổ dữ liệu cho bảng `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(2, 3),
(3, 2),
(4, 2),
(5, 3);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `contract`
--
ALTER TABLE `contract`
  ADD CONSTRAINT `contract_ibfk_2` FOREIGN KEY (`roomID`) REFERENCES `room` (`id`),
  ADD CONSTRAINT `contract_ibfk_3` FOREIGN KEY (`serviceID`) REFERENCES `service` (`id`);

--
-- Các ràng buộc cho bảng `device`
--
ALTER TABLE `device`
  ADD CONSTRAINT `device_ibfk_1` FOREIGN KEY (`roomID`) REFERENCES `room` (`id`),
  ADD CONSTRAINT `device_ibfk_2` FOREIGN KEY (`unitID`) REFERENCES `unit` (`id`);

--
-- Các ràng buộc cho bảng `room_rental`
--
ALTER TABLE `room_rental`
  ADD CONSTRAINT `room_rental_ibfk_1` FOREIGN KEY (`roomID`) REFERENCES `room` (`id`),
  ADD CONSTRAINT `room_rental_ibfk_2` FOREIGN KEY (`customerID`) REFERENCES `customer` (`id`);

--
-- Các ràng buộc cho bảng `service`
--
ALTER TABLE `service`
  ADD CONSTRAINT `service_ibfk_1` FOREIGN KEY (`unitID`) REFERENCES `unit` (`id`);

--
-- Các ràng buộc cho bảng `service_rental`
--
ALTER TABLE `service_rental`
  ADD CONSTRAINT `service_rental_ibfk_1` FOREIGN KEY (`roomID`) REFERENCES `room` (`id`),
  ADD CONSTRAINT `service_rental_ibfk_2` FOREIGN KEY (`serviceID`) REFERENCES `service` (`id`);

--
-- Các ràng buộc cho bảng `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `app_role` (`id`),
  ADD CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
