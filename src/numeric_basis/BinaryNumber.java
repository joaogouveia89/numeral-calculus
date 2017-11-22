package numeric_basis;

public class BinaryNumber {
	private String value;	
	
	public BinaryNumber(int n) {
		super();
		fromDecimal(n);
	}	

	public BinaryNumber() {
		super();
	}

	public String getValue() {
		return value;
	}
	
	public void fromDecimal(int n) {
		int a = n;
		while(a != 0) {
			if(value == null) {
				value = Integer.toString(a%2);
			}else {
				value = Integer.toString(a%2) + value;
			}			
			a = a/2;
		}
	}
}
