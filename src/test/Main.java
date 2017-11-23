package test;

import java.util.ArrayList;
import java.util.List;

import cartesian.CartesianPoint;
import fraction.Fraction;
import linearsystem.LinearSystem;
import numeric_basis.BinaryNumber;
import numeric_basis.HexaNumber;
import numeric_basis.OctalNumber;

public class Main {

	public static void main(String[] args) {
		List<Fraction> matrix = new ArrayList<Fraction>();
		
		matrix.add(new Fraction(10));
		matrix.add(new Fraction(2));
		matrix.add(new Fraction(1));
		matrix.add(new Fraction(7));
		
		matrix.add(new Fraction(1));
		matrix.add(new Fraction(5));
		matrix.add(new Fraction(1));
		matrix.add(new Fraction(-8));
		
		matrix.add(new Fraction(2));
		matrix.add(new Fraction(3));
		matrix.add(new Fraction(10));
		matrix.add(new Fraction(6));

		LinearSystem system = new LinearSystem(matrix, 3);
		List<Double> initialAprox = new ArrayList<>();
		initialAprox.add(0.7);
		initialAprox.add(-1.6);
		initialAprox.add(0.6);
		
		List<Double> results = system.gaussJacobi(0.05, initialAprox);
		
		for(int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i));
		}
	}

}
