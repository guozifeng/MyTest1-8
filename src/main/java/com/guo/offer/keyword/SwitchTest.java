package com.guo.offer.keyword;

/**
 * switch��ִ���ǰ��մ�С�����˳��ִ�еģ����ִ��default��䣬 ���default�������break����ô����ͻ���������switch������
 * �����������ִ��switch��䣡Ҳ����˵������default����ʲô λ�ã������������һ��������Ȼ��������´�����
 * ���ԣ����Ĵ����취�������������������ð취����ÿһ��case �Լ�default��䶼Ҫ��һ��break!
 * 
 * @author Administrator
 *
 */
public class SwitchTest {
    static final short a = 0;
    public static int b =10;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String c = "a"; // char�����ַ�
		switch (c) {
		default:
			System.out.println("��ӡĬ��ֵ");
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
	
	public void test1(){
	    short aa =0;
	    switch(a){

            case a+11 : System.out.println(" A ");

	        case 2 : System.out.println(" B ");

	        case 3 : System.out.println(" C ");

	        case 4 : System.out.println(" D ");

	        default : System.out.println(" default ");

	        }
	}

}