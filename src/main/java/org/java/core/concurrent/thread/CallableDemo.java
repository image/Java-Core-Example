package org.java.core.concurrent.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author yinmengyu
 * @date  2016年9月3日
 */
public class CallableDemo {
	static ExecutorService exec=Executors.newCachedThreadPool();
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Future<Integer> f=exec.submit(new TaskResult(50));
		//System.out.println(f.get());
		System.out.println(0<<29);
	}

}
