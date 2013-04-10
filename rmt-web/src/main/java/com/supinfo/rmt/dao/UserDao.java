package com.supinfo.rmt.dao;

import com.supinfo.rmt.entity.Employee;
import com.supinfo.rmt.entity.Manager;
import com.supinfo.rmt.entity.User;

import javax.ejb.Local;
import java.util.List;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@Local
public interface UserDao {

    User getUserByEmailAndPassword(String username, String password);

    void addEmployee(Employee employee);

    List<Employee> getEmployeesByManager(Manager manager);
}
