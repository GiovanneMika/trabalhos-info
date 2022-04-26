-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 24-Mar-2022 às 17:56
-- Versão do servidor: 5.7.25
-- versão do PHP: 7.1.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `caixa`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `movimento`
--

CREATE TABLE `movimento` (
  `id` int(55) NOT NULL,
  `dataMov` date NOT NULL,
  `descricao` varchar(55) NOT NULL,
  `valor` int(55) NOT NULL,
  `tipo` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `movimento`
--

INSERT INTO `movimento` (`id`, `dataMov`, `descricao`, `valor`, `tipo`) VALUES
(151, '2005-05-12', 'xcvbcvx', 50, 'S'),
(201, '2005-02-12', 'coco', 50, 'E'),
(202, '2003-06-23', 'laranja', 40, 'E'),
(251, '2012-05-14', 'Dinamite', 100, 'E'),
(252, '2004-12-02', 'bomba', 60, 'S'),
(301, '2018-09-18', 'Maionese', 15, 'S'),
(351, '2020-09-12', 'Halls', 10, 'S'),
(401, '2017-11-12', 'geleia', 40, 'S'),
(402, '2017-11-12', 'geleia', 40, 'S'),
(403, '2017-11-12', 'geleia', 40, 'S'),
(404, '2017-11-12', 'geleia', 40, 'S'),
(405, '2017-11-12', 'geleia', 40, 'S'),
(406, '2017-11-12', 'geleia', 40, 'S'),
(451, '2000-12-12', 'efsad', 40, 'S'),
(501, '2223-10-22', 'aaaaaa', 30, 'S'),
(551, '2324-09-21', 'dfdsdf', 20, 'S'),
(601, '3234-11-23', 'gfhggh', 20, 'S'),
(651, '2113-09-12', 'dfzfds', 40, 'S'),
(701, '2022-10-10', 'fdsa', 0, 'S');

-- --------------------------------------------------------

--
-- Estrutura da tabela `saldo`
--

CREATE TABLE `saldo` (
  `id` int(55) NOT NULL,
  `data` date NOT NULL,
  `valor` int(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `saldo`
--

INSERT INTO `saldo` (`id`, `data`, `valor`) VALUES
(1, '2022-03-17', 50),
(2, '2022-03-16', 40);

-- --------------------------------------------------------

--
-- Estrutura da tabela `sequence`
--

CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `sequence`
--

INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN', '750');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `movimento`
--
ALTER TABLE `movimento`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `saldo`
--
ALTER TABLE `saldo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sequence`
--
ALTER TABLE `sequence`
  ADD PRIMARY KEY (`SEQ_NAME`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `movimento`
--
ALTER TABLE `movimento`
  MODIFY `id` int(55) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=702;

--
-- AUTO_INCREMENT for table `saldo`
--
ALTER TABLE `saldo`
  MODIFY `id` int(55) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
