package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 22..
 *
 * 백준 알고리즘 1987번 풀이 (https://www.acmicpc.net/problem/1987)
 *
 * !! 모든 경로 dfs 탐색해서 제일 깊은 dfs 찾아내는 문제 !!
 * !! dfs + 백트래킹 !!
 */

public class BOJ_1987 {

    private static boolean[] isVisited = new boolean[26];
    private static char[][] matrix = null;

    private static int R;
    private static int C;

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    private static int maxStep = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        matrix = new char[R][C];

        for (int i = 0; i < R; i++) {

            String line = br.readLine();

            for (int j = 0; j < C; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0, 1);

        System.out.println(maxStep);
    }

    private static void dfs(int x, int y, int step){
        char c = matrix[x][y];
        isVisited[c - 'A'] = true;

        maxStep = Math.max(maxStep, step);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < R && ny < C){

                if(!isVisited[matrix[nx][ny] - 'A']){
                    dfs(nx, ny, step + 1);
                }
            }
        }

        isVisited[c - 'A'] = false;
    }
}
