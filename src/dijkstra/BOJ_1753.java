package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 13..
 *
 * 백준 알고리즘 1753번 풀이 (https://www.acmicpc.net/problem/1753)
 *
 * 최단 경로 구하는 문제
 *
 * !! 우선순위 큐를 이용하여 다익스트라 알고리즘 구현 !!
 * !! N * N 크기의 배열을 쓰면 런타임 에러가 발생한다. !!
 * !! ArrayList 배열을 이용하여 연결된 노드만 추가하여 가중치 그래프를 구성한다. !!
 */

public class BOJ_1753 {

    private static final int INF = Integer.MAX_VALUE;
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 정점 개수와 간선 개수를 입력받음
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        // 시작점
        int S = Integer.parseInt(br.readLine());

        // int[][] weight = new int[N + 1][N + 1];
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        int[] dist = new int[N + 1];

        // init
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<Node>());
            dist[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(u).add(new Node(v, w));
        }

        dijkstra(list, dist, S, N);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < dist.length; i++) {
            if(dist[i] == INF){
                sb.append("INF");
            } else{
                sb.append(dist[i]);
            }

            sb.append(NEW_LINE);
        }

        System.out.println(sb.toString());
    }

    private static void dijkstra(ArrayList<ArrayList<Node>> list, int[] dist, int S, int N){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[S] = 0;
        pq.offer(new Node(S, 0));

        while(!pq.isEmpty()){

            Node u = pq.poll();
            // 이미 최소값을 가지고 있기 때문에 탐색할 필요가 없는 경우
            if(dist[u.node] < u.dist) continue;

            // 연결되있는 노드만을 탐색
            for (Node adjNode : list.get(u.node)){
                // 이미 가지고 있는 경로보다 u 정점을 거쳐서 가는 경우가 최소값을 가질 경우
                if(dist[adjNode.node] > adjNode.dist + u.dist){
                    dist[adjNode.node] = adjNode.dist + u.dist;
                    pq.offer(new Node(adjNode.node, dist[adjNode.node]));
                }
            }

//            for (int adjNode = 1; adjNode <= N; adjNode++) {
//
//                if(weight[u.node][adjNode] != INF){
//
//                    if(dist[adjNode] > weight[u.node][adjNode] + u.dist){
//                        dist[adjNode] = weight[u.node][adjNode] + u.dist;
//                        pq.add(new Node(adjNode, dist[adjNode]));
//                    }
//                }
//            }
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
