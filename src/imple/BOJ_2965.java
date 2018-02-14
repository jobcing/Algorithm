package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 2. 14..
 *
 * 백준 알고리즘 2965번 풀이 (https://www.acmicpc.net/problem/2965)
 */

public class BOJ_2965 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        int n3 = scan.nextInt();

        int ans = Math.max(n2 - n1, n3 - n2) - 1;

        System.out.println(ans);
    }
}
