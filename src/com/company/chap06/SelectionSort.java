package com.company.chap06;

import java.util.Arrays;

// 선택정렬 구현
public class SelectionSort {
    public static void main(String[] args) {
        Integer[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for(int index = 0; index < array.length-1; index++){
            int min = index;

            for(int compare = index+1 ; compare < array.length; compare++){
                // 현재 범위에서 가장 작은 인덱스가 어디에 있는지 check
                if(array[compare] < array[min]) min = compare;

            }

            //현재 index와 가장 작은수가 있는 index를 교환

            int tempVal = array[min];
            array[min] = array[index];
            array[index] = tempVal;
        }


        System.out.println(Arrays.toString(array));
    }
}
