package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 18..
 *
 * 백준 알고리즘 1504번 풀이 (https://www.acmicpc.net/problem/1504)
 */

public class BOJ_1504 {
    // private static final int INF = Integer.MAX_VALUE;

    private static final int INF = 100000;

    private static int N, E;
    private static int[][] weight;
    private static int[][] dist;

    static {
        for (int i = 0; i < 3; i++) {

            Arrays.fill(dist[i], INF);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i < E; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            weight[a][b] = c;
            weight[b][a] = c;
        }

        st = new StringTokenizer(br.readLine());
        int node1 = Integer.parseInt(st.nextToken());
        int node2 = Integer.parseInt(st.nextToken());

        // 1번, node1, node2에서 각각 최단거리를 구해 dist[idx]에 순서대로 저장한다.
        dijkstra(1, 0);
        dijkstra(node1, 1);
        dijkstra(node2, 2);

        // 1번 -> node1 -> node2 -> N
        // 1번 -> node2 -> node1 -> N
        // 두 가지 경우의 수 중에 최소값을 택함
        int minCost = Math.min(dist[0][node1] + dist[1][node2] + dist[2][N], dist[0][node2] + dist[2][node1] + dist[1][N]);

        System.out.println(minCost >= INF ? -1 : minCost);
    }

    private static void dijkstra(int S, int idx) {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(S, 0));
        dist[idx][S] = 0;

        while (!pq.isEmpty()) {

            Node u = pq.poll();

            // 이미 최소값이라면 넘어간다.
            if (dist[idx][u.node] < u.dist) continue;

            for (int i = 1; i <= N; i++) {

                if (weight[u.node][i] != 0) {

                    if (dist[idx][i] > dist[idx][u.node] + weight[u.node][i]) {

                        dist[idx][i] = dist[idx][u.node] + weight[u.node][i];
                        pq.add(new Node(i, dist[idx][i]));
                    }
                }
            }
        }
    }

    private static class Node implements Comparable<Node>{
        int node;
        int dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o){
            return this.dist - o.dist;
        }
    }
}
