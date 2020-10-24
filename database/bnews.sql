-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th7 18, 2020 lúc 11:46 AM
-- Phiên bản máy phục vụ: 10.1.32-MariaDB
-- Phiên bản PHP: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `bnews`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'Tin mới'),
(2, 'Tin trong nước'),
(3, 'Tin thời sự');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `news`
--

CREATE TABLE `news` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  `detail` text COLLATE utf8_unicode_ci NOT NULL,
  `id_cat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `news`
--

INSERT INTO `news` (`id`, `name`, `description`, `detail`, `id_cat`) VALUES
(1, 'Việt Nam siêu cường', 'Sau đây là nhưng thông tin cập nhật mới nhất về Việt Nam - Siêu Cường Quốc Thế Giới!', 'Sau đây là nhưng thông tin cập nhật mới nhất về Việt Nam - Siêu Cường Quốc Thế Giới!\r\nSau đây là nhưng thông tin cập nhật mới nhất về Việt Nam - Siêu Cường Quốc Thế Giới!', 2),
(2, 'Tin kinh tế:', 'Thị trường thế giới trở nên hỗn loạn sau khi VND mất giá, giới đánh giá lo ngại sẽ xảy ra suy thoái kinh tế', 'Thị trường thế giới trở nên hỗn loạn sau khi VND mất giá, giới đánh giá lo ngại sẽ xảy ra suy thoái kinh tế\r\nThị trường thế giới trở nên hỗn loạn sau khi VND mất giá, giới đánh giá lo ngại sẽ xảy ra suy thoái kinh tế', 2),
(3, 'Tin xã hội:', 'Hà Nội vừa được công nhận là thành phố sạch nhất thế giới,vượt lên Singapore và Paris', 'Hôm qua, trên bầu trời Ngã Tư Sở, đã xảy ra một vụ va chạm trực thăng nghiêm trọng do một chiếc Phản lực khác đi lấn vào đường bay của trực thăng, rất may không có thiệt hại về người do các phi công đã nhảy dù và cả 3 chiếc máy bay đều rơi vào xe chở rác đang kẹt phía dưới\r\nĐể hạn chế lượng trực thăng vào thành phố, sở GTVT HN quyết định trực thăng chẵn bay ngày chẵn, và trực thăng số hiệu lẻ bay ngày lẻ, đồng thời thu phí với trực thăng ngoại thành bay vào thành phố', 1),
(4, 'Tin quốc phòng:', 'Trung Quốc lên tiếng vì việc tàu đánh cá của ngư dân Việt Nam đâm chìm tàu chiến TQ', 'Quân đội VN đứng hàng nhất thế giới, Hải quân VN nắm tất cả việc lưu thông trên biển, chỉ cần nhìn ra là thấy tàu chiến 10000 tấn của VN lưu trú, HQ VN có các hạm đội như Biển Đông, Hoàng Hải, Hoa Đông, Thái Bình Dương, Ấn Độ Dương, Bắc Băng Dương, Đại Tây Dương,...', 3);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_cat` (`id_cat`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `news`
--
ALTER TABLE `news`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `news`
--
ALTER TABLE `news`
  ADD CONSTRAINT `news_ibfk_1` FOREIGN KEY (`id_cat`) REFERENCES `category` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
