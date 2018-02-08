package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 2. 8..
 *
 * 백준 알고리즘 1094번 풀이 (https://www.acmicpc.net/problem/1094)
 */

public class BOJ_1094 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] squareTwo = {1, 2, 4, 8, 16, 32, 64};

        int x = scan.nextInt();
        int ans = 0;

        for (int i = (squareTwo.length - 1); i >= 0; i--) {
            if(x >= squareTwo[i]){
                ans++;
                x -= squareTwo[i];
            }

            if(x == 0){
                break;
            }
        }

        System.out.println(ans);
    }
}
