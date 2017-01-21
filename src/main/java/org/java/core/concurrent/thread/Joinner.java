package org.java.core.concurrent.thread;
/**
 * join方法停止正在执行的线程，执行刚加入的线程至结束
 * @author yinmengyu
 * @date  2016年9月3日
 */
public class Joinner extends Thread {
	private Sleeper sleeper;

	public Joinner(String name, Sleeper sleeper) {
		super(name);
		this.sleeper=sleeper;
		start();
	}

	@Override
	public void run() {
		try {
			sleeper.join();
		} catch (InterruptedException e) {
			System.out.println(getName()+"我被中断");
		}
		System.out.println(getName()+"我执行完了");
	}
}
