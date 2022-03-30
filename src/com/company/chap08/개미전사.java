package com.company.chap08;

public class 개미전사 {
    public static void main(String[] args) {
        int n = 6;
        int[] warehouse = {1, 4, 1, 1, 5, 6};

        System.out.println(solution(n, warehouse));
    }

    static public int[] dict = new int[101];

    static public int solution(int n, int[] warehouse){
        // 첫번째, 두번째 값은 미리 세팅해둔다
        dict[1] = warehouse[0];
        dict[2] = warehouse[1];

        // bottom up 방식으로 an = max((an+an-2),(an+an-3))을 구해준다
        for(int i = 3; i <= n; i++){
            dict[i] = Math.max((warehouse[i-1]+dict[i-2]), (warehouse[i-1]+dict[i-3]));
        }

        return Math.max(dict[n-1], dict[n]);
    }
}
