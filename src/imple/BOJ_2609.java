package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 3. 20..
 *
 * 백준 알고리즘 2609번 풀이 (https://www.acmicpc.net/problem/2609)
 *
 * 최대 공약수와 최대 공배수를 구하는 문제
 */

public class BOJ_2609{

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();

        int mulValue = a * b;

        while(true){
            if(b == 0){
                break;
            }

            int tmp = b;
            b = a % b;
            a = tmp;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(a).append(NEW_LINE);
        sb.append(mulValue / a);

        System.out.println(sb.toString());
    }
}
