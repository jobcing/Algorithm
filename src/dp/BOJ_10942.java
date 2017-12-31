package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by ByeongChan on 2017. 12. 31..
 *
 * 백준 알고리즘 10942번 풀이 (https://www.acmicpc.net/problem/10942)
 *
 * 팰린드롬
 * 다이나믹 프로그래밍을 이용한 풀이
 */
public class BOJ_10942 {
    public static void main(String[] args) throws IOException{
        // Scanner scan = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];

        String line[] = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        // 배열의 부분집합이 팰린드롬인지 아닌지를 저장할 DP
        boolean[][] dp = new boolean[n][n];

        // 부분 팰린드롬 체크
        palindromCheck(arr, dp, n);

        int m = Integer.parseInt(in.readLine());

        for (int i = 0; i < m; i++) {
            line = in.readLine().split(" ");
            int s = Integer.parseInt(line[0]) - 1;
            int e = Integer.parseInt(line[1]) - 1;

            if(dp[s][e]){
                System.out.println("1");
            } else{
                System.out.println("0");
            }
        }
    }

    // 2->4 까지도 팰린드롬이면 4->2도 팰린드롬
    private static void palindromCheck(int arr[], boolean dp[][], int n){
        int i, j;

        for (i = 0; i < n; i++) {
            for (j = i; j < n; j++){
                dp[j][i] = dp[i][j] = isPalindrom(arr, i, j);
            }
        }
    }

    // s부터 시작해서 증가 & e부터 시작해서 감소시키면서 s와 e의 중간까지 검사
    private static boolean isPalindrom(int arr[], int s, int e){
        if(s < e){
            int n = s + (e - s) / 2 + (e - s) % 2; // s와 e의 중간까지만 체크

            while(s <= n){
                if(arr[s++] != arr[e--]) return false;
            }
        }

        return true;
    }
}
