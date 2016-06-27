package org.java.core.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/**
 * 视图缓冲器
 * @author yinmengyu
 * @date 2016年6月25日
 */
public class ViewBuffers {
	public static void main(String[] args) {
		ByteBuffer buff=ByteBuffer.wrap(new byte[]{0,0,0,0,0,'a',0,0});
		while (buff.hasRemaining()){
			System.out.print(buff.position()+"->"+buff.get()+",");
		}
		System.out.println("\nCharBuffer");
		CharBuffer cbuff=((ByteBuffer)buff.rewind()).asCharBuffer();
		while(cbuff.hasRemaining()){
			System.out.print(cbuff.position()+"->"+cbuff.get()+",");
		}
		System.out.println("\nFloatBuffer");
		FloatBuffer fbuff=((ByteBuffer)buff.rewind()).asFloatBuffer();
		while(fbuff.hasRemaining()){
			System.out.print(fbuff.position()+"->"+fbuff.get()+",");
		}
		System.out.println("\nIntBuffer");
		IntBuffer ibuff=((ByteBuffer)buff.rewind()).asIntBuffer();
		while(ibuff.hasRemaining()){
			System.out.print(ibuff.position()+"->"+ibuff.get()+",");
		}
	}
}
