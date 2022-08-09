package com.doriswu.onlineorder.entity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


//set class to table in Mysql
@Entity
@Table(name = "authorities")
// Serializable 将obj从内存存到硬盘(DB)
public class Authorities implements Serializable {

//    序列号indicates业务逻辑版本
    private static final long serialVersionUID = 8734140534986494039L;

    @Id
    private String email;

    private String authorities;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}
