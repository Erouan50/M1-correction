package com.supinfo.rmt.controller;

import com.supinfo.rmt.entity.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@ManagedBean
@SessionScoped
public class UserBean {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
