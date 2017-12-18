package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2017. 9. 13..
 *
 * 백준 알고리즘 1307번 풀이 (https://www.acmicpc.net/problem/1037)
 */
public class BOJ_1037 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] numlist = new int[n];

        for (int i = 0; i < numlist.length; i++) {
            numlist[i] = scan.nextInt();
        }

        int minDiv = Integer.MAX_VALUE;
        int maxDiv = Integer.MIN_VALUE;

        for (int i = 0; i < numlist.length; i++) {
            maxDiv = Math.max(maxDiv, numlist[i]);
            minDiv = Math.min(minDiv, numlist[i]);
        }

        System.out.println(minDiv * maxDiv);
    }
}
