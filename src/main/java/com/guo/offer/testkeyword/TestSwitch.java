package com.guo.offer.testkeyword;

/**
 * switch的执行是按照从小到大的顺序执行的，最后执行default语句， 如果default后面带有break，那么程序就会正常跳出switch，否则，
 * 程序会继续向后执行switch语句！也就是说，不管default放在什么 位置，它总是在最后一个处理，然后继续向下处理！
 * 所以，最后的处理办法，避免出现以外结果的最好办法就是每一个case 以及default语句都要加一个break!
 * 
 * @author Administrator
 *
 */
public class TestSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String c = "a"; // char类型字符
		switch (c) {
		default:
			System.out.println("打印默认值");
			// break;
		case "a":
			System.out.println("a");
			break;
		case "b":
			System.out.println('b');
			break;
		case "c":
			System.out.println('c');
			break;
		case "d":
			System.out.println("d");
			break;

		}

		int cc = 4;
		int j = 1;
		switch (cc) {

		case 1:
			j++;
		case 2:
			j++;
		case 3:
			j++;
		case 4:
			j++;
		case 5:
			j++;
		default:
			j++;

		}
		System.out.println(cc + j);
	}

}
