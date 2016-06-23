package org.java.core.io.zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 多文件压缩：
 * 使用：直接将输出流包装在ZipOutputStream中（压缩），或将输入流包装在ZipInputStream(解压缩)
 * 和普通读写文件的区别即中间套了ZipInputStream或ZipOutputStream流
 * @author yinmengyu
 * @date  2016年6月22日
 */
public class ZipCompress {
   
	private static String filepath="src"+File.separator
								+"main"+File.separator
								+"java"+File.separator
								+"org"+File.separator+"java"+File.separator
								+"core"+File.separator+"io"+File.separator;
	public static void main(String[] args) throws IOException {
		zipFiles(new String[]{"TextFile.java"});
	}
	private static void zipFiles(String[] fileNames) throws IOException{
		FileOutputStream f=new FileOutputStream("test.zip");
		//校验流
		CheckedOutputStream ch=new CheckedOutputStream(f, new Adler32());
		ZipOutputStream z=new ZipOutputStream(ch);
		BufferedWriter b=new BufferedWriter(new OutputStreamWriter(z));
		z.setComment("测试 java zip stream");
		for(String name:fileNames){
			System.out.println("写入文件:"+name);
			BufferedReader reader=new BufferedReader(new FileReader(new File(filepath+name).getAbsolutePath()));
			//Begins writing a new ZIP file entry and positions the stream to the start of the entry data
			z.putNextEntry(new ZipEntry(name));
			String c;
			while((c=reader.readLine())!=null){
				b.write(c);
				b.write("\n");
			}
			reader.close();
		}
		b.close();
		System.out.println("CheckSum："+ch.getChecksum().getValue());
		System.out.println("解压缩开始");
		FileInputStream in=new FileInputStream("test.zip");
		CheckedInputStream chi=new CheckedInputStream(in, new Adler32());
		ZipInputStream zipi=new ZipInputStream(chi);
		//字节流套在InputStreamReader中转换为字符流读取
		BufferedReader r=new BufferedReader(new InputStreamReader(zipi));
		ZipEntry ze=null;
		while ((ze=zipi.getNextEntry())!=null){
			System.out.println("reading file "+ze);
			BufferedWriter bw=new BufferedWriter(new FileWriter("testzip.txt"));
			String str="";
			while((str=r.readLine())!=null){
				bw.write(str);
				bw.write("\n");
			}
			bw.close();
		}
		r.close();	
		System.out.println("解压缩完毕");
	}
	
}
