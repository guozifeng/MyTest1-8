package com.guo.offer.testmath;

import java.math.BigDecimal;

public class TestBigDecimal {
    // Ĭ�ϳ������㾫��
    private static final int DEF_SCALE = 10;

    // ����಻��ʵ����
    private TestBigDecimal() {}

    public static void main(String[] args) {

        System.out.println(0.02 + 0.01);
        System.out.println(0.05 + 0.01);

        System.out.println(new BigDecimal(Double.valueOf(0.09)));
        System.out.println(new BigDecimal(0.06).toString());
        System.out.println(new BigDecimal("0.06").doubleValue());
        System.out.println(new BigDecimal("0.06"));
        BigDecimal cc = new BigDecimal("0.00");
        BigDecimal bb = new BigDecimal("10.00");
        BigDecimal aa = new BigDecimal("110.00");

        bb = bb.add(aa);
        System.out.println(aa);
        System.out.println(bb);
        System.out.println(cc);
    }

    /**
     * �ṩ��ȷ�ļӷ����㡣
     * 
     * @param v1 ������
     * @param v2 ����
     * @return ���������ĺ�
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * �ṩ��ȷ�ļ������㡣
     * 
     * @param v1 ������
     * @param v2 ����
     * @return ���������Ĳ�
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * �ṩ��ȷ�ĳ˷����㡣
     * 
     * @param v1 ������
     * @param v2 ����
     * @return ���������Ļ�
     */
    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * �ṩ����ԣ���ȷ�ĳ������㣬�����������������ʱ����ȷ�� С�����Ժ�10λ���Ժ�������������롣
     * 
     * @param v1 ������
     * @param v2 ����
     * @return ������������
     */
    public static double div(double v1, double v2) {
        return div(v1, v2, DEF_SCALE);
    }

    /**
     * �ṩ����ԣ���ȷ�ĳ������㡣�����������������ʱ����scale����ָ �����ȣ��Ժ�������������롣
     * 
     * @param v1 ������
     * @param v2 ����
     * @param scale ��ʾ��ʾ��Ҫ��ȷ��С�����Ժ�λ��
     * @return ������������
     */
    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * �ṩ��ȷ��С��λ�������봦��
     * 
     * @param v ��Ҫ�������������
     * @param scale С���������λ
     * @return ���������Ľ��
     */
    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}