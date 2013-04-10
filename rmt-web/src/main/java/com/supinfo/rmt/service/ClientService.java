package com.supinfo.rmt.service;

import com.supinfo.rmt.dao.ClientDao;
import com.supinfo.rmt.entity.Client;
import com.supinfo.rmt.entity.Employee;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@Stateless
public class ClientService {

    @EJB
    private ClientDao clientDao;

    public void addClient(Client client) {
        clientDao.addClient(client);
    }

    public Client getClientById(Long id) {
        return clientDao.getById(id);
    }

    public List<Client> getClientByEmployee(Employee employee) {
        return clientDao.getClientsByEmployee(employee);
    }
}
