package fraction;

public class Fraction {
	private int num;
	private int den;
	
	
	/* ============================================================
	 * **********************CONSTRUCTORS**************************
	 * ============================================================
	 */
	
	public Fraction(int num, int den) {
		super();
		this.num = num;
		this.den = den;
	}
	
	public Fraction(double n) {
		int mult = 0;
		double integerUp = Math.floor(n);
		while((integerUp - n) != 0) {
			mult++;
			n *= 10;
			integerUp = Math.floor(n);
		}
		this.num = (int) n;
		this.den = (int)Math.pow(10, mult);
	}
	
	public Fraction(int n) {
		this.num = n;
		this.den = 1;
	}
	
	/* ============================================================
	 * ****************GETTERS AND SETTERS*************************
	 * ============================================================
	 */
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getDen() {
		return den;
	}
	public void setDen(int den) {
		this.den = den;
	}
	
	/* ============================================================
	 * *********************BASIC OPERATIONS**********************
	 * ============================================================
	 */
	
	public Fraction sumFrac(Fraction f){
		return new Fraction(
				f.den * this.num + this.den *f.num,
				this.den * f.den);
	}
	
	public Fraction subFrac(Fraction f){
		return new Fraction(
				f.den * this.num - this.den *f.num,
				this.den * f.den);
	}
	
	public Fraction mulFrac(Fraction f){
		return new Fraction(
				this.num * f.num,
				this.den * f.den
				);
	}
	
	public Fraction divFrac(Fraction f){
		Fraction auxf = new Fraction(f.den, f.num);		
		return mulFrac(auxf);
	}
	
	public void pow(int power) {
		/**
		 * 5th year of school lesson: 
		 * PT: Todo numero diferente de zero, elevado a zero é igual a 1
		 * EN: Any number different from zero, powered on zero results in 1
		 */
		if(power == 0) {
			if(this.num != 0) {
				this.num = 1;
			}			
			this.den = 1;
			return;
		}else if(power != 1) {
			int oldNum = this.num;
			int oldDen = this.den;
			for(int i = 0; i < power-1; i++) {
				this.num *= oldNum;
				this.den *= oldDen;
			}
		}
		
	}
	
	/* ============================================================
	 * ********************TRANSFORMATION**************************
	 * ============================================================
	 */
	
	public double toDouble(){
		return this.num/(double)this.den;
	}
	
	public void simplify() {
		int gdc = euclidGreatterCommonDivisor(this.num, this.den);
		this.num = this.num/gdc;
		this.den = this.den/gdc;
	}
	
	private int euclidGreatterCommonDivisor(int a, int b) {
		int aux;
		if(a == 0) {
			aux = a;
			a = b;
			b = aux;
		}
		
		if(b == 0)
			return a;
		return euclidGreatterCommonDivisor(b,  a%b);
	}
	
	
	@Override
	public String toString() {
		return this.getNum() + "/" + this.getDen();
	}
}