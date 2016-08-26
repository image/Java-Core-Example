package org.java.core.enumdemo;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * 1、编译器将Explore标记为final类，so无法继承Enum
 * 2、枚举实例其实就是定义在类中的常量，我们可以直接访问:Explore.HERE
 * 3、既然是类，肯定可以自己定义属性、方法
 * 4、values()方法是由编译器添加的static方法，Enum中没有
 * 5、枚举继承了Enum类，所以无法再继承其他类，只能实现.
 * @author yinmengyu
 * @date  2016年8月26日
 */
public class Reflection {
   
	public static void main(String[] args) throws Exception {
		Set<String> methods=analyze(Explore.class);
		Set<String> enumMethods=analyze(Enum.class);
		System.out.println("Explore.containAll(Enum)? "+methods.containsAll(enumMethods));
		System.out.println("Explore.removeAll(Enum): ");
		methods.removeAll(enumMethods);
		System.out.println(methods);
		OSExecute.command("javap D:/WorkSpace/Java-Core-Example/target/classes/org/java/core/enumdemo/Explore.class");
	}
	
	public static Set<String> analyze(Class<?> enumclass){
		System.out.println("---analyze class"+enumclass+"----");
		System.out.println("Interfaces:");
		for(Type t:enumclass.getGenericInterfaces())
			System.out.println(t);
		System.out.println("Base:"+enumclass.getGenericSuperclass());
		System.out.println("Methods:");
		Set<String> methods=new TreeSet<String>();
		for(Method m:enumclass.getMethods())
			methods.add(m.getName());
		System.out.println(methods);
		
		return methods;
	}
}
