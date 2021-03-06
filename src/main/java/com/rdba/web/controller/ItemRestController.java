package com.rdba.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.rdba.model.jpa.item.Item;
import com.rdba.service.ItemService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/v1/items")
public class ItemRestController {

    @Autowired
    private ItemService service;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/"
    )
    public List<Item> getAllItem() {
        List<Item> listItems = service.getAllItem();
        return listItems;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Item save(@RequestBody Item item) {
        return service.save(item);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Item> findByModelOrSerialNumber(@RequestParam(value = "search") String search) {
        return service.findByModelOrSerialNumber(search);
    }


}
