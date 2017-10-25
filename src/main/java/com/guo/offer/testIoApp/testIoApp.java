package com.guo.offer.testIoApp;

import java.io.IOException;
import java.io.RandomAccessFile;

public class testIoApp {
	public static void main(String[] args) throws IOException {

		@SuppressWarnings("resource")
		RandomAccessFile file = new RandomAccessFile("C:/Users/Administrator/Desktop/test.txt", "rw");
		file.writeBoolean(true);
		file.writeInt(123456);
		file.writeInt(7890);
		file.writeLong(1000000);
		file.writeInt(777);
		file.writeFloat(.0001f);
		file.seek(5);
		System.out.println(file.readBoolean());

	}
}
