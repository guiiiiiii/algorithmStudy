package com.company.chap15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Ex30가사검색 {
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?", "?????"};


        int[] result = solution(words, queries);

        System.out.println(Arrays.toString(result));
    }

    static public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        int count = 0;

        ArrayList<ArrayList<String>> wordsList = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> reverseWordsList = new ArrayList<ArrayList<String>>();

        // Step1. words를 글자수대로 분류하여 관리하기위해 가능한 수만큼 arraylist를 생성해준다
        for(int i=0; i<10001; i++){
            wordsList.add(new ArrayList<>());
            reverseWordsList.add(new ArrayList<>());
        }

        // Step1. words를 글자수대로 분류하여  넣어준다
        //        이 때 ?가 앞에 있는 query면 뒤에서부터 비교하기위해 (자바 compareTo 함수는 같은 자리수부터 비교하기 때문)
        //        기본 주어진 word와 반대로 뒤집힌 reverseWord를 저장하는 map 두개를 생성해서 사용한다
        for(String word : words){
            int size = word.length();
            wordsList.get(size).add(word);

            String reversedStr = (new StringBuffer(word)).reverse().toString();
            reverseWordsList.get(size).add(reversedStr);

        }

        // Step2. 단어를 사전순으로 정렬
        for(int i=0; i<10001; i++){
            Collections.sort(wordsList.get(i));
            Collections.sort(reverseWordsList.get(i));
        }

        // Step3. queries를 순회하며 첫 인자부터 check한다
        for(int arrIndex = 0; arrIndex < queries.length; arrIndex++){
            String query = queries[arrIndex];
            count = 0;

            int upperIndex;
            int lowerIndex;

            // Step4. 앞에 ?가 있는지 뒤에?가 있는지 체크한 뒤, 가작 작은(가장 큰) 인덱스를 구한다
            if(query.startsWith("?")){
                // ?로 시작한다면 문자를 반대로 뒤집은 다음 upperindex와 lowerindex를 찾는다
                ArrayList<String> wordsArr = reverseWordsList.get(query.length());

                lowerIndex = findLowerIndex(wordsArr, (new StringBuffer(query)).reverse().toString().replaceAll("\\?", "a"), 0, wordsArr.size()-1);
                upperIndex = findUpperIndex(wordsArr, (new StringBuffer(query)).reverse().toString().replaceAll("\\?", "z"), 0, wordsArr.size()-1);

                count = upperIndex - lowerIndex +1;

            } else{
                ArrayList<String> wordsArr = wordsList.get(query.length());

                lowerIndex = findLowerIndex(wordsArr, query.replaceAll("\\?", "a"), 0, wordsArr.size()-1);
                upperIndex = findUpperIndex(wordsArr, query.replaceAll("\\?", "z"), 0, wordsArr.size()-1);

                count = upperIndex - lowerIndex +1;

            }

            answer[arrIndex] = count;

        }

        return answer;
    }

    static public int findLowerIndex(ArrayList<String> wordsArr, String target, int start, int end){
        int mid = (start + end)/2;

        if(start > end) return start;

        if(wordsArr.get(mid).compareTo(target) < 0)     return findLowerIndex(wordsArr, target, mid+1, end);
        else                                            return findLowerIndex(wordsArr, target, start, mid-1);

    }

    static public int findUpperIndex(ArrayList<String> wordsArr, String target, int start, int end){
        int mid = (start + end)/2;

        if(start > end) return end;

        if(wordsArr.get(mid).compareTo(target) > 0)     return findUpperIndex(wordsArr, target, start, mid-1);
        else                                            return findUpperIndex(wordsArr, target, mid+1, end);
    }





}
