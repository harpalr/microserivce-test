package com.tenx.ms.retail.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomer(){
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void updateCustomer(int customer_id, Customer customer){
        customer.setId(customer_id);
        customerRepository.save(customer);
    }

    public void deleteCustomer(int id){
        customerRepository.delete(id);
    }
}
