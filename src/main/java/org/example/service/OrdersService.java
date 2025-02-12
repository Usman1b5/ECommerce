package org.example.service;

import org.example.dao.OrdersDAO;
import org.example.models.OrderItem;
import org.example.models.Orders;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrdersService {

    private OrdersDAO ordersDAO = new OrdersDAO();

    public void createOrder(int customerId, List<OrderItem> orderItems) {
        ordersDAO.createOrder(customerId, orderItems);
    }

    public Orders getOrderById(int orderId) {
        return ordersDAO.getOrderById(orderId);
    }

    public List<Map<String, Object>> viewOrderDetails() {
        return ordersDAO.viewOrderDetails();
    }

    public void updateOrderStatus(String orderStatus, int orderId) {
        System.out.println("This is update dfunction");
        ordersDAO.UpdateOrderStatus(orderStatus, orderId);
    }

    public void cancelOrder(int customerId) {
        ordersDAO.cancelOrder(customerId);
        System.out.println("yo");
    }

    public List<Map<String, Object>> fetchOrdersWithinDateRange(Date startDate, Date endDate) {
        return ordersDAO.getOrdersWithinDateRange(startDate, endDate);
    }

}
