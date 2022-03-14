package com.company.chap15;

import java.util.Arrays;

public class Ex28고정점찾기 {
    public static void main(String[] args) {
        int n = 7;
        String numStr = "-15 -4 3 8 9 13 15";

        Integer[] numArr = Arrays.stream(numStr.split(" ")).mapToInt(Integer::parseInt).boxed().sorted().toArray(Integer[]::new);

        System.out.println(solution(numArr, 0, n-1));

    }

    static public int solution(Integer[] numArr, int start, int end){
        int medium = (start+end)/2;

        if( start > end ) return -1;

        if(medium < numArr[medium])         return solution(numArr, start, medium-1);
        else if(medium > numArr[medium])    return solution(numArr, medium+1, end);
        else                                return numArr[medium];

    }

}
