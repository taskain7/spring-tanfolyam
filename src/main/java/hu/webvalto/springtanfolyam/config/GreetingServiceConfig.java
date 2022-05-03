package hu.webvalto.springtanfolyam.config;

import hu.webvalto.springtanfolyam.services.ConstructorGreetingServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingServiceConfig {

    @Bean
    ConstructorGreetingServiceImpl constructorGreetingService() {
        return new ConstructorGreetingServiceImpl();
    }
}
