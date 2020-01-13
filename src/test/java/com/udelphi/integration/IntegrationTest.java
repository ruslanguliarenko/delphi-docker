package com.udelphi.integration;

import java.util.List;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.jdbc.Sql;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.jdbc.SqlMergeMode;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.sql.DataSource;

@SpringBootTest(webEnvironment = RANDOM_PORT,
        properties = {
                "spring.datasource.platform=postgresql",
                /*"spring.datasource.driver-class-name=org.testcontainers.jdbc.ContainerDatabaseDriver",
                "spring.datasource.url=jdbc:tc:postgresql:9.6.12:///",
                "spring.second-datasource.platform=mysql",
                "spring.second-datasource.driver-class-name=org.testcontainers.jdbc.ContainerDatabaseDriver",
                "spring.second-datasource.url=jdbc:tc:mysql:///"*/
        })
@SqlGroup({
        @Sql(value = "/test-data.sql", executionPhase = BEFORE_TEST_METHOD),
        @Sql(value = "/drop.sql", executionPhase = AFTER_TEST_METHOD)
})
@SqlMergeMode(value = SqlMergeMode.MergeMode.MERGE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IntegrationTest {

    @LocalServerPort
    protected int port;

    @Autowired
    private List<GenericContainer> containers;

    protected static final String TEST_DATA = "/test-test-data.sql";

    @BeforeAll
    void startUpTestContainers(){
        containers.stream().parallel().forEach(GenericContainer::start);
    }

    @BeforeEach
    void setUp() {
        RestAssured.port = port;

        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("john@gmail.com");
        authScheme.setPassword("admin");
        RestAssured.authentication = authScheme;
    }
}
