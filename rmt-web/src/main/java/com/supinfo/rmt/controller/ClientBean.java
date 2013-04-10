package com.supinfo.rmt.controller;

import com.supinfo.rmt.entity.Client;
import com.supinfo.rmt.entity.Employee;
import com.supinfo.rmt.service.ClientService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@ManagedBean
public class ClientBean {

    @ManagedProperty("#{userBean}")
    private UserBean userBean;
    @EJB
    private ClientService clientService;
    private Client client;
    private List<Client> clients;

    public String addClient() {
        if (userBean.getUser() instanceof Employee) {
            Employee employee = (Employee) userBean.getUser();
            client.setEmployee(employee);
            clientService.addClient(client);
        }
        return "employee_home?faces-redirect=true";
    }

    public List<Client> getClients() {
        if (clients == null) {
            if (userBean.getUser() instanceof Employee) {
                Employee employee = (Employee) userBean.getUser();
                clients = clientService.getClientByEmployee(employee);
            }
        }
        return clients;
    }

    public Client getClient() {
        if (client == null) {
            client = new Client();
        }
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
}
