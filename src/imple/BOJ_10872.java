package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ByeongChan on 2018. 2. 6..
 *
 * 백준 알고리즘 10872번 풀이 (https://www.acmicpc.net/problem/10872)
 *
 * 팩토리얼 구현 문제
 */

public class BOJ_10872 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        br.close();

        int ans = 1;
        for (int i = n; i > 0; i--) {
            ans *= i;
        }

        System.out.println(ans);
    }
}
