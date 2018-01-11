package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 1. 11..
 *
 * 백준 알고리즘 11047번 풀이 (https://www.acmicpc.net/problem/11047)
 *
 * N개의 동전의 종류를 가지고 K원을 만들 수 있는 동전의 최소 개수를 구하는 문제
 * 대표적인 greedy 알고리즘 문제
 */
public class BOJ_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        // 코인 개수
        int cnt = 0;

        for (int i = (N - 1); i > -1; i--) {
            if(K >= coins[i]){
                cnt = cnt + (K / coins[i]);
                K = K % coins[i];
            }
        }

        System.out.println(cnt);
    }
}
