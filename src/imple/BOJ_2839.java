package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 2. 7..
 *
 * 백준 알고리즘 2839번 풀이 (https://www.acmicpc.net/problem/2839)
 *
 * 5와 3으로 수를 구성할 수 있는 최소 개수 구하기
 * !! 먼저 5로 나눠지는지 확인하고 안나눠지면 3을 빼보면서 구한다. !!
 */

public class BOJ_2839 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int ans = 0;

        while(n > 0){
            if(n % 5 == 0){
                ans += (n / 5);
                n = n % 5;
            } else{
                ans += 1;
                n -= 3;
            }
        }

        if(n < 0){
            System.out.println(-1);
        } else{
            System.out.println(ans);
        }
    }
}
