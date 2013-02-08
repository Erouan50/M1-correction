package com.supinfo.suprails.application;

import com.sun.jersey.api.core.PackagesResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@ApplicationPath("/resources")
public class SupRailsApplication extends PackagesResourceConfig {

    public SupRailsApplication() {
        super("com.supinfo.suprails.resources");
    }
}
