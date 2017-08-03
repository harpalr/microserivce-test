package com.tenx.ms.retail.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customer/all")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomer();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/customer/add")
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/customer/update/{customer_id}")
    public void updateCustomer(@PathVariable("customer_id") int customer_id, @RequestBody Customer customer){
        customerService.updateCustomer(customer_id, customer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/customer/delete/{customer_id}")
    public void deteleCustomer(@PathVariable int customer_id){
        customerService.deleteCustomer(customer_id);
    }
}
