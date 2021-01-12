package com.RibeiroFilho92;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.RibeiroFilho92.domain.Category;
import com.RibeiroFilho92.repositories.CategoryRepository;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository rep;

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category c1 = new Category(null, "Computing");
		Category c2 = new Category(null, "Healthy");
		
		rep.saveAll(Arrays.asList(c1, c2));
		
	}

}
