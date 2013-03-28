package com.supinfo.rmt.dao.jpa;

import com.supinfo.rmt.dao.UserDao;
import com.supinfo.rmt.entity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@Stateless
public class UserJpaDao implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User getUserByEmailAndPassword(String username, String password) {
        Query query = em.createNamedQuery("findUserByEmailAndPassword");
        query.setParameter("username", username);
        query.setParameter("password", password);
        return (User) query.getSingleResult();
    }
}
