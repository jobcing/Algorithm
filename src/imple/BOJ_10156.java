package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 4. 22..
 *
 * 백준 알고리즘 10156번 풀이 (https://www.acmicpc.net/problem/10156)
 */

public class BOJ_10156 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int snackPrice = K * N;
        int ans = snackPrice - M >= 0 ? snackPrice - M : 0;

        System.out.println(ans);
    }
}
