package com.doriswu.onlineorder.entity;

// POJO: 无逻辑功能的class (Order, Menu), 一般放在entity package里.
// 功能性class： UserService， MenuFactory.
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {

    private static final long serialVersionUID = 2652327633296064143L;

    @Id
    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private boolean enabled;

//    create foreign key Cart
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Cart cart;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}




