package com.zerses;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationBoot.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class HelloWorldTest  {
    
    @Autowired
    private CamelContext camelContext;
    
    private static Logger logger = Logger.getLogger(HelloWorldTest.class);

    @Test
    public void testFind() throws InterruptedException {

        ProducerTemplate template = camelContext.createProducerTemplate();

        String result = template.requestBody("direct:helloWorld", "Hello", String.class);
        logger.info(result);
        assert (result.contains("Hello World"));
        Thread.sleep(3000);

    }
   

}
