# 🚀 Construyendo una API REST con Spring Boot: Gestión de Tareas

## 🌟 Objetivo del Proyecto

Este repositorio contiene un proyecto funcional de Desarrollo de Aplicaciones Web (Backend) creado con Java y el framework **Spring Boot (v3.5.8)**.

El objetivo principal de este proyecto es servir como un recurso práctico para otros estudiantes de DAW que buscan entender y aplicar los siguientes conceptos.

### 🔑 Valor Educativo Añadido

Para facilitar el aprendizaje, **todo el código fuente (Controller, Repository y Model) está comentado línea a línea**, explicando:
* El **propósito** de cada anotación de Spring (ej. `@RestController`, `@Autowired`).
* La **función** de cada método y su relación con la Base de Datos.
* Los **conceptos** clave de JPA (Java Persistence API).

### Conceptos Clave a Aprender

1.  **Arquitectura en Capas:** Entender la división Model, Repository, y Controller.
2.  **CRUD Básico:** Implementar las cuatro operaciones fundamentales de gestión de datos.
3.  **Persistencia de Datos:** Usar Spring Data JPA para guardar y recuperar información sin escribir SQL.
4.  **APIs RESTful:** Crear *endpoints* que responden a peticiones HTTP (GET, POST, PUT, DELETE).

## 🛠️ Stack y Prerrequisitos

Para ejecutar este proyecto, necesitarás lo siguiente:

* **Lenguaje:** Java Development Kit (JDK 17 o superior)
* **Framework:** Spring Boot 3.5.8
* **Gestor de Dependencias:** Maven
* **Base de Datos:** H2 Database (En memoria, no requiere instalación externa).
* **Herramienta de Prueba:** Un cliente HTTP (Recomiendo la extensión **REST Client** de VS Code).

## 🧩 Pasos de Construcción (Guía para Estudiantes)

El proyecto se divide en tres componentes principales que trabajan juntos:

### Paso 1: El Modelo (La Estructura del Dato)

El archivo `Tarea.java` define la **forma** de los datos que guardaremos.
* `@Entity`: Le dice a Spring que esto es una tabla de base de datos.
* `@Data` (Lombok): Nos ahorra escribir *Getters* y *Setters*.



### Paso 2: El Repositorio (El Acceso a la DB)

La interfaz `TareaRepository.java` es la clave para la persistencia.
* Al extender `JpaRepository<Tarea, Long>`, heredamos **automáticamente** los métodos `save()`, `findAll()`, `findById()`, etc.
* Esto significa que **no escribimos código SQL**. Spring se encarga de traducir estos métodos a sentencias SQL (INSERT, SELECT, etc.).

### Paso 3: El Controlador (El Intermediario HTTP)

El `TareaController.java` es el "guardián de la API", responsable de mapear las peticiones HTTP a las acciones del repositorio. 

| HTTP Método |    URL Mapeada    |             Acción en la DB                |
| :---------- | :---------------- | :----------------------------------------- |
| `GET`       | `/api/tareas`     | `tareaRepository.findAll()`                |
| `POST`      | `/api/tareas`     | `tareaRepository.save()`                   |
| `PUT`       | `/api/tareas/{id}`| `tareaRepository.save()` (tras actualizar) |
| `DELETE`    | `/api/tareas/{id}`| `tareaRepository.deleteById()`             |

---

## ⚙️ Cómo Ponerlo en Marcha

### 1. Clonación y Ejecución

1.  Clona el proyecto en tu máquina.
2.  Abre la carpeta raíz en VS Code.
3.  Ejecuta la aplicación desde la terminal (asegúrate de que el JDK está configurado):
    ```bash
    ./mvnw spring-boot:run
    ```
4.  El servidor debe iniciarse en `http://localhost:8080`.

### 2. Pruebas de Funcionamiento

Utiliza el archivo **`requests.http`** incluido en la raíz del proyecto (requiere la extensión **REST Client**) para probar los endpoints:

1.  **POST:** Crea nuevas tareas.
2.  **GET:** Consulta la lista de tareas.
3.  **PUT:** Actualiza el estado de una tarea (ej. a `completada: true`).
4.  **DELETE:** Elimina tareas.

---

## 🎓 Sobre el Autor

Soy Malakai Villegas, recién graduado en Desarrollo de Aplicaciones Web (DAW). Este proyecto es un ejercicio para consolidar mis habilidades en el backend moderno de Java. 

Recomiendo a cualquier estudiante de DAW o de programación que complete este ejercicio porque es la "piedra Rosetta" del desarrollo backend: si entiendes la arquitectura Model-Repository-Controller y cómo funciona Spring Data JPA, tienes la base para trabajar con cualquier framework moderno (como Laravel, Django o Node.js/Express).

* **Mi LinkedIn:** (https://www.linkedin.com/in/malakai-villegas-pérez-8239b1339)