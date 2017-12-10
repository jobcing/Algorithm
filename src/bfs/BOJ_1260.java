package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by ByeongChan on 2017. 12. 10..
 *
 * 백준 알고리즘 1260번 문제풀이 (https://www.acmicpc.net/problem/1260)
 *
 */
public class BOJ_1260 {

    // 노드 방문 여부
    private static boolean[] isVisited = new boolean[1001];

    // 인접행렬로 그래프 표현
    private static int[][] graph = new int[1001][1001];

    // 노드 개수
    private static int N;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        int M = scan.nextInt();
        int V = scan.nextInt();

        for (int i = 0; i < M; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();

            graph[a][b] = graph[b][a] = 1;
        }

        dfs(V);

        // 노드 방문 여부 초기화
        for (int i = 0; i < N; i++) {
            isVisited[i] = false;
        }

        System.out.println();

        bfs(V);
    }

    // 깊이 우선 탐색
    private static void dfs(int i){
        isVisited[i] = true;
        System.out.println(i + " ");

        for (int j = 1; j <= N; j++) {
            if(graph[i][j] == 1 && !isVisited[j]){
                dfs(j);
            }
        }
    }

    // 너비 우선 탐색
    private static void bfs(int i){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(i);

        while(!queue.isEmpty()){
            i = queue.poll();
            System.out.println(i + " ");
            isVisited[i] = true;

            for (int j = 1; j <= N; j++) {
                if(!isVisited[j] && graph[i][j] == 1){
                    isVisited[j] = true;
                    queue.offer(j);
                }
            }
        }
    }
}
