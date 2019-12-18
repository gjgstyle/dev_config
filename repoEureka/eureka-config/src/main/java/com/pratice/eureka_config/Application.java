package com.pratice.eureka_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 全局配置文件注册中心
 * server
 */
@EnableConfigServer
@SpringBootApplication
public class Application
{
    public static void main( String[] args )
    {
        SpringApplication.run(Application.class,args);
    }
}
