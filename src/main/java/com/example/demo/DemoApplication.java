package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
        System.out.println("-------------------INCIANDO---------------------");

        SpringApplication.run(DemoApplication.class, args);
	}

}


