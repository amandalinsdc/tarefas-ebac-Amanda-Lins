package br.com.ebac.users.services;

import br.com.ebac.users.entities.Usuario;
import br.com.ebac.users.repositories.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UsuarioService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);
    private UsuarioRepository repository;

     public UsuarioService(UsuarioRepository repository) {
         this.repository = repository;
     }

    public Usuario novoUsuario(Usuario usuario) {
        LOGGER.info("Criando novo usuario: {}", usuario.getNome());
        return repository.save(usuario);
    }

    public List<Usuario> listaTodosUsuarios() {
        return repository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long usuarioId) {
         return repository.findById(usuarioId);
    }
}
