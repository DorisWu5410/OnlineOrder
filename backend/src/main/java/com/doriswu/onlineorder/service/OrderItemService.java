package com.doriswu.onlineorder.service;
import com.doriswu.onlineorder.dao.CartDao;
import com.doriswu.onlineorder.dao.OrderItemDao;

import com.doriswu.onlineorder.entity.Cart;
import com.doriswu.onlineorder.entity.Customer;
import com.doriswu.onlineorder.entity.MenuItem;
import com.doriswu.onlineorder.entity.OrderItem;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.hibernate.SessionFactory;
@Service

public class OrderItemService {

    @Autowired
    private MenuInfoService menuInfoService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    private CartDao cartDao;


    public void saveOrderItem(int menuId) {
//        final OrderItem orderItem = new OrderItem();
        final MenuItem menuItem = menuInfoService.getMenuItem(menuId);

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        Customer customer = customerService.getCustomer(username);

        OrderItem orderItem = cartDao.getOrderItemByMenuId(menuId, customer.getCart());

        if(orderItem == null){
            orderItem = new OrderItem();
            orderItem.setMenuItem(menuItem);
            orderItem.setCart(customer.getCart());
        }

        orderItem.setQuantity(orderItem.getQuantity() + 1);
        orderItem.setPrice(menuItem.getPrice() * orderItem.getQuantity());
        orderItemDao.saveOrUpdate(orderItem);
    }
}




