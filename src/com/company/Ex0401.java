package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// p.110 예제4-1 상하좌우
public class Ex0401 {
    public static void main(String[] args) {
        /****
         * 여행가 A가 N*N크기의 정사각형 공간 위에 있고
         * 계획서로 하나의 줄에 띄어쓰기를 기준으로 하여 L, R, U, D중 하나의 문자가 반복으로 적혀있다
         * 이 때 여행가가 최종으로 도착하는 지점의 좌표를 출력
         * ps. 여행자의 최초위치는 1,1 고정
         */

        Scanner sc = new Scanner(System.in);

        System.out.println("공간의 크기 N 입력 >>> ");
        String ariaSize = sc.nextLine();

        System.out.println("이동계획을 공백으로 분리하여 입력 >>> ");
        String pathStr = sc.nextLine();

        //String result = solution(ariaSize, pathStr);
        String result = solutionWithAnswer(ariaSize, pathStr);

        System.out.println("예제 4-1 의 결과는 >>> "+result);
    }

    public static String solutionWithAnswer(String areaSize, String pathStr){
        String result = "";

        // Step1. 현재 여행자의 x, y좌표 지정
        int locX= 1;
        int locY= 1;

        // Step2. 이동계획에 따른 방향연산계획 지정
        String[] move = {"L", "R", "U", "D"};
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        // Step3. 입력받은 공간의 크기와 계획을 int, String[]로 변환
        int size = Integer.parseInt(areaSize);
        String[] pathArr = pathStr.split(" ");

        for(String path : pathArr){

            // Step4. 계획서에서 제시한 path가 몇번째 index인지 찾은 후 이동경로 계산
            int index = Arrays.asList(move).indexOf(path);

            int tempX = locX + dx[index];
            int tempY = locY + dy[index];

            // Step5. 이동경로가 공간을 벗어났다면 continue, 공간 이내라면 실제 여행자 위치에 적용
            if(tempX < 1 || tempX > size || tempY < 1 || tempY > size)  continue;

            locX = tempX;
            locY = tempY;
        }

        result = locX + " "+locY;

        return result;
    }

    public static String solution(String areaSize, String pathStr){
        String result = "";

        // Step1. 현재 여행자의 x,y좌표 지정
        int locX = 1;
        int locY = 1;

        // Step2. path를 배열로 변환하고, 공간크기도 int로 변환한다
        int size = Integer.parseInt(areaSize);
        String[] pathArr = pathStr.split(" ");

        // Step3. 배열 크기만큼 순회하며 x, y좌표 이동
        for(String path : pathArr){
            if("L".equals(path))        locY--;
            else if("R".equals(path))   locY++;
            else if("U".equals(path))   locX--;
            else                        locX++;

            // Step4. 공간을 벗어난 좌표가 있다면 직전의 연산을 취소한다
            if(locX < 1)                       locX++;
            else if(locX > pathArr.length)     locX--;
            if(locY < 1)                       locY++;
            else if(locY > pathArr.length)     locY--;
        }

        result = locX+" "+locY;

        return result;
    }
}
