package services;

import models.Facture;

import java.util.List;

public interface IFactureService {
    Facture save(Facture f);
    Facture update(Facture f);
    void deleteById(long idFacture);
    Facture findById(long idFacture);
    List<Facture> findAll();
}
