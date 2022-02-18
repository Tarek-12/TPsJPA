package services;

import models.Adresse;

import java.util.List;

public interface IAdresseService {
    Adresse save(Adresse adresse);
    Adresse modify(Adresse adresse);
    void remove(long idAdresse);
    Adresse getOne(long idAdresse);
    List<Adresse> getAll();
}
