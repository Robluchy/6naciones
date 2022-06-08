CREATE DATABASE IF NOT EXISTS 6_naciones;
USE 6_naciones;

 

CREATE TABLE `arbitros` (
  `id_arbitro` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `precision` int(100) NOT NULL,
  `fecha_nacimiento` varchar(255) NOT NULL,
  `peso` double(100,0) NOT NULL,
  PRIMARY KEY (`id_arbitro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

 

CREATE TABLE `equipos` (
  `id_equipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `partidos_jugados` int(100) NOT NULL,
  `partidos_ganados` int(100) NOT NULL,
  `partidos_perdidos` int(100) NOT NULL,
  `partidos_empatados` int(100) NOT NULL,
  PRIMARY KEY (`id_equipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

 

CREATE TABLE `entrenadores` (
  `id_entrenador` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `id_equipo` int(100) DEFAULT NULL,
  `experiencia` int(100) NOT NULL,
  `peso` double(100,0) NOT NULL,
  `fecha_nacimiento` varchar(255) NOT NULL,
  PRIMARY KEY (`id_entrenador`),
  KEY `id_equipo` (`id_equipo`),
  CONSTRAINT `entrenadores_ibfk_1` FOREIGN KEY (`id_equipo`) REFERENCES `equipos` (`id_equipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `estadios` (
  `id_estadio` int(11) NOT NULL AUTO_INCREMENT,
  `capacidad` int(100) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id_estadio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

 

CREATE TABLE `jugadores` (
  `id_jugador` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_nacimiento` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `id_equipo` int(100) DEFAULT NULL,
  `fuerza` int(100) NOT NULL,
  `velocidad` int(100) NOT NULL,
  `resistencia` int(100) NOT NULL,
  `peso` double(100,0) NOT NULL,
  PRIMARY KEY (`id_jugador`),
  KEY `id_equipo` (`id_equipo`),
  CONSTRAINT `jugadores_ibfk_1` FOREIGN KEY (`id_equipo`) REFERENCES `equipos` (`id_equipo`)
) ENGINE=InnoDB AUTO_INCREMENT=181 DEFAULT CHARSET=utf8mb4;
 

CREATE TABLE `partidos` (
  `id_partido` int(11) NOT NULL AUTO_INCREMENT,
  `id_visitante` int(11) NOT NULL,
  `id_local` int(11) NOT NULL,
  `id_estadio` int(11) NOT NULL,
  `fecha_partido` varchar(255) NOT NULL,
  `resultado` varchar(255) DEFAULT 'sin resultado',
  PRIMARY KEY (`id_partido`),
  KEY `id_estadio` (`id_estadio`),
  KEY `id_visitante` (`id_visitante`),
  KEY `id_local` (`id_local`),
  CONSTRAINT `partidos_ibfk_1` FOREIGN KEY (`id_estadio`) REFERENCES `estadios` (`id_estadio`),
  CONSTRAINT `partidos_ibfk_2` FOREIGN KEY (`id_visitante`) REFERENCES `equipos` (`id_equipo`),
  CONSTRAINT `partidos_ibfk_3` FOREIGN KEY (`id_local`) REFERENCES `equipos` (`id_equipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

 

CREATE TABLE `arbitros_partidos` (
  `id_arbitro` int(11) NOT NULL,
  `id_partido` int(11) NOT NULL,
  `actas` varchar(255),
  KEY `id_arbitro` (`id_arbitro`),
  KEY `id_partido` (`id_partido`),
  CONSTRAINT `arbitros_partidos_ibfk_1` FOREIGN KEY (`id_arbitro`) REFERENCES `arbitros` (`id_arbitro`),
  CONSTRAINT `arbitros_partidos_ibfk_2` FOREIGN KEY (`id_partido`) REFERENCES `partidos` (`id_partido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
