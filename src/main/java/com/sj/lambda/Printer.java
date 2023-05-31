package com.sj.lambda;

public class Printer {
    public static void main(String[] args) {
        Printable p = (int x, int y) -> x + y;
        System.out.println(p.add(2,4));
    }
}
