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


    public Item( String itemName, User user, User userSaved, Category category) {
        this.itemName = itemName;
        this.user = user;
        this.userSaved = userSaved;
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
}
