package com.company.chap06;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 두 배열의 원소 교체
public class Ex0604 {
    public static void main(String[] args) {
        /****
         * 동빈이가 가지고 있는 두 배열 A와 B는 N개의 원소로 구성되어있다
         * 동빈이가 최대 K번의 바꾸기를 할 수 있는데
         * 이 때 바꾸기를 통해 A배열의 원소의 합이 최대가 되도록 만들어라
         */

        //Scanner sc = new Scanner(System.in);

        int n = 5;
        int k = 3;

        Integer[] arrA = {1, 2, 5, 4, 3};
        Integer[] arrB = {5, 5, 6, 6, 5};

        // A는 오름차순으로, B는 내림차순으로 정렬
        Arrays.sort(arrA);
        Arrays.sort(arrB, Collections.reverseOrder());

        for(int index = 0; index < k; index++){
            if(arrA[index] < arrB[index]){
                int tempVal = arrB[index];

                arrB[index] = arrA[index];
                arrA[index] = tempVal;
            }
        }

        int sum = 0;

        for(int i : arrA){
            sum += i;
        }

        System.out.println("result >>> "+sum);
    }
}
