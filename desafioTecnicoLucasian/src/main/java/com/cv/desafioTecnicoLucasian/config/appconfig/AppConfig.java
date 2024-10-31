package com.cv.desafioTecnicoLucasian.config.appconfig;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
@PropertySource("classpath:message.properties")
public class AppConfig {
}
