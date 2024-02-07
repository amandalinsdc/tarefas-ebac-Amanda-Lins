package br.com.ebac.memes.services;

import br.com.ebac.memes.entities.Meme;
import br.com.ebac.memes.exceptions.UserOrCategoryNotExistException;
import br.com.ebac.memes.repositories.MemeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@Component
public class MemeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MemeService.class);
    private MemeRepository repository;
    private RestTemplate restTemplate;

    @Value("${application.url}")
    private String baseUrl;

    public MemeService(MemeRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public Meme novoMeme(Meme meme) {
        if(usuarioExiste(meme.getUsuarioId()) && categoriaMemeExiste(meme.getCategoriaMemeId())) {
            LOGGER.info("Criando novo meme: {}", meme.getNome());
            return repository.save(meme);
        }
        LOGGER.warn("Usuario={} ou Categoria={} não existe", meme.getUsuarioId(), meme.getCategoriaMemeId());
        throw new UserOrCategoryNotExistException("Usuário ou categoria não existe");
    }

    public Meme memeDoDia() {
        LOGGER.info("Carregando meme do dia");
        List<Meme> memes = repository.findAll();
        Random random = new Random();
        int randomMemeIndex = random.nextInt(memes.size());

        return memes.get(randomMemeIndex);
    }

    public List<Meme> listaTodosMemes() {
        return repository.findAll();
    }

    private boolean usuarioExiste(Long usuarioId) {
        LOGGER.info("Verifica se usuario {} existe", usuarioId);
        String url = baseUrl + "/get-user/" + usuarioId;
        Long responseId = restTemplate.getForObject(url, Long.class, usuarioId);

        return responseId != null;
    }

    private boolean categoriaMemeExiste(Long categoriaMemeId) {
        LOGGER.info("Verifica se categoria {} existe", categoriaMemeId);
        String url = baseUrl + "/get-category/" + categoriaMemeId;
        Long responseId = restTemplate.getForObject(url, Long.class, categoriaMemeId);

        return responseId != null;
    }
}
