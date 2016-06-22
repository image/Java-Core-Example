package org.java.core.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile extends ArrayList<String> {

	public static void main(String[] args) {
		//读文件
		String file=read("src/main/java/org/java/core/io/TextFile.java");
		//写文件
		write("src/main/java/org/java/core/io/text.txt", file);
		
		TextFile text = new TextFile("src/main/java/org/java/core/io/text.txt");
		//写入text2.txt
		text.write("src/main/java/org/java/core/io/text2.txt");
		
		TreeSet<String> words=new TreeSet<String>(new TextFile("src/main/java/org/java/core/io/text2.txt",
				"\\W+"));
		
		System.out.println(words.headSet("a"));
	}

	// 读取文件
	public static String read(String filename) {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File(filename).getAbsolutePath()));
			String s = "";
			while ((s = reader.readLine()) != null) {
				sb.append(s).append("\n");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}

	// 写入文件
	public static void write(String fileName, String text) {

		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File(fileName).getAbsoluteFile());
			pw.println(text);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}

	public TextFile(String fileName) {
		this(fileName, "\n");
	}

	// 分割字符串
	public TextFile(String fileName, String regex) {
		super(Arrays.asList(read(fileName).split(regex)));
		if (get(0).equals(""))
			remove(0);
	}

	public void write(String fileName) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File(fileName).getAbsoluteFile());
			for (String item : this) {
				pw.println(item);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
}
