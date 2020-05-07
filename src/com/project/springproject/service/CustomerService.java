package com.project.springproject.service;

import com.project.springproject.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();
    Customer getCustomers(int theId);
    void saveCustomer(Customer customer);

    void delete(int theId);
}
