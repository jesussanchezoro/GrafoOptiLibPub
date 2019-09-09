package grafo.optilib.structure;

/**
 * Represents an instance of the problem.
 * @author jesussanchezoro
 *
 */
public interface Instance {

	/**
	 * Reads an instance from a file, initializing all necessary attributes
	 * @param path the (absolute or relative) path in which the instance file is located 
	 */
	public void readInstance(String path);
}
