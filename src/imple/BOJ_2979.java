package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 4. 6..
 *
 * 백준 알고리즘 2979번 풀이 (https://www.acmicpc.net/problem/2979)
 *
 * 3대의 트럭이 존재. 겹치는 시간에 따라 요금이 달라진다. 최종 주차요금을 구하는 문제.
 */

public class BOJ_2979 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] list = new int[101];

        int min = 101;
        int max = 0;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            min = Math.min(min, s);
            max = Math.max(max, d);

            for (int j = s; j < d; j++) {
                list[j]++;
            }
        }

        int ans = 0;

        for (int i = min; i <= max; i++) {
            if(list[i] == 3){
                ans += (C * list[i]);
            } else if(list[i] == 2){
                ans += (B * list[i]);
            } else if(list[i] == 1){
                ans += (A * list[i]);
            } else{
                continue;
            }
        }

        System.out.println(ans);
    }
}
