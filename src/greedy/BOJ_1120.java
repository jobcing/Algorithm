package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 1. 20..
 *
 * 백준 알고리즘 1120번 풀이 (https://www.acmicpc.net/problem/1120)
 *
 * 한 문자열에 문자를 추가하여 두 문자열이 최소로 차이나는 개수를 구하기
 *
 * !! 문자열을 추가하는 것은 말장난일 뿐이고 두 문자열을 자리를 이동하며 !!
 * !! 최소로 차이나는 개수를 구하면 된다 !!
 */
public class BOJ_1120 {

    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);

        br.close();

        char[] aChars = st.nextToken().toCharArray();
        char[] bChars = st.nextToken().toCharArray();

        int difflen = bChars.length - aChars.length;

        // 결과값(문자열의 최소 차이)을 저장할 변수
        // 최대로 차이날 개수는 B문자열의 길이
        int minResult = bChars.length;

        for (int i = 0; i <= difflen; i++) {
            int diffCnt = 0;

            for (int j = 0; j < aChars.length; j++) {
                if(aChars[j] != bChars[i + j]){
                    diffCnt++;
                }
            }

            minResult = Math.min(minResult, diffCnt);
        }

        System.out.println(minResult);
    }
}
