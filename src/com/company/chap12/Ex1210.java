package com.company.chap12;

public class Ex1210 {
    /******
     * 자물쇠와 키가 주어지고
     * 이들의 돌기와 홈이 0:홈, 1:돌기 로 주어질 때
     * 자물쇠를 주어진 키로 열수 있는지 구하시오
     *
     * 입출력 예시
     * key = [[0,0,1], [1,0,0], [0,1,1]]
     * lock = [[1,1,1], [1,1,0], [1,0,1]]
     *
     */

    public static void main(String[] args) {
        int[][] key = {{0,0,1}, {1,0,0}, {0,1,1}};
        int[][] lock = {{1,1,0,1}, {1,0,0,1}, {1,1,0,0},{0,0,0,0}};

        boolean result = solution(key, lock);
        System.out.println("Ex1210의 result >>>> "+result);

    }

    // 90도 회전시켜줄 rotate함수
    public static int[][] rotate(int[][] matrix){
        int[][] temp_matrix = new int[matrix.length][matrix[0].length];

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                // 90도 회전은 (i,j) -> (j,n-i-1) 이다
                temp_matrix[j][matrix.length-i-1] = matrix[i][j];
            }
        }

        return temp_matrix;
    }

    // 자물쇠가 풀릴수 있는지 확인하는 함수
    public static boolean check(int[][] matrix){
        int locklength = matrix.length/3;
        for(int i= locklength; i< locklength*2 ;i++){
            for(int j= locklength; j<locklength*2; j++){
                if(matrix[i][j] != 1)   return false;
            }
        }
        return true;
    }

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;

        // Step1. 자물쇠의 크기를 3배로 늘리면 문제해결이 쉬움
        int locSize = lock.length;
        int keySize = key.length;
        int[][] large_lock = new int[3*locSize][3*locSize];


       // Step2. 새로운 자물쇠의 중앙에 기존 자물쇠를 위치시킨다
        for(int i=locSize; i<locSize*2 ; i++){
            for(int j=locSize; j<locSize*2; j++){
                large_lock[i][j] = lock[i-locSize][j-locSize];
            }
        }

        // Step3. 4방향 모두 돌려가며 열쇠를 왼쪽 위에서부터 움직인다
        for(int count = 0; count < 4; count++){
            key = rotate(key);

            // Step3-1. 키를 움직일 때 크게만든 자물쇠의 크기-key의 크기만큼만 움직이면 된다
            for(int index_x=0; index_x <= locSize*2; index_x++){
                for(int index_y=0; index_y <= locSize*2; index_y++){
                    // Stepe3-2. 비교를 위한 자물쇠변수 생성
                    //int[][] temp_lock = large_lock;
                    for(int x = 0; x < keySize; x++){
                        for(int y=0; y < keySize; y++){
                            large_lock[index_x+x][index_y+y] += key[x][y];
                        }
                    }
                    if(check(large_lock)){
                        answer = true;
                        return answer;
                    }

                    for(int x = 0; x < keySize; x++){
                        for(int y=0; y < keySize; y++){
                            large_lock[index_x+x][index_y+y] -= key[x][y];
                        }
                    }

                }
            }
        }

        return answer;
    }
}
