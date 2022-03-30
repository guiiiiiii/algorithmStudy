package com.company.chap08;

import java.util.Arrays;
import java.util.Scanner;

public class 일로만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1 ~ 30000까지 정수입력 ");
        int num = Integer.parseInt(sc.nextLine());

        //System.out.println("결과 >>> "+solution(num));
        System.out.println("결과 >>> "+solution2(num));
    }

    static public int solution(int num){
        int result = 0;

        while(num != 1){

            if(num >=5){
                if(num % 5 == 0)    num = num/5;
                else                num -= 1;
            }else if(num >= 3){
                if(num % 3 == 0)    num = num/3;
                else                num -= 1;
            }else{
                if(num % 2 == 0)    num = num/2;
                else                num -= 1;
            }
            result ++;
        }

        return result;
    }

    static public int[] resultArr = new int[30001];

    static public int solution2(int num){
        // bottom up방식으로
        for(int i=2; i <= num ; i++){
            resultArr[i] = resultArr[i-1]+1;

            if(i % 2 == 0){
                resultArr[i] = Math.min(resultArr[i], resultArr[i/2]+1 );
            }
            if(i % 3 == 0){
                resultArr[i] = Math.min(resultArr[i], resultArr[i/3]+1 );
            }
            if(i % 5 == 0){
                resultArr[i] = Math.min(resultArr[i], resultArr[i/5]+1 );
            }
        }

        return resultArr[num];
    }
}
