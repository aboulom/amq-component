package com.myamq;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.impl.DefaultEndpoint;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriPath;

/**
 * Represents a myamq endpoint.
 */
@UriEndpoint(scheme = "myamq", title = "myamq", syntax="myamq:name", consumerClass = myamqConsumer.class, label = "myamq")
public class myamqEndpoint extends DefaultEndpoint {
    @UriPath @Metadata(required = "true")
    private String name;
    @UriParam(defaultValue = "10")
    private int option = 10;

    public myamqEndpoint() {
    }

    public myamqEndpoint(String uri, myamqComponent component) {
        super(uri, component);
    }

    public myamqEndpoint(String endpointUri) {
        super(endpointUri);
    }

    public Producer createProducer() throws Exception {
        return new myamqProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        return new myamqConsumer(this, processor);
    }

    public boolean isSingleton() {
        return true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public int getOption() {
        return option;
    }
}
