package com.bugsrock.jerseysample.controllers;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import com.bugsrock.jerseysample.controllers.Root;

import static org.junit.Assert.*;

public class RootTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(Root.class);
    }

    @Test
    public void test() {
        final String responseBody = target("/").request().get(String.class);
        assertEquals("Hello world!", responseBody);
    }

}
