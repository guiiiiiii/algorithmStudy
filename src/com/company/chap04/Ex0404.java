package com.company.chap04;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// p.118 실전문제 게임 개발
public class Ex0404 {
    /****
     * N*M크기의 맵에 캐릭터 존재
     * 캐릭터는 상하좌우로 움직일 수 있고, 바다로는 갈 수 없다
     * 캐릭터가 움직이는 메뉴얼은 다음과 같음
     * {
     *     1. 현재 위치에서 현재방향을 기준으로 왼쪽방향부터 갈곳을 정함
     *     2. 바로 왼쪽방향에 가보지않은 칸이 있다면 회전 후 한칸 전진, 가보지않은 칸이 없다면 회전 후 1로 돌아감
     *     3. 네 방향 모두 가본칸이거나 바다로 되어있다면 회전 후 한칸 뒤로 움직인 후 1로 돌아감
     *        이 때 뒤쪽 방향이 바다인 경우 움직임을 멈춘다
     * }
     * 캐릭터가 방문한 칸의 수를 출력하는 프로그램을 작성
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("맵크기 입력 >>> ");
        String mapSize = sc.nextLine();

        int n = Integer.parseInt(mapSize.split(" ")[0]);

        System.out.println("캐릭터의 위치 >>> ");
        String location = sc.nextLine();

        ArrayList<Integer[]> mapArr = new ArrayList<>();
        System.out.println("행별로 맵 입력 1:바다 0:육지");
        for(int i=0; i<n; i++){
            String tempStr = sc.nextLine();
            mapArr.add(Arrays.stream(tempStr.split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new));
        }

        int result = solution(mapSize, location, mapArr);

        System.out.println("결과값 >>>> "+result);

    }

    public static int solution(String mapSize, String playerLoc, ArrayList<Integer[]> map){
        int result = 1;

        int n = Integer.parseInt(mapSize.split(" ")[0]);
        int m = Integer.parseInt(mapSize.split(" ")[1]);

        // 캐릭터의 위치 및 방향 설정
        String[] tempArr = playerLoc.split(" ");
        int playerX = Integer.parseInt(tempArr[0]);
        int playerY = Integer.parseInt(tempArr[1]);
        int playerD = Integer.parseInt(tempArr[2]);

        // 북, 동, 남, 서 별로 이동하게 될 때 캐릭터가 움직이게 될 좌표변환배열
        // 북동남서로 한 이유는 문제에서 북부터 0으로 설정되어있기 때문
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        // 회전만 한 경우 카운트
        int redirect = 0;

        // 캐릭터가 서있는곳 체크
        map.get(playerX)[playerY] = 2;

        while(true){
            // 1. 왼쪽 회전 후 전진 시도
            playerD -= 1;
            int tempX ;
            int tempY ;

            if(playerD < 0) playerD = 3;

            tempX = playerX + dx[playerD];
            tempY = playerY + dy[playerD];

            redirect++;
            // 맵을 벗어나도록 움직이는 경우는 가지 못하는 경우이므로 카운트하지 않고 넘어간다
            if(tempX < 0 || tempX >= m || tempY < 0 || tempY >= n)  continue;

            // 이동한곳이 육지라면 카운트를 올리고 가본영역으로 표기한다
            if(map.get(tempX)[tempY] == 0){
                result++;
                redirect = 0;
                map.get(tempX)[tempY] = 2;

                playerX = tempX;
                playerY = tempY;
            }else{
                // 네방향 모두 가본곳이거나 바다인경우 뒤로 한칸 이동
                if(redirect >= 4){
                    tempX = playerX - dx[playerD];
                    tempY = playerY - dy[playerD];

                    // 물러난곳이 바다이거나 맵 밖인경우 끝
                    if(tempX < 0 || tempX >= m || tempY < 0 || tempY >= n || map.get(tempX)[tempY] == 1){
                        break;
                    }else{
                        if(map.get(tempX)[tempY] == 0){
                            result++;
                            map.get(tempX)[tempY] = 2;
                        }

                        redirect = 0;
                        playerX = tempX;
                        playerY = tempY;
                    }
                }
            }

        }

        return result;
    }
}
