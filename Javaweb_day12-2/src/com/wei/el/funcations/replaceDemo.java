package com.wei.el.funcations;

import java.util.Arrays;

public class replaceDemo {
    public static void main(String[] args){
        String[] arr = {"a", "b", "c"};

        String s = Arrays.toString(arr);

        String replace = s.replace("a", "p");

        System.out.println(replace);

    }
}
