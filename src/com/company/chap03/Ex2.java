package com.company.chap03;

import java.util.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args) {
        /******
         * 배열의 크기 N, M
         * 이후로 N개의 줄에 걸쳐 각 카드에 적힌 수가 주어짐 (1이상 10,000이하 자연수)
         * 가장 큰 수의 카드를 냈을 때 이길 수 있지만
         * 선택한 행에서 가장 작은 수를 뽑아야하는 패널티가 있을 때
         * 어떤 행을 선택해야 이길 수 있을지 행을 골라야 하는 문제
         */

        Scanner sc = new Scanner(System.in);

        System.out.println("배열 크기 입력 >>> ");
        String matSize = sc.nextLine();

        ArrayList<String> rowInfoArr = new ArrayList<>();

        int[] matSizeArr = Arrays.stream(matSize.split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i=0; i<matSizeArr[0]; i++){
            System.out.println(i+"번째 행 정보 입력 >>> ");
            String rowInfo = sc.nextLine();
            rowInfoArr.add(rowInfo);
        }

        int _result = result(matSizeArr[0],rowInfoArr);
        System.out.println("Ex2의 결과값 >>>>> "+_result);


    }

    public static int result(int rowSize, ArrayList<String> rowArr){

        int max = 0;
        int index = 0;

        // 각 행의 최소값을 담기 위한 arraylist 생성
        ArrayList<Integer> rowMinVal =  new ArrayList<>();

        // Step1. 행만큼 반복문을 돌면서 최소값 체크 진행 (행에서 선택할 수 있는 카드는 가장 작은 수의 카드이다)
        for(String row : rowArr){
            Integer[] tempArr = Arrays.stream(row.split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
            ArrayList<Integer> temprow = new ArrayList<>();
            Collections.addAll(temprow, tempArr);

            Collections.sort(temprow);

            //정렬 했기 때문에 가장 앞 인덱스가 해당 row의 최소값이다
            rowMinVal.add(temprow.get(0));
        }

        // Step2. 각 행의 최소값을 담아놓은 arrayList를 순회하며 최소값과, 최소값이 있는 행을 찾는다
        for(int rowIndex = 0; rowIndex < rowMinVal.size(); rowIndex++){
            if(max < rowMinVal.get(rowIndex)){
                max = rowMinVal.get(rowIndex);
                index = rowIndex;
            }
        }


        return max;
    }

}