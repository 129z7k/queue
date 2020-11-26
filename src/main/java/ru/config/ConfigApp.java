package ru.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
@PropertySource("classpath:/scheduler.properties")
public class ConfigApp {

}

