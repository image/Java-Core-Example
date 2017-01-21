package org.java.core.conconcurrent.thread;

import org.java.core.concurrent.thread.Joinner;
import org.java.core.concurrent.thread.Sleeper;
import org.junit.Test;

import sun.misc.Unsafe;

public class ThreadTest {
   @Test
	public void testJoin(){
	   Sleeper lily=new Sleeper("lily", 5000);
	   Sleeper pite=new Sleeper("pite", 1000);
	   Joinner join=new Joinner("join", lily);
	   Joinner selrain=new Joinner("selrain", pite);
	   lily.interrupt();
   }
}
