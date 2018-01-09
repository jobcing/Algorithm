package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 1. 9..
 *
 * 백준 알고리즘 11399번 풀이 (https://www.acmicpc.net/problem/11399)
 *
 * 그리디 알고리즘 : 매 순간마다 최적의 선택을 하여 정해진 목표까지 계산하는 방법
 * 누적합을 구하는방법 : p[i] * (N - i)
 */
public class BOJ_11399 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        // 소요시간 오름차순 정렬
        Arrays.sort(P);

        int sum = 0;

        for (int i = 0; i < N; i++) {
            // 누적 합은 i번째에 있는 수가 총 (N - i)번 더해진다.
            sum += P[i] * (N - i);
        }

        System.out.println(sum);
    }
}
