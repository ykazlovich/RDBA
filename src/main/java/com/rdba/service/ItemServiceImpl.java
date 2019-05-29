package com.rdba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rdba.model.jpa.item.Item;
import com.rdba.repository.ItemRepository;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository repository;

    @Override
    public List<Item> findByModelOrSerialNumber(String search) {
        return repository.findByModelOrSerialNumber(search);
    }

    @Override
    public List<Item> getAllItem() {
        return repository.getAllItem();
    }

    @Override
    public Item getById(int id) {
        return repository.getById(id);
    }

    @Override
    public Item save(Item item) {
        return repository.save(item);
    }
}
