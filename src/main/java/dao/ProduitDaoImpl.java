package dao;

import models.Produit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProduitDaoImpl implements IproduitDao{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_client");
    EntityManager em = emf.createEntityManager();

    @Override
    public Produit save(Produit p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        return null;
    }
}
