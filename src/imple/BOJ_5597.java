package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ByeongChan on 2018. 3. 3..
 *
 * 백준 알고리즘 5597번 풀이 (https://www.acmicpc.net/problem/5597)
 */

public class BOJ_5597 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] students = new boolean[30];

        for (int i = 0; i < 28; i++) {
            int submit = Integer.parseInt(br.readLine());

            students[submit - 1] = true;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < students.length; i++) {
            if(!students[i]){
                sb.append(i + 1).append(NEW_LINE);
            }
        }

        System.out.println(sb.toString());
    }
}
