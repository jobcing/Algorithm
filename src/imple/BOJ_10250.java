package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 5. 6..
 *
 * 백준 알고리즘 10250번 풀이 (https://www.acmicpc.net/problem/10250)
 */

public class BOJ_10250 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int H = Integer.parseInt(st.nextToken());
            st.nextToken();
            int N = Integer.parseInt(st.nextToken());

            sb.append(String.format("%d%02d", (N - 1) % H + 1, (N - 1) / H + 1)).append(NEW_LINE);
        }

        br.close();

        System.out.println(sb.toString());
    }
}
