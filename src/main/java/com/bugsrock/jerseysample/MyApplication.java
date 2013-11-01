package com.bugsrock.jerseysample;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class MyApplication extends ResourceConfig {

    public MyApplication() {
        packages("com.bugsrock.jerseysample.controllers");
        
        register(org.glassfish.jersey.server.mvc.MvcFeature.class);
        register(org.glassfish.jersey.server.mvc.jsp.JspMvcFeature.class);
    }

}
