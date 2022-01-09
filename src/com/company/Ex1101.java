package com.company;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Ex1101 {

    public static void main(String[] args) {
        /****
         * 모험가가 N명 있고 모든 모험가는 공포도X를 가지고 있음
         * 모험 그룹을 구성할 때 공포도가 X인 모험가는 반드시 X명 이상으로 구성되어야 그룹조건이 충족될 때
         * 최대 몇개의 그룹을 생성할 수 있는지
         */

        Scanner sc = new Scanner(System.in);
        System.out.println("몇 명의 모험가가 있는지 :N >>> ");
        int n = Integer.parseInt(sc.nextLine());

        System.out.println("모험가들의 공포도를 공백을 기준으로 입력 >> ");
        String fearString = sc.nextLine();

        //int result = solution(n, fearString);
        int result = solutionWithAnswer(n, fearString);

        System.out.println("Ex11-01 result >>>>> "+result);
    }

    // 내가 처음 한 풀이
    public static int solution(int n, String fearGroup){
        int result = 0;

        // Step1. 주어진 공포도를 공백을 기준으로 자른 후 배열로 변환
        Integer[] tempArr = Arrays.stream(fearGroup.split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

        // Step2. Sortedmap에 공포도별로 모험가들이 몇명있는지 저장
        SortedMap<Integer, Integer> sortedFearMap = new TreeMap<>();

        for(int arr : tempArr){
            sortedFearMap.put(arr,sortedFearMap.getOrDefault(arr, 0)+1);
        }

        // Step3. 공포도의 배수만큼 모험가들이 있는지 체크
        //		  ( 이번 풀이에서는 공포도의 배수만큼의 모험가들이 그룹을 짓는게 그룹의 최대값이라 보고 나머지 모험가는 버림)
        Set keyset = 	sortedFearMap.keySet();

        for(Object k : keyset){
            int personnal = sortedFearMap.get((int)k);

            // 인원수보다 k가 크면 일단 나눠지긴 하므로 몇번 그룹지을수있는지 계산
            if((int)k <= personnal){
                result += personnal/(int)k;
            }
        }

        return result;
    }

    // 해설보고 한 풀이
    public static int solutionWithAnswer(int n, String fearGroup){
        int result = 0;
        int recentMemberCnt = 0;

        // Step1. 주어진 모험가 문자열을 배열로 만든 뒤 정렬
        Integer[] tempArr = Arrays.stream(fearGroup.split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        ArrayList<Integer> fearArr = new ArrayList<>();

        Collections.addAll(fearArr, tempArr);
        Collections.sort(fearArr);

        // Step2. 낮은 수부터 차례로 비교하며 그룹을 생성
        for(int fear : fearArr){
            // 그룹원이 추가되었으므로 멤버수 증가
            recentMemberCnt++;

            // Step3. 현재까지의 그룹원이 공포도와 같다면 그룹수를 증가시키고 멤버수를 초기화한다
            if(recentMemberCnt == fear){
                result++;
                recentMemberCnt = 0;
            }
        }

        return result;
    }


}
