package lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

        int[] portNum = new int[n + 1];
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            portNum[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        for (int i = 1; i <= n; i++) {

            int prevLen = 0;
            for (int j = 1; j < i; j++) {
                // 작은 값들 중에 가장 긴 배열의 길이를 가진 값을 구한다.
                if(portNum[j] < portNum[i]){
                    prevLen = Math.max(prevLen, dp[j]);
                }
            }
            
            dp[i] = prevLen + 1;
        }

        Arrays.sort(dp);

        System.out.println(dp[n]);
    }
}
