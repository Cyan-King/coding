package com.test.Junit01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDemo {

    @Before
    public void  testBefore(){
        System.out.println("Brfore............");
    }
    @Test
    public void testAdd1(){
        TestJunit testJunit = new TestJunit();
        testJunit.testAdd(2, 3);
    }
    @Test
    public void testAdd2(){
        TestJunit testJunit = new TestJunit();
        testJunit.testAdd(3, 3);
    }
    @Test
    public void testAdd3(){
        TestJunit testJunit = new TestJunit();
        testJunit.testAdd(4, 3);
    }
    @After
    public  void testAfter(){
        System.out.println("After........");
    }


}