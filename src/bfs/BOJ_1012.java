package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 4. 7..
 *
 * 백준 알고리즘 1012번 풀이 (https://www.acmicpc.net/problem/1012)
 *
 * bfs 몇 번 진입하는지 묻는 문제. int[][] 2차원 배열쓰면 시간초과 --> ArrayList로 변경
 */

public class BOJ_1012 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            Integer.parseInt(st.nextToken());
            Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            ArrayList<Point> pointList = new ArrayList<>();
            //matrix = new int[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                // matrix[y][x] = 1;
                pointList.add(new Point(x, y));
            }

            int cnt = bfs(pointList);

            sb.append(cnt).append(NEW_LINE);
        }

        br.close();

        System.out.println(sb.toString());
    }

    private static int bfs(ArrayList<Point> pointList) {
        Queue<Point> q = new LinkedList<>();

        int count = 0;

        while (!pointList.isEmpty()) {

            q.add(pointList.get(0));
            pointList.get(0).isVisited = true;

            while (!q.isEmpty()) {
                Point p = q.poll();
                pointList.remove(p);

                for (Point u : pointList) {
                    // 인접한 좌표인지 확인하기 위해 아래와 같은 식이 필요
                    if (!u.isVisited && (Math.abs(p.x - u.x) + Math.abs(p.y - u.y) == 1)) {
                        q.add(u);
                        u.isVisited = true;
                    }
                }
            }

            // 인접한 좌표 모두 탐색을 끝냈을 때 카운트
            count++;
        }

        return count;
    }

    private static class Point{
        int x;
        int y;
        boolean isVisited;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
            this.isVisited = false;
        }
    }
}
