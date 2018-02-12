package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ByeongChan on 2018. 2. 12..
 *
 * 백준 알고리즘 2667번 풀이 (https://www.acmicpc.net/problem/2667)
 *
 * 1로 연결된 집단의 개수와 1의 개수 정렬해서 출력하는 문제
 *
 * !! bfs 사용 !!
 */

public class BOJ_2667 {

    // 상수 개행문자
    private static final String NEW_LINE = "\n";

    // 상하좌우 탐색
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private static int N = 0;
    private static int[][] map = null;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        // 결과를 저장할 리스트
        ArrayList<Integer> resultCnt = new ArrayList<>();

        // 버퍼를 통해 입력받음
        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        br.close();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 만약 1이라면
                if(map[i][j] == 1){
                    // 0으로 바꿔준다.
                    map[i][j] = 0;

                    // 0으로 바꾸고 bfs 탐색
                    int cnt = bfs(i, j);
                    // 1로 연결된 개수
                    resultCnt.add(cnt);
                }
            }
        }

        // 정렬
        Collections.sort(resultCnt);

        StringBuilder sb = new StringBuilder();

        sb.append(resultCnt.size() + NEW_LINE);
        for (int i = 0; i < resultCnt.size(); i++) {
            sb.append(resultCnt.get(i));
            sb.append(NEW_LINE);
        }

        System.out.println(sb.toString());
    }

    // bfs
    private static int bfs(int x, int y){
        Queue q = new LinkedList();
        q.offer(new Point(x, y));

        int ans = 0;

        while(!q.isEmpty()){
            Point p = (Point) q.poll();
            // 탐색 횟수 저장
            ans++;

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < N){
                    if(map[nx][ny] == 1){
                        map[nx][ny] = 0;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }

        return ans;
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
