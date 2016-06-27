package org.java.core.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * 交换相邻字符
 * 
 * @author yinmengyu
 * @date 2016年6月27日
 */
public class UsingBuffers {
	public static void main(String[] args) {
		char[] ch="HelloWorld".toCharArray();
		ByteBuffer buff=ByteBuffer.allocate(ch.length*2);
		CharBuffer cbuff=buff.asCharBuffer();
		cbuff.put(ch);
		System.out.println(cbuff.rewind());
		wrapChar(cbuff);
		System.out.println(cbuff.rewind());
	}

	private static void wrapChar(CharBuffer buff) {
		while (buff.hasRemaining()) {
			buff.mark();
			char c1 = buff.get();
			char c2 = buff.get();
			buff.reset();
			buff.put(c2).put(c1);
		}
	}
}
