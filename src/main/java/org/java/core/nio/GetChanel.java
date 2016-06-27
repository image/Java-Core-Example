package org.java.core.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileChanel
 * @author yinmengyu
 * @date  2016年6月24日
 */
public class GetChanel {
	private static final int BSIZE=1024;
	
	public static void main(String[] args) throws IOException {
		//写文件
		FileChannel fc=new FileOutputStream("data.txt").getChannel();
		fc.write(ByteBuffer.wrap("some one".getBytes()));
		//在文件中追加
		fc=new RandomAccessFile("data.txt", "rw").getChannel();
		fc.position(fc.size());
		fc.write(ByteBuffer.wrap(" some more".getBytes()));
		fc.close();
		//读取文件
		fc=new FileInputStream("data.txt").getChannel();
		ByteBuffer buff=ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		buff.flip();
		while(buff.hasRemaining()){
			System.out.print((char)buff.get());
		}
		
	}
}
