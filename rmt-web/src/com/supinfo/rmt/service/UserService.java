package com.supinfo.rmt.service;

import com.supinfo.rmt.dao.UserDao;
import com.supinfo.rmt.entity.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@Stateless
public class UserService {

    @EJB
    private UserDao userDao;

    public User authenticate(String username, String password) {
        return userDao.getUserByEmailAndPassword(username, password);
    }
}
