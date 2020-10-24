-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 26, 2018 lúc 02:35 PM
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
-- Cơ sở dữ liệu: `myfriends`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `contact`
--

CREATE TABLE `contact` (
  `id_contact` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `content` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `contact`
--

INSERT INTO `contact` (`id_contact`, `name`, `email`, `phone`, `content`) VALUES
(1, 'Nguyễn Văn Tèo', 'teo@vinaenter.edu.vn', '0981.234.56', 'Nội dung liên hệ 1'),
(2, 'Trần Thị Diệu Thảo', 'teo@vinaenter.edu.vn', '0981.234.56', 'Nội dung liên hệ 2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `friends`
--

CREATE TABLE `friends` (
  `fid` int(11) NOT NULL,
  `fname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `preview` text COLLATE utf8_unicode_ci NOT NULL,
  `detail` text COLLATE utf8_unicode_ci NOT NULL,
  `date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fl_id` int(11) NOT NULL,
  `count_number` int(11) NOT NULL,
  `picture` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `friends`
--

INSERT INTO `friends` (`fid`, `fname`, `preview`, `detail`, `date_create`, `fl_id`, `count_number`, `picture`) VALUES
(1, 'Nguyễn Văn Tèo', 'Bạn thân vẫn chia sẻ, trò chuyện trước...', 'Tôi và thằng bạn thân vẫn chia sẻ, trò chuyện trước những tin vịt đã truyền qua lớp khác. hôm trước, sẵn sàng đâm va vào tàu Việt Nam.', '2018-12-26 13:26:56', 1, 20, 'anh1.jpg'),
(2, 'Trần Thị Diệu Thảo', 'Tôi và thằng bạn thân vẫn chia sẻ, trò chuyện...', 'Tôi và thằng bạn thân vẫn chia sẻ, trò chuyện trước những tin vịt đã truyền qua lớp khác. hôm trước, sẵn sàng đâm va vào tàu Việt Nam.', '2018-12-26 13:27:08', 1, 10, 'anh2.jpg'),
(3, 'Trần Việt Anh', 'Tôi và thằng bạn thân vẫn chia sẻ, trò chuyện trước', 'Tôi và thằng bạn thân vẫn chia sẻ, trò chuyện trước những tin vịt đã truyền qua lớp khác. hôm trước, sẵn sàng đâm va vào tàu Việt Nam.', '2018-12-26 13:27:14', 2, 1, 'anh3.jpg'),
(4, 'Nguyễn Xuân Thành', 'Trò chuyện trước những tin vịt đã truyền qua lớp khác', 'Tôi và thằng bạn thân vẫn chia sẻ, trò chuyện trước những tin vịt đã truyền qua lớp khác. hôm trước, sẵn sàng đâm va vào tàu Việt Nam.', '2018-12-26 13:27:19', 4, 2, 'anh4.jpg'),
(5, 'Trần Thị Mỹ Hạ', 'Trước những tin vịt đã truyền qua lớp khác', 'Tôi và thằng bạn thân vẫn chia sẻ, trò chuyện trước những tin vịt đã truyền qua lớp khác. hôm trước, sẵn sàng đâm va vào tàu Việt Nam.', '2018-12-26 13:27:25', 3, 1, 'anh5.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `friend_list`
--

CREATE TABLE `friend_list` (
  `fl_id` int(11) NOT NULL,
  `fl_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `friend_list`
--

INSERT INTO `friend_list` (`fl_id`, `fl_name`) VALUES
(1, 'Bạn quen thời phổ thông'),
(2, 'Bạn quen thời đại học'),
(3, 'Bạn tâm giao'),
(4, 'Bạn tri kỷ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fullname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `fullname`) VALUES
(1, 'admin', 'v123456', 'VinaEnter Edu'),
(2, 'administrator', 'v123456', 'VNE Trainer'),
(3, 'mod', 'vne123', 'VNE Mod'),
(4, 'supermod', 'abc123', 'VNE Super Mod'),
(5, 'mod', 'Mne2468', 'VNE Mod');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`id_contact`);

--
-- Chỉ mục cho bảng `friends`
--
ALTER TABLE `friends`
  ADD PRIMARY KEY (`fid`,`fl_id`);

--
-- Chỉ mục cho bảng `friend_list`
--
ALTER TABLE `friend_list`
  ADD PRIMARY KEY (`fl_id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `contact`
--
ALTER TABLE `contact`
  MODIFY `id_contact` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `friends`
--
ALTER TABLE `friends`
  MODIFY `fid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `friend_list`
--
ALTER TABLE `friend_list`
  MODIFY `fl_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
