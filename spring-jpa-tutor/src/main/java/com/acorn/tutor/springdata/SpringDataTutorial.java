package com.acorn.tutor.springdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ImportResource("classpath*:spring/context.xml")
@ComponentScan({ "com.acorn.*" })
@EnableJpaRepositories
@EnableAutoConfiguration
@Configuration
public class SpringDataTutorial {

   public static void main(String[] args) {
      SpringApplication app = new SpringApplication(SpringDataTutorial.class);
      app.setShowBanner(true);
      app.run(args);
   }
}