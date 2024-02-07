package br.com.ebac.memes.controllers;

import br.com.ebac.memes.entities.Meme;
import br.com.ebac.memes.exceptions.UserOrCategoryNotExistException;
import br.com.ebac.memes.feign.CategoriaMemeFeign;
import br.com.ebac.memes.feign.UserFeign;
import br.com.ebac.memes.services.MemeService;
import io.micrometer.core.instrument.Counter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memes")
public class MemesController {

    private MemeService service;
    private UserFeign userFeign;
    private CategoriaMemeFeign categoriaMemeFeign;
    private Counter endpointCounter;

    public MemesController(MemeService service, UserFeign userFeign,
                           CategoriaMemeFeign categoriaMemeFeign, Counter endpointCounter) {
        this.service = service;
        this.userFeign = userFeign;
        this.categoriaMemeFeign = categoriaMemeFeign;
        this.endpointCounter = endpointCounter;
    }

    @GetMapping()
    public List<Meme> buscaMemes() {
        endpointCounter.increment();
        return service.listaTodosMemes();
    }

    @PostMapping()
    public ResponseEntity<String> novoMeme(@RequestBody Meme meme) {
        try {
            endpointCounter.increment();
            service.novoMeme(meme);
            return ResponseEntity.status(HttpStatus.CREATED).body("Meme criado com sucesso");
        } catch (UserOrCategoryNotExistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário não existe");
        }
    }

    @GetMapping("/meme-do-dia")
    public Meme memeDoDia() {
        endpointCounter.increment();
        return service.memeDoDia();
    }

    @GetMapping("/get-user/{usuarioId}")
    public Long getUser(@PathVariable("usuarioId") Long usuarioId) {
        endpointCounter.increment();
        return userFeign.getUser(usuarioId);
    }

    @GetMapping("/get-category/{categoriaId}")
    public Long getCategoriaMeme(@PathVariable("categoriaId") Long categoriaId) {
        endpointCounter.increment();
        return categoriaMemeFeign.getCategoriaMeme(categoriaId);
    }
}
