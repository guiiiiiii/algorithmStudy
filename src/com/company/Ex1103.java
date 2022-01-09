package com.company;


import java.util.Scanner;

public class Ex1103 {

    public static void main(String[] args) {
        /***
         * 0과 1로만 이루어진 문자열S가 있을 때 S에서 연속된 하나이상의 숫자를 잡고 뒤집어서
         * 전부 같은 수를 만들어야 할 때 뒤집어야하는 최소 횟수
         */

        Scanner sc = new Scanner(System.in);
        System.out.println("0과 1로만 이루어진 문자열 입력 >>> ");
        String s = sc.nextLine();

        int result = solution(s);

        System.out.println("Ex11-03 결과값은 >>>> "+result);
    }

    public static int solution(String s){
        int cnt0 = 0;
        int cnt1 = 0;

        // Step1. 문자열 가장 첫 자리수를 최근 숫자로 저장
        String recentVal = s.substring(0,1);

        // Step2. 문자열 가장 첫자리수에 따라 해당하는 변수 수를 하나 증가
        if("0".equals(recentVal)){
            cnt0++;
        }else{
            cnt1++;
        }

        // Step3. 문자열 길이만큼 반복을 돌며 숫자가 바뀔때마다 해당하는 변수 수를 증가
        for(int i = 1; i < s.length(); i++){
            if(s.substring(i,i+1).equals(recentVal)){
                if("0".equals(recentVal)){
                    cnt1++;
                }else{
                    cnt0++;
                }
                recentVal = s.substring(i,i+1);
            }
        }

        // Step4. 두 변수중 더 큰 값을 return
        if(cnt0 < cnt1){
            return cnt0;
        }else{
            return cnt1;
        }
    }

}
