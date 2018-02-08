package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 2. 8..
 *
 * 백준 알고리즘 7576번 풀이 (https://www.acmicpc.net/problem/7576)
 *
 * 주변에 익은 토마토들이 있으면 토마토가 익는다. 모든 토마토가 익는 최소 일수 구하는 문제
 *
 * !! bfs 사용 !!
 * !! 조건문 && 순서도 중요하다 !!
 * !! 익은 토마토가 있으면 나중에 확인하고 넣는 것이 아닌 우선 큐에 넣는 것이 중요 !!
 */

public class BOJ_7576 {

    private static int n;
    private static int m;
    private static int[][] matrix;

    private static int ans = 0;

    private static Queue<Tomato> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == 1){
                    q.offer(new Tomato(i, j, 0));
                }
            }
        }

        bfs();

        // 익지 않은 토마토가 있는지 확인
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

    private static void bfs(){
        while(!q.isEmpty()){
            Tomato tomato = q.poll();

            int col = tomato.col;
            int row = tomato.row;
            int day = tomato.day;

            ans = Math.max(ans, day);

            if(col + 1 < n && matrix[col + 1][row] == 0){
                matrix[col + 1][row] = 1;
                q.offer(new Tomato(col + 1, row, day + 1));
            }

            if(col - 1 > -1 && matrix[col - 1][row] == 0){
                matrix[col - 1][row] = 1;
                q.offer(new Tomato(col - 1, row, day + 1));
            }

            if(row + 1 < m && matrix[col][row + 1] == 0){
                matrix[col][row + 1] = 1;
                q.offer(new Tomato(col, row + 1, day + 1));
            }

            if(row - 1 > -1 && matrix[col][row - 1] == 0){
                matrix[col][row - 1] = 1;
                q.offer(new Tomato(col, row - 1, day + 1));
            }
        }
    }
    static class Tomato {
        int col;
        int row;
        int day;

        public Tomato(int col, int row, int day) {
            this.col = col;
            this.row = row;
            this.day = day;
        }
    }
}
