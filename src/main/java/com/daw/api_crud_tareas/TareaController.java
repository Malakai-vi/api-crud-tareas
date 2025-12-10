package com.daw.api_crud_tareas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; // Para manejar códigos de respuesta HTTP
import org.springframework.http.ResponseEntity; // Para construir respuestas HTTP
import org.springframework.web.bind.annotation.*; //Importa todas las anotaciones

import java.util.List;
import java.util.Optional;

/*EXPLICACIÓN CLASE CONTROLADOR: TareaController
  Esta clase maneja todas las peticiones HTTP que llegan a la API.
  Actúa como intermediario entre el cliente web y la capa de datos (Repository).*/
@RestController
    /*1. @RestController: Combina @Controller (marca la clase como un componente web) 
    y @ResponseBody (indica que los métodos devuelven datos directos, no vistas HTML).*/
@RequestMapping("/api/tareas")
    /*2. @RequestMapping("/api/tareas"): Define la URL base para todos los métodos de esta clase.
    Todas las rutas internas empezarán por: http://localhost:8080/api/tareas*/
public class TareaController {

    //3. INYECCIÓN DE DEPENDENCIA (IoC)
    @Autowired 
    private TareaRepository tareaRepository;
    /*@Autowired le dice a Spring que busque una instancia de TareaRepository 
      y la inyecte automáticamente aquí. Esto permite que el Controller use 
      todos los métodos CRUD sin que tengamos que instanciar la clase manualmente.*/

    // =======================================================
    // R - READ: OBTENER TODAS LAS TAREAS
    // =======================================================
    @GetMapping 
    // @GetMapping: Mapea peticiones HTTP GET a la URL base (/api/tareas)
    public List<Tarea> obtenerTodasLasTareas() {
        // Llama al método findAll() heredado de JpaRepository
        return tareaRepository.findAll();
    }

    // =======================================================
    // C - CREATE: CREAR NUEVA TAREA
    // =======================================================
    @PostMapping
    // @PostMapping: Mapea peticiones HTTP POST a la URL base (/api/tareas)
    @ResponseStatus(HttpStatus.CREATED) // Opcional: Devuelve el código HTTP 201 (Created)
    public Tarea crearTarea(@RequestBody Tarea nuevaTarea) {
        /*@RequestBody: Spring toma el JSON del cuerpo de la petición y lo convierte 
          automáticamente en un objeto Tarea (gracias a Jackson y Lombok).*/
        return tareaRepository.save(nuevaTarea); // Guarda el objeto en la DB
    }
    
    // =======================================================
    // R - READ: OBTENER POR ID
    // =======================================================
    @GetMapping("/{id}")
    // @GetMapping("/{id}"): Mapea GET a una URL con un parámetro dinámico (ej: /api/tareas/1)
    public ResponseEntity<Tarea> obtenerTareaPorId(@PathVariable Long id) {
        // @PathVariable Long id: Captura el valor del ID desde la URL.
        
        // findById() devuelve un Optional<Tarea> para manejar si el objeto no existe
        Optional<Tarea> tarea = tareaRepository.findById(id); 
        
        /*Uso de Optional: Si encuentra la tarea (.map), devuelve 200 OK y la tarea.
          Si no la encuentra (.orElseGet), devuelve 404 Not Found.*/
        return tarea.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // =======================================================
    // U - UPDATE: ACTUALIZAR TAREA EXISTENTE
    // =======================================================
    @PutMapping("/{id}")
    // @PutMapping: Mapea peticiones HTTP PUT para actualizar un recurso existente.
    public ResponseEntity<Tarea> actualizarTarea(@PathVariable Long id, @RequestBody Tarea detallesTarea) {
        
        return tareaRepository.findById(id)
            .map(tareaExistente -> {
                // 1. Actualiza los campos de la tarea existente con los nuevos detalles
                tareaExistente.setTitulo(detallesTarea.getTitulo());
                tareaExistente.setDescripcion(detallesTarea.getDescripcion());
                tareaExistente.setCompletada(detallesTarea.isCompletada()); 

                // 2. Llama a save(). Si el objeto tiene un ID existente, JPA actualiza en lugar de insertar.
                Tarea tareaActualizada = tareaRepository.save(tareaExistente);
                return ResponseEntity.ok(tareaActualizada); // Devuelve 200 OK
            })
            .orElseGet(() -> ResponseEntity.notFound().build()); 
    }

    // =======================================================
    // D - DELETE: ELIMINAR TAREA
    // =======================================================
    @DeleteMapping("/{id}")
    // @DeleteMapping: Mapea peticiones HTTP DELETE para eliminar un recurso.
    public ResponseEntity<Void> eliminarTarea(@PathVariable Long id) {
        
        if (tareaRepository.existsById(id)) {
            tareaRepository.deleteById(id);
            /*ResponseEntity.noContent().build(): Devuelve 204 No Content, el código 
              estándar para una eliminación exitosa sin devolver un cuerpo.*/
            return ResponseEntity.noContent().build(); 
        } else {
            return ResponseEntity.notFound().build(); // Devuelve 404 si la tarea no existe
        }
    }
}