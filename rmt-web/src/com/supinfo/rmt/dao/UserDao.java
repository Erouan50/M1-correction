package com.supinfo.rmt.dao;

import com.supinfo.rmt.entity.User;

import javax.ejb.Local;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@Local
public interface UserDao {

    User getUserByEmailAndPassword(String username, String password);
}
