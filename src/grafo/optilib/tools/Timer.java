package grafo.optilib.tools;

import java.util.ArrayList;
import java.util.List;

public abstract class Timer {

	private static long tIni;
	private static long tMax;
	private static List<Long> timeStamps = new ArrayList<>();
	
	public static void initTimer() {
		tMax = Long.MAX_VALUE;
		tIni = System.currentTimeMillis();
	}
	
	public static void initTimer(long max) {
		tMax = max;
		tIni = System.currentTimeMillis();
	}
	
	public static boolean timeReached() {
		if (tIni < 0) {
			System.err.println("Timer is not initialized.");
			return false;
		} else {
			long tFin = System.currentTimeMillis();
			return ((tFin - tIni)>tMax);
		}
	}
	
	public static long getTime() {
		if (tIni < 0) {
			System.err.println("Timer is not initialized.");
			return -1;
		} else {
			long tFin = System.currentTimeMillis();
			return (tFin - tIni);
		}
	}
	
	public static void stopTime() {
		tIni = -1;
	}
	
	public static void addTimeStamp() {
		if (tIni < 0) {
			System.err.println("No time stamp added since Timer is not initialized.");
		} else {
			long time = System.currentTimeMillis() - tIni;
			timeStamps.add(time);
		}
	}
}
