package com.supinfo.suprails.dao.jpa;

import com.supinfo.suprails.dao.CustomerOrderDao;
import com.supinfo.suprails.entity.CustomerOrder;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@Stateless
public class JpaCustomerOrderDao implements CustomerOrderDao{

    @PersistenceContext(unitName = "SupRails-PU")
    private EntityManager em;

    @Override
    public void addCustomerOrder(CustomerOrder customerOrder) {
        em.persist(customerOrder);
    }
}
