package ch.bbw.service01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableFeignClients
@EntityScan(basePackages = "ch.bbw.service01")
public class ServiceKatalog {
    public static void main(String[] args) {
        SpringApplication.run(ServiceKatalog.class, args);


    }
}

