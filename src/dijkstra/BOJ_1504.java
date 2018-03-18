package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 18..
 *
 * 백준 알고리즘 1504번 풀이 (https://www.acmicpc.net/problem/1504)
 */

public class BOJ_1504 {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // ArrayList<ArrayList<Node>> weight = new ArrayList<>();
        int[][] weight = new int[N + 1][N + 1];
        int[][] dist = new int[3][N + 1];
//
//        for (int i = 0; i <= N; i++) {
//            weight.add(new ArrayList<Node>());
//        }

        for (int i = 0; i < 3; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

//            weight.get(a).add(new Node(b, c));
//            weight.get(b).add(new Node(a, c));
            weight[a][b] = c;
            weight[b][a] = c;
        }

        st = new StringTokenizer(br.readLine(), " ");
        int node1 = Integer.parseInt(st.nextToken());
        int node2 = Integer.parseInt(st.nextToken());

        dijkstra(weight, dist, N, 1, 0);
        dijkstra(weight, dist, N, node1, 1);
        dijkstra(weight, dist, N, node2, 2);

        int minCost = Math.min(dist[0][node1] + dist[1][node2] + dist[2][N],
                dist[0][node2] + dist[2][node1] + dist[1][N]);

        System.out.println(minCost >= INF ? -1 : minCost);
    }

    private static void dijkstra(int[][] weight, int[][] dist, int N, int S, int idx){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(S, 0));
        dist[idx][S] = 0;

        while(!pq.isEmpty()){
            Node u = pq.poll();

            if(dist[idx][u.node] < u.dist) continue;

//            for (Node adjNode : list.get(u.node)){
//                if(dist[idx][adjNode.node] > adjNode.dist + u.dist){
//                    dist[idx][adjNode.node] = adjNode.dist + u.dist;
//                    pq.offer(new Node(adjNode.node, dist[idx][adjNode.node]));
//                }
//            }
            for (int i = 1; i <= N; i++) {
                if(weight[u.node][i] != 0){
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

        public Node(int node, int dist){
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o){
            return this.dist - o.dist;
        }
    }
}
