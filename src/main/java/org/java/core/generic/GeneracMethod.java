package org.java.core.generic;
/**
 * 泛型方法：
 * 1、若使用泛型方法可以代替使用泛型类，那就应该使用泛型方法
 * 2、static方法需要使用泛型，必须使用泛型方法（static方法无法访问泛型类的参数）
 * 定义：
 * 将泛型参数置于返回值前
 * @author yinmengyu
 * @date  2017年1月21日
 */
public class GeneracMethod {
  public <T> void f(T t){
	  System.out.println(t.getClass().getSimpleName());
  }
  
  public static void main(String[] args) {
	GeneracMethod g=new GeneracMethod();
	g.f(2);
	g.f("a");
}
}
