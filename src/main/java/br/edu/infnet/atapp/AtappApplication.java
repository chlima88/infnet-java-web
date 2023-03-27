package br.edu.infnet.atapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AtappApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtappApplication.class, args);
	}

}
