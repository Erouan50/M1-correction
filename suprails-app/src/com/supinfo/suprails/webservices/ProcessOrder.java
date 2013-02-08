package com.supinfo.suprails.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for processOrder complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="processOrder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://webservices.suprails.supinfo.com/}customerOrder" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "processOrder", propOrder = {
        "arg0"
})
public class ProcessOrder {

    protected CustomerOrder arg0;

    /**
     * Gets the value of the arg0 property.
     *
     * @return possible object is
     *         {@link CustomerOrder }
     */
    public CustomerOrder getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     *
     * @param value allowed object is
     *              {@link CustomerOrder }
     */
    public void setArg0(CustomerOrder value) {
        this.arg0 = value;
    }

}
