    package com.Consultorio_spring.consultorio_spring_sql.controladores;

    import com.Consultorio_spring.consultorio_spring_sql.Entidades.Usuarios;
    import com.Consultorio_spring.consultorio_spring_sql.servicios.Servicios_Usuarios;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    //@RequestMapping("/usuarios")
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
                if (u.getDocumento() == (usuario.getDocumento())) {
                    return "El usuario con el documento " + usuario.getDocumento() + " ya existe.";
                }
            }

            // Si el documento no existe, agrega el usuario
            serviciosUsuarios.agregar(usuario);
            return "Usuario agregado exitosamente.";
        }


    }
