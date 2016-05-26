package com.myamq;

import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;

import org.apache.camel.impl.UriEndpointComponent;

/**
 * Represents the component that manages {@link myamqEndpoint}.
 */
public class myamqComponent extends UriEndpointComponent {
    
    public myamqComponent() {
        super(myamqEndpoint.class);
    }

    public myamqComponent(CamelContext context) {
        super(context, myamqEndpoint.class);
    }

    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        Endpoint endpoint = new myamqEndpoint(uri, this);
        setProperties(endpoint, parameters);
        return endpoint;
    }
}
