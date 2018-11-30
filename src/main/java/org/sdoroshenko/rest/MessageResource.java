package org.sdoroshenko.rest;

import org.sdoroshenko.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("messageResource")
public class MessageResource {

    private final MessageService messageService;

    @Autowired
    public MessageResource(MessageService messageService) {
        this.messageService = messageService;
    }

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreetingMessage(@QueryParam("name") String name) {
        return messageService.getGreetingMessage() + " " + name;
    }
}
