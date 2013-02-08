package com.supinfo.suprails.service;

import com.supinfo.suprails.dao.TrainStationDao;
import com.supinfo.suprails.entity.TrainStation;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author bargenson
 */
@Stateless
public class TrainStationService {

    @EJB
    private TrainStationDao trainStationDao;


    public void addTrainStation(TrainStation station) {
        trainStationDao.addTrainStation(station);
    }

    public List<TrainStation> getAllTrainStations() {
        return trainStationDao.getAllTrainStations();
    }

    public TrainStation findTrainStationById(Long departureId) {
        return trainStationDao.findTrainStationById(departureId);
    }

}
