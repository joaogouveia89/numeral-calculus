package functions;

import java.util.ArrayList;
import java.util.List;

import fraction.Fraction;
import linearsystem.LinearSystem;

public class Interpolation {
	private List<Double> xValues;
	private List<Double> yValues;	
	
	private int degree;
	


	public Interpolation(List<Double> xValues, List<Double> yValues, int degree) {
		super();
		this.xValues = xValues;
		this.yValues = yValues;
		this.degree = degree;
	}	
	
	public Interpolation() {
		super();
	}
	
	public double linearSystem(double xPoint) {
		double res = 0;
		List<Fraction> system = new ArrayList<Fraction>();
		// Building the linear system
		for(int i = 0; i < xValues.size(); i++) {
			for(int j = 0; j <= degree; j++) {
				Fraction f = new Fraction(xValues.get(i));
				f.pow(j);				
				system.add(f);
			}
			Fraction f = new Fraction(yValues.get(i));
			system.add(f);
		}
		
		LinearSystem ls = new LinearSystem(system, degree+1);
		
		List<Fraction> results = ls.gaussElimination();
		
		for(int i = results.size() - 1; i >= 0; --i) {
			res += Math.pow(xPoint, i) *(double) results.get(results.size() - 1 - i).toDouble();
		}
		
		return res;
	}
	
	public List<Double> getxValues() {
		return xValues;
	}
	public void setxValues(List<Double> xValues) {
		this.xValues = xValues;
	}
	public List<Double> getyValues() {
		return yValues;
	}
	public void setyValues(List<Double> yValues) {
		this.yValues = yValues;
	}
	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}
	
}
