package org.java.core.concurrent.thread;

public class Sleeper extends Thread{
	private int time;
	public Sleeper(String name,int time){
		super(name);
		start();
	}
	@Override
	public void run() {
		try {
			sleep(time);
		} catch (InterruptedException e) {
			System.out.println(getName()+"被中断");
		}
		System.out.println(getName()+"被叫醒");
	}
}
