package ru.innotech.education.rxjava.config;

import com.zaxxer.hikari.HikariDataSource;
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.postgresql.Driver;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.testcontainers.containers.PostgreSQLContainer;

@TestConfiguration
public class DatabaseTestConfiguration {
    private static final String POSTGRES_IMAGE = "postgres:13-alpine";
    private static final String DATABASE_NAME = "rss";
    private static final String USERNAME = "program";
    private static final String PASSWORD = "test";
    private static final int PORT = 5432;

    @Bean
    public PostgreSQLContainer<?> postgres() {
        final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(POSTGRES_IMAGE)
                .withUsername(USERNAME)
                .withPassword(PASSWORD)
                .withDatabaseName(DATABASE_NAME);
        postgres.start();
        return postgres;
    }

    @DependsOn("postgres")
    @Bean(destroyMethod = "close")
    public HikariDataSource dataSource() {
        final HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(postgres().getJdbcUrl());
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        dataSource.setDriverClassName(Driver.class.getCanonicalName());
        return dataSource;
    }

    @Bean
    @DependsOn({ "postgres", "flyway" })
    public ConnectionFactory connectionFactory() {
        return new PostgresqlConnectionFactory(
                PostgresqlConnectionConfiguration.builder()
                        .host(postgres().getHost())
                        .port(postgres().getMappedPort(PORT))
                        .database(DATABASE_NAME)
                        .username(USERNAME)
                        .password(PASSWORD)
                        .build());
    }

    @Bean
    public TransactionManagementConfigurer transactionManagementConfigurer(ReactiveTransactionManager reactiveTransactionManager) {
        return () -> reactiveTransactionManager;
    }
}