package org.bk.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Inventory {
    public static void main(String[] args) {
        SpringApplication.run(Inventory.class, args);
    }
}
