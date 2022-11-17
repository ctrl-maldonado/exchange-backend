package com.example.exchange.item;

import javax.persistence.*;

@Entity( name = "Item" )
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    private String itemName;
}
