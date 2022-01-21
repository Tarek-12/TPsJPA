package services;

import dao.IproduitDao;
import models.Produit;

public class ProduitServiceImpl implements IproduitService{
    IproduitDao dao;

    public void setDao(IproduitDao dao) {
        this.dao = dao;
    }

    @Override
    public Produit save(Produit p) {
        return dao.save(p);
    }
}
