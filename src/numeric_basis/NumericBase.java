package numeric_basis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import numeric_basis.NumericBase.Builder.NumericBaseException;

public class NumericBase {
	
	public static final int BINARY = 2;
	public static final int OCTAL = 8;
	public static final int DECIMAL = 10;
	public static final int HEXADECIMAL = 16;
	
	private HashMap<Integer, String> conversions = new HashMap<>();
	private boolean validNumber = false;
	
	private NumericBase() {}
	
	public String getConversion(int base) throws NumericBaseException{
		if(!validNumber)
			throw new NumericBaseException(NumericBaseException.MALFORMED_OBJECT_REBUILD);
		return conversions.get(base);
	}
	
	public static class Builder {
		private int base = DECIMAL;
		private String input;
		private int asciiFirst = 48;
		private List<Integer> outputBases = new ArrayList<Integer>() {
			{
				add(BINARY);
				add(OCTAL);
				add(DECIMAL);
				add(HEXADECIMAL);
			}		
		};
		private NumericBase nb = new NumericBase();
		
		public Builder setInputBase(int base) {
			this.base = base;
			return this;
		}
		
		public Builder setNumber(String input) {
			this.input = input;
			return this;
		}
		
		public Builder addOutputBase(int base) {
			outputBases.add(base);
			return this;
		}
		
		private boolean isValid() {
			for(int i = 0; i < input.length(); i++) {
				if((int)input.charAt(i) < asciiFirst || (int)input.charAt(i) > (asciiFirst + base - 1))
					return false;
			}
			return true;
		}
		
		private String toDecimal() {
			int decimal = 0;
			for(int i = (input.length()-1); i >= 0 ; i--) {
				decimal += Math.pow(base, i) * Character.getNumericValue(input.charAt(input.length() - i - 1));
			}
			return Integer.toString(decimal);
		}
		
		public NumericBase build() throws NumericBaseException {
			if(!isValid()) {
				throw new NumericBaseException(NumericBaseException.INVALID_INPUT_FOR_BASE);
			}
			nb.validNumber = true;
			nb.conversions.put(this.base, this.input);
			if(base != DECIMAL) {
				nb.conversions.put(DECIMAL, toDecimal());
			}
			return nb;
		}
		
		public static class NumericBaseException extends Exception{
			public static final String INVALID_INPUT_FOR_BASE = "Invalid input number for base";
			public static final String MALFORMED_OBJECT_REBUILD = "Malformed object, please rebuild it";
			public NumericBaseException(String error) {
				super(error);
			}
		}
	}
	
	
}
