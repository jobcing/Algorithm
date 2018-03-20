package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ByeongChan on 2018. 3. 20..
 *
 * 백준 알고리즘 3460번 풀이 (https://www.acmicpc.net/problem/3460)
 *
 * 10진수 -> 2진수로 변환 뒤 1의 위치를 출력하는 문제
 */

public class BOJ_3460 {

    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            solve(N);

            sb.append(NEW_LINE);
        }

        System.out.println(sb.toString());
    }

    private static void solve(int N){
        int idx = 0;

        while(N >= 1){
            if(N % 2 == 1){
                sb.append(idx).append(SPACE);
            }

            N /= 2;
            idx++;
        }
    }
}
