package com.daw.api_crud_tareas;

// Importaciones esenciales de Jakarta Persistence API (JPA)
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// Importación de Lombok
import lombok.Data; 

/*EXPLICACIÓN DE CLASE MODELO / ENTIDAD: Tarea
  Esta clase representa la tabla 'Tarea' en la base de datos.
  Define la estructura de los datos que vamos a guardar.*/
@Entity
/*@Entity es la anotación más importante: le dice a Hibernate 
  (el motor de JPA) que cree una tabla en la base de datos (DB) 
  con el mismo nombre que esta clase.*/
 
@Data
/*@Data (de Lombok): Esta anotación es muy útil en las Entidades.
  Genera automáticamente todo el código 'boilerplate' (repetitivo):
  - Getters y Setters para todos los campos.
  - Constructores.
  - Métodos toString(), hashCode(), y equals().*/
public class Tarea {

    // ----------------------------------------------------
    // Atributos de la Entidad (Columnas de la Tabla)
    // ----------------------------------------------------

    @Id // 1. Marca este campo como la CLAVE PRIMARIA (Primary Key) de la tabla.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
         /*2. Define cómo se genera el valor de 'id'. 
           IDENTITY le pide a la DB que maneje la auto-generación (autoincremental), 
           asegurando que cada Tarea nueva tenga un ID único.*/
    private Long id; 

    // Campos normales (se convierten en columnas de la tabla automáticamente)
    private String titulo;      // Columna 'titulo' (tipo VARCHAR)
    private String descripcion; // Columna 'descripcion' (tipo VARCHAR)
    private boolean completada; // Columna 'completada' (tipo BOOLEAN)

    /*NOTA: recordemos que los métodos getters/setters no son necesarios
      de escribir gracias a usar @Data*/
}