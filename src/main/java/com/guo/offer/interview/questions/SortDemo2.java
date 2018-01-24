package com.guo.offer.interview.questions;

import java.util.ArrayList;
import java.util.Arrays;

public final class SortDemo2 {

    // ����ԭʼ����
    private static final int[] NUMBERS
        = {49, 38, 65, 97, 76, 13, 27, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

    public static void main(String[] args) {
        insertSort(NUMBERS);
        shellSort(NUMBERS);
        selectSort(NUMBERS);
        bubbleSort(NUMBERS);
        heapSort(NUMBERS);
        quickSort(NUMBERS);
        mergingSort(NUMBERS);
        radixSort(NUMBERS);
    }

    public static void insertSort(int[] a) {
        int length = a.length;// ���鳤�ȣ��������ȡ������Ϊ������ٶȡ�
        int insertNum;// Ҫ�������
        for (int i = 1; i < length; i++) {// ����Ĵ���
            insertNum = a[i];// Ҫ�������
            int j = i - 1;// �Ѿ�����õ�����Ԫ�ظ���
            while (j >= 0 && a[j] > insertNum) {// ���дӺ�ǰѭ����������insertNum��������ƶ�һ��
                a[j + 1] = a[j];// Ԫ���ƶ�һ��
                j--;
            }
            a[j + 1] = insertNum;// ����Ҫ�����������Ҫ�����λ�á�
        }
        System.out.println(Arrays.toString(a) + " insertSort");
    }

    public static void sheelSort(int[] a) {
        int d = a.length;
        while (d != 0) {
            d = d / 2;
            for (int x = 0; x < d; x++) {// �ֵ�����
                for (int i = x + d; i < a.length; i += d) {// ���е�Ԫ�أ��ӵڶ�������ʼ
                    int j = i - d;// jΪ�����������һλ��λ��
                    int temp = a[i];// Ҫ�����Ԫ��
                    for (; j >= 0 && temp < a[j]; j -= d) {// �Ӻ���ǰ������
                        a[j + d] = a[j];// ����ƶ�dλ
                    }
                    a[j + d] = temp;
                }
            }
        }
    }

    public static void shellSort(int[] array) {
        int i;
        int j;
        int temp;
        int gap = 1;
        int len = array.length;
        while (gap < len / 3) {
            gap = gap * 3 + 1;
        }
        for (; gap > 0; gap /= 3) {
            for (i = gap; i < len; i++) {
                temp = array[i];
                for (j = i - gap; j >= 0 && array[j] > temp; j -= gap) {
                    array[j + gap] = array[j];
                }
                array[j + gap] = temp;
            }
        }
        System.out.println(Arrays.toString(array) + " shellSort");
    }

    public void selectSort1(int[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {// ѭ������
            int key = a[i];
            int position = i;
            for (int j = i + 1; j < length; j++) {// ѡ����С��ֵ��λ��
                if (a[j] < key) {
                    key = a[j];
                    position = j;
                }
            }
            a[position] = a[i];// ����λ��
            a[i] = key;
        }
        System.out.println(Arrays.toString(a) + " selectSort1");
    }

    public static void selectSort(int[] array) {
        int position = 0;
        for (int i = 0; i < array.length; i++) {
            int j = i + 1;
            position = i;
            int temp = array[i];
            for (; j < array.length; j++) {
                if (array[j] < temp) {
                    temp = array[j];
                    position = j;
                }
            }
            array[position] = array[i];
            array[i] = temp;
        }
        System.out.println(Arrays.toString(array) + " selectSort");
    }

    public static void bubbleSort(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array) + " bubbleSort");
    }

