package com.wode.interfaces;

import org.junit.Test;

public class TestHandler {


    public static void main(String[] args) {

    }

    @Test
    public void testAdd(){
        TestHandler ts = new TestHandler();
        ts.user(1, 2, new Handler() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        });
    }


    public  void user(int a, int b, Handler handler) {
        System.out.println(handler.operate(a, b));
    }
}
