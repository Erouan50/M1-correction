package com.supinfo.suprails.resources;

import com.supinfo.suprails.entity.TrainStation;
import com.supinfo.suprails.service.TrainStationService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@Stateless
@Path("/trainStations")
public class TrainStationResource {

    @EJB
    private TrainStationService trainStationService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TrainStation> getAllTrainStation() {
        return trainStationService.getAllTrainStations();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTrainStation(TrainStation trainStation) {
        trainStationService.addTrainStation(trainStation);
        System.out.println("Id: " + trainStation.getId());
        String uri = "/" + trainStation.getId();
        return Response.created(URI.create(uri)).build();
    }
}
