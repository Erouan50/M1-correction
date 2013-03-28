package com.supinfo.rmt.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@Entity
@DiscriminatorValue("employee")
public class Employee extends User {
}
