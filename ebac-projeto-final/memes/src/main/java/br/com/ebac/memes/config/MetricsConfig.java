package br.com.ebac.memes.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {

    @Autowired
    MeterRegistry registry;

    @Bean
    public Counter endpointCounter(MeterRegistry registry) {
        return Counter.builder("endpoint.invocation.counter")
                .description("Contador de chamadas do endpoint")
                .register(registry);
    }
}
