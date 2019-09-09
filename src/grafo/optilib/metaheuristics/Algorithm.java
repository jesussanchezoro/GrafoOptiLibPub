package grafo.optilib.metaheuristics;

import grafo.optilib.results.Result;
import grafo.optilib.structure.Instance;
import grafo.optilib.structure.Solution;

/**
 * Represents an algorithm for the problem
 * @author jesussanchezoro
 *
 * @param <T> the type of the considered instances
 */
public interface Algorithm<T extends Instance> {

	/**
	 * Executes the algorithm and obtains a result for it
	 * @param instance the instance to be executed
	 * @return the results obtained by the algorithm
	 */
	public Result execute(T instance);
	/**
	 * Getter for the best solution found
	 * @return the best solution found in the search, or null if not executed
	 */
	public Solution getBestSolution();
	
}
