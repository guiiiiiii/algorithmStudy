package com.company.chap07;

import java.util.Arrays;

public class 부품찾기with이진탐색 {
    public static void main(String[] args) {
        int n = 5;
        String str_n = "8 3 7 9 2";
        int m = 3;
        String str_m = "5 7 9";

        // Step1. 매장재고를 정렬된 arr로 만든다
        Integer[] stockArr = Arrays.stream(str_n.split(" ")).mapToInt(Integer::parseInt).boxed().sorted().toArray(Integer[]::new);

        Arrays.stream(str_m.split(" ")).forEach((String customerAsk) -> {
            System.out.print(checkisExist(stockArr, customerAsk)+" ");
        });
    }

    static public String checkisExist(Integer[] stockArr, String customerAsk){
        int customer = Integer.parseInt(customerAsk);
        int startIndex = 0;
        int endIndex = stockArr.length-1;

        while(true){
            if(startIndex > endIndex) break;
            int mediumIndex = (startIndex+endIndex)/2;

            if(customer < stockArr[mediumIndex]){
                endIndex = mediumIndex-1;
            }else if(customer > stockArr[mediumIndex]){
                startIndex = mediumIndex+1;
            }else{
                return "yes";
            }
        }

        return "no";
    }
}
