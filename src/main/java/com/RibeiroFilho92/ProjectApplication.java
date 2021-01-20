package com.RibeiroFilho92;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.RibeiroFilho92.domain.Address;
import com.RibeiroFilho92.domain.Category;
import com.RibeiroFilho92.domain.City;
import com.RibeiroFilho92.domain.Client;
import com.RibeiroFilho92.domain.Product;
import com.RibeiroFilho92.domain.State;
import com.RibeiroFilho92.domain.enums.TypeClient;
import com.RibeiroFilho92.repositories.AddressRepository;
import com.RibeiroFilho92.repositories.CategoryRepository;
import com.RibeiroFilho92.repositories.CityRepository;
import com.RibeiroFilho92.repositories.ClientRepository;
import com.RibeiroFilho92.repositories.ProductRepository;
import com.RibeiroFilho92.repositories.StateRepository;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository repOne;
	
	@Autowired
	private ProductRepository repTwo;
	
	@Autowired
	private StateRepository repThree;

	@Autowired
	private CityRepository repFour;
	
	@Autowired
	private ClientRepository repFive;
	
	@Autowired
	private AddressRepository repSix;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category c1 = new Category(null, "Computing");
		Category c2 = new Category(null, "Healthy");
		
		Product p1 = new Product("Mac Pro", 8_000.00);
		Product p2 = new Product("Widescreen Monitor", 1_500.00);
		Product p3 = new Product("Mouse and keyboard", 900.00);
		Product p4 = new Product("Kit whey protein + creatine", 900.00);
		
		State st1 = new State("Minas Gerais");
		State st2 = new State("São Paulo");
		
		City city1 = new City("Uberlândia", st1);
		City city2 = new City("São Paulo", st2);
		City city3 = new City("Campinas", st2);
		
		st1.getCities().addAll(Arrays.asList(city1));
		st2.getCities().addAll(Arrays.asList(city2, city3));
		
		c1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		c2.getProducts().addAll(Arrays.asList(p4));
		
		p1.getCategories().addAll(Arrays.asList(c1));
		p2.getCategories().addAll(Arrays.asList(c1));
		p3.getCategories().addAll(Arrays.asList(c1));
		p4.getCategories().addAll(Arrays.asList(c2));
		
		Client cli1 = new Client("Bill Gates", "bg@microsoft.com", "123456789", TypeClient.NATURALPERSON);
		
		Address ad1 = new Address("N Andrews Ave", "6750", "33309", city1, cli1);
		Address ad2 = new Address("Walter-Gropius-Straße", "5", "85716", city2, cli1);
		
		cli1.getPhones().addAll(Arrays.asList("9123512658", "32157841"));
		cli1.getAddresses().addAll(Arrays.asList(ad1, ad2));
		
		repOne.saveAll(Arrays.asList(c1, c2));
		repTwo.saveAll(Arrays.asList(p1, p2, p3, p4));
		repThree.saveAll(Arrays.asList(st1, st2));
		repFour.saveAll(Arrays.asList(city1, city2, city3));
		repFive.saveAll(Arrays.asList(cli1));
		repSix.saveAll(Arrays.asList(ad1, ad2));
	}

}
