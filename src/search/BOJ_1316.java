package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 2. 27..
 * <p>
 * 백준 알고리즘 1316번 풀이 (https://www.acmicpc.net/problem/1316)
 */

public class BOJ_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i = 0; i < N; i++) {
            char[] wordChars = br.readLine().toCharArray();

            boolean flag = false;
            boolean isChecked[] = new boolean[26];
            char prevChar = ' ';

            for (char c : wordChars){
                int alphaIndex = c - 'a';

                if(!isChecked[alphaIndex] || c == prevChar){
                    isChecked[alphaIndex] = true;
                } else{
                    flag = true;
                    break;
                }

                prevChar = c;
            }

            if (!flag) {
                ans++;
            }
        }

        br.close();

        System.out.println(ans);
    }
}
