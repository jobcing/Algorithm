package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 26..
 *
 * 백준 알고리즘 1238번 풀이 (https://www.acmicpc.net/problem/1238)
 *
 * !! INF 값 수정, Arrays.fill 사용 x, max값 구하는 방법 변경하니 정답
 * !! INF = Integer.MAX_VALUE 주의할 것. Arrays.fill보다 i != j 예외처리로 가중치 배열 init할 것
 */

public class BOJ_1238 {

    private static final int INF = 100_001;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    matrix[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            matrix[u][v] = w;
        }

        br.close();

        for (int via = 1; via <= N; via++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
                }
            }
        }

        // 결과 값 저장 변수 초기화
        int max = 0;

        // X번 마을 까지 가는 거리와 오는 거리가 최대인 값을 구함
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, matrix[i][X] + matrix[X][i]);
        }

        // 결과 값 출력
        System.out.println(max);
    }
}
