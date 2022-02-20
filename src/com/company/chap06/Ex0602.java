package com.company.chap06;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// p.178 위에서 아래로
public class Ex0602 {
    public static void main(String[] args) {
        /***
         * 하나의 수열에는 다양한 수가 존재하고, 이 수가 크기에 상관없이 나열되어 있다
         * 이 수를 큰 수부터 작은 수의 순서로 정렬할 때 내림차순으로 정렬하는 프로그램을 만드시오
         */

        Scanner sc = new Scanner(System.in);
        System.out.println("수열에 속해있는 수의 개수 N 입력");
        int n = Integer.parseInt(sc.nextLine());

        ArrayList<Integer> array = new ArrayList<>();

        for(int i=0; i<n; i++){
            System.out.println((i+1)+"번째 수 입력");
            array.add(Integer.parseInt(sc.nextLine()));
        }

        solution(array);
        System.out.println("result >>> "+ Arrays.toString(array.toArray()));

    }

    public static ArrayList<Integer> solution(ArrayList<Integer> array){
        Collections.sort(array, Collections.reverseOrder());
        return array;
    }
}
