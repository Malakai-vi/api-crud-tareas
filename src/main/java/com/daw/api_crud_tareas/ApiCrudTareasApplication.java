package com.daw.api_crud_tareas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*Clase principal de la aplicación Spring Boot.
  Esta clase sirve como punto de entrada (main class) de toda la aplicación.
  Cuando se ejecuta, inicia el contenedor de Spring Boot y configura todo, 
  incluyendo el servidor web Tomcat y la base de datos H2.*/
@SpringBootApplication
public class ApiCrudTareasApplication {

    /**
     * Método principal (Main) que se ejecuta al iniciar la aplicación.
     * * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        /*SpringApplication.run() es el método mágico que inicia todo.
          Se le pasa la clase principal (ApiCrudTareasApplication.class) para que
          Spring sepa dónde empezar a buscar componentes (Controllers, Repositories, etc.).*/
        SpringApplication.run(ApiCrudTareasApplication.class, args);
        
        /* Al ejecutar esta línea, Spring:
           1. Configura el contenedor de Inversión de Control (IoC).
           2. Escanea todas las clases con anotaciones (@Controller, @Repository, etc.).
           3. Inicializa la base de datos H2.
           4. Arranca el servidor web Tomcat en el puerto 8080.*/
    }

}