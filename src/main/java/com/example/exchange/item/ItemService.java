package com.example.exchange.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exchange.Repository.CategoryRepository;
import com.example.exchange.Repository.ItemRepository;
import com.example.exchange.category.Category;
import com.example.exchange.user.User;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public void addItem(Item item) {
        item.setDate(System.currentTimeMillis());
        itemRepository.save(item);
    }

    public List<Item> getUserItems(User userId) {
        return itemRepository.findByUser(userId);
    }

    public List<Item> getUserSavedItems(User userId) {
        return itemRepository.findByUserSaved(userId);
    }

    /*public void itemSavedByUser(User userId, Item itemId) {
        Item item = itemRepository.findByItemId(itemId);
        item.setUserSaved(userId);
        itemRepository.save(item);
    }*/

    public List<Item> getItemByCategoryId(int categoryId) {
        Category category = categoryRepository.findByCategoryId(categoryId);
        return itemRepository.findByCategory(category);
    }

    public Item getById(Integer itemId) {
        return itemRepository.findByItemId(itemId);
    }
}
