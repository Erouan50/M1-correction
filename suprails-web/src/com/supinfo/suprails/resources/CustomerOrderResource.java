package com.supinfo.suprails.resources;

import com.supinfo.suprails.entity.CustomerOrder;
import com.supinfo.suprails.service.CustomerOrderService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@Stateless
@Path("/customerOrders")
public class CustomerOrderResource {

    @EJB
    private CustomerOrderService customerOrderService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response processOrder(CustomerOrder customerOrder) {
        customerOrderService.processCustomerOrder(customerOrder);
        String uri = "/" + customerOrder.getId();
        return Response.created(URI.create(uri)).build();
    }
}
