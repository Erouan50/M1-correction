package com.supinfo.rmt.converter;

import com.supinfo.rmt.entity.Client;
import com.supinfo.rmt.service.ClientService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@ManagedBean
public class ClientConverter implements Converter {

    @EJB
    private ClientService clientService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return clientService.getClientById(Long.parseLong(s));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o instanceof Client) {
            return String.valueOf(((Client) o).getId());
        }
        throw new RuntimeException("Your object is not a client");
    }
}
