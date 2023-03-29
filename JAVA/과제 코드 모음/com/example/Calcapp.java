package com.example;

import com.example.logic.CalcLogic;

public class Calcapp {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        int total = CalcLogic.add(a, b);
        int delta = CalcLogic.substract(a, b);
        System.out.println(total);
        System.out.println(delta);
    }
}
