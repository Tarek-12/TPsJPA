package presentation;

import models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import services.IClientService;

import java.util.List;

@Controller("idCtrl")
public class ClientController {
    @Autowired
    IClientService service;

    public Client save(Client c) {
        return service.save(c);
    }
    public Client modify(Client c) { return service.modify(c); }
    public void remove(long idClient) {
        service.remove(idClient);
    }
    public Client getOne(long idClient) { return service.getOne(idClient); }
    public List<Client> getAll() {
        return service.getAll();
    }
    public List<Client> findByName(String name) { return service.findByName(name); }
}
