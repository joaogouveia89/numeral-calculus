package numeric_basis;

public class OctalNumber {
	private String value;	
	
	public OctalNumber(int n) {
		super();
		fromDecimal(n);
	}	

	public OctalNumber() {
		super();
	}

	public String getValue() {
		return value;
	}
	
	public void fromDecimal(int n) {
		int a = n;
		while(a != 0) {
			if(value == null) {
				value = Integer.toString(a%8);
			}else {
				value = Integer.toString(a%8) + value;
			}			
			a = a/8;
		}
	}
}
