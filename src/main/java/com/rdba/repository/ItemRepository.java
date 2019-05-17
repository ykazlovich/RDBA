package com.rdba.repository;

import com.rdba.model.jpa.item.Item;

import java.util.List;

public interface ItemRepository {

    Item getById(int id);

    Item save(Item item);

    List<Item> getAllItem();

}
