package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 2. 12..
 *
 * 백준 알고리즘 7576번 두번째 풀이 (https://www.acmicpc.net/problem/7576)
 *
 * !! bfs 사용 !!
 * !! 상하좌우 탐색을 보다 간편하게 !!
 */

public class BOJ_7576_1 {

    private static int ans = 0;

    // 상하좌우 탐색에 쓰일 리스트
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[n][m];

        Queue<Tomato> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());

                // 익은 토마토라면 Queue에 담는다.
                if(matrix[i][j] == 1){
                    q.offer(new Tomato(i, j, 0));
                }
            }
        }

        br.close();

        // bfs
        while(!q.isEmpty()){
            Tomato tomato = q.poll();

            int col = tomato.x;
            int row = tomato.y;
            int day = tomato.day;

            // 가장 오래 걸린 토마토의 일 수를 저장하고 있어야 한다.
            ans = Math.max(ans, day);

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = col + dx[i];
                int ny = row + dy[i];

                // 범위 확인
                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    // 익지 않은 토마토라면
                    if(matrix[nx][ny] == 0){
                        // 익은 토마토로 바꾸고 Queue에 담는다.
                        matrix[nx][ny] = 1;
                        q.offer(new Tomato(nx, ny, day + 1));
                    }
                }
            }
        }

        // bfs가 끝나고 배열안에 익지 않은 토마토가 있다면 -1 출력.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == 0){
                    ans = -1;
                    break;
                }
            }
        }

        System.out.println(ans);
    }

    static class Tomato{
        int x;
        int y;
        int day;

        public Tomato(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}
