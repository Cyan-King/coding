package com.test.EnumDemo;

public class EnumColor1 {

//    private int color;
    private Color2 color2;
    private Color3 color3;

    public EnumColor1(){
//        this.color = Color1.RED;
//        this.color2 = Color2.RED;
        this.color3 = Color3.GREEN;
    }
}

class Color1{
    public  static  final  int RED = 1;
    public  static  final  int GREEN = 1;
    public  static  final  int YELLOW = 1;
}

//构造函数私有化
class  Color2{
    private  Color2(){}
    public static final Color2 RED = new Color2();
    public static final Color2 GREEN = new Color2();
    public static final Color2 YELLOW = new Color2();
}

enum  Color3{
    RED, GREEN, YELLOW;
}


