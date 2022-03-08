package com.company.chap07;

import java.util.Arrays;

public class 부품찾기with계수정렬 {
    public static void main(String[] args) {
        int n = 5;
        String str_n = "8 3 7 9 2";
        int m = 3;
        String str_m = "5 7 9";

        // Step1. 물건배열을 담을 계수배열 생성
        Integer[] stock = new Integer[11];

        Arrays.fill(stock,0);

        Arrays.stream(str_n.split(" ")).forEach((String str) -> {
            stock[Integer.parseInt(str)] = 1;
        });

        System.out.println(Arrays.toString(stock));

        Arrays.stream(str_m.split(" ")).forEach((String customer) -> {
            if(stock[Integer.parseInt(customer)] == 1)    System.out.print("yes ");
            else                                            System.out.print("no ");
        });
    }
}
