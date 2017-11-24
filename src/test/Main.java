package test;

import java.util.ArrayList;
import java.util.List;

import cartesian.CartesianPoint;
import fraction.Fraction;
import functions.Interpolation;
import linearsystem.LinearSystem;
import numeric_basis.BinaryNumber;
import numeric_basis.HexaNumber;
import numeric_basis.OctalNumber;

public class Main {

	public static void main(String[] args) {
		List<Double> x = new ArrayList<>();
		List<Double> y = new ArrayList<>();
		
		x.add(-1.0);
		x.add(0.0);
		x.add(2.0);
		
		y.add(4.0);
		y.add(1.0);
		y.add(-1.0);
		
		Interpolation interpolation = new Interpolation(x, y, 2);
		
		double val = interpolation.linearSystem(12.0);
		
		System.out.println(val);
	}

}
