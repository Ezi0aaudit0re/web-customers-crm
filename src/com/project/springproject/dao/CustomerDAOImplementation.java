package com.project.springproject.dao;

import com.project.springproject.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

// tell spring this is our DAO implementation
@Repository
public class CustomerDAOImplementation implements CustomerDAO {


    @Override
    public void delete(int theId) {

        if(theId == 0){ return; }

        // get session
        Session session = sessionFactory.getCurrentSession();


        // delete customer
        Query theQuery = session.createQuery("delete from Customer where id=:theCustomerId");
        theQuery.setParameter("theCustomerId", theId);


        theQuery.executeUpdate();

    }

    // need to inject session Factory
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Customer getCustomers(int theId) {
        // get a session
        Session session = sessionFactory.getCurrentSession();


        Customer theCustomer = session.get(Customer.class, theId);

        return theCustomer;


    }

    @Override
    public void saveCustomer(Customer customer) {

        if(customer == null){
            System.out.println("Customer is None");
            return;
        }

        Session currentSession = sessionFactory.getCurrentSession();

        // save / update the customer
        currentSession.saveOrUpdate(customer);

    }

    @Override
    public List<Customer> getCustomers() {


        // get current hibernate session
        // create use of injected session Factory
        Session currentSession = sessionFactory.getCurrentSession();

        // create query sorted by last name
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);


        // execute the query
        List<Customer> customers = theQuery.getResultList();


        // return results
        return customers;
    }
}