    public static void heapSort(int[] array) {
        /*
         *  ��һ����������ѻ�
         *  beginIndex = ��һ����Ҷ�ӽڵ㡣
         *  �ӵ�һ����Ҷ�ӽڵ㿪ʼ���ɡ���������һ��Ҷ�ӽڵ㿪ʼ��
         *  Ҷ�ӽڵ���Կ����ѷ��϶�Ҫ��Ľڵ㣬���ڵ�������Լ����Լ�����ֵΪ���
         */
        int len = array.length - 1;
        int beginIndex = (len - 1) >> 1;
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(i, len, array);
        }
        /*
         * �ڶ������Զѻ���������
         * ÿ�ζ����Ƴ����ĸ��ڵ�A[0]������β���ڵ�λ�õ�����ͬʱ�������� - 1��
         * Ȼ����������������ڵ��ĩβԪ�أ�ʹ����϶ѵ����ԡ�
         * ֱ��δ����Ķѳ���Ϊ 0��
         */
        for (int i = len; i > 0; i--) {
            swap(0, i, array);
            maxHeapify(0, i - 1, array);
        }
        System.out.println(Arrays.toString(array) + " heapSort");
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * ��������Ϊ index �������ݣ�ʹ����϶ѵ����ԡ�
     *
     * @param index ��Ҫ�ѻ���������ݵ�����
     * @param len δ����Ķѣ����飩�ĳ���
     */
    private static void maxHeapify(int index, int len, int[] arr) {
        int li = (index << 1) + 1; // ���ӽڵ�����
        int ri = li + 1; // ���ӽڵ�����
        int cMax = li; // �ӽڵ�ֵ���������Ĭ�����ӽڵ㡣
        if (li > len) {
            return; // ���ӽڵ������������㷶Χ��ֱ�ӷ��ء�
        }
        if (ri <= len && arr[ri] > arr[li]) // ���ж������ӽڵ㣬�ĸ��ϴ�
        {
            cMax = ri;
        }
        if (arr[cMax] > arr[index]) {
            swap(cMax, index, arr); // ������ڵ㱻�ӽڵ������
            maxHeapify(cMax, len, arr); // ����Ҫ�����жϻ��º�ĸ��ڵ��Ƿ���϶ѵ����ԡ�
        }
    }

    public static void quickSort(int[] array) {
        _quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array) + " quickSort");
    }

    private static int getMiddle(int[] list, int low, int high) {
        int tmp = list[low]; // ����ĵ�һ����Ϊ����
        while (low < high) {
            while (low < high && list[high] >= tmp) {
                high--;
            }

            list[low] = list[high]; // ������С�ļ�¼�Ƶ��Ͷ�
            while (low < high && list[low] <= tmp) {
                low++;
            }

            list[high] = list[low]; // �������ļ�¼�Ƶ��߶�
        }
        list[low] = tmp; // �����¼��β
        return low; // ���������λ��
    }

    private static void _quickSort(int[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high); // ��list�������һ��Ϊ��
            _quickSort(list, low, middle - 1); // �Ե��ֱ���еݹ�����
            _quickSort(list, middle + 1, high); // �Ը��ֱ���еݹ�����
        }
    }

    public static void mergingSort(int[] array) {
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array) + " mergingSort");
    }

    private static void sort(int[] data, int left, int right) {
        if (left < right) {
            // �ҳ��м�����
            int center = (left + right) / 2;
            // �����������еݹ�
            sort(data, left, center);
            // ���ұ�������еݹ�
            sort(data, center + 1, right);
            // �ϲ�
            merge(data, left, center, right);
        }
    }

    private static void merge(int[] data, int left, int center, int right) {
        int[] tmpArr = new int[data.length];
        int mid = center + 1;
        // third��¼�м����������
        int third = left;
        int tmp = left;
        while (left <= center && mid <= right) {
            // ������������ȡ����С�ķ����м�����
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }
        }

        // ʣ�ಿ�����η����м�����
        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }

        while (left <= center) {
            tmpArr[third++] = data[left++];
        }

        // ���м������е����ݸ��ƻ�ԭ����
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }
    }

    public static void radixSort(int[] array) {
        // ����ȷ�����������;
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int time = 0;
        // �ж�λ��;
        while (max > 0) {
            max /= 10;
            time++;
        }

        // ����10������;
        ArrayList<ArrayList<Integer>> queue = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> queue1 = new ArrayList<>();
            queue.add(queue1);
        }

        // ����time�η�����ռ�;
        for (int i = 0; i < time; i++) {
            // ��������Ԫ��;
            for (int anArray : array) {
                // �õ����ֵĵ�time+1λ��;
                int x = anArray % (int)Math.pow(10, i + 1) / (int)Math.pow(10, i);
                ArrayList<Integer> queue2 = queue.get(x);
                queue2.add(anArray);
                queue.set(x, queue2);
            }
            int count = 0;// Ԫ�ؼ�����;
            // �ռ�����Ԫ��;
            for (int k = 0; k < 10; k++) {
                while (queue.get(k).size() > 0) {
                    ArrayList<Integer> queue3 = queue.get(k);
                    array[count] = queue3.get(0);
                    queue3.remove(0);
                    count++;
                }
            }
        }
        System.out.println(Arrays.toString(array) + " radixSort");
    }
}
