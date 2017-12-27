package bfs;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by ByeongChan on 2017. 9. 22..
 *
 * 백준 알고리즘 2178번 풀이 (https://www.acmicpc.net/problem/2178)
 *
 * 미로 탐색 (BFS 이용)
 */
public class BOJ_2178 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        int[][] matrix = new int[n][m];
        boolean[][] visit = new boolean[n][m];

        scan.nextLine();

        for (int i = 0; i < n; i++) {
            String str = scan.nextLine();
            String[] ele = str.split("");
            for (int j = 0; j < ele.length; j++) {
                matrix[i][j] = Integer.parseInt(ele[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = false;
            }
        }

        int cnt = 1;

        LinkedList q = new LinkedList<Point>();

        q.add(new Point(0, 0,0));
        visit[0][0] = true;

        while(!q.isEmpty()){
            Point v = (Point) q.poll();

            if(v.getRow() == n - 1 && v.getCol() == m - 1){
                cnt = v.getLen() + 1;
                break;
            }

            if(v.getRow() - 1 > -1 && matrix[v.getRow() - 1][v.getCol()] == 1 &&
                    visit[v.getRow() - 1][v.getCol()] == false){

                visit[v.getRow() - 1][v.getCol()] = true;
                q.add(new Point(v.getRow() - 1, v.getCol(), v.getLen() + 1));
            }

            if(v.getCol() - 1 > -1 && matrix[v.getRow()][v.getCol() - 1] == 1 &&
                    visit[v.getRow()][v.getCol() - 1] == false){

                visit[v.getRow()][v.getCol() - 1] = true;
                q.add(new Point(v.getRow(), v.getCol() - 1, v.getLen() + 1));
            }

            if(v.getCol() + 1 < m && matrix[v.getRow()][v.getCol() + 1] == 1 &&
                    visit[v.getRow()][v.getCol() + 1] == false){

                visit[v.getRow()][v.getCol() + 1] = true;
                q.add(new Point(v.getRow(), v.getCol() + 1, v.getLen() + 1));
            }

            if(v.getRow() + 1 < n && matrix[v.getRow() + 1][v.getCol()] == 1 &&
                    visit[v.getRow() + 1][v.getCol()] == false){

                visit[v.getRow() + 1][v.getCol()] = true;
                q.add(new Point(v.getRow() + 1, v.getCol(), v.getLen() + 1));
            }
        }

        System.out.println(cnt);
    }
}

class Point{
    private int row;
    private int col;
    private int len;

    public Point(int row, int col, int len){
        this.row = row;
        this.col = col;
        this.len = len;
    }

    public int getRow(){
        return this.row;
    }

    public int getCol(){
        return this.col;
    }

    public int getLen(){
        return this.len;
    }
}