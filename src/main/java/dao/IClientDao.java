package dao;

import models.Client;

import java.util.List;

public interface IClientDao {
    Client save(Client c);
    Client update(Client c);
    void deleteById(long idClient);
    Client findById(long idClient);
    List<Client> findAll();
}
