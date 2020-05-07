package com.project.springproject.service;

import com.project.springproject.dao.CustomerDAO;
import com.project.springproject.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImplementation implements CustomerService {


    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public void delete(int theId) {
        customerDAO.delete(theId);

    }

    @Override
    @Transactional
    public Customer getCustomers(int theId) {
        return customerDAO.getCustomers(theId);
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {

        customerDAO.saveCustomer(customer);

    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {

        return customerDAO.getCustomers();

    }
}
