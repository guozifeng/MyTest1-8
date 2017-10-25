package com.guo.offer.outofmemory;

import java.io.File;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * -XX:PermSize=8M -XX:MaxPermSize=8M -XX:+HeapDumpOnOutOfMemoryError 
 * -verbose:gc -XX:+PrintGCDetails  -XX:+PrintGCDateStamps
 * @author Administrator
 *
 */
public class PermGenOomMock {
	public static void main(String[] args) {
		URL url = null;
		List<ClassLoader> classLoaderList = new ArrayList<ClassLoader>();
		try {
			url = new File("C:\\Users\\Administrator\\workspace1.7\\Mytest1.7\\bin").toURI().toURL();
			URL[] urls = { url };
			Boolean flag = true;
			int i = 0;
			while (flag) {
				try{
					ClassLoadingMXBean loadingBean = ManagementFactory.getClassLoadingMXBean();  
					ClassLoader loader = new URLClassLoader(urls);
					classLoaderList.add(loader);
					loader.loadClass("com.guo.offer.outofmemory.StringOomMock");
					
				} catch (Throwable e) {
					e.printStackTrace();
					flag = false;
					System.out.println(" count=" + i);// 记录运行的次数
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
