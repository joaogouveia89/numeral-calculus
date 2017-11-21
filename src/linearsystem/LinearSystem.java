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
	
	
	
}
