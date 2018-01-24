package com.guo.offer.interview.questions;

import java.util.ArrayList;
import java.util.Arrays;

public final class SortDemo2 {

    // 排序原始数据
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
        int length = a.length;// 数组长度，将这个提取出来是为了提高速度。
        int insertNum;// 要插入的数
        for (int i = 1; i < length; i++) {// 插入的次数
            insertNum = a[i];// 要插入的数
            int j = i - 1;// 已经排序好的序列元素个数
            while (j >= 0 && a[j] > insertNum) {// 序列从后到前循环，将大于insertNum的数向后移动一格
                a[j + 1] = a[j];// 元素移动一格
                j--;
            }
            a[j + 1] = insertNum;// 将需要插入的数放在要插入的位置。
        }
        System.out.println(Arrays.toString(a) + " insertSort");
    }

    public static void sheelSort(int[] a) {
        int d = a.length;
        while (d != 0) {
            d = d / 2;
            for (int x = 0; x < d; x++) {// 分的组数
                for (int i = x + d; i < a.length; i += d) {// 组中的元素，从第二个数开始
                    int j = i - d;// j为有序序列最后一位的位数
                    int temp = a[i];// 要插入的元素
                    for (; j >= 0 && temp < a[j]; j -= d) {// 从后往前遍历。
                        a[j + d] = a[j];// 向后移动d位
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
        for (int i = 0; i < length; i++) {// 循环次数
            int key = a[i];
            int position = i;
            for (int j = i + 1; j < length; j++) {// 选出最小的值和位置
                if (a[j] < key) {
                    key = a[j];
                    position = j;
                }
            }
            a[position] = a[i];// 交换位置
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
         *  第一步：将数组堆化
         *  beginIndex = 第一个非叶子节点。
         *  从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
         *  叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
         */
        int len = array.length - 1;
        int beginIndex = (len - 1) >> 1;
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(i, len, array);
        }
        /*
         * 第二步：对堆化数据排序
         * 每次都是移出最顶层的根节点A[0]，与最尾部节点位置调换，同时遍历长度 - 1。
         * 然后从新整理被换到根节点的末尾元素，使其符合堆的特性。
         * 直至未排序的堆长度为 0。
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
     * 调整索引为 index 处的数据，使其符合堆的特性。
     *
     * @param index 需要堆化处理的数据的索引
     * @param len 未排序的堆（数组）的长度
     */
    private static void maxHeapify(int index, int len, int[] arr) {
        int li = (index << 1) + 1; // 左子节点索引
        int ri = li + 1; // 右子节点索引
        int cMax = li; // 子节点值最大索引，默认左子节点。
        if (li > len) {
            return; // 左子节点索引超出计算范围，直接返回。
        }
        if (ri <= len && arr[ri] > arr[li]) // 先判断左右子节点，哪个较大。
        {
            cMax = ri;
        }
        if (arr[cMax] > arr[index]) {
            swap(cMax, index, arr); // 如果父节点被子节点调换，
            maxHeapify(cMax, len, arr); // 则需要继续判断换下后的父节点是否符合堆的特性。
        }
    }

    public static void quickSort(int[] array) {
        _quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array) + " quickSort");
    }

    private static int getMiddle(int[] list, int low, int high) {
        int tmp = list[low]; // 数组的第一个作为中轴
        while (low < high) {
            while (low < high && list[high] >= tmp) {
                high--;
            }

            list[low] = list[high]; // 比中轴小的记录移到低端
            while (low < high && list[low] <= tmp) {
                low++;
            }

            list[high] = list[low]; // 比中轴大的记录移到高端
        }
        list[low] = tmp; // 中轴记录到尾
        return low; // 返回中轴的位置
    }

    private static void _quickSort(int[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high); // 将list数组进行一分为二
            _quickSort(list, low, middle - 1); // 对低字表进行递归排序
            _quickSort(list, middle + 1, high); // 对高字表进行递归排序
        }
    }

    public static void mergingSort(int[] array) {
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array) + " mergingSort");
    }

    private static void sort(int[] data, int left, int right) {
        if (left < right) {
            // 找出中间索引
            int center = (left + right) / 2;
            // 对左边数组进行递归
            sort(data, left, center);
            // 对右边数组进行递归
            sort(data, center + 1, right);
            // 合并
            merge(data, left, center, right);
        }
    }

    private static void merge(int[] data, int left, int center, int right) {
        int[] tmpArr = new int[data.length];
        int mid = center + 1;
        // third记录中间数组的索引
        int third = left;
        int tmp = left;
        while (left <= center && mid <= right) {
            // 从两个数组中取出最小的放入中间数组
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }
        }

        // 剩余部分依次放入中间数组
        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }

        while (left <= center) {
            tmpArr[third++] = data[left++];
        }

        // 将中间数组中的内容复制回原数组
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }
    }

    public static void radixSort(int[] array) {
        // 首先确定排序的趟数;
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int time = 0;
        // 判断位数;
        while (max > 0) {
            max /= 10;
            time++;
        }

        // 建立10个队列;
        ArrayList<ArrayList<Integer>> queue = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> queue1 = new ArrayList<>();
            queue.add(queue1);
        }

        // 进行time次分配和收集;
        for (int i = 0; i < time; i++) {
            // 分配数组元素;
            for (int anArray : array) {
                // 得到数字的第time+1位数;
                int x = anArray % (int)Math.pow(10, i + 1) / (int)Math.pow(10, i);
                ArrayList<Integer> queue2 = queue.get(x);
                queue2.add(anArray);
                queue.set(x, queue2);
            }
            int count = 0;// 元素计数器;
            // 收集队列元素;
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
