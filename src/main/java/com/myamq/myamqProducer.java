
package com.myamq;

import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The myamq producer.
 */
public class myamqProducer extends DefaultProducer {
    private static final Logger LOG = LoggerFactory.getLogger(myamqProducer.class);
    private myamqEndpoint endpoint;

    public myamqProducer(myamqEndpoint endpoint) {
        super(endpoint);
        this.endpoint = endpoint;
    }

    public void process(Exchange exchange) throws Exception {
    	exchange.getIn().getBody(String.class);
    	exchange.getIn().setBody(endpoint.getEndpointUri());
    }

}
