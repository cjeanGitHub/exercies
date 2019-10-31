package com.cjean.springboot.demo_nginx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@ComponentScan(value = "com.cjean")
@SpringBootApplication
public class DemoNginxApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoNginxApplication.class, args);
    }
}
