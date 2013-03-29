package com.supinfo.rmt.dao.jpa;

import com.supinfo.rmt.dao.ClientDao;
import com.supinfo.rmt.entity.Client;
import com.supinfo.rmt.entity.Employee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@Stateless
public class ClientJpaDao implements ClientDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addClient(Client client) {
        em.persist(client);
    }

    @Override
    public Client getById(Long id) {
        return em.find(Client.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Client> getClientsByEmployee(Employee employee) {
        Query query = em.createNamedQuery("findClientsByEmployee");
        query.setParameter("employee", employee);
        return query.getResultList();
    }
}
