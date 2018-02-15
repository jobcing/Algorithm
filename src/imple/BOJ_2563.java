package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 2. 15..
 *
 * 백준 알고리즘 2563번 풀이 (https://www.acmicpc.net/problem/2563)
 */

public class BOJ_2563 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[][] paper = new int[100][100];

        for (int i = 0; i < n; i++) {
            int startX = scan.nextInt();
            int startY = scan.nextInt();

            int endX = startX + 10;
            int endY = startY + 10;

            for (int j = startX; j < endX; j++) {
                for (int k = startY; k < endY; k++) {
                    paper[j][k] = 1;
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(paper[i][j] == 1){
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
