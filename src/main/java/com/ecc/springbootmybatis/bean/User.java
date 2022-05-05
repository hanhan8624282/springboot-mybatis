package com.ecc.springbootmybatis.bean;

/**
 * @author sunyc
 * @create 2022-04-27 10:30
 */
public class User {
    private Integer id;
    private String email;
    private String name;


    public Integer getID() {
        return id;
    }

    public void setID(Integer ID) {
        this.id = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
