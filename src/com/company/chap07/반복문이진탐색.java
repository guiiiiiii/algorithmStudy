package com.company.chap07;

public class 반복문이진탐색 {
    public static void main(String[] args) {
        Integer[] arr = {1, 3, 5, 7, 9,11, 13, 15, 17,19};
        int target = 4;

        int start = 0;
        int end = arr.length-1;
        int medium = end;

        while(true){
            if(start>end){
                medium = -1;
                break;
            }
            medium = (start+end)/2;

            if(arr[medium] < target){
                start = medium+1;
            }else if(arr[medium] > target){
                end= medium -1;
            }else{
                break;
            }
        }

        System.out.println("결과값은 >> "+ medium);
    }
}
