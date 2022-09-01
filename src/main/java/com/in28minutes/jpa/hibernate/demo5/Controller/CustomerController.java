package com.in28minutes.jpa.hibernate.demo5.Controller;

import com.in28minutes.jpa.hibernate.demo5.entity.Customer;
import com.in28minutes.jpa.hibernate.demo5.repository.CustomerRepositery;
import com.in28minutes.jpa.hibernate.demo5.repository.CustomerRepositeryWithEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepositery customerRepositery;

    @Autowired
    private CustomerRepositeryWithEntityManager crwe;

    @RequestMapping("/customers")
    public List<Customer> getAllCustomers(){
        List<Customer> customers = new ArrayList<>();
        customerRepositery.findAll().forEach(customers::add);
        return customers;
    }

    @RequestMapping("/customers/{id}")
    public Optional<Customer> getCustomerbyid(@PathVariable int id){
        return customerRepositery.findById(id);
    }
    @RequestMapping("/customersManager/{id}")
    public Customer getCustomerbyidWEntityManager(@PathVariable int id){
        return crwe.findById(id);
    }

    @RequestMapping(method= RequestMethod.POST,value="/customers")
    public void addCustomer (@RequestBody Customer new_customer){
        customerRepositery.save(new_customer);
    }


    @RequestMapping(method= RequestMethod.PUT,value="/customers/{id}")
    public void updateCustomer (@RequestBody Customer updated_customer , @PathVariable int id){
        customerRepositery.save(updated_customer);
    }


    @RequestMapping(method= RequestMethod.DELETE,value="/customers/{id}")
    public void deleteCutsomer(@PathVariable int id){
        customerRepositery.deleteById(id);
    }
//

}
