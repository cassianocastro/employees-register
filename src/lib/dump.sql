-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Tempo de geração: 15/04/2020 às 19:27
-- Versão do servidor: 5.7.29-0ubuntu0.18.04.1
-- Versão do PHP: 7.2.24-0ubuntu0.18.04.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `exercicio`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `Funcionarios`
--

CREATE TABLE `Funcionarios` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(250) NOT NULL,
  `data_nasc` date NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `cpf` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `Funcionarios`
--

INSERT INTO `Funcionarios` (`codigo`, `nome`, `data_nasc`, `sexo`, `cpf`) VALUES
(1, 'Ana Maria', '1990-05-08', 'f', '123.456.789/00'),
(2, 'Bia Mattos', '2002-09-22', 'f', '456.789.123/00'),
(3, 'Carlos Lopes', '2000-01-30', 'm', '789.456.123/00');

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `Funcionarios`
--
ALTER TABLE `Funcionarios`
  ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `Funcionarios`
--
ALTER TABLE `Funcionarios`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
