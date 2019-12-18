package com.pratice.config_client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableDiscoveryClient
@RefreshScope
public class App
{
	/**
	 * http://localhost:8881/actuator/bus-refresh?destination=customers:**
	 * @param args
	 */
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

    @Value("${test}")
    String value;

    @RequestMapping(value = "/config")
    public String getConfig() {
    	return value;
    }
}
