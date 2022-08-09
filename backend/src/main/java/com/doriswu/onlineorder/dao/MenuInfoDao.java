package com.doriswu.onlineorder.dao;

import com.doriswu.onlineorder.entity.MenuItem;
import com.doriswu.onlineorder.entity.Restaurant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuInfoDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Restaurant> getRestaurants() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Restaurant> criteria = builder.createQuery(Restaurant.class);
            criteria.from(Restaurant.class);
            return session.createQuery(criteria).getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally{
            if(session != null){
                session.close();
            }
        }
        return null;
    }


    public List<MenuItem> getAllMenuItem(int restaurantId) {
        try (Session session = sessionFactory.openSession()) {
            Restaurant restaurant = session.get(Restaurant.class, restaurantId);
            if (restaurant != null) {
                return restaurant.getMenuItemList();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public MenuItem getMenuItem(int menuItemId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(MenuItem.class, menuItemId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<MenuItem> searchItemByNameAndR(String name, int restaurantId) {
        List<MenuItem> menuList = getAllMenuItem(restaurantId);
        List<MenuItem> result = new ArrayList<>();
        for(MenuItem item: menuList){
            String itemName = item.getName();
            if(itemName.indexOf(name) != -1){
                result.add(item);
            }
        }
        return result;
    }

//    public List<MenuItem> searchItemByName(String name){
//        Session session = sessionFactory.getCurrentSession();
//        List<MenuItem> allMenu = session.createCriteria(MenuItem.class).list();
//    }

}
