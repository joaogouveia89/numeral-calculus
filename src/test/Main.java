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
		
		matrix.add(new Fraction(5));
		matrix.add(new Fraction(1));
		matrix.add(new Fraction(1));
		matrix.add(new Fraction(5));
		
		matrix.add(new Fraction(3));
		matrix.add(new Fraction(4));
		matrix.add(new Fraction(1));
		matrix.add(new Fraction(6));
		
		matrix.add(new Fraction(3));
		matrix.add(new Fraction(3));
		matrix.add(new Fraction(6));
		matrix.add(new Fraction(0));

		LinearSystem system = new LinearSystem(matrix, 3);
		
		List<Fraction> results = system.gaussElimination();
		
		for(int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i).toDouble());
		}
	}

}
