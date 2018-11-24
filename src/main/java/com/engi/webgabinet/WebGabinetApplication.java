package com.engi.webgabinet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication(exclude= HibernateJpaAutoConfiguration.class)
public class WebGabinetApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebGabinetApplication.class, args);
    }
}
