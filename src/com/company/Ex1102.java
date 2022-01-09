package com.company;


import java.util.Scanner;

public class Ex1102 {

    public static void main(String[] args) {

        /****
         * 각 자리가 숫자(0~9) 로만 이루어진 문자열 S가 있을 때
         * 숫자 사이에 X혹은 +를 넣어 만들 수 있는 가장 큰 수를 구하는 프로그램을 작성
         * (이 때 연산순서는 일반연산법칙을 무시하고 앞 순서대로 진행한다)
         */

        Scanner sc = new Scanner(System.in);

        System.out.println("숫자 구성 입력 >>>> ");
        String numString = sc.nextLine();

        //int result = solution(numString);
        int result = solutionWithAnswer(numString);

        System.out.println("Ex11-02 result >>> "+result);

    }

    // 내가 한 풀이
    public static int solution(String numString){

        int result = 1;

        // Step1. 주어진 문자열을 길이만큼 순회하며 0또는 1일경우 덧셈, 그 이외의 경우는 곱셈을 시도한다
        for(int i=0; i<numString.length(); i++){

            int presentNum = Integer.parseInt(numString.substring(i,i+1));

            if(presentNum > 1){
                result *= presentNum;
            }else{
                result += presentNum;
            }
        }

        return result;
    }


    // 해설보고 수정한 풀이
    public static int solutionWithAnswer(String numString){

        int result = Integer.parseInt(numString.substring(0,1));;

        // Step1. 주어진 문자열을 길이만큼 순회하며 0또는 1일경우 덧셈, 그 이외의 경우는 곱셈을 시도한다
        for(int i=1; i<numString.length(); i++){

            int presentNum = Integer.parseInt(numString.substring(i,i+1));

            if(presentNum > 1 && result > 1){
                result *= presentNum;
            }else{
                result += presentNum;
            }
        }

        return result;
    }

}
