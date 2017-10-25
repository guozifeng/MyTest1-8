package com.guo.offer.testIoApp;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class a {

	public a() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		RandomAccessFile r = new RandomAccessFile("heihei.txt", "rw");

		r.writeChar('a');
		r.writeChar('b');
		r.writeChar('c');
		// 这样文件的内容不就应该是abc了吗?

		r.seek(2); // 指针设置在a后.
		r.writeChar('d'); // 文件理应变成adbc,但貌似不是这么回事,如下

		StringBuffer strBuf = new StringBuffer();
		r.seek(0); // 指针归回初始位置
		strBuf.append(r.readChar());
		strBuf.append(r.readChar());
		strBuf.append(r.readChar());
		// strBuf.append(r.readChar());

		System.out.println(strBuf); // 结果是adc
	}

}
