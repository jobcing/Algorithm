package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 22..
 *
 * 백준 알고리즘 9372번 풀이 (https://www.acmicpc.net/problem/9372)
 *
 * 최소 스패닝 트리 간선의 개수를 구하는 문제
 * !! 간선의 개수 : N - 1 !!
 */

public class BOJ_9372 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            while(M-- > 0){
                br.readLine();
            }

            // 타야할 비행기의 개수는 최소 스패닝 트리의 간선의 개수와 같다.
            // N - 1
            sb.append(N - 1).append(NEW_LINE);
        }

        System.out.println(sb.toString());
    }
}
