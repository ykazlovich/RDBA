package com.rdba.repository;

import com.rdba.model.jpa.client.Client;

import java.util.List;

public interface ClientRepository {

    Client get(int id);

    List<Client> getAll();

    Client save(Client client);

}
