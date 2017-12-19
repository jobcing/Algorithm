package mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2017. 10. 9..
 *
 * 백준 알고리즘 1197번 풀이 (https://www.acmicpc.net/problem/1197)
 *
 * Arrays.sort(Comparator)
 * Kruskal Algorithm
 */
public class BOJ_1197{
    // 공백 문자열
    private static final String SPACE = " ";
    // 부모 노드가 저장될 배열
    private static int[] parent;

    public static void main(String[] args) throws Exception{
        // Scanner scan = new Scanner(System.in);

        // 버퍼를 통해 입력 값을 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = 0;

        Edge[] edges = new Edge[m];
        parent = new int[n + 1];

        // 부모노드 초기화 (자기 자신을 가르킴)
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), SPACE);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(x, y, c);
        }

        br.close();

        // 비용 순서대로 엣지 정렬
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost - o2.cost;
            }
        });

        // 크루스칼 알고리즘
        // find-union
        for (int i = 0; i < m; i++) {
            int rootX = findRoot(edges[i].x);
            int rootY = findRoot(edges[i].y);

            if(rootX == rootY){
                continue;
            } else{
                parent[rootX] = rootY;
                result += edges[i].cost;
            }
        }

        System.out.println(result);
    }

    private static int findRoot(int x){
        if(x == parent[x]){
            return x;
        }

        return findRoot(parent[x]);
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
