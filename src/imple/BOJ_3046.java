package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 2. 8..
 *
 * 백준 알고리즘 3046번 풀이 (https://www.acmicpc.net/problem/3046)
 */

public class BOJ_3046 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int avg = scan.nextInt();

        int ans = (avg * 2) - n;

        System.out.println(ans);
    }
}
