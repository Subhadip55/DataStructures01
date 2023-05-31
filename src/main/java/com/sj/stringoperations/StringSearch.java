package com.sj.stringoperations;

import java.util.*;

public class StringSearch {
    /*
    * This method is also known as Naive String Search Algorithm
    * O(n+m) -> Average case
    * O(nm) -> Best case
    * */
    public List<Integer> linearSearch(String input_string, String key) {
        int no_of_comparisons = 0;
        List<Integer> indexList = new ArrayList<>();
        for(int i = 0; i <= input_string.length() - key.length(); i++) {
            String temp_string = "";
            no_of_comparisons++;
            if(input_string.charAt(i) == key.charAt(0)) {
                temp_string = input_string.substring(i, i + key.length());
                no_of_comparisons++;
                if (temp_string.equals(key)) {
                    indexList.add(i);
                    i += key.length() - 1;
                }
            }

        }
        System.out.println("No of comparisons : "+ no_of_comparisons);
        return indexList;
    }

    /*
    * Boyer-Moore-Horspool String searching
    * Bad match table
    *  find and replace
    *
    * O(n) average performance
    * O(nm) worst case performance
    * The larger the bad match table the better the performance
    * */
    private Map<String, Integer> table;
    public List<Integer> bmhStringSearch(String line, String pattern) {
        // we are trying to search the pattern in line.

        String[] pattern_array = pattern.split("");
        table = new HashMap<String, Integer>();

        // make the table
        for(int i = 0; i < pattern_array.length; i++) {
            table.put(pattern_array[i], pattern_array.length - i - 1);
        }

//        Set s = table.entrySet();
//        Iterator itr = s.iterator();
//        while(itr.hasNext()) {
//            System.out.println(itr.next());
//        }

        String[] line_array = line.split("");
        List<Integer> list = new ArrayList<>();

        // loop for checking pattern in line array
        int i = pattern_array.length - 1;   // index for line_array elements
        int index = i;
        do {
            if(table.containsKey(line_array[i])) {  // check whether that ith element is present in table or not

                int j = i;  // loop counter for line_array
                int k = pattern_array.length - 1;   // loop counter for pattern_array

                // when i matches with the end of the pattern
                if(line_array[i].equals(pattern_array[k])) {
                    // we have to traverse backwards in line as well as pattern array
                    // so that elements are matching or not
                    while(j >= 0 && k >= 0) {   // this loop goes backwards
//                        j --> loop counter for line_array
//                        k --> loop counter for pattern_array

                        try {
                            // when j and kth element are not matching
                            if (!line_array[j].equals(pattern_array[k])) {
                                i += table.get(j);
                                break;
                            }
                            else { // when both elements are matching
//                                decrease them both by one
                                j--;
                                k--;
                            }
                        }
                        catch(ArrayIndexOutOfBoundsException e) {
//                            In case any error regarding array index out ob bound
                            e.printStackTrace();
                            break;
                        }
                    }
                    if (k < 0) {
                        // when while loop executes completely means k = -1
                        // that means patterns matches / found
                        list.add(j+1);  // storing the starting index of found pattern
                        i += pattern_array.length; // update i by incrementing by pattern's length
                        continue;
                    }
                }
//                if ith element of line_array does not match the last element of pattern_array though the item is present in the table
//                then we have to shift the loop counter i.e. i by the value of table, where key is ith item in line_array
                else {
                    i += table.get(line_array[i]);      // shift the i by the value of the table
                }
            }
            // when item does not exist in table
            else {
                i += pattern_array.length;  // update i by incrementing by pattern's length
            }
        } while (i <= line_array.length);

        return list;
    }
}
