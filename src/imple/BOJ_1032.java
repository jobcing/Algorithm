package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ByeongChan on 2018. 3. 13..
 *
 * 백준 알고리즘 1032번 풀이 (https://www.acmicpc.net/problem/1032)
 *
 * 길이가 같은 문자열 N개에서 공통 부분 문자 뽑아내는 문제
 */

public class BOJ_1032 {

    private static final String DIFF = "?";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] filenames = new String[N];

        for (int i = 0; i < N; i++) {
            filenames[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < filenames[0].length(); i++) {
            // 기준이 되는 문자
            char compareChar = filenames[0].charAt(i);
            boolean flag = true;

            for (int j = 1; j < N; j++) {
                // 다를 경우 반복문 탈출
                if(compareChar != filenames[j].charAt(i)){
                    flag = false;
                    break;
                }
            }

            if(flag){
                sb.append(compareChar);
            } else{
                sb.append(DIFF);
            }
        }

        System.out.println(sb.toString());
    }
}
