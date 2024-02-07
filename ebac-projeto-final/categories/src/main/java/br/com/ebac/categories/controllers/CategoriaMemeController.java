package br.com.ebac.categories.controllers;

import br.com.ebac.categories.entities.CategoriaMeme;
import br.com.ebac.categories.exceptions.CategoriaAlreadyExistsException;
import br.com.ebac.categories.feign.UserFeign;
import br.com.ebac.categories.services.CategoriaMemeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaMemeController {

    private CategoriaMemeService service;
    private UserFeign userFeign;

    public CategoriaMemeController(CategoriaMemeService service, UserFeign userFeign) {
        this.service = service;
        this.userFeign = userFeign;
    }

    @GetMapping()
    public List<CategoriaMeme> buscaCategorias() {
        return service.listaTodasCategorias();
    }

    @PostMapping()
    public ResponseEntity<String> novaCategoria(@RequestBody CategoriaMeme categoriaMeme) {
        try {
            service.novaCategoriaMeme(categoriaMeme);
            return ResponseEntity.status(HttpStatus.CREATED).body("Categoria criada com sucesso");
        } catch (CategoriaAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Categoria já existe ou usuário não existe");
        }
    }

    @GetMapping("/get-category/{categoriaId}")
    public Long getCategoriaMeme(@PathVariable("categoriaId") Long categoriaId) {
        Optional<CategoriaMeme> categoria = service.buscarPorId(categoriaId);

        if(categoria.isEmpty()) {
            return null;
        }
        return categoria.get().getId();
    }

    @GetMapping("/get-user/{usuarioId}")
    public Long getUser(@PathVariable("usuarioId") Long usuarioId) {
        return userFeign.getUser(usuarioId);
    }
}
