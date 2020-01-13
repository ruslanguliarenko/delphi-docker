package com.udelphi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.PostgreSQLContainer;

@Configuration
public class TestContainerConfig {

    @Bean
    public PostgreSQLContainer postgreSQLContainer2(){
        PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer();
        return postgreSQLContainer;
    }

    @Bean
    public MySQLContainer mySQLContainer2(){
        return new MySQLContainer();
    }
}
