package dao;

import models.Facture;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactureDaoImpl implements IfactureDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_client");
    EntityManager em = emf.createEntityManager();

    @Override
    public Facture save(Facture f) {
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
        return null;
    }
}
