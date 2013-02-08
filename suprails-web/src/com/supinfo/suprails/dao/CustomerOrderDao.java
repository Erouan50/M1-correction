package com.supinfo.suprails.dao;

import com.supinfo.suprails.entity.CustomerOrder;

import javax.ejb.Local;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@Local
public interface CustomerOrderDao {

    void addCustomerOrder(CustomerOrder customerOrder);
}
