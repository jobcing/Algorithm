package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 5. 7..
 *
 * 백준 알고리즘 10409번 풀이 (https://www.acmicpc.net/problem/10409)
 */

public class BOJ_10409 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int sum = 0;
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());

            if(sum > T){ break; }

            cnt++;
        }

        System.out.println(cnt);
    }
}
