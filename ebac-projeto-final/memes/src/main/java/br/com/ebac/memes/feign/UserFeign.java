package br.com.ebac.memes.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.*;

@Configuration
@Import(FeignCommonConfiguration.class)
public class UserFeign {

    @Autowired
    private Users users;

    @FeignClient(name = "Usuarios")
    interface Users {
        @RequestMapping(path = "/users/get-user/{usuarioId}", method = RequestMethod.GET)
        @ResponseBody
        Long getUser(@PathVariable("usuarioId") Long usuarioId);
    }

    public Long getUser(Long usuarioId) {
        return users.getUser(usuarioId);
    }
}
