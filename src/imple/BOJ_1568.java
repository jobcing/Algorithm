package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 3. 6..
 *
 * 백준 알고리즘 1568번 풀이 (https://www.acmicpc.net/problem/1568)
 */

public class BOJ_1568 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int ans = 0;
        int K = 1;

        while(N != 0){
            if(N - K < 0){
                K = 1;
                continue;
            } else{
                N = N - K;
                K++;
                ans++;
            }
        }

        System.out.println(ans);
    }
}
