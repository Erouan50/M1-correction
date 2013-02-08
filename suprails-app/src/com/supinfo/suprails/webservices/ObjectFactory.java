package com.supinfo.suprails.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.supinfo.suprails.webservices package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllTripsResponse_QNAME = new QName("http://webservices.suprails.supinfo.com/", "getAllTripsResponse");
    private final static QName _ProcessOrderResponse_QNAME = new QName("http://webservices.suprails.supinfo.com/", "processOrderResponse");
    private final static QName _GetAllTrips_QNAME = new QName("http://webservices.suprails.supinfo.com/", "getAllTrips");
    private final static QName _ProcessOrder_QNAME = new QName("http://webservices.suprails.supinfo.com/", "processOrder");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.supinfo.suprails.webservices
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllTrips }
     */
    public GetAllTrips createGetAllTrips() {
        return new GetAllTrips();
    }

    /**
     * Create an instance of {@link ProcessOrder }
     */
    public ProcessOrder createProcessOrder() {
        return new ProcessOrder();
    }

    /**
     * Create an instance of {@link ProcessOrderResponse }
     */
    public ProcessOrderResponse createProcessOrderResponse() {
        return new ProcessOrderResponse();
    }

    /**
     * Create an instance of {@link GetAllTripsResponse }
     */
    public GetAllTripsResponse createGetAllTripsResponse() {
        return new GetAllTripsResponse();
    }

    /**
     * Create an instance of {@link TrainStation }
     */
    public TrainStation createTrainStation() {
        return new TrainStation();
    }

    /**
     * Create an instance of {@link CustomerOrder }
     */
    public CustomerOrder createCustomerOrder() {
        return new CustomerOrder();
    }

    /**
     * Create an instance of {@link Trip }
     */
    public Trip createTrip() {
        return new Trip();
    }

    /**
     * Create an instance of {@link Customer }
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllTripsResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://webservices.suprails.supinfo.com/", name = "getAllTripsResponse")
    public JAXBElement<GetAllTripsResponse> createGetAllTripsResponse(GetAllTripsResponse value) {
        return new JAXBElement<GetAllTripsResponse>(_GetAllTripsResponse_QNAME, GetAllTripsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessOrderResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://webservices.suprails.supinfo.com/", name = "processOrderResponse")
    public JAXBElement<ProcessOrderResponse> createProcessOrderResponse(ProcessOrderResponse value) {
        return new JAXBElement<ProcessOrderResponse>(_ProcessOrderResponse_QNAME, ProcessOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllTrips }{@code >}}
     */
    @XmlElementDecl(namespace = "http://webservices.suprails.supinfo.com/", name = "getAllTrips")
    public JAXBElement<GetAllTrips> createGetAllTrips(GetAllTrips value) {
        return new JAXBElement<GetAllTrips>(_GetAllTrips_QNAME, GetAllTrips.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessOrder }{@code >}}
     */
    @XmlElementDecl(namespace = "http://webservices.suprails.supinfo.com/", name = "processOrder")
    public JAXBElement<ProcessOrder> createProcessOrder(ProcessOrder value) {
        return new JAXBElement<ProcessOrder>(_ProcessOrder_QNAME, ProcessOrder.class, null, value);
    }

}
