package br.com.ebac.categories.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@EnableFeignClients
@EnableDiscoveryClient
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
