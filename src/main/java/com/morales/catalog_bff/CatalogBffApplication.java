package com.morales.catalog_bff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CatalogBffApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogBffApplication.class, args);
		System.out.println("Servicio 'Catalog-bff' iniciado correctamente.");
	}
}
