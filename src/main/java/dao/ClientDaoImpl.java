package dao;

import models.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ClientDaoImpl implements IClientDao{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_client");
    EntityManager em = emf.createEntityManager();

    @Override
    public Client save(Client c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        return null;
    }
    @Override
    public Client update(Client c) {
        em.getTransaction().begin();
        Client client = em.find(Client.class, c.getId());
        client.setName(c.getName());
        em.persist(c);
        em.getTransaction().commit();
        return null;
    }
    @Override
    public void deleteById(long idClient) {
        em.getTransaction().begin();
        Client client = em.find(Client.class, idClient);
        em.remove(client);
        em.getTransaction().commit();
    }
    @Override
    public Client findById(long idClient) {
        return em.find(Client.class, idClient);
    }
    @Override
    public List<Client> findAll() {
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Client> cq =cb.createQuery(Client.class);
        Root<Client> rootEntry = cq.from(Client.class);
        CriteriaQuery<Client> all = cq.select(rootEntry);
        TypedQuery<Client> allQuery =em.createQuery(all);
        return allQuery.getResultList();
    }
}
