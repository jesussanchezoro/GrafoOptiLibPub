package grafo.optilib.metaheuristics;

import grafo.optilib.structure.Solution;

public interface GreedyFunction<S extends Solution> {

	public double greedy(S sol);
}
