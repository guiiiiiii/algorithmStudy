package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Ex1WithGuide {
    public static void main(String[] args) {
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

        // Step3. 총 더해야할 횟수가 최대연속가능횟수보다 작은지 체크하여 작은경우 return진행
        if(totalCount < serialNum)      return numArr.get(0)*totalCount;

        // Step4. 최대연속가능한만큼의 최댓값과 그다음 큰 수의 합을 구하여 반복되는 횟수만큼 더하기 진행
        System.out.println("한세트 덧셈 >> "+(numArr.get(0)*serialNum + numArr.get(1)));
        System.out.println("총 세트 >> "+ (totalCount / serialNum));
        System.out.println("나머지 제일큰수 더할 횟수 >> "+(totalCount % serialNum));
        total = (numArr.get(0)*serialNum + numArr.get(1)) * (totalCount / (serialNum+1)) + numArr.get(0) * (totalCount % (serialNum+1));

        return total;
    }
}
