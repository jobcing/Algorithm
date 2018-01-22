package lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 1. 21..
 *
 * 백준 알고리즘 2352번 풀이 (https://www.acmicpc.net/problem/2352)
 *
 * 연결선이 겹치지 않으면서 최대 몇개까지 연결할 수 있는지 묻는 문제
 * lis 알고리즘인 것을 알아채는 것이 중요 !
 *
 * !! LIS 알고리즘 : 수열에서 존재하는 모든 증가 수열 중 길이가 최대인 수열을 찾는 것 !!
 */

public class BOJ_2352 {

    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] portNum = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            portNum[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        // 최소값으로 초기화
        int max = 0;

        // dp로 LIS 알고리즘 구현
        // dp[x] : x번째에서 최장 수열 길이
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                // 수는 당연히 커야하고 배열의 길이까지 체크해주어야 한다
                if(portNum[i] > portNum[j] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
