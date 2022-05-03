package hu.webvalto.springtanfolyam.config;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("datasource")
@Configuration
@Data
public class DatasourceProperties {

    @Value("url")
    private String jdbcUrl;
    private String username;
    private String password;
}
