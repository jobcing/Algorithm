package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 2. 12..
 *
 * 백준 알고리즘 2010번 풀이 (https://www.acmicpc.net/problem/2010)
 *
 * 연결될 수 있는 플러그 개수가 주어지고 최대로 연결할 수 있는 컴퓨터의 갯수를 구하는 문제
 */

public class BOJ_2010 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int ans = 0;

        // 문제의 규칙을 보면 마지막 수를 빼고 모두 -1을 하고 더해야 함을 알 수 있다.
        for (int i = 0; i < n - 1; i++) {
            int connection = scan.nextInt();

            ans += (connection - 1);
        }

        // 마지막 수만 그대로 더해준다.
        ans += scan.nextInt();

        System.out.println(ans);
    }
}
