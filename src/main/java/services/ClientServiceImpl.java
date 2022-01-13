package services;

import dao.IClientDao;
import models.Client;

public class ClientServiceImpl implements IClientService{

    IClientDao dao;

    public void setDao(IClientDao dao) {
        this.dao = dao;
    }

    @Override
    public Client save(Client c) {
        return dao.save(c);
    }
}
