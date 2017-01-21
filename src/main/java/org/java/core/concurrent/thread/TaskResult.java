package org.java.core.concurrent.thread;

import java.util.concurrent.Callable;

/**
 * Runnable执行独立的任务，但是他不返回值
 * 如果希望完成任务返回值可以使用Callable
 * call方法必须使用ExecutorService.submit方法调用
 * @author yinmengyu
 * @date  2016年9月3日
 */
public class TaskResult implements Callable<Integer>{

	private int count;
	
	public TaskResult(int count){
		this.count=count;
	}
	public Integer call() throws Exception {
		return fib(count);
	}
	public int fib(int count){
		if(count==1||count==0){
			return 1;
		}else{
			 return fib(count-1)+fib(count-2);
		}
		
	}
}
