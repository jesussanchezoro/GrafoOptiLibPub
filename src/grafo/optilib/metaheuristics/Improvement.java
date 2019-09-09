package grafo.optilib.metaheuristics;

import grafo.optilib.structure.Solution;

/**
 * Represents an improvement method for a given problem 
 * @author jesussanchezoro
 *
 * @param <T> the type of the problem solution
 */
public interface Improvement<T extends Solution> {

	/**
	 * Improves a given solution, modifying it
	 * @param sol the solution to be improved
	 */
	public void improve(T sol);
}
