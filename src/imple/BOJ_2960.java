package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 2. 19..
 *
 * 백준 알고리즘 2960번 풀이 (https://www.acmicpc.net/problem/2960)
 *
 * 에라토스테네의 체 구현
 **/

public class BOJ_2960 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int K = scan.nextInt();

        int[] dp = new int[N + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        
        // 0 : not prime number , 1 : prime number
        dp[0] = 0;
        dp[1] = 0;

        int cnt = 0;
        int ans = 0;

        for (int i = 2; i <= N; i++) {
            for (int j = 1; i * j <= N; j++) {
                if(dp[i * j] == 0){
                    continue;
                } else {

                    dp[i * j] = 0;
                    cnt++;

                    if (cnt == K) {
                        ans = i * j;
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
