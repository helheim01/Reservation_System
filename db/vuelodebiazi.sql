-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-06-2025 a las 20:04:18
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `vuelodebiazi`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aerolinea`
--

CREATE TABLE `aerolinea` (
  `id` int(11) NOT NULL,
  `nombre_aerolinea` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `aerolinea`
--

INSERT INTO `aerolinea` (`id`, `nombre_aerolinea`) VALUES
(1, 'LATAM Airlines'),
(2, 'Avianca');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aeropuerto`
--

CREATE TABLE `aeropuerto` (
  `id` int(11) NOT NULL,
  `nombre_aeropuerto` varchar(255) DEFAULT NULL,
  `ciudad_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `aeropuerto`
--

INSERT INTO `aeropuerto` (`id`, `nombre_aeropuerto`, `ciudad_id`) VALUES
(1, 'Aeropuerto Internacional Jorge Chávez', 1),
(2, 'Aeropuerto Internacional El Dorado', 2),
(3, 'Aeropuerto de la Ciudad de México Benito Juárez', 3),
(4, 'Aeropuerto Internacional Barcelona-El Prat', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asiento`
--

CREATE TABLE `asiento` (
  `id` int(11) NOT NULL,
  `clase` enum('BUSINESS','ECONOMY','TURISTA') DEFAULT NULL,
  `fila_asiento` int(11) DEFAULT NULL,
  `letra_asiento` char(1) NOT NULL,
  `avion_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `asiento`
--

INSERT INTO `asiento` (`id`, `clase`, `fila_asiento`, `letra_asiento`, `avion_id`) VALUES
(1, 'ECONOMY', 1, 'A', 1),
(2, 'ECONOMY', 1, 'B', 1),
(3, 'BUSINESS', 2, 'A', 1),
(4, 'TURISTA', 5, 'Z', 2),
(5, 'TURISTA', 2, 'J', 2),
(6, 'BUSINESS', 9, 'L', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `avion`
--

CREATE TABLE `avion` (
  `numero_avion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `avion`
--

INSERT INTO `avion` (`numero_avion`) VALUES
(1),
(2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

CREATE TABLE `ciudad` (
  `id` int(11) NOT NULL,
  `nombre_ciudad` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ciudad`
--

INSERT INTO `ciudad` (`id`, `nombre_ciudad`) VALUES
(1, 'Madrid'),
(2, 'Buenos Aires'),
(3, 'Santiago de Chile'),
(4, 'Paris');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consulta`
--

CREATE TABLE `consulta` (
  `id` int(11) NOT NULL,
  `vuelo_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fecha`
--

CREATE TABLE `fecha` (
  `id` int(11) NOT NULL,
  `fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `fecha`
--

INSERT INTO `fecha` (`id`, `fecha`) VALUES
(1, '2025-05-11'),
(2, '2026-03-23');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `dtype` varchar(31) NOT NULL,
  `id` int(11) NOT NULL,
  `monto` double DEFAULT NULL,
  `numero_tarjeta` bigint(20) DEFAULT NULL,
  `tipo_tarjeta` enum('CREDITO','DEBITO') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pago`
--

INSERT INTO `pago` (`dtype`, `id`, `monto`, `numero_tarjeta`, `tipo_tarjeta`) VALUES
('Tarjeta', 1, 0, 123456789, 'CREDITO'),
('Tarjeta', 2, 0, 987654322, 'CREDITO'),
('Tarjeta', 3, 0, 1455678674, 'CREDITO'),
('Tarjeta', 4, 0, 123456789, 'CREDITO'),
('Tarjeta', 5, 0, 123456789, 'CREDITO'),
('Tarjeta', 6, 0, 34635767, 'CREDITO'),
('Tarjeta', 7, 0, 795684376, 'CREDITO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `tipo_persona` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `numero_piloto` int(11) DEFAULT NULL,
  `contraseña_usuario` varchar(255) DEFAULT NULL,
  `correo_electronico_usuario` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`tipo_persona`, `id`, `apellido`, `dni`, `nombre`, `numero_piloto`, `contraseña_usuario`, `correo_electronico_usuario`) VALUES
('Piloto', 1, 'Pérez', '30222333', 'Juan', 105, NULL, NULL),
('Piloto', 2, 'Nuñez', '46397857', 'Martina', 344, NULL, NULL),
('Piloto', 3, 'Pérez', '25767836', 'Lautaro', 761, NULL, NULL),
('Piloto', 4, 'Poso', '30222333', 'Tobias', 105, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona_consultas`
--

CREATE TABLE `persona_consultas` (
  `usuario_id` bigint(20) NOT NULL,
  `consultas_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona_reservas`
--

CREATE TABLE `persona_reservas` (
  `usuario_id` bigint(20) NOT NULL,
  `reservas_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona_tarjetas`
--

CREATE TABLE `persona_tarjetas` (
  `usuario_id` bigint(20) NOT NULL,
  `tarjetas_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `id` int(11) NOT NULL,
  `pago_id` int(11) DEFAULT NULL,
  `vuelo_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarifa`
--

CREATE TABLE `tarifa` (
  `id` int(11) NOT NULL,
  `clase_tarifa` enum('BUSINESS','ECONOMY','TURISTA') DEFAULT NULL,
  `impuesto_tarifa` int(11) DEFAULT NULL,
  `precio_tarifa` int(11) NOT NULL,
  `vuelo_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tarifa`
--

INSERT INTO `tarifa` (`id`, `clase_tarifa`, `impuesto_tarifa`, `precio_tarifa`, `vuelo_id`) VALUES
(1, 'ECONOMY', 15000, 200000, 4),
(3, 'BUSINESS', 1500000, 200000000, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelo`
--

CREATE TABLE `vuelo` (
  `id` int(11) NOT NULL,
  `aerolinea_id` int(11) DEFAULT NULL,
  `avion_id` int(11) DEFAULT NULL,
  `fecha_id` int(11) DEFAULT NULL,
  `piloto_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vuelo`
--

INSERT INTO `vuelo` (`id`, `aerolinea_id`, `avion_id`, `fecha_id`, `piloto_id`) VALUES
(1, 2, 1, 1, 1),
(2, 1, 2, 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelo_aeropuerto`
--

CREATE TABLE `vuelo_aeropuerto` (
  `vuelo_id` int(11) NOT NULL,
  `aeropuerto_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vuelo_aeropuerto`
--

INSERT INTO `vuelo_aeropuerto` (`vuelo_id`, `aeropuerto_id`) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aerolinea`
--
ALTER TABLE `aerolinea`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `aeropuerto`
--
ALTER TABLE `aeropuerto`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKesurdqxnpi4n6ubpjhassp8sq` (`ciudad_id`);

--
-- Indices de la tabla `asiento`
--
ALTER TABLE `asiento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4fw5ih4sgn6y6vggowpjo3t90` (`avion_id`);

--
-- Indices de la tabla `avion`
--
ALTER TABLE `avion`
  ADD PRIMARY KEY (`numero_avion`);

--
-- Indices de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `consulta`
--
ALTER TABLE `consulta`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKl6r95jcsv8x18ujbgl6hk0140` (`vuelo_id`);

--
-- Indices de la tabla `fecha`
--
ALTER TABLE `fecha`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `persona_consultas`
--
ALTER TABLE `persona_consultas`
  ADD UNIQUE KEY `UKo6j57u5y8y6l0m37hmtrh2l09` (`consultas_id`),
  ADD KEY `FKo0t36lsik1exhrn9ykw61ctfn` (`usuario_id`);

--
-- Indices de la tabla `persona_reservas`
--
ALTER TABLE `persona_reservas`
  ADD UNIQUE KEY `UKnqnxppdoe2f22y9dpxd94s2jv` (`reservas_id`),
  ADD KEY `FKcbcya4ttc80a580urw6wno79j` (`usuario_id`);

--
-- Indices de la tabla `persona_tarjetas`
--
ALTER TABLE `persona_tarjetas`
  ADD UNIQUE KEY `UKtm5vyuw7gsqcpyiihruyudyi0` (`tarjetas_id`),
  ADD KEY `FKe1hyo7emva3qu267ybi2ys2mq` (`usuario_id`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK9sowslilhk499oya4y5gjkqhr` (`pago_id`),
  ADD UNIQUE KEY `UK3y0afbn6bhaf8vyntg1exqmdo` (`vuelo_id`);

--
-- Indices de la tabla `tarifa`
--
ALTER TABLE `tarifa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7p5hex9mxl33v42bbxfq2k2s` (`vuelo_id`);

--
-- Indices de la tabla `vuelo`
--
ALTER TABLE `vuelo`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKg8nshmnxj1q60rn1ebqe1rfuw` (`aerolinea_id`),
  ADD UNIQUE KEY `UKeuixexc7a8qj8pfc8i2k48ee4` (`fecha_id`),
  ADD UNIQUE KEY `UKo4n8nycp25xtbbktvg994h94w` (`piloto_id`),
  ADD KEY `FK8j5widj67y5mcf830eqkvth2p` (`avion_id`);

--
-- Indices de la tabla `vuelo_aeropuerto`
--
ALTER TABLE `vuelo_aeropuerto`
  ADD KEY `FK7nxlv4hlqcytfbdaa3loa0iwt` (`aeropuerto_id`),
  ADD KEY `FKo01yvo4c8nlwujrfchqjdq9ap` (`vuelo_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `aerolinea`
--
ALTER TABLE `aerolinea`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `aeropuerto`
--
ALTER TABLE `aeropuerto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `asiento`
--
ALTER TABLE `asiento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `avion`
--
ALTER TABLE `avion`
  MODIFY `numero_avion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `consulta`
--
ALTER TABLE `consulta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `fecha`
--
ALTER TABLE `fecha`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `pago`
--
ALTER TABLE `pago`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tarifa`
--
ALTER TABLE `tarifa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `vuelo`
--
ALTER TABLE `vuelo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aeropuerto`
--
ALTER TABLE `aeropuerto`
  ADD CONSTRAINT `FKsu7kcvtb1oj6xods0wsnwvwn0` FOREIGN KEY (`ciudad_id`) REFERENCES `ciudad` (`id`);

--
-- Filtros para la tabla `asiento`
--
ALTER TABLE `asiento`
  ADD CONSTRAINT `FK4fw5ih4sgn6y6vggowpjo3t90` FOREIGN KEY (`avion_id`) REFERENCES `avion` (`numero_avion`);

--
-- Filtros para la tabla `consulta`
--
ALTER TABLE `consulta`
  ADD CONSTRAINT `FKnenbme9wh94apn8corfitaqsv` FOREIGN KEY (`vuelo_id`) REFERENCES `vuelo` (`id`);

--
-- Filtros para la tabla `persona_consultas`
--
ALTER TABLE `persona_consultas`
  ADD CONSTRAINT `FKi61e0i2d976l12cjtmsgifm4h` FOREIGN KEY (`consultas_id`) REFERENCES `consulta` (`id`),
  ADD CONSTRAINT `FKo0t36lsik1exhrn9ykw61ctfn` FOREIGN KEY (`usuario_id`) REFERENCES `persona` (`id`);

--
-- Filtros para la tabla `persona_reservas`
--
ALTER TABLE `persona_reservas`
  ADD CONSTRAINT `FKbodawlelb0td7j4cvpfhs6dxj` FOREIGN KEY (`reservas_id`) REFERENCES `reserva` (`id`),
  ADD CONSTRAINT `FKcbcya4ttc80a580urw6wno79j` FOREIGN KEY (`usuario_id`) REFERENCES `persona` (`id`);

--
-- Filtros para la tabla `persona_tarjetas`
--
ALTER TABLE `persona_tarjetas`
  ADD CONSTRAINT `FKe1hyo7emva3qu267ybi2ys2mq` FOREIGN KEY (`usuario_id`) REFERENCES `persona` (`id`),
  ADD CONSTRAINT `FKns3pdpfjsv9rmttsh36q8gjm0` FOREIGN KEY (`tarjetas_id`) REFERENCES `pago` (`id`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `FK4tvli56vtc61fgd5dktdd24l` FOREIGN KEY (`vuelo_id`) REFERENCES `vuelo` (`id`),
  ADD CONSTRAINT `FKo9jt3kmlktub09lc3y4kaii3v` FOREIGN KEY (`pago_id`) REFERENCES `pago` (`id`);

--
-- Filtros para la tabla `tarifa`
--
ALTER TABLE `tarifa`
  ADD CONSTRAINT `FK7p5hex9mxl33v42bbxfq2k2s` FOREIGN KEY (`vuelo_id`) REFERENCES `vuelo` (`id`);

--
-- Filtros para la tabla `vuelo`
--
ALTER TABLE `vuelo`
  ADD CONSTRAINT `FK5se3mkqwwtymed3najmh8bmej` FOREIGN KEY (`aerolinea_id`) REFERENCES `aerolinea` (`id`),
  ADD CONSTRAINT `FK7i7n1xighru2cut1ntasbp7ad` FOREIGN KEY (`piloto_id`) REFERENCES `persona` (`id`),
  ADD CONSTRAINT `FK8j5widj67y5mcf830eqkvth2p` FOREIGN KEY (`avion_id`) REFERENCES `avion` (`numero_avion`),
  ADD CONSTRAINT `FKslxgrretfcmk14te2d9ucnbv2` FOREIGN KEY (`fecha_id`) REFERENCES `fecha` (`id`);

--
-- Filtros para la tabla `vuelo_aeropuerto`
--
ALTER TABLE `vuelo_aeropuerto`
  ADD CONSTRAINT `FK7nxlv4hlqcytfbdaa3loa0iwt` FOREIGN KEY (`aeropuerto_id`) REFERENCES `aeropuerto` (`id`),
  ADD CONSTRAINT `FKo01yvo4c8nlwujrfchqjdq9ap` FOREIGN KEY (`vuelo_id`) REFERENCES `vuelo` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
