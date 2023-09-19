package com.example.cloudtest;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class CloudTestApplication {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public static void main(String[] args) {
    SpringApplication.run(CloudTestApplication.class, args);
  }

  @Component
  @Slf4j
  @RequiredArgsConstructor
  static class TestRunner implements ApplicationRunner {

    private final Environment environment;

    @Value("${host.api.venom}")
    private String venom;

    @Value("${szs.sdk.venom.api.key}")
    private String key;

    @Override
    public void run(ApplicationArguments args) {
      log.info("print config start");
      log.info("{}", environment);
      log.info("{}", venom);
      log.info("{}", key);
      log.info("print config end");
    }
  }
}
