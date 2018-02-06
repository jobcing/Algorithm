package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 2. 6..
 *
 * 백준 알고리즘 10886번 풀이 (https://www.acmicpc.net/problem/10886)
 */

public class BOJ_10886 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int vote = scan.nextInt();

            ans = (vote == 1) ? ans + 1 : ans - 1;
        }

        if(ans > 0){
            System.out.println("Junhee is cute!");
        } else{
            System.out.println("Junhee is not cute!");
        }
    }
}
