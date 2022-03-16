package com.company.chap07;

import java.util.Arrays;

public class 떡볶이떡만들기 {
    public static void main(String[] args) {
        String ricecake_and_height = "4 6";
        String ricecake_str = "19 15 10 17";

        int ricecakeCnt = Integer.parseInt(ricecake_and_height.split(" ")[0]);
        int height = Integer.parseInt(ricecake_and_height.split(" ")[1]);

        Integer[] heightArr = Arrays.stream(ricecake_str.split(" ")).mapToInt(Integer::parseInt).boxed().sorted().toArray(Integer[]::new);

        System.out.println("결과 >>> "+findMaxHdight(heightArr,height));
    }

    static public int findMaxHdight(Integer[] heightArr, int height){
        int mid = (0+heightArr[heightArr.length-1])/2;
        int prev = 0;

        while(true){
            int compare = 0;

            for(int index = 0; index< heightArr.length; index++){
                compare += (heightArr[index]-mid < 0) ? 0 : heightArr[index]-mid;
            }

            if(compare >= height){
                prev = mid;
                mid++;
            }else if(compare < height){
                break;
            }
        }

        return prev;
    }
}
