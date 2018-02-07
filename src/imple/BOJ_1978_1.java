package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 2. 7..
 *
 * 백준 알고리즘 1978번 2번째 풀이 방법 (https://www.acmicpc.net/problem/1978)
 *
 * !! dp를 이용해서 소수 찾기 !!
 */

public class BOJ_1978_1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[1001];
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // find prime number
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        // 0 : not prime number, 1 : prime number
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < dp.length; i++) {
            for (int j = 2; i * j < dp.length; j++) {
                dp[i * j] = 0;
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(dp[num] == 1){
                ans++;
            }
        }

        br.close();

        System.out.println(ans);
    }
}
