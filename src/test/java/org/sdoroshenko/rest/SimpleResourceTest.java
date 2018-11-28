package org.sdoroshenko.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SimpleResourceTest {
    private HttpServer server;
    private WebTarget target;

    @BeforeMethod
    public void setUp() {
        server = Main.startServer();
        Client client = ClientBuilder.newClient();
        target = client.target(Main.BASE_URI);
    }

    @AfterMethod
    public void tearDown() {
        server.stop();
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void getIt() {
        String responseMsg = target.path("simpleResource").request().get(String.class);
        assertEquals( responseMsg, "Got it!");
    }
}