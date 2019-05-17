package com.rdba.service;

import com.rdba.model.jpa.item.Item;

import java.util.List;

public interface ItemService {
    Item getById(int id);
    Item save(Item item);
    List<Item> getAllItem();
}
