package com.project.springproject.controller;

import com.project.springproject.entity.Customer;
import com.project.springproject.service.CustomerService;
import com.project.springproject.service.CustomerServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    // inject Service layer
    // since we used @Service spring find the service automatically.
    @Autowired
    private CustomerService customerService;


    @GetMapping("/list")
    public String listCustomers(Model model){


        // get customers from Service
        List<Customer> theCustomers = customerService.getCustomers();



        // add to the spring MVC model
        model.addAttribute("customers", theCustomers);


        return "list-customers";
    }


    @GetMapping("/showFormForAdd")
    public String showNewCustomerForm(Model model){

        Customer customer = new Customer();

        model.addAttribute("customer", customer);

        return "customer-form";
    }


    @PostMapping("/saveCustomer")
    public String addCustomer(@ModelAttribute("customer") Customer theCustomer){




        // save customer using service
        customerService.saveCustomer(theCustomer);

        // this is how we redirect
        return "redirect:/customer/list";

    }


    @GetMapping("/showFormForUpdate")
    public String showUpdateCustomerForm(@RequestParam("customerId") int theId, Model model){

        // get the customer from the database
        Customer theCustomer = customerService.getCustomers(theId);


        // set is as model attribute
        model.addAttribute("customer", theCustomer);


        return "customer-form";

    }


    @GetMapping("/delete")
    public String deleteUser(@RequestParam("customerId") int theId, Model model){

        customerService.delete(theId);

        return "redirect:/customer/list";
    }

}
