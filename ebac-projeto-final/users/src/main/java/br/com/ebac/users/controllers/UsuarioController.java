package br.com.ebac.users.controllers;

import br.com.ebac.users.entities.Usuario;
import br.com.ebac.users.services.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);
    private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Usuario> buscaUsuarios() {
        return service.listaTodosUsuarios();
    }

    @PostMapping()
    public Usuario novoUsuario(@RequestBody Usuario usuario) {
        LOGGER.info("Criando novo usuário: {}", usuario.getNome());
        return service.novoUsuario(usuario);
    }

    @GetMapping("/get-user/{usuarioId}")
    public Long getUsuario(@PathVariable("usuarioId") Long usuarioId) {
        Optional<Usuario> user = service.buscarPorId(usuarioId);

        if(user.isEmpty()) {
            return null;
        }
        return user.get().getId();
    }
}
