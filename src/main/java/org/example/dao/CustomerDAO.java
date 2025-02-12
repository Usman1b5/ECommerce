package org.example.dao;

import org.example.configuration.DatabaseConfig;
import org.example.models.Customer;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigInteger;
import java.util.List;

public class CustomerDAO {

    private final JdbcTemplate jdbcTemplate = DatabaseConfig.getJdbcTemplate();

    public List<Customer> getCustomer(){
        String sql = "select * from customer";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class));
    }

    public void addCustomer(String custName, String custAddress, BigInteger custPhoneNo){
        String sql = "insert into customer(cust_name, cust_address, cust_phone) values (?, ?, ?)";
        int result = jdbcTemplate.update(sql, custName, custAddress, custPhoneNo);
        if (result > 0){
            System.out.println("Customer Data Added Successfully.");
        }else{
            System.out.println("Customer Failed to add.");
        }
    }

    public List<Customer> getCustomersByName(String custName){
        String sql = "select * from customer where trim(cust_name) = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class), custName);
    }
}
