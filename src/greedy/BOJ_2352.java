package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 1. 21..
 *
 * 백준 알고리즘 2352번 풀이 (https://www.acmicpc.net/problem/2352)
 *
 * 연결선이 겹치지 않으면서 최대 몇개까지 연결할 수 있는지 묻는 문제
 */

public class BOJ_2352 {

    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] portNum = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            portNum[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        // 최소값으로 초기화
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int endPoint = -1;
            int temp = 0;

            for (int j = i; j < n; j++) {
                if(portNum[j] > endPoint){
                    temp++;
                    endPoint = portNum[j];
                }
            }

            ans = Math.max(ans, temp);
        }

        System.out.println(ans);
    }
}
