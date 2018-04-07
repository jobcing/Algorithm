package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 4. 7..
 *
 * 백준 알고리즘 1551번 풀이 (https://www.acmicpc.net/problem/1551)
 *
 * K번을 거쳐 배열 B[i] = A[i + 1] - A[1] 를 만드는 문제. 규칙을 파악하여 문제 풀이
 */

public class BOJ_1551 {

    private static final String COMMA = ",";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        st = new StringTokenizer(br.readLine(), COMMA);

        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        for (int i = 1; i <= K; i++) {

            for (int j = 0; j < A.length - i; j++) {
                int a = A[j];
                int b = A[j + 1];

                A[j] = b - a;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < A.length - K; i++) {

            sb.append(A[i]);

            if(i != A.length - K - 1){
                sb.append(COMMA);
            }
        }

        System.out.println(sb.toString());
    }
}
