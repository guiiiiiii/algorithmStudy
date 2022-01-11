package com.company;

public class Ex1106 {

    public static void main(String[] args) {
        /*****
         *
         * 1번부터 음식을 먹기 시작하며 회전판은 번호가 증가하는 순서대로 음식이 앞으로 이동됨
         * 마지막 번호의 음식을 먹으면 다시 1번부터 음식을 섭취
         * 음식은 1초씩 섭취하며, 1초뒤에는 그 다음번호의 음식을 섭취
         *
         * N : 회전판에 먹어야 할 음식의 개수
         * food_times : 음식을 모두 먹는 데 필요한 시간이 담겨있는 배열
         * K : 네트워크 장애가 발생한 시간
         *
         */

        int k = 5;
        int[] food_times = {3, 1, 2};

        int result = solution(food_times, k);
        System.out.println("Ex11 06의 결과값은 >>> "+result);
    }

    public static int solution(int[] food_times, int k){

        int totalSum =0;
        int currentIndex = 0;
        int networkFailIndex = 0;

        // Step1. k가 모든 배열의 합보다 큰 경우 -1를 반환한다
        for(int item : food_times){
            totalSum+=item;
        }

        if(totalSum <= k) return -1;
        else{

            while(networkFailIndex < k){
                // Step2. 현재 인덱스의 값이 1보다 큰 경우는 먹을수있는 음식이 남아있는 경우이므로
                //			배열의 값을 수정 후 네트워크 장애인덱스 증가
                if(food_times[currentIndex] >= 1){
                    food_times[currentIndex] = food_times[currentIndex]-1;

                    networkFailIndex++;
                }

                // Step3. 현재 인덱스의 값이 1보다 작은 즉, 더이상 먹을 음식이 없는 경우에는
                //			먹을 음식이 있는 인덱스를 찾을때까지 현재 인덱스를 증가시킨다
                currentIndex++;
                // Step4. 현재 인덱스가 배열의 길이를 넘어서면 0으로 초기화한다
                if(currentIndex > food_times.length-1)	currentIndex = 0;

            }
        }

        // Step5. 인덱스는 0부터 시작하므로 1증가시킨 후 return
        return ++currentIndex;
    }

}
