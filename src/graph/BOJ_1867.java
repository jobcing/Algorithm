package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 8..
 *
 * 백준 알고리즘 1867번 풀이 (https://www.acmicpc.net/problem/1867)
 *
 *
 * !! Minimum Vertex Cover : 정점 집합 S가 있을 때, 모든 간선은 양 끝점 중 적어도 하나가 S에 포함되어야 한다. !!
 * !! 이분 그래프에서 최대 매칭 = 최소 버텍스 커버 !!
 *
 * !! 최소 버텍스 커버 문제임을 알아채는 방법
 * 1. 이분 그래프 문제인지 확인해본다.
 * 2. 그래프로 만약 형성된다면 그 그래프에 존재하는 모든 간선이 이용되는지 확인한다.
 * 3. 그 모든 간선이 정점에 적어도 하나가 연결되야 하는지 확인해본다.(정의를 잘 생각하고 이용하면 좋다.)
 */

public class BOJ_1867 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] v = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            v[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            v[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        boolean[] isVisited = new boolean[n + 1];
        int[] b = new int[n + 1];

        int result = 0;

        for (int i = 1; i <= n; i++) {
            Arrays.fill(isVisited, false);

            if(dfs(v, isVisited, i, b)) result++;
        }

        System.out.println(result);
    }

    private static boolean dfs(ArrayList<Integer>[] v, boolean[] isVisited, int here, int[] b){
        if(isVisited[here]) return false; // 이미 방문된 정점은 매칭 불가

        isVisited[here] = true;

        for (int there : v[here]){
            // 매칭이 되어있지 않은 정점을 만나거나 이미 매칭된 정점이 다른 정점과 매칭이 가능할 경우
            if(b[there] == 0 || dfs(v, isVisited, b[there], b)){
                // 매칭을 시킴
                b[there] = here;
                return true;
            }
        }

        return false;
    }
}
