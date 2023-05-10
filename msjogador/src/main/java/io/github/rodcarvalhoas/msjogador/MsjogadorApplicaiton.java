package io.github.rodcarvalhoas.msjogador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsjogadorApplicaiton {
    public static void main(String[] args) {
        SpringApplication.run(MsjogadorApplicaiton.class, args);
    }
}
