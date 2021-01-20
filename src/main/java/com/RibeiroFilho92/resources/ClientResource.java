package com.RibeiroFilho92.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RibeiroFilho92.domain.Client;
import com.RibeiroFilho92.services.ClientService;

@RestController @RequestMapping(value="/clients")
public class ClientResource {

	@Autowired
	private ClientService serv;
	
	@RequestMapping(method=RequestMethod.GET, value = "/{ID}")
	public ResponseEntity<?> find(@PathVariable Long ID) {
		Client obj = serv.find(ID);
		return ResponseEntity.ok().body(obj);
	}
}
