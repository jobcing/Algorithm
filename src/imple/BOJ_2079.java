package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2017. 9. 21..
 *
 * 백준 알고리즘 2079번 풀이 (https://www.acmicpc.net/problem/2079)
 *
 * 팰린드롬(palindrome)
 */
public class BOJ_2079 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputStr = scan.nextLine();
        int palinCnt = 0;
        int palinCnt2 = 0;

        int start = 0;
        int end = inputStr.length();

        while(start < inputStr.length()){
            if(!palinCheck(inputStr.substring(start, end))){
                end--;
            } else{
                start = end;
                end = inputStr.length();
                palinCnt++;
            }
        }

        start = 0;
        end = inputStr.length();

        while(end > 0){
            if(!palinCheck(inputStr.substring(start, end))){
                start++;
            } else{
                end = start;
                start = 0;
                palinCnt2++;
            }
        }

        System.out.println(Math.min(palinCnt2, palinCnt));
    }

//    private static boolean palinCheck(String str){
//        int m = str.length() / 2;
//
//        for (int i = 0; i <= m; i++) {
//            if(str.charAt(i) != str.charAt(str.length() - 1 - i)){
//                return false;
//            }
//        }
//
//        return true;
//    }

    private static boolean palinCheck(String str){
        String reverseStr = (new StringBuffer(str)).reverse().toString();

        if(str.equals(reverseStr)){
            return true;
        } else{
            return false;
        }
    }
}
