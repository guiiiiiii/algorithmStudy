package com.company.chap11;

import java.util.*;

public class Ex1106 {

    // priority queue를 사용하기 위해 inner class 작성
    public static class Food implements Comparable<Food>{
        private int index;          // 음식의 배열 index
        private int totalTime;      // 음식 다먹는데 소요되는 시간

        public Food(int index, int totalTime){
            this.index = index;
            this.totalTime = totalTime;
        }

        public int getIndex() {
            return index;
        }

        public int getTotalTime(){
            return totalTime;
        }

        public void setTotalTime(int totalTime) {
            this.totalTime = totalTime;
        }

        @Override
        public int compareTo(Food o) {
            // 우리는 음식의 총 섭취시간이 작은것이 우선순위가 높으므로 아래와같이 반환
            if(this.totalTime < o.getTotalTime())       return -1;
            else if(this.totalTime == o.getTotalTime()) return 0;
            else                                        return 1;
        }
    }
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

        //int result = solution(food_times, k);
        int result = solutionWithAnswer(food_times, k);
        System.out.println("Ex11 06의 결과값은 >>> "+result);
    }

    // 해설 보고 풀어본 풀이
    public static int solutionWithAnswer(int[] food_times, int k){
        // 마지막까지 효율성 0점이 나온 이유는 int형으로 사용했기 때문
        // 문제에서 주어진 k의 값이 2*10^13인데 이는 int형의 max value인 2^13-1을 넘어서기 때문에 long으로 사용해야한다
        long totalSum = 0;

        // Step1. 우선순위 큐 생성
        PriorityQueue<Food> foodQueue = new PriorityQueue<>();

        // Step2. 큐에 주어진 음식 배열 삽입
        for(int index=0; index<food_times.length; index++){
            foodQueue.add(new Food(index+1,food_times[index]));

            // Step3. 주어진 음식배열의 움식을 다 먹으면 몇초가 소요되는지 계산한다
            totalSum += food_times[index];
        }

        // Step4. 주어진 음식 배열의합보다 k가 같거나 크면 -1을 반환한다
        if(totalSum <= k) return -1;
        else {

            totalSum = 0;                    // 먹기위해 사용한시간
            long previous = 0;               // 직전에 다 먹은 음식시간
            long length = food_times.length; //남은 음식의 개수

            // Step5. foodQueue에서 가장 우선순위가 높은(먹는시간이 적은) 음식을 꺼낸다
            //          이 음식을 다먹는 데에 소요되는 시간은 { foodQueue의 길이 * (이 음식을 먹는데에 소요되는시간 -지금까지 먹은 음식회전수) }
            while (k >= totalSum + (foodQueue.peek().getTotalTime() - previous) *length) {
                // Step6. 가장 우선순위가 높은 음식을 다 먹는데에 소요되는 시간이 k보다 작은 경우는 이 음식을 다 먹을 수 있다는 것
                int now = foodQueue.poll().getTotalTime();
                totalSum += (now - previous) *length;
                length -= 1;
                previous = now;

            }

            // Step8. 그렇지 않은 경우는 한바퀴 돌지 못하는 경우이므로 index순서대로 임시 배열에 넣는다
            ArrayList<Food> foodArr = new ArrayList<>();
            while (!foodQueue.isEmpty()) {
                foodArr.add(foodQueue.poll());
            }

            // Step9. 임시 배열을 index순으로 정렬
            Collections.sort(foodArr, new Comparator<Food>() {
                @Override
                public int compare(Food o1, Food o2) {
                    return Integer.compare(o1.getIndex(), o2.getIndex());
                }
            });

            // Step10. 남은 k만큼
            return  foodArr.get((int)((k-totalSum) % length)).getIndex();
        }


    }
    
    // 내가 한 풀이 (카카오 코테 28점나옴..)
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
