package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 3. 19..
 *
 * 백준 알고리즘 1550번 풀이 (https://www.acmicpc.net/problem/1550)
 *
 * 16진수 -> 10진수 변환 문제
 */

public class BOJ_1550 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String hexStr = scan.nextLine();

        int decimalNum = 0;

        for (int i = hexStr.length() - 1; i >= 0; i--) {
            // 우선 char -> int 를 통해 10진수를 구하고 9가 넘어간다면 10을 더해준다
            decimalNum += ((hexStr.charAt(i) <= '9') ? hexStr.charAt(i) - '0' : hexStr.charAt(i) - 'A' + 10)
                    * Math.pow(16, hexStr.length() - 1 - i);
        }

        System.out.println(decimalNum);
    }
}
