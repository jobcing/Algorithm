package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by ByeongChan on 2018. 5. 7..
 *
 * 백준 알고리즘 10384번 풀이 (https://www.acmicpc.net/problem/10384)
 */

public class BOJ_10384 {

    private static final String[] RESULTS = { "Not a pangram", "Pangram!", "Double pangram!!", "Triple pangram!!!" };

    private static final String NEW_LINE = "\n";
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            char[] inputSenten = br.readLine().toLowerCase().toCharArray();
            int[] alphaCnt = new int[26];

            for (char c : inputSenten){
                if(c < 'a' || c > 'z'){
                    continue;
                }

                alphaCnt[c - 'a']++;
            }

            // 알파벳 최소 개수 찾기
            Arrays.sort(alphaCnt);

            // 출력 양식 버퍼에 삽입
            sb.append("Case").append(SPACE).append(i).append(":").append(SPACE);
            // 알파벳 최소 개수가 3이 넘어가면 3으로 지정하고 나머지는 인덱스값에 따라 정답 출력
            sb.append(RESULTS[alphaCnt[0] > 3 ? 3 : alphaCnt[0]]).append(NEW_LINE);
        }

        br.close();

        System.out.println(sb.toString());
    }
}
