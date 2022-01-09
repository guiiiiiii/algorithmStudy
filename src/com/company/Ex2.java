package com.company;

import java.util.*;

public class Ex2 {

    public static void main(String[] args) {
        SortedMap<Integer, Integer> testmap = new TreeMap<>();

        int[] arr = {2, 3, 1, 2, 2};

        for(int i=0; i<arr.length; i++){
           testmap.put(arr[i], testmap.getOrDefault(arr[i],0)+1);
        }


        System.out.println(testmap.keySet());

    }

    public static int recursiveTest(int num, int total, int cnt){
        if(total != num) recursiveTest(num,total/num, cnt++);

        return cnt+1;
    }
}
