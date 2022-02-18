package services;

import dao.IClientDao;
import models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements IClientService{

    @Autowired
    IClientDao dao;

    @Override
    @Transactional
    public Client save(Client c) {
        return dao.save(c);
    }

    @Override
    @Transactional
    public Client modify(Client c) {
        Client oldClt = dao.findById(c.getId_client()).get();
        oldClt.setName(c.getName());
        return dao.save(oldClt);
    }

    @Override
    @Transactional
    public void remove(long idClient) {
        dao.deleteById(idClient);
    }

    @Override
    public Client getOne(long idClient) { return dao.findById(idClient).get(); }

    @Override
    public List<Client> getAll() {
        return (List<Client>) dao.findAll();
    }

    @Override
    public List<Client> findByName(String name) { return dao.findByName(name); }
}
