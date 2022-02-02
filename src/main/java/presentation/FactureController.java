package presentation;

import models.Facture;
import services.IFactureService;

import java.util.List;

public class FactureController {
    IFactureService service;

    public void setService(IFactureService service) {
        this.service = service;
    }

    public Facture save(Facture f){ return service.save(f); }
    public Facture update(Facture f) {
        return service.update(f);
    }
    public void deleteById(long idFacture) { service.deleteById(idFacture); }
    public Facture findById(long idFacture) { return service.findById(idFacture); }
    public List<Facture> findAll() {
        return service.findAll();
    }
}
