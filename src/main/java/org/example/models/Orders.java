package org.example.models;

import java.util.Date;
import java.util.List;

public class Orders {
    private int order_Id;
    private String order_Status;
    private int customer_Id;
    private List<OrderItem> orderItems;
    private Date created_date;

    public Orders(){}

    public Orders(int order_Id, String order_Status, int customer_Id, List<OrderItem> orderItems) {
        this.order_Id = order_Id;
        this.order_Status = order_Status;
        this.customer_Id = customer_Id;
        this.orderItems = orderItems;
    }

    public int getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(int order_Id) {
        this.order_Id = order_Id;
    }

    public String getOrder_Status() {
        return order_Status;
    }

    public void setOrder_Status(String order_Status) {
        this.order_Status = order_Status;
    }

    public int getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(int customer_Id) {
        this.customer_Id = customer_Id;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Date getCreatedDate() {
        return created_date;
    }

    public void setCreatedDate(Date created_date) {
        this.created_date = created_date;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order_Id=" + order_Id +
                ", order_Status='" + order_Status + '\'' +
                ", customer_Id=" + customer_Id +
                ", orderItems=" + orderItems +
                ", created_date=" + created_date +
                '}';
    }
}


