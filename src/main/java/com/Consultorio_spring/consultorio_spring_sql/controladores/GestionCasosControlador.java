package com.Consultorio_spring.consultorio_spring_sql.controladores;

import com.Consultorio_spring.consultorio_spring_sql.Entidades.GestionCasos;
import com.Consultorio_spring.consultorio_spring_sql.Entidades.Usuarios;
import com.Consultorio_spring.consultorio_spring_sql.servicios.GestionCasosServicios;
import com.Consultorio_spring.consultorio_spring_sql.servicios.Servicios_Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/casos")
public class GestionCasosControlador {

    @Autowired
    private GestionCasosServicios gestionCasosServicios;

    @Autowired
    private Servicios_Usuarios serviciosUsuarios;


    @PostMapping("/insertar")
    public ResponseEntity<GestionCasos> registrarCaso(@RequestBody GestionCasos caso) {
        // Busca al usuario por el documento del estudiante en la entidad Usuarios
        Optional<Usuarios> usuarioOptional = serviciosUsuarios.buscarPorDocumento(caso.getDocumentoUsuario());

        if (usuarioOptional.isPresent()) {
            // Asigna el objeto Usuarios al campo documentoEstudiante en GestionCasos
            caso.setDocumentoEstudiante(usuarioOptional.get());

            // Guarda el nuevo caso en la base de datos
            GestionCasos nuevoCaso = gestionCasosServicios.insertarCaso(caso);
            return new ResponseEntity<>(nuevoCaso, HttpStatus.CREATED);
        } else {
            // Si el usuario no está registrado, retorna un error 404
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    /*@PostMapping("/insertar")
    public ResponseEntity<GestionCasos> registrarCaso(@RequestBody GestionCasos caso) {
        // Busca al usuario por el documento del estudiante
        Optional<Usuarios> usuarioOptional = serviciosUsuarios.buscarPorDocumento(caso.getDocumentoUsuario());

        if (usuarioOptional.isPresent()) {
            // Asignamos el objeto Usuarios al campo documentoEstudiante en GestionCasos
            caso.setDocumentoEstudiante(usuarioOptional.get());
            // Guarda el nuevo caso
            GestionCasos nuevoCaso = gestionCasosServicios.insertarCaso(caso);
            return new ResponseEntity<>(nuevoCaso, HttpStatus.CREATED);
        } else {
            // Si el usuario no existe, retorna un error
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
*/

    @GetMapping("/consultarLista")
    public ResponseEntity<List<GestionCasos>> consultarListaCasos() {
        List<GestionCasos> listaCasos = gestionCasosServicios.consultarListaCasos();
        return ResponseEntity.ok(listaCasos);
    }

    @GetMapping("/filtrar/{documento}")
    public ResponseEntity<List<GestionCasos>> consultarPorDocumento(@PathVariable String documento) {
        List<GestionCasos> casosFiltrados = gestionCasosServicios.consultarPorDocumento(documento);
        if (casosFiltrados.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(casosFiltrados);
    }

    @DeleteMapping("/eliminar/{numeroCaso}")
    public ResponseEntity<String> eliminarCaso(@PathVariable String numeroCaso) {
        if (gestionCasosServicios.eliminarCaso(numeroCaso)) {
            return ResponseEntity.ok("Caso eliminado exitosamente.");
        } else {
            return new ResponseEntity<>("Caso no encontrado.", HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para actualizar un caso por número de caso
    @PutMapping("/actualizar/{numeroCaso}")
    public ResponseEntity<GestionCasos> actualizarCaso(@PathVariable String numeroCaso, @RequestBody GestionCasos casoActualizado) {
        Optional<GestionCasos> casoOptional = gestionCasosServicios.actualizarCaso(numeroCaso, casoActualizado);
        return casoOptional.map(caso -> new ResponseEntity<>(caso, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
