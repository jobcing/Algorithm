package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 1. 9..
 *
 * 백준 알고리즘 11399번 풀이 (https://www.acmicpc.net/problem/11399)
 */
public class BOJ_11399 {
    private static final char SPACE = ' ';
    private static final char NEW_LINE = '\n';

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(P);

        int[] dp = new int[N];
        dp[0] = P[0];

        for (int i = 1; i < N; i++) {
            dp[i] = dp[i - 1] + P[i];
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum = sum + dp[i];
        }

        System.out.println(sum);
    }
}
