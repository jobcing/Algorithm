package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 2. 14..
 *
 * 백준 알고리즘 12790번 풀이 (https://www.acmicpc.net/problem/12790)
 */

public class BOJ_12790 {

    private static final String NEW_LINE = "\n";

    private static BufferedReader br = null;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            solve();
        }

        br.close();

        System.out.println(sb.toString());
    }

    private static void solve() throws IOException{
        int[] statis = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < statis.length; i++) {
            statis[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < statis.length; i++) {
            statis[i] += Integer.parseInt(st.nextToken());
        }

        if(statis[0] < 1){
            statis[0] = 1;
        }

        if(statis[1] < 1){
            statis[1] = 1;
        }

        if(statis[2] < 0){
            statis[2] = 0;
        }

        int power = statis[0] + 5 * statis[1] + 2 * (statis[2] + statis[3]);
        sb.append(power).append(NEW_LINE);
    }
}
