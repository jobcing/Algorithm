package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 4. 6..
 *
 * 백준 알고리즘 2805번 풀이 (https://www.acmicpc.net/problem/2805)
 *
 * 파라메트릭 서치를 이용한 풀이
 */

public class BOJ_2805 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        // 가장 큰 값을 right, 가장 작은 값을 left로 설정 후에 반씩 잘라가며 결과값을 도출한다 --> binary search 원리 이용
        // 톱의 높이를 가장 높게 설정할 수 있는 경우는 나무 중 가장 큰 값
        int right = trees[N - 1];
        // 톱의 높이를 가장 낮게 설정할 수 있는 경우는 1
        int left = 1;

        // 최종 결과를 저장할 변수
        int ans = 0;

        while(left <= right){

            long sum = 0;
            int mid = (left + right) / 2; // 기준값을 구한다

            for (int i = 0; i < trees.length; i++) {
                sum += trees[i] - mid > 0 ? trees[i] - mid : 0;
            }

            // 만약 총합이 M보다 크다면 기준 값을 올려도 되므로
            // 기준 값을 올려준다.
            // 기준 값을 올리려면 최소값을 mid + 1로 해주면 된다.
            if(sum >= M){
                ans = mid;
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
