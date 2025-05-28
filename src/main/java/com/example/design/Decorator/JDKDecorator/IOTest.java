package com.example.design.Decorator.JDKDecorator;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class IOTest {
 
	public static void main(String[] args) throws IOException {
		// 流式读取文件
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new BufferedInputStream(new FileInputStream("/Users/zhaopengfei/Downloads/test.txt")));
			// 读取文件内容
			byte[] bs = new byte[dis.available()];
			dis.read(bs);
			String content = new String(bs);
			System.out.println(content);
		} finally {
			dis.close();
		}
	}
}