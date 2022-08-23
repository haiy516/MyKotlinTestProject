package com.example.javatest.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainTest {
    public static void main(String[] args) throws Exception {
        Class<? extends Apple> mClass = Apple.class;
        Apple apple = mClass.getConstructor().newInstance();
        Method setPrice = mClass.getMethod("setPrice", int.class);
        setPrice.invoke(apple,14);
        Method getPrice = mClass.getMethod("getPrice");
        int price = (int) getPrice.invoke(apple);
        System.out.println(price);
        System.out.println("======");
        Method printString = mClass.getDeclaredMethod("printString", String.class);
        printString.setAccessible(true);
        printString.invoke(apple,"apple");
        System.out.println("======");
        for (Field field : mClass.getDeclaredFields()) {
            System.out.println(field.getName());
        }
    }
}
