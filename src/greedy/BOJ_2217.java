package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by ByeongChan on 2018. 1. 11..
 *
 * 백준 알고리즘 2217번 풀이 (https://www.acmicpc.net/problem/2217)
 */
public class BOJ_2217 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 로프 개수
        int n = Integer.parseInt(br.readLine());

        int[] rope = new int[n];
        // 로프가 버틸 수 있는 중량 입력
        for (int i = 0; i < n; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        // 로프 중량 정렬
        Arrays.sort(rope);

        int max = 0;
        for (int i = 0; i < n; i++) {
            // 지금 로프 중량에서 마지막 로프 중량까지의 개수를 곱한 값
            int sum = rope[i] * (n - i);

            if(sum > max){
                max = sum;
            }
        }

        System.out.println(max);
    }
}
