package org.example.dao;

import org.example.configuration.DatabaseConfig;
import org.example.models.Product;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class ProductDAO {

    private final JdbcTemplate jdbcTemplate = DatabaseConfig.getJdbcTemplate();

    public List<Product> getProduct(){
        String sql= "select * from product";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<> (Product.class));
    }

    public void addProduct(String name, String description, float price, int quantity, int categoryId){
        String sql = "insert into product (prod_name, prod_desc, prod_price, prod_quantity, category_id) values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, name, description, price, quantity, categoryId);
    }

    public List<Product> getProductByNameOrCategory(String name, int categoryId){
        String sql= "select * from product where prod_name like ? or category_id =?";
        String keyword = "%" + name + "%";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class), keyword, categoryId);
    }

    public void updateProduct(float price, int quantity, String description, int prodId){
        String sql = "update product set prod_price =?, prod_quantity =?, prod_desc =? where prod_id = ?";
        jdbcTemplate.update(sql, price, quantity, description, prodId);
    }

    public void deleteProduct(int prodId){
        String sql = "delete from product where prod_id = ?";
        jdbcTemplate.update(sql, prodId);
    }

    public List<Map<String, Object>> getProductsByCategory(String categoryName) {
        String sql = "SELECT p.prod_id, p.prod_name, p.prod_desc, p.prod_price, p.prod_quantity, c.cat_name " +
                "FROM product p " +
                "LEFT JOIN category c ON p.category_id = c.cat_id " +
                "WHERE c.cat_name = ?";

        return jdbcTemplate.queryForList(sql,categoryName);
    }

    public List<Map<String, Object>> getTopSellingProducts() {
        String sql = "SELECT p.prod_id, p.prod_name, p.prod_desc, p.prod_price, SUM(oi.quantity) AS total_sold " +
                "FROM order_items oi " +
                "JOIN product p ON oi.product_id = p.prod_id " +
                "GROUP BY p.prod_id " +
                "ORDER BY total_sold DESC";

        return jdbcTemplate.queryForList(sql);
    }
}
