package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 6..
 *
 * 백준 알고리즘 3034번 풀이 (https://www.acmicpc.net/problem/3034)
 */

public class BOJ_3034 {

    private static final String POSSIBLE = "DA";
    private static final String IMPOSSIBLE = "NE";

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int match = Integer.parseInt(br.readLine());

            if(match <= W || match <= H || Math.pow(match, 2) <= Math.pow(W, 2) + Math.pow(H, 2)){
                sb.append(POSSIBLE).append(NEW_LINE);
            } else{
                sb.append(IMPOSSIBLE).append(NEW_LINE);
            }
        }

        br.close();

        System.out.println(sb.toString());
    }
}
