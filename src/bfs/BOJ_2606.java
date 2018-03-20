package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 20..
 *
 * 백준 알고리즘 2606번 풀이 (https://www.acmicpc.net/problem/2606)
 */

public class BOJ_2606 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        int[][] matrix = new int[N + 1][N + 1];
        boolean[] isVisited = new boolean[N + 1];

        StringTokenizer st = null;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            matrix[a][b] = 1;
            matrix[b][a] = 1;
        }

        br.close();

        bfs(matrix, isVisited, N, 1);

        // 감염된 컴퓨터 개수 count
        int cnt = 0;

        for (int i = 0; i < isVisited.length; i++) {
            if(isVisited[i]) cnt++;
        }

        // 1번 컴퓨터 개수 빼줌
        System.out.println(cnt - 1);
    }

    private static void bfs(int[][] matrix, boolean[] isVisited, int N, int S){
        Queue<Integer> q = new LinkedList<>();

        q.add(S);
        isVisited[S] = true;

        while(!q.isEmpty()){
            int V = q.poll();

            for (int i = 1; i <= N; i++) {
                if(matrix[V][i] == 1 && !isVisited[i]){
                    q.offer(i);
                    isVisited[i] = true;
                }
            }
        }
    }
}
