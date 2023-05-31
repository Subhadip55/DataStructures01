package com.sj.app;

import java.util.HashSet;
import java.util.Set;

public class PrintCombinationOfNumbers {
    public static void main(String[] args) {
        Set<Integer> horizontalChecker = new HashSet<>();

        Set<Integer> verticalChecker_pos1 = new HashSet<>();
        Set<Integer> verticalChecker_pos2 = new HashSet<>();
        Set<Integer> verticalChecker_pos3 = new HashSet<>();
        Set<Integer> verticalChecker_pos4 = new HashSet<>();

        int lowerBound = 1, upperBound = 100;

        int count = 0;

//        Approach 1

        for (int value_1 = lowerBound; value_1 <= upperBound; value_1++) {

            horizontalChecker.add(value_1);
            verticalChecker_pos1.add(value_1);

            for (int value_2 = lowerBound; value_2 <= upperBound; value_2++) {
                if (!horizontalChecker.contains(value_2) && !verticalChecker_pos2.contains(value_2)) {
                    horizontalChecker.add(value_2);

                    for (int value_3 = lowerBound; value_3 <= upperBound; value_3++) {
                        if (!horizontalChecker.contains(value_3) && !verticalChecker_pos3.contains(value_3)) {
                            horizontalChecker.add(value_3);

                            for (int value_4 = lowerBound; value_4 <= upperBound; value_4++) {
                                if (!horizontalChecker.contains(value_4) && !verticalChecker_pos4.contains(value_4)) {

                                    System.out.println(value_1 + "-" + value_2 + "-" + value_3 + "-" + value_4);

                                    verticalChecker_pos2.add(value_2);
                                    verticalChecker_pos3.add(value_3);
                                    verticalChecker_pos4.add(value_4);

                                    count++;
                                    break;
                                }
                            }
                            horizontalChecker.remove(value_3);
                            break;
                        }
                    }
                    horizontalChecker.remove(value_2);
                    break;
                }
            }
            horizontalChecker.remove(value_1);
        }
        System.out.println("\nOutput Count = " + count);

////          Approach 2 : try to print same as the output is given
//        for(int i = lowerBound; i <= upperBound; i += 4) {
//            System.out.println(i + "-" + (i+1) + "-" + (i+2) + "-" + (i+3));
////            verticalChecker_pos1.add(i);
//            verticalChecker_pos2.add(i+1);
//            verticalChecker_pos3.add(i+2);
//            verticalChecker_pos4.add(i+3);
//            count++;
//        }
//        for (int value_1 = lowerBound; value_1 <= upperBound; value_1++) {
//
//            horizontalChecker.add(value_1);
//            verticalChecker_pos1.add(value_1);
//
//            for (int value_2 = lowerBound; value_2 <= upperBound; value_2++) {
//                if (!horizontalChecker.contains(value_2) && !verticalChecker_pos2.contains(value_2)) {
//                    horizontalChecker.add(value_2);
//
//                    for (int value_3 = lowerBound; value_3 <= upperBound; value_3++) {
//                        if (!horizontalChecker.contains(value_3) && !verticalChecker_pos3.contains(value_3)) {
//                            horizontalChecker.add(value_3);
//
//                            for (int value_4 = lowerBound; value_4 <= upperBound; value_4++) {
//                                if (!horizontalChecker.contains(value_4) && !verticalChecker_pos4.contains(value_4)) {
//
//                                    System.out.println(value_1 + "-" + value_2 + "-" + value_3 + "-" + value_4);
//
//                                    verticalChecker_pos2.add(value_2);
//                                    verticalChecker_pos3.add(value_3);
//                                    verticalChecker_pos4.add(value_4);
//
//                                    count++;
//                                    break;
//                                }
//                            }
//                            horizontalChecker.remove(value_3);
//                            break;
//                        }
//                    }
//                    horizontalChecker.remove(value_2);
////                    break;
//                }
//            }
//            horizontalChecker.remove(value_1);
//        }
//        System.out.println("Output count = " + count);


        // another approach
        /*
        int count = 0;
        int lowerBound = 1, upperBound = 100, no_of_sets = 4;
        for(int i = no_of_sets; i<= upperBound; i += no_of_sets) {
            System.out.println((i-3) + "-" + (i-2) + "-" + (i-1) + "-" + i);
            count++;
        }
        for (int i = lowerBound; i <= upperBound; i += (no_of_sets * no_of_sets)) {
            for(int j = i; j <  i + no_of_sets && (j + 3 * no_of_sets) <= 100; j++) {
                System.out.println(j + "-" + (j + no_of_sets) + "-" + ((j + 2 * no_of_sets)) + "-" + (j + 3 * no_of_sets));
                count++;
            }
        }
        System.out.println("Output count = " + count);

         */
    }
}
