package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by ByeongChan on 2018. 3. 12..
 *
 * 백준 알고리즘 5719번 풀이 (https://www.acmicpc.net/problem/5719)
 */

public class BOJ_5719 {

    private static final int INF = 100000000;
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            int[][] weight = new int[N][N];
            int[] dist = new int[N];

            // init
            for (int i = 0; i < N; i++) {
                Arrays.fill(weight[i], INF);
                dist[i] = INF;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int U = Integer.parseInt(st.nextToken());
                int V = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());

                weight[U][V] = P;
            }

            // 다익스트라 알고리즘으로 최단 경로를 구한다.
            dijkstra(weight, dist, N, S, D);

            removeShortestPath(weight, dist, N, S, D);

            for (int i = 0; i < N; i++) {

                dist[i] = INF;
            }

            dijkstra(weight, dist, N, S, D);

            sb.append(dist[D] == INF ? -1 : dist[D]).append(NEW_LINE);
        }

        br.close();

        System.out.println(sb.toString());
    }
    private static void dijkstra(int[][] weight, int[] dist, int N, int S, int D) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(S, 0));

        dist[S] = 0;

        while(!pq.isEmpty()){
            Node u = pq.poll();

            if(dist[u.node] < u.dist) continue;
            if(u.node == D) break;

            // 탐색
            for (int adjNode = 0; adjNode < N; adjNode++) {

                if(weight[u.node][adjNode] != INF){

                    if(dist[adjNode] > u.dist + weight[u.node][adjNode]){
                        dist[adjNode] = u.dist + weight[u.node][adjNode];
                        pq.add(new Node(adjNode, dist[adjNode]));
                    }
                }
            }
        }
    }

    private static void removeShortestPath(int[][] weight, int[] dist, int N, int S, int D){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(D);

        while(!queue.isEmpty()){
            int j = queue.poll();

            for (int i = 0; i < N; i++) {
                if(dist[j] == dist[i] + weight[i][j]){
                    weight[i][j] = INF;
                    queue.add(i);
                }
            }
        }
    }

    private static class Node implements Comparable<Node>{
        int node;
        int dist;

        public Node(int node, int dist){
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o){
            return this.dist < o.dist ? -1 : 1;
        }
    }
}
