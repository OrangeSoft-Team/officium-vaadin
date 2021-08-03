package com.proyecto.desarrollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.vaadin.artur.helpers.LaunchUtil;

import java.util.Collections;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        String port = System.getenv("port");
        if (port != null){
            app.setDefaultProperties(Collections.singletonMap("server.port",port));
        }
        app.setDefaultProperties(Collections.singletonMap("server.port", "8080"));

        LaunchUtil.launchBrowserInDevelopmentMode(app.run(args));
    }

}
