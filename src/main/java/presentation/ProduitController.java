package presentation;

import models.Produit;
import services.IproduitService;

public class ProduitController {

    IproduitService service;

    public void setService(IproduitService service) {
        this.service = service;
    }

    public Produit save(Produit p){ return service.save(p); }
}
