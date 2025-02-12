package org.example.service;

import org.example.dao.CustomerDAO;
import org.example.models.Customer;

import java.math.BigInteger;
import java.util.List;

public class CustomerService {

    private CustomerDAO customerDAO = new CustomerDAO();

    public List<Customer> getCustomer(){
        return customerDAO.getCustomer();
    }

    public void addCustomer(String custName, String custAddress, BigInteger custPhoneNo){
        customerDAO.addCustomer(custName, custAddress, custPhoneNo);
    }

    public List<Customer> getCustomersByName(String custName){
        return customerDAO.getCustomersByName(custName);
    }
}
