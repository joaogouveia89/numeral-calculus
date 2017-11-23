package linearsystem;

import java.util.ArrayList;
import java.util.List;

import fraction.Fraction;

public class LinearSystem {
	private List<Fraction> system = new ArrayList<Fraction>();
	private int numberOfVariables;
	
	public LinearSystem(List<Fraction> system, int numberOfVariables) {
		super();
		this.system = system;
		this.numberOfVariables = numberOfVariables;
	}

	public LinearSystem() {
		super();
	}
	
	
	//linear system methods
	public List<Fraction> gaussElimination(){
		List<Fraction> results = new ArrayList<Fraction>();
		
		List<Fraction> originalList = new ArrayList<>();
		
		for(Fraction fr : system) {
			originalList.add(fr);
		}
		
		int pivotLine = 0;
		int pivotColumn = 0;
		
		while(pivotLine < getNumberOfVariables()) {
			Fraction pivot = getSystem().get(getElement(pivotLine, pivotColumn));
			
			for(int i = pivotLine + 1; i < getNumberOfVariables(); ++i) {
				Fraction m = getSystem().get(getElement(i, pivotColumn)).divFrac(pivot);
				for(int j = 0; j < getNumberOfVariables() + 1; ++j) {
					Fraction f = m;
					f = f.mulFrac(system.get(getElement(pivotLine, j)));
					f = system.get(getElement(i, j)).subFrac(f);
					system.set(getElement(i,j), f);
				}
			}
			
			pivotLine++;
			pivotColumn++;
		}
		
		
		for(int currentLine = getNumberOfVariables() - 1; currentLine >= 0; currentLine--) {
			int currentColumn = currentLine;
			Fraction sum = new Fraction(0);
			
			if(results.size() > 0) {
				for(int j = getNumberOfVariables() - 1; j > currentColumn ; --j) {
					Fraction mult = system.get(
							getElement(
									currentLine, j)
									).mulFrac(
									results.get(getNumberOfVariables() - j - 1));									
					sum = sum.sumFrac(mult);
					
				}
						
			}
			
			
			
			sum.simplify();
			
			Fraction res =
					system.get(getElement(currentLine, getNumberOfVariables()))
					.subFrac(sum)
					.divFrac(system.get(getElement(currentLine, currentColumn)));
			
			res.simplify();
			
			results.add(res);
		}
		
		system.clear();
		for(int i = 0; i < originalList.size(); i++) {
			system.add(originalList.get(i));
		}
		return results;
	}
	
	public List<Double> gaussJacobi(double error, List<Double> initialAprox){
		List<Double> results = new ArrayList<Double>();
		Double greattestDiff = null;
		Double greattestElement = null;
		double currentError;
		if(divergenceCriterion()) {
			for(Double d : initialAprox) {
				results.add(d);
			}
			List<Double> doubleSystem = new ArrayList<Double>();
			
			for(Fraction f : system) {
				doubleSystem.add(f.toDouble());
			}
			
			
			do {
				greattestDiff = null;
				greattestElement = null;
				for(int i = 0 ; i < getNumberOfVariables(); i++) {
					double res = doubleSystem.get(getElement(i, getNumberOfVariables()));
					for(int j = 0; j <= getNumberOfVariables() - 1; j++) {
						if(j != i) {
							res = res - (doubleSystem.get(getElement(i, j)) * initialAprox.get(j));
						}				
					}
					res = res/(double) doubleSystem.get(getElement(i,i));
					results.set(i, res);
				}
				
				// checking the error
				
				for(int i = 0; i < results.size(); i++) {
					if(greattestDiff == null) {
						greattestDiff = modulus(results.get(i) - initialAprox.get(i));
					}else {
						if(modulus((results.get(i) - initialAprox.get(i))) > greattestDiff) {
							greattestDiff = results.get(i) - initialAprox.get(i);
						}
					}
					
					if(greattestElement == null || modulus(results.get(i)) > greattestElement) {
						greattestElement = modulus(results.get(i));
					}
				}
				
				currentError = greattestDiff/(double) greattestElement;
				
				for(int i = 0; i < initialAprox.size(); i++) {
					initialAprox.set(i, results.get(i));
				}
			}while( currentError > error);
		}else {
			System.out.println("This method does not work for this linear system, use the Gauss Elimination instead!");
		}
		
		return results;
	}
	
	public List<Double> gaussSeidel(double error, List<Double> initialAprox){
		List<Double> results = new ArrayList<Double>();
		Double greattestDiff = null;
		Double greattestElement = null;
		double currentError;
		if(divergenceCriterion()) {
			for(Double d : initialAprox) {
				results.add(d);
			}
			List<Double> doubleSystem = new ArrayList<Double>();
			
			for(Fraction f : system) {
				doubleSystem.add(f.toDouble());
			}
			
			
			do {
				greattestDiff = null;
				greattestElement = null;
				for(int i = 0 ; i < getNumberOfVariables(); i++) {
					double res = doubleSystem.get(getElement(i, getNumberOfVariables()));
					for(int j = 0; j <= getNumberOfVariables() - 1; j++) {
						if(j != i) {
							//this line is the only difference between this method and the gauss-jacobi one
							//it uses the new calculate values instead of using the old ones
							if(j > i) {
								res = res - (doubleSystem.get(getElement(i, j)) * initialAprox.get(j));
							}else {
								res = res - (doubleSystem.get(getElement(i, j)) * results.get(j));
							}							
						}				
					}
					res = res/(double) doubleSystem.get(getElement(i,i));
					results.set(i, res);
				}
				
				// checking the error
				
				for(int i = 0; i < results.size(); i++) {
					if(greattestDiff == null) {
						greattestDiff = modulus(results.get(i) - initialAprox.get(i));
					}else {
						if(modulus((results.get(i) - initialAprox.get(i))) > greattestDiff) {
							greattestDiff = results.get(i) - initialAprox.get(i);
						}
					}
					
					if(greattestElement == null || modulus(results.get(i)) > greattestElement) {
						greattestElement = modulus(results.get(i));
					}
				}
				
				currentError = greattestDiff/(double) greattestElement;
				
				for(int i = 0; i < initialAprox.size(); i++) {
					initialAprox.set(i, results.get(i));
				}
			}while( currentError > error);
		}else {
			System.out.println("This method does not work for this linear system, use the Gauss Elimination instead!");
		}
		
		return results;
	}
	
	
	
	public int getElement(int line, int column) {
		if(line >= getNumberOfVariables() || column > (getNumberOfVariables() + 1)) {
			return -1;
		}
		return (getNumberOfVariables() + 1) * line + column;		
	}
	
	

	public List<Fraction> getSystem() {
		return system;
	}

	public void setSystem(List<Fraction> system) {
		this.system = system;
	}

	public int getNumberOfVariables() {
		return numberOfVariables;
	}

	public void setNumberOfVariables(int numberOfVariables) {
		this.numberOfVariables = numberOfVariables;
	}
	
	private boolean divergenceCriterion() {
		Fraction sum = new Fraction(0);
		for(int i = 0; i < getNumberOfVariables(); i++) {
			sum.setNum(0);
			sum.setDen(1);
			for(int j = 0 ; j < getNumberOfVariables(); j++) {
				if(i != j) {
					sum = sum.sumFrac(system.get(getElement(i, j)));
				}
			}
			if(sum.divFrac(system.get(getElement(i, i))).toDouble() > 1) {
				return false;
			}
		}
		return true;
	}
	
	// helper functions
	
	double modulus(double n) {
		if(n >= 0)
			return n;
		return n*(-1);
	}
	
}
