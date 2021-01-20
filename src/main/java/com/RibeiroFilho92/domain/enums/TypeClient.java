package com.RibeiroFilho92.domain.enums;

public enum TypeClient {

	LEGALENTITY(0L),
	NATURALPERSON(1L);
	
	private Long code;
	
	private TypeClient(Long code) {
		this.code = code;
	}
	
	public Long getCode() {
		return code;
	}
	
	public static TypeClient toEnum(Long code) {
		if (code == null) {
			return null;
		}
		
		for (TypeClient x: TypeClient.values()) {
			if (code.equals(x.getCode())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid ID: " + code);
	}
}
