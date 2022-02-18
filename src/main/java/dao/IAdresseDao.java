package dao;

import models.Adresse;
import org.springframework.data.repository.CrudRepository;

public interface IAdresseDao extends CrudRepository<Adresse,Long> {
}
