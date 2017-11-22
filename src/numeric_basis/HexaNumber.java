package numeric_basis;

public class HexaNumber {
	private String value;	
	
	public HexaNumber(int n) {
		super();
		fromDecimal(n);
	}	

	public HexaNumber() {
		super();
	}

	public String getValue() {
		return value;
	}
	
	public void fromDecimal(int n) {
		int a = n;
		while(a != 0) {
			int reminder = a%16;
			char hexDigit;
			if(reminder == 10) {
				hexDigit = 'A';
			}else if(reminder == 11) {
				hexDigit = 'B';
			}else if(reminder == 12) {
				hexDigit = 'C';
			}else if(reminder == 13) {
				hexDigit = 'D';
			}else if(reminder == 14) {
				hexDigit = 'E';
			}else if(reminder == 15) {
				hexDigit = 'F';
			}else {
				hexDigit = Integer.toString(reminder).charAt(0);
			}
			if(value == null) {				
				value = "" + hexDigit;
			}else {
				value = hexDigit + value;
			}			
			a = a/16;
		}
	}
}
