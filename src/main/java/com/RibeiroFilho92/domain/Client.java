package com.RibeiroFilho92.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.RibeiroFilho92.domain.enums.TypeClient;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Client implements Serializable {

	private static final long serialVersionUID = 7L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	private String name;
	private String email;
	private String socialCode;
	private Long type;
	
	@OneToMany(mappedBy = "client") @JsonManagedReference
	private List<Address> addresses = new ArrayList<> ();
	
	@ElementCollection @CollectionTable(name = "phone")
	private Set<String> phones = new HashSet<> ();
	
	public Client() {}

	public Client(String name, String email, String socialCode, TypeClient type) {
		this.name = name;
		this.email = email;
		this.socialCode = socialCode;
		this.type = type.getCode();
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSocialCode() {
		return socialCode;
	}

	public void setSocialCode(String socialCode) {
		this.socialCode = socialCode;
	}

	public TypeClient getType() {
		return TypeClient.toEnum(type);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}

	public void setType(TypeClient type) {
		this.type = type.getCode();
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}
	
	
}
