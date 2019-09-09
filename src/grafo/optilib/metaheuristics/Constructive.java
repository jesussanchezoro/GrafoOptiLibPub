package grafo.optilib.metaheuristics;

import grafo.optilib.structure.Instance;
import grafo.optilib.structure.Solution;

/**
 * Represents a constructive method for a given problem.
 * @author jesussanchezoro
 *
 * @param <T> the type of the instance
 * @param <S> the type of the solution
 */
public interface Constructive<T extends Instance, S extends Solution> {

	/**
	 * Constructs a new solution using the given instance
	 * @param instance the instance to be used in the construction
	 * @return the constructed solution
	 */
	public S constructSolution(T instance);
}
