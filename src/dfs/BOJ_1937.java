package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 10..
 *
 * 백준 알고리즘 1037번 풀이 (https://www.acmicpc.net/problem/1937)
 *
 * !! DP + DFS !!
 * !! 2차원 배열을 탐색하며 수가 더 큰 쪽으로 이동하는데 최대 값을 묻는 문제 !!
 * !! y는 세로축 !!
 */

public class BOJ_1937 {

    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][N];
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, dfs(matrix, dp, i, j));
            }
        }

        System.out.println(max);
    }

    private static int dfs(int[][] matrix, int[][] dp, int x, int y){
        int N = matrix.length;

        if(dp[y][x] == 0){
            dp[y][x] = 1;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if(0 <= nx && nx < N && 0 <= ny && ny < N){
                    if(matrix[y][x] > matrix[ny][nx]){
                        dp[y][x] = Math.max(dp[y][x], dfs(matrix, dp, nx, ny) + 1);
                    }
                }
            }
        }

        return dp[y][x];
    }
}
