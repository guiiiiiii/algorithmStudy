package com.company;

import java.util.Scanner;

// p.113 예제 4-2 시각
public class Ex0402 {
    /***
     * 정수 N이 입력되면 00시 00분 00초부터 N시 59분 59초까지 모든 시각 중 3이 하나라도 포함되는
     * 모든 경우의 수 출력
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수 N입력 >>> ( 0~ 23 사이 ) ");
        int n = sc.nextInt();

        //int result = solution(n);
        int result = solutionWithAnswer(n);

        System.out.println("예제 4-2 결과값 >>> "+result);
    }
    
    public static int solutionWithAnswer(int n){
        int result = 0;

        // Step1. n시 59분 59초까지 완전탐색하며 3이 있는 시간을 카운트한다
        for(int hours=0; hours<=n; hours++){
            for(int min = 0; min <= 59; min++){
                for(int sec = 0; sec <= 59; sec++){
                    String time = ""+hours+min+sec;
                    if(time.indexOf("3") > -1)  result++;
                }
            }
        }
        return result;
    }

    // 완전 틀린로직
    public static int solution(int n){

        // Step1. 1~59까지 3이 몇번나오는지 count
        int count3In59 = 0;     // 59 내에서 3이 나오는 횟수
        int count3InN = 0;      // n 내에서 3이 나오는 횟수

        for(int i=1; i <= 59; i++){
            if(Integer.toString(i).indexOf("3") > -1)    count3In59++;
        }

        for(int i=1; i<=n; i++){
            if(Integer.toString(i).indexOf("3") > -1)    count3InN++;
        }

        return count3InN*count3In59*count3In59;
    }

}
