package com.test.Nums;

/*
* 可变参数的使用
* */

public class NumsDemo {

    public static void main(String[] args){

        add(1, 3, 3, 3);
        add(1, 3, 3, 3, 1, 2, 3);
        add2("222", 1, 2, 3, 4, 5, 6);
    }

    public static void add(int...nums){
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        System.out.println(sum);
    }

    public static void add2(String s, int...nums){
        int sum = 0;
        for (int i = 0;i < nums.length; i++){
            sum += nums[i];
        }
//        System.out.println(s + "......." + sum);
        System.out.println(s + sum);
        System.out.println(s + sum + 1);
    }
}
