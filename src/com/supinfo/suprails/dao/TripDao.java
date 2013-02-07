package com.supinfo.suprails.dao;

import com.supinfo.suprails.entity.TrainStation;
import com.supinfo.suprails.entity.Trip;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bargenson
 */
@Local
public interface TripDao {
    
    Trip addTrip(Trip trip);
    
    List<Trip> getAllTrips();

    public Trip findTripById(Long tripId);

    public void removeTrip(Trip findTripById);

    List<Trip> getAllTripByDepartureArrivalPrice(TrainStation departure,
                                                 TrainStation arrival,
                                                 BigDecimal price);
    
}
