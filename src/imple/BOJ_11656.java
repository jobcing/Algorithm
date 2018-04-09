package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by ByeongChan on 2018. 4. 9..
 *
 * 백준 알고리즘 11656번 풀이 (https://www.acmicpc.net/problem/11656)
 */

public class BOJ_11656 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] slist = new String[s.length()];

        for (int i = 0; i < slist.length; i++) {
            slist[i] = s.substring(i, s.length());
        }

        Arrays.sort(slist);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < slist.length; i++) {
            sb.append(slist[i]).append(NEW_LINE);
        }

        System.out.println(sb.toString());
    }
}
