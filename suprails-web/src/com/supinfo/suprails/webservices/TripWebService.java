package com.supinfo.suprails.webservices;

import com.supinfo.suprails.entity.CustomerOrder;
import com.supinfo.suprails.entity.Trip;
import com.supinfo.suprails.service.CustomerOrderService;
import com.supinfo.suprails.service.TripService;

import javax.ejb.EJB;
import javax.jws.WebService;
import java.util.List;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@WebService(serviceName = "tripService")
public class TripWebService {

    @EJB
    private TripService tripService;
    @EJB
    private CustomerOrderService customerOrderService;

    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    public void processOrder(CustomerOrder customerOrder) {
        customerOrderService.processCustomerOrder(customerOrder);
    }
}
