package com.company.chap07;

import java.util.Arrays;

public class 재귀이진참색 {
    public static void main(String[] args) {
        Integer[] arr = {1, 3, 5, 7, 9,11, 13, 15, 17,19};
        int target = 7;

        int result = search(arr, target, 0, arr.length-1);
        System.out.println("결과 >>> " + result);

    }

    static public int search(Integer[] arr, int target, int start, int end){
        int medium = (start+end)/2;

        if(start > end ) return -1;
        if(arr[medium] < target){
            search(arr, target, medium+1, end);
        }else if(arr[medium] > target){
            search(arr, target, start, medium-1);
        }

        return medium;

    }
}
