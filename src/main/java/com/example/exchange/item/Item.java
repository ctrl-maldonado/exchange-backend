package com.example.exchange.item;
import com.example.exchange.category.Category;
import com.example.exchange.user.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity( name = "Item" )
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    private String itemName;
    private String description;
    private String color;
    private String brand;
    private Long date;

    @JsonBackReference
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="userId", referencedColumnName="userId")
    private User user;
   
    @JsonBackReference
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="userSavedId", referencedColumnName="userId")
    private User userSaved;

    @JsonBackReference
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="categoryId", referencedColumnName = "categoryId")
    private Category category;

    public Item () {
    }


    

    public Item(int itemId, String itemName, String description, String color, String brand, Long date, User user, Category category) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.description = description;
        this.color = color;
        this.brand = brand;
        this.date = date;
        this.user = user;
        this.category = category;
    }
    
    public int getItemId() {
        return this.itemId;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUserSaved() {
        return this.userSaved;
    }

    public void setUserSaved(User userSaved) {
        this.userSaved = userSaved;
    }


    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }


    public String getBrand() {
        return brand;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }


    public Long getDate() {
        return date;
    }


    public void setDate(Long date) {
        this.date = date;
    }

    
}
