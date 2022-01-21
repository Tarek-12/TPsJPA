package presentation;

import models.Client;
import services.IClientService;

import java.util.List;

public class ClientController {
    IClientService service;

    public void setService(IClientService service) {
        this.service = service;
    }

    public Client save(Client c) {
        return service.save(c);
    }
    public Client update(Client c) {
        return service.update(c);
    }
    public void deleteById(long idClient) {
        service.deleteById(idClient);
    }
    public Client findById(long idClient) {
        return service.findById(idClient);
    }
    public List<Client> findAll() {
        return service.findAll();
    }
}
