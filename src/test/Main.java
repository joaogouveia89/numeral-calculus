package test;

import numeric_basis.NumericBase;
import numeric_basis.NumericBase.Builder.NumericBaseException;

public class Main {
	
	private static NumericBase nb = null;

	public static void main(String[] args){
		try {
			nb = new NumericBase.Builder()
					.setInputBase(NumericBase.BINARY)
					.setNumber("111001")
					.build();
			System.out.println(nb.getConversion(NumericBase.DECIMAL));
		}catch(NumericBaseException e) {
			System.out.println(e.getMessage());
		}
	}

}
