package com.zerses;


import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;


public class FileWriterRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("timer://myTimer?period=30000")
		.id("fileWriterRoute").log(LoggingLevel.INFO, "File wroiter route");

    }



}
