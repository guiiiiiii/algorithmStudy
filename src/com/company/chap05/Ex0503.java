package com.company.chap05;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ex0503 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("N X M 을 공백을 기준으로 입력 :");
        String nm = sc.nextLine();

        int n = Integer.parseInt(nm.split(" ")[0]);
        int m = Integer.parseInt(nm.split(" ")[1]);

        ArrayList<ArrayList<Integer>> icemaker = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++){
            System.out.println((i+1)+"번째 행 입력 :");
            Integer[] temprow = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
            ArrayList<Integer> temp = new ArrayList<Integer>();

            Collections.addAll(temp,temprow);

            icemaker.add(temp);
        }



        int result = solution(n, m, icemaker);

        System.out.println("result >>>>> "+result);

    }

    @SuppressWarnings("unchecked")
    public static int solution(int n, int m, ArrayList<ArrayList<Integer>> icemaker){
        int result = 0;

        ArrayList<ArrayList<Integer>> visited = new ArrayList<>();

        for(ArrayList<Integer> row : icemaker){
            visited.add((ArrayList<Integer>)row.clone());
        }


        for(int y = 0; y < m; y++){
            for(int x = 0; x < n; x++){
                if(visited.get(x).get(y) == 0){
                    result++;
                    checkIce(n, m, x, y, icemaker, visited);
                }
            }
        }

        return result;
    }


    public static void checkIce(int n, int m, int x, int y, ArrayList<ArrayList<Integer>> icemaker, ArrayList<ArrayList<Integer>> visited){
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        // 방문처리
        visited.get(x).set(y, 2);

        for(int count=0; count < 4; count++){
            int newx = x+dx[count];
            int newy = y+dy[count];

            if(newx < 0 || newx >= n || newy < 0 || newy >= m)	continue;

            if(visited.get(newx).get(newy) == 0){
                checkIce(n, m, newx, newy, icemaker, visited);
            }
        }
    }
}