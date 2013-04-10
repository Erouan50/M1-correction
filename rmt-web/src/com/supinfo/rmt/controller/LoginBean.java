package com.supinfo.rmt.controller;

import com.supinfo.rmt.entity.Employee;
import com.supinfo.rmt.entity.Manager;
import com.supinfo.rmt.entity.User;
import com.supinfo.rmt.service.UserService;
import org.hibernate.validator.constraints.NotEmpty;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.validation.constraints.NotNull;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@ManagedBean
public class LoginBean {

    @ManagedProperty("#{userBean}")
    private UserBean userBean;

    @EJB
    private UserService userService;

    @NotNull
    @NotEmpty(message = "Username must be filled")
    private String username;
    private String password;

    public String authenticate() {
        User user = userService.authenticate(username, password);
        userBean.setUser(user);
        if (user != null && user instanceof Manager) {
            return "manager_home?faces-redirect=true";
        } else if (user != null && user instanceof Employee) {
            return "employee_home?faces-redirect=true";
        } else {
            return null;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
}
