package com.supinfo.suprails.service;

import com.supinfo.suprails.entity.CustomerOrder;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@Stateless
public class PrinterService {

    @Resource(mappedName = "ConnectionFactory")
    private ConnectionFactory factory;
    @Resource(mappedName = "queue/printer")
    private Destination destination;

    public void print(CustomerOrder customerOrder) {
        Connection connection = null;
        try {
            connection = factory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage();

            message.setText(buildMessage(customerOrder));
            producer.send(message);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String buildMessage(CustomerOrder customerOrder) {
        StringBuilder builder = new StringBuilder();
        builder.append("New order").append(System.lineSeparator());
        builder.append("\tOrder Id: ").append(customerOrder.getId()).append(System.lineSeparator());
        builder.append("\tDeparture station: ").append(customerOrder.getTrip().getDepartureStation().getName())
                .append("(").append(customerOrder.getTrip().getDepartureStation().getCity()).append(")")
                .append(System.lineSeparator());
        builder.append("\tArrival station: ").append(customerOrder.getTrip().getArrivalStation().getName())
                .append("(").append(customerOrder.getTrip().getArrivalStation().getCity()).append(")")
                .append(System.lineSeparator());
        builder.append("\tPrice: ").append(customerOrder.getTrip().getPrice()).append(System.lineSeparator());
        builder.append("\tFirstName: ").append(customerOrder.getCustomer().getFirstName())
                .append(System.lineSeparator());
        builder.append("\tLastName: ").append(customerOrder.getCustomer().getLastName())
                .append(System.lineSeparator());
        builder.append("\tEmail: ").append(customerOrder.getCustomer().getEmail()).append(System.lineSeparator());
        return builder.toString();
    }
}
