package services;

import dao.IAdresseDao;
import models.Adresse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdresseServiceImpl implements IAdresseService{
    @Autowired
    IAdresseDao dao;

    @Override
    @Transactional
    public Adresse save(Adresse adresse) { return dao.save(adresse); }

    @Override
    @Transactional
    public Adresse modify(Adresse adresse) {
        Adresse oldAdresse = dao.findById(adresse.getId_Adresse()).get();
        oldAdresse.setAvenue(adresse.getAvenue());
        oldAdresse.setVille(adresse.getVille());
        oldAdresse.setPays(adresse.getPays());
        return dao.save(oldAdresse);
    }

    @Override
    public void remove(long idAdresse) { dao.deleteById(idAdresse); }

    @Override
    public Adresse getOne(long idAdresse) { return dao.findById(idAdresse).get(); }

    @Override
    public List<Adresse> getAll() {
        return (List<Adresse>) dao.findAll();
    }
}
