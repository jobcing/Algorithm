package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 2. 19..
 *
 * 백준 알고리즘 2503번 풀이 (https://www.acmicpc.net/problem/2503)
 *
 * 모든 정점 사이의 최단 경로 구하는 문제
 *
 * !! 두개의 정점사이의 최단 경로를 갖는 다익스트라 알고리즘은 시간 복잡도가 O(n2)인데,
 * !! 모든 정점 사이의 최단 경로를 구하려면 다익스트라 알고리즘을 n번 반복해야되므로 전체 복잡도는 O(n3)가 된다.
 * !! 한번에 모든 정점사이의 최단 경로를 구하는 Floyd 알고리즘은 3중 반복문이 실행되므로 O(n3)
 * !! 따라서, 모든 정점사이의 최단 경로를 구하는 문제는 어차피 시간복잡도가 같으므로 간단한 Floyd를 사용하는 것이 좋다. !!
 */

public class BOJ_2503 {

    private static final int INFINITE = 100_001;

    private static final String NEW_LINE = "\n";
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] costs = new int[n + 1][n + 1];

        // 모든 경로 비용 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 자기 자신 빼고
                if (i != j) {
                    costs[i][j] = INFINITE;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int startCity = Integer.parseInt(st.nextToken());
            int arriveCity = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 같은 입력 값이 있을경우 작은 값을 저장
            costs[startCity][arriveCity] = Math.min(costs[startCity][arriveCity], cost);
        }

        br.close();

        // floyd
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if(costs[j][k] > costs[j][i] + costs[i][k]){
                        costs[j][k] = costs[j][i] + costs[i][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 경로가 없을 경우 0을 출력
                if(costs[i][j] == INFINITE){
                    sb.append(0);
                } else{
                    sb.append(costs[i][j]);
                }

                sb.append(SPACE);
            }

            sb.append(NEW_LINE);
        }

        // 결과값 출력
        System.out.println(sb.toString());
    }
}
