package dao;

import models.Client;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ClientDaoImpl implements IClientDao{
    @PersistenceContext
    EntityManager em;

    @Override
    public Client save(Client c) {
        em.persist(c);
        return null;
    }

    @Override
    public Client update(Client c) {
        //Methode1
        Client client = em.find(Client.class, c.getId_client());
        client.setName(c.getName());
        em.persist(c);
        //Methode2
        //em.merge(c);
        return null;
    }

    @Override
    public void deleteById(long idClient) {
        Client client = em.find(Client.class, idClient);
        em.remove(client);
    }
    @Override
    public Client findById(long idClient) {
        return em.find(Client.class, idClient);
    }

    @Override
    //Methode1
    public List<Client> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Client> cq =cb.createQuery(Client.class);
        Root<Client> rootEntry = cq.from(Client.class);
        CriteriaQuery<Client> all = cq.select(rootEntry);
        TypedQuery<Client> allQuery =em.createQuery(all);
        return allQuery.getResultList();
    }
    //Methode2
    /*public List<Client> findAll() {
        return em.createQuery("from Client ", Client.class).getResultList();
    }*/

}
