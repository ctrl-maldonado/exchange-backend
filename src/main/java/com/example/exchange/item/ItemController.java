package com.example.exchange.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exchange.user.User;
import com.example.exchange.user.UserService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/items")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @RequestMapping(value = "/addItem")
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
    }

    @RequestMapping(value = "/userItems")
    public List<Item> getUserItems (@RequestBody User userId) {
        return itemService.getUserItems(userId);
    }

    @RequestMapping(value = "/userSavedItems")
    public List<Item> getUserSavedItems (@RequestBody User userId) {
        return itemService.getUserSavedItems(userId);
    }

    /*@RequestMapping(value = "/itemSavedByUser")
    public void itemSavedByUser (@RequestBody User userId, Item itemId) {q
        itemService.itemSavedByUser(userId, itemId);
    }*/

    @RequestMapping(value="/item/{categoryId}")
    public List<Item> getItemsByCategoryId (@PathVariable Integer categoryId){
        return itemService.getItemByCategoryId(categoryId);
    }

    @RequestMapping(value="/findByItemId/{itemId}")
    public Item getItem(@PathVariable Integer itemId) {
        return itemService.getById(itemId);
    }
    
}
