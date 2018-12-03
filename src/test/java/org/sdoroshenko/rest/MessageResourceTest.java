package org.sdoroshenko.rest;

import org.glassfish.grizzly.http.server.HttpServer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import static org.testng.Assert.assertEquals;

public class MessageResourceTest {
    private HttpServer server;
    private WebTarget target;

    @BeforeClass
    public void setUp() {
        server = Main.startServer();
        Client client = ClientBuilder.newClient();
        target = client.target(Main.BASE_URI);
    }

    @AfterClass
    public void tearDown() {
        server.stop();
    }

    /**
     * Test to see that the message "application" is sent in the response.
     */
    @Test
    public void getIt() {
        String responseMsg = target.path("messageResource")
            .queryParam("name", "Sergei")
            .request()
            .get(String.class);
        assertEquals( responseMsg, "jersey-spring-rest Sergei");
    }
}