package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by ByeongChan on 2017. 9. 22..
 *
 * 백준 알고리즘 11403번 풀이 (https://www.acmicpc.net/problem/11403)
 *
 * 경로 찾기 문제
 */
public class BOJ_11403 {
    // 문자 상수
    private static final char SPACE = ' ';
    private static final char NEW_LINE = '\n';

    // 정점 갯수 저장 변수
    private static int N = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int[][] mat = new int[N][N];
        boolean[] isVisited = new boolean[N];

        scan.nextLine();

        for (int i = 0; i < N; i++) {
            String line = scan.nextLine();
            String[] temp = line.split(" ");

            for (int j = 0; j < temp.length; j++) {
                mat[i][j] = Integer.parseInt(temp[j]);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        isVisited[0] = true;
        q.offer(0);

        boolean[][] result = new boolean[N][N];

        while(!q.isEmpty()){
            int u = q.poll();

            for (int i = 0; i < N; i++) {
                if(mat[u][i] == 1 && isVisited[i] == true){
                    q.offer(i);
                    result[u][i] = isVisited[i] = true;
                }
            }
        }


    }
}
