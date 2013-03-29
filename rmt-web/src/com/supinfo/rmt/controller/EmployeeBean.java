package com.supinfo.rmt.controller;

import com.supinfo.rmt.entity.Employee;
import com.supinfo.rmt.entity.Manager;
import com.supinfo.rmt.service.EmployeeService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@ManagedBean
public class EmployeeBean {

    @ManagedProperty("#{userBean}")
    private UserBean userBean;
    @EJB
    private EmployeeService employeeService;

    private Employee employee;
    private List<Employee> employees;

    public String addEmployee() {
        if (userBean.getUser() instanceof Manager) {
            Manager manager = (Manager) userBean.getUser();
            employee.setManager(manager);
            employeeService.addEmployee(employee);
        }
        return "manager_home?faces-redirect=true";
    }

    public Employee getEmployee() {
        if (employee == null) {
            employee = new Employee();
        }
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Employee> getEmployees() {
        if (employees == null) {
            if (userBean.getUser() instanceof Manager) {
                Manager manager = (Manager) userBean.getUser();
                employees = employeeService.getAllEmployeesByManager(manager);
            }
        }
        return employees;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
}
