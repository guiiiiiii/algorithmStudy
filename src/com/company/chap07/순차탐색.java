package com.company.chap07;

import java.util.Arrays;
import java.util.Scanner;

public class 순차탐색 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("문자열을 공백을 기준으로 입력");
        String arrStr= sc.nextLine();

        System.out.println("찾고자 하는 문자열 입력");
        String targetStr = sc.nextLine();

        System.out.println("결과는 >>> "+solution(arrStr, targetStr));

    }

    static public int solution(String arrStr, String targetStr){
        String[] searchArr = arrStr.split(" ");

        for(int index=0; index<searchArr.length; index++){
            if(searchArr[index].equals(targetStr))  return index;
        }

        // 찾는 문자열이 없으면 -1 반환
        return -1;
    }
}
