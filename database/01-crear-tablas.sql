
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
	id_usuario INTEGER NOT NULL,
	nombre VARCHAR(100) NOT NULL,

	CONSTRAINT fk_categoria_usuario
		FOREIGN KEY (id_usuario)
		REFERENCES usuario(id)
);

-- Query para insertar las categorias a la tabla:
INSERT INTO categoria (id_usuario, nombre) VALUES (1, 'Facultad'), (1, 'Personal'), (1, 'Trabajo');

-- Creacion de tabla para estado:
CREATE TABLE estado (
	id_estado SERIAL PRIMARY KEY,
	nombre VARCHAR(150) NOT NULL
);

-- Query para insertar los estados correspondientes a la tabla estado:
INSERT INTO estado (nombre) VALUES ('Pendiente'), ('En progreso'), ('Completada');


-- Creacion de tabla para tareas:
CREATE TABLE tareas(
	id_tareas SERIAL PRIMARY KEY,
	id_usuario INTEGER NOT NULL,
	id_categoria INTEGER NOT NULL,
	id_estado INTEGER NOT NULL,

	titulo VARCHAR(150) NOT NULL,
	descripcion TEXT,
	prioridad VARCHAR(20) NOT NULL,

	fecha_limite DATE,
	fecha_creacion DATE NOT NULL DEFAULT CURRENT_DATE,

	completada BOOLEAN NOT NULL DEFAULT FALSE,

	CONSTRAINT fk_tareas_usuario
		FOREIGN KEY (id_usuario)
		REFERENCES usuario(id),
	
	CONSTRAINT fk_tareas_categoria
		FOREIGN KEY (id_categoria)
		REFERENCES categoria(id_categoria),

	CONSTRAINT fk_tareas_estado
		FOREIGN KEY (id_estado)
		REFERENCES estado(id_estado)
);