package com.RibeiroFilho92.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RibeiroFilho92.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	
}
