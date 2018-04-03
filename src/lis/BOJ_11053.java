package lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 4. 3..
 *
 * 백준 알고리즘 11053번 풀이 (https://www.acmicpc.net/problem/11053)
 *
 * 가장 긴 증가하는 부분 수열 구하는 문제 (LIS)
 */

public class BOJ_11053 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] list = new int[N + 1];
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 탐색
        for (int i = 1; i <= N; i++) {
            
            int prevLen = 0;
            // i인덱스의 값보다 작은 값을 탐색
            for (int j = 1; j < i; j++) {
                if(list[i] > list[j]){
                    // 현재 i인덱스보다 작은 값들을 탐색하고 그 중에서 가장 긴 배열의 길이를 가지고 있는
                    // 배열의 길이를 저장한다.
                    prevLen = Math.max(prevLen, dp[j]);
                }
            }

            // i인덱스 값이 가장 긴 배열에 포함되므로 + 1
            dp[i] = prevLen + 1;
        }
        // 배열의 길이가 저장된 리스트 dp
        // 가장 긴 배열의 길이를 구하기 위해 sort
        Arrays.sort(dp);

        System.out.println(dp[N]);
    }
}
