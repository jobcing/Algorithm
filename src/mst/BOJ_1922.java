package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 22..
 *
 * 백준 알고리즘 1922번 풀이 (https://www.acmicpc.net/problem/1922)
 *
 * !! MST 문제. 크루스칼 알고리즘 이용 !!
 */

public class BOJ_1922 {
    // i의 루트 노드 저장하는 배열
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Edge[] edges = new Edge[M];
        parent = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(x, y, cost);
        }

        br.close();

        // 자기 자신을 가르키도록 루트 노드 초기화
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 가중치 기준으로 정렬
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost - o2.cost;
            }
        });

        // 결과값 저장하는 변수
        int ans = 0;

        // find-union
        for (int i = 0; i < M; i++) {
            // 루트 노드를 찾는다
            int rootX = findRoot(edges[i].x);
            int rootY = findRoot(edges[i].y);

            if(rootX == rootY){
                continue;
            } else{
                // 루트 노드가 다르다면 같은 집합이 아니므로 union
                parent[rootX] = rootY;
                ans += edges[i].cost;
            }
        }

        System.out.println(ans);
    }

    private static int findRoot(int n){
        if(n == parent[n]){
            return n;
        }

        return findRoot(parent[n]);
    }

    private static class Edge{
        int x;
        int y;
        int cost;

        public Edge(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
