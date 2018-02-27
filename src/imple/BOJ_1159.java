package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ByeongChan on 2018. 2. 27..
 *
 * 백준 알고리즘 1159번 풀이 (https://www.acmicpc.net/problem/1159)
 *
 * 알파벳 개수 세어서 5개 이상인 알파벳만 출력하는 문제
 */

public class BOJ_1159 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] alphaCnt = new int[26];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            char fn = s.charAt(0);

            alphaCnt[fn - 'a']++;
        }

        br.close();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < alphaCnt.length; i++) {
            if(alphaCnt[i] >= 5){
                sb.append((char)(i + 'a'));
            }
        }

        if(sb.length() == 0){
            System.out.println("PREDAJA");
        } else{
            System.out.println(sb.toString());
        }
    }
}
