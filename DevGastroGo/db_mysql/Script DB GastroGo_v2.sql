-- Script para la base de datos restaurantedb

-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS restaurantedb;

-- Usar la base de datos restaurantedb
USE restaurantedb;

-- Crear la tabla usuario si no existe
CREATE TABLE IF NOT EXISTS usuario (
    id INT AUTO_INCREMENT PRIMARY KEY, 
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE,
    telefono VARCHAR(20),
    numero_documento VARCHAR(20)
);

-- Opcional: Insertar algunos datos de ejemplo
INSERT INTO usuario (nombre, email, telefono, numero_documento) VALUES
('Juan Pérez', 'juan.perez@ejemplo.com', '3001234567', '1234567890'),
('María Gómez', 'maria.gomez@ejemplo.com', '3109876543', '0987654321'),
('Carlos López', 'carlos.lopez@ejemplo.com', '3201122334', '1122334455');

-- Mostrar la estructura de la tabla usuario
DESCRIBE usuario;

-- Mostrar los datos insertados (opcional)
SELECT * FROM usuario;
