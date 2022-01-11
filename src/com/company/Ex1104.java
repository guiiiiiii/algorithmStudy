package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ex1104 {

    public static void main(String[] args) {
        /*****
         * N개의 동전을 이용해서 만들 수 없는 정수 중 최솟값을 구하는 문제
         *
         * 첫번째 입력값  >> N
         * 두번째 입력값  >> 공백으로 구분된 N개의 숫자
         */

        Scanner sc = new Scanner(System.in);

        System.out.println("동전의 개수 N을 입력 >>>> ");
        int n = Integer.parseInt(sc.nextLine());

        System.out.println("공백으로 구분하여 "+n+" 개의 수 입력");
        String coinStr = sc.nextLine();

        int result = solution(n, coinStr);


    }


    public static int solution(int N, String coinStr){

        // Step1. 주어진 동전String을 Integer형 arrayList로 변환
        Integer[] tempArr = Arrays.stream(coinStr.split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        ArrayList<Integer> coinArr = new ArrayList<>();

        // Step2. 오름차순으로 배열 정렬
        Collections.addAll(coinArr, tempArr);
        Collections.sort(coinArr);

        // Step3. 가장 작은 수와 그다음 작은수를 더한 값이 몇인지 확인
        int prevAvailable = coinArr.get(0)+coinArr.get(1);
        int coinGroupSize = 1;
        int available;

        // Step4. 배열 순회하며 가능한 값 체크
        for(int index = 1; index < coinArr.size()-coinGroupSize ; index++){
            // Step5. 현재 조합으로 만들 수 있는 정수 변수 초기화
            available = 0;

            // Step6. 동전으로 정수의 그룹을 만들 때 필요한 동전의 수만큼 배열의 수를 더해줌
            for(int n = coinGroupSize; n >=0 ; n--){
                available += coinArr.get(n) ;
            }

            // Step7. 이전조합에서 만든 정수에서 1더한값이 현재 조합에서 만든 정수라면
            //			이전 조합에서 만든 정수에 현재 조합에서 만든 정수를 세팅
            if(prevAvailable+1 == available){
                prevAvailable = available;
            }else{

            }
        }



        return 0;
    }

}
