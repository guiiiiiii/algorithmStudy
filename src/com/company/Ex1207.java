package com.company;

import java.util.Scanner;

public class Ex1207 {
    public static void main(String[] args) {
        /**
         * 현재 캐릭터의 점수 N이 주어질 때 자리수를 기준으로 점수 N을 반으로 나누어
         * 왼쪽의 자릿수의 합과 오른쪽 자릿수의 합을 더한값이 동일할 때 기술을 사용할 수 있다
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("점수 입력 >>> ");
        String score = sc.nextLine();

        System.out.println("결과값은 >>> "+solution(score));

    }

    public static int calculate(String num){
        int result = Integer.parseInt(num.substring(0,1));

        for(int i=1; i<num.length(); i++){
            result += Integer.parseInt(num.substring(i,i+1));
        }
        return result;
    }

    public static String solution(String score){
        String result = "READY";

        String leftScore = score.substring(0,score.length()/2);
        String rightScore = score.substring(score.length()/2);

        if(calculate(leftScore) == calculate(rightScore))   result = "LUCKY";

        return result;
    }
}
