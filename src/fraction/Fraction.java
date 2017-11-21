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