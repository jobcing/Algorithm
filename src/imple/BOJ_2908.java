package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 12..
 *
 * 백준 알고리즘 2908번 풀이 (https://www.acmicpc.net/problem/2908)
 *
 * 숫자 뒤집어서 비교하는 문제
 *
 * !! StringBuffer.reverse() 메소드 사용 !!
 */

public class BOJ_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String a = reverseString(st.nextToken());
        String b = reverseString(st.nextToken());

        int aInt = Integer.valueOf(a);
        int bInt = Integer.valueOf(b);

        int ans = aInt > bInt ? aInt : bInt;

        System.out.println(ans);
    }

    private static String reverseString(String s){
        return (new StringBuffer(s)).reverse().toString();
    }
}
