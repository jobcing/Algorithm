package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 2. 26..
 *
 * 백준 알고리즘 10809번 풀이 (https://www.acmicpc.net/problem/10809)
 *
 * !! 알파벳이 처음으로 등장하는 위치 표시하는 문제 !!
 */

public class BOJ_10809 {

    private static final String SPACE = " ";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] position = new int[26];

        for (int i = 0; i < position.length; i++) {
            position[i] = -1;
        }

        String word = scan.nextLine();

        for (int i = 0; i < word.length(); i++) {
            int wordIndex = word.charAt(i) - 'a';

            // 최초 등장인지 확인
            if(position[wordIndex] == -1){
                position[wordIndex] = i;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < position.length; i++) {
            sb.append(position[i]).append(SPACE);
        }

        System.out.println(sb.toString());
    }
}
