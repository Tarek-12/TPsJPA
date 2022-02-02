package services;

import dao.IfactureDao;
import models.Facture;

public class FactureServiceImpl implements IFactureService {
    IfactureDao dao;

    public void setDao(IfactureDao dao) {
        this.dao = dao;
    }

    @Override
    public Facture save(Facture f) {
        return dao.save(f);
    }
}
