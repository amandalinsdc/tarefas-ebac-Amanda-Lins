package br.com.amanda.vendas.online;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerVendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerVendasApplication.class, args);
	}

}
