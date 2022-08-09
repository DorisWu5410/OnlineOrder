package com.doriswu.onlineorder.controller;

import com.doriswu.onlineorder.entity.MenuItem;
import com.doriswu.onlineorder.entity.Restaurant;
import com.doriswu.onlineorder.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MenuInfoController {
    @Autowired
    private MenuInfoService menuInfoService;


    @RequestMapping(value = "/restaurant/{restaurantId}/menu", method = RequestMethod.GET)
//    ResponseBody 讲返回值变成json格式

    @ResponseBody

    public List<MenuItem> getMenus(@PathVariable("restaurantId") int restaurantId) {
        return menuInfoService.getAllMenuItem(restaurantId);
    }

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    @ResponseBody
    public List<Restaurant> getRestaurants() {
        return menuInfoService.getRestaurants();
    }


    @RequestMapping(value = "/restaurant/{restaurantId}/menu/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<MenuItem> getMenuByNameAndR(@PathVariable("restaurantId") int restaurantId, @PathVariable("name") String name){
        return menuInfoService.searchMenuItemByNameAndR(name, restaurantId);
    }

}

