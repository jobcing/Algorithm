package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 20..
 *
 * 백준 알고리즘 10159번 풀이 (https://www.acmicpc.net/problem/10159)
 *
 * !! a < b 인가? 에 대한 질문은 a -> b의 경로가 있는가? 로 변환된다.
 * !! 모든 정점의 경로를 구하는 것과 같은 문제로 해석될 수 있으므로 플로이드 사용
 *
 * !! 플로이드는 최단 경로에만 사용되는 것이 아니라 모든 정점의 관계를 파악할 때도 사용될 수 있다.
 * !! 또한, 이 문제는 N의 범위가 100이하기 때문에 플로이드 n^3 복잡도의 알고리즘을 사용할 수 있다.
 */

public class BOJ_10159 {

    private static final int INF = 100_000;
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] matrix = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i != j) matrix[i][j] = INF;
            }
        }

        StringTokenizer st = null;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            matrix[a][b] = 1;
        }

        br.close();

        // floyd
        for (int via = 1; via <= N; via++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {

            int cnt = 0;

            for (int j = 1; j <= N; j++) {
                if(matrix[i][j] == INF && matrix[j][i] == INF) cnt++;
            }

            sb.append(cnt).append(NEW_LINE);
        }

        System.out.println(sb.toString());
    }
}
