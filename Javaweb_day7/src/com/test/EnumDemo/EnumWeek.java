package com.test.EnumDemo;

public class EnumWeek {

    public static void main(String[] args){

//        TestMethod3();

        Test1 test1 = new Test1();
        test1.Test1();

    }

    //知道下标获取对象和名称
    private static void TestMethod3() {
        int idx = 4;

        //获取对象
        Week1[] values = Week1.values();
        //获取名称
        String name = values[4].name();
        System.out.println(name);

    }

    //知道名称获取下标和对象
    private static void TestMethod2() {

        String weekName = "Tue";

        //获取对象
        Week1 week1 = Week1.valueOf(weekName);
        //获取下标
        int ordinal = week1.ordinal();
        System.out.println(ordinal);

    }

    //知道对象获取下标和名称
    private static void TestMethod1() {
        Week1 week = Week1.Mon;

        //使用枚举中的抽象方法
        Week1.Mon.Print1();

        //得到枚举下标
        int oFri = Week1.Fri.ordinal();
        System.out.println(oFri);

        //的到枚举名称
        String StaName = Week1.Sat.name();
        System.out.println(StaName);
    }

}

enum Week1{
    Mon("Monday"){
        public void Print1(){
            System.out.println("Monday-----今天是周一");
        }
    },Tue("TuesDay"){
        public void Print1(){
            System.out.println("TuesDay-----今天是周二");
        }
    },Wed("WednesDay"){
        public void Print1(){
            System.out.println("WednesDay-----今天是周三");
        }
    },Thu("ThuesDay"){
        public void Print1(){
            System.out.println("ThuesDay-----今天是周四");
        }
    },Fri("FriDay"){
        public void Print1(){
            System.out.println("FriDay-----今天是周五");
        }
    },Sat("SaturDay"){
        public void Print1(){
            System.out.println("SaturDay-----今天是周六");
        }
    },Sun("Sunday"){
        public void Print1(){
            System.out.println("Sunday-----今天是星期天");
        }
    };
    //枚举构造方法---一定要是私有的
    private  String weekName;
    private Week1(String weekName){}

    //枚举的抽象方法，一定要实现每一个方法
    public abstract void Print1();
}

//自动拆箱和装箱
class Test1{
    Integer i = 10;
    int m = i;

    public void Test1(){
        System.out.println(m);
    }
}
