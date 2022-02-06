package com.company.chap05;

import java.util.Arrays;

public class Dfs {
    public static void main(String[] args) {
        int INF = 999999;

        int[][] graph = {{}, {2,3,8}, {1,7}, {1,4,5}, {3,5}, {3,4}, {7}, {2,6,8}, {1,7}};
        Boolean[] visited = new Boolean[9];
        Arrays.fill(visited, false);

        printDfs(1,graph, visited);

    }

    public static void printDfs(int i ,int[][] graph, Boolean[] visited){
        // 방문여부 체크
        visited[i] = true;
        System.out.print(" - "+i+" - ");
        // 인접노드에서 방문하지않은 노드를 찾아서 방문
        for(int nodelist : graph[i]){
            if(!visited[nodelist])      printDfs(nodelist, graph, visited);
        }


    }
}
