package com.rdba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rdba.model.jpa.client.Client;
import com.rdba.repository.ClientRepository;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Override
    public List<Client> findByNameOrPhone(String text) {
        return repository.findByNameOrPhone(text);
    }

    @Override
    public Client get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Client> getAll() {
        return repository.getAll();
    }

    @Override
    public Client save(Client client) {
        return repository.save(client);
    }
}
