package cartesian;

public class CartesianPoint {
	private int x;
	private int y;
	
	
	public CartesianPoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public CartesianPoint() {
		super();
	}



	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public double distanceTo(CartesianPoint p) {
		double dist;
		
		dist = Math.sqrt((
				Math.pow((p.getX() - this.x), 2) + 
				Math.pow((p.getY() - this.y), 2)
				));
		
		return dist;
	}
	
}
