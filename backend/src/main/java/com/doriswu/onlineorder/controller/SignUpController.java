package com.doriswu.onlineorder.controller;
import com.doriswu.onlineorder.entity.Customer;
import com.doriswu.onlineorder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@Controller
public class SignUpController {
    private CustomerService customerService;

    @Autowired
    public SignUpController(CustomerService customerService){
        this.customerService = customerService;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
//    @RequestBody maps the request body to an object (customer)
    public void signUp(@RequestBody Customer customer){
        customerService.signUp(customer);
    }

}
