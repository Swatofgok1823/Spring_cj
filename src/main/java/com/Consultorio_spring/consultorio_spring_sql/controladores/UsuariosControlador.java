    package com.Consultorio_spring.consultorio_spring_sql.controladores;

    import com.Consultorio_spring.consultorio_spring_sql.Entidades.Rol;
    import com.Consultorio_spring.consultorio_spring_sql.Entidades.Usuarios;
    import com.Consultorio_spring.consultorio_spring_sql.servicios.Servicios_Usuarios;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.Collections;
    import java.util.List;
    import java.util.Map;
    import java.util.Optional;

    @RestController
    @RequestMapping("/usuarios")
    @CrossOrigin(origins = "http://localhost:5173")
    public class UsuariosControlador {

        @Autowired
        private Servicios_Usuarios serviciosUsuarios;


        @GetMapping
        public List<Usuarios> getUsuarios() {
            return serviciosUsuarios.getLista();
        }

        @PostMapping("/aggusuarios")
        public String addUsuario(@RequestBody Usuarios usuario) {
            // Verifica si el documento ya existe
            for (Usuarios u : serviciosUsuarios.getLista()) {
                if (u.getDocumento().equals(usuario.getDocumento())) {
                    return "El usuario con el documento " + usuario.getDocumento() + " ya existe.";
                }
            }

            // Si el documento no existe, agrega el usuario
            serviciosUsuarios.agregar(usuario);
            return "Usuario agregado exitosamente.";
        }

        @DeleteMapping("/{documento}")
        public ResponseEntity<Void> deleteUsuario(@PathVariable String documento) {
            serviciosUsuarios.deleteUsuario(documento);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @PostMapping("/login")
        public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
            String documento = credentials.get("documento");
            String password = credentials.get("password");

            Usuarios usuario = serviciosUsuarios.login(documento, password);

            if (usuario != null) {
                return ResponseEntity.ok(usuario);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
            }
        }

        @PutMapping("/modificar/{documento}")
        public ResponseEntity<Usuarios> actualizarUsuario(@PathVariable String documento, @RequestBody Usuarios usuarioActualizado) {
            Usuarios usuarioExistente = serviciosUsuarios.getUsuarioPorDocumento(documento);

            if (usuarioExistente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            // Actualiza todos los campos del usuario
            usuarioExistente.setNombre(usuarioActualizado.getNombre());
            usuarioExistente.setApellido(usuarioActualizado.getApellido());
            usuarioExistente.setCorreo(usuarioActualizado.getCorreo());
            usuarioExistente.setPassword(usuarioActualizado.getPassword());
            usuarioExistente.setRol(usuarioActualizado.getRol());

            serviciosUsuarios.agregar(usuarioExistente); // Guarda el usuario actualizado

            return ResponseEntity.ok(usuarioExistente); // Retorna los datos del usuario modificado
        }



    }
