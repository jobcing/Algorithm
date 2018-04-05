package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 4. 5..
 *
 * 백준 알고리즘 2110번 풀이 (https://www.acmicpc.net/problem/2110)
 *
 * 파라메트릭 서치 알고리즘을 적용
 *
 * !! 파라메트릭 서치 : 이진 탐색을 응용한 탐색 알고리즘 !!
 * !! Parametric Search = Binary Search + YES/NO Problem !!
 */

public class BOJ_2110 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] houseCoord = new int[N];

        for (int i = 0; i < N; i++) {
            houseCoord[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houseCoord);

        int left = 1; // 가능한 최소거리
        int right = houseCoord[N - 1] - houseCoord[0]; // 가능한 최대거리

        int d = 0; // 간격
        int ans = 0;

        while(left <= right){
            int mid = (left + right) / 2; // 기준
            int start = houseCoord[0]; // 가장 왼쪽인 houseCoord[0] 좌표에는 공유기가 설치되어있다고 생각. 여기가 공유기 설치하는 시작점
            int cnt = 1; // 시작점에 이미 공유기가 한대 설치되어있으므로 1

            for (int i = 1; i < N; i++) {
                d = houseCoord[i] - start; // 공유기가 설치되어있는 곳과 현재의 간격

                if (d >= mid) { // 그 간격이 기준을 넘는다면 카운트
                    cnt++;
                    start = houseCoord[i]; // 공유기 설치 장소 변경
                }
            }

            // 만약 공유기 개수가 설치 가능횟수보다 크거나 같으면 기준을 수정
            if(cnt >= C){
                ans = mid;
                left = mid + 1;
            }
            // 만약 공유기 개수가 적다면 기준 수정
            else{
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
