package com.company.chap06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 삽입정렬 구현
public class InsertionSort {
    public static void main(String[] args) {
        Integer[] array = new Integer[] {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        ArrayList<Integer> arrayList = new ArrayList<>();

        Collections.addAll(arrayList, array);


        // 첫번째 데이터는 정렬이 되어있다고 가정
        for(int index = 1; index < arrayList.size(); index++){
            int minIndex = index;
            //앞 데이터와 비교하며 현재 데이터의 위치를 결정한다
            for(int compare = index-1; compare>=0; compare--){
                if(arrayList.get(index) < arrayList.get(compare)){
                    minIndex = compare;
                }
            }
            if(index != minIndex){
                int minVal = arrayList.remove(index);
                arrayList.add(minIndex, minVal);
            }
        }

        System.out.println(Arrays.toString(arrayList.toArray()));
    }
}
