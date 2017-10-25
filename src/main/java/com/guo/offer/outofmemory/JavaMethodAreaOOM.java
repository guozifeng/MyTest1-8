package com.guo.offer.outofmemory;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * VM Args£º -XX:PermSize=10M -XX:MaxPermSize=10M
 * 
 * @author zzm
 */
public class JavaMethodAreaOOM {

	public static void test() {
		boolean flag = true;
		while (flag) {
			try {
				Enhancer enhancer = new Enhancer();
				enhancer.setSuperclass(OOMObject.class);
				enhancer.setUseCache(false);
				enhancer.setCallback(new MethodInterceptor() {
					@Override
					public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
							throws Throwable {
						return proxy.invokeSuper(obj, args);
					}
				});
				enhancer.create();
			} catch (Exception e) {
				e.printStackTrace();
				flag = false;
			} catch (Throwable e) {
				e.printStackTrace();
				flag = false;
			}

		}
	}

	public static void main(String[] args){
		test();
	}

	static class OOMObject {

	}
}
