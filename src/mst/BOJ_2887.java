package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by ByeongChan on 2018. 3. 22..
 *
 * 백준 알고리즘 2887번 풀이 (https://www.acmicpc.net/problem/2887)
 *
 * 행성 간 간선은 min(x1-x2, y1-y2, z1-z2)일 때 최소 스패닝 트리를 구하는 문제.
 * 모든 간선을 구할 경우 N^2이기 때문에 시간초과. 그러므로 x축 기준 정렬, y축 기준 정렬, z축 기준 정렬을 통해 3*(n-1)개의 간선만 등록
 *
 * !! 그럼에도 불구하고 시간초과. 기존의 find-union 메소드 개선하여 시간초과 해결 !!
 */

public class BOJ_2887 {

    private static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        Coord[] planet = new Coord[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            planet[i] = new Coord(x, y, z, i);
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>();

        Arrays.sort(planet, new Comparator<Coord>() {
            @Override
            public int compare(Coord o1, Coord o2) {
                return o1.x - o2.x;
            }
        });

        for (int i = 1; i < N; i++) {
            edges.add(new Edge(planet[i - 1].idx, planet[i].idx, Math.abs(planet[i].x - planet[i - 1].x)));
        }

        Arrays.sort(planet, new Comparator<Coord>() {
            @Override
            public int compare(Coord o1, Coord o2) {
                return o1.y - o2.y;
            }
        });

        for (int i = 1; i < N; i++) {
            edges.add(new Edge(planet[i - 1].idx, planet[i].idx, Math.abs(planet[i].y - planet[i - 1].y)));
        }

        Arrays.sort(planet, new Comparator<Coord>() {
            @Override
            public int compare(Coord o1, Coord o2) {
                return o1.z - o2.z;
            }
        });

        for (int i = 1; i < N; i++) {
            edges.add(new Edge(planet[i - 1].idx, planet[i].idx, Math.abs(planet[i].z - planet[i - 1].z)));
        }

        /*
        parent = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        int result = 0;
        int nEdge = 0;

        while(nEdge < N && !edges.isEmpty()){
            Edge edge = edges.poll();

            int rootX = findRoot(edge.u);
            int rootY = findRoot(edge.v);

            if(rootX == rootY){
                continue;
            } else{
                parent[rootY] = rootX;
                result += edge.cost;
                nEdge++;
            }
        }

        System.out.println(result);
        */

        UnionFind unionFind = new UnionFind(N);
        int nEdge = 0;
        int cost = 0;

        while (nEdge < N && !edges.isEmpty()) {

            Edge edge = edges.poll();

            if (unionFind.find(edge.u) != unionFind.find(edge.v)) {

                unionFind.union(edge.u, edge.v);
                nEdge++;
                cost += edge.cost;
            }
        }

        System.out.println(cost);

    }

    /*
    private static int findRoot(int i){
        if(i == parent[i]){
            return i;
        }

        return findRoot(parent[i]);
    }
    */

    private static class Coord{
        int x, y, z;

        int idx;

        public Coord(int x, int y, int z, int idx){
            this.x = x;
            this.y = y;
            this.z = z;

            this.idx = idx;
        }
    }

    private static class Edge implements Comparable<Edge>{
        int u;
        int v;
        int cost;

        public Edge(int u, int v, int cost){
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }

    private static class UnionFind {

        private int[] root;

        UnionFind(int V) {

            root = new int[V + 1];

            initialize();
        }

        int find(int a) {

            if (root[a] < 0) {

                return a;
            }

            return root[a] = find(root[a]);
        }

        void union(int a, int b) {

            int root1 = find(a);
            int root2 = find(b);

            if (root1 == root2) {

                return;
            }

            if (root[root1] > root[root2]) {

                root1 ^= root2;
                root2 ^= root1;
                root1 ^= root2;
            }

            root[root1] += root[root2];
            root[root2] = root1;
        }

        private void initialize() {

            for (int i = 0; i < root.length; i++) {

                root[i] = -1;
            }
        }
    }
}
