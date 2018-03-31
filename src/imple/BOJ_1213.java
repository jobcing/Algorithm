package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ByeongChan on 2018. 3. 31..
 *
 * 백준 알고리즘 1213번 풀이 (https://www.acmicpc.net/problem/1213)
 *
 * 팰린드롬 만들기 문제
 *
 * !! 반례 : AAABB -> ABABA 를 생각못했었음
 * !! 알파벳 수를 센다는 것을 생각못함
 *
 * !! 알파벳을 세어서 팰린드롬을 만든다.
 * !! 홀수개가 되는 알파벳은 한개만 있어야한다. 만약 2개 이상이라면 팰린드롬을 만들수 x
 */

public class BOJ_1213 {

    private static final int ALPHA = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        br.close();

        int[] alpha = new int[ALPHA];

        for (int i = 0; i < str.length(); i++) {
            alpha[str.charAt(i) - 'A']++;
        }

        int oddcnt = 0;
        char center = ' ';

        for (int i = 0; i < ALPHA; i++) {
            // 알파벳 수가 홀수 개인 것을 체크
            if (alpha[i] % 2 != 0){
                oddcnt++;
                // 홀수라면 팰린드롬 중앙에 위치하는 알파벳이므로 저장
                center = (char)(i + 'A');
            }
        }

        StringBuilder sb = new StringBuilder();

        // 홀수개인 것이 2개 이상이라면 팰린드롬을 만들 수 없다.
        if (oddcnt > 1) {
            System.out.println("I'm Sorry Hansoo");
        } else {

            for (int i = 0; i < ALPHA; i++) {
                // 알파벳의 절반을 버퍼에 입력 --> 나머지 반은 아래에서 reverse
                for (int j = 0; j < alpha[i] / 2; j++) {
                    sb.append((char) (i + 'A'));
                }
            }

            // 입력받은 버퍼를 reverse
            StringBuilder reverse = new StringBuilder(sb).reverse();

            // 만약 중앙에 위치하는 알파벳이 있다면 추가
            if (oddcnt != 0) {
                sb = sb.append(center);
            }

            // reverse한 문자열을 버퍼에 추가
            sb.append(reverse);

            System.out.println(sb.toString());
        }
    }
}
