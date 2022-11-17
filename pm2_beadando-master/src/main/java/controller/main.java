package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class main {
    public static final Logger LOGGER = LoggerFactory.getLogger(main.class);

    public static void main(String[] args) {
        LOGGER.info("start");
        SpringApplication.run(main.class, args);
    }
}