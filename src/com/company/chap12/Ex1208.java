package com.company.chap12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ex1208 {
    /****
     * 알파벳 대문자와 숫자롬나 구성된 문자열이 주어질 떄
     * 모든 알파벳을오름차순으로 정렬하여 출력한 뒤 모든 숫자를 더한값을 이어서 출력
     */
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("문자열 입력 >>> ");
        String str = sc.nextLine();

        //System.out.println("결과는 >>> "+solution(str));
        System.out.println("결과는 >>> "+solutionWithAnswer(str));
    }

    public static String solutionWithAnswer(String str){
        String result = "";

        ArrayList<Character> arr = new ArrayList<>();
        int value = 0;

        for(int index = 0; index <str.length(); index++){
            if(Character.isLetter(str.charAt(index))){
                arr.add(str.charAt(index));
            }else{
                // '0'을 뺴주는 이유 => '1'은 아스키코드로 49, '0'은 48이다
                // 따라서 '0'을 뺌으로서 아스키코드로 연산했을때 정수형이 나올수 있도록 한다
                value += str.charAt(index)- '0';
            }
        }

        Collections.sort(arr);

        for(Character c : arr)  result += c;

        if(value != 0)      result+= value;

        return result;
    }

    public static String solution(String str ){
        String result = "";

        // 모든 글자를 뜯어서 arraylist에 담음
        String[] strArr = Arrays.stream(str.split("")).sorted().toArray(String[]::new);
        ArrayList<String> temp = new ArrayList<>();

        // 숫자배열은 모두 더한다
        int sum = 0;

        // 배열을 순회하면서 아스키코드가 65보다 작으면 즉, 숫자면 배열에서 제거한 뒤 임시배열에 담는다
        for(String s : strArr){
            if(s.hashCode() < 65){
                sum+= Integer.parseInt(s);
                continue;
            }
            temp.add(s);
        }

        // 두 배열을 합친다
        for(String s : temp){
            result += s;
        }
        result+=sum;

        return result;
    }
}
