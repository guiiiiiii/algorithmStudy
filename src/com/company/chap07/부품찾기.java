package com.company.chap07;

import com.sun.org.apache.xerces.internal.xs.datatypes.XSDateTime;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class 부품찾기 {
    public static void main(String[] args) {
        /****
         * HashSet과 TreeSet이 있음
         *
         * Set 인터페이스를 구현한 클래스로써 객체를 중복해서 저장할 수 없고 저장 순서가 유지되지 않음
         * HashSet : 데이터의 삽입과 삭제에 우수한 성능을 보임
         * TreeSet : 이진탐색 트리구조로 되어있어 HashSet에 비해 우수한 데이터 정렬, 탐색성능을 보임
         *
         * TreeSet 선언 방법
         * TreeSet<Collection ? > tree = new TreeSet();
         * TreeSet<Collection ? > tree = new TreeSet(Arrays.asList());
         */

       /* Scanner sc = new Scanner(System.in);
        System.out.println("정수 n을 입력하세요");
        int n = Integer.parseInt(sc.nextLine());

        System.out.println("공백을 기준으로 가게에 존재하는 부품번호를 입력하세요");
        String str_n = sc.nextLine();

        System.out.println("정수 m을 입력하세요");
        int m = Integer.parseInt(sc.nextLine());

        System.out.println("공백을 기준으로 손님이 요청하는 부품 번호를 입력하세요");
        String str_m = sc.nextLine();*/

        int n = 5;
        String str_n = "8 3 7 9 2";
        int m = 3;
        String str_m = "5 7 9";

        String result = "";

        // Step1. 가게에 존재하는 부품을 이진트리로 생성
        TreeSet<Integer> stockTree = new TreeSet<Integer>();

        Arrays.stream(str_n.split(" ")).forEach( (String tempstr) ->{
            stockTree.add(Integer.parseInt(tempstr));
        } );

        System.out.println(stockTree.contains(7));

        // Step2. 손님이 주문하고자 하는 부품을 반복문을 사용하여 검색
        Arrays.stream(str_m.split(" ")).forEach( (String custom) -> {
            int customStock = Integer.parseInt(custom);
            String flag = (stockTree.contains(customStock) == true) ? "yes" : "no";
            System.out.print(flag + " ");

        } );

        System.out.println(result);
    }
}
