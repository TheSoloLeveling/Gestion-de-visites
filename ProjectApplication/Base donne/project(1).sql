-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 15 juin 2021 à 01:21
-- Version du serveur :  10.4.18-MariaDB
-- Version de PHP : 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `project`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `nom` varchar(11) NOT NULL,
  `prenom` varchar(11) NOT NULL,
  `email` varchar(11) NOT NULL,
  `login` varchar(11) NOT NULL,
  `motDePasse` varchar(11) NOT NULL,
  `telephone` varchar(11) NOT NULL,
  `idSite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`id`, `nom`, `prenom`, `email`, `login`, `motDePasse`, `telephone`, `idSite`) VALUES
(1, 'dazd', 'dqs', 'qsd', 'qsd', 'qsd', '0', 0),
(2, 'aze', 'aze', 'zae', 'ez', 'aze', 'zae', 1),
(3, 'tt', 'tt', 'tt', 'tt', 'tt', 'tt', 1);

-- --------------------------------------------------------

--
-- Structure de la table `demande`
--

CREATE TABLE `demande` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `cnie` varchar(50) NOT NULL,
  `beginDate` date NOT NULL,
  `endDate` date NOT NULL,
  `time` varchar(24) NOT NULL,
  `userE` varchar(20) NOT NULL,
  `entreprise` varchar(50) NOT NULL,
  `etat` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `demande`
--

INSERT INTO `demande` (`id`, `nom`, `prenom`, `cnie`, `beginDate`, `endDate`, `time`, `userE`, `entreprise`, `etat`) VALUES
(5, 'test', 'test', 'test', '2021-06-02', '0000-00-00', '61919', '', 'test', 0),
(6, 'a', 'a', 'a', '2020-10-01', '0000-00-00', '61318', '', 'aze', 0),
(7, 'b', 'b', 'b', '2021-06-22', '0000-00-00', '70900', '', 'b', 0),
(8, 'yassine', 'bouziane', '12', '2013-06-05', '0000-00-00', '51310', '', 'uir', 0),
(9, 'po', 'po', '45', '2021-06-30', '0000-00-00', '12', '', 'b', 0),
(10, 'mo', 'mo', '54', '2021-06-12', '0000-00-00', '98', '', 'rst', 0),
(12, 'aa', 'aa', 'aa', '2021-06-16', '2021-06-07', '10 : 1', 'aa', '', 0),
(13, 'yassine', 'bouziane', '12', '2021-06-05', '2021-06-25', '10 : 2', 'reda', '', 0),
(14, 'qsdqsd', 'dqsd', 'AS123465', '2021-06-12', '2021-07-10', '10 : 1', 'c c', '', 0);

-- --------------------------------------------------------

--
-- Structure de la table `guerite`
--

CREATE TABLE `guerite` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `login` varchar(50) NOT NULL,
  `motDePasse` varchar(50) NOT NULL,
  `dateCreation` varchar(50) NOT NULL,
  `CIN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `guerite`
--

INSERT INTO `guerite` (`id`, `nom`, `prenom`, `email`, `login`, `motDePasse`, `dateCreation`, `CIN`) VALUES
(2, 'aze', 'aze', 'reda.belhaj@uir.ac.ma', 'aze', 'aze', 'azeaz', 45),
(3, 'wxc', 'vcx', 'mohamed-reda.falhi@uir.ac.ma', 'q', 'q', 'qdqsd', 12);

-- --------------------------------------------------------

--
-- Structure de la table `responsablesite`
--

CREATE TABLE `responsablesite` (
  `id` int(10) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `login` varchar(50) NOT NULL,
  `motDePasse` varchar(50) NOT NULL,
  `telephone` varchar(50) NOT NULL,
  `idSite` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `site`
--

CREATE TABLE `site` (
  `id` int(10) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `entreprise` varchar(50) NOT NULL,
  `capacite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `site`
--

INSERT INTO `site` (`id`, `nom`, `entreprise`, `capacite`) VALUES
(1, 'abs', 'uir', 12),
(2, 'dzl', 'CBI', 50),
(3, 'site1', 'aze', 20),
(4, 'site2', 'rst', 30);

-- --------------------------------------------------------

--
-- Structure de la table `superadmin`
--

CREATE TABLE `superadmin` (
  `id` int(10) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `login` varchar(50) NOT NULL,
  `motDePasse` varchar(50) NOT NULL,
  `telephone` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `superadmin`
--

INSERT INTO `superadmin` (`id`, `nom`, `prenom`, `email`, `login`, `motDePasse`, `telephone`) VALUES
(1, 'admin', 'admin', 'admin@gmail.com', 'admin', 'admin', '0613638818'),
(3, 'w', 'w', 'w', 'w', 'w', 'w'),
(4, 'azd', 'aqsx', 'wxc', 'sqd', 'aze', 'zae');

-- --------------------------------------------------------

--
-- Structure de la table `userentreprise`
--

CREATE TABLE `userentreprise` (
  `id` int(10) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `login` varchar(50) NOT NULL,
  `motDePasse` varchar(50) NOT NULL,
  `telephone` varchar(50) NOT NULL,
  `Etat` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `userentreprise`
--

INSERT INTO `userentreprise` (`id`, `nom`, `prenom`, `email`, `login`, `motDePasse`, `telephone`, `Etat`) VALUES
(22, 'absaq', 'q', 'qs', 'az', 'qs', 'zae', 0),
(24, 'c', 'c', 'c', 'c', 'c', 'c', 0),
(25, 'x', 'x', 'x', 'x', 'x', 'x', 0);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `demande`
--
ALTER TABLE `demande`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `guerite`
--
ALTER TABLE `guerite`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `responsablesite`
--
ALTER TABLE `responsablesite`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idSite` (`idSite`);

--
-- Index pour la table `site`
--
ALTER TABLE `site`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `superadmin`
--
ALTER TABLE `superadmin`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `userentreprise`
--
ALTER TABLE `userentreprise`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `demande`
--
ALTER TABLE `demande`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `guerite`
--
ALTER TABLE `guerite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `responsablesite`
--
ALTER TABLE `responsablesite`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `site`
--
ALTER TABLE `site`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `superadmin`
--
ALTER TABLE `superadmin`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `userentreprise`
--
ALTER TABLE `userentreprise`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `responsablesite`
--
ALTER TABLE `responsablesite`
  ADD CONSTRAINT `responsablesite_ibfk_1` FOREIGN KEY (`idSite`) REFERENCES `site` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
