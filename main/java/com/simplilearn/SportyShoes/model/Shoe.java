package com.simplilearn.SportyShoes.model;

import javax.persistence.*;

@Entity
@Table
public class Shoe {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name="shoe_price")
    private long price;

    @Column(name="shoe_name")
    private String shoename;

    @Column(name="date_time")
    private String datetime;


    @Column(name="user_name")
    private String username;

    //setters and getters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getPrice() {
        return price;
    }
    public void setPrice(long price) {
        this.price = price;
    }

    public String getShoename() {
        return shoename;
    }
    public void setShoename(String shoename) {
        this.shoename = shoename;
    }

    public String getDatetime() {
        return datetime;
    }
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
