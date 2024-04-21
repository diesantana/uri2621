package com.devsuperior.uri2621;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.repositories.ProductRepository;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("\nRESULTADO SQL RAIZ");
		List<ProductMinDTO> resultSQL = repository.search1(10, 20, "P")
				.stream().map(x -> new ProductMinDTO(x.getName())).toList(); 
		
		for (ProductMinDTO dtoSQL : resultSQL) {
			System.out.println(dtoSQL);
		}
		System.out.println("\n\n");
		
		
		
		System.out.println("\nRESULTADO SPQL");
		List<ProductMinDTO> resultJPQL = repository.search2(10, 20, "P"); 
		
		for (ProductMinDTO dtoJPQL : resultJPQL) {
			System.out.println(dtoJPQL);
		}
		System.out.println("\n\n");
		
		
	}
}
