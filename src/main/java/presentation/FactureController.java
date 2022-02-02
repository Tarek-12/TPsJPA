package presentation;

import models.Facture;
import services.IFactureService;

public class FactureController {

    IFactureService service;

    public void setService(IFactureService service) {
        this.service = service;
    }

    public Facture save(Facture f){ return service.save(f); }
}
