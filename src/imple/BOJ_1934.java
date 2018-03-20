package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 20..
 *
 * 백준 알고리즘 1934번 풀이 (https://www.acmicpc.net/problem/1934)
 *
 * 최소 공배수 구하는 문제
 *
 * !! 유클리드 호제법 사용 !!
 */

public class BOJ_1934 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int mulValue = a * b;

            while(true){
                if(b == 0){
                    sb.append(mulValue / a).append(NEW_LINE);
                    break;
                }

                int tmp = b;
                b = a % b;
                a = tmp;
            }
        }

        br.close();

        System.out.println(sb.toString());
    }
}
