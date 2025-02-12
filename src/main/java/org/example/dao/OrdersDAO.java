package org.example.dao;

import org.example.configuration.DatabaseConfig;
import org.example.models.OrderItem;
import org.example.models.Orders;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrdersDAO {
    private final JdbcTemplate jdbcTemplate = DatabaseConfig.getJdbcTemplate();

    // Create a new order with multiple products
    public void createOrder(int customerId, List<OrderItem> orderItems) {
        // Insert order and get order ID
        String orderSql = "INSERT INTO orders (order_status, customer_id) VALUES ('Pending', ?)";
        jdbcTemplate.update(orderSql, customerId);

        // Get the latest inserted order ID
        String getOrderIdSql = "SELECT MAX(order_id) FROM orders WHERE customer_id = ?";
        int orderId = jdbcTemplate.queryForObject(getOrderIdSql, Integer.class, customerId);

        // Insert order items
        String orderItemSql = "INSERT INTO order_items (order_id, product_id, quantity) VALUES (?, ?, ?)";

        for (OrderItem item : orderItems) {
            jdbcTemplate.update(orderItemSql, orderId, item.getProduct_id(), item.getQuantity());
        }

        System.out.println("Order created successfully with ID: " + orderId);
    }


    public Orders getOrderById(int orderId) {
        String orderSql = "SELECT * FROM orders WHERE order_id = ?";
        Orders order = jdbcTemplate.queryForObject(orderSql, new BeanPropertyRowMapper<>(Orders.class), orderId);

        String orderItemsSql = "SELECT * FROM order_items WHERE order_id = ?";
        List<OrderItem> orderItems = jdbcTemplate.query(orderItemsSql, new BeanPropertyRowMapper<>(OrderItem.class), orderId);
        order.setOrderItems(orderItems);

        return order;
    }

    public List<Map<String, Object>> viewOrderDetails() {
        String sql = "SELECT o.customer_id,o.order_id, o.order_status, SUM(oi.quantity * p.prod_price) AS total_price FROM orders AS o LEFT JOIN order_items AS oi ON o.order_id = oi.order_id LEFT JOIN product AS p ON oi.product_id = p.prod_id GROUP BY o.order_id";
        return jdbcTemplate.queryForList(sql);
    }

    public void UpdateOrderStatus(String orderStatus, int orderId) {
        String sql = "update orders set order_status = ? where order_id = ?";
        int result = jdbcTemplate.update(sql, orderStatus, orderId);
        if (result > 0){
            System.out.println("Order Status Updated Successfully.");
        }else{
            System.out.println("Failed to update.");
        }
    }


    public void cancelOrder(int orderId) {
        String sql = "UPDATE orders SET order_status = 'Cancelled' WHERE order_id = ?";
        int rowsUpdated = jdbcTemplate.update(sql, orderId);

        if (rowsUpdated > 0) {
            System.out.println("Order ID " + orderId + " has been cancelled.");
        } else {
            System.out.println("Order ID " + orderId + " not found.");
        }
    }

    public List<Map<String, Object>> getOrdersWithinDateRange(Date startDate, Date endDate) {
        String sql = "SELECT * FROM orders WHERE created_date BETWEEN ? AND ? ORDER BY created_date DESC";
        return jdbcTemplate.queryForList(sql, startDate, endDate);
    }

}
