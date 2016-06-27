package org.java.core.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/**
 * 数据复制
 * @author yinmengyu
 * @date  2016年6月25日
 */
public class ChanelCopy {
	private static String filepath="src"+File.separator
			+"main"+File.separator
			+"java"+File.separator
			+"org"+File.separator+"java"+File.separator
			+"core"+File.separator+"io"+File.separator;
	
	public static void main(String[] args) throws IOException {
		String[] files=new String[]{filepath+"TextFile.java","textcopy.txt"};
		copy(files);
	}
	//复制
	public static void copy(String[] files) throws IOException{
		FileChannel in=new FileInputStream(files[0]).getChannel(),
				    out=new FileOutputStream(files[1]).getChannel();
		ByteBuffer buff=ByteBuffer.allocate(1024);
		while(in.read(buff)!=-1){
			buff.flip();
			out.write(buff);
			buff.clear();
		}
	}
}
