package com.company.chap12;

import java.util.HashMap;
import java.util.Scanner;

public class Ex1209 {
    /******
     * 문자열 압축
     * 압축할 문자열 s가 주어질 떄
     * 1개 이상단위로 문자열을 잘라 압축하여 표현할 문자열 중 가장 짧은것의 길이를 return하도록 작성
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("압축할 문자열 s입력 >>>> ");
        String s = sc.nextLine();

        int result = solution(s);
        System.out.println("Ex12 - 9의 결과값은 >> "+result);
    }

    // 문자열 s를 주면 앞에서부터 몇글자가 반복되는지 return해주는 함수
    public static int countCheckLength(String s){
        // 반복되는 글자수를 카운트해줄 변수 선언
        int checkLength = 0;

        String checkStr ="";

        // 주어진 문자열의 절반길이를 넘어선만큼은 반복될 수 없으므로 길이의 절반까지만 체크
        for(int index = 1; index <= s.length()/2; index++){
            if(s.substring(0,index).equals(s.substring(index, index*2))){
                checkStr = s.substring(0,index);
                checkLength = index;
            }
        }

        return checkLength;
    }

    // checkLength와 s를 매개변수로받아 압축한 결과를 주는 함수
    public static HashMap<String, String> makeCompression(String s, int checkLength){
        int repetition = 1;
        HashMap<String, String> result = new HashMap<>();

        while(true){
            if(s.length() >= checkLength*2 && s.substring(0,checkLength).equals(s.substring(checkLength, checkLength*2))){
                // 같은문자열이 반복되면 반복횟수를 1늘린 뒤 반복문자열을 1회분 제거한 뒤 다시 연산한다
                repetition++;
                s = s.substring(checkLength);
            }else{
                break;
            }
        }

        // repetition이 1이면 반복되는 문자열이 없으므로 숫자를 떼고 s return
        // repetition이 2이상이면 반복횟수를 앞에 붙인 뒤 s를 붙여서 return
        if(repetition == 1){
            result.put("compress", s);
            result.put("else", "");
        }else{
            result.put("compress", ""+repetition+s.substring(0,checkLength));
            result.put("else", s.substring(checkLength));
        }

        return result;
    }

    // 카카오 정합성 26점..
    public static int solution(String s) {
        int answer = 0;
        HashMap<String, String> result;

        String compressStr = "";
        String leftStr = s;

        while(leftStr.length() != 0){
            // countCheckLength의 return 즉, 반복되는 문자열의 길이가 1보다 크면 반복되는 문자열이 있는것
            int checkLength = countCheckLength(leftStr);
            if(checkLength >= 1 ){
                if(compressStr.length() > 0 && Integer.parseInt(compressStr.substring(0,1)) == checkLength){
                    compressStr += leftStr.substring(0,checkLength);
                    leftStr = leftStr.substring(checkLength);

                }else{
                    result = makeCompression(leftStr,checkLength);
                    leftStr = result.get("else");
                    compressStr+= result.get("compress");
                }
            }else{
                // 하나도 글자가 겹치는게 없는경우
                if(compressStr.length() == 0)       break;
                // 중간에 안겹치는 글자가 한글자 있는 경우
                compressStr += leftStr.substring(0,1);
                leftStr = leftStr.substring(1);
            }
        }

        answer = compressStr.length()+leftStr.length();
        System.out.println(compressStr+leftStr);
        return answer;
    }
}
