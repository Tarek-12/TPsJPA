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
