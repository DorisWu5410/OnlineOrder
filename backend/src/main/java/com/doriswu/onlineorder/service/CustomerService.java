package com.doriswu.onlineorder.service;

import com.doriswu.onlineorder.dao.CustomerDao;
import com.doriswu.onlineorder.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.doriswu.onlineorder.dao.CustomerDao;
import com.doriswu.onlineorder.entity.Cart;
import com.doriswu.onlineorder.entity.Customer;

@Service
public class CustomerService {

    private CustomerDao customerDao;

    @Autowired
    public CustomerService(CustomerDao customerDao) {

        this.customerDao = customerDao;
    }

    public void signUp(Customer customer) {
        Cart cart = new Cart();
        customer.setCart(cart);

        customer.setEnabled(true);
        customerDao.signUp(customer);
    }


    public Customer getCustomer(String email) {
        return customerDao.getCustomer(email);
    }
}





