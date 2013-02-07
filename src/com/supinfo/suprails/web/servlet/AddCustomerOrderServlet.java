package com.supinfo.suprails.web.servlet;

import com.supinfo.suprails.dao.TripDao;
import com.supinfo.suprails.entity.Customer;
import com.supinfo.suprails.entity.CustomerOrder;
import com.supinfo.suprails.entity.Trip;
import com.supinfo.suprails.service.CustomerOrderService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@WebServlet(urlPatterns = "/addCustomerOrder")
public class AddCustomerOrderServlet extends HttpServlet {

    @EJB
    private TripDao tripDao;

    @EJB
    private CustomerOrderService customerOrderService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Trip> trips = tripDao.getAllTrips();
        req.setAttribute("trips", trips);
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/addCustomerOrder.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = new Customer();
        customer.setFirstName(req.getParameter("firstName"));
        customer.setLastName(req.getParameter("lastName"));
        customer.setEmail(req.getParameter("email"));

        Long idTrip = Long.parseLong(req.getParameter("idTrip"));
        Trip trip = tripDao.findTripById(idTrip);

        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCustomer(customer);
        customerOrder.setTrip(trip);

        customerOrderService.processCustomerOrder(customerOrder);

        resp.sendRedirect(getServletContext().getContextPath() + "/trips");
    }
}
