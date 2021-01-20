package com.RibeiroFilho92.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RibeiroFilho92.domain.Client;
import com.RibeiroFilho92.repositories.ClientRepository;
import com.RibeiroFilho92.services.exception.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository rep;
	
	public Client find(Long ID) {
		Optional<Client> obj = rep.findById(ID);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found. ID: " + ID + ", type " + Client.class.getName()));
	}
	
}
