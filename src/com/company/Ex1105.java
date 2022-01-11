package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Ex1105 {

    public static void main(String[] args) {
        /***
         * 볼링공이 N개가 있고
         * 볼링공의 무게는 1부터 M까지의 자연수로 존재할 때
         * 같은공이 아닌 다른공을 뽑는 경우의 수
         */

        Scanner sc = new Scanner(System.in);

        System.out.println("볼링공 개수 N, M입력 >>> ");
        String nm = sc.nextLine();

        int n = Integer.parseInt(nm.split(" ")[0]);
        int m = Integer.parseInt(nm.split(" ")[1]);

        System.out.println("볼링공의 무게를 입력하려면 Y 아니라면 그 외의 문자 입력 >>>");
        String testCase = sc.nextLine();
        String weightStr = "";


        if("Y".equals(testCase)){
            // 책에서 주어진대로 사용자의 입력을 받음 [S]
            System.out.println("볼링공의 최대무게 >> ");
            weightStr = sc.nextLine();
            // 책에서 주어진대로 사용자의 입력을 받음 [E]

        }else{
            // 여러 경우를 위해 랜덤생성 [S]

            Random random = new Random();
            random.setSeed(System.currentTimeMillis());


            for(int i=0 ; i < n; i++){
                weightStr += Integer.toString(random.nextInt(m));
                weightStr += " ";
            }

            weightStr.substring(weightStr.length()-1, weightStr.length());

            // 여러 경우를 위해 랜덤생성 [E]
        }

        long first = System.nanoTime();
        //int result = solution(weightStr);
        int result = solutionWithAnswer(weightStr);

        System.out.println("Ex11-05 결과값은 >>> "+result);

        System.out.println("실행시간 >>> " + (double)(System.nanoTime()-first)/1000000000);


    }

    public static int solutionWithAnswer(String weightStr){
        int count = 0;

        // Step1. 주어진 볼링공의 무게를 배열로 변환한 뒤 Map에 저장
        Integer[] weightArr = Arrays.stream(weightStr.split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        SortedMap<Integer, Integer> weightMap = new TreeMap<>();

        for(Integer weight : weightArr){
            weightMap.put(weight, weightMap.getOrDefault(weight, 0)+1);
        }

        // Step2. Map의 keySet을 꺼내서 ArrayList로 변환
        ArrayList<Integer> weightkeys = new ArrayList<>(weightMap.keySet());

        // Step3. 총 가능 개수는 작은 볼링공의 무게 * (그보다 큰 수의 볼링공 개수 합) 이므로
        for(int index= 0; index < weightkeys.size()-1 ; index++){
            int temp = 0;		// 임시 값 저장 변수

            for(int index2 = index+1; index2 < weightkeys.size() ; index2++){
                temp += weightMap.get(weightkeys.get(index2));
            }

            count += (weightkeys.get(index)*temp) ;

        }

        return count;
    }

    public static int solution(String weightStr){
        int count = 0;

        // Step1. 주어진 볼링공의 무게를 배열로 변환
        Integer[] weightArr = Arrays.stream(weightStr.split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

        // Step2. arr[index] 와 arr[index+1]의 무게가 다르다면 가능한 조합으로 생각하여 count증가
        for(int index1=0; index1 < weightArr.length-1 ; index1++){
            for(int index2 = index1+1; index2 < weightArr.length; index2++){
                if(weightArr[index1] != weightArr[index2])	count++;
            }
        }

        return count;
    }

}
