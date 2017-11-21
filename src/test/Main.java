package test;

import java.util.ArrayList;
import java.util.List;

import fraction.Fraction;
import linearsystem.LinearSystem;

public class Main {

	public static void main(String[] args) {
		List<Fraction> matrix = new ArrayList<Fraction>();
		
		matrix.add(new Fraction(5));
		matrix.add(new Fraction(-2));
		matrix.add(new Fraction(1));
		matrix.add(new Fraction(-3));
		matrix.add(new Fraction(1));
		matrix.add(new Fraction(15));

		matrix.add(new Fraction(2));
		matrix.add(new Fraction(1));
		matrix.add(new Fraction(-4));
		matrix.add(new Fraction(-8));
		matrix.add(new Fraction(2));
		matrix.add(new Fraction(-6));
		
		matrix.add(new Fraction(1));
		matrix.add(new Fraction(-1));
		matrix.add(new Fraction(1));
		matrix.add(new Fraction(-1));
		matrix.add(new Fraction(1));
		matrix.add(new Fraction(9));
		
		matrix.add(new Fraction(2));
		matrix.add(new Fraction(2));
		matrix.add(new Fraction(5));
		matrix.add(new Fraction(3));
		matrix.add(new Fraction(-3));
		matrix.add(new Fraction(7));
		
		matrix.add(new Fraction(-1));
		matrix.add(new Fraction(5));
		matrix.add(new Fraction(-3));
		matrix.add(new Fraction(-2));
		matrix.add(new Fraction(1));
		matrix.add(new Fraction(-8));

		LinearSystem system = new LinearSystem(matrix, 5);
		
		List<Fraction> results = system.gaussElimination();
		
		for(int n = 0; n < results.size(); n ++) {
			Fraction f = results.get(n);
			double v = f.toDouble();
			System.out.println(v);
		}
	}

}
