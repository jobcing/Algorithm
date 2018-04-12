package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 4. 10..
 *
 * 백준 알고리즘 11724번 풀이 (https://www.acmicpc.net/problem/11724)
 *
 * !! 방향 없는 그래프임을 확인할 것. 따라서 u -> v 가 경로가 있으면 v -> u 도 경로가 있음 !!
 */

public class BOJ_11724 {

    private static int N;
    private static boolean[] isVisited;
    private static int[][] matrix;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        matrix = new int[N + 1][N + 1];
        isVisited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }

        int ans = 0;

        for (int i = 1; i <= N; i++) {
            if(!isVisited[i]){
                ans++;
                dfs(i);
            }
        }

        System.out.println(ans);
    }

    private static void dfs(int i){
        isVisited[i] = true;

        for (int j = 1; j <= N; j++) {
            if(matrix[i][j] == 1 && !isVisited[j]){
                dfs(j);
            }
        }
    }
}
