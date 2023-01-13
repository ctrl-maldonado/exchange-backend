package com.example.exchange.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exchange.user.User;

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

    @RequestMapping(value = "/itemSavedByUser")
    public void itemSavedByUser (@RequestBody User userId, Item itemId) {
        itemService.itemSavedByUser(userId, itemId);
    }
}
