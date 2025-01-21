# API de Foro de Consultas

Este proyecto implementa una API para la gestión de tópicos en un foro de consultas. Permite crear, consultar, actualizar y eliminar tópicos de forma sencilla y eficiente. 🚀

## Descripción del Proyecto 📋

La API está diseñada para gestionar tópicos en un foro de consultas, proporcionando operaciones esenciales para interactuar con ellos. Este proyecto está desarrollado con **Java** utilizando **Spring Boot**, y utiliza **PostgreSQL** como base de datos para el almacenamiento de los datos.

### Funcionamiento de la API

1. **Registro de un Nuevo Tópico**: Permite crear un nuevo tópico con un título y un mensaje.
2. **Mostrar Todos los Tópicos**: Proporciona una lista de todos los tópicos registrados.
3. **Detallar un Tópico**: Permite consultar los detalles de un tópico específico mediante su ID.
4. **Actualizar un Tópico**: Facilita la modificación de un tópico existente.
5. **Eliminar un Tópico**: Permite eliminar un tópico identificado por su ID.

### Características 🌟

- **Registrar Tópico**: Crear nuevos tópicos con un título y un mensaje asociados.
- **Listar Tópicos**: Consultar todos los tópicos disponibles en la base de datos.
- **Consultar Tópico por ID**: Ver los detalles de un tópico específico.
- **Actualizar Tópico**: Modificar el contenido o título de un tópico existente.
- **Eliminar Tópico**: Eliminar tópicos que ya no sean necesarios.

## Tecnologías Utilizadas 🛠️

- **Java 17+**
- **Spring Boot 3.4.1**
- **Spring Data JPA**
- **MySQL**
- **Maven**
- **Jackson (para manejo de JSON)**
- **Flyway**
- **JWT (Java Web Tokens)**
- **Springdoc OpenAPI**

## Instalación y Ejecución 🚀

Sigue estos pasos para configurar y ejecutar el proyecto en tu máquina local.

### Prerrequisitos

- Java 17 o superior
- Maven 3.6 o superior
- MySQL o cualquier base de datos compatible


## Instalación

### 1. Clonar el Repositorio

Clona este proyecto desde GitHub utilizando el siguiente comando:

```bash
git clone https://github.com/deidmon/foro-hub.git
```

### Configurar tu base de datos en el archivo application.properties
```bash
spring.application.name=api
spring.datasource.url = jdbc:mysql://${DB_HOST}/foro_hub
spring.datasource.username = ${DB_USER}
spring.datasource.password = ${DB_PASSWORD}
```

