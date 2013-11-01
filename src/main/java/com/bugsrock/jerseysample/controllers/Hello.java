package com.bugsrock.jerseysample.controllers;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.glassfish.jersey.server.mvc.Template;

@Path("/hello")
@Template
public class Hello {
    
    @GET
    public String getHello(@DefaultValue("world") @QueryParam("s") String s) {
        return s;
    }

}
