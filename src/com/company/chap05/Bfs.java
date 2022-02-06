package com.company.chap05;

import java.util.*;

public class Bfs {
    public static void main(String[] args) {
        int[][] graph = {{}, {2,3,8}, {1,7}, {1,4,5}, {3,5}, {3,4}, {7}, {2,6,8}, {1,7}};
        Queue<Integer> queue = new LinkedList<>();
        Boolean[] visited = new Boolean[9];
        Arrays.fill(visited, false);
        queue.add(1);
        printBfs(1, graph, visited, queue);
       // printBfs2(1, graph, visited);
    }

    public static void printBfs(int i, int[][] graph, Boolean[] visited, Queue<Integer> queue){

       visited[i] = true;
       for(int node : graph[i]){
           if(!visited[node]){
               visited[node] = true;
               queue.add(node);
               //System.out.print(" - "+node+" - ");
           }
       }

       int q = queue.poll();
       System.out.print(" - "+q+" - ");
        if(!queue.isEmpty()){
           printBfs(queue.peek(), graph, visited, queue);
       }

    }

    public static void printBfs2(int i, int[][]graph, Boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(i);
        visited[i] = true;

        int currentnode = i;

        while(!queue.isEmpty()){
            int q = queue.poll();
            System.out.print(" - "+q+" - ");
            for(int node : graph[i]){
                if(!visited[node]){
                    queue.add(node);
                    visited[node] = true;
                    //System.out.print(" - "+node+" - ");
                }
            }

            if(!queue.isEmpty()) i = queue.peek();
        }

    }
}
