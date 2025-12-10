package com.daw.api_crud_tareas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*EXPLICACIÓN INTERFAZ REPOSITORIO: TareaRepository
  Esta interfaz es la Capa de Acceso a Datos (DAL - Data Access Layer).
  Su trabajo es comunicar nuestra aplicación con la base de datos (H2, en este caso).*/
@Repository
    /*1. @Repository: Anotación de Spring que marca esta interfaz como un
      'bean' de Spring encargado de gestionar datos. Spring sabe que debe
      crear una implementación concreta en tiempo de ejecución.*/
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    
    /*2. JpaRepository<T, ID>: Aquí ocurre la "magia" de Spring Data.
      Al extender JpaRepository, nuestra interfaz hereda automáticamente
      MÁS DE 12 MÉTODOS BÁSICOS de CRUD, tales como:
      - save(Tarea entity): Guarda o actualiza una tarea.
      - findAll(): Devuelve todas las tareas.
      - findById(Long id): Busca una tarea por su ID.
      - deleteById(Long id): Elimina una tarea por su ID.
    
      Los parámetros de JpaRepository son:
      - Tarea: La Entidad (Modelo) con la que va a trabajar.
      - Long: El tipo de dato de la Clave Primaria (el 'id' de Tarea.java).

      3. No hay código de implementación aquí:
      Nuestra interfaz está vacía porque Spring, gracias a JpaRepository, 
      genera la clase concreta que implementa estos métodos CRUD 
      automáticamente, por lo que no necesitamos escribir ni una línea de SQL.

      NOTA: Si quisiéramos una búsqueda personalizada, la definiríamos 
      aquí usando un patrón de nombres, ejemplo:
      List<Tarea> findByCompletada(boolean completada); 
      Spring Data sabría automáticamente cómo escribir el SQL para eso.*/
}