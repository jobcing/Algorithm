package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 2. 14..
 *
 * 백준 알고리즘 1476번 풀이 (https://www.acmicpc.net/problem/1476)
 */

public class BOJ_1476 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int e = scan.nextInt();
        int s = scan.nextInt();
        int m = scan.nextInt();

        // 역으로 1 1 1이 될때까지 계산
        int years = 1;

        while(true){
            if(e == 1 && s == 1 && m == 1){
                break;
            }

            e--;
            s--;
            m--;
            years++;

            if(e < 1){
                e = 15;
            }
            if(s < 1){
                s = 28;
            }
            if(m < 1){
                m = 19;
            }
        }

        System.out.println(years);
    }
}
