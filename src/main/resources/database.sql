-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 25 Maj 2019, 12:56
-- Wersja serwera: 10.1.37-MariaDB
-- Wersja PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `wypożyczalnia filmów`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `actor`
--

CREATE TABLE `actor` (
  `id_actor` int(11) NOT NULL,
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `surname` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `yob` varchar(4) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `actor`
--

INSERT INTO `actor` (`id_actor`, `name`, `surname`, `yob`) VALUES
(1, 'Bogusław', 'Linda', '1952'),
(2, 'Cezary', 'Pazura', '1962'),
(3, 'Radosław', 'Pazura', '1969'),
(4, 'Samuel L.', 'Jackson', '1948'),
(5, 'Robert', 'Downey', '1965'),
(6, 'Daniel', 'Craig', '1968'),
(7, 'Penelope', 'Cruz', '1974'),
(8, 'Demi', 'Moore', '1962'),
(9, 'Roger', 'Moore', '1927'),
(10, 'Pierce', 'Brosnan', '1953'),
(11, 'Keanu', 'Reeves', '1964'),
(12, 'Denzel', 'Washington', '1954'),
(13, 'Lena', 'Headey', '1973'),
(14, 'Emilia', 'Clarke', '1986'),
(15, 'Sophie', 'Turner', '1996'),
(16, 'Gal', 'Gadot', '1985'),
(17, 'Vin', 'Diesel', '1967'),
(18, 'Scarlett', 'Johansson', '1984'),
(19, 'Gwyneth', 'Paltrow', '1972'),
(20, 'Emily', 'Blunt', '1983');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `age_category`
--

CREATE TABLE `age_category` (
  `kind` varchar(40) DEFAULT NULL,
  `id_film` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `age_category`
--

INSERT INTO `age_category` (`kind`, `id_film`) VALUES
('13+', 5),
('13+', 6),
('13+', 7),
('16+', 8),
('16+', 9),
('16+', 10),
('16+', 11),
('14+', 12),
('16+', 14),
('16+', 15);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `award`
--

CREATE TABLE `award` (
  `id_award` int(11) NOT NULL,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_film` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `award`
--

INSERT INTO `award` (`id_award`, `name`, `id_film`) VALUES
(2, 'Złoty Popcorn', 5),
(3, 'Oscar', 6),
(4, 'Złoty Popcorn', 7),
(5, 'Złote Lwy Gdańskie', 8),
(6, 'Złota Kaczka', 8),
(7, 'Złota Kaczka', 9);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `client`
--

CREATE TABLE `client` (
  `id_client` int(11) NOT NULL,
  `address` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `id_user` int(11) NOT NULL,
  `yor` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `client`
--

INSERT INTO `client` (`id_client`, `address`, `id_user`, `yor`) VALUES
(2, 'Kraków', 4, '2018'),
(3, 'Kraków', 5, '2018'),
(4, 'Kraków', 6, '2018'),
(5, 'Łobozew Górny 16/6', 7, '2010'),
(8, 'Kraków', 2, '2012');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `country`
--

CREATE TABLE `country` (
  `id_country` int(11) NOT NULL,
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `country`
--

INSERT INTO `country` (`id_country`, `name`) VALUES
(1, 'Polska'),
(2, 'USA'),
(3, 'Wielka Brytania'),
(4, 'Francja'),
(5, 'Niemcy'),
(7, 'Hiszpania'),
(8, 'Włochy');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `country_film`
--

CREATE TABLE `country_film` (
  `id_film` int(11) NOT NULL,
  `id_country` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `country_film`
--

INSERT INTO `country_film` (`id_film`, `id_country`) VALUES
(5, 2),
(6, 2),
(7, 2),
(8, 1),
(9, 2),
(9, 3),
(11, 2),
(11, 3),
(12, 3),
(12, 8),
(14, 7),
(15, 2);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `director`
--

CREATE TABLE `director` (
  `id_director` int(11) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `surname` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `yob` varchar(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `director`
--

INSERT INTO `director` (`id_director`, `name`, `surname`, `yob`) VALUES
(1, 'Władysław', 'Pasikowski', '1959'),
(2, 'Anthony', 'Russo', '1970'),
(3, 'John', 'Glen', '1932'),
(4, 'Chad', 'Stahelski', '1968'),
(5, 'Jon', 'Favreau', '1966'),
(6, 'Phillip', 'Noyce', '1950'),
(7, 'Sam', 'Mendes', '1965'),
(8, 'Martin', 'Campbell', '1943'),
(9, 'Asghar', 'Farhadi', '1972'),
(10, 'Justin', 'Lin', '1973');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `employee`
--

CREATE TABLE `employee` (
  `id_emp` int(11) NOT NULL,
  `address` varchar(60) NOT NULL,
  `id_user` int(11) NOT NULL,
  `yoe` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `employee`
--

INSERT INTO `employee` (`id_emp`, `address`, `id_user`, `yoe`) VALUES
(1, 'Dziekanowcie, ul. Zacisze 4', 1, '2017'),
(2, 'Kraków', 2, '2019');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `film`
--

CREATE TABLE `film` (
  `id_film` int(11) NOT NULL,
  `yop` varchar(4) DEFAULT NULL,
  `id_director` int(11) NOT NULL,
  `title` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `film`
--

INSERT INTO `film` (`id_film`, `yop`, `id_director`, `title`) VALUES
(5, '2019', 2, 'Avengers: End Game'),
(6, '2018', 2, 'Avengers: Infinity War'),
(7, '2019', 5, 'Iron Man 2'),
(8, '1992', 1, 'Psy'),
(9, '1998', 1, 'Demony wojny wg Goi'),
(10, '2019', 4, 'John Wick 3'),
(11, '1992', 6, 'Czas patriotów'),
(12, '2015', 7, 'Spectre'),
(14, '2018', 9, 'Wszyscy wiedzą'),
(15, '2013', 10, 'Szybcy i wściekli 6');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `film_actor`
--

CREATE TABLE `film_actor` (
  `id_film` int(11) NOT NULL,
  `id_actor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `film_actor`
--

INSERT INTO `film_actor` (`id_film`, `id_actor`) VALUES
(5, 5),
(6, 5),
(7, 5),
(8, 1),
(8, 2),
(9, 1),
(9, 3),
(10, 11),
(11, 4),
(14, 7),
(15, 16),
(15, 17);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `genre`
--

CREATE TABLE `genre` (
  `id_genre` int(11) NOT NULL,
  `kind` varchar(40) NOT NULL,
  `id_film` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `genre`
--

INSERT INTO `genre` (`id_genre`, `kind`, `id_film`) VALUES
(3, 'Sci-Fi', 5),
(4, 'Sci-Fi', 6),
(5, 'Sci-Fi', 7),
(6, 'Sensacyjny', 8),
(7, 'Dramat', 9),
(8, 'Wojenny', 9),
(9, 'Thriller', 10),
(10, 'Sensacyjny', 11),
(11, 'Sensacyjny', 12),
(13, 'Dramat', 14),
(14, 'Akcja', 15);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `opinion`
--

CREATE TABLE `opinion` (
  `id_opinion` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `date_opinion` date DEFAULT NULL,
  `id_user` int(11) NOT NULL,
  `id_film` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `product`
--

CREATE TABLE `product` (
  `id_product` int(11) NOT NULL,
  `id_film` int(11) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `product`
--

INSERT INTO `product` (`id_product`, `id_film`, `status`) VALUES
(1, 8, 'available'),
(2, 9, 'available'),
(3, 5, 'available'),
(4, 6, 'available'),
(5, 10, 'available'),
(6, 7, 'available'),
(7, 11, 'available'),
(8, 12, 'available'),
(10, 14, 'available'),
(11, 15, 'available');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `transaction_hire`
--

CREATE TABLE `transaction_hire` (
  `id_t_h` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_emp` int(11) NOT NULL,
  `id_product` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `surname` varchar(40) NOT NULL,
  `PESEL` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `user`
--

INSERT INTO `user` (`id_user`, `name`, `surname`, `PESEL`) VALUES
(1, 'Dawid', 'Kruczek', '97063001370'),
(2, 'Aleksandra', 'Piechnik', '96063001370'),
(4, 'Daniel', 'Kruczek', '13118039297'),
(5, 'Krzysztof', 'Kruczek', '72070202819'),
(6, 'Iwona', 'Kruczek', '75050989123'),
(7, 'Monika', 'Koza', '97032102213');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `actor`
--
ALTER TABLE `actor`
  ADD PRIMARY KEY (`id_actor`);

--
-- Indeksy dla tabeli `age_category`
--
ALTER TABLE `age_category`
  ADD PRIMARY KEY (`id_film`),
  ADD UNIQUE KEY `id_film` (`id_film`);

--
-- Indeksy dla tabeli `award`
--
ALTER TABLE `award`
  ADD PRIMARY KEY (`id_award`),
  ADD KEY `fk_film_award` (`id_film`);

--
-- Indeksy dla tabeli `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`),
  ADD UNIQUE KEY `id_user_2` (`id_user`),
  ADD KEY `id_user` (`id_user`);

--
-- Indeksy dla tabeli `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`id_country`);

--
-- Indeksy dla tabeli `country_film`
--
ALTER TABLE `country_film`
  ADD PRIMARY KEY (`id_film`,`id_country`),
  ADD KEY `fk_country_cf` (`id_country`);

--
-- Indeksy dla tabeli `director`
--
ALTER TABLE `director`
  ADD PRIMARY KEY (`id_director`);

--
-- Indeksy dla tabeli `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id_emp`),
  ADD UNIQUE KEY `id_user_2` (`id_user`),
  ADD KEY `id_user` (`id_user`);

--
-- Indeksy dla tabeli `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`id_film`),
  ADD KEY `fk_director` (`id_director`);

--
-- Indeksy dla tabeli `film_actor`
--
ALTER TABLE `film_actor`
  ADD PRIMARY KEY (`id_film`,`id_actor`),
  ADD KEY `id_actor` (`id_actor`);

--
-- Indeksy dla tabeli `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`id_genre`),
  ADD KEY `fk_film_genre` (`id_film`);

--
-- Indeksy dla tabeli `opinion`
--
ALTER TABLE `opinion`
  ADD PRIMARY KEY (`id_opinion`),
  ADD KEY `film_fk` (`id_film`),
  ADD KEY `fk_to_user_from_op` (`id_user`);

--
-- Indeksy dla tabeli `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id_product`),
  ADD KEY `id_film` (`id_film`);

--
-- Indeksy dla tabeli `transaction_hire`
--
ALTER TABLE `transaction_hire`
  ADD PRIMARY KEY (`id_t_h`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_emp` (`id_emp`),
  ADD KEY `fk_product` (`id_product`);

--
-- Indeksy dla tabeli `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `PESEL` (`PESEL`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `actor`
--
ALTER TABLE `actor`
  MODIFY `id_actor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT dla tabeli `award`
--
ALTER TABLE `award`
  MODIFY `id_award` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT dla tabeli `client`
--
ALTER TABLE `client`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT dla tabeli `country`
--
ALTER TABLE `country`
  MODIFY `id_country` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT dla tabeli `director`
--
ALTER TABLE `director`
  MODIFY `id_director` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT dla tabeli `employee`
--
ALTER TABLE `employee`
  MODIFY `id_emp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT dla tabeli `film`
--
ALTER TABLE `film`
  MODIFY `id_film` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT dla tabeli `genre`
--
ALTER TABLE `genre`
  MODIFY `id_genre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT dla tabeli `opinion`
--
ALTER TABLE `opinion`
  MODIFY `id_opinion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `product`
--
ALTER TABLE `product`
  MODIFY `id_product` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT dla tabeli `transaction_hire`
--
ALTER TABLE `transaction_hire`
  MODIFY `id_t_h` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `age_category`
--
ALTER TABLE `age_category`
  ADD CONSTRAINT `fk_to_film_from_ac` FOREIGN KEY (`id_film`) REFERENCES `film` (`id_film`) ON DELETE CASCADE;

--
-- Ograniczenia dla tabeli `award`
--
ALTER TABLE `award`
  ADD CONSTRAINT `fk_to_film_from_a` FOREIGN KEY (`id_film`) REFERENCES `film` (`id_film`) ON DELETE CASCADE;

--
-- Ograniczenia dla tabeli `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `fk_to_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE;

--
-- Ograniczenia dla tabeli `country_film`
--
ALTER TABLE `country_film`
  ADD CONSTRAINT `fk_to_country_from_cf` FOREIGN KEY (`id_country`) REFERENCES `country` (`id_country`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_to_film_from_cf` FOREIGN KEY (`id_film`) REFERENCES `film` (`id_film`) ON DELETE CASCADE;

--
-- Ograniczenia dla tabeli `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `fk_to_user_from_empl` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE;

--
-- Ograniczenia dla tabeli `film`
--
ALTER TABLE `film`
  ADD CONSTRAINT `fk_to_director_from_film` FOREIGN KEY (`id_director`) REFERENCES `director` (`id_director`) ON DELETE CASCADE;

--
-- Ograniczenia dla tabeli `film_actor`
--
ALTER TABLE `film_actor`
  ADD CONSTRAINT `fk_to_actor_from_fa` FOREIGN KEY (`id_actor`) REFERENCES `actor` (`id_actor`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_to_film_from_fa` FOREIGN KEY (`id_film`) REFERENCES `film` (`id_film`) ON DELETE CASCADE;

--
-- Ograniczenia dla tabeli `genre`
--
ALTER TABLE `genre`
  ADD CONSTRAINT `fk_to_film_from_g` FOREIGN KEY (`id_film`) REFERENCES `film` (`id_film`) ON DELETE CASCADE;

--
-- Ograniczenia dla tabeli `opinion`
--
ALTER TABLE `opinion`
  ADD CONSTRAINT `fk_to_film_from_op` FOREIGN KEY (`id_film`) REFERENCES `film` (`id_film`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_to_user_from_op` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE;

--
-- Ograniczenia dla tabeli `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `fk_to_film_from_product` FOREIGN KEY (`id_film`) REFERENCES `film` (`id_film`) ON DELETE CASCADE;

--
-- Ograniczenia dla tabeli `transaction_hire`
--
ALTER TABLE `transaction_hire`
  ADD CONSTRAINT `fk_to_emp_from_tr` FOREIGN KEY (`id_emp`) REFERENCES `employee` (`id_emp`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_to_product_from_tr` FOREIGN KEY (`id_product`) REFERENCES `product` (`id_product`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_to_user_from_tr` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
