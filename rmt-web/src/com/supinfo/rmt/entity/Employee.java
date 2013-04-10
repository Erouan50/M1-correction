package com.supinfo.rmt.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@Entity
@DiscriminatorValue("employee")
@NamedQueries({
        @NamedQuery(name = "findEmployeesByManager",
                query = "SELECT employee FROM Employee AS employee " +
                        "WHERE employee.manager = :manager")
})
public class Employee extends User {

    @ManyToOne
    @JoinColumn(name = "fk_manager")
    private Manager manager;
    @OneToMany(mappedBy = "employee")
    private List<Client> clients;

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Client> getClients() {

        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Employee employee = (Employee) o;

        if (manager != null ? !manager.equals(employee.manager) : employee.manager != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + (clients != null ? clients.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        char tot = 'a';
        System.out.println((int) tot);
    }
}
