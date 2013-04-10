package com.supinfo.rmt.controller;

import com.supinfo.rmt.entity.Client;
import com.supinfo.rmt.entity.Employee;
import com.supinfo.rmt.entity.WorkTime;
import com.supinfo.rmt.service.ClientService;
import com.supinfo.rmt.service.WorkTimeService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@ManagedBean
public class WorkTimeBean {

    @ManagedProperty("#{userBean}")
    private UserBean userBean;

    @EJB
    private WorkTimeService workTimeService;
    @EJB
    private ClientService clientService;
    private WorkTime workTime;
    private List<SelectItem> clientSelectItems;

    public String addWorkTime() {
        workTimeService.addWorkTime(workTime);
        return "employee_home?faces-redirect=true";
    }

    public List<SelectItem> getClientSelectItems() {
        if (clientSelectItems == null) {
            if (userBean.getUser() instanceof Employee) {
                Employee employee = (Employee) userBean.getUser();
                List<Client> clients = employee.getClients();
                clientSelectItems = new ArrayList<SelectItem>();
                for (Client client : clients) {
                    clientSelectItems.add(new SelectItem(client, client.getName()));
                }
            }
        }
        return clientSelectItems;
    }

    public WorkTime getWorkTime() {
        if (workTime == null) {
            workTime = new WorkTime();
        }
        return workTime;
    }

    public void setWorkTime(WorkTime workTime) {
        this.workTime = workTime;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
}
