package services;

import dao.IClientDao;
import models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements IClientService{

    @Autowired
    IClientDao dao;

    @Override
    public Client save(Client c) {
        return dao.save(c);
    }
    @Override
    public Client update(Client c) {
        return dao.update(c);
    }
    @Override
    public void deleteById(long idClient) {
        dao.deleteById(idClient);
    }
    @Override
    public Client findById(long idClient) {
        return dao.findById(idClient);
    }
    @Override
    public List<Client> findAll() {
        return dao.findAll();
    }
}
