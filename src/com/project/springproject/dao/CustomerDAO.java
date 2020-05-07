package com.project.springproject.dao;

import com.project.springproject.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();


    void saveCustomer(Customer customer);

    Customer getCustomers(int theId);

    void delete(int theId);
}
