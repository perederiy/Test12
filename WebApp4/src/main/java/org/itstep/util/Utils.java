package org.itstep.util;

public class Utils {

	public static int getIncrementId(int id) {
		int counter = 0;
		counter++;
		return id + counter + 1;
	}
}
