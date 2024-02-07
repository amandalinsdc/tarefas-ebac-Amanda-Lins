package br.com.ebac.categories.services;

import br.com.ebac.categories.entities.CategoriaMeme;
import br.com.ebac.categories.exceptions.CategoriaAlreadyExistsException;
import br.com.ebac.categories.repositories.CategoriaMemeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Component
public class CategoriaMemeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaMemeService.class);
    private CategoriaMemeRepository repository;

    private RestTemplate restTemplate;

    @Value("${application.url}")
    private String baseUrl;

    public CategoriaMemeService(CategoriaMemeRepository repository) {
        this.repository = repository;
    }

    public CategoriaMeme novaCategoriaMeme(CategoriaMeme categoriaMeme) {
        CategoriaMeme categoria = buscarPorDescricao(categoriaMeme.getDescricao());
        if(categoria == null || usuarioExiste(categoriaMeme.getUsuarioId())) {
            LOGGER.info("Categoria cadastrada com sucesso");
            return repository.save(categoriaMeme);
        }
        LOGGER.warn("Categoria não cadastrada, '{}' ja existe no banco ou usuarioId={} não existe", categoria.getNome(), categoria.getUsuarioId());
        throw new CategoriaAlreadyExistsException("Categoria já existe ou usuário não existe");
    }

    public List<CategoriaMeme> listaTodasCategorias() {
        return repository.findAll();
    }


    private CategoriaMeme buscarPorDescricao(String descricao) {
        return repository.findByDescricao(descricao);
    }

    public Optional<CategoriaMeme> buscarPorId(Long categoriaId) {
        return repository.findById(categoriaId);
    }

    private boolean usuarioExiste(Long usuarioId) {
        LOGGER.info("Verifica se usuario {} existe", usuarioId);
        String url = baseUrl + "/get-user/" + usuarioId;
        Long responseId = restTemplate.getForObject(url, Long.class, usuarioId);

        return responseId != null;
    }
}
