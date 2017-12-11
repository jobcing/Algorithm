package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by ByeongChan on 2017. 12. 10..
 *
 * 백준 알고리즘 1260번 문제풀이 (https://www.acmicpc.net/problem/1260)
 *
 * DFS (Depth First Search) 깊이우선 탐색 : 인접해 있는 노드 순으로 탐색 (재귀호출 사용)
 * BFS (Breadth First Search) 너비우선 탐색 : 가까운 정점 먼저 탐색 후 점차 한단계씩 탐색 (큐 사용)
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
        for (int i = 1; i <= N; i++) {
            isVisited[i] = false;
        }

        System.out.println();

        bfs(V);
    }

    // 깊이 우선 탐색
    private static void dfs(int i){
        isVisited[i] = true;
        System.out.print(i + " ");

        for (int j = 1; j <= N; j++) {
            if(graph[i][j] == 1 && !isVisited[j]){
                dfs(j);
            }
        }
    }

    // 너비 우선 탐색
    private static void bfs(int i){
        Queue<Integer> q = new LinkedList<Integer>();

        q.offer(i);
        isVisited[i] = true;

        while(!q.isEmpty()){
            i = q.poll();
            System.out.print(i + " ");

            for (int j = 1; j <= N; j++) {
                if(graph[i][j] == 1 && !isVisited[j]){
                    q.offer(j);
                    isVisited[j] = true;
                }
            }
        }
    }
}
