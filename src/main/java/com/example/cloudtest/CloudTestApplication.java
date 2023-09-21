package com.example.cloudtest;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class CloudTestApplication {

  public static void main(String[] args) {
    SpringApplication.run(CloudTestApplication.class, args);
  }

  @Component
  @Slf4j
  @RequiredArgsConstructor
  static class TestRunner implements ApplicationRunner {

    private final Environment environment;

    @Value("${spring.config.import}")
    private List<String> imports;

    @Value("${szs.sdk.venom.api.host}")
    private String venom;
//
    @Value("${szs.sdk.venom.api.key}")
    private String key;

    @Override
    public void run(ApplicationArguments args) {
      System.out.println(venom);
      System.out.println(key);
      imports.forEach(System.out::println);
    }
  }
}