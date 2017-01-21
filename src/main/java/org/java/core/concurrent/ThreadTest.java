package org.java.core.concurrent;


import sun.misc.Unsafe;

public class ThreadTest {
	private volatile int i = 0;
	
	private static final Unsafe unsafe = Unsafe.getUnsafe();
	private static final long valueOffset;
	static {
        try {
            valueOffset = unsafe.objectFieldOffset
                (ThreadTest.class.getDeclaredField("i"));
        } catch (Exception ex) { throw new Error(ex); }
    }
	public void add(int j){
		unsafe.getAndAddInt(this, valueOffset, j);
	}
}
