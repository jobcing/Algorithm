package dp;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2017. 10. 27..
 *
 * 백준 알고리즘 1912번 풀이 (https://www.acmicpc.net/problem/1912)
 *
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

        int result = -1000;

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(numlist[i], dp[i - 1] + numlist[i]);
            result = Math.max(dp[i], result);
        }

        result = Math.max(result, dp[0]);

        System.out.println(result);
    }
}
