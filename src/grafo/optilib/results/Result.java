package grafo.optilib.results;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores the results for every instance executed
 * @author jesussanchezoro
 *
 */
public class Result {
	
	public class ResultInfo {
		private String name;
		private double value;
		
		public ResultInfo(String name, double value) {
			this.name = name;
			this.value = value;
		}
		
		public String getName() {
			return name;
		}
		
		public double getValue() {
			return value;
		}
	}

	private String instanceName;
	private List<ResultInfo> results;
	
	public Result(String instanceName) {
		this.instanceName = instanceName;
		results = new ArrayList<>();
	}
	
	/**
	 * Adds a new result with a given name and value. Notice
	 * that two results with the same name are not merged.
	 * @param name the name of the result
	 * @param value the value of the result
	 */
	public void add(String name, double value) {
		results.add(new ResultInfo(name, value));
	}
	
	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}
	
	public String getInstanceName() {
		return instanceName;
	}
	
	public List<ResultInfo> getResults() {
		return results;
	}
}
