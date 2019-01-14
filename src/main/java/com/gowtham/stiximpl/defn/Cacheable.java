package com.gowtham.stiximpl.defn;

public interface Cacheable {

	
	public boolean isExpired();
	
	public Object getIdentifier();
}
