package com.RibeiroFilho92.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RibeiroFilho92.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	
}
