package com.company.chap04;

import java.util.Arrays;
import java.util.Scanner;

// p.115 실전문제2 왕실의 나이트
public class Ex0403 {
    /***
     * 8*8 체스판에 나이트가 있을 때
     * 나이트는 다음과같은 두가지로만 이동이 가능하다
     * {
     *     1. 수평으로 두 칸 이동한뒤에 수직으로 한칸 이동
     *     2. 수직으로 두 칸 이동한뒤에 수평으로 한칸 이동
     * }
     *
     * 입력값으로 나이트의 위치가 주어질 때 나이트가 이동할 수 있는 경우의 수 출력 (x좌표 a~h, y좌표 1~8)
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("나이트의 현재위치 >>>> " );
        String nightLoc = sc.nextLine();

        int result = solution(nightLoc);
        System.out.println("4챕터 실전문제 2 결과값은 >>>> "+result);
    }

    public static int solution(String loc){
        int result = 0;

        // Step1. 체스말의 x좌표로 변환할 알파벳 배열 선언과 이를 사용한 체스말의 현재 location 선언
        String[] indexX = {"a", "b", "c", "d", "e", "f", "g", "h"};

        int locX = Arrays.asList(indexX).indexOf(loc.substring(0,1))+1;
        int locY = Integer.parseInt(loc.substring(1));

        // Step2. 이동할 수 있는 경로배열 선언
        int[] dx = {2, 2, -2, -2, 1, -1, 1, -1};
        int[] dy = {1, -1, 1, -1, 2, 2, -2, -2};

        for(int index = 0; index<dx.length; index++){
            int tempX = locX+dx[index];
            int tempY = locY+dy[index];

            if(tempX < 1 || tempX > 8 || tempY < 1 || tempY > 8)    continue;

            result++;
        }

        return result;
    }
}
