package dao;

import javafx.css.Styleable;
import models.Facture;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class FactureDaoImpl implements IFactureDao{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_factures");
    EntityManager em = emf.createEntityManager();

    public FactureDaoImpl() {}

    @Override
    public Facture save(Facture f) {
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
        return null;
    }

    @Override
    public Facture update(Facture f) {
        em.getTransaction().begin();
        Facture facture = em.find(Facture.class, f.getId());
        facture.setDate(f.getDate());
        facture.setAmount(f.getAmount());
        em.persist(facture);
        em.getTransaction().commit();
        return null;
    }

    @Override
    public void deleteById(long idFacture) {
        em.getTransaction().begin();
        Facture factureInDb = em.find(Facture.class, idFacture);
        em.remove(factureInDb);
        em.getTransaction().commit();
    }

    @Override
    public Facture findById(long idFacture) {
        return em.find(Facture.class, idFacture);
    }

    @Override
    public List<Facture> findAll() {
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Facture> cq = cb.createQuery(Facture.class);
        Root<Facture> rootEntry = cq.from(Facture.class);
        CriteriaQuery<Facture> all = cq.select(rootEntry);
        TypedQuery<Facture> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }
}
