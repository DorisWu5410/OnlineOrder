package com.doriswu.onlineorder.service;
import com.doriswu.onlineorder.dao.MenuInfoDao;
import com.doriswu.onlineorder.entity.Restaurant;
import com.doriswu.onlineorder.dao.MenuInfoDao;
import com.doriswu.onlineorder.entity.MenuItem;
import com.doriswu.onlineorder.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuInfoService {

    @Autowired
    private MenuInfoDao menuInfoDao;

    public List<Restaurant> getRestaurants(){
        return menuInfoDao.getRestaurants();
    }

    public List<MenuItem> getAllMenuItem(int restaurantId){

        return menuInfoDao.getAllMenuItem(restaurantId);
    }

    public MenuItem getMenuItem(int id){
        return menuInfoDao.getMenuItem(id);
    }

    public List<MenuItem> searchMenuItemByNameAndR(String name, int restaurantId){
        return menuInfoDao.searchItemByNameAndR(name, restaurantId);
    }

}
