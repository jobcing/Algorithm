package dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ByeongChan on 2017. 10. 27..
 *
 * 백준 알고리즘 1912번 풀이 (https://www.acmicpc.net/problem/1912)
 *
 * 가장 큰 연속합 구하기 문제
 * Dynamic Programming
 * Math.max
 */
public class BOJ_1912 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] numlist = new int[n];

        for (int i = 0; i < n; i++) {
            numlist[i] = scan.nextInt();
        }

        int[] dp = new int[n];
        dp[0] = numlist[0];

        for (int i = 1; i < n; i++) {
            // dp에는 i번째일때 가장 큰 연속 합이 저장
            dp[i] = Math.max(numlist[i], dp[i - 1] + numlist[i]);
        }

        // 가장 큰 연속 합을 구해야하므로 오름차순 정렬
        Arrays.sort(dp);

        // 가장 큰 값 출력
        System.out.println(dp[n - 1]);
    }
}
