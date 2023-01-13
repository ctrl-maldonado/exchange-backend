package com.example.exchange.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.exchange.item.Item;
import com.example.exchange.user.User;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    Item findByItemId (Item itemId);
    List<Item> findByUser(User userId);
    List<Item> findByUserSaved(User userId);

}
