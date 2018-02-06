package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 2. 6..
 *
 * 백준 알고리즘 1080번 풀이 (https://www.acmicpc.net/problem/1080)
 *
 * A행렬을 B행렬로 만드는 최소 연산 횟수를 구하는 문제
 */

public class BOJ_1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] matrix1 = new int[51][51];
        int[][] matrix2 = new int[51][51];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < m; j++) {
                matrix1[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < m; j++) {
                matrix2[i][j] = line.charAt(j) - '0';
            }
        }

        br.close();

        int ans = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if(matrix1[i][j] != matrix2[i][j]) {

                    ans++;

                    for (int k = i; k < i + 3; k++) {
                        for (int l = j; l < j + 3; l++) {
                            matrix1[k][l] = (matrix1[k][l] == 1) ? 0 : 1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix1[i][j] != matrix2[i][j]){
                    ans = -1;
                }
            }
        }

        System.out.println(ans);
    }
}
