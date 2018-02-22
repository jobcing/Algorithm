package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 2. 22..
 *
 * 백준 알고리즘 5063번 풀이(https://www.acmicpc.net/problem/5063)
 */

public class BOJ_5063 {

    // 결과값 STRING
    private static final String AD = "advertise";
    private static final String N_AD = "do not advertise";
    private static final String E = "does not matter";

    // new line 상수 문자열
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int r = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(r > (e - c)){
                sb.append(N_AD).append(NEW_LINE);
            } else if(r < (e - c)){
                sb.append(AD).append(NEW_LINE);
            } else{
                sb.append(E).append(NEW_LINE);
            }
        }

        System.out.println(sb.toString());
    }
}
