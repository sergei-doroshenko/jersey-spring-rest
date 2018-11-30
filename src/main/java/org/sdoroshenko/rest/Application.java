package org.sdoroshenko.rest;

import org.glassfish.jersey.server.ResourceConfig;

public class Application extends ResourceConfig {

    public Application() {
        register(MessageResource.class);
    }

}
