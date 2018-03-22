package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 22..
 *
 * 백준 알고리즘 1389번 풀이 (https://www.acmicpc.net/problem/1389)
 *
 * 케빈 베이컨의 6단계 문제. 친구들을 연결하는 최소 관계 수를 구하는 문제.
 *
 * !! 친구들의 관계과 최소 몇단계로 이루어져있는지 파악해야하므로 플로이드 알고리즘 사용
 * !! 각 친구들의 관계를 모두 파악 후 비교해야하므로, 또한 N의 수가 100이하 조건 --> 플로이드 n^3 사용
 */

public class BOJ_1389 {

    private static final int INF = 100_100;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] relations = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(relations[i], INF);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relations[a][b] = relations[b][a] = 1;
        }

        br.close();

        for (int via = 1; via <= N; via++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    relations[i][j] = Math.min(relations[i][j], relations[i][via] + relations[via][j]);
                }
            }
        }

        // 케빈 베이컨의 수가 가장 작은 사람을 찾음
        int minSum = INF;
        int res = 1;

        for (int i = 1; i <= N; i++) {
            int sum = 0;

            for (int j = 1; j <= N; j++) {
                sum += relations[i][j];
            }

            if (minSum > sum) {
                minSum = sum;
                res = i;
            }
        }

        // 결과 값 출력
        System.out.println(res);
    }
}
