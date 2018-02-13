package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 2. 13..
 *
 * 백준 알고리즘 1076번 풀이 (https://www.acmicpc.net/problem/1076)
 *
 * !! int의 최대 값은 21억 !!
 */

public class BOJ_1076 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] resistance = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

        // 최대 결과 값이 Integer 최대값을 벗어나므로 타입을 long으로
        long ans = 0;
        int squareValue = 0;

        String input1 = scan.nextLine();
        String input2 = scan.nextLine();
        String input3 = scan.nextLine();

        for (int i = 0; i < resistance.length; i++) {
            // 10의 자리
            if(input1.equals(resistance[i])){
                ans += i * 10;
            }
            // 1의 자리
            if(input2.equals(resistance[i])){
                ans += i;
            }
            // 제곱 값을 구한다.
            if(input3.equals(resistance[i])){
                squareValue = i;
            }
        }

        ans *= Math.pow(10, squareValue);

        System.out.println(ans);
    }
}
