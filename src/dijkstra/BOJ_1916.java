package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 26..
 *
 * 백준 알고리즘 1916번 풀이 (https://www.acmicpc.net/problem/1916)
 *
 * 최소비용 구하는 문제
 * !! 출발지와 도착지가 명시되어 있고 최소비용을 구하는 것이므로 다익스트라 알고리즘 사용 !!
 */

public class BOJ_1916 {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> weight = new ArrayList<>();
        int[] dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            weight.add(new ArrayList<Node>());
            dist[i] = INF;
        }

        StringTokenizer st = null;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            weight.get(u).add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine(), " ");

        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        br.close();

        dijkstra(weight, dist, S);

        System.out.println(dist[D]);
    }

    private static void dijkstra(ArrayList<ArrayList<Node>> weight, int[] dist, int S){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(S, 0 ));
        dist[S] = 0;

        while(!pq.isEmpty()){
            Node u = pq.poll();

            if(dist[u.node] < u.dist) continue;

            for (Node adjNode : weight.get(u.node)){
                if(dist[adjNode.node] > adjNode.dist + u.dist){
                    dist[adjNode.node] = adjNode.dist + u.dist;
                    pq.offer(new Node(adjNode.node, dist[adjNode.node]));
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
