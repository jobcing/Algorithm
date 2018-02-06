package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ByeongChan on 2018. 2. 6..
 *
 * 백준 알고리즘 10798번 풀이 (https://www.acmicpc.net/problem/10798)
 *
 * replace.All(regex, replacement)
 * 초기화를 먼저해야된다는 생각을 X
 */
public class BOJ_10798 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] chars = new char[5][15];

        for (int i = 0; i < chars.length; i++) {
            char[] charTemp = br.readLine().toCharArray();

            for (int j = 0; j < charTemp.length; j++) {
                chars[i][j] = charTemp[j];
            }

            for (int j = charTemp.length; j < 15; j++) {
                chars[i][j] = ' ';
            }
        }

        br.close();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                sb.append(chars[j][i]);
            }
        }

        System.out.println(sb.toString().replaceAll(" ", ""));
    }
}
