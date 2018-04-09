package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 4. 9..
 *
 * 백준 알고리즘 3047번 풀이 (https://www.acmicpc.net/problem/3047)
 */

public class BOJ_3047 {

    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);

        int[] list = new int[3];

        for (int i = 0; i < list.length; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(list[s.charAt(i) - 'A']).append(SPACE);
        }

        System.out.println(sb.toString());
    }
}
