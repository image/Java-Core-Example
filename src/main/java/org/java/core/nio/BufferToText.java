package org.java.core.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * asCharBuffer()方法乱码问题处理
 * @author yinmengyu
 * @date 2016年6月25日
 */
public class BufferToText {
	public static void main(String[] args) throws IOException {
		FileChannel fc=new FileOutputStream("data2.txt").getChannel();
		fc.write(ByteBuffer.wrap("some text".getBytes()));
		fc.close();
		fc=new FileInputStream("data2.txt").getChannel();
		ByteBuffer buff=ByteBuffer.allocate(1024);
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());//乱码
		//用系统默认编码解码
		buff.rewind();//返回到数据开始部分
		String encoding=System.getProperty("file.encoding");
		System.out.println("Decoding using "+encoding+": "+Charset.forName(encoding).decode(buff));
		//也可以使用指定编码
		fc=new FileOutputStream("data2.txt").getChannel();
		fc.write(ByteBuffer.wrap("some text".getBytes("utf-16be")));
		fc.close();
		fc=new FileInputStream("data2.txt").getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
		//直接使用CharBuffer
		fc=new FileOutputStream("data2.txt").getChannel();
		buff=ByteBuffer.allocate(24);
		buff.asCharBuffer().put("some more");
		fc.write(buff);
		fc.close();
		
		fc=new FileInputStream("data2.txt").getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
	}
}
