package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 2. 13..
 *
 * 백준 알고리즘 4963번 풀이 (https://www.acmicpc.net/problem/4963)
 *
 * 연결되어 있는 섬의 개수 구하는 문제. 대각선도 연결된 것으로 본다.
 *
 * !! 그래프가 연결되어 있는지를 물어보는 문제. dfs 이용하여 연결 여부 확인 !!
 */

public class BOJ_4963 {

    // final static String NEW LINE
    private static final String NEW_LINE = "\n";

    // 상하좌우 대각선을 탐색하기 위한 배열 상수
    private static final int[][] direct = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 },
            { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

    private static int[][] map = null;

    private static int w = 0;
    private static int h = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cnt = 0;

        // infinite loop
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0){
                br.close();

                break;
            }

            cnt = 0;
            map = new int[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(map[i][j] == 1){
                        cnt++;

                        dfs(i, j);
                    }
                }
            }

            sb.append(cnt).append(NEW_LINE);
        }

        System.out.println(sb.toString());
    }

    // dfs
    private static void dfs(int i, int j){
        // 방문하면 0으로 바꿈
        map[i][j] = 0;

        // 상하좌우 대각선 탐색
        for (int[] direction : direct) {
            int nx = i + direction[0];
            int ny = j + direction[1];

            // 범위 안에 들어오고 1이라면 dfs
            if(0 <= nx && 0 <= ny && nx < h && ny < w && map[nx][ny] == 1){
                dfs(nx, ny);
            }
        }
    }
}
