package org.java.core.generic;
/**
 * 简单的泛型类
 * @author yinmengyu
 * @date  2017年1月21日
 * @param <T>
 */
public class Holder<T> {
	private T a;

	public Holder(T a) {
		this.a = a;
	}
	public T get(){
		return a;
	}
}
