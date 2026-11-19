
-- Creacion de tabla para usuario:
CREATE TABLE usuario (
	id SERIAL PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL,
	email VARCHAR(150) UNIQUE NOT NULL,
	password VARCHAR(255) NOT NULL
);

-- Creacion de tabla para Categoria:
CREATE TABLE categoria (
    id_categoria SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    id_usuario INTEGER NOT NULL,

    CONSTRAINT fk_categoria_usuario
        FOREIGN KEY (id_usuario)
        REFERENCES usuario(id)
        ON DELETE CASCADE,

    CONSTRAINT uq_categoria_usuario_nombre
        UNIQUE (id_usuario, nombre)
);

-- Query para insertar las categorias a la tabla:
INSERT INTO categoria (nombre, id_usuario)
SELECT valores.nombre, u.id
FROM usuario u
CROSS JOIN (
    VALUES ('Facultad'), ('Personal'), ('Trabajo')
) AS valores(nombre);

-- Creacion de tabla para estado:
CREATE TABLE estado (
	id_estado SERIAL PRIMARY KEY,
	nombre VARCHAR(150) NOT NULL
);

-- Query para insertar los estados correspondientes a la tabla estado:
INSERT INTO estado (nombre) VALUES ('Pendiente'), ('Completada');


-- Creacion de tabla para Prioridad
CREATE TABLE prioridad (
    id_prioridad SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    id_usuario INTEGER NOT NULL,

    CONSTRAINT fk_prioridad_usuario
        FOREIGN KEY (id_usuario)
        REFERENCES usuario(id)
        ON DELETE CASCADE,

    CONSTRAINT uq_prioridad_usuario_nombre
        UNIQUE (id_usuario, nombre)
);

-- Valores para prioridad
INSERT INTO prioridad (nombre, id_usuario)
SELECT valores.nombre, u.id
FROM usuario u
CROSS JOIN (
    VALUES ('Alta'), ('Media'), ('Baja')
) AS valores(nombre);

-- Creacion de tabla para tareas:
CREATE TABLE tareas (
    id_tareas SERIAL PRIMARY KEY,
    id_usuario INTEGER NOT NULL,
    id_categoria INTEGER NOT NULL,
    id_estado INTEGER NOT NULL,
    id_prioridad INTEGER NOT NULL,
    titulo VARCHAR(150) NOT NULL,
    descripcion TEXT,
    fecha_limite DATE,
    fecha_creacion DATE NOT NULL DEFAULT CURRENT_DATE,
    completada BOOLEAN NOT NULL DEFAULT FALSE,

    FOREIGN KEY (id_usuario)
        REFERENCES usuario(id),

    FOREIGN KEY (id_categoria)
        REFERENCES categoria(id_categoria),

    FOREIGN KEY (id_estado)
        REFERENCES estado(id_estado),

    FOREIGN KEY (id_prioridad)
        REFERENCES prioridad(id_prioridad)
);