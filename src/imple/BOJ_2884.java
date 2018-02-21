package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 2. 21..
 *
 * 백준 알고리즘 2884번 풀이 (https://www.acmicpc.net/problem/2884)
 */

public class BOJ_2884 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int H = scan.nextInt();
        int M = scan.nextInt();

        M -= 45;

        if(M < 0){
            H -= 1;

            if(H < 0){
                H += 24;
            }

            M += 60;
        }

        System.out.println(H + " " + M);
    }
}
