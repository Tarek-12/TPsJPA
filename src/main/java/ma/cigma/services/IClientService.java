package ma.cigma.services;

import ma.cigma.models.Client;

import java.util.List;

public interface IClientService {
    Client save(Client c);
    Client modify(Client c);
    void remove(long idClient);
    Client getOne(long idClient);
    List<Client> getAll();
}
