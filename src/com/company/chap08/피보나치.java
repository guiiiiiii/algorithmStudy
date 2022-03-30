package com.company.chap08;

import java.util.Arrays;

public class 피보나치 {
    public static void main(String[] args) {
        int n = 4;

        //System.out.println(fibonacci(4));
        System.out.println("result >> "+fibonacciWithStore(50));
    }

    // 피보나치 계산할 범위가 커지면 int로 담을수 없어서 long으로 선언
    // 그런데 99피보나치도 계산하려면 long으로는 부족
    static public long[] dict = new long[101];

    // 재귀로 피보나치
    static public long fibonacci(int n){

        if( n == 1 || n == 2 )      return 1;
        else                        return fibonacci(n-1) + fibonacci(n-2);
    }

    //재귀로 피보나치 but 결과를 저장
    static public  long fibonacciWithStore(int n){
        if( n == 1 || n == 2 )      return 1;

        if(dict[n] != 0)    return dict[n];

        dict[n] = fibonacciWithStore(n-1) + fibonacciWithStore(n-2);
        return dict[n];

    }
}
