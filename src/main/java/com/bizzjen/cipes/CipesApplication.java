package com.bizzjen.cipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.management.ManagementFactory;

@SpringBootApplication
public class CipesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CipesApplication.class, args);
        System.out.println("Number of threads " + Thread.activeCount());
        System.out.println("Total Number of threads " + ManagementFactory.getThreadMXBean().getThreadCount());
    }

}
