package com.sj.lambda;

import java.util.Arrays;

public class AnonymousDemo {
    public static void main(String[] args) {
        Invisible i = new Invisible() {
            @Override
            public void hideOne(int a) {
                System.out.println(a + " is hidden.");
            }

            @Override
            public int[] hideTwo(int a, int b) {
                int[] number = {a, b};
                return number;
            }
        };
        i.hideOne(90);
        System.out.println("The following numbers are hidden "+ Arrays.toString(i.hideTwo(23, 45)));
    }
}
