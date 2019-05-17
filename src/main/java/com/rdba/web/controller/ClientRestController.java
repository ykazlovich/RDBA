package com.rdba.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.rdba.model.jpa.client.Client;
import com.rdba.service.ClientService;

import java.util.List;

@RequestMapping(value = "/v1/clients")
@RestController
@CrossOrigin
public class ClientRestController {

    @Autowired
    private ClientService service;

    @GetMapping
    @CrossOrigin
    public List<Client> getAllClient(){
        return service.getAll();
    }

    @GetMapping(value = "/{id}")
    public Client getClientById(@PathVariable() int id){
        return service.get(id);
    }

    @PostMapping(path = "/",consumes = "application/json")
    public Client save(@RequestBody() Client client){
        return service.save(client);
    }

}
