package com.example.cloudtest;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CloudTestApplication {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Value("${redis-url}")
  private String redisUrl;

  @Value("${database-url}")
  private String databaseUrl;
  public static void main(String[] args) {
    SpringApplication.run(CloudTestApplication.class, args);
  }


  @PostConstruct
  void setUp () {

    logger.info("redis url : " + redisUrl);
    logger.info("database url : " + databaseUrl);

  }
}
