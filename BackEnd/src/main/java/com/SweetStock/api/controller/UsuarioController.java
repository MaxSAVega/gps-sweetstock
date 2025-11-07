package com.SweetStock.api.controller;

import com.SweetStock.api.dto.LoginRequest;
import com.SweetStock.api.model.Usuario;
import com.SweetStock.api.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/usuarios")
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        Optional<Usuario> usuarioOpt = usuarioRepository.findByNombre(request.getUsername());

        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(401).body("Usuario no encontrado");
        }

        Usuario usuario = usuarioOpt.get();

        // ⚠️ TEMPORAL: comparación directa (luego lo cambiamos por BCrypt)
        if (!usuario.getPassword().equals(request.getPassword())) {
            return ResponseEntity.status(401).body("Contraseña incorrecta");
        }

        // Si todo OK
        return ResponseEntity.ok(Map.of(
            "mensaje", "Login exitoso",
            "rol", usuario.getRol(),
            "id", usuario.getId(),
            "nombre", usuario.getNombre()
        ));
    }
}
