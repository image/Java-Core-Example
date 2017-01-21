package org.java.core.generic.inteface;

import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee> {
	
	private Class[] type=new Class[]{Moca.class,Lattor.class};
	@Override
	public Coffee next() {
		try {
			return (Coffee) type[new Random().nextInt(2)].newInstance();
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		CoffeeGenerator g=new CoffeeGenerator();
		System.out.println(g.next());
	}
}
