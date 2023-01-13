package com.example.exchange.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.example.exchange.item.Item;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity( name = "ExchangeUser" )
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String userName;
    private String address;
    private String email;
    private double rating;
    private String password;
    private String token;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Item> itemList = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "userSaved")
    private Set<Item> savedItems = new HashSet<>();
    
    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(int userId, String userName, String address, String email, double rating, String password, String token,
            Set<Item> itemList, Set<Item> savedItems) {
        this.userId = userId;
        this.userName = userName;
        this.address = address;
        this.email = email;
        this.rating = rating;
        this.password = password;
        this.token = token;
        this.itemList = itemList;
        this.savedItems = savedItems;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Set<Item> getItemList() {
        return itemList;
    }

    public Set<Item> getSavedItems() {
        return savedItems;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setItemList(Set<Item> itemList) {
        this.itemList = itemList;
    }

    public void setSavedItems(Set<Item> savedItems) {
        this.savedItems = savedItems;
    }
    
}