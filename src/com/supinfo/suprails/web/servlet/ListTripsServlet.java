package com.supinfo.suprails.web.servlet;

import com.supinfo.suprails.dao.TrainStationDao;
import com.supinfo.suprails.dao.TripDao;
import com.supinfo.suprails.entity.TrainStation;
import com.supinfo.suprails.entity.Trip;
import com.supinfo.suprails.service.TripService;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bargenson
 */
@WebServlet(urlPatterns="/trips")
public class ListTripsServlet extends HttpServlet {

    @EJB
    private TripDao tripDao;

    @EJB
    private TrainStationDao trainStationDao;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TrainStation departure = null;
        String strIdDeparture = req.getParameter("departure");
        if (strIdDeparture != null && !strIdDeparture.isEmpty()) {
            Long idDeparture = Long.parseLong(strIdDeparture);
            departure = trainStationDao.findTrainStationById(idDeparture);
        }

        TrainStation arrival = null;
        String strIdArrival = req.getParameter("arrival");
        if (strIdArrival != null && !strIdArrival.isEmpty()) {
            Long idArrival = Long.parseLong(strIdArrival);
            arrival = trainStationDao.findTrainStationById(idArrival);
        }

        BigDecimal price =
                req.getParameter("price") == null ? null : new BigDecimal(req.getParameter("price"));
        List<Trip> trips = tripDao.getAllTripByDepartureArrivalPrice(departure, arrival, price);

        List<TrainStation> trainStations = trainStationDao.getAllTrainStations();

        req.setAttribute("trips", trips);
        req.setAttribute("trainStations", trainStations);
        req.getRequestDispatcher("/jsp/listTrips.jsp").forward(req, resp);
    }

}
