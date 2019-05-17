package com.rdba.service;

import com.rdba.model.jpa.client.Client;

import java.util.List;

public interface ClientService {
    Client get(int id);
    List<Client> getAll();
    Client save(Client client);

}
