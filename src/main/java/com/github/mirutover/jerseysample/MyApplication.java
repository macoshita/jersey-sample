package com.github.mirutover.jerseysample;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class MyApplication extends ResourceConfig {

    public MyApplication() {
        packages("com.github.mirutover.jerseysample.controllers");
    }

}
