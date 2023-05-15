package com.example.demo;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    private final UsuarioRepository repository;

    public RedisController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/redis/save")
    public ResponseEntity<?> load() {
        Usuario usuario = new Usuario();

        usuario.setId("luccas");
        usuario.setUsername("luccas");
        usuario.setNome("Luccas de Freitas");
        usuario.setPassword(new BCryptPasswordEncoder().encode("1234"));
        usuario.setEnabled(true);
        usuario.setAccountExpired(false);
        usuario.setAccountLocked(false);

        repository.save(usuario);

        return ResponseEntity.ok().build();
    }
}
