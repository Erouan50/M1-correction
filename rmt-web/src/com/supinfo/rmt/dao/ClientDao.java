package com.supinfo.rmt.dao;

import com.supinfo.rmt.entity.Client;
import com.supinfo.rmt.entity.Employee;

import javax.ejb.Local;
import java.util.List;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@Local
public interface ClientDao {

    void addClient(Client client);

    Client getById(Long id);

    List<Client> getClientsByEmployee(Employee employee);
}
