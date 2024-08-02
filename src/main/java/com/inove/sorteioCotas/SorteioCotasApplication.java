package com.inove.sorteioCotas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.inove.sorteioCotas.models")
public class SorteioCotasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SorteioCotasApplication.class, args);
	}

}

