package com.company.chap15;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class Ex27정렬된배열에서특정수의개수구하기 {
    public static void main(String[] args) {
        int n =  7;
        int x = 4;
        String numStr= "1 1 2 2 2 2 3";

        // Step1. 주어진 문자열을 쪼개어 Treemap 세팅
        SortedMap<Integer, Integer> map = new TreeMap<>();
        Arrays.stream(numStr.split(" ")).mapToInt(Integer::parseInt).forEach( i -> {
            map.put(i, map.getOrDefault(i,0)+1);
        });

        // Step2. map에 key가 존재하면 그 값을 print
        if(map.keySet().contains(x))        System.out.println(map.get(x));
        else                                System.out.println(-1);
    }
}
