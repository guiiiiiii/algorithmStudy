package com.company.chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        /*************
         * 배열의 크기 : N
         * 숫자가 더해지는 횟수 : M
         * 연속해 더할 수 있는 횟수 : K
         *
         * 입력예시
         * [ 5 8 3 ] => N:5, M:8, K:3
         * [ 2 4 5 4 6 ] => 주어지는 숫자
         */
        String guideInt = "5 8 3";
        String numList = "2 4 5 4 6";

        //ArrayList<Integer> guideInt = new ArrayList<>(Arrays.asList(5, 8, 3));
        //ArrayList<Integer> numList = new ArrayList<>(Arrays.asList(2, 4, 5, 4, 6));

        int _total = result(generateStringToIntArrayList(guideInt, " "), generateStringToIntArrayList(numList, " "));

        System.out.println(_total);

    }

    // 주어진 string을 ArrayList로 변환
    public static ArrayList<Integer> generateStringToIntArrayList(String stringArr, String regex){
        Integer[] tempIntegerArr = Arrays.stream(stringArr.split(regex)).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        ArrayList<Integer> ArrList = new ArrayList<Integer>();
        Collections.addAll(ArrList, tempIntegerArr);

        return ArrList;
    }

    public static int result(ArrayList<Integer> guideArr, ArrayList<Integer> numArr){
        int total = 0;				// 총 더한 값
        int index = 0;				// 배열의 현재 index
        int totalIndex = 0;			// 현재까지 총 더한 횟수

        // Step1. 총 더해질 횟수와, 연속해서 더할 수 있는 횟수를 변수로 정의
        int totalCount = guideArr.get(1);
        int serialNum = guideArr.get(2);

        // Step2. 더하는 숫자가 있는 배열을 내림차순으로 정렬
        Collections.sort(numArr, Collections.reverseOrder());

        // Step3. 총 숫자가 더해질 횟수만큼 반복 진행
        for(int i=0; i <totalCount; i++){

            // Step4. 현재까지 총 더한 횟수가 주어진 연속횟수보다 크고,
            //		  주어진 연속횟수로 나누었을때 나머지가 1이면 두번째로 큰 수를 더한다
            if(totalIndex > serialNum && totalIndex % serialNum == 1){
                index = 1;
            }else{
                index = 0;
            }

            // Step5. 총 더한 횟수가 주어진 횟수만큼 충족되면 for문 중지
            if(totalIndex == totalCount) break;

            // Step6. 앞쪽 index부터 total에 더한 뒤 serialIndex횟수를 카운트
            total += numArr.get(index);
            totalIndex++;

        }

        return total;
    }
}
