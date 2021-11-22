package com.olivine.mybatis.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.Objects;

/**
 * @author jphao
 * @date 2021/11/21 22:46
 * @description
 */
@Configuration
public class DBConfig {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }
    @Bean
    @ConfigurationProperties("spring.datasource.hikari")
    public HikariDataSource dataSource(DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }


//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.hikari")
//    public HikariDataSource dataSource(){
//        return DataSourceBuilder.create().type(HikariDataSource.class).build();
//    }

/*    @Bean
    public DataSource dataSource(Environment env){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(env.getProperty("db.datasource.hikari.driver-class-name"));
        hikariDataSource.setUsername(env.getProperty("db.datasource.hikari.username"));
        hikariDataSource.setJdbcUrl(env.getProperty("db.datasource.hikari.jdbc-url"));
        hikariDataSource.setPassword(env.getProperty("db.datasource.hikari.password"));
        hikariDataSource.setConnectionTimeout(Long.parseLong(Objects.requireNonNull(env.getProperty("db.datasource.hikari.connection-timeout"))));
        hikariDataSource.setIdleTimeout(Long.parseLong(Objects.requireNonNull(env.getProperty("db.datasource.hikari.idle-timeout"))));
        hikariDataSource.setMaxLifetime(Long.parseLong(Objects.requireNonNull(env.getProperty("db.datasource.hikari.max-lifetime"))));
        hikariDataSource.setMaximumPoolSize(Integer.parseInt(Objects.requireNonNull(env.getProperty("db.datasource.hikari.maximum-pool-size"))));
        return hikariDataSource;
    }*/
}
