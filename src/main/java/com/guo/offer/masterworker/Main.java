package com.guo.offer.masterworker;

import java.util.Map;
import java.util.Set;

/**
 * @author Administrator
 * @date 2018/03/22
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // �̶�ʹ��5��Worker����ָ��Worker
        Master m = new Master(new PlusWorker(), 5);
        // �ύ100��������
        for (int i = 0; i < 100; i++) {
            m.submit(i);
        }
        // ��ʼ����
        m.execute();
        int re = 0;
        // �������ս�����
        Map<String, Object> resultMap = m.getResultMap();

        // ����Ҫ�ȴ�����Worker��ִ����ɣ����ɿ�ʼ�������ս��
        while (resultMap.size() > 0 || !m.isComplete()) {
            Set<String> keys = resultMap.keySet();
            String key = null;
            for (String k : keys) {
                key = k;
                break;
            }
            Integer i = null;
            if (key != null) {
                i = (Integer)resultMap.get(key);
            }
            if (i != null) {
                // ���ս��
                re += i;
            }
            if (key != null) {
                // �Ƴ��Ѿ������������
                resultMap.remove(key);
            }

        }

    }

}
