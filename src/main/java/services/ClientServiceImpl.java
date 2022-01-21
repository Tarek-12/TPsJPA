package services;

import dao.IClientDao;
import models.Client;

import java.util.List;

public class ClientServiceImpl implements IClientService{

    IClientDao dao;

    public void setDao(IClientDao dao) {
        this.dao = dao;
    }

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
