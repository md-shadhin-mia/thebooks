package com.shadhin.thebooks.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DbConfig {
    @Bean
    public DataSource dataSource(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.postgresql.Driver");
        config.setJdbcUrl("jdbc:postgresql://postgres:n7SWUZ8Gbruqxpu1SSJR@containers-us-west-175.railway.app:6489/railway");
        config.setUsername("postgres");
        config.setPassword("n7SWUZ8Gbruqxpu1SSJR");
        return new HikariDataSource(config);
    }
}
