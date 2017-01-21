package org.java.core.generic.inteface;

public class Coffee {
	private static long count;

	@Override
	public String toString() {
		return getClass().getSimpleName()+""+count++;
	}
	
}
