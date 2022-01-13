package presentation;

import services.IClientService;
import models.Client;

public class ClientController {
    IClientService service;

    public void setService(IClientService service) {
        this.service = service;
    }

    public Client save(Client c){
        return service.save(c);
    }
}
