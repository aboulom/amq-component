package com.myamq;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class myamqComponentTest extends CamelTestSupport {

    @Test
    public void testmyamq() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedMinimumMessageCount(1);       
        
        assertMockEndpointsSatisfied();
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            public void configure() {
                from("file:target/input")
                  .to("myamq://foo")
                  .to("file:target/input/message1")
                  .to("myamq://bar")
                  .to("file:target/input/message2")
                  .to("myamq://work")
                  .to("file:target/input/message3")
                  .to("mock:result");
            }
        };
    }
}
