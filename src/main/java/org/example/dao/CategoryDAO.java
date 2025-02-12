package org.example.dao;

import net.sf.jsqlparser.schema.Database;
import org.example.configuration.DatabaseConfig;
import org.example.models.Category;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDAO {

    private final JdbcTemplate jdbcTemplate = DatabaseConfig.getJdbcTemplate();

    public List<Category> getCategory(){

        String sql= "select * from category";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<> (Category.class));
    }

    public void addCategory(String name, String description){

        String sql = "insert into category(cat_name, cat_desc) values (?, ?)";
        jdbcTemplate.update(sql, name, description);
    }


}
