package com.supinfo.suprails.resources;

import com.supinfo.suprails.entity.Trip;
import com.supinfo.suprails.service.TripService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@Stateless
@Path("/trips")
public class TripResource {

    @EJB
    private TripService tripService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }
}
