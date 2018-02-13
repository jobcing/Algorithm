package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ByeongChan on 2018. 2. 13..
 *
 * 백준 알고리즘 4948번 풀이 (https://www.acmicpc.net/problem/4948)
 *
 * 입력 값 n과 2n 사이에 있는 소수의 개수 찾는 문제
 *
 * !! dp를 이용해서 소수 찾기 !!
 */

public class BOJ_4948 {

    // final static NEW LINE String
    private final static String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[123457 * 2];

        // init dp
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        // 0 : not prime number, 1 : prime number
        dp[0] = 0;
        dp[1] = 0;

        // find prime number
        for (int i = 2; i < dp.length; i++) {
            for (int j = 2; i * j < dp.length; j++) {
                dp[i * j] = 0;
            }
        }

        // init n
        int n = -1;

        // init cnt
        int cnt = 0;

        // result save variable
        StringBuilder sb = new StringBuilder();

        // repeat until n = 0
        while(true){
            n = Integer.parseInt(br.readLine());

            if(n == 0){
                break;
            }

            cnt = 0;

            // prime number count
            for (int i = (n + 1); i <= (2 * n); i++) {
                if(dp[i] == 1){
                    cnt++;
                }
            }

            sb.append(cnt);
            sb.append(NEW_LINE);
        }

        br.close();

        System.out.println(sb.toString());
    }
}
