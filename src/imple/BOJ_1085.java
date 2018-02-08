package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 2. 8..
 *
 * 백준 알고리즘 1085번 풀이 (https://www.acmicpc.net/problem/1085)
 */

public class BOJ_1085 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        br.close();

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        x = Math.min(x, w - x);
        y = Math.min(y, h - y);

        System.out.println(Math.min(x, y));
    }
}
