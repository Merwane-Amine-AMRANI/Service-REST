package org.amrani.type2;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Civility {
	
	MR("M"),
	MRS("Mme"),
	MLLE("Mlle");
	
	private String label;

	private Civility(String label) {
		this.label = label;
	}
	
	public static Civility of(String label){
		
		return Arrays.stream(values())
					 .filter(value->value.label.equals(label))
					 .findFirst()
					 .orElseThrow(()-> new NoSuchElementException("No civility for +"+label));			  
	}
}
