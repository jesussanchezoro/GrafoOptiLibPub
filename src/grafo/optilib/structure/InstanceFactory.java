package grafo.optilib.structure;

/**
 * Class for creating instances 
 * @author jesussanchezoro
 *
 * @param <T> the type of the instance
 */
public abstract class InstanceFactory<T extends Instance> {
	
	/**
	 * Creates an instance reading it from a file
	 * @param path the path where the instance file is located
	 * @return the instance properly initialized with data found in path
	 */
	public abstract T readInstance(String path);
}
