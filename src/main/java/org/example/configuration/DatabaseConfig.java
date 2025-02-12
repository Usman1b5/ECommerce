package org.example.configuration;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class DatabaseConfig {
    public static JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    private static DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/ecommerce");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

}
