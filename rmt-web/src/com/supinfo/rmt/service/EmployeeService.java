package com.supinfo.rmt.service;

import com.supinfo.rmt.dao.UserDao;
import com.supinfo.rmt.entity.Employee;
import com.supinfo.rmt.entity.Manager;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@Stateless
public class EmployeeService {

    @EJB
    private UserDao userDao;

    public void addEmployee(Employee employee) {
        userDao.addEmployee(employee);
    }

    public List<Employee> getAllEmployeesByManager(Manager manager) {
        return manager.getEmployees();
    }
}
