package com.supinfo.suprails.dao;

import com.supinfo.suprails.entity.TrainStation;

import javax.ejb.Local;
import java.util.List;

/**
 * @author bargenson
 */
@Local
public interface TrainStationDao {

    TrainStation addTrainStation(TrainStation station);

    List<TrainStation> getAllTrainStations();

    TrainStation findTrainStationById(Long departureId);

}
