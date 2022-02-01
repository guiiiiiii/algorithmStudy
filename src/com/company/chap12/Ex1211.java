package com.company.chap12;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex1211 {
    /*****
     * 뱀게임
     * 1. 이동한 칸에 사과가 있으면 그 칸에 사과없어지고 꼬리는 움직이지 X
     * 2. 이동한 칸에 사과가 없으면 머리를 한칸 이동한 뒤 꼬리가 위치한 칸을 비움
     * 입력예시
     *
     * 6 :보드의크기 N
     * 3 : 사과의 개수 K
     * 3 4 : 이후부터 사과의 개수만큼 사과의위치
     * 2 5
     * 5 3
     * 3 : 뱀의 방향변환횟수 L
     * 3 D : 방향변환횟수만큼 0초되 L(왼쪽) D(오른쪽)회전
     * 15 L
     * 17 D
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("보드의 크기 입력 >> ");
        int n = Integer.parseInt(sc.nextLine());

        System.out.println("사과의 개수 입력 >> ");
        int k = Integer.parseInt(sc.nextLine());

        ArrayList<String> apple_loc = new ArrayList<>();
        for(int i=0; i<k; i++){
            System.out.println((i+1)+"번째 사과 위치 입력 -공백으로 구분 >> ");
            apple_loc.add(sc.nextLine());
        }

        System.out.println("뱀의 방향변환횟수 입력 >> ");
        int l = Integer.parseInt(sc.nextLine());

        ArrayList<String> snake_rotate = new ArrayList<>();
        for(int i=0; i<l; i++){
            System.out.println((i+1)+"번째 뱀 방향변환정보 입력 -공백으로 구분 >> ");
            snake_rotate.add(sc.nextLine());
        }

        int result = solution(n,k,apple_loc,l,snake_rotate);

        System.out.println("결과는 >>> "+result);
    }

    public static boolean check_snake_body(ArrayList<int[]> snake){

        if(snake.size() == 1)   return false;
        for(int index = 0; index < snake.size()-1; index++){
            int tempx = snake.get(index)[0];
            int tempy = snake.get(index)[1];

            for(int target = index+1; target<= snake.size()-1; target++){
                if(snake.get(target)[0]==tempx && snake.get(target)[1] == tempy)    return true;
            }
        }
        return false;
    }

    public static int solution(int n, int k, ArrayList<String> apple_loc, int l, ArrayList<String> snake_rotate){
        int result = 0;     // 게임이 현재까지 몇초 흘렀는지 시간
        int gametime = 0;

        // Step1. 보드 생성
        int[][] board = new int[n][n];

        // Step2. 사과 위치 보드에 insert
        for(String loc : apple_loc){
            board[Integer.parseInt(loc.split(" ")[0])][Integer.parseInt(loc.split(" ")[1])] = 1;
        }

        //Step3. 회전변수에 끝까지갈것 하나 더 넣기
        snake_rotate.add("10000 D");

        // Step4. 뱀위치 저장 list 생성 & 초기위치 세팅
        ArrayList<int[]> snake = new ArrayList<>();
        snake.add(new int[]{0, 0});

        // Step5. 뱀의 현재 방향변수와 방향변수에 따라 이동할 방향list 선언
        int snakeDirectionIndex = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for(String rotate : snake_rotate){
            int time = Integer.parseInt(rotate.split(" ")[0]);
            String direction = rotate.split(" ")[1];

            while(result < time){
                // 게임이 진행되는 시간 증가
                result++;

                int[] snake_head = snake.get(0);

                // Step6. 다음이동위치가 보드를 벗어나면 즉시 return한다
                if(snake_head[0]+dx[snakeDirectionIndex] <= n-1 && snake_head[1]+dy[snakeDirectionIndex] <= n-1
                        && snake_head[0]+dx[snakeDirectionIndex] >= 0 &&  snake_head[1]+dy[snakeDirectionIndex] >= 0){
                    // Step7. 다음 갈곳이 1이면 사과의위치이므로 사과의 개수를 줄이고
                    if(board[snake_head[0]+dx[snakeDirectionIndex]][snake_head[1]+dy[snakeDirectionIndex]] == 1){
                        k--;
                        board[snake_head[0]+dx[snakeDirectionIndex]][snake_head[1]+dy[snakeDirectionIndex]] = 0;
                        // 뱀의 머리를 추가한다
                        snake.add(0, new int[]{snake_head[0] + dx[snakeDirectionIndex], snake_head[1] + dy[snakeDirectionIndex]});
                    }else{
                        // 뱀의 머리를 추가한다
                        snake.add(0, new int[]{snake_head[0] + dx[snakeDirectionIndex], snake_head[1] + dy[snakeDirectionIndex]});
                        // 사과가 없으면 꼬리를 잘라냄 (몸길이 변화x)
                        snake.remove(snake.size()-1);
                    }

                    // Step8. 게임종료 조건을 검토한다 (사과개수 0 or 뱀이 자기몸에 닿은경우 or 뱀머리가 밖으로 나가는경우 ...
                    boolean checkbody =  check_snake_body(snake);
                    if(k<=0 || checkbody)       return result;


                }else{
                    return result++;
                }

            }

            if(direction.equals("D")){
                if(snakeDirectionIndex < 3)     snakeDirectionIndex++;
                else                            snakeDirectionIndex=0;
            }
            else {
                if(snakeDirectionIndex > 0)     snakeDirectionIndex--;
                else                            snakeDirectionIndex = 3;

            }
        }

        return result;
    }
}
