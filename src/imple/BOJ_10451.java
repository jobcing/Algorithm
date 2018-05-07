package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 5. 7..
 *
 * 백준 알고리즘 10451번 풀이 (https://www.acmicpc.net/problem/10451)
 */

public class BOJ_10451 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());

            int[] permutation = new int[N + 1];
            boolean[] isVisited = new boolean[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int i = 1; i <= N; i++) {
                permutation[i] = Integer.parseInt(st.nextToken());
            }

            int cycleCnt = 0;

            for (int i = 1; i <= N; i++) {
                if(isVisited[i]){
                    continue;
                }

                // 순열 사이클 추적
                int loop = i;

                while(!isVisited[loop]){
                    isVisited[loop] = true;
                    loop = permutation[loop];
                }

                // 한 사이클이 끝나면 개수 추가
                cycleCnt++;
            }
            sb.append(cycleCnt).append(NEW_LINE);
        }
        br.close();

        System.out.println(sb.toString());
    }
}
