package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ByeongChan on 2018. 4. 9..
 *
 * 백준 알고리즘 10987번 풀이 (https://www.acmicpc.net/problem/10987)
 */

public class BOJ_10987 {

    private static final char[] moum = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < moum.length; j++) {
                if(s.charAt(i) == moum[j]) cnt++;
            }
        }

        System.out.println(cnt);
    }
}
