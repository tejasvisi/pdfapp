package com.example.pdfapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PdfappApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdfappApplication.class, args);
	}

}
