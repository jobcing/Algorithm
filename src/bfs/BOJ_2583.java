package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by ByeongChan on 2018. 3. 5..
 *
 * 백준 알고리즘 2583번 풀이 (https://www.acmicpc.net/problem/2583)
 *
 * !! 2차원 배열로 x, y좌표를 표현할 땐 반대로 [y, x]로 표현된다 !!
 */

public class BOJ_2583 {

    private static boolean[][] matrix = null;

    private static int M;
    private static int N;

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private static ArrayList<Integer> arealist = null;

    private static final String NEW_LINE = "\n";
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        matrix = new boolean[M][N];
        arealist = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    matrix[j][k] = true;
                }
            }
        }

        br.close();

        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if(!matrix[y][x]) {
                    bfs(new Point(x, y));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        Collections.sort(arealist);

        sb.append(arealist.size()).append(NEW_LINE);
        for (int i = 0; i < arealist.size(); i++) {
            sb.append(arealist.get(i)).append(SPACE);
        }

        System.out.println(sb.toString());
    }

    private static void bfs(Point p){
        Queue<Point> q = new LinkedList<>();

        q.offer(p);
        int areaSize = 1;

        while(!q.isEmpty()){
            Point point = q.poll();
            matrix[point.y][point.x] = true;

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if(!matrix[ny][nx]) {
                        matrix[ny][nx] = true;
                        q.offer(new Point(nx, ny));
                        areaSize++;
                    }
                }
            }
        }

        arealist.add(areaSize);
    }

    private static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
