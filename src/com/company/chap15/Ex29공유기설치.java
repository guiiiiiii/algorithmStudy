package com.company.chap15;

import java.util.Arrays;

public class Ex29공유기설치 {
    public static void main(String[] args) {
        int n = 5;
        int c = 3;
        String houseStr = "1 2 8 4 9";

        Integer[] houseArr = Arrays.stream(houseStr.split(" ")).mapToInt(Integer::parseInt).boxed().sorted().toArray(Integer[]::new);

        // 함수 호출 시 start와 end는 배열의 첫index, 마지막index가 아닌
        // 배열의 수에서 가장 작은 gap과 큰gap을 넣어준다 (배열은 정렬되어있으니 작은 gap은 앞 두 index와의 차이이고, 큰 gap은 가장큰 index와 작은 index와의 차이이다)
        System.out.println(findMaxDistance(houseArr, houseArr[1]-houseArr[0], houseArr[houseArr.length-1]-houseArr[0], 0, c));
    }

    static public int findMaxDistance(Integer[] houseArr, int start, int end, int bestGap, int c){

        if(start > end)         return bestGap;

        // parameter로 넘어온 start와 end를 사용해 중간 gap을 계산한다
        int mid = (start+end) /2;
        // 현재까지 설치된 공유기 개수(가장 첫 인덱스에 공유기는 이미 설치했다고 가정한다)
        int count = 1;
        // gap만큼 떨어진 위치에 공유기설치를 하기위해 다음 공유기 설치 위치를 저장
        int nextTerm = houseArr[0]+mid;

        for(int index=1; index < houseArr.length; index++){
            if(nextTerm <= houseArr[index]){
                // 공유기 설치 위치를 찾았다면 다음 설치 지점을 지정하고, 공유기 개수를 늘린다
                nextTerm= houseArr[index]+mid;
                count++;
            }
        }

        // 공유기 설치 개수가 목표 개수보다 작다면 gap을 줄여준다
        if(count < c){
            return findMaxDistance(houseArr, start, mid-1, bestGap, c);
        }else{
            // 공유기 설치 개수가 목표 개수보다 크거나 같다면 최적의 gap을 계산한뒤, gap을 늘려본다
            if(bestGap < mid)   return findMaxDistance(houseArr, mid+1, end, mid, c);
            else                return findMaxDistance(houseArr, mid+1, end, bestGap, c);
        }

    }

}
