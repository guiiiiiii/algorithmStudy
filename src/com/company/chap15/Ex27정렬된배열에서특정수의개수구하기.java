package com.company.chap15;

import java.util.*;

public class Ex27정렬된배열에서특정수의개수구하기 {
    public static void main(String[] args) {
        int n =  10;
        int x = 3;
        String numStr= "1 1 2 2 2 2 3 3 4 4";

        // 내가 한 풀이 (이진탐색 직접구현X)
        solution(numStr,x, n);

        // 풀이에서 제시한 풀이(이진탐색 사용)
        solutionWithAnswer(numStr,x, n);
    }

    static public void solution(String numStr, int x, int n){
        // Step1. 주어진 문자열을 쪼개어 Treemap 세팅
        SortedMap<Integer, Integer> map = new TreeMap<>();
        Arrays.stream(numStr.split(" ")).mapToInt(Integer::parseInt).forEach( i -> {
            map.put(i, map.getOrDefault(i,0)+1);
        });

        // Step2. map에 key가 존재하면 그 값을 print
        if(map.keySet().contains(x))        System.out.println(map.get(x));
        else                                System.out.println(-1);

    }

    static public void solutionWithAnswer(String numStr, int x, int n){
        Integer[] numArr = Arrays.stream(numStr.split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

        int startIndex = searchLowerIndex(numArr, 0, numArr.length-1, x);
        int endIndex = searchUpperIndex(numArr, 0, numArr.length-1, x);

        if(( endIndex-startIndex) < 0)  System.out.println(-1);
        else                            System.out.println(endIndex-startIndex+1);

    }

    static public int searchLowerIndex(Integer[] numArr, int start, int end, int target){
        int mid = (start+end)/2;

        if(start > end)             return start;

        if(numArr[mid] >= target)   return searchLowerIndex(numArr, start, mid-1, target);
        else                        return searchLowerIndex(numArr,mid+1, end, target);

    }

    static public int searchUpperIndex(Integer[] numArr, int start, int end, int target){
        int mid = (start+end)/2;

        if(start > end)             return end;

        if(numArr[mid] <= target)   return searchUpperIndex(numArr, mid+1, end, target);
        else                        return searchUpperIndex(numArr, start, mid-1, target);

    }
}
