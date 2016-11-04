package com.zerses;


import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("timer://myTimer?period=30000")
		.id("myTimerRoute").log(LoggingLevel.INFO, "Timer .... tick tock..... tick tock");
        
        from("direct:helloWorld")
        .id("helloWorld")
        .transform(constant("Hello World"))
        .log("body is: ${body}");

    }



}
