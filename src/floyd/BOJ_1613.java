package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 4. 7..
 *
 * 백준 알고리즘 1613번 풀이 (https://www.acmicpc.net/problem/1613)
 *
 * 모든 관계의 사건 전후를 묻는 문제.
 *
 * !! 최단 경로뿐만 아니라 모든 노드의 경로가 있는지에 대해서도 플로이드 와샬 알고리즘을 사용할 수 있다. !!
 *
 * !! 'a의 사건이 b의 사건보다 먼저 일어났는가?' 는 'a-->b의 경로가 존재한다'로 바꿔서 문제를 풀이할 수 있다. !!
 * !! 모든 관계를 파악해야하므로 플로이드 알고리즘을 사용하는 것이 적절하다. !!
 *
 * !! a-->b 의 경로가 존재하면 a의 사건은 b사건보다 먼저 일어난 일이고, b-->a의 경로가 존재하면 그 반대다.
 * !! 둘 다 경로가 없다면 전후 관계를 알 수 없다.
 */

public class BOJ_1613 {

    private static final int INF = 50_001;

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N + 1][N + 1];

        // matrix init
        for (int i = 0; i <= N; i++) {
            Arrays.fill(matrix[i], INF);
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            matrix[a][b] = 1;
        }

        // floyd
        for (int via = 1; via <= N; via++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
                }
            }
        }

        int S = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // a-->b 혹은 b-->a의 경로가 있는지 파악
            if(matrix[b][a] != INF){
                sb.append(1);
            } else if(matrix[a][b] != INF){
                sb.append(-1);
            } else{
                sb.append(0);
            }

            sb.append(NEW_LINE);
        }
        
        br.close();

        System.out.println(sb.toString());
    }
}
