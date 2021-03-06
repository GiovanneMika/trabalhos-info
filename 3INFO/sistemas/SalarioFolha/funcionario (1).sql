-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 10-Maio-2022 às 03:45
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
-- Database: `funcionario`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `matricula` int(11) NOT NULL,
  `dep14` int(11) NOT NULL,
  `depir` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `vt` varchar(50) NOT NULL,
  `salario` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`matricula`, `dep14`, `depir`, `nome`, `vt`, `salario`) VALUES
(1, 2, 3, 'Gustavo Henrique', 'Não', 1500.85),
(10, 2, 3, 'Cassio', 's', 1100),
(11, 0, 0, 'Rafael', 'n', 1100),
(12, 1, 2, 'Anna', 's', 2000),
(13, 0, 0, 'Nicolas', 'n', 3000),
(14, 1, 1, 'Allan', 'n', 6400),
(15, 1, 1, 'Arthur', 'n', 15000),
(16, 0, 0, 'Vitor', 'n', 15000),
(17, 0, 1, 'Lucio', 'Sim', 20000),
(18, 1, 2, 'teste', 'N', 1000),
(51, 5, 5, 'João Gustavo', 'Sim', 2131);

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
('SEQ_GEN', '100');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tabela`
--

CREATE TABLE `tabela` (
  `id` int(11) NOT NULL,
  `tinss1` double NOT NULL,
  `tinss2` double NOT NULL,
  `tinss3` double NOT NULL,
  `tinss4` double NOT NULL,
  `ainss1` double NOT NULL,
  `ainss2` double NOT NULL,
  `ainss3` double NOT NULL,
  `ainss4` double NOT NULL,
  `tsf` double NOT NULL,
  `vsf` double NOT NULL,
  `tirrf1` double NOT NULL,
  `tirrf2` double NOT NULL,
  `airrf2` double NOT NULL,
  `dirrf2` double NOT NULL,
  `tirrf3` double NOT NULL,
  `airrf3` double NOT NULL,
  `dirrf3` double NOT NULL,
  `tirrf4` double NOT NULL,
  `airrf4` double NOT NULL,
  `dirrf4` double NOT NULL,
  `airrf5` double NOT NULL,
  `dirrf5` double NOT NULL,
  `dedpdep` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tabela`
--

INSERT INTO `tabela` (`id`, `tinss1`, `tinss2`, `tinss3`, `tinss4`, `ainss1`, `ainss2`, `ainss3`, `ainss4`, `tsf`, `vsf`, `tirrf1`, `tirrf2`, `airrf2`, `dirrf2`, `tirrf3`, `airrf3`, `dirrf3`, `tirrf4`, `airrf4`, `dirrf4`, `airrf5`, `dirrf5`, `dedpdep`) VALUES
(1, 1100, 2203.48, 3305.22, 6433.57, 7.5, 9, 12, 14, 1503.25, 51.27, 1903.98, 2826.65, 7.5, 142.8, 3751.05, 15, 354.8, 4664.68, 22.5, 646.13, 27.5, 869.36, 189.59);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`matricula`);

--
-- Indexes for table `sequence`
--
ALTER TABLE `sequence`
  ADD PRIMARY KEY (`SEQ_NAME`);

--
-- Indexes for table `tabela`
--
ALTER TABLE `tabela`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `matricula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT for table `tabela`
--
ALTER TABLE `tabela`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
