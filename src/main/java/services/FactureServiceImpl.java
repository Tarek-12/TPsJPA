package services;

import dao.IFactureDao;
import models.Facture;

import java.util.List;

public class FactureServiceImpl implements IFactureService{

    IFactureDao dao;

    public void setDao(IFactureDao dao) {
        this.dao = dao;
    }

    @Override
    public Facture save(Facture f) {
        return dao.save(f);
    }

    @Override
    public Facture update(Facture f) {
        return dao.update(f);
    }

    @Override
    public void deleteById(long idFacture) { dao.deleteById(idFacture); }

    @Override
    public Facture findById(long idFacture) { return dao.findById(idFacture); }

    @Override
    public List<Facture> findAll() {
        return dao.findAll();
    }
}
