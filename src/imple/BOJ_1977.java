package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 2. 6..
 *
 * 백준 알고리즘 1977번 풀이 (https://www.acmicpc.net/problem/1977)
 */

public class BOJ_1977 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = n; i <= m; i++) {
            if(Math.sqrt(i) % 1.0f == 0.0f){
                sum += i;
                min = Math.min(min, i);
            }
        }

        if(sum == 0){
            System.out.println(-1);
        } else{
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
