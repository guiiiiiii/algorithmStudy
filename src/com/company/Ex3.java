package com.company;


import java.util.Scanner;

public class Ex3 {

    public static void main(String[] args) {
        /*******
         * 어떠한 수 N이 1이 될때까지 두 과정중 하나를 반복적으로 수행한다
         * 1. N에서 1을 뺸다
         * 2. N을 K로 나눈다
         *
         * N과 K가 주어질 떄 N이 1이 될떄까지 1 또는 2를 수행하는 최소 횟수를 구하시오
         */


        Scanner sc = new Scanner(System.in);

        System.out.println("N과 K를 공백을 기준으로 입력 >>> ");
        String problem = sc.nextLine();

        String[] problemList = problem.split(" ");

        int N = Integer.parseInt(problemList[0]);
        int K = Integer.parseInt(problemList[1]);


        int result = solution(N, K);

        System.out.println("Ex3 결과값 >>>> "+result);

    }

    public static int solution(int n, int k){

        int subtractCount = 0;			// 1을 뺄 횟수
        int multipleCount = 0;			// K로 나눌 횟수

        // Step1. k로 더이상 나눠지지 않을때까지 n을 계속 나눈다
        while(true){
            // Step2. n이 k보다 크면 더 나눌수 있다는 뜻이므로 나누기를 진행
            // 		& 이 때 나누어 떨어지지 않는 나머지는 모두 1씩 빼기를 진행한다고 가정하여 subtract 카운트를 증가
            if(n >= k)	{
                subtractCount += n % k;
                multipleCount++;
                n = n / k;
            }else{
                break;
            }
        }

        return subtractCount+multipleCount;
    }
}