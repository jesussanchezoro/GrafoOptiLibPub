package grafo.optilib.metaheuristics;

import grafo.optilib.structure.Solution;

public interface Combiner<S extends Solution> {

	public S combine(S s1, S s2);
}
