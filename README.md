# 📋 Control de Tareas

Aplicación de escritorio desarrollada en Java para la gestión de tareas personales.

El proyecto forma parte de un trabajo universitario y tiene como objetivo aplicar conceptos de **Programación Orientada a Objetos**, manejo de bases de datos y desarrollo de interfaces gráficas.

## Tecnologías utilizadas

* Java 26
* Apache NetBeans
* PostgreSQL
* pgAdmin 4
* Git & GitHub

## Funcionalidades

Actualmente, el proyecto se encuentra en etapa de desarrollo.

La aplicación tendrá como objetivo permitir:

* Inicio de sesión de usuarios.
* Creación y gestión de tareas.
* Organización de tareas mediante categorías.
* Asignación de estados a las tareas.
* Almacenamiento de la información en una base de datos PostgreSQL.

## Configuración inicial del proyecto

### 1. Crear una carpeta para el proyecto

Crear una carpeta donde se almacenará el proyecto.

Ejemplo:

```text
C:\Projects\
```

### 2. Verificar la instalación de Java

Verificar que Java esté instalado ejecutando el siguiente comando desde la terminal:

```bash
java --version
```

Si Java no está instalado, se puede descargar desde:

[Descargar Java JDK 26](https://www.oracle.com/latam/java/technologies/downloads/#jdk26-windows)

### 3. Instalar PostgreSQL y pgAdmin 4

Se necesita instalar:

* **PostgreSQL:** motor de base de datos.
* **pgAdmin 4:** interfaz gráfica para administrar PostgreSQL.

PostgreSQL:

https://www.postgresql.org/download/

pgAdmin 4:

https://www.pgadmin.org/download/pgadmin-4-windows/

### 4. Instalar Git

Git se utilizará para el control de versiones del proyecto.

Descarga:

https://git-scm.com/install/windows

### 5. Configurar Git

Se recomienda realizar esta configuración desde la terminal de Visual Studio Code:

```bash
git config --global user.name "TuNombre"
git config --global user.email "tuemail@gmail.com"
```

## Cómo empezar a trabajar con el proyecto

### 1. Clonar el repositorio

Ubicarse dentro de la carpeta donde se desea guardar el proyecto y ejecutar desde la terminal:

```bash
git clone https://github.com/Zaracho16/controlDeTareas.git
```

Luego ingresar a la carpeta del proyecto:

```bash
cd controlDeTareas
```

### 2. Actualizar la rama `main`

Antes de crear una rama de trabajo, asegurarse de tener la última versión de `main`:

```bash
git checkout main
git pull origin main
```

### 3. Crear una rama de trabajo

No se debe trabajar directamente sobre `main`. Cada integrante debe crear su propia rama para evitar conflictos.

Crear una nueva rama:

```bash
git checkout -b nombre-de-tu-rama
```

Por ejemplo:

```bash
git checkout -b agregar-login
```

### 4. Guardar y subir los cambios

Cuando termines de trabajar:

Primero verificar los cambios:

```bash
git status
```

Agregar los archivos modificados:

```bash
git add .
```

Crear un commit describiendo los cambios realizados:

```bash
git commit -m "Agregar sistema de inicio de sesión"
```

Finalmente, subir la rama al repositorio:

```bash
git push -u origin nombre-de-tu-rama
```

### 5. Crear un Pull Request

Una vez que los cambios hayan sido subidos a GitHub, crear un **Pull Request** desde la rama de trabajo hacia `main`.

Después de revisar los cambios, el Pull Request podrá ser aprobado y fusionado con `main`.
