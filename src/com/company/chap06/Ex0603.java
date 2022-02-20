package com.company.chap06;

import java.util.*;

// 성적이 낮은 순서로 학생 출력하기
public class Ex0603 {
    public static void main(String[] args) {
        /*****
         * N명의 학생 정보가 있을 때 학생 정보는 학생의 이름과 학생의 성적으로 구분된다
         * 이 정보가 있을 때 성적이 낮은 순서대로 학생의 일므을 출력하는 프로그램 작성
         */

        Scanner sc = new Scanner(System.in);
        System.out.println("몇명인지 입력 >> ");
        int n = Integer.parseInt(sc.nextLine());

        ArrayList<Integer> score = new ArrayList<>();
        HashMap<Integer, ArrayList<String>> stuInfo = new HashMap<>();

        for(int i=0; i<n; i++){
            System.out.println("학생 정보를 공백을 기준으로 이름과 점수 입력 >> ");
            String info = sc.nextLine();

            String name = info.split(" ")[0];
            int studentScore = Integer.parseInt(info.split(" ")[1]);

            //점수를 점수 arr에 넣고 점수를 key로 하는 map에 이름을 insert
            if(score.indexOf(studentScore) < 0){
                score.add(studentScore);
            }
            ArrayList<String> nameList = stuInfo.getOrDefault(studentScore, new ArrayList<String>());

            nameList.add(name);
            stuInfo.put(studentScore, nameList);
        }

        Collections.sort(score);

        for(int i : score){
            ArrayList<String> temparr = stuInfo.get(i);
            for(String name : temparr){
                System.out.print(name+" ");
            }
        }
    }
}
