package br.com.ebac.memes.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@Import(FeignCommonConfiguration.class)
public class CategoriaMemeFeign {

    @Autowired
    private CategoriasMeme categorias;

    @FeignClient(name = "CategoriasMemes")
    interface CategoriasMeme {
        @RequestMapping(path = "/categorias/get-category/{categoriaId}", method = RequestMethod.GET)
        @ResponseBody
        Long getCategoriaMeme(@PathVariable("categoriaId") Long categoriaId);
    }

    public Long getCategoriaMeme(Long categoriaId) {
        return categorias.getCategoriaMeme(categoriaId);
    }
}
