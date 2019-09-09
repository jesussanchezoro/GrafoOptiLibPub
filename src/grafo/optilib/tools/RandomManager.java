package grafo.optilib.tools;

import java.util.Random;

public abstract class RandomManager {

	private static Random rnd;
	
	public static void setSeed(long value) {
		rnd = new Random(value);
	}
	
	public static Random getRandom() {
		if (rnd == null) {
			System.err.println("Random seed not initialized.");
			System.exit(-1);
		}
		return rnd;
	}
}
