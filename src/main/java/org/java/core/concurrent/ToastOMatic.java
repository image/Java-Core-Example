package org.java.core.concurrent;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import sun.misc.Unsafe;

/**
 * 阻塞队列实现
 * 每个类只和他的BlockingQueue通信，相当于使用wait和notify
 * @author yinmengyu
 * @date 2016年9月4日
 */
public class ToastOMatic{
	 public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Toast> dryQueue=new LinkedBlockingQueue<>(),
				butterQueue=new LinkedBlockingQueue<>();
		ExecutorService exec=Executors.newCachedThreadPool();
		exec.execute(new Toster(dryQueue));
		exec.execute(new Butterer(dryQueue,butterQueue));
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}
}
 class Toast{
	public enum Status {
		DRY, BUTTERED, JAMMED
	};

	private Status status = Status.DRY;
	private final int id;

	public Toast(int id) {
		this.id = id;
	}
	public void butter(){
		status=Status.BUTTERED;
	}
	
	public void jam(){
		status=Status.JAMMED;
	}
	
	public Status getStatus(){
		return status;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Toast [status=" + status + ", id=" + id + "]";
	}
	
}
 class Toster implements Runnable{
	 private BlockingQueue<Toast> tostQueue;
	 private int count=0;
	 private Random ran=new Random(47);
	 public Toster(BlockingQueue tQueue) {
	     this.tostQueue=tQueue;
	 }
	@Override
	public void run() {
		while(!Thread.interrupted()){
			try {
				TimeUnit.MILLISECONDS.sleep(100+ran.nextInt(50));
				Toast t=new Toast(count++);
				tostQueue.put(t);
			} catch (InterruptedException e) {
				System.out.println("dry interrupt");
			}
		}
		System.out.println("Toster off");
	}
	 
 }
 
 class Butterer implements Runnable{
	 private BlockingQueue<Toast> dryQueue,butterQueue;
	 public Butterer(BlockingQueue dryQueue,BlockingQueue butterQueue) {
	     this.dryQueue=dryQueue;
	     this.butterQueue=butterQueue;
	 }
	@Override
	public void run() {
		while(!Thread.interrupted()){
			try {
				Toast t=dryQueue.take(); //阻塞直到dryQueue队列中有值
				t.butter();
				System.out.println(t);
				butterQueue.put(t);
			} catch (InterruptedException e) {
				System.out.println("butter interrupt");
			}
		}
		System.out.println("Butterer off");
	}
	 
 }
