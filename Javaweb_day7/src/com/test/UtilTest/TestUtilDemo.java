package com.test.UtilTest;

import java.util.Arrays;

/*
 *
 * 颠倒数组中所有的元素
 * */
public class TestUtilDemo {
    public static void main(String[] args) {

        Integer[] arr = {1, 2, 3, 4, 5, 6, 7,};
        reverses(arr);
        System.out.println(Arrays.toString(arr));
        String[] arr2 = {"赵一", "钱二", "孙三", "李四", "周五", "吴六", "郑七",};
        reverses(arr2);
        System.out.println(Arrays.toString(arr2));


    }

    private static <T> void swap(T[] arr) {
        T temp;
        //进行颠倒操作
        //arr.length-1:我们要得到end的角标就是因为长度的话是从直接从一开始，而角标是从0开始，所以我们要arr.length-1
        for (int start = 0, end = arr.length - 1; start < end; start++, end--) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }

    }

    private  static <T> void reverses(T[] arr){

        for (int i = 0; i < arr.length/2; i++){
            T temp = arr[i];
            //arr.length-i-1:就是第一个角标和最后一个交换，第二个和倒数第二个角标交换
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }

    }
}
