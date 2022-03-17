package com.company.chap15;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Ex30가사검색 {
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        System.out.println("test>> "+(int)"a".charAt(0));

        int[] result = solution(words, queries);

        System.out.println(Arrays.toString(result));
    }

    static public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        int count = 0;
        // Step1. queries를 순회하며 첫 인자부터 check한다
        for(int arrIndex = 0; arrIndex < queries.length; arrIndex++){
            String query = queries[arrIndex];
            int index;                  // ?의 최소(최대) 위치 인덱스
            boolean isStartswith;       // ?가 앞에 있늕 뒤에있는지 체크하는 변수
            count = 0;

            // Step2. 앞에 ?가 있는지 뒤에?가 있는지 체크한 뒤, 가작 작은(가장 큰) 인덱스를 구한다
            if(query.startsWith("?")){
                isStartswith = true;
                index = findUpperIndex(query.split(""), 0, query.length()-1, "?");
            } else{
                isStartswith = false;
                index = findLowerIndex(query.split(""), 0, query.length()-1, "?");
            }

            // Step3. words를 순회하며 일치여부를 check하여 count
            for(int wordIndex = 0; wordIndex < words.length; wordIndex++){
                String word = words[wordIndex];

                // Step3-1. query와 문자길이가 일치하는지 판단, 일치하지않는다면 이후 로직을 타지않고 다음 word로 넘어간다
                if(word.length() != query.length())      continue;

                // Step3-2. query와 동일하게 ?의 위치를 word에서도 제거한 뒤 같은지 비교
                if(isStartswith){
                    if(query.substring(index+1).equals(word.substring(index+1)))      count++;
                }else{
                    if(query.substring(0, index).equals(word.substring(0, index)))    count++;
                }
            }

            answer[arrIndex] = count;

        }

        return answer;
    }

    static public int findLowerIndex(String[] queryArr, int start, int end, String target){
        int mid = (start + end)/2;

        if(start > end)  return start;
        if((int)queryArr[mid].charAt(0) == (int)target.charAt(0))   return findLowerIndex(queryArr, start, mid-1, target);
        else                                                        return findLowerIndex(queryArr,mid+1, end, target);

    }

    static public int findUpperIndex(String[] queryArr, int start, int end, String target){
        int mid = (start + end)/2;

        if(start > end)  return end;
        if((int)queryArr[mid].charAt(0) == (int)target.charAt(0))   return findUpperIndex(queryArr, mid+1, end, target);
        else                                                        return findUpperIndex(queryArr, start, mid-1, target);

    }
}
