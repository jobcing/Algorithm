package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 2. 14..
 *
 * 백준 알고리즘 2914번 풀이 (https://www.acmicpc.net/problem/2914)
 */

public class BOJ_2914 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int i = scan.nextInt();

        int ans = a * (i - 1) + 1;

        System.out.println(ans);
    }
}
